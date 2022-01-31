package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;

public class FlutterActivity
  extends Activity
  implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host
{
  protected static final String DART_ENTRYPOINT_META_DATA_KEY = "io.flutter.Entrypoint";
  protected static final String DEFAULT_BACKGROUND_MODE = FlutterActivity.BackgroundMode.opaque.name();
  protected static final String DEFAULT_DART_ENTRYPOINT = "main";
  protected static final String DEFAULT_INITIAL_ROUTE = "/";
  protected static final String EXTRA_BACKGROUND_MODE = "background_mode";
  protected static final String EXTRA_CACHED_ENGINE_ID = "cached_engine_id";
  protected static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
  protected static final String EXTRA_INITIAL_ROUTE = "initial_route";
  protected static final String INITIAL_ROUTE_META_DATA_KEY = "io.flutter.InitialRoute";
  protected static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
  protected static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
  private static final String TAG = "FlutterActivity";
  private FlutterActivityAndFragmentDelegate delegate;
  @NonNull
  private LifecycleRegistry lifecycle = new LifecycleRegistry(this);
  
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(1073741824);
      localWindow.getDecorView().setSystemUiVisibility(1280);
    }
  }
  
  private void configureWindowForTransparency()
  {
    if (getBackgroundMode() == FlutterActivity.BackgroundMode.transparent)
    {
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      getWindow().setFlags(512, 512);
    }
  }
  
  @NonNull
  public static Intent createDefaultIntent(@NonNull Context paramContext)
  {
    return withNewEngine().build(paramContext);
  }
  
  @NonNull
  private View createFlutterView()
  {
    return this.delegate.onCreateView(null, null, null);
  }
  
  @Nullable
  private Drawable getSplashScreenFromManifest()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 == null) {
          break label77;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21) {
            return getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      return null;
      label77:
      Object localObject2 = null;
    }
  }
  
  private boolean isDebuggable()
  {
    return (getApplicationInfo().flags & 0x2) != 0;
  }
  
  private void switchLaunchThemeForNormalTheme()
  {
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
      if (localActivityInfo.metaData != null)
      {
        int i = localActivityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      else
      {
        Log.d("FlutterActivity", "Using the launch theme as normal theme.");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
    }
  }
  
  public static FlutterActivity.CachedEngineIntentBuilder withCachedEngine(@NonNull String paramString)
  {
    return new FlutterActivity.CachedEngineIntentBuilder(FlutterActivity.class, paramString);
  }
  
  @NonNull
  public static FlutterActivity.NewEngineIntentBuilder withNewEngine()
  {
    return new FlutterActivity.NewEngineIntentBuilder(FlutterActivity.class);
  }
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  @NonNull
  public Activity getActivity()
  {
    return this;
  }
  
  @NonNull
  public String getAppBundlePath()
  {
    if ((isDebuggable()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      String str = getIntent().getDataString();
      if (str != null) {
        return str;
      }
    }
    return FlutterMain.findAppBundlePath();
  }
  
  @NonNull
  protected FlutterActivity.BackgroundMode getBackgroundMode()
  {
    if (getIntent().hasExtra("background_mode")) {
      return FlutterActivity.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
    }
    return FlutterActivity.BackgroundMode.opaque;
  }
  
  @Nullable
  public String getCachedEngineId()
  {
    return getIntent().getStringExtra("cached_engine_id");
  }
  
  @NonNull
  public Context getContext()
  {
    return this;
  }
  
  @NonNull
  public String getDartEntrypointFunctionName()
  {
    Object localObject2;
    if (getIntent().hasExtra("dart_entrypoint")) {
      localObject2 = getIntent().getStringExtra("dart_entrypoint");
    }
    for (;;)
    {
      return localObject2;
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 != null) {}
        for (localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");; localObject1 = null)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          return "main";
        }
        return "main";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  @Nullable
  protected FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  @NonNull
  public FlutterShellArgs getFlutterShellArgs()
  {
    return FlutterShellArgs.fromIntent(getIntent());
  }
  
  @NonNull
  public String getInitialRoute()
  {
    Object localObject2;
    if (getIntent().hasExtra("initial_route")) {
      localObject2 = getIntent().getStringExtra("initial_route");
    }
    for (;;)
    {
      return localObject2;
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 != null) {}
        for (localObject1 = ((Bundle)localObject1).getString("io.flutter.InitialRoute");; localObject1 = null)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          return "/";
        }
        return "/";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
  
  @NonNull
  public FlutterView.RenderMode getRenderMode()
  {
    if (getBackgroundMode() == FlutterActivity.BackgroundMode.opaque) {
      return FlutterView.RenderMode.surface;
    }
    return FlutterView.RenderMode.texture;
  }
  
  @NonNull
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    if (getBackgroundMode() == FlutterActivity.BackgroundMode.opaque) {
      return FlutterView.TransparencyMode.opaque;
    }
    return FlutterView.TransparencyMode.transparent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(this);
    configureWindowForTransparency();
    setContentView(createFlutterView());
    configureStatusBarForFullscreenFlutterExperience();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.delegate.onDestroyView();
    this.delegate.onDetach();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onFirstFrameRendered() {}
  
  protected void onNewIntent(@NonNull Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.delegate.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.delegate.onPause();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.delegate.onPostResume();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.delegate.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.delegate.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.delegate.onStop();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    this.delegate.onTrimMemory(paramInt);
  }
  
  public void onUserLeaveHint()
  {
    this.delegate.onUserLeaveHint();
  }
  
  @Nullable
  public FlutterEngine provideFlutterEngine(@NonNull Context paramContext)
  {
    return null;
  }
  
  @Nullable
  public PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine)
  {
    if (paramActivity != null) {
      return new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel());
    }
    return null;
  }
  
  @Nullable
  public SplashScreen provideSplashScreen()
  {
    Drawable localDrawable = getSplashScreenFromManifest();
    if (localDrawable != null) {
      return new DrawableSplashScreen(localDrawable);
    }
    return null;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    return getIntent().getBooleanExtra("destroy_engine_with_activity", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;

public class FlutterActivity
  extends Activity
  implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host
{
  private static final String TAG = "FlutterActivity";
  @VisibleForTesting
  protected FlutterActivityAndFragmentDelegate delegate;
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
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
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
    Drawable localDrawable = null;
    for (;;)
    {
      try
      {
        Bundle localBundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localBundle != null)
        {
          i = localBundle.getInt("io.flutter.embedding.android.SplashScreenDrawable");
          if (i != 0)
          {
            if (Build.VERSION.SDK_INT > 21) {
              return getResources().getDrawable(i, getTheme());
            }
            localDrawable = getResources().getDrawable(i);
          }
          return localDrawable;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        return null;
      }
      int i = 0;
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
        if (i == -1) {
          break label59;
        }
        setTheme(i);
        return;
      }
      Log.v("FlutterActivity", "Using the launch theme as normal theme.");
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label52:
      label59:
      break label52;
    }
    Log.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
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
  
  public void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    GeneratedPluginRegister.registerGeneratedPlugins(paramFlutterEngine);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
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
    return null;
  }
  
  @NonNull
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    if (getIntent().hasExtra("background_mode")) {
      return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
    }
    return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
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
    Object localObject2 = "main";
    try
    {
      Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
      return localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "main";
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
    Object localObject2 = "/";
    if (getIntent().hasExtra("route")) {
      return getIntent().getStringExtra("route");
    }
    try
    {
      Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("io.flutter.InitialRoute");
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
      return localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "/";
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
  
  @NonNull
  public RenderMode getRenderMode()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
      return RenderMode.surface;
    }
    return RenderMode.texture;
  }
  
  @NonNull
  public TransparencyMode getTransparencyMode()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
      return TransparencyMode.opaque;
    }
    return TransparencyMode.transparent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(this);
    this.delegate.onActivityCreated(paramBundle);
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
  
  public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(@NonNull FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      reportFullyDrawn();
    }
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
  
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
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.delegate.onSaveInstanceState(paramBundle);
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
  
  @VisibleForTesting
  void setDelegate(@NonNull FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate)
  {
    this.delegate = paramFlutterActivityAndFragmentDelegate;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    boolean bool2 = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    boolean bool1 = bool2;
    if (getCachedEngineId() == null)
    {
      if (this.delegate.isFlutterEngineFromHost()) {
        return bool2;
      }
      bool1 = getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }
    return bool1;
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    if (getIntent().hasExtra("enable_state_restoration")) {
      return getIntent().getBooleanExtra("enable_state_restoration", false);
    }
    return getCachedEngineId() == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */
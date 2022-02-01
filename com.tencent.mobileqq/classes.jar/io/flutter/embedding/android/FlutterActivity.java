package io.flutter.embedding.android;

import Override;
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
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;

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
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent)
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
        Object localObject = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject == null) {
          break label68;
        }
        i = ((Bundle)localObject).getInt("io.flutter.embedding.android.SplashScreenDrawable");
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT > 21) {
            return getResources().getDrawable(i, getTheme());
          }
          localObject = getResources().getDrawable(i);
          return localObject;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      return null;
      label68:
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
  
  public void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
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
    return FlutterMain.findAppBundlePath();
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
    try
    {
      Object localObject = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
      if (localObject != null) {}
      for (localObject = ((Bundle)localObject).getString("io.flutter.Entrypoint"); localObject != null; localObject = null) {
        return localObject;
      }
      return "main";
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
    Object localObject2;
    if (getIntent().hasExtra("initial_route")) {
      localObject2 = getIntent().getStringExtra("initial_route");
    }
    for (;;)
    {
      return localObject2;
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
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
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
      return FlutterView.RenderMode.surface;
    }
    return FlutterView.RenderMode.texture;
  }
  
  @NonNull
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
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
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost())) {
      return bool;
    }
    return getIntent().getBooleanExtra("destroy_engine_with_activity", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */
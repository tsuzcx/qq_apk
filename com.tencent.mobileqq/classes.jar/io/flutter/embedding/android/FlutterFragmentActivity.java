package io.flutter.embedding.android;

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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider
{
  private static final int FRAGMENT_CONTAINER_ID = 609893468;
  private static final String TAG = "FlutterFragmentActivity";
  private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
  @Nullable
  private FlutterFragment flutterFragment;
  
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
  private View createFragmentContainer()
  {
    FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setId(609893468);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  private void ensureFlutterFragmentCreated()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    this.flutterFragment = ((FlutterFragment)localFragmentManager.findFragmentByTag("flutter_fragment"));
    if (this.flutterFragment == null)
    {
      this.flutterFragment = createFlutterFragment();
      localFragmentManager.beginTransaction().add(609893468, this.flutterFragment, "flutter_fragment").commit();
    }
  }
  
  @Nullable
  private Drawable getSplashScreenFromManifest()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
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
        Log.v("FlutterFragmentActivity", "Using the launch theme as normal theme.");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("FlutterFragmentActivity", "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
    }
  }
  
  @NonNull
  public static FlutterFragmentActivity.CachedEngineIntentBuilder withCachedEngine(@NonNull String paramString)
  {
    return new FlutterFragmentActivity.CachedEngineIntentBuilder(FlutterFragmentActivity.class, paramString);
  }
  
  @NonNull
  public static FlutterFragmentActivity.NewEngineIntentBuilder withNewEngine()
  {
    return new FlutterFragmentActivity.NewEngineIntentBuilder(FlutterFragmentActivity.class);
  }
  
  public void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    GeneratedPluginRegister.registerGeneratedPlugins(paramFlutterEngine);
  }
  
  @NonNull
  protected FlutterFragment createFlutterFragment()
  {
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = getBackgroundMode();
    RenderMode localRenderMode = getRenderMode();
    if (localBackgroundMode == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {}
    for (TransparencyMode localTransparencyMode = TransparencyMode.opaque; getCachedEngineId() != null; localTransparencyMode = TransparencyMode.transparent)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Creating FlutterFragment with cached engine:\nCached engine ID: ");
      localStringBuilder.append(getCachedEngineId());
      localStringBuilder.append("\nWill destroy engine when Activity is destroyed: ");
      localStringBuilder.append(shouldDestroyEngineWithHost());
      localStringBuilder.append("\nBackground transparency mode: ");
      localStringBuilder.append(localBackgroundMode);
      localStringBuilder.append("\nWill attach FlutterEngine to Activity: ");
      localStringBuilder.append(shouldAttachEngineToActivity());
      Log.v("FlutterFragmentActivity", localStringBuilder.toString());
      return FlutterFragment.withCachedEngine(getCachedEngineId()).renderMode(localRenderMode).transparencyMode(localTransparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).destroyEngineWithFragment(shouldDestroyEngineWithHost()).build();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Creating FlutterFragment with new engine:\nBackground transparency mode: ");
    localStringBuilder.append(localBackgroundMode);
    localStringBuilder.append("\nDart entrypoint: ");
    localStringBuilder.append(getDartEntrypointFunctionName());
    localStringBuilder.append("\nInitial route: ");
    localStringBuilder.append(getInitialRoute());
    localStringBuilder.append("\nApp bundle path: ");
    localStringBuilder.append(getAppBundlePath());
    localStringBuilder.append("\nWill attach FlutterEngine to Activity: ");
    localStringBuilder.append(shouldAttachEngineToActivity());
    Log.v("FlutterFragmentActivity", localStringBuilder.toString());
    return FlutterFragment.withNewEngine().dartEntrypoint(getDartEntrypointFunctionName()).initialRoute(getInitialRoute()).appBundlePath(getAppBundlePath()).flutterShellArgs(FlutterShellArgs.fromIntent(getIntent())).renderMode(localRenderMode).transparencyMode(localTransparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).build();
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
  protected String getAppBundlePath()
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
  protected String getCachedEngineId()
  {
    return getIntent().getStringExtra("cached_engine_id");
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
    return this.flutterFragment.getFlutterEngine();
  }
  
  @NonNull
  protected String getInitialRoute()
  {
    Object localObject2;
    if (getIntent().hasExtra("route")) {
      localObject2 = getIntent().getStringExtra("route");
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
  protected RenderMode getRenderMode()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
      return RenderMode.surface;
    }
    return RenderMode.texture;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.flutterFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.flutterFragment.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    configureWindowForTransparency();
    setContentView(createFragmentContainer());
    configureStatusBarForFullscreenFlutterExperience();
    ensureFlutterFragmentCreated();
  }
  
  public void onNewIntent(@NonNull Intent paramIntent)
  {
    this.flutterFragment.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.flutterFragment.onPostResume();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.flutterFragment.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    this.flutterFragment.onTrimMemory(paramInt);
  }
  
  public void onUserLeaveHint()
  {
    this.flutterFragment.onUserLeaveHint();
  }
  
  @Nullable
  public FlutterEngine provideFlutterEngine(@NonNull Context paramContext)
  {
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
  
  protected boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    return getIntent().getBooleanExtra("destroy_engine_with_activity", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */
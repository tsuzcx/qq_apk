package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.platform.PlatformPlugin;

public class FlutterFragment
  extends ReportAndroidXFragment
  implements FlutterActivityAndFragmentDelegate.Host
{
  protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
  protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
  protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
  protected static final String ARG_ENABLE_STATE_RESTORATION = "enable_state_restoration";
  protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
  protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
  protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
  protected static final String ARG_INITIAL_ROUTE = "initial_route";
  protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
  private static final String TAG = "FlutterFragment";
  @VisibleForTesting
  FlutterActivityAndFragmentDelegate delegate;
  
  public FlutterFragment()
  {
    setArguments(new Bundle());
  }
  
  @NonNull
  public static FlutterFragment createDefault()
  {
    return new FlutterFragment.NewEngineFragmentBuilder().build();
  }
  
  @NonNull
  public static FlutterFragment.CachedEngineFragmentBuilder withCachedEngine(@NonNull String paramString)
  {
    return new FlutterFragment.CachedEngineFragmentBuilder(paramString, null);
  }
  
  @NonNull
  public static FlutterFragment.NewEngineFragmentBuilder withNewEngine()
  {
    return new FlutterFragment.NewEngineFragmentBuilder();
  }
  
  public void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).cleanUpFlutterEngine(paramFlutterEngine);
    }
  }
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).configureFlutterEngine(paramFlutterEngine);
    }
  }
  
  @NonNull
  public String getAppBundlePath()
  {
    return getArguments().getString("app_bundle_path");
  }
  
  @Nullable
  public String getCachedEngineId()
  {
    return getArguments().getString("cached_engine_id", null);
  }
  
  @NonNull
  public String getDartEntrypointFunctionName()
  {
    return getArguments().getString("dart_entrypoint", "main");
  }
  
  @Nullable
  public FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  @NonNull
  public FlutterShellArgs getFlutterShellArgs()
  {
    String[] arrayOfString = getArguments().getStringArray("initialization_args");
    if (arrayOfString != null) {}
    for (;;)
    {
      return new FlutterShellArgs(arrayOfString);
      arrayOfString = new String[0];
    }
  }
  
  @Nullable
  public String getInitialRoute()
  {
    return getArguments().getString("initial_route");
  }
  
  @NonNull
  public RenderMode getRenderMode()
  {
    return RenderMode.valueOf(getArguments().getString("flutterview_render_mode", RenderMode.surface.name()));
  }
  
  @NonNull
  public TransparencyMode getTransparencyMode()
  {
    return TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.transparent.name()));
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.delegate.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(paramContext);
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = this.delegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.delegate.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
  }
  
  public void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(@NonNull FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterUiDisplayListener)) {
      ((FlutterUiDisplayListener)localFragmentActivity).onFlutterUiDisplayed();
    }
  }
  
  public void onFlutterUiNoLongerDisplayed()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterUiDisplayListener)) {
      ((FlutterUiDisplayListener)localFragmentActivity).onFlutterUiNoLongerDisplayed();
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.delegate.onLowMemory();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onNewIntent(@NonNull Intent paramIntent)
  {
    this.delegate.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.delegate.onPause();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onPostResume()
  {
    this.delegate.onPostResume();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.delegate.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.delegate.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.delegate.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.delegate.onStop();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onTrimMemory(int paramInt)
  {
    this.delegate.onTrimMemory(paramInt);
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onUserLeaveHint()
  {
    this.delegate.onUserLeaveHint();
  }
  
  @Nullable
  public FlutterEngine provideFlutterEngine(@NonNull Context paramContext)
  {
    paramContext = getActivity();
    if ((paramContext instanceof FlutterEngineProvider))
    {
      Log.v("FlutterFragment", "Deferring to attached Activity to provide a FlutterEngine.");
      return ((FlutterEngineProvider)paramContext).provideFlutterEngine(getContext());
    }
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
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof SplashScreenProvider)) {
      return ((SplashScreenProvider)localFragmentActivity).provideSplashScreen();
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
    return getArguments().getBoolean("should_attach_engine_to_activity");
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost())) {
      return bool;
    }
    return getArguments().getBoolean("destroy_engine_with_fragment", true);
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    if (getArguments().containsKey("enable_state_restoration")) {
      return getArguments().getBoolean("enable_state_restoration");
    }
    return getCachedEngineId() == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */
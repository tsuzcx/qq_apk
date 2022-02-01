package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;

final class FlutterActivityAndFragmentDelegate
{
  private static final String FRAMEWORK_RESTORATION_BUNDLE_KEY = "framework";
  private static final String PLUGINS_RESTORATION_BUNDLE_KEY = "plugins";
  private static final String TAG = "FlutterActivityAndFragmentDelegate";
  @Nullable
  private FlutterEngine flutterEngine;
  @Nullable
  private FlutterSplashView flutterSplashView;
  @NonNull
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterActivityAndFragmentDelegate.1(this);
  @Nullable
  private FlutterView flutterView;
  @NonNull
  private FlutterActivityAndFragmentDelegate.Host host;
  private boolean isFlutterEngineFromHost;
  @Nullable
  private PlatformPlugin platformPlugin;
  
  FlutterActivityAndFragmentDelegate(@NonNull FlutterActivityAndFragmentDelegate.Host paramHost)
  {
    this.host = paramHost;
  }
  
  private void doInitialFlutterViewRun()
  {
    if (this.host.getCachedEngineId() != null) {
      return;
    }
    if (this.flutterEngine.getDartExecutor().isExecutingDart()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Executing Dart entrypoint: ");
    ((StringBuilder)localObject).append(this.host.getDartEntrypointFunctionName());
    ((StringBuilder)localObject).append(", and sending initial route: ");
    ((StringBuilder)localObject).append(this.host.getInitialRoute());
    Log.v("FlutterActivityAndFragmentDelegate", ((StringBuilder)localObject).toString());
    if (this.host.getInitialRoute() != null) {
      this.flutterEngine.getNavigationChannel().setInitialRoute(this.host.getInitialRoute());
    }
    String str = this.host.getAppBundlePath();
    if (str != null)
    {
      localObject = str;
      if (!str.isEmpty()) {}
    }
    else
    {
      localObject = FlutterInjector.instance().flutterLoader().findAppBundlePath();
    }
    localObject = new DartExecutor.DartEntrypoint((String)localObject, this.host.getDartEntrypointFunctionName());
    this.flutterEngine.getDartExecutor().executeDartEntrypoint((DartExecutor.DartEntrypoint)localObject);
  }
  
  private void ensureAlive()
  {
    if (this.host != null) {
      return;
    }
    throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
  }
  
  @Nullable
  FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  boolean isFlutterEngineFromHost()
  {
    return this.isFlutterEngineFromHost;
  }
  
  void onActivityCreated(@Nullable Bundle paramBundle)
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onActivityCreated. Giving framework and plugins an opportunity to restore state.");
    ensureAlive();
    byte[] arrayOfByte = null;
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getBundle("plugins");
      arrayOfByte = paramBundle.getByteArray("framework");
      paramBundle = (Bundle)localObject;
      localObject = arrayOfByte;
    }
    else
    {
      localObject = null;
      paramBundle = arrayOfByte;
    }
    if (this.host.shouldRestoreAndSaveState()) {
      this.flutterEngine.getRestorationChannel().setRestorationData((byte[])localObject);
    }
    if (this.host.shouldAttachEngineToActivity()) {
      this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(paramBundle);
    }
  }
  
  void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("\nresultCode: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("\ndata: ");
      localStringBuilder.append(paramIntent);
      Log.v("FlutterActivityAndFragmentDelegate", localStringBuilder.toString());
      this.flutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
  }
  
  void onAttach(@NonNull Context paramContext)
  {
    ensureAlive();
    if (this.flutterEngine == null) {
      setupFlutterEngine();
    }
    paramContext = this.host;
    this.platformPlugin = paramContext.providePlatformPlugin(paramContext.getActivity(), this.flutterEngine);
    if (this.host.shouldAttachEngineToActivity())
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this Fragment.");
      this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
    }
    this.host.configureFlutterEngine(this.flutterEngine);
  }
  
  void onBackPressed()
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
      this.flutterEngine.getNavigationChannel().popRoute();
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
  }
  
  @NonNull
  View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
    ensureAlive();
    if (this.host.getRenderMode() == RenderMode.surface)
    {
      paramLayoutInflater = this.host.getActivity();
      boolean bool;
      if (this.host.getTransparencyMode() == TransparencyMode.transparent) {
        bool = true;
      } else {
        bool = false;
      }
      paramLayoutInflater = new FlutterSurfaceView(paramLayoutInflater, bool);
      this.host.onFlutterSurfaceViewCreated(paramLayoutInflater);
      this.flutterView = new FlutterView(this.host.getActivity(), paramLayoutInflater);
    }
    else
    {
      paramLayoutInflater = new FlutterTextureView(this.host.getActivity());
      this.host.onFlutterTextureViewCreated(paramLayoutInflater);
      this.flutterView = new FlutterView(this.host.getActivity(), paramLayoutInflater);
    }
    this.flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
    this.flutterSplashView = new FlutterSplashView(this.host.getContext());
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutInflater = this.flutterSplashView;
      i = View.generateViewId();
    }
    else
    {
      paramLayoutInflater = this.flutterSplashView;
      i = 486947586;
    }
    paramLayoutInflater.setId(i);
    this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
    Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
    this.flutterView.attachToFlutterEngine(this.flutterEngine);
    return this.flutterSplashView;
  }
  
  void onDestroyView()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
    ensureAlive();
    this.flutterView.detachFromFlutterEngine();
    this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
  }
  
  void onDetach()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
    ensureAlive();
    this.host.cleanUpFlutterEngine(this.flutterEngine);
    if (this.host.shouldAttachEngineToActivity())
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
      if (this.host.getActivity().isChangingConfigurations()) {
        this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
      } else {
        this.flutterEngine.getActivityControlSurface().detachFromActivity();
      }
    }
    PlatformPlugin localPlatformPlugin = this.platformPlugin;
    if (localPlatformPlugin != null)
    {
      localPlatformPlugin.destroy();
      this.platformPlugin = null;
    }
    this.flutterEngine.getLifecycleChannel().appIsDetached();
    if (this.host.shouldDestroyEngineWithHost())
    {
      this.flutterEngine.destroy();
      if (this.host.getCachedEngineId() != null) {
        FlutterEngineCache.getInstance().remove(this.host.getCachedEngineId());
      }
      this.flutterEngine = null;
    }
  }
  
  void onLowMemory()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
    ensureAlive();
    this.flutterEngine.getDartExecutor().notifyLowMemoryWarning();
    this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
  }
  
  void onNewIntent(@NonNull Intent paramIntent)
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.");
      this.flutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
  }
  
  void onPause()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsInactive();
  }
  
  void onPostResume()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
    ensureAlive();
    if (this.flutterEngine != null)
    {
      PlatformPlugin localPlatformPlugin = this.platformPlugin;
      if (localPlatformPlugin != null) {
        localPlatformPlugin.updateSystemUiOverlays();
      }
    }
    else
    {
      Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
    }
  }
  
  void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("\npermissions: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      localStringBuilder.append("\ngrantResults: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfInt));
      Log.v("FlutterActivityAndFragmentDelegate", localStringBuilder.toString());
      this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
  }
  
  void onResume()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsResumed();
  }
  
  void onSaveInstanceState(@Nullable Bundle paramBundle)
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
    ensureAlive();
    if (this.host.shouldRestoreAndSaveState()) {
      paramBundle.putByteArray("framework", this.flutterEngine.getRestorationChannel().getRestorationData());
    }
    if (this.host.shouldAttachEngineToActivity())
    {
      Bundle localBundle = new Bundle();
      this.flutterEngine.getActivityControlSurface().onSaveInstanceState(localBundle);
      paramBundle.putBundle("plugins", localBundle);
    }
  }
  
  void onStart()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
    ensureAlive();
    doInitialFlutterViewRun();
  }
  
  void onStop()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsPaused();
  }
  
  void onTrimMemory(int paramInt)
  {
    ensureAlive();
    Object localObject = this.flutterEngine;
    if (localObject != null)
    {
      ((FlutterEngine)localObject).getDartExecutor().notifyLowMemoryWarning();
      if (paramInt == 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Forwarding onTrimMemory() to FlutterEngine. Level: ");
        ((StringBuilder)localObject).append(paramInt);
        Log.v("FlutterActivityAndFragmentDelegate", ((StringBuilder)localObject).toString());
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
      }
    }
    else
    {
      Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
    }
  }
  
  void onUserLeaveHint()
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
      this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
  }
  
  void release()
  {
    this.host = null;
    this.flutterEngine = null;
    this.flutterView = null;
    this.platformPlugin = null;
  }
  
  @VisibleForTesting
  void setupFlutterEngine()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
    Object localObject = this.host.getCachedEngineId();
    if (localObject != null)
    {
      this.flutterEngine = FlutterEngineCache.getInstance().get((String)localObject);
      this.isFlutterEngineFromHost = true;
      if (this.flutterEngine != null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("'");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    localObject = this.host;
    this.flutterEngine = ((FlutterActivityAndFragmentDelegate.Host)localObject).provideFlutterEngine(((FlutterActivityAndFragmentDelegate.Host)localObject).getContext());
    if (this.flutterEngine != null)
    {
      this.isFlutterEngineFromHost = true;
      return;
    }
    Log.v("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
    this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false, this.host.shouldRestoreAndSaveState());
    this.isFlutterEngineFromHost = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityAndFragmentDelegate
 * JD-Core Version:    0.7.0.1
 */
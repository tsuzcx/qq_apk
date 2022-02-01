package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;

final class FlutterActivityAndFragmentDelegate
{
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
    if (this.host.getCachedEngineId() != null) {}
    while (this.flutterEngine.getDartExecutor().isExecutingDart()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Executing Dart entrypoint: ");
    ((StringBuilder)localObject).append(this.host.getDartEntrypointFunctionName());
    ((StringBuilder)localObject).append(", and sending initial route: ");
    ((StringBuilder)localObject).append(this.host.getInitialRoute());
    Log.d("FlutterActivityAndFragmentDelegate", ((StringBuilder)localObject).toString());
    if (this.host.getInitialRoute() != null) {
      this.flutterEngine.getNavigationChannel().setInitialRoute(this.host.getInitialRoute());
    }
    localObject = new DartExecutor.DartEntrypoint(this.host.getAppBundlePath(), this.host.getDartEntrypointFunctionName());
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
    Log.v("FlutterActivityAndFragmentDelegate", "onActivityCreated. Giving plugins an opportunity to restore state.");
    ensureAlive();
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
    this.platformPlugin = this.host.providePlatformPlugin(this.host.getActivity(), this.flutterEngine);
    if (this.host.shouldAttachEngineToActivity())
    {
      Log.d("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this Fragment.");
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
    this.flutterView = new FlutterView(this.host.getActivity(), this.host.getRenderMode(), this.host.getTransparencyMode());
    this.flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
    this.flutterSplashView = new FlutterSplashView(this.host.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.flutterSplashView.setId(View.generateViewId());
    }
    for (;;)
    {
      this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
      return this.flutterSplashView;
      this.flutterSplashView.setId(486947586);
    }
  }
  
  void onDestroyView()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
    ensureAlive();
    this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
  }
  
  void onDetach()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
    ensureAlive();
    this.host.cleanUpFlutterEngine(this.flutterEngine);
    if (this.host.shouldAttachEngineToActivity())
    {
      Log.d("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
      if (!this.host.getActivity().isChangingConfigurations()) {
        break label153;
      }
      this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
    }
    for (;;)
    {
      if (this.platformPlugin != null)
      {
        this.platformPlugin.destroy();
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
      return;
      label153:
      this.flutterEngine.getActivityControlSurface().detachFromActivity();
    }
  }
  
  void onLowMemory()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
    ensureAlive();
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
      if (this.platformPlugin != null) {
        this.platformPlugin.updateSystemUiOverlays();
      }
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
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
    Log.v("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving plugins an opportunity to save state.");
    ensureAlive();
    if (this.host.shouldAttachEngineToActivity()) {
      this.flutterEngine.getActivityControlSurface().onSaveInstanceState(paramBundle);
    }
  }
  
  void onStart()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
    ensureAlive();
    new Handler().post(new FlutterActivityAndFragmentDelegate.2(this));
  }
  
  void onStop()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsPaused();
    this.flutterView.detachFromFlutterEngine();
  }
  
  void onTrimMemory(int paramInt)
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      if (paramInt == 10)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Forwarding onTrimMemory() to FlutterEngine. Level: ");
        localStringBuilder.append(paramInt);
        Log.v("FlutterActivityAndFragmentDelegate", localStringBuilder.toString());
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
      }
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
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
    Log.d("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
    String str = this.host.getCachedEngineId();
    if (str != null)
    {
      this.flutterEngine = FlutterEngineCache.getInstance().get(str);
      this.isFlutterEngineFromHost = true;
      if (this.flutterEngine != null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '");
      localStringBuilder.append(str);
      localStringBuilder.append("'");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    this.flutterEngine = this.host.provideFlutterEngine(this.host.getContext());
    if (this.flutterEngine != null)
    {
      this.isFlutterEngineFromHost = true;
      return;
    }
    Log.d("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
    this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray());
    this.isFlutterEngineFromHost = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityAndFragmentDelegate
 * JD-Core Version:    0.7.0.1
 */
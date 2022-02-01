package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;

abstract interface FlutterActivityAndFragmentDelegate$Host
  extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider
{
  public abstract void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine);
  
  public abstract void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine);
  
  @Nullable
  public abstract Activity getActivity();
  
  @NonNull
  public abstract String getAppBundlePath();
  
  @Nullable
  public abstract String getCachedEngineId();
  
  @NonNull
  public abstract Context getContext();
  
  @NonNull
  public abstract String getDartEntrypointFunctionName();
  
  @NonNull
  public abstract FlutterShellArgs getFlutterShellArgs();
  
  @Nullable
  public abstract String getInitialRoute();
  
  @NonNull
  public abstract Lifecycle getLifecycle();
  
  @NonNull
  public abstract RenderMode getRenderMode();
  
  @NonNull
  public abstract TransparencyMode getTransparencyMode();
  
  public abstract void onFlutterSurfaceViewCreated(@NonNull FlutterSurfaceView paramFlutterSurfaceView);
  
  public abstract void onFlutterTextureViewCreated(@NonNull FlutterTextureView paramFlutterTextureView);
  
  public abstract void onFlutterUiDisplayed();
  
  public abstract void onFlutterUiNoLongerDisplayed();
  
  @Nullable
  public abstract FlutterEngine provideFlutterEngine(@NonNull Context paramContext);
  
  @Nullable
  public abstract PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine);
  
  @Nullable
  public abstract SplashScreen provideSplashScreen();
  
  public abstract boolean shouldAttachEngineToActivity();
  
  public abstract boolean shouldDestroyEngineWithHost();
  
  public abstract boolean shouldRestoreAndSaveState();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;

abstract interface FlutterActivityAndFragmentDelegate$Host
  extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider
{
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
  public abstract FlutterView.RenderMode getRenderMode();
  
  @NonNull
  public abstract FlutterView.TransparencyMode getTransparencyMode();
  
  public abstract void onFirstFrameRendered();
  
  @Nullable
  public abstract FlutterEngine provideFlutterEngine(@NonNull Context paramContext);
  
  @Nullable
  public abstract PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine);
  
  @Nullable
  public abstract SplashScreen provideSplashScreen();
  
  public abstract boolean shouldAttachEngineToActivity();
  
  public abstract boolean shouldDestroyEngineWithHost();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
 * JD-Core Version:    0.7.0.1
 */
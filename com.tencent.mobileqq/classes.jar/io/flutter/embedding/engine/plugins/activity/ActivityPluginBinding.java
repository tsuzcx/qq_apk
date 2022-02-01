package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;

public abstract interface ActivityPluginBinding
{
  public abstract void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener paramActivityResultListener);
  
  public abstract void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener paramNewIntentListener);
  
  public abstract void addOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener paramOnSaveInstanceStateListener);
  
  public abstract void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener);
  
  public abstract void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener);
  
  @NonNull
  public abstract Activity getActivity();
  
  @NonNull
  public abstract Object getLifecycle();
  
  public abstract void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener paramActivityResultListener);
  
  public abstract void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener paramNewIntentListener);
  
  public abstract void removeOnSaveStateListener(@NonNull ActivityPluginBinding.OnSaveInstanceStateListener paramOnSaveInstanceStateListener);
  
  public abstract void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener);
  
  public abstract void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
 * JD-Core Version:    0.7.0.1
 */
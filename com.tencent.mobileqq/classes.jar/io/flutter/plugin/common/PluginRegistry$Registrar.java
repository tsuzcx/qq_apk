package io.flutter.plugin.common;

import android.app.Activity;
import android.content.Context;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;

public abstract interface PluginRegistry$Registrar
{
  public abstract Context activeContext();
  
  public abstract Activity activity();
  
  public abstract Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener);
  
  public abstract Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener);
  
  public abstract Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener);
  
  public abstract Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener);
  
  public abstract Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener);
  
  public abstract Context context();
  
  public abstract String lookupKeyForAsset(String paramString);
  
  public abstract String lookupKeyForAsset(String paramString1, String paramString2);
  
  public abstract BinaryMessenger messenger();
  
  public abstract PlatformViewRegistry platformViewRegistry();
  
  public abstract Registrar publish(Object paramObject);
  
  public abstract TextureRegistry textures();
  
  public abstract FlutterView view();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.PluginRegistry.Registrar
 * JD-Core Version:    0.7.0.1
 */
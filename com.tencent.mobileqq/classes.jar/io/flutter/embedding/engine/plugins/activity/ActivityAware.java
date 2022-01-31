package io.flutter.embedding.engine.plugins.activity;

import android.support.annotation.NonNull;

public abstract interface ActivityAware
{
  public abstract void onAttachedToActivity(@NonNull ActivityPluginBinding paramActivityPluginBinding);
  
  public abstract void onDetachedFromActivity();
  
  public abstract void onDetachedFromActivityForConfigChanges();
  
  public abstract void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding paramActivityPluginBinding);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.activity.ActivityAware
 * JD-Core Version:    0.7.0.1
 */
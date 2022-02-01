package io.flutter.embedding.engine.plugins.service;

import androidx.annotation.NonNull;

public abstract interface ServiceAware
{
  public abstract void onAttachedToService(@NonNull ServicePluginBinding paramServicePluginBinding);
  
  public abstract void onDetachedFromService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServiceAware
 * JD-Core Version:    0.7.0.1
 */
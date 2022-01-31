package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import android.support.annotation.NonNull;

public abstract interface ServicePluginBinding
{
  public abstract void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener paramOnModeChangeListener);
  
  @NonNull
  public abstract Service getService();
  
  public abstract void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener paramOnModeChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServicePluginBinding
 * JD-Core Version:    0.7.0.1
 */
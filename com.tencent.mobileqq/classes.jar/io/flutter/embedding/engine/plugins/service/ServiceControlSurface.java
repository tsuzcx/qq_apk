package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

public abstract interface ServiceControlSurface
{
  public abstract void attachToService(@NonNull Service paramService, @Nullable Lifecycle paramLifecycle, boolean paramBoolean);
  
  public abstract void detachFromService();
  
  public abstract void onMoveToBackground();
  
  public abstract void onMoveToForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.service.ServiceControlSurface
 * JD-Core Version:    0.7.0.1
 */
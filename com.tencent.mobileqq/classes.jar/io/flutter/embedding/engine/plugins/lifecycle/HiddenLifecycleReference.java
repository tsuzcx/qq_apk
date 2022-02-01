package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

@Keep
public class HiddenLifecycleReference
{
  @NonNull
  private final Lifecycle lifecycle;
  
  public HiddenLifecycleReference(@NonNull Lifecycle paramLifecycle)
  {
    this.lifecycle = paramLifecycle;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference
 * JD-Core Version:    0.7.0.1
 */
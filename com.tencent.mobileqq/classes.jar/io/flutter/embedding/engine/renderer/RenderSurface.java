package io.flutter.embedding.engine.renderer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface RenderSurface
{
  public abstract void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer);
  
  public abstract void detachFromRenderer();
  
  @Nullable
  public abstract FlutterRenderer getAttachedRenderer();
  
  public abstract void pause();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.RenderSurface
 * JD-Core Version:    0.7.0.1
 */
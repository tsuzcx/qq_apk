package io.flutter.embedding.engine.renderer;

import android.support.annotation.NonNull;

public abstract interface FlutterRenderer$RenderSurface
{
  public abstract void addOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener);
  
  public abstract void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer);
  
  public abstract void detachFromRenderer();
  
  public abstract void onFirstFrameRendered();
  
  public abstract void removeOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.FlutterRenderer.RenderSurface
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
public class FlutterOverlaySurface
{
  private final int id;
  @NonNull
  private final Surface surface;
  
  public FlutterOverlaySurface(int paramInt, @NonNull Surface paramSurface)
  {
    this.id = paramInt;
    this.surface = paramSurface;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Surface getSurface()
  {
    return this.surface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterOverlaySurface
 * JD-Core Version:    0.7.0.1
 */
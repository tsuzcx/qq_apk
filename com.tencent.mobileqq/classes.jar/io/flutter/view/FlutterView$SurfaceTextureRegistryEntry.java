package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import io.flutter.embedding.engine.FlutterJNI;

final class FlutterView$SurfaceTextureRegistryEntry
  implements TextureRegistry.SurfaceTextureEntry
{
  private final long id;
  private SurfaceTexture.OnFrameAvailableListener onFrameListener = new FlutterView.SurfaceTextureRegistryEntry.1(this);
  private boolean released;
  private final SurfaceTexture surfaceTexture;
  
  FlutterView$SurfaceTextureRegistryEntry(FlutterView paramFlutterView, long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    this.id = paramLong;
    this.surfaceTexture = paramSurfaceTexture;
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener, new Handler());
      return;
    }
    this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener);
  }
  
  public long id()
  {
    return this.id;
  }
  
  public void release()
  {
    if (this.released) {
      return;
    }
    this.released = true;
    this.surfaceTexture.setOnFrameAvailableListener(null);
    this.surfaceTexture.release();
    FlutterView.access$100(this.this$0).getFlutterJNI().unregisterTexture(this.id);
  }
  
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.view.FlutterView.SurfaceTextureRegistryEntry
 * JD-Core Version:    0.7.0.1
 */
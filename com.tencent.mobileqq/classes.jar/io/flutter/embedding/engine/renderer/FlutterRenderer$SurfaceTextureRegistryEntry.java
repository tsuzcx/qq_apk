package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

final class FlutterRenderer$SurfaceTextureRegistryEntry
  implements TextureRegistry.SurfaceTextureEntry
{
  private final long id;
  private SurfaceTexture.OnFrameAvailableListener onFrameListener = new FlutterRenderer.SurfaceTextureRegistryEntry.1(this);
  private boolean released;
  @NonNull
  private final SurfaceTexture surfaceTexture;
  
  FlutterRenderer$SurfaceTextureRegistryEntry(FlutterRenderer paramFlutterRenderer, @NonNull long paramLong, SurfaceTexture paramSurfaceTexture)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Releasing a SurfaceTexture (");
    localStringBuilder.append(this.id);
    localStringBuilder.append(").");
    Log.v("FlutterRenderer", localStringBuilder.toString());
    this.surfaceTexture.release();
    FlutterRenderer.access$500(this.this$0, this.id);
    this.released = true;
  }
  
  @NonNull
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI;

class FlutterRenderer$SurfaceTextureRegistryEntry$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  FlutterRenderer$SurfaceTextureRegistryEntry$1(FlutterRenderer.SurfaceTextureRegistryEntry paramSurfaceTextureRegistryEntry) {}
  
  public void onFrameAvailable(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    if (!FlutterRenderer.SurfaceTextureRegistryEntry.access$100(this.this$1))
    {
      if (!FlutterRenderer.access$200(this.this$1.this$0).isAttached()) {
        return;
      }
      FlutterRenderer.access$400(this.this$1.this$0, FlutterRenderer.SurfaceTextureRegistryEntry.access$300(this.this$1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
 * JD-Core Version:    0.7.0.1
 */
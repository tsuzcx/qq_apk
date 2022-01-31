package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.NonNull;

class FlutterRenderer$SurfaceTextureRegistryEntry$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  FlutterRenderer$SurfaceTextureRegistryEntry$1(FlutterRenderer.SurfaceTextureRegistryEntry paramSurfaceTextureRegistryEntry) {}
  
  public void onFrameAvailable(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    if (FlutterRenderer.SurfaceTextureRegistryEntry.access$100(this.this$1)) {
      return;
    }
    FlutterRenderer.access$300(this.this$1.this$0, FlutterRenderer.SurfaceTextureRegistryEntry.access$200(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
 * JD-Core Version:    0.7.0.1
 */
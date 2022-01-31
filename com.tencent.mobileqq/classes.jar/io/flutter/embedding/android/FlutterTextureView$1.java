package io.flutter.embedding.android;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.view.TextureView.SurfaceTextureListener;
import io.flutter.Log;

class FlutterTextureView$1
  implements TextureView.SurfaceTextureListener
{
  FlutterTextureView$1(FlutterTextureView paramFlutterTextureView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
    FlutterTextureView.access$002(this.this$0, true);
    if (FlutterTextureView.access$100(this.this$0)) {
      FlutterTextureView.access$200(this.this$0);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
    FlutterTextureView.access$002(this.this$0, false);
    if (FlutterTextureView.access$100(this.this$0)) {
      FlutterTextureView.access$400(this.this$0);
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
    if (FlutterTextureView.access$100(this.this$0)) {
      FlutterTextureView.access$300(this.this$0, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(@NonNull SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView.1
 * JD-Core Version:    0.7.0.1
 */
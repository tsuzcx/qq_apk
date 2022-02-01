package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;

public class RFWTextureBarrageView
  implements TextureView.SurfaceTextureListener, IRFWBarrageView
{
  private TextureView a;
  private IRFWBarrageView.CallBack b;
  
  public RFWTextureBarrageView(TextureView paramTextureView)
  {
    this.a = paramTextureView;
    paramTextureView = this.a;
    if (paramTextureView != null)
    {
      paramTextureView.setOpaque(false);
      this.a.setSurfaceTextureListener(this);
    }
  }
  
  public Canvas a()
  {
    return this.a.lockCanvas();
  }
  
  public void a(Canvas paramCanvas)
  {
    this.a.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IRFWBarrageView.CallBack paramCallBack)
  {
    this.b = paramCallBack;
  }
  
  public float b()
  {
    return this.a.getY();
  }
  
  public void c() {}
  
  public void d()
  {
    this.b = null;
    TextureView localTextureView = this.a;
    if (localTextureView != null)
    {
      localTextureView.setOnTouchListener(null);
      this.a = null;
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    RFWBarrageLogger.b("TextureBarrageView", "[onSurfaceTextureAvailable] surface texture available...");
    paramSurfaceTexture = this.a;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOpaque(false);
    }
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.l();
      this.b.m();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.n();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    RFWBarrageLogger.b("TextureBarrageView", "[onSurfaceTextureSizeChanged] surface texture size changed...");
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.m();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWTextureBarrageView
 * JD-Core Version:    0.7.0.1
 */
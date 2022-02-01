package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;

public class TextureDanmakuView
  implements TextureView.SurfaceTextureListener, IDanmakuView
{
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private IDanmakuView.CallBack jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
  
  public TextureDanmakuView(TextureView paramTextureView)
  {
    this.jdField_a_of_type_AndroidViewTextureView = paramTextureView;
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    this.jdField_a_of_type_AndroidViewTextureView.setSurfaceTextureListener(this);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidViewTextureView.getY();
  }
  
  public Canvas a()
  {
    return this.jdField_a_of_type_AndroidViewTextureView.lockCanvas();
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidViewTextureView.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewTextureView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IDanmakuView.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack = paramCallBack;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack = null;
    TextureView localTextureView = this.jdField_a_of_type_AndroidViewTextureView;
    if (localTextureView != null)
    {
      localTextureView.setOnTouchListener(null);
      this.jdField_a_of_type_AndroidViewTextureView = null;
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.l();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack.m();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.n();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.m();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.TextureDanmakuView
 * JD-Core Version:    0.7.0.1
 */
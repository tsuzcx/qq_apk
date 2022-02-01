package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class QQDrawScreenFilter
  extends QQBaseFilter
{
  public TextureRender textureRender;
  
  public QQDrawScreenFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public void init()
  {
    this.textureRender = new TextureRender();
  }
  
  public void onDrawFrame()
  {
    if (this.textureRender == null) {
      init();
    }
    boolean bool = getQQFilterRenderManager().getBooleanParam("key_draw_screen");
    int i = getQQFilterRenderManager().getIntParam("key_width");
    int j = getQQFilterRenderManager().getIntParam("key_height");
    if (bool)
    {
      QQFilterLogManager.setOnDrawFilterStart();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, i, j);
      TextureRender localTextureRender = this.textureRender;
      if (localTextureRender != null) {
        localTextureRender.drawTexture(3553, this.mInputTextureID, null, null);
      }
      QQFilterLogManager.setOnDrawFilterEnd("绘制到屏幕");
    }
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void onSurfaceDestroy()
  {
    TextureRender localTextureRender = this.textureRender;
    if (localTextureRender != null)
    {
      localTextureRender.release();
      this.textureRender = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDrawScreenFilter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.List;

public class QQGaussianBlurFilter
  extends QQBaseFilter
{
  private GaussianBlurFilterCompose compose;
  private int frameIndex = 0;
  private int frameRate = 0;
  private GLImage glImage;
  private int height = 1280;
  private int imgSize = 0;
  private RenderBuffer mRenderFBO;
  private List<String> pathList;
  private int picIndex = 0;
  private int picRate = 0;
  private TextureRender textureRender;
  private int width = 640;
  
  public QQGaussianBlurFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void initTexture()
  {
    this.glImage = new GLImage();
    this.compose = new GaussianBlurFilterCompose();
    this.compose.init(this.width, this.height);
    this.mRenderFBO = new RenderBuffer(this.width, this.height, 33984);
    this.textureRender = new TextureRender();
  }
  
  public void onDrawFrame()
  {
    if (this.frameIndex % this.picRate == 0)
    {
      this.picIndex = (this.frameIndex / this.picRate);
      if (this.picIndex < this.imgSize)
      {
        Log.d("rejectliu", "scale Filter OnDrawFrame frameIndex : " + this.frameIndex + "  picRate : " + this.picRate + " imgSize : " + this.imgSize + "  picIndex : " + this.picIndex);
        this.glImage.loadTextureSync((String)this.pathList.get(this.picIndex));
      }
    }
    int i = this.glImage.getTexture();
    this.compose.drawTexture(i);
    i = this.compose.getTextureId();
    this.mRenderFBO.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    this.textureRender.drawTexture(3553, i, null, null);
    this.mRenderFBO.unbind();
    this.mOutputTextureID = this.mRenderFBO.getTexId();
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    initTexture();
  }
  
  protected void parseSpecificParam()
  {
    if (this.mSpecificParam != null) {}
    try
    {
      ArrayList localArrayList = (ArrayList)this.mSpecificParam;
      if (localArrayList.size() >= 2)
      {
        this.width = ((Integer)localArrayList.get(0)).intValue();
        this.height = ((Integer)localArrayList.get(1)).intValue();
      }
      return;
    }
    catch (ClassCastException localClassCastException) {}
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.frameIndex = paramInt;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameRate = paramInt;
    this.picRate = (paramInt * 2);
  }
  
  public void setImageList(List<String> paramList)
  {
    this.pathList = paramList;
    this.imgSize = paramList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */
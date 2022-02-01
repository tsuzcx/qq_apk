package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class QQTextEjectaFilter
  extends QQBaseFilter
{
  private int blurTex = 0;
  private GaussianBlurFilterCompose compose;
  private GLImage glImage;
  private int imageBgTextureId = 0;
  QQTextEjectaFilter.EjectaTextureCallBack mEjectaTextureCallBack;
  private String mImagePath;
  boolean mIsNeedCameraTexture = true;
  int[] mIsNeedReverseTexture = { 0, 0 };
  private RenderBuffer mRenderFBO;
  float[] mvpMatrix = new float[16];
  private int[] tex = { -1 };
  float[] textureMatrix = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  TextureRender textureRender;
  private int videoHeight = 1280;
  private int videoWidth = 720;
  
  public QQTextEjectaFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    initTexture();
  }
  
  private int getBgImageTextrueId()
  {
    if (TextUtils.isEmpty(this.mImagePath))
    {
      this.imageBgTextureId = 0;
      return this.imageBgTextureId;
    }
    if (this.imageBgTextureId == 0)
    {
      this.glImage.loadTextureSync(this.mImagePath);
      this.imageBgTextureId = this.glImage.getTexture();
    }
    return this.imageBgTextureId;
  }
  
  private void initTexture()
  {
    Object localObject = this.mRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.textureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    this.glImage = new GLImage();
    this.mRenderFBO = new RenderBuffer(this.videoWidth, this.videoHeight, 33986);
    this.textureRender = new TextureRender();
  }
  
  public boolean isFilterWork()
  {
    int[] arrayOfInt = this.tex;
    return (arrayOfInt != null) && (arrayOfInt.length > 0);
  }
  
  public void onDrawFrame()
  {
    Object localObject1 = this.mEjectaTextureCallBack;
    if (localObject1 != null) {
      this.tex = ((QQTextEjectaFilter.EjectaTextureCallBack)localObject1).onDrawFrame();
    }
    localObject1 = this.tex;
    if ((localObject1 != null) && (localObject1.length != 0)) {}
    try
    {
      i = getBgImageTextrueId();
      if ((i != 0) && (this.blurTex == 0))
      {
        if (this.compose == null)
        {
          this.compose = new GaussianBlurFilterCompose();
          this.compose.init(this.videoWidth, this.videoHeight);
        }
        this.compose.drawTexture(i);
        this.blurTex = this.compose.getTextureId();
      }
      this.mRenderFBO.bind();
      if (this.mIsNeedCameraTexture)
      {
        this.textureRender.drawTexture(3553, this.mInputTextureID, null, null);
      }
      else
      {
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glClear(16384);
      }
      if (i == 0) {
        break label417;
      }
      if (this.blurTex != 0) {
        this.textureRender.drawTexture(3553, this.blurTex, this.textureMatrix, null);
      }
      float f = this.videoWidth / this.glImage.getWidth() * this.glImage.getHeight() / this.videoHeight;
      Matrix.setIdentityM(this.mvpMatrix, 0);
      Matrix.scaleM(this.mvpMatrix, 0, 1.0F, f, 1.0F);
      this.textureRender.drawTexture(3553, i, this.textureMatrix, this.mvpMatrix);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TextureRender localTextureRender;
        int k;
        continue;
        int i = 0;
        continue;
        int j = 0;
        continue;
        Object localObject2 = null;
        continue;
        i += 1;
      }
    }
    if (i < this.tex.length)
    {
      if (this.tex[i] <= 0) {
        break label433;
      }
      if ((i < this.mIsNeedReverseTexture.length) && (this.mIsNeedReverseTexture[i] == 1))
      {
        j = 1;
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        localTextureRender = this.textureRender;
        k = this.tex[i];
        if (j == 0) {
          break label427;
        }
        localObject1 = this.textureMatrix;
        localTextureRender.drawTexture(3553, k, (float[])localObject1, null);
        GLES20.glDisable(3042);
        break label433;
      }
    }
    else
    {
      GLES20.glGetError();
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return;
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return;
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    GaussianBlurFilterCompose localGaussianBlurFilterCompose = this.compose;
    if (localGaussianBlurFilterCompose != null) {
      localGaussianBlurFilterCompose.destroy();
    }
  }
  
  protected void parseSpecificParam()
  {
    if ((this.mSpecificParam != null) && ((this.mSpecificParam instanceof QQTextEjectaFilter.EjectaTextureCallBack))) {
      this.mEjectaTextureCallBack = ((QQTextEjectaFilter.EjectaTextureCallBack)this.mSpecificParam);
    }
  }
  
  public void setImagePath(String paramString)
  {
    this.imageBgTextureId = 0;
    this.blurTex = 0;
    this.mImagePath = paramString;
  }
  
  public void setIsNeedCameraTexture(boolean paramBoolean)
  {
    this.mIsNeedCameraTexture = paramBoolean;
  }
  
  public void setIsNeedReverseTexture(int[] paramArrayOfInt)
  {
    this.mIsNeedReverseTexture = paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter
 * JD-Core Version:    0.7.0.1
 */
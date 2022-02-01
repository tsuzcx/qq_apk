package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class QQScaleFilter
  extends QQBaseFilter
{
  private float[] ALPHA_BUFFER = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  private GPUAlphaFilter alphaRender;
  private GaussianBlurFilterCompose compose;
  private int frameIndex = 0;
  private int frameRate = 0;
  private GLImage glImage;
  private int height = 1280;
  private int imgSize = 0;
  private RenderBuffer mRenderFBO;
  private float[] mvpMatrix;
  private GLImage nextGlImage;
  private List<String> pathList;
  private int picIndex = 0;
  private int picRate = 0;
  private FloatBuffer rgbaBuffer;
  private RenderBuffer scaleFBO;
  private TextureRender textureRender;
  private int width = 640;
  
  public QQScaleFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void initTexture()
  {
    this.mRenderFBO = new RenderBuffer(this.width, this.height, 33984);
    this.scaleFBO = new RenderBuffer(this.width, this.height, 33984);
    this.textureRender = new TextureRender();
    this.alphaRender = new GPUAlphaFilter();
    this.alphaRender.init();
    this.compose = new GaussianBlurFilterCompose();
    this.compose.init(this.width, this.height);
    this.glImage = new GLImage();
    this.nextGlImage = new GLImage();
    this.mvpMatrix = new float[16];
    this.rgbaBuffer = GlUtil.createFloatBuffer(this.ALPHA_BUFFER);
  }
  
  private void setArrayAlpha(float paramFloat)
  {
    float[] arrayOfFloat = this.ALPHA_BUFFER;
    arrayOfFloat[3] = paramFloat;
    arrayOfFloat[7] = paramFloat;
    arrayOfFloat[11] = paramFloat;
    arrayOfFloat[15] = paramFloat;
  }
  
  private void updateAlphaByteBuffer(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = this.rgbaBuffer;
    if (localFloatBuffer != null)
    {
      localFloatBuffer.put(paramArrayOfFloat);
      this.rgbaBuffer.position(0);
    }
  }
  
  public void onDrawFrame()
  {
    super.onDrawFrame();
    int i = this.frameIndex;
    int j = this.picRate;
    if (i % j == 0)
    {
      this.picIndex = (i / j);
      if (this.picIndex < this.imgSize)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("scale Filter OnDrawFrame frameIndex : ");
        localStringBuilder.append(this.frameIndex);
        localStringBuilder.append("  picRate : ");
        localStringBuilder.append(this.picRate);
        localStringBuilder.append(" imgSize : ");
        localStringBuilder.append(this.imgSize);
        localStringBuilder.append("  picIndex : ");
        localStringBuilder.append(this.picIndex);
        Log.d("rejectliu", localStringBuilder.toString());
        this.glImage.loadTextureSync((String)this.pathList.get(this.picIndex));
        i = this.picIndex;
        if (i + 1 < this.imgSize) {
          this.nextGlImage.loadTextureSync((String)this.pathList.get(i + 1));
        }
      }
    }
    j = this.picIndex;
    i = this.picRate;
    j *= i;
    int k = this.frameIndex;
    float f1;
    if (k >= j)
    {
      f2 = (k - j) / i;
      f1 = f2 * 0.1F + 1.0F;
    }
    else
    {
      f2 = 0.0F;
      f1 = 1.0F;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frameIndex : ");
    localStringBuilder.append(this.frameIndex);
    localStringBuilder.append(" animRatio : ");
    localStringBuilder.append(f1);
    localStringBuilder.append(" startIndex : ");
    localStringBuilder.append(j);
    localStringBuilder.append(" picRate : ");
    localStringBuilder.append(this.picRate);
    localStringBuilder.append(" animRatio : ");
    localStringBuilder.append(f1);
    Log.d("rejectliu", localStringBuilder.toString());
    this.mRenderFBO.bind();
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    GLES20.glClear(16384);
    this.mRenderFBO.unbind();
    float f3 = f2 * 0.9F + 0.1F;
    float f2 = (1.0F - f2) * 0.9F + 0.1F;
    if (this.picIndex + 1 < this.imgSize)
    {
      float f4 = this.width / this.nextGlImage.getWidth() * this.nextGlImage.getHeight() / this.height;
      i = this.nextGlImage.getTexture();
      setArrayAlpha(f3);
      updateAlphaByteBuffer(this.ALPHA_BUFFER);
      this.compose.drawTexture(i);
      j = this.compose.getTextureId();
      this.mRenderFBO.bind();
      this.alphaRender.drawTexture(j, null, null, this.rgbaBuffer);
      setArrayAlpha(f3);
      updateAlphaByteBuffer(this.ALPHA_BUFFER);
      Matrix.setIdentityM(this.mvpMatrix, 0);
      Matrix.scaleM(this.mvpMatrix, 0, 1.0F, f4, 1.0F);
      this.alphaRender.drawTexture(i, null, this.mvpMatrix, this.rgbaBuffer);
      this.mRenderFBO.unbind();
    }
    this.mRenderFBO.bind();
    setArrayAlpha(f2);
    updateAlphaByteBuffer(this.ALPHA_BUFFER);
    this.alphaRender.drawTexture(this.mInputTextureID, null, null, this.rgbaBuffer);
    f3 = this.width / this.glImage.getWidth() * this.glImage.getHeight() / this.height;
    i = this.glImage.getTexture();
    Matrix.setIdentityM(this.mvpMatrix, 0);
    Matrix.scaleM(this.mvpMatrix, 0, f1, f1, 1.0F);
    setArrayAlpha(f2);
    updateAlphaByteBuffer(this.ALPHA_BUFFER);
    j = this.height;
    GLES20.glViewport(0, (int)(j * (1.0F - f3)) / 2, this.width, (int)(j * f3));
    this.alphaRender.drawTexture(i, null, this.mvpMatrix, this.rgbaBuffer);
    GLES20.glViewport(0, 0, this.width, this.height);
    this.mRenderFBO.unbind();
    this.mOutputTextureID = this.mRenderFBO.getTexId();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQScaleFilter
 * JD-Core Version:    0.7.0.1
 */
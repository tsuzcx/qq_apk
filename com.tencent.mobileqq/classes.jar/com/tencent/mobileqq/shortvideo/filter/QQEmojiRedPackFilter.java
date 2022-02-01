package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class QQEmojiRedPackFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQEmojiRedPackFilter";
  private RenderBuffer mRenderFBO;
  private GPUAlphaBlendFilter mWatermarkFilter;
  private int mWatermarkHeight;
  private String mWatermarkPath;
  private int mWatermarkTextureIdForEncode = -1;
  private int mWatermarkWidth;
  
  public QQEmojiRedPackFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(185, paramQQFilterRenderManager);
  }
  
  private void initWatermark(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      float f1 = paramInt1 / paramString.getWidth();
      float f2 = paramInt2 / paramString.getHeight();
      android.graphics.Matrix localMatrix = new android.graphics.Matrix();
      localMatrix.postScale(f1, f2);
      paramString = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), localMatrix, true);
      this.mWatermarkTextureIdForEncode = GlUtil.createTexture(3553, paramString);
      this.mWatermarkWidth = paramString.getWidth();
      this.mWatermarkHeight = paramString.getHeight();
      paramString.recycle();
      label100:
      this.mWatermarkFilter = new GPUAlphaBlendFilter();
      this.mWatermarkFilter.onOutputSizeChanged(this.mWatermarkWidth, this.mWatermarkHeight);
      this.mWatermarkFilter.init();
      this.mRenderFBO = new RenderBuffer(this.mWatermarkWidth, this.mWatermarkHeight, 33984);
      return;
    }
    catch (Throwable paramString)
    {
      break label100;
    }
  }
  
  public void onDrawFrame()
  {
    super.onDrawFrame();
    if (TextUtils.isEmpty(this.mWatermarkPath))
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    int i = getQQFilterRenderManager().getFilterWidth();
    int j = getQQFilterRenderManager().getFilterHeight();
    if (this.mWatermarkFilter == null) {
      initWatermark(this.mWatermarkPath, i, j);
    }
    RenderBuffer localRenderBuffer = this.mRenderFBO;
    if (localRenderBuffer != null)
    {
      localRenderBuffer.recoverInitialTexId();
      localRenderBuffer.setTexId(this.mInputTextureID);
      localRenderBuffer.bind();
      if (this.mWatermarkFilter != null)
      {
        i = this.mWatermarkWidth;
        j = this.mWatermarkHeight;
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(i, j, i, j);
        android.opengl.Matrix.setIdentityM(arrayOfFloat, 0);
        android.opengl.Matrix.scaleM(arrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
        this.mWatermarkFilter.drawTexture(this.mWatermarkTextureIdForEncode, null, arrayOfFloat);
      }
      localRenderBuffer.unbind();
    }
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    Object localObject = this.mWatermarkFilter;
    if (localObject != null) {
      ((GPUAlphaBlendFilter)localObject).destroy();
    }
    localObject = this.mRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
  }
  
  public void setWatermarkPath(String paramString)
  {
    this.mWatermarkPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter
 * JD-Core Version:    0.7.0.1
 */
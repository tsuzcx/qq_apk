package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQDynamicStickersFilter
  extends QQBaseFilter
{
  private static String TAG = "QQDynamicStickersFilter";
  private boolean bwork = false;
  private List<DynamicStickerData> mDynamicStickers;
  private GPUAlphaBlendFilter mMultiStickerFilter;
  private RenderBuffer mRenderFBO;
  private int mSurfaceHeight = 0;
  private int mSurfaceWidth = 0;
  private boolean mbReversed = true;
  private float[][] mvpMatrix;
  private int textureId;
  private float[] textureMatrix = null;
  
  public QQDynamicStickersFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public void InitDynamicStickers(List<DynamicStickerData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mDynamicStickers = paramList;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((DynamicStickerData)localIterator.next()).mGifDecoder.init();
      }
      this.mvpMatrix = new float[paramList.size()][];
      this.bwork = true;
    }
    if (this.mbReversed)
    {
      this.textureMatrix = null;
      return;
    }
    this.textureMatrix = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public void SetReversedCoordination(boolean paramBoolean)
  {
    this.mbReversed = paramBoolean;
    if (this.mbReversed)
    {
      this.textureMatrix = null;
      return;
    }
    this.textureMatrix = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public float[] caculateMatrix(DynamicStickerData paramDynamicStickerData, TrackerStickerParam.MotionInfo paramMotionInfo)
  {
    float f3 = this.mSurfaceWidth / this.mSurfaceHeight;
    GlMatricUtil localGlMatricUtil = new GlMatricUtil();
    localGlMatricUtil.ortho(-1.0F * f3, 1.0F * f3, -1.0F, 1.0F, 3.0F, 20.0F);
    localGlMatricUtil.setCamera(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    float f1 = paramDynamicStickerData.centerP.x;
    float f2 = paramDynamicStickerData.translateX + f1;
    f1 = paramDynamicStickerData.centerP.y + paramDynamicStickerData.translateY;
    if (paramMotionInfo != null)
    {
      f2 = paramMotionInfo.x;
      f1 = paramMotionInfo.y;
    }
    f2 = f2 * 2.0F / paramDynamicStickerData.layerWidth;
    f1 = f1 * 2.0F / paramDynamicStickerData.layerHeight;
    if (this.mbReversed) {
      localGlMatricUtil.translate((f2 - 1.0F) * f3, f1 - 1.0F, 0.0F);
    }
    for (;;)
    {
      float f4 = this.mSurfaceWidth / paramDynamicStickerData.layerWidth;
      f1 = this.mSurfaceHeight / paramDynamicStickerData.layerHeight;
      float f5 = paramDynamicStickerData.width / this.mSurfaceWidth;
      f2 = paramDynamicStickerData.height / this.mSurfaceHeight;
      f3 = f4 * paramDynamicStickerData.scale * f5 * f3;
      f1 = f1 * paramDynamicStickerData.scale * f2;
      localGlMatricUtil.rotate(paramDynamicStickerData.rotate, 0.0F, 0.0F, 1.0F);
      localGlMatricUtil.scale(f3, f1, 1.0F);
      SLog.d("giftrackerMatrix ", "finalScaleX : " + f3 + " finalScaleY:" + f1);
      paramMotionInfo = localGlMatricUtil.getFinalMatrix();
      paramDynamicStickerData = "mvp: ";
      int i = 0;
      while (i < 16)
      {
        paramDynamicStickerData = paramDynamicStickerData + " " + paramMotionInfo[i];
        i += 1;
      }
      localGlMatricUtil.translate((f2 - 1.0F) * f3, 1.0F - f1, 0.0F);
    }
    SLog.d("giftrackerMatrix ", paramDynamicStickerData);
    return paramMotionInfo;
  }
  
  TrackerStickerParam.MotionInfo getTrackerPoint(long paramLong, DynamicStickerData paramDynamicStickerData)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = (TrackerStickerParam.MotionInfo)paramDynamicStickerData.mapMotionTrack.get(Long.valueOf(paramLong));
    paramDynamicStickerData = localMotionInfo;
    if (localMotionInfo == null) {
      paramDynamicStickerData = new TrackerStickerParam.MotionInfo(true, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
    }
    return paramDynamicStickerData;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  @TargetApi(17)
  public void onDrawFrame()
  {
    long l2;
    long l3;
    if ((this.bwork) && (this.mRenderFBO != null))
    {
      l2 = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
      l3 = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp();
      l1 = getQQFilterRenderManager().getBusinessOperation().getVideoStartTime();
      l3 /= 1000000L;
      if (l3 <= l1) {
        break label432;
      }
    }
    label420:
    label425:
    label432:
    for (long l1 = l3 - l1;; l1 = 0L)
    {
      if ((this.mDynamicStickers != null) && (this.mDynamicStickers.size() > 0)) {}
      for (;;)
      {
        int j;
        try
        {
          this.mRenderFBO.setTexId(this.mInputTextureID);
          this.mRenderFBO.bind();
          j = 0;
          if (j < this.mDynamicStickers.size())
          {
            Bitmap localBitmap = ((DynamicStickerData)this.mDynamicStickers.get(j)).mGifDecoder.getNextGifFrame(l2);
            if (!((DynamicStickerData)this.mDynamicStickers.get(j)).isShow((int)l1)) {
              break label425;
            }
            DynamicStickerData localDynamicStickerData = (DynamicStickerData)this.mDynamicStickers.get(j);
            if (localDynamicStickerData.mapMotionTrack.size() == 0) {
              break label420;
            }
            TrackerStickerParam.MotionInfo localMotionInfo = getTrackerPoint(l2, localDynamicStickerData);
            if (!localMotionInfo.isLost)
            {
              this.mvpMatrix[j] = caculateMatrix(localDynamicStickerData, localMotionInfo);
              i = 0;
              if ((localBitmap == null) || (i != 0)) {
                break label425;
              }
              GLES20.glBindTexture(3553, this.textureId);
              GlUtil.checkGlError("glBindTexture " + this.textureId);
              GLES20.glTexParameterf(3553, 10241, 9729.0F);
              GLES20.glTexParameterf(3553, 10240, 9729.0F);
              GLES20.glTexParameteri(3553, 10242, 33071);
              GLES20.glTexParameteri(3553, 10243, 33071);
              GLUtils.texImage2D(3553, 0, localBitmap, 0);
              GlUtil.checkGlError("glTexParameter");
              this.mMultiStickerFilter.drawTexture(this.textureId, this.textureMatrix, this.mvpMatrix[j]);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          this.mOutputTextureID = this.mInputTextureID;
        }
        for (;;)
        {
          this.mOutputTextureID = this.mInputTextureID;
          return;
          i = 1;
          break;
          this.mRenderFBO.unbind();
          this.mOutputTextureID = this.mRenderFBO.getTexId();
        }
        this.mOutputTextureID = this.mInputTextureID;
        return;
        int i = 0;
        continue;
        j += 1;
      }
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    this.textureId = GlUtil.createTexture(3553);
    if ((paramInt1 != this.mSurfaceWidth) || (paramInt2 != this.mSurfaceHeight))
    {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      this.mRenderFBO = null;
      this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
      paramInt1 = 0;
      while (paramInt1 < this.mDynamicStickers.size())
      {
        this.mvpMatrix[paramInt1] = caculateMatrix((DynamicStickerData)this.mDynamicStickers.get(paramInt1), null);
        paramInt1 += 1;
      }
    }
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    Object localObject;
    if (this.mMultiStickerFilter == null)
    {
      this.mMultiStickerFilter = new GPUAlphaBlendFilter();
      this.mMultiStickerFilter.init();
      localObject = this.mMultiStickerFilter;
      GPUAlphaBlendFilter.checkGlError("filter init");
    }
    this.mSurfaceWidth = getQQFilterRenderManager().getSufaceWidth();
    this.mSurfaceHeight = getQQFilterRenderManager().getSurfaceHeight();
    int i;
    if (this.mDynamicStickers != null)
    {
      i = 0;
      while (i < this.mDynamicStickers.size())
      {
        this.mvpMatrix[i] = caculateMatrix((DynamicStickerData)this.mDynamicStickers.get(i), null);
        i += 1;
      }
    }
    try
    {
      i = GLES20.glGetError();
      if (i != 0)
      {
        localObject = "previousUnknownError: glError 0x" + Integer.toHexString(i);
        SLog.e(TAG, (String)localObject);
      }
      this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.mRenderFBO = null;
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.mMultiStickerFilter.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDynamicStickersFilter
 * JD-Core Version:    0.7.0.1
 */
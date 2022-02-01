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
    Object localObject = new GlMatricUtil();
    ((GlMatricUtil)localObject).ortho(f3 * -1.0F, f3 * 1.0F, -1.0F, 1.0F, 3.0F, 20.0F);
    ((GlMatricUtil)localObject).setCamera(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    float f2 = paramDynamicStickerData.centerP.x + paramDynamicStickerData.translateX;
    float f1 = paramDynamicStickerData.centerP.y + paramDynamicStickerData.translateY;
    if (paramMotionInfo != null)
    {
      f2 = paramMotionInfo.x;
      f1 = paramMotionInfo.y;
    }
    f2 = f2 * 2.0F / paramDynamicStickerData.layerWidth;
    f1 = f1 * 2.0F / paramDynamicStickerData.layerHeight;
    if (this.mbReversed) {
      ((GlMatricUtil)localObject).translate((f2 - 1.0F) * f3, f1 - 1.0F, 0.0F);
    } else {
      ((GlMatricUtil)localObject).translate((f2 - 1.0F) * f3, 1.0F - f1, 0.0F);
    }
    float f4 = this.mSurfaceWidth / paramDynamicStickerData.layerWidth;
    f1 = this.mSurfaceHeight / paramDynamicStickerData.layerHeight;
    float f5 = paramDynamicStickerData.width / this.mSurfaceWidth;
    f2 = paramDynamicStickerData.height / this.mSurfaceHeight;
    f3 = paramDynamicStickerData.scale * f4 * f5 * f3;
    f1 = paramDynamicStickerData.scale * f1 * f2;
    ((GlMatricUtil)localObject).rotate(paramDynamicStickerData.rotate, 0.0F, 0.0F, 1.0F);
    ((GlMatricUtil)localObject).scale(f3, f1, 1.0F);
    paramDynamicStickerData = new StringBuilder();
    paramDynamicStickerData.append("finalScaleX : ");
    paramDynamicStickerData.append(f3);
    paramDynamicStickerData.append(" finalScaleY:");
    paramDynamicStickerData.append(f1);
    SLog.d("giftrackerMatrix ", paramDynamicStickerData.toString());
    paramMotionInfo = ((GlMatricUtil)localObject).getFinalMatrix();
    int i = 0;
    paramDynamicStickerData = "mvp: ";
    while (i < 16)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramDynamicStickerData);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMotionInfo[i]);
      paramDynamicStickerData = ((StringBuilder)localObject).toString();
      i += 1;
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
    long l1;
    Object localObject1;
    if ((this.bwork) && (this.mRenderFBO != null))
    {
      l2 = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
      long l3 = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp();
      l1 = getQQFilterRenderManager().getBusinessOperation().getVideoStartTime();
      l3 /= 1000000L;
      if (l3 > l1) {
        l1 = l3 - l1;
      } else {
        l1 = 0L;
      }
      localObject1 = this.mDynamicStickers;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {}
    }
    try
    {
      this.mRenderFBO.setTexId(this.mInputTextureID);
      this.mRenderFBO.bind();
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i;
        Object localObject2;
        TrackerStickerParam.MotionInfo localMotionInfo;
        label413:
        continue;
        int j = 1;
        continue;
        j = 0;
        continue;
        i += 1;
      }
    }
    if (i < this.mDynamicStickers.size())
    {
      localObject1 = ((DynamicStickerData)this.mDynamicStickers.get(i)).mGifDecoder.getNextGifFrame(l2);
      if (!((DynamicStickerData)this.mDynamicStickers.get(i)).isShow((int)l1)) {
        break label446;
      }
      localObject2 = (DynamicStickerData)this.mDynamicStickers.get(i);
      if (((DynamicStickerData)localObject2).mapMotionTrack.size() == 0) {
        break label441;
      }
      localMotionInfo = getTrackerPoint(l2, (DynamicStickerData)localObject2);
      if (!localMotionInfo.isLost)
      {
        this.mvpMatrix[i] = caculateMatrix((DynamicStickerData)localObject2, localMotionInfo);
        break label441;
        if ((localObject1 == null) || (j != 0)) {
          break label446;
        }
        GLES20.glBindTexture(3553, this.textureId);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("glBindTexture ");
        ((StringBuilder)localObject2).append(this.textureId);
        GlUtil.checkGlError(((StringBuilder)localObject2).toString());
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
        GlUtil.checkGlError("glTexParameter");
        this.mMultiStickerFilter.drawTexture(this.textureId, this.textureMatrix, this.mvpMatrix[i]);
        break label446;
      }
    }
    else
    {
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      break label413;
      this.mOutputTextureID = this.mInputTextureID;
      this.mOutputTextureID = this.mInputTextureID;
      return;
      this.mOutputTextureID = this.mInputTextureID;
      return;
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("previousUnknownError: glError 0x");
        ((StringBuilder)localObject).append(Integer.toHexString(i));
        localObject = ((StringBuilder)localObject).toString();
        SLog.e(TAG, (String)localObject);
      }
      this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
      return;
    }
    catch (Throwable localThrowable)
    {
      label183:
      break label183;
    }
    this.mRenderFBO = null;
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.mMultiStickerFilter.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDynamicStickersFilter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Map;

public class QQTrackerStickersFilter
  extends QQBaseFilter
{
  private static String TAG = "QQTrackerStickersFilter";
  private boolean bwork = false;
  private ArrayList<TrackerStickerParam> listStickers;
  private GPUAlphaBlendFilter mMultiStickerFilter;
  private RenderBuffer mRenderFBO;
  private int mSurfaceHeight = 0;
  private int mSurfaceWidth = 0;
  private boolean mbReversed = true;
  private float[][] mvpMatrix;
  private int[] textureId;
  private float[] textureMatrix = null;
  
  public QQTrackerStickersFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public void InitTrackerStickers(ArrayList<TrackerStickerParam> paramArrayList)
  {
    this.listStickers = paramArrayList;
    paramArrayList = this.listStickers;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.textureId = new int[this.listStickers.size()];
      this.mvpMatrix = new float[this.listStickers.size()][];
      this.bwork = true;
    }
    else
    {
      this.bwork = false;
      SLog.i(TAG, "TrackerStickerParam is null or zero");
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
  
  public float[] caculateMatrix(TrackerStickerParam paramTrackerStickerParam, TrackerStickerParam.MotionInfo paramMotionInfo)
  {
    float f1 = this.mSurfaceWidth / this.mSurfaceHeight;
    Object localObject = new GlMatricUtil();
    ((GlMatricUtil)localObject).ortho(f1 * -1.0F, f1 * 1.0F, -1.0F, 1.0F, 3.0F, 20.0F);
    ((GlMatricUtil)localObject).setCamera(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    float f2 = paramMotionInfo.x * 2.0F / paramTrackerStickerParam.layerWidth;
    float f3 = paramMotionInfo.y * 2.0F / paramTrackerStickerParam.layerHeight;
    if (this.mbReversed) {
      ((GlMatricUtil)localObject).translate((f2 - 1.0F) * f1, f3 - 1.0F, 0.0F);
    } else {
      ((GlMatricUtil)localObject).translate((f2 - 1.0F) * f1, 1.0F - f3, 0.0F);
    }
    float f4 = this.mSurfaceWidth / paramTrackerStickerParam.layerWidth;
    f2 = this.mSurfaceHeight / paramTrackerStickerParam.layerHeight;
    float f5 = paramTrackerStickerParam.width / this.mSurfaceWidth;
    f3 = paramTrackerStickerParam.height / this.mSurfaceHeight;
    f1 = paramTrackerStickerParam.scale * f4 * f5 * f1;
    f2 = paramTrackerStickerParam.scale * f2 * f3;
    ((GlMatricUtil)localObject).rotate(paramTrackerStickerParam.rotate, 0.0F, 0.0F, 1.0F);
    ((GlMatricUtil)localObject).scale(f1, f2, 1.0F);
    paramTrackerStickerParam = new StringBuilder();
    paramTrackerStickerParam.append("finalScaleX : ");
    paramTrackerStickerParam.append(f1);
    paramTrackerStickerParam.append(" finalScaleY:");
    paramTrackerStickerParam.append(f2);
    SLog.d("trackerMatrix ", paramTrackerStickerParam.toString());
    paramMotionInfo = ((GlMatricUtil)localObject).getFinalMatrix();
    int i = 0;
    paramTrackerStickerParam = "mvp: ";
    while (i < 16)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTrackerStickerParam);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMotionInfo[i]);
      paramTrackerStickerParam = ((StringBuilder)localObject).toString();
      i += 1;
    }
    SLog.d("trackerMatrix ", paramTrackerStickerParam);
    return paramMotionInfo;
  }
  
  TrackerStickerParam.MotionInfo getTrackerPoint(long paramLong, TrackerStickerParam paramTrackerStickerParam)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = (TrackerStickerParam.MotionInfo)paramTrackerStickerParam.mapMotionTrack.get(Long.valueOf(paramLong));
    paramTrackerStickerParam = localMotionInfo;
    if (localMotionInfo == null) {
      paramTrackerStickerParam = new TrackerStickerParam.MotionInfo(true, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
    }
    return paramTrackerStickerParam;
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
    long l1;
    if (this.bwork)
    {
      l2 = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp();
      l3 = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
      l1 = getQQFilterRenderManager().getBusinessOperation().getVideoStartTime();
      long l4 = l2 / 1000000L;
      if (l4 > l1) {
        l1 = l4 - l1;
      } else {
        l1 = 0L;
      }
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
        TrackerStickerParam localTrackerStickerParam;
        TrackerStickerParam.MotionInfo localMotionInfo;
        float f1;
        float f2;
        float f3;
        float f4;
        int j;
        continue;
        i += 1;
      }
    }
    if (i < this.listStickers.size())
    {
      localTrackerStickerParam = (TrackerStickerParam)this.listStickers.get(i);
      if (localTrackerStickerParam.isShow((int)l1)) {
        if ((localTrackerStickerParam.mapMotionTrack != null) && (localTrackerStickerParam.mapMotionTrack.size() != 0))
        {
          localMotionInfo = getTrackerPoint(l2, localTrackerStickerParam);
          if (!localMotionInfo.isLost)
          {
            this.mvpMatrix[i] = caculateMatrix(localTrackerStickerParam, localMotionInfo);
            GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
            this.mMultiStickerFilter.drawTexture(this.textureId[i], this.textureMatrix, this.mvpMatrix[i]);
          }
        }
        else
        {
          f1 = localTrackerStickerParam.centerP.x;
          f2 = localTrackerStickerParam.translateXValue;
          f3 = localTrackerStickerParam.centerP.y;
          f4 = localTrackerStickerParam.translateYValue;
          j = i;
          localMotionInfo = new TrackerStickerParam.MotionInfo(false, l3, f1 + f2, f3 + f4, 1.0F, 0.0F);
          this.mvpMatrix[j] = caculateMatrix(localTrackerStickerParam, localMotionInfo);
          GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
          this.mMultiStickerFilter.drawTexture(this.textureId[j], this.textureMatrix, this.mvpMatrix[j]);
        }
      }
    }
    else
    {
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return;
      this.mOutputTextureID = this.mInputTextureID;
      return;
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    if ((paramInt1 != this.mSurfaceWidth) || (paramInt2 != this.mSurfaceHeight))
    {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      this.mRenderFBO = null;
      this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
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
    int i;
    if (this.listStickers != null)
    {
      i = 0;
      while (i < this.listStickers.size())
      {
        localObject = BitmapFactory.decodeFile(((TrackerStickerParam)this.listStickers.get(i)).path);
        if (localObject != null) {
          this.textureId[i] = GlUtil.createTexture(3553, (Bitmap)localObject);
        }
        i += 1;
      }
    }
    this.mSurfaceWidth = getQQFilterRenderManager().getSufaceWidth();
    this.mSurfaceHeight = getQQFilterRenderManager().getSurfaceHeight();
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
      label192:
      break label192;
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
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQTrackerStickersFilter
 * JD-Core Version:    0.7.0.1
 */
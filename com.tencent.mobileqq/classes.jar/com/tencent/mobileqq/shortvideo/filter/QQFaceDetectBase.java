package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;

public class QQFaceDetectBase
  extends QQBaseFilter
{
  public static final int FACE_DETECT_OFF = 2;
  public static final int FACE_DETECT_ON = 1;
  private boolean isCaptureMode = false;
  boolean isInit = false;
  private int lastFrameHeight = 0;
  private int lastFrameWidth = 0;
  private BaseFilter mCopyFilter = null;
  private int mDetectCount = 0;
  private int mFaceDetectType = 1;
  private BaseFilter mFlipFilter = null;
  private boolean mNeedDetectCount = false;
  private boolean needFlip = true;
  
  public QQFaceDetectBase(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(-1, paramQQFilterRenderManager);
  }
  
  public void onDrawFrame()
  {
    int j = 1;
    int i = 1;
    label79:
    label248:
    Frame localFrame2;
    if ((!this.isInit) && (FeatureManager.loadBasicFeatures()))
    {
      if (this.mFlipFilter == null)
      {
        this.mFlipFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
        this.mFlipFilter.apply();
        this.mFlipFilter.setRotationAndFlip(0, 0, 1);
        if (this.mCopyFilter != null) {
          break label386;
        }
        this.mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
        this.mCopyFilter.apply();
        this.isInit = true;
      }
    }
    else if (this.isInit)
    {
      QQFilterLogManager.setPTVStart();
      if (!this.needFlip) {
        break label396;
      }
      localFrame1 = this.mFlipFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      label134:
      QQFilterLogManager.setPTVEnd("第一次翻转texture耗时");
      getQQFilterRenderManager().setFaceDetectFlags(true);
      getQQFilterRenderManager().initDetectFaceSDK(localFrame1);
      if ((this.lastFrameWidth != localFrame1.width) || (this.lastFrameHeight != localFrame1.height)) {
        getQQFilterRenderManager().initDetectFaceSDK(localFrame1);
      }
      this.lastFrameWidth = localFrame1.width;
      this.lastFrameHeight = localFrame1.height;
      QQFilterLogManager.setPTVEnd("人脸sdk耗时");
      if ((this.mNeedDetectCount) && (getQQFilterRenderManager().hasAEDetectorInited())) {
        this.mDetectCount += 1;
      }
      if (this.mNeedDetectCount)
      {
        if (this.mDetectCount < 2) {
          break label425;
        }
        j = i;
        if (i != 0)
        {
          this.mNeedDetectCount = false;
          this.mDetectCount = 0;
          SLog.d("QQFaceDetectBase", "reset mNeedDetectCount!");
          j = i;
        }
      }
      PTFaceAttr localPTFaceAttr = getQQFilterRenderManager().getFaceAttr();
      localFrame2 = localFrame1;
      if (getQQFilterRenderManager().hasAEDetectorInited())
      {
        localFrame2 = localFrame1;
        if (localPTFaceAttr != null)
        {
          localFrame2 = localFrame1;
          if (localPTFaceAttr.getFaceCount() > 0)
          {
            localFrame2 = localFrame1;
            if (j != 0) {
              localFrame2 = getQQFilterRenderManager().getFaceAttr().getOrigFrame();
            }
          }
        }
      }
      if (!this.needFlip) {
        break label430;
      }
    }
    label386:
    label396:
    label425:
    label430:
    for (Frame localFrame1 = this.mFlipFilter.RenderProcess(localFrame2.getTextureId(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());; localFrame1 = this.mCopyFilter.RenderProcess(localFrame2.getTextureId(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight()))
    {
      this.mOutputTextureID = localFrame1.getTextureId();
      return;
      this.mFlipFilter.ClearGLSL();
      break;
      this.mCopyFilter.ClearGLSL();
      break label79;
      localFrame1 = this.mCopyFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      break label134;
      i = 0;
      break label248;
    }
  }
  
  public void setCaptureMode(boolean paramBoolean)
  {
    this.isCaptureMode = paramBoolean;
  }
  
  public void setFaceDetectType(int paramInt)
  {
    if ((this.mFaceDetectType == 2) && (paramInt == 1))
    {
      this.mNeedDetectCount = true;
      this.mDetectCount = 0;
      SLog.d("QQFaceDetectBase", "mNeedDetectCount on!");
    }
    this.mFaceDetectType = paramInt;
  }
  
  public void setInputTextureID(int paramInt)
  {
    super.setInputTextureID(paramInt);
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void setNeedFlip(boolean paramBoolean)
  {
    this.needFlip = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDetectBase
 * JD-Core Version:    0.7.0.1
 */
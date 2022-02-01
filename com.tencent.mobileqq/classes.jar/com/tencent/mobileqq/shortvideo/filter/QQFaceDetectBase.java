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
    boolean bool = this.isInit;
    int j = 1;
    int i = 1;
    Object localObject1;
    if ((!bool) && (FeatureManager.loadBasicFeatures()))
    {
      localObject1 = this.mFlipFilter;
      if (localObject1 == null) {
        this.mFlipFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
      } else {
        ((BaseFilter)localObject1).clearGLSL();
      }
      this.mFlipFilter.apply();
      this.mFlipFilter.setRotationAndFlip(0, 0, 1);
      localObject1 = this.mCopyFilter;
      if (localObject1 == null) {
        this.mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
      } else {
        ((BaseFilter)localObject1).clearGLSL();
      }
      this.mCopyFilter.apply();
      this.isInit = true;
    }
    if (this.isInit)
    {
      QQFilterLogManager.setPTVStart();
      if (this.needFlip) {
        localObject1 = this.mFlipFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      } else {
        localObject1 = this.mCopyFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      }
      QQFilterLogManager.setPTVEnd("第一次翻转texture耗时");
      getQQFilterRenderManager().setFaceDetectFlags(true);
      getQQFilterRenderManager().initDetectFaceSDK((Frame)localObject1);
      if ((this.lastFrameWidth != ((Frame)localObject1).width) || (this.lastFrameHeight != ((Frame)localObject1).height)) {
        getQQFilterRenderManager().initDetectFaceSDK((Frame)localObject1);
      }
      this.lastFrameWidth = ((Frame)localObject1).width;
      this.lastFrameHeight = ((Frame)localObject1).height;
      QQFilterLogManager.setPTVEnd("人脸sdk耗时");
      if ((this.mNeedDetectCount) && (getQQFilterRenderManager().hasAEDetectorInited())) {
        this.mDetectCount += 1;
      }
      if (this.mNeedDetectCount)
      {
        if (this.mDetectCount < 2) {
          i = 0;
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
      Object localObject2 = localObject1;
      if (getQQFilterRenderManager().hasAEDetectorInited())
      {
        localObject2 = localObject1;
        if (localPTFaceAttr != null)
        {
          localObject2 = localObject1;
          if (localPTFaceAttr.getFaceCount() > 0)
          {
            localObject2 = localObject1;
            if (j != 0) {
              localObject2 = getQQFilterRenderManager().getFaceAttr().getOrigFrame();
            }
          }
        }
      }
      if (this.needFlip) {
        localObject1 = this.mFlipFilter.RenderProcess(((Frame)localObject2).getTextureId(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      } else {
        localObject1 = this.mCopyFilter.RenderProcess(((Frame)localObject2).getTextureId(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      }
      this.mOutputTextureID = ((Frame)localObject1).getTextureId();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDetectBase
 * JD-Core Version:    0.7.0.1
 */
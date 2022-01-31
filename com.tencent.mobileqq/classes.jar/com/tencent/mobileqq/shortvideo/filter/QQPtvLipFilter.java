package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.FaceFeatureAndTeethWhitenFilterSingle;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.LIPS_SEG_TPYE;
import java.io.File;

public class QQPtvLipFilter
  extends QQBaseFilter
{
  private final String TAG = "QQPtBeautyLipFilter";
  private boolean filterWork = false;
  Logger logger;
  private BaseFilter mCopyFaceFilter = null;
  private BaseFilter mFlipFaceFilter = null;
  private int[] mFlipFaceTextureID = new int[1];
  private boolean mHasInit = false;
  private Frame mInPutFrame;
  FaceFeatureAndTeethWhitenFilterSingle mLipsFilter;
  QQFilterRenderManager mManager;
  private String mMaskDir;
  private Frame mOutFrame;
  private boolean mShouldRender = false;
  private boolean needFlip = true;
  
  public QQPtvLipFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(186, paramQQFilterRenderManager);
    this.mManager = paramQQFilterRenderManager;
    this.mLipsFilter = new FaceFeatureAndTeethWhitenFilterSingle();
    this.logger = SdkContext.getInstance().getLogger();
    this.mMaskDir = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    this.logger.d("QQPtBeautyLipFilter", "mMaskDir:" + this.mMaskDir);
    this.mLipsFilter.setMaskDir(this.mMaskDir);
    this.mInPutFrame = new Frame();
    this.mOutFrame = new Frame();
  }
  
  private void init()
  {
    if ((this.mManager != null) && (this.mManager.loadFilterSoSuccess()))
    {
      GLES20.glGenTextures(this.mFlipFaceTextureID.length, this.mFlipFaceTextureID, 0);
      if (this.mFlipFaceFilter != null) {
        break label112;
      }
      this.mFlipFaceFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
      this.mFlipFaceFilter.apply();
      this.mFlipFaceFilter.setRotationAndFlip(0, 0, 1);
      if (this.mCopyFaceFilter != null) {
        break label122;
      }
      this.mCopyFaceFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
    }
    for (;;)
    {
      this.mCopyFaceFilter.apply();
      this.mLipsFilter.ApplyGLSLFilter();
      this.mHasInit = true;
      return;
      label112:
      this.mFlipFaceFilter.ClearGLSL();
      break;
      label122:
      this.mCopyFaceFilter.ClearGLSL();
    }
  }
  
  public int getOutputTextureID()
  {
    return super.getOutputTextureID();
  }
  
  public boolean isFilterWork()
  {
    return this.filterWork;
  }
  
  public void onDrawFrame()
  {
    super.onDrawFrame();
    this.mOutputTextureID = this.mInputTextureID;
    if (!this.mHasInit) {
      init();
    }
    while ((!this.mShouldRender) || (this.mManager.getFaceAttr() == null)) {
      return;
    }
    if (this.needFlip) {
      this.mFlipFaceFilter.RenderProcess(this.mInputTextureID, this.mManager.getFilterWidth(), this.mManager.getFilterHeight(), this.mFlipFaceTextureID[0], 0.0D, this.mInPutFrame);
    }
    Frame localFrame;
    for (;;)
    {
      this.mLipsFilter.updateVideoSize(this.mManager.getFilterWidth(), this.mManager.getFilterHeight(), this.mManager.getWindowScale());
      localFrame = this.mLipsFilter.render(this.mInPutFrame, this.mManager.getFaceAttr().getAllFacePoints());
      if (!this.needFlip) {
        break;
      }
      this.mFlipFaceFilter.RenderProcess(localFrame.getTextureId(), this.mManager.getFilterWidth(), this.mManager.getFilterHeight(), this.mInputTextureID, 0.0D, this.mOutFrame);
      this.mOutputTextureID = this.mInputTextureID;
      return;
      this.mCopyFaceFilter.RenderProcess(this.mInputTextureID, this.mManager.getFilterWidth(), this.mManager.getFilterHeight(), this.mFlipFaceTextureID[0], 0.0D, this.mInPutFrame);
    }
    this.mOutputTextureID = localFrame.getTextureId();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    double d = this.mManager.getWindowScale();
    this.logger.d("QQPtBeautyLipFilter", "current faceScale:" + d);
    this.mLipsFilter.updateVideoSize(paramInt1, paramInt2, d);
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mHasInit)
    {
      GLES20.glDeleteTextures(this.mFlipFaceTextureID.length, this.mFlipFaceTextureID, 0);
      if (this.mFlipFaceFilter != null) {
        this.mFlipFaceFilter.ClearGLSL();
      }
      if (this.mCopyFaceFilter != null) {
        this.mCopyFaceFilter.ClearGLSL();
      }
      if (this.mLipsFilter != null) {
        this.mLipsFilter.clearGLSLSelf();
      }
      this.mHasInit = false;
      this.mShouldRender = false;
      this.mInPutFrame.clear();
      this.mInPutFrame = null;
      this.mOutFrame.clear();
    }
  }
  
  public void setNeedFlip(boolean paramBoolean)
  {
    this.needFlip = paramBoolean;
  }
  
  public void setUpCosmeticsAlpha(int paramInt)
  {
    this.mLipsFilter.setLipsLutAlpha(paramInt);
  }
  
  public void setVideoFilter(VideoMaterial paramVideoMaterial)
  {
    this.filterWork = false;
    if (!this.mHasInit)
    {
      init();
      return;
    }
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.getLipsSegType() == VideoMaterialUtil.LIPS_SEG_TPYE.MASK.value)
      {
        this.mLipsFilter.setLipsLut(paramVideoMaterial.getDataPath() + File.separator + paramVideoMaterial.getLipsLutPath());
        this.mShouldRender = true;
        this.filterWork = true;
      }
      for (;;)
      {
        this.mLipsFilter.setLipsLutAlpha(100);
        return;
        this.mLipsFilter.setLipsLut("");
        this.mShouldRender = false;
      }
    }
    this.mLipsFilter.setLipsLut("");
    this.mShouldRender = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtvLipFilter
 * JD-Core Version:    0.7.0.1
 */
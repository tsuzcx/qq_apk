package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.aekit.api.standard.filter.AESmooth;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUSkinRegionFilter;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;

public class QQPtNewBeautyFilter
  extends QQBaseFilter
{
  private static final String TAG = "QQPtNewBeautyFilter";
  private boolean bInit = false;
  private boolean busiSkinRegionOpen = true;
  private boolean bwork = false;
  private boolean faceDetectTool = false;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private AESmooth mBeautyFilter = new AESmooth();
  private VideoFilterBase mCopyFaceFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private VideoFilterBase mCopyFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame;
  private VideoFilterBase mFlipFaceFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int[] mFlipFaceTextureID = new int[1];
  private Frame mFlipFrame = new Frame();
  private Frame mInputFrame = new Frame();
  private int mProgress = 0;
  private boolean mSoReadyAndGetAuth = false;
  private boolean needFlip = true;
  private GPUSkinRegionFilter skinRegionFilter;
  private boolean skinRegionOpen = false;
  
  public QQPtNewBeautyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private boolean beNeedShowBeauty()
  {
    if (this.mProgress == 0) {}
    while ((QmcfManager.getInstance().isQmcfNoNeedBeauty()) || (getQQFilterRenderManager().getBusinessOperation().getAVFilterFilterType() == 3)) {
      return false;
    }
    return true;
  }
  
  private void clear()
  {
    if (this.bInit)
    {
      this.mInputFrame.clear();
      this.mBeautyFilter.clear();
      this.mCopyFilter.clearGLSLSelf();
      if ((this.skinRegionOpen) && (this.skinRegionFilter != null))
      {
        this.skinRegionFilter.release();
        this.skinRegionFilter = null;
      }
      this.bInit = false;
    }
  }
  
  private void clearFaceDetect()
  {
    GLES20.glDeleteTextures(this.mFlipFaceTextureID.length, this.mFlipFaceTextureID, 0);
    this.mFlipFaceFilter.clearGLSLSelf();
    this.mCopyFaceFilter.clearGLSLSelf();
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    if (getQQFilterRenderManager().loadFilterSoSuccess())
    {
      clear();
      this.mBeautyFilter = new AESmooth();
      this.mBeautyFilter.apply();
      this.mBeautyFilter.setSharpenSize(paramInt1, paramInt2);
      this.mCopyFilter.ApplyGLSLFilter();
      if (SdkContext.getInstance().getAppName().equals("DOV")) {
        this.skinRegionOpen = true;
      }
      if (this.skinRegionOpen)
      {
        if (this.skinRegionFilter == null) {
          this.skinRegionFilter = new GPUSkinRegionFilter();
        }
        this.skinRegionFilter.init();
        this.skinRegionFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      this.bInit = true;
      updateBeautyFilter(this.mProgress);
      SLog.d("QQPtNewBeautyFilter", "init by beauty");
      return;
    }
    SLog.e("QQPtNewBeautyFilter", "beauty init failed");
  }
  
  private void initFaceDetect()
  {
    GLES20.glGenTextures(this.mFlipFaceTextureID.length, this.mFlipFaceTextureID, 0);
    this.mFlipFaceFilter.clearGLSLSelf();
    this.mFlipFaceFilter.ApplyGLSLFilter();
    this.mFlipFaceFilter.setRotationAndFlip(0, false, true);
    this.mCopyFaceFilter.clearGLSLSelf();
    this.mCopyFaceFilter.ApplyGLSLFilter();
  }
  
  private void needReInit()
  {
    int i = getQQFilterRenderManager().getFilterWidth();
    int j = getQQFilterRenderManager().getFilterHeight();
    if ((this.lastWidth != i) || (this.lastHeight != j)) {
      init(i, j);
    }
  }
  
  public int getPtuBeautyLevel()
  {
    return this.mProgress;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public boolean needFaceDetect()
  {
    if (getQQFilterRenderManager().getBackCameraDetectEnable()) {
      if (this.mProgress <= 0) {}
    }
    do
    {
      return true;
      return false;
      if (getQQFilterRenderManager().getCameraID() != 1) {
        break;
      }
    } while (this.mProgress > 0);
    return false;
    return false;
  }
  
  public void onDrawFrame()
  {
    if (!this.mSoReadyAndGetAuth)
    {
      this.mSoReadyAndGetAuth = getQQFilterRenderManager().loadFilterSoSuccess();
      if (!this.mSoReadyAndGetAuth)
      {
        SLog.d("QQPtNewBeautyFilter", "onDrawFrame  mSoReadyAndGetAuth=" + this.mSoReadyAndGetAuth);
        this.mOutputTextureID = this.mInputTextureID;
        return;
      }
    }
    if (this.bInit) {
      needReInit();
    }
    if (!this.faceDetectTool)
    {
      initFaceDetect();
      this.faceDetectTool = true;
    }
    this.lastWidth = getQQFilterRenderManager().getFilterWidth();
    this.lastHeight = getQQFilterRenderManager().getFilterHeight();
    Object localObject = getQQFilterRenderManager().getFaceAttr();
    int i;
    if ((getQQFilterRenderManager().needFaceDetect()) && (localObject != null) && (((PTFaceAttr)localObject).getFaceCount() > 0)) {
      i = 1;
    }
    while ((i != 0) && (this.mBeautyFilter != null) && (beNeedShowBeauty())) {
      if (!this.bInit)
      {
        init(this.lastWidth, this.lastHeight);
        this.mOutputTextureID = this.mInputTextureID;
        return;
        i = 0;
      }
      else
      {
        BenchUtil.benchStart("mBeautyFilter");
        if (((PTFaceAttr)localObject).getAllFacePoints() != null) {
          if (this.needFlip)
          {
            this.mFlipFaceFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight, this.mFlipFaceTextureID[0], 0.0D, this.mFlipFrame);
            this.mBeautyFilter.setSharpenSize(this.lastWidth, this.lastHeight);
            this.mBeautyFilter.setFaceAttr((PTFaceAttr)localObject);
            localObject = this.mBeautyFilter.render(this.mFlipFrame);
            if (!this.needFlip) {
              break label429;
            }
            this.mFlipFaceFilter.RenderProcess(((Frame)localObject).getTextureId(), this.lastWidth, this.lastHeight, this.mInputTextureID, 0.0D, this.mInputFrame);
            this.mOutputTextureID = this.mInputTextureID;
          }
        }
        for (;;)
        {
          if ((this.skinRegionOpen) && (this.busiSkinRegionOpen) && (this.skinRegionFilter != null))
          {
            if (SLog.isEnable()) {
              SLog.d("QQPtNewBeautyFilter", "GPU Skin RegionFilter render region beauty");
            }
            this.mOutputTextureID = this.skinRegionFilter.mergeTexture(getQQFilterRenderManager().getFaceAttr().getAllFacePoints(), this.mInputTextureID, this.mOutputTextureID);
          }
          QQFilterLogManager.setFilterStatus("QQPtNewBeautyFilter", true);
          this.bwork = true;
          return;
          this.mCopyFaceFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight, this.mFlipFaceTextureID[0], 0.0D, this.mFlipFrame);
          break;
          label429:
          this.mOutputTextureID = ((Frame)localObject).getTextureId();
          continue;
          this.mOutputTextureID = this.mInputTextureID;
        }
      }
    }
    this.mOutputTextureID = this.mInputTextureID;
    QQFilterLogManager.setFilterStatus("QQPtNewBeautyFilter", false);
    this.bwork = false;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if ((this.lastHeight != paramInt1) || (this.lastHeight != paramInt2)) {
      init(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.bInit) {
      clear();
    }
    if (this.faceDetectTool) {
      clearFaceDetect();
    }
  }
  
  public void setBusiSkinRegionOpen(boolean paramBoolean)
  {
    this.busiSkinRegionOpen = paramBoolean;
  }
  
  public void setCaptureMode(boolean paramBoolean)
  {
    super.setCaptureMode(paramBoolean);
    this.mBeautyFilter.setmIsTakePhoto(paramBoolean);
  }
  
  public void setNeedFlip(boolean paramBoolean)
  {
    this.needFlip = paramBoolean;
  }
  
  public void updateBeautyFilter(int paramInt)
  {
    this.mProgress = paramInt;
    if (this.bInit) {
      this.mBeautyFilter.setSmoothLevel(paramInt);
    }
    if (SLog.isEnable()) {
      SLog.i("QQPtNewBeautyFilter", "setBeautyLevel blurAlpha: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtNewBeautyFilter
 * JD-Core Version:    0.7.0.1
 */
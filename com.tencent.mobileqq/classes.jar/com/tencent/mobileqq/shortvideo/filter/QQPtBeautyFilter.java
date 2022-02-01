package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUSkinRegionFilter;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.FaceBeautysRealAutoFilter;
import com.tencent.ttpic.openapi.model.CameraFilterParam;
import java.util.Map;

public class QQPtBeautyFilter
  extends QQBaseFilter
{
  private String TAG = "QQPtBeautyFilter";
  private boolean bInit = false;
  private boolean busiSkinRegionOpen = true;
  private boolean bwork = false;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private FaceBeautysRealAutoFilter mBeautyFilter = new FaceBeautysRealAutoFilter();
  private Frame mBeautyFrame = new Frame();
  private CameraFilterParam mBeautyParam = new CameraFilterParam();
  private int[] mBeautyTextureId = new int[1];
  private int mProgress = 0;
  private GPUSkinRegionFilter skinRegionFilter;
  private boolean skinRegionOpen = false;
  
  public QQPtBeautyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
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
    this.mBeautyFrame.clear();
    if (this.mBeautyFilter != null) {
      this.mBeautyFilter.ClearGLSL();
    }
    GLES20.glDeleteTextures(this.mBeautyTextureId.length, this.mBeautyTextureId, 0);
    if ((this.skinRegionOpen) && (this.skinRegionFilter != null))
    {
      this.skinRegionFilter.release();
      this.skinRegionFilter = null;
    }
    this.bInit = false;
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    if (getQQFilterRenderManager().loadFilterSoSuccess())
    {
      clear();
      this.mBeautyFilter.applyFilterChain(true, paramInt1, paramInt2);
      if (this.mBeautyFilter.getProgramIds() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (!Boolean.valueOf(bool).booleanValue()) {
          SLog.e(this.TAG, "ApplyGLSLFilter failed!");
        }
        this.mBeautyParam.smoothLevel = this.mProgress;
        Map localMap = this.mBeautyParam.getSmoothMap(this.mProgress);
        this.mBeautyFilter.setParameterDic(localMap);
        GLES20.glGenTextures(this.mBeautyTextureId.length, this.mBeautyTextureId, 0);
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
        SLog.d(this.TAG, "init by beauty");
        return;
      }
    }
    SLog.e(this.TAG, "beauty init failed");
  }
  
  public int getPtuBeautyLevel()
  {
    return this.mProgress;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    this.lastWidth = getQQFilterRenderManager().getFilterWidth();
    this.lastHeight = getQQFilterRenderManager().getFilterHeight();
    if ((this.mBeautyFilter != null) && (beNeedShowBeauty()))
    {
      if (!this.bInit)
      {
        init(this.lastWidth, this.lastHeight);
        this.mOutputTextureID = this.mInputTextureID;
        return;
      }
      BenchUtil.benchStart("mBeautyFilter");
      this.mBeautyFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight, this.mBeautyTextureId[0], 0.0D, this.mBeautyFrame);
      this.mOutputTextureID = this.mBeautyTextureId[0];
      if ((this.skinRegionOpen) && (this.busiSkinRegionOpen) && (this.skinRegionFilter != null))
      {
        if (SLog.isEnable()) {
          SLog.d(this.TAG, "GPU Skin RegionFilter render region beauty");
        }
        this.mOutputTextureID = this.skinRegionFilter.mergeTexture(getQQFilterRenderManager().getFaceAttr().getAllFacePoints(), this.mInputTextureID, this.mOutputTextureID);
      }
      QQFilterLogManager.setFilterStatus("QQPtBeautyFilter", true);
      this.bwork = true;
      return;
    }
    this.mOutputTextureID = this.mInputTextureID;
    QQFilterLogManager.setFilterStatus("QQPtBeautyFilter", false);
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
  }
  
  public void setBusiSkinRegionOpen(boolean paramBoolean)
  {
    this.busiSkinRegionOpen = paramBoolean;
  }
  
  public void updateBeautyFilter(int paramInt)
  {
    this.mProgress = paramInt;
    if (this.bInit)
    {
      this.mBeautyParam.smoothLevel = paramInt;
      Map localMap = this.mBeautyParam.getSmoothMap(paramInt);
      this.mBeautyFilter.setParameterDic(localMap);
    }
    if (SLog.isEnable()) {
      SLog.i(this.TAG, "setBeautyLevel " + this.mProgress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtBeautyFilter
 * JD-Core Version:    0.7.0.1
 */
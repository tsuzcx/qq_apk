package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceDetectTask;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.TreeSet;

public class QQFaceDanceMechineFilter
  extends QQBaseFilter
{
  public static boolean isEnableFaceDance = false;
  private DanceManagerFilter mDanceMgrFilter;
  private QQFaceDanceDetectFilter mFaceDanceDetectFilter;
  private RenderBuffer mRenderFBO;
  private boolean textureInited = false;
  private TextureRender textureRender;
  private int videoHeight = 1280;
  private int videoWidth = 720;
  
  public QQFaceDanceMechineFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    isEnableFaceDance = false;
    this.mDanceMgrFilter = new DanceManagerFilter(0, paramQQFilterRenderManager);
    this.mFaceDanceDetectFilter = new QQFaceDanceDetectFilter(0, paramQQFilterRenderManager);
  }
  
  private void initTexture()
  {
    if (this.mRenderFBO != null) {
      this.mRenderFBO.destroy();
    }
    if (this.textureRender != null) {
      this.textureRender.release();
    }
    this.mRenderFBO = new RenderBuffer(this.videoWidth, this.videoHeight, 33984);
    this.textureRender = new TextureRender();
  }
  
  private void onInternalChanged()
  {
    QQFilterRenderManager localQQFilterRenderManager = getQQFilterRenderManager();
    int i = localQQFilterRenderManager.getSufaceWidth();
    int j = localQQFilterRenderManager.getSurfaceHeight();
    this.videoWidth = localQQFilterRenderManager.getFilterWidth();
    this.videoHeight = localQQFilterRenderManager.getFilterHeight();
    this.mDanceMgrFilter.onSurfaceChange(i, j);
    this.mDanceMgrFilter.setViewportSize(this.videoWidth, this.videoHeight);
    float f = this.mDanceMgrFilter.getContext().getViewPortRatio();
    j = (int)(this.videoHeight / f);
    this.mDanceMgrFilter.onSurfaceChange(i, j);
  }
  
  private void onInternalCreate()
  {
    this.mDanceMgrFilter.onSurfaceCreate();
  }
  
  public void changeToReadyFilter()
  {
    this.mDanceMgrFilter.selectToFilter(0);
    this.mFaceDanceDetectFilter.clearFlipFrame();
    GLFrameImage.reloadTextureCache();
  }
  
  public boolean isFilterWork()
  {
    return isEnableFaceDance;
  }
  
  public void onCloseClicked()
  {
    int i = this.mDanceMgrFilter.getCurrentFilterKind();
    boolean bool = this.mDanceMgrFilter.getFilterParam();
    this.mDanceMgrFilter.onCloseClicked();
    if (i == 0)
    {
      QQDanceEventHandler localQQDanceEventHandler = getQQFilterRenderManager().getBusinessOperation().getDanceEventHandler();
      if (localQQDanceEventHandler != null) {
        localQQDanceEventHandler.closeEvent(bool);
      }
    }
  }
  
  public void onDrawFrame()
  {
    if (!isEnableFaceDance)
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if (!this.textureInited)
    {
      onInternalCreate();
      onInternalChanged();
      initTexture();
      this.textureInited = true;
    }
    this.mFaceDanceDetectFilter.setInputTextureID(this.mInputTextureID);
    this.mFaceDanceDetectFilter.onDrawFrame();
    this.mRenderFBO.bind();
    try
    {
      this.textureRender.drawTexture(3553, this.mInputTextureID, null, null);
      TreeSet localTreeSet = this.mDanceMgrFilter.getCurrentVisible();
      FaceDanceDetectTask.getInstance().updateDetectResult();
      this.mDanceMgrFilter.onDrawFrame();
      this.mRenderFBO.unbind();
      this.mFaceDanceDetectFilter.postDetectTask(localTreeSet);
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
    }
  }
  
  public void onPause()
  {
    FaceDanceDetectTask.loginfo("QQFaceDanceMechineFilter.onPause");
    this.mDanceMgrFilter.onPause();
  }
  
  public void onResume()
  {
    FaceDanceDetectTask.loginfo("QQFaceDanceMechineFilter.onResume");
    this.mDanceMgrFilter.onResume();
  }
  
  public void onSurfaceDestroy()
  {
    this.mFaceDanceDetectFilter.onSurfaceDestroy();
    GLShaderManager.clearShaderManager();
    GLFrameImage.clearTextureCache();
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQFaceDanceMechineFilter
 * JD-Core Version:    0.7.0.1
 */
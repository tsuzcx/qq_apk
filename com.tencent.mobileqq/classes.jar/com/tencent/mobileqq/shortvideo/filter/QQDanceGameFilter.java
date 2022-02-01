package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.DancePosture;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.Posture;
import com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter;
import com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate.MatchTemplate;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@TargetApi(18)
public class QQDanceGameFilter
  extends QQBaseFilter
{
  private static int IntervalNum = 2;
  private List<Vec3f> cachePoints = new ArrayList(18);
  private long detectCost = 0L;
  private DanceManagerFilter mDanceMgrFilter;
  private long mMatchInterval = 0L;
  private QQPoseDetectFilter mPoseDetectFilter;
  private RenderBuffer mRenderFBO;
  private long nextDetectTime = 0L;
  private long startDetectTime = 0L;
  private boolean textureInited = false;
  private TextureRender textureRender;
  private int videoHeight = 1280;
  private int videoWidth = 720;
  
  public QQDanceGameFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    this.mDanceMgrFilter = new DanceManagerFilter(0, paramQQFilterRenderManager);
    this.mPoseDetectFilter = new QQPoseDetectFilter(0, paramQQFilterRenderManager);
    this.mMatchInterval = 0L;
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
  
  private boolean needMatchVideoFrame()
  {
    if (this.mMatchInterval == 0L) {}
    while (SystemClock.elapsedRealtime() - this.mMatchInterval >= 300L) {
      return true;
    }
    return false;
  }
  
  private void onInternalChanged()
  {
    QQFilterRenderManager localQQFilterRenderManager = getQQFilterRenderManager();
    int i = localQQFilterRenderManager.getSufaceWidth();
    int j = localQQFilterRenderManager.getSurfaceHeight();
    this.videoWidth = localQQFilterRenderManager.getFilterWidth();
    this.videoHeight = localQQFilterRenderManager.getFilterHeight();
    this.mPoseDetectFilter.onSurfaceChange(this.videoWidth, this.videoHeight);
    this.mDanceMgrFilter.onSurfaceChange(i, j);
    this.mDanceMgrFilter.setViewportSize(this.videoWidth, this.videoHeight);
    float f = this.mDanceMgrFilter.getContext().getViewPortRatio();
    j = (int)(this.videoHeight / f);
    this.mDanceMgrFilter.onSurfaceChange(i, j);
  }
  
  private void onInternalCreate()
  {
    this.mPoseDetectFilter.onSurfaceCreate();
    this.mDanceMgrFilter.onSurfaceCreate();
  }
  
  public void changeToReadyFilter()
  {
    this.mMatchInterval = 0L;
    this.mDanceMgrFilter.selectToFilter(0);
    GLFrameImage.reloadTextureCache();
    DanceLog.printFrameQueue("GLFrameImage", "changeToReadyFilter: reloadTextureCache");
    BadcaseReportUtils.resetSamplingParam();
  }
  
  public float[] getKeyPoints()
  {
    return this.mPoseDetectFilter.getKeyPoints();
  }
  
  public boolean isFilterWork()
  {
    return QmcfManager.getInstance().getCurrQmcfMode() == 2;
  }
  
  public void onCloseClicked()
  {
    int i = this.mDanceMgrFilter.getCurrentFilterKind();
    boolean bool = this.mDanceMgrFilter.getFilterParam();
    DanceLog.print("QQDanceGameFilter", "onCloseClicked isReady=" + bool);
    this.mDanceMgrFilter.onCloseClicked();
    if (i == 0)
    {
      QQDanceEventHandler localQQDanceEventHandler = getQQFilterRenderManager().getBusinessOperation().getDanceEventHandler();
      if (localQQDanceEventHandler != null)
      {
        DanceLog.print("QQDanceGameFilter", "onCloseClicked call closeEvent");
        localQQDanceEventHandler.closeEvent(bool);
        DanceLog.print("QQDanceGameFilter", "onCloseClicked call closeEvent ...");
      }
    }
  }
  
  public void onDrawFrame()
  {
    Iterator localIterator = null;
    if (QmcfManager.getInstance().getCurrQmcfMode() != 2)
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
    boolean bool = needMatchVideoFrame();
    if (!bool) {
      Log.i("onDrawFrame", "onDrawFrame[Dance]: needMatchInterval300" + bool);
    }
    this.startDetectTime = System.currentTimeMillis();
    if ((!QmcfManager.FrameExtraction) || (this.startDetectTime >= this.nextDetectTime))
    {
      this.mPoseDetectFilter.setInputTextureID(this.mInputTextureID);
      if ((bool) && (this.mDanceMgrFilter.getCurrentFilterKind() != 2)) {
        this.mPoseDetectFilter.onDrawFrame();
      }
      this.detectCost = (System.currentTimeMillis() - this.startDetectTime);
      this.nextDetectTime = (this.startDetectTime + IntervalNum * this.detectCost);
    }
    this.mRenderFBO.bind();
    this.textureRender.drawTexture(3553, this.mInputTextureID, null, null);
    Object localObject2 = this.mDanceMgrFilter.getCurrentVisible();
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = localIterator;
    Object localObject3;
    if (bool)
    {
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localObject1 = getKeyPoints();
        localIterator = ((TreeSet)localObject2).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (GLLittleBoy)localIterator.next();
            if (((GLLittleBoy)localObject2).needDoMatch())
            {
              localObject3 = ((GLLittleBoy)localObject2).getDanceData();
              if (localObject3 != null)
              {
                localObject3 = ResourceManager.getInstance().getPostureById(((ResourceManager.DancePosture)localObject3).id);
                if (localObject3 != null)
                {
                  List localList = ((ResourceManager.Posture)localObject3).gestureConfigs;
                  PoseDataConvert.convertToVec3f(PoseDataConvert.convertPointsToFrameCoordinate((float[])localObject1, this.mRenderFBO.getWidth(), this.mRenderFBO.getHeight(), this.mPoseDetectFilter.getPoseInitWidth(), this.mPoseDetectFilter.getPoseInitHeight()), this.cachePoints);
                  bool = MatchTemplate.getInstance().multiMatch(this.cachePoints, localList, this.mRenderFBO.getWidth());
                  ((GLLittleBoy)localObject2).setMatch(bool);
                  if (bool)
                  {
                    this.mMatchInterval = SystemClock.elapsedRealtime();
                    BadcaseReportUtils.releaseCurrentFrame();
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      BadcaseReportUtils.finishCurrentFrame(this.mRenderFBO.getTexId(), this.mRenderFBO.getWidth(), this.mRenderFBO.getHeight(), (float[])localObject1);
      BadcaseReportUtils.setCurrentRenderFilterKind(this.mDanceMgrFilter.getCurrentFilterKind());
      DanceLog.print("onDrawFrame", "[Match]cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      l = SystemClock.elapsedRealtime();
      this.mDanceMgrFilter.onDrawFrame();
      DanceLog.print("onDrawFrame", "[DanceMgrFilter]cost = " + (SystemClock.elapsedRealtime() - l) + " ms");
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return;
      if (BadcaseReportUtils.needDoSample()) {
        BadcaseReportUtils.initCurrentFrame();
      }
      BadcaseReportUtils.collectionBadCaseDetectCost(this.detectCost);
      BadcaseReportUtils.problemClassification(this.cachePoints, (ResourceManager.Posture)localObject3, ((GLLittleBoy)localObject2).mIndex);
      break;
    }
  }
  
  public void onPause()
  {
    this.mDanceMgrFilter.onPause();
  }
  
  public void onResume()
  {
    this.mDanceMgrFilter.onResume();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    DanceLog.printFrameQueue("GLFrameImage", "onSurfaceChange");
  }
  
  public void onSurfaceCreate()
  {
    DanceLog.printFrameQueue("GLFrameImage", "onSurfaceCreate");
  }
  
  public void onSurfaceDestroy()
  {
    this.mPoseDetectFilter.onSurfaceDestroy();
    GLShaderManager.clearShaderManager();
    DanceLog.printFrameQueue("GLFrameImage", "onSurfaceDestroy:clearShaderManager");
    GLFrameImage.clearTextureCache();
    DanceLog.printFrameQueue("GLFrameImage", "onSurfaceDestroy:clearTextureCache");
    this.mDanceMgrFilter.onSurfaceDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDanceGameFilter
 * JD-Core Version:    0.7.0.1
 */
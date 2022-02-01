package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class DanceManagerFilter
  extends DanceBaseFilter
{
  public static final int DANCE_FILTER_MAX = 2;
  public static final int DANCE_PLAY_INDEX = 1;
  public static final int DANCE_READY_INDEX = 0;
  public static final int DANCE_SCORE_INDEX = 2;
  private int mCurrentFilterIndex = 0;
  private ArrayList<DanceBaseFilter> mDanceFilterList = new ArrayList(5);
  private GLViewContext mGLViewContext = new GLViewContext();
  public DanceManagerFilter.GamePlayOutData mGamePlayOutData = new DanceManagerFilter.GamePlayOutData();
  private boolean mHasInitedResource;
  private int mHeight;
  private int mWidth;
  
  public DanceManagerFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    initManager(paramInt, paramQQFilterRenderManager);
    this.mHasInitedResource = false;
  }
  
  private void initManager(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.mDanceFilterList.add(new DanceReadyFilter(paramInt, paramQQFilterRenderManager));
    this.mDanceFilterList.add(new DancePlayFilter(paramInt, paramQQFilterRenderManager));
    this.mDanceFilterList.add(new DanceScoreFilter(paramInt, paramQQFilterRenderManager));
    this.mDanceFilterList.add(new DanceTestFilter(paramInt, paramQQFilterRenderManager));
    paramQQFilterRenderManager = this.mDanceFilterList.iterator();
    while (paramQQFilterRenderManager.hasNext()) {
      ((DanceBaseFilter)paramQQFilterRenderManager.next()).setDanceManager(this);
    }
  }
  
  private void printItem()
  {
    Iterator localIterator = this.mDanceFilterList.iterator();
    while (localIterator.hasNext())
    {
      DanceBaseFilter localDanceBaseFilter = (DanceBaseFilter)localIterator.next();
      if (localDanceBaseFilter != null) {
        DanceLog.printFrameQueue("DanceManagerFilter", "[printItem]mCurrentFilterIndex=" + this.mCurrentFilterIndex + " name: " + localDanceBaseFilter.getClass().getName());
      }
    }
  }
  
  private void rollbackStatusOnInitBeforeDraw()
  {
    ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).rollbackStatusCallOnInitFilter();
  }
  
  public GLViewContext getContext()
  {
    return this.mGLViewContext;
  }
  
  public int getCurrentFilterKind()
  {
    return this.mCurrentFilterIndex;
  }
  
  public TreeSet<GLLittleBoy> getCurrentVisible()
  {
    return ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).getCurrentVisible();
  }
  
  public boolean getFilterParam()
  {
    return ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).getFilterParam();
  }
  
  public void onChangeCamera(int paramInt)
  {
    ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).onChangeCamera(paramInt);
  }
  
  public void onCloseClicked()
  {
    ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).onCloseClicked();
  }
  
  public void onDrawFrame()
  {
    if (!this.mHasInitedResource)
    {
      TrAsyncTextureLoad.getInstance().onSurfaceCreate();
      this.mGLViewContext.loadSoundResource(ResourceManager.getInstance().getAllSound());
      Iterator localIterator = this.mDanceFilterList.iterator();
      while (localIterator.hasNext()) {
        ((DanceBaseFilter)localIterator.next()).onSurfaceCreate();
      }
      localIterator = this.mDanceFilterList.iterator();
      while (localIterator.hasNext()) {
        ((DanceBaseFilter)localIterator.next()).onSurfaceChange(this.mWidth, this.mHeight);
      }
      rollbackStatusOnInitBeforeDraw();
      this.mHasInitedResource = true;
    }
    this.mGLViewContext.executeDraw();
    ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).onDrawFrame();
    GLES20.glFinish();
  }
  
  public void onPause()
  {
    ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).onPause();
  }
  
  public void onResume()
  {
    ((DanceBaseFilter)this.mDanceFilterList.get(this.mCurrentFilterIndex)).onResume();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    this.mGLViewContext.setSurfaceSize(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void onSurfaceCreate() {}
  
  public void onSurfaceDestroy()
  {
    DanceLog.printFrameQueue("GLFrameImage", "[DanceMgrFilter]onSurfaceDestroy mHasInitedResource=" + this.mHasInitedResource);
    if (this.mHasInitedResource)
    {
      Iterator localIterator = this.mDanceFilterList.iterator();
      while (localIterator.hasNext()) {
        ((DanceBaseFilter)localIterator.next()).onSurfaceDestroy();
      }
      this.mGLViewContext.releaseSoundResource();
      TrAsyncTextureLoad.getInstance().onSurfaceDestroy();
    }
    this.mHasInitedResource = false;
  }
  
  public void selectNextFilter()
  {
    this.mCurrentFilterIndex += 1;
    if (this.mCurrentFilterIndex == this.mDanceFilterList.size() - 1) {
      throw new RuntimeException("Invalid index = " + this.mCurrentFilterIndex);
    }
    if (this.mHasInitedResource) {
      rollbackStatusOnInitBeforeDraw();
    }
  }
  
  public void selectTestFilter()
  {
    this.mCurrentFilterIndex = (this.mDanceFilterList.size() - 1);
    if (this.mHasInitedResource) {
      rollbackStatusOnInitBeforeDraw();
    }
  }
  
  public void selectToFilter(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.mCurrentFilterIndex = paramInt;
      if (this.mHasInitedResource) {
        rollbackStatusOnInitBeforeDraw();
      }
      return;
    }
    throw new RuntimeException("Invalid index = " + this.mCurrentFilterIndex);
  }
  
  public void setViewportSize(int paramInt1, int paramInt2)
  {
    this.mGLViewContext.setViewPort(new Rect(0, 0, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceManagerFilter
 * JD-Core Version:    0.7.0.1
 */
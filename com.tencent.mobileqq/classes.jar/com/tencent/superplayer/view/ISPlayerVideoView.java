package com.tencent.superplayer.view;

import android.view.Surface;
import android.view.View;

public abstract interface ISPlayerVideoView
{
  public abstract void addViewCallBack(ISPlayerVideoView.IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract boolean disableViewCallback();
  
  public abstract boolean enableViewCallback();
  
  public abstract View getRenderView();
  
  public abstract int getRenderViewHeight();
  
  public abstract int getRenderViewWidth();
  
  public abstract String getSerialNO();
  
  public abstract Surface getSurface();
  
  public abstract boolean isSurfaceReady();
  
  public abstract void removeViewCallBack(ISPlayerVideoView.IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void setDegree(int paramInt);
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setXYaxis(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.ISPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */
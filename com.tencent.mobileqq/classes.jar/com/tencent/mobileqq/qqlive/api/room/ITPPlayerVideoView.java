package com.tencent.mobileqq.qqlive.api.room;

import android.graphics.Rect;
import android.view.View;

public abstract interface ITPPlayerVideoView
{
  public static final int PLAYER_SCALE_BOTH_FULLSCREEN = 1;
  public static final int PLAYER_SCALE_ORIGINAL_FULLSCREEN = 2;
  public static final int PLAYER_SCALE_ORIGINAL_RATIO = 0;
  public static final int PLAYER_SCALE_ORIGINAL_RATIO_SQUARE = 3;
  
  public abstract void addSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback paramIVideoSurfaceCallback);
  
  public abstract void blackScreen(boolean paramBoolean);
  
  public abstract View getCurrentDisplayView();
  
  public abstract Rect getDisplayViewRect();
  
  public abstract int getViewRenderMode();
  
  public abstract void release();
  
  public abstract void removeSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback paramIVideoSurfaceCallback);
  
  public abstract boolean setDegree(int paramInt);
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
  
  public abstract void setRadio(int paramInt1, int paramInt2);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setXYAxis(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */
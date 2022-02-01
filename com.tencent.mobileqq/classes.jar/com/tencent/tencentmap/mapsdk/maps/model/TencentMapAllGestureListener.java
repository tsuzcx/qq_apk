package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.PointF;

public abstract interface TencentMapAllGestureListener
{
  public abstract boolean onDoubleTap(float paramFloat1, float paramFloat2);
  
  public abstract boolean onDoubleTapDown(float paramFloat1, float paramFloat2);
  
  public abstract boolean onDoubleTapMove(float paramFloat1, float paramFloat2);
  
  public abstract boolean onDoubleTapUp(float paramFloat1, float paramFloat2);
  
  public abstract boolean onDown(float paramFloat1, float paramFloat2);
  
  public abstract boolean onFling(float paramFloat1, float paramFloat2);
  
  public abstract boolean onLongPress(float paramFloat1, float paramFloat2);
  
  public abstract void onMapStable();
  
  public abstract boolean onMove(float paramFloat1, float paramFloat2);
  
  public abstract boolean onScroll(float paramFloat1, float paramFloat2);
  
  public abstract boolean onSingleTap(float paramFloat1, float paramFloat2);
  
  public abstract boolean onTwoFingerDown();
  
  public abstract boolean onTwoFingerMoveAgainst(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2);
  
  public abstract boolean onTwoFingerMoveHorizontal(float paramFloat);
  
  public abstract boolean onTwoFingerMoveVertical(float paramFloat);
  
  public abstract boolean onTwoFingerRotate(PointF paramPointF1, PointF paramPointF2, float paramFloat);
  
  public abstract boolean onTwoFingerSingleTap();
  
  public abstract boolean onTwoFingerUp();
  
  public abstract boolean onUp(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TencentMapAllGestureListener
 * JD-Core Version:    0.7.0.1
 */
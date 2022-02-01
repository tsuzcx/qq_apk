package com.tencent.qcircle.tavcut.view.ext;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/tavcut/view/ext/OnGestureListener;", "", "onDrag", "", "dx", "", "dy", "onFling", "startX", "startY", "velocityX", "velocityY", "onRotation", "focusX", "focusY", "angle", "onScale", "scaleFactor", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface OnGestureListener
{
  public abstract void onDrag(float paramFloat1, float paramFloat2);
  
  public abstract void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void onRotation(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void onScale(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void onScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.ext.OnGestureListener
 * JD-Core Version:    0.7.0.1
 */
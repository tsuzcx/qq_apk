package com.tencent.tavcut.view.ext;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/view/ext/OnGestureListener;", "", "onDrag", "", "dx", "", "dy", "onFling", "startX", "startY", "velocityX", "velocityY", "onRotation", "focusX", "focusY", "angle", "onScale", "scaleFactor", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface OnGestureListener
{
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.ext.OnGestureListener
 * JD-Core Version:    0.7.0.1
 */
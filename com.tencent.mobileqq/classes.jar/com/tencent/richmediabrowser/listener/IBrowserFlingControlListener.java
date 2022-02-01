package com.tencent.richmediabrowser.listener;

import android.graphics.RectF;

public abstract interface IBrowserFlingControlListener
{
  public abstract RectF getCurrentMatrixRectF();
  
  public abstract void startFling(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.listener.IBrowserFlingControlListener
 * JD-Core Version:    0.7.0.1
 */
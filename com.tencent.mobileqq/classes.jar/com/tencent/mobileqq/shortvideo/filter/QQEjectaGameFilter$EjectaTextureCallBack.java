package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.PointF;
import java.util.List;

public abstract interface QQEjectaGameFilter$EjectaTextureCallBack
{
  public abstract int[] getFaceCanvasTexture();
  
  public abstract boolean hasRegisteredEvent(String paramString);
  
  public abstract void onDetectFace(List<List<PointF>> paramList);
  
  public abstract void onDetectFaceDirection(int paramInt1, int paramInt2);
  
  public abstract int[] onDrawFrame();
  
  public abstract void testApi(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQEjectaGameFilter.EjectaTextureCallBack
 * JD-Core Version:    0.7.0.1
 */
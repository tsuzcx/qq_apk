package com.tencent.taveffect.core;

import android.graphics.Matrix;

public class TAVStickerRenderFilter
  extends TAVRendererFilter
{
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    this.xyMatrix = paramMatrix1;
    this.stMatrix = paramMatrix2;
    this.cropRect = paramTAVRectangle;
    this.alpha = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVStickerRenderFilter
 * JD-Core Version:    0.7.0.1
 */
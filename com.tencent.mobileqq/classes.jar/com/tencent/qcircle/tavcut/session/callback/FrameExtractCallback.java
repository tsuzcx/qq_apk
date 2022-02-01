package com.tencent.qcircle.tavcut.session.callback;

import android.graphics.Bitmap;

public abstract interface FrameExtractCallback
{
  public abstract void onExtractCanceled();
  
  public abstract void onExtractFailed();
  
  public abstract void onFrameExtracted(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.callback.FrameExtractCallback
 * JD-Core Version:    0.7.0.1
 */
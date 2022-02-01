package com.tencent.tavcut.session.callback;

import android.graphics.Bitmap;

public abstract interface FrameExtractCallback
{
  public abstract void onExtractCanceled();
  
  public abstract void onExtractFailed();
  
  public abstract void onFrameExtracted(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.callback.FrameExtractCallback
 * JD-Core Version:    0.7.0.1
 */
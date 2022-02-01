package com.tencent.superplayer.capture;

import android.graphics.Bitmap;
import com.tencent.superplayer.api.ISPlayerImageGenerator.Listener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;

class SPlayerImageGenerator$1
  implements TPCaptureCallBack
{
  SPlayerImageGenerator$1(SPlayerImageGenerator paramSPlayerImageGenerator, ISPlayerImageGenerator.Listener paramListener) {}
  
  public void onCaptureVideoFailed(int paramInt)
  {
    if (this.val$listener != null) {
      this.val$listener.onCaptureVideoFailed(paramInt);
    }
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    if (this.val$listener != null) {
      this.val$listener.onCaptureVideoSuccess(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.capture.SPlayerImageGenerator.1
 * JD-Core Version:    0.7.0.1
 */
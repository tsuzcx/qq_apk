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
    ISPlayerImageGenerator.Listener localListener = this.val$listener;
    if (localListener != null) {
      localListener.onCaptureVideoFailed(paramInt);
    }
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    ISPlayerImageGenerator.Listener localListener = this.val$listener;
    if (localListener != null) {
      localListener.onCaptureVideoSuccess(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.capture.SPlayerImageGenerator.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.os.Handler;
import android.os.Message;

class PreviewCaptureManager$1
  extends Handler
{
  PreviewCaptureManager$1(PreviewCaptureManager paramPreviewCaptureManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1000) {
      return;
    }
    PreviewCaptureManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PreviewCaptureManager.1
 * JD-Core Version:    0.7.0.1
 */
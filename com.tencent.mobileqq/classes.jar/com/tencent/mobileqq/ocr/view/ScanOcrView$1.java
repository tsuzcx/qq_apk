package com.tencent.mobileqq.ocr.view;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ScanOcrView$1
  extends Handler
{
  ScanOcrView$1(ScanOcrView paramScanOcrView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScanOcrView", 2, "handleMessage, MSG_SCANLINE");
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.a(paramMessage.arg1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView.1
 * JD-Core Version:    0.7.0.1
 */
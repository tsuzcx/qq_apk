package com.tencent.mobileqq.qrscan.activity;

import android.os.Handler.Callback;
import android.os.Message;

class ScannerActivity$4
  implements Handler.Callback
{
  ScannerActivity$4(ScannerActivity paramScannerActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    this.a.showProgress();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.ScannerActivity.4
 * JD-Core Version:    0.7.0.1
 */
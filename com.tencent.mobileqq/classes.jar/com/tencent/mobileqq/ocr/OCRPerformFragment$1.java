package com.tencent.mobileqq.ocr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class OCRPerformFragment$1
  extends BroadcastReceiver
{
  OCRPerformFragment$1(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      QLog.d("OCRPerformFragment", 4, "receive videochat");
      OCRPerformFragment.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.1
 * JD-Core Version:    0.7.0.1
 */
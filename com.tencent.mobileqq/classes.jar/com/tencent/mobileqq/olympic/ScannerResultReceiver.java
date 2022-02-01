package com.tencent.mobileqq.olympic;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.ocr.activity.ScanBaseActivity;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;

public class ScannerResultReceiver
  extends ResultReceiver
{
  private ScanBaseActivity a;
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    OlympicUtil.a("ScannerResultReceiver", new Object[] { "mResultReceiver.onReceiveResult, resultCode=", Integer.valueOf(paramInt), this });
    if (paramInt == 0)
    {
      paramBundle = this.a;
      if ((paramBundle != null) && (paramBundle.f)) {
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.ScannerResultReceiver
 * JD-Core Version:    0.7.0.1
 */
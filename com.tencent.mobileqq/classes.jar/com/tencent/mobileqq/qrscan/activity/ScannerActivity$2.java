package com.tencent.mobileqq.qrscan.activity;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ScannerActivity$2
  implements OnQRHandleResultCallback
{
  ScannerActivity$2(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "restartDecodeFrame");
    }
    this.a.finish();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = ScannerActivity.access$100(this.a);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "onFinish");
    }
    this.a.finish();
  }
  
  public JSONObject c()
  {
    try
    {
      JSONObject localJSONObject = ScannerActivity.access$300(this.a);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQRReportParams error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.i("IQRScanConst_ScannerActivity", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public Context d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.ScannerActivity.2
 * JD-Core Version:    0.7.0.1
 */
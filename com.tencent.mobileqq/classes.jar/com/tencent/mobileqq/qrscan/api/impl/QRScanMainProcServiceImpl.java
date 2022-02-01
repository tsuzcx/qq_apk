package com.tencent.mobileqq.qrscan.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.VoiceScan;
import com.tencent.mobileqq.qrscan.api.IQRScanMainProcService;
import mqq.app.AppRuntime;

public class QRScanMainProcServiceImpl
  implements IQRScanMainProcService
{
  public static final String TAG = "QRScanMainProcServiceImpl";
  private AppRuntime app;
  private Context mContext;
  private VoiceScan mVoiceScan;
  
  private void onScannerPause()
  {
    VoiceScan localVoiceScan = this.mVoiceScan;
    if (localVoiceScan != null) {
      localVoiceScan.b();
    }
  }
  
  private void onScannerResume()
  {
    VoiceScan localVoiceScan = this.mVoiceScan;
    if (localVoiceScan != null) {
      localVoiceScan.a();
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    onScannerDestroy();
    this.app = null;
    this.mContext = null;
  }
  
  public void onScannerCreate(Context paramContext, ScannerParams paramScannerParams)
  {
    this.mContext = paramContext;
    if ((paramScannerParams.f) && (this.mVoiceScan == null)) {
      this.mVoiceScan = new VoiceScan(this.mContext, (AppInterface)this.app);
    }
  }
  
  public void onScannerDestroy()
  {
    VoiceScan localVoiceScan = this.mVoiceScan;
    if (localVoiceScan != null)
    {
      localVoiceScan.c();
      this.mVoiceScan = null;
    }
  }
  
  public void onToolScannerActivityStateChanged(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          onScannerDestroy();
          return;
        }
        onScannerPause();
        return;
      }
      onScannerResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRScanMainProcServiceImpl
 * JD-Core Version:    0.7.0.1
 */
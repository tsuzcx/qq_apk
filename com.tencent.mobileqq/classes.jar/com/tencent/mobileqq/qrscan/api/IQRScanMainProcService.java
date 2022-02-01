package com.tencent.mobileqq.qrscan.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQRScanMainProcService
  extends IRuntimeService
{
  public abstract void onScannerCreate(Context paramContext, ScannerParams paramScannerParams);
  
  public abstract void onScannerDestroy();
  
  public abstract void onToolScannerActivityStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRScanMainProcService
 * JD-Core Version:    0.7.0.1
 */
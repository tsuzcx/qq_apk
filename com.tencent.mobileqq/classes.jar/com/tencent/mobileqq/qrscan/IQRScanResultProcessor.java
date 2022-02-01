package com.tencent.mobileqq.qrscan;

import android.content.Intent;

public abstract interface IQRScanResultProcessor
{
  public abstract String a();
  
  public abstract boolean a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams);
  
  public abstract boolean b(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean b(String paramString1, String paramString2, ScannerParams paramScannerParams);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.IQRScanResultProcessor
 * JD-Core Version:    0.7.0.1
 */
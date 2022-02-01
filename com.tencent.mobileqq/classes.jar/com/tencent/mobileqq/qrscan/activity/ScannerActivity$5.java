package com.tencent.mobileqq.qrscan.activity;

import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.MultiSelectListener;
import com.tencent.qphone.base.util.QLog;

class ScannerActivity$5
  implements ScannerMultiResultSelectView.MultiSelectListener
{
  ScannerActivity$5(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_ScannerActivity", 2, "onMultiCancel");
    }
    this.a.doOnBackPressed();
  }
  
  public void a(QBarResult paramQBarResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel())
    {
      paramImageData = new StringBuilder();
      paramImageData.append("onMultiSelectQr result:");
      paramImageData.append(paramQBarResult);
      paramImageData.append(" ");
      paramImageData.append(paramInt);
      QLog.d("IQRScanConst_ScannerActivity", 2, paramImageData.toString());
    }
    ScannerActivity.access$400(this.a, 1, paramQBarResult.a, paramQBarResult.b, paramInt);
  }
  
  public void a(QMiniResult paramQMiniResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData)
  {
    if (QLog.isColorLevel())
    {
      paramImageData = new StringBuilder();
      paramImageData.append("onMultiSelectMini result:");
      paramImageData.append(paramQMiniResult);
      paramImageData.append(" ");
      paramImageData.append(paramInt);
      QLog.d("IQRScanConst_ScannerActivity", 2, paramImageData.toString());
    }
    ScannerActivity.access$400(this.a, 2, "", paramQMiniResult.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.ScannerActivity.5
 * JD-Core Version:    0.7.0.1
 */
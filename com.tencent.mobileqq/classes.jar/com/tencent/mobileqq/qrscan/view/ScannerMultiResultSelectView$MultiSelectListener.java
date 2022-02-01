package com.tencent.mobileqq.qrscan.view;

import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;

public abstract interface ScannerMultiResultSelectView$MultiSelectListener
{
  public abstract void a();
  
  public abstract void a(QBarResult paramQBarResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData);
  
  public abstract void a(QMiniResult paramQMiniResult, int paramInt, ScannerMultiResultSelectView.ImageData paramImageData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.MultiSelectListener
 * JD-Core Version:    0.7.0.1
 */
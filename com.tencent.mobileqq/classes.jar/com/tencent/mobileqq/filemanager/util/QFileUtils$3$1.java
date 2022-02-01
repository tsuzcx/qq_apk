package com.tencent.mobileqq.filemanager.util;

import android.util.SparseArray;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IQRResultCallback;
import com.tencent.mobileqq.filemanager.fileviewer.data.FileQRScanResult;

class QFileUtils$3$1
  implements Runnable
{
  QFileUtils$3$1(QFileUtils.3 param3, int paramInt, SparseArray paramSparseArray) {}
  
  public void run()
  {
    this.this$0.c.a(new FileQRScanResult(this.this$0.b, this.a, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils.3.1
 * JD-Core Version:    0.7.0.1
 */
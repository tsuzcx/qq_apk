package com.tencent.mobileqq.qrscan.view;

import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ScannerMultiResultSelectView$2
  implements Runnable
{
  ScannerMultiResultSelectView$2(ScannerMultiResultSelectView paramScannerMultiResultSelectView) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAfterDecodeBitmap mShowing：");
      localStringBuilder.append(ScannerMultiResultSelectView.a(this.this$0));
      localStringBuilder.append(" mBitmap:");
      localStringBuilder.append(ScannerMultiResultSelectView.c(this.this$0));
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, localStringBuilder.toString());
    }
    if (!ScannerMultiResultSelectView.a(this.this$0)) {
      return;
    }
    if (ScannerMultiResultSelectView.c(this.this$0) != null)
    {
      ScannerMultiResultSelectView.d(this.this$0);
      return;
    }
    if ((ScannerMultiResultSelectView.e(this.this$0) != null) && (ScannerMultiResultSelectView.f(this.this$0) != null))
    {
      if (ScannerMultiResultSelectView.f(this.this$0).h())
      {
        ScannerMultiResultSelectView.e(this.this$0).a((QBarResult)ScannerMultiResultSelectView.f(this.this$0).a.get(0), ScannerMultiResultSelectView.g(this.this$0), ScannerMultiResultSelectView.h(this.this$0));
        return;
      }
      if (ScannerMultiResultSelectView.f(this.this$0).g())
      {
        ScannerMultiResultSelectView.e(this.this$0).a((QMiniResult)ScannerMultiResultSelectView.f(this.this$0).b.get(0), ScannerMultiResultSelectView.g(this.this$0), ScannerMultiResultSelectView.h(this.this$0));
        return;
      }
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.2
 * JD-Core Version:    0.7.0.1
 */
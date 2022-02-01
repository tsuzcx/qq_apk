package com.tencent.mobileqq.qrscan.activity;

import android.view.View;
import com.tencent.mobileqq.qrscan.QrImageScan.FileDecodeListener;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ScannerActivity$1
  implements QrImageScan.FileDecodeListener
{
  ScannerActivity$1(ScannerActivity paramScannerActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    ScannerActivity.access$100(this.a).setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    if (paramInt == 2) {
      localQQCustomDialog.setMessage(2131915906);
    } else {
      localQQCustomDialog.setMessage(2131915919);
    }
    ScannerActivity.1.1 local1 = new ScannerActivity.1.1(this);
    localQQCustomDialog.setPositiveButton(2131892267, local1);
    localQQCustomDialog.setOnCancelListener(local1);
    localQQCustomDialog.show();
  }
  
  public void a(ScannerResult paramScannerResult, int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    ScannerActivity.access$000(this.a, paramScannerResult, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.ScannerActivity.1
 * JD-Core Version:    0.7.0.1
 */
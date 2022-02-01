package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.support.annotation.RequiresApi;
import bbrl;
import bdla;
import bhhh;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;

public class AIOPictureView$9
  implements Runnable
{
  public AIOPictureView$9(bbrl parambbrl, ScannerResult paramScannerResult, ArrayList paramArrayList) {}
  
  @RequiresApi(api=5)
  public void run()
  {
    if ((this.this$0.mContext == null) || (this.this$0.mContext.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.d())
    {
      bhhh.a(55, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.b, 0);
      bdla.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.c())
    {
      bhhh.a(56, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.b, 0);
      bdla.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
    }
    this.this$0.a.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.9
 * JD-Core Version:    0.7.0.1
 */
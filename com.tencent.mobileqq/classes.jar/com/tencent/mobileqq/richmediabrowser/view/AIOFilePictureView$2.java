package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;

class AIOFilePictureView$2
  implements Runnable
{
  AIOFilePictureView$2(AIOFilePictureView paramAIOFilePictureView, ScannerResult paramScannerResult, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.this$0.mContext == null) || (this.this$0.mContext.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.d())
    {
      RichMediaShareActionSheetUtil.a(55, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.b, 0);
      ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.c())
    {
      RichMediaShareActionSheetUtil.a(56, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.b, 0);
      ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
    }
    this.this$0.a.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.2
 * JD-Core Version:    0.7.0.1
 */
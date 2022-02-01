package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;

class BrowserDependImpl$3
  implements Runnable
{
  BrowserDependImpl$3(BrowserDependImpl paramBrowserDependImpl, Activity paramActivity, ScannerResult paramScannerResult, ArrayList paramArrayList, String paramString, ShareActionSheet paramShareActionSheet) {}
  
  @RequiresApi(api=5)
  public void run()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.d())
      {
        RichMediaShareActionSheetUtil.a(55, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, 0);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.c())
      {
        RichMediaShareActionSheetUtil.a(56, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, 0);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.updateUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.BrowserDependImpl.3
 * JD-Core Version:    0.7.0.1
 */
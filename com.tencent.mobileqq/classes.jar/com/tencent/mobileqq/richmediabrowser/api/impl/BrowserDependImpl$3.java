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
  BrowserDependImpl$3(BrowserDependImpl paramBrowserDependImpl, Activity paramActivity, ScannerResult paramScannerResult, ArrayList paramArrayList1, String paramString, ArrayList paramArrayList2, ShareActionSheet paramShareActionSheet) {}
  
  @RequiresApi(api=5)
  public void run()
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (this.b.h())
      {
        RichMediaShareActionSheetUtil.a(55, this.c, this.d, 0);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
      }
      if (this.b.g())
      {
        RichMediaShareActionSheetUtil.a(56, this.c, this.d, 0);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
      }
      if (!this.b.f()) {
        BrowserDependImpl.access$000(this.this$0, this.e);
      }
      this.f.updateUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.BrowserDependImpl.3
 * JD-Core Version:    0.7.0.1
 */
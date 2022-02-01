package com.tencent.mobileqq.kandian.biz.atlas;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

class ReadInJoySettingActivity$1
  extends IPublicAccountObserver.OnCallback
{
  ReadInJoySettingActivity$1(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onSetPublicAccountSubscribeStatus(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramLong != 2171946401L) {
      return;
    }
    ReadInJoySettingActivity localReadInJoySettingActivity = this.a;
    localReadInJoySettingActivity.f -= 1;
    if ((this.a.f == 0) && (this.a.e != null) && (this.a.e.isShowing())) {
      this.a.e.dismiss();
    }
    if (paramInt == this.a.j)
    {
      boolean bool = ReadInJoySettingActivity.a(this.a);
      if (paramBoolean)
      {
        ReadInJoySettingActivity.b(this.a).setChecked(bool ^ true);
        if (bool) {
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        } else {
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        }
        ReadInJoySettingActivity.c(this.a).a(bool);
      }
      else
      {
        QQToast.makeText(this.a.getApplicationContext(), 2131897929, 0).show();
        localReadInJoySettingActivity = this.a;
        localReadInJoySettingActivity.i = true;
        ReadInJoySettingActivity.b(localReadInJoySettingActivity).setChecked(bool);
        QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
      }
    }
    this.a.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.atlas;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
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
    localReadInJoySettingActivity.jdField_a_of_type_Int -= 1;
    if ((this.a.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramInt == this.a.b)
    {
      boolean bool = ReadInJoySettingActivity.a(this.a);
      if (paramBoolean)
      {
        ReadInJoySettingActivity.a(this.a).setChecked(bool ^ true);
        if (bool) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        } else {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
        }
        ReadInJoySettingActivity.a(this.a).a(bool);
      }
      else
      {
        QQToast.a(this.a.getApplicationContext(), 2131699876, 0).a();
        localReadInJoySettingActivity = this.a;
        localReadInJoySettingActivity.c = true;
        ReadInJoySettingActivity.a(localReadInJoySettingActivity).setChecked(bool);
        QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
      }
    }
    this.a.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.1
 * JD-Core Version:    0.7.0.1
 */
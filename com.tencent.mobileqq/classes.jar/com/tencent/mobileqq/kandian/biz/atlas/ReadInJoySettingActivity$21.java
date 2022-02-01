package com.tencent.mobileqq.kandian.biz.atlas;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySettingActivity$21
  implements CompoundButton.OnCheckedChangeListener
{
  ReadInJoySettingActivity$21(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = RIJQQAppInterfaceUtil.a();
    if (paramBoolean) {
      paramCompoundButton = "1";
    } else {
      paramCompoundButton = "0";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800AFEB", "0X800AFEB", 0, 0, str, paramCompoundButton, "", RIJTransMergeKanDianReport.a(), false);
    ReadInJoyHelper.a((QQAppInterface)this.a.getAppInterface(), paramBoolean, new ReadInJoySettingActivity.TroopProtocolObserver(this.a, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.21
 * JD-Core Version:    0.7.0.1
 */
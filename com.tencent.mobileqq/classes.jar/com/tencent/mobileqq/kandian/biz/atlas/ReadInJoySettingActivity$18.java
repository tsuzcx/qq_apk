package com.tencent.mobileqq.kandian.biz.atlas;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoySettingActivity$18
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoySettingActivity$18(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).setRadioButtonChecked(paramInt);
    ((TextView)this.a.findViewById(2131372737)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    RIJAppSetting.a(Integer.toString(paramInt));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.18
 * JD-Core Version:    0.7.0.1
 */
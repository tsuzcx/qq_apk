package com.tencent.mobileqq.kandian.biz.atlas;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoySettingActivity$18
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoySettingActivity$18(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.k(this.a).setRadioButtonChecked(paramInt);
    ((TextView)this.a.findViewById(2131440284)).setText(ReadInJoySettingActivity.l(this.a)[paramInt]);
    RIJAppSetting.a(Integer.toString(paramInt));
    PublicAccountReportUtils.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.k(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.18
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyBaseDeliverActivity$14
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyBaseDeliverActivity$14(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyBaseDeliverActivity.jdField_a_of_type_Boolean) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyBaseDeliverActivity;
    paramView.jdField_a_of_type_Boolean = true;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ForwardSdkShareOption.a(paramView, true, "shareToQQ", this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyBaseDeliverActivity.moveTaskToBack(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyBaseDeliverActivity.finish();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyBaseDeliverActivity.f();
      if (this.b)
      {
        paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("");
        paramView.publicAccountReportClickEvent(null, "", "0X8008661", "0X8008661", 0, 0, localStringBuilder.toString(), "", "", ReadInJoyBaseDeliverActivity.a(), false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyBaseDeliverActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.14
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.app.AppRuntime;

class ReadinjoyTabFrame$12
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 2;
    if (j == 2131366266)
    {
      ((IKandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame.a.getRuntimeService(IKandianSubscribeManager.class, "")).lanuchKandianSubscribeActivity(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame.a(), 2);
      i = 1;
    }
    ReadinjoyTabFrame.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame).setAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame.a(), 2130772370));
    ReadinjoyTabFrame.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame).setVisibility(8);
    SharedPreUtils.q(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame.a().getCurrentAccountUin());
    paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    paramView.publicAccountReportClickEvent(localQQAppInterface, "", "0X80093FE", "0X80093FE", 0, 0, localStringBuilder.toString(), "", "", this.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.12
 * JD-Core Version:    0.7.0.1
 */
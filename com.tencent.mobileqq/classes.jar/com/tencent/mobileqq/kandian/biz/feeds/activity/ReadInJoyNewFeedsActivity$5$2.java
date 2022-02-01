package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReadInJoyNewFeedsActivity$5$2
  implements View.OnClickListener
{
  ReadInJoyNewFeedsActivity$5$2(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    paramView = (ReadInJoyRefreshManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0, 0);
      if (paramView != null)
      {
        paramView.isShown = false;
        SharedPreUtils.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), paramView.toJson().toString(), 0);
      }
    }
    SharedPreUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.a.skinData.toJson().toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.a.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.a);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("set skin ：id = ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.a.skinData.id);
      QLog.d("ReadInJoyNewFeedsActivity", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.5.2
 * JD-Core Version:    0.7.0.1
 */
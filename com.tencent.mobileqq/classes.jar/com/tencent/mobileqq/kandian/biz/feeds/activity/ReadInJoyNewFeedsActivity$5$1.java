package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ReadInJoyNewFeedsActivity$5$1
  implements View.OnClickListener
{
  ReadInJoyNewFeedsActivity$5$1(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.a.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.a);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.a) {
      SharedPreUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.5.1
 * JD-Core Version:    0.7.0.1
 */
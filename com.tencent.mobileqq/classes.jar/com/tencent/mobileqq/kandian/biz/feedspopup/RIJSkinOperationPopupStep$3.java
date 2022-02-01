package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;
import com.tencent.mobileqq.utils.SharedPreUtils;

class RIJSkinOperationPopupStep$3
  implements View.OnClickListener
{
  RIJSkinOperationPopupStep$3(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep));
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep, null);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.jdField_a_of_type_Int) {
      SharedPreUtils.o(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep.3
 * JD-Core Version:    0.7.0.1
 */
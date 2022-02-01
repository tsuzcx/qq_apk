package com.tencent.mobileqq.kandian.biz.feedspopup;

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

class RIJSkinOperationPopupStep$4
  implements View.OnClickListener
{
  RIJSkinOperationPopupStep$4(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, GuideData paramGuideData) {}
  
  public void onClick(View paramView)
  {
    paramView = (ReadInJoyRefreshManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep), 0);
      if (paramView != null)
      {
        paramView.isShown = false;
        SharedPreUtils.f(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView.toJson().toString(), 0);
      }
    }
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep));
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep, null);
    SharedPreUtils.o(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedspopupRIJSkinOperationPopupStep), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("set skin: id = ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinGuideData.skinData.id);
      QLog.d("RIJSkinOperationPopupStep", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJSkinOperationPopupStep.4
 * JD-Core Version:    0.7.0.1
 */
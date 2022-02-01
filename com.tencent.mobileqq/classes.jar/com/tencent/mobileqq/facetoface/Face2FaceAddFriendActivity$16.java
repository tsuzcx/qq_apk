package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$16
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$16(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    long l;
    if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity))
    {
      l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b < Face2FaceAddFriendActivity.jdField_a_of_type_Long) && (l > this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b)) {
        if (QLog.isColorLevel()) {
          QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "click too offen,please try again later ");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b = l;
      Face2FaceAddFriendActivity.b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.d();
      ReportController.b(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 1, 0, "", "", "", "");
      continue;
      String str = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getResources().getString(2131692215);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, 0, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.16
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$17
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$17(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity))
    {
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b < Face2FaceAddFriendActivity.jdField_a_of_type_Long) && (l > this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b))
      {
        if (QLog.isColorLevel()) {
          QLog.e(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "click too offen,please try again later ");
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
        ((Face2FaceAddFriendActivity)localObject).b = l;
        Face2FaceAddFriendActivity.b((Face2FaceAddFriendActivity)localObject, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.d();
        ReportController.b(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 1, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getResources().getString(2131692141);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, 0, (CharSequence)localObject, 0).b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getTitleBarHeight());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.17
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$19
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$19(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity;
    ProfileCardUtil.a(localFace2FaceAddFriendActivity, localFace2FaceAddFriendActivity.a.a(), this.jdField_a_of_type_JavaLangString, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.19
 * JD-Core Version:    0.7.0.1
 */
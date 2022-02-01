package com.tencent.mobileqq.facetoface;

import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class Face2FaceAddFriendActivity$4$1
  implements Animation.AnimationListener
{
  Face2FaceAddFriendActivity$4$1(Face2FaceAddFriendActivity.4 param4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.n = true;
    if (Face2FaceAddFriendConstants.a >= Face2FaceAddFriendConstants.b)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(Face2FaceAddFriendConstants.a, Face2FaceAddFriendConstants.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(Face2FaceAddFriendConstants.a, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.4.1
 * JD-Core Version:    0.7.0.1
 */
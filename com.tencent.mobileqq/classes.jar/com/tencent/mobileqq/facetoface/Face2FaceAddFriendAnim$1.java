package com.tencent.mobileqq.facetoface;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class Face2FaceAddFriendAnim$1
  implements Animation.AnimationListener
{
  Face2FaceAddFriendAnim$1(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim, Face2FaceUserData paramFace2FaceUserData1, int paramInt1, double paramDouble, boolean paramBoolean1, boolean paramBoolean2, Face2FaceUserData paramFace2FaceUserData2, boolean paramBoolean3, boolean paramBoolean4, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((Face2FaceAddFriendActivity)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a).b(this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData, this.c, this.d);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.setStatusWithAnimation(this.jdField_b_of_type_Int);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramAnimation = Face2FaceAddFriendActivity.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startFriendInAnimation currentUin ( ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData.e.substring(0, 4));
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" ) Animation Start  ");
      QLog.d(paramAnimation, 2, localStringBuilder.toString());
    }
    double d1 = Math.atan(this.jdField_a_of_type_Double) * 180.0D / 3.141592653589793D;
    double d2 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_b_of_type_Int;
    Double.isNaN(d2);
    d2 = d1 * d2;
    d1 = d2;
    if (this.jdField_a_of_type_Boolean) {
      d1 = 180.0D - d2;
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.jdField_b_of_type_Float = ((float)d1);
    if (QLog.isColorLevel())
    {
      paramAnimation = Face2FaceAddFriendActivity.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startFriendInAnimation uinToHoleIndex add( ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData.e.substring(0, 4));
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" )");
      QLog.d(paramAnimation, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.a(2, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.1
 * JD-Core Version:    0.7.0.1
 */
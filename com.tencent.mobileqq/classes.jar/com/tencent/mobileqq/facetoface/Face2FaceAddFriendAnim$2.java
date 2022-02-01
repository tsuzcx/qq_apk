package com.tencent.mobileqq.facetoface;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class Face2FaceAddFriendAnim$2
  implements Animation.AnimationListener
{
  Face2FaceAddFriendAnim$2(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = Face2FaceAddFriendActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startFriendDisappearAnimation disappear ( disappearCount: ");
      localStringBuilder.append(this.a.h);
      localStringBuilder.append(", disappearSize: ");
      localStringBuilder.append(this.a.i);
      localStringBuilder.append(" )");
      QLog.d(paramAnimation, 2, localStringBuilder.toString());
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.2
 * JD-Core Version:    0.7.0.1
 */
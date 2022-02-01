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
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear ( disappearCount: " + this.a.h + ", disappearSize: " + this.a.i + " )");
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.2
 * JD-Core Version:    0.7.0.1
 */
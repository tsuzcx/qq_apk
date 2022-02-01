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
    ((Face2FaceAddFriendActivity)this.k.C).b(this.f, this.g, this.h);
    this.i.setStatusWithAnimation(this.j);
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
      localStringBuilder.append(this.a.f.substring(0, 4));
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" ) Animation Start  ");
      QLog.d(paramAnimation, 2, localStringBuilder.toString());
    }
    double d1 = Math.atan(this.c) * 180.0D / 3.141592653589793D;
    double d2 = this.k.f;
    Double.isNaN(d2);
    d2 = d1 * d2;
    d1 = d2;
    if (this.d) {
      d1 = 180.0D - d2;
    }
    this.k.d = ((float)d1);
    if (QLog.isColorLevel())
    {
      paramAnimation = Face2FaceAddFriendActivity.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startFriendInAnimation uinToHoleIndex add( ");
      localStringBuilder.append(this.a.f.substring(0, 4));
      localStringBuilder.append(", ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" )");
      QLog.d(paramAnimation, 2, localStringBuilder.toString());
    }
    this.k.a(2, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.facetoface;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class Face2FaceDetailBaseView$2
  implements Animation.AnimationListener
{
  Face2FaceDetailBaseView$2(Face2FaceDetailBaseView paramFace2FaceDetailBaseView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(4);
    this.a.e.b();
    this.a.c.setBackgroundDrawable(null);
    this.a.n.e();
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("animHide, onAnimationEnd ");
      paramAnimation.append(hashCode());
      QLog.d("Face2FaceDetailBaseView", 2, paramAnimation.toString());
    }
    Face2FaceDetailBaseView.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel())
    {
      paramAnimation = new StringBuilder();
      paramAnimation.append("animHide, onAnimationStart ");
      paramAnimation.append(hashCode());
      QLog.d("Face2FaceDetailBaseView", 2, paramAnimation.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.2
 * JD-Core Version:    0.7.0.1
 */
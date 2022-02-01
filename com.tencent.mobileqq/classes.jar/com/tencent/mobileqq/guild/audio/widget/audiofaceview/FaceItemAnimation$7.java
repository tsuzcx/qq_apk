package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;

class FaceItemAnimation$7
  extends FaceItemAnimation.VpaListenerAdapter
{
  FaceItemAnimation$7(FaceItemAnimation paramFaceItemAnimation, FaceItemAnimation.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    this.c.dispatchChangeFinished(this.a.a, true);
    FaceItemAnimation.h(this.c).remove(this.a.a);
    FaceItemAnimation.e(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchChangeStarting(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;

class FaceItemAnimation$8
  extends FaceItemAnimation.VpaListenerAdapter
{
  FaceItemAnimation$8(FaceItemAnimation paramFaceItemAnimation, FaceItemAnimation.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(this.c, 1.0F);
    ViewCompat.setTranslationX(this.c, 0.0F);
    ViewCompat.setTranslationY(this.c, 0.0F);
    this.d.dispatchChangeFinished(this.a.b, false);
    FaceItemAnimation.h(this.d).remove(this.a.b);
    FaceItemAnimation.e(this.d);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.d.dispatchChangeStarting(this.a.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.8
 * JD-Core Version:    0.7.0.1
 */
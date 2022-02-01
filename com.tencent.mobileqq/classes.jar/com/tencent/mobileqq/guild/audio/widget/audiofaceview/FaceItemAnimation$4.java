package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

class FaceItemAnimation$4
  extends FaceItemAnimation.VpaListenerAdapter
{
  FaceItemAnimation$4(FaceItemAnimation paramFaceItemAnimation, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    this.c.dispatchRemoveFinished(this.a);
    FaceItemAnimation.d(this.c).remove(this.a);
    FaceItemAnimation.e(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchRemoveStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.4
 * JD-Core Version:    0.7.0.1
 */
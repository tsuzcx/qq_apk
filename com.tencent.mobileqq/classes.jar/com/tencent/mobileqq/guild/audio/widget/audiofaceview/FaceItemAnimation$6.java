package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

class FaceItemAnimation$6
  extends FaceItemAnimation.VpaListenerAdapter
{
  FaceItemAnimation$6(FaceItemAnimation paramFaceItemAnimation, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    if (this.b != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (this.c != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.d.setListener(null);
    this.e.dispatchMoveFinished(this.a);
    FaceItemAnimation.g(this.e).remove(this.a);
    FaceItemAnimation.e(this.e);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.e.dispatchMoveStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.6
 * JD-Core Version:    0.7.0.1
 */
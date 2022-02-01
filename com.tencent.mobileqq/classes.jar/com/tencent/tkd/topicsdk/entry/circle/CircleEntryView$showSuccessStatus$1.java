package com.tencent.tkd.topicsdk.entry.circle;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/entry/circle/CircleEntryView$showSuccessStatus$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
public final class CircleEntryView$showSuccessStatus$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    new Handler(Looper.getMainLooper()).postAtTime((Runnable)new CircleEntryView.showSuccessStatus.1.onAnimationEnd.1(this), 300L);
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation) {}
  
  public void onAnimationStart(@Nullable Animation paramAnimation)
  {
    this.a.setCurrentStatus(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.circle.CircleEntryView.showSuccessStatus.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/follow/popup/RIJBottomDialog$animateDown$1$1", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBottomDialog$animateDown$$inlined$let$lambda$1
  extends AnimateUtils.AnimationAdapter
{
  RIJBottomDialog$animateDown$$inlined$let$lambda$1(RIJBottomDialog paramRIJBottomDialog) {}
  
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    RIJBottomDialog.b(this.a, false);
    paramAnimation = this.a.a();
    if (paramAnimation != null) {
      paramAnimation.post((Runnable)new RIJBottomDialog.animateDown..inlined.let.lambda.1.1(this));
    }
  }
  
  public void onAnimationStart(@Nullable Animation paramAnimation)
  {
    RIJBottomDialog.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJBottomDialog.animateDown..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */
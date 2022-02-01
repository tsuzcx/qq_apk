package com.tencent.mobileqq.kandian.biz.push.mvp;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/push/mvp/RIJPushNotifyDialog$playAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyDialog$playAnimation$1
  implements Animation.AnimationListener
{
  RIJPushNotifyDialog$playAnimation$1(Function0 paramFunction0) {}
  
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    ThreadManager.getUIHandler().postDelayed((Runnable)new RIJPushNotifyDialog.playAnimation.1.onAnimationEnd.1(this), 30L);
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation) {}
  
  public void onAnimationStart(@Nullable Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog.playAnimation.1
 * JD-Core Version:    0.7.0.1
 */
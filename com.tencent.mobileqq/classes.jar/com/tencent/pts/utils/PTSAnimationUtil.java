package com.tencent.pts.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

public class PTSAnimationUtil
{
  public static void playAnimation(PTSAnimationUtil.AnimationInfo paramAnimationInfo, PTSNodeVirtual paramPTSNodeVirtual, PTSNodeInfo paramPTSNodeInfo1, PTSNodeInfo paramPTSNodeInfo2)
  {
    if ((paramAnimationInfo == null) || (paramPTSNodeVirtual == null) || (paramPTSNodeInfo1 == null) || (paramPTSNodeInfo2 == null)) {
      return;
    }
    Object localObject = paramPTSNodeVirtual.getView();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramPTSNodeInfo1.getStyle().getHeight(), paramPTSNodeInfo2.getStyle().getHeight() });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new PTSAnimationUtil.1(localLayoutParams, (View)localObject));
    paramPTSNodeInfo1 = ValueAnimator.ofInt(new int[] { paramPTSNodeInfo1.getStyle().getTop(), paramPTSNodeInfo2.getStyle().getTop() });
    paramPTSNodeInfo1.setInterpolator(new AccelerateDecelerateInterpolator());
    paramPTSNodeInfo1.addUpdateListener(new PTSAnimationUtil.2(localLayoutParams, (View)localObject));
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).addListener(new PTSAnimationUtil.3(paramPTSNodeVirtual, paramPTSNodeInfo2));
    ((AnimatorSet)localObject).setDuration(PTSAnimationUtil.AnimationInfo.access$000(paramAnimationInfo));
    ((AnimatorSet)localObject).setStartDelay(PTSAnimationUtil.AnimationInfo.access$100(paramAnimationInfo));
    ((AnimatorSet)localObject).playTogether(new Animator[] { localValueAnimator, paramPTSNodeInfo1 });
    ((AnimatorSet)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.utils.PTSAnimationUtil
 * JD-Core Version:    0.7.0.1
 */
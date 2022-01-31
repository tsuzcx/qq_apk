package com.tencent.pts.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

final class PTSAnimationUtil$3
  extends AnimatorListenerAdapter
{
  PTSAnimationUtil$3(PTSNodeVirtual paramPTSNodeVirtual, PTSNodeInfo paramPTSNodeInfo) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.val$node.bindNodeInfo(this.val$newNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.utils.PTSAnimationUtil.3
 * JD-Core Version:    0.7.0.1
 */
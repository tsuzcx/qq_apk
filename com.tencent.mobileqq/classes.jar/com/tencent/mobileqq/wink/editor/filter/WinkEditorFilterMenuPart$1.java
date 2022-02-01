package com.tencent.mobileqq.wink.editor.filter;

import android.animation.Animator;
import android.widget.TextView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class WinkEditorFilterMenuPart$1
  extends D8SafeAnimatorListener
{
  WinkEditorFilterMenuPart$1(WinkEditorFilterMenuPart paramWinkEditorFilterMenuPart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WinkEditorFilterMenuPart.b(this.a).setVisibility(4);
    WinkEditorFilterMenuPart.b(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    WinkEditorFilterMenuPart.a(this.a).setVisibility(0);
    WinkEditorFilterMenuPart.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.WinkEditorFilterMenuPart.1
 * JD-Core Version:    0.7.0.1
 */
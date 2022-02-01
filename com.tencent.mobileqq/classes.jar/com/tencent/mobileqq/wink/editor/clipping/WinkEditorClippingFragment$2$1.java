package com.tencent.mobileqq.wink.editor.clipping;

import android.animation.Animator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.D8SafeAnimatorListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController;

class WinkEditorClippingFragment$2$1
  extends D8SafeAnimatorListener
{
  WinkEditorClippingFragment$2$1(WinkEditorClippingFragment.2 param2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (((VideoTrackContainerView)WinkEditorClippingFragment.d(this.a.b).d()).b()) {
      return;
    }
    WinkEditorClippingFragment.c(this.a.b).setVisibility(0);
    WinkEditorClippingFragment.c(this.a.b).a(this.a.a);
    ((VideoTrackContainerView)WinkEditorClippingFragment.d(this.a.b).d()).setVisibility(4);
    WinkEditorClippingFragment.f(this.a.b).a(false);
    if (WinkEditorClippingFragment.g(this.a.b).d() != null) {
      ((DragDropScrollView)WinkEditorClippingFragment.g(this.a.b).d()).setVisibility(4);
    }
    ((VideoTrackContainerView)WinkEditorClippingFragment.d(this.a.b).d()).setHandleView(WinkEditorClippingFragment.c(this.a.b));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
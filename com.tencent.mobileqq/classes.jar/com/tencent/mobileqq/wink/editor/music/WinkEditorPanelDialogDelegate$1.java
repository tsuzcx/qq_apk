package com.tencent.mobileqq.wink.editor.music;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class WinkEditorPanelDialogDelegate$1
  implements Animation.AnimationListener
{
  WinkEditorPanelDialogDelegate$1(WinkEditorPanelDialogDelegate paramWinkEditorPanelDialogDelegate) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    WinkEditorPanelDialogDelegate.a(this.a, false);
    WinkEditorPanelDialogDelegate.b(this.a).post(new WinkEditorPanelDialogDelegate.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    WinkEditorPanelDialogDelegate.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorPanelDialogDelegate.1
 * JD-Core Version:    0.7.0.1
 */
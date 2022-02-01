package com.tencent.richmediabrowser.view;

import android.view.animation.Animation;
import com.tencent.richmediabrowser.animation.AbstractAnimationManager;
import com.tencent.richmediabrowser.animation.AnimateUtils.AnimationAdapter;

class BrowserBaseScene$2
  extends AnimateUtils.AnimationAdapter
{
  BrowserBaseScene$2(BrowserBaseScene paramBrowserBaseScene) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.getAnimationManager().onExitAnimationEnd();
    this.this$0.getAnimationManager().resetAnimationDuring();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.getAnimationManager().onExitAnimationStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseScene.2
 * JD-Core Version:    0.7.0.1
 */
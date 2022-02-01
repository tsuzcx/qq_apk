package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class EmotionSearchPanel$7
  extends D8SafeAnimatorListener
{
  EmotionSearchPanel$7(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim onAnimationEnd=");
    }
    EmotionUtils.a(this.this$0.emotionInput);
    this.this$0.addOnSoftKeyBoardVisibleListener();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("upAndDownAnim start animStartBottom=");
      paramAnimator.append(EmotionSearchPanel.access$700(this.this$0));
      QLog.d("EmotionSearchPanel", 2, paramAnimator.toString());
    }
    paramAnimator = this.this$0;
    EmotionSearchPanel.access$800(paramAnimator, EmotionSearchPanel.access$700(paramAnimator));
    paramAnimator = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.this$0.interactionListener);
    if (paramAnimator != null) {
      ((EmoticonPanelHotPicSearchHelper)paramAnimator.getEmoController().getHelper(7)).setSearchContainerVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.7
 * JD-Core Version:    0.7.0.1
 */
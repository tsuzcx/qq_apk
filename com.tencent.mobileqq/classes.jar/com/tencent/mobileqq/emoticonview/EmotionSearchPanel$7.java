package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.qphone.base.util.QLog;

class EmotionSearchPanel$7
  implements Animator.AnimatorListener
{
  EmotionSearchPanel$7(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim onAnimationEnd=");
    }
    AIOUtils.a(this.this$0.emotionInput);
    this.this$0.addOnSoftKeyBoardVisibleListener();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim start animStartBottom=" + EmotionSearchPanel.access$700(this.this$0));
    }
    EmotionSearchPanel.access$800(this.this$0, EmotionSearchPanel.access$700(this.this$0));
    paramAnimator = AIOEmoticonUIHelper.a(this.this$0.chatPie);
    if (paramAnimator != null) {
      ((EmoticonPanelHotPicSearchHelper)paramAnimator.getEmoController().getHelper(7)).setSearchContainerVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.7
 * JD-Core Version:    0.7.0.1
 */
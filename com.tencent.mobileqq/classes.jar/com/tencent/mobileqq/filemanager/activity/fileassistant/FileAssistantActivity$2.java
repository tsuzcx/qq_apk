package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewStub;

class FileAssistantActivity$2
  implements ValueAnimator.AnimatorUpdateListener
{
  FileAssistantActivity$2(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FileAssistantActivity.a(this.a).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    FileAssistantActivity.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.2
 * JD-Core Version:    0.7.0.1
 */
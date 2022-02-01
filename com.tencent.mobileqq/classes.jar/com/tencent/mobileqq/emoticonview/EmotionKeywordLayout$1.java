package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class EmotionKeywordLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  EmotionKeywordLayout$1(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("show:offset=");
      paramValueAnimator.append(f);
      QLog.d("EmotionKeywordLayout", 2, paramValueAnimator.toString());
    }
    if (EmotionKeywordLayout.access$000(this.this$0) != null) {
      EmotionKeywordLayout.access$000(this.this$0).setTranslationY(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.1
 * JD-Core Version:    0.7.0.1
 */
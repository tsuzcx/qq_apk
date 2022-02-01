package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import java.util.ArrayList;
import java.util.List;

class ReadInJoyFeedbackPopupWindow$1$1
  extends AnimateUtils.AnimationAdapter
{
  ReadInJoyFeedbackPopupWindow$1$1(ReadInJoyFeedbackPopupWindow.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (ReadInJoyFeedbackPopupWindow.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(ReadInJoyFeedbackPopupWindow.a(this.a.a));
      ReadInJoyFeedbackPopupWindow.a(this.a.a).a(paramAnimation, ReadInJoyFeedbackPopupWindow.a(this.a.a));
      QQToast.a(ReadInJoyFeedbackPopupWindow.a(this.a.a), 2, 2131717910, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.1.1
 * JD-Core Version:    0.7.0.1
 */
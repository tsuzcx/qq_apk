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
    if (ReadInJoyFeedbackPopupWindow.b(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(ReadInJoyFeedbackPopupWindow.c(this.a.a));
      ReadInJoyFeedbackPopupWindow.b(this.a.a).a(paramAnimation, ReadInJoyFeedbackPopupWindow.d(this.a.a));
      QQToast.makeText(ReadInJoyFeedbackPopupWindow.e(this.a.a), 2, 2131915384, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.1.1
 * JD-Core Version:    0.7.0.1
 */
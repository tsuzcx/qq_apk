package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.widget.QQToast;

class ReadInJoyFeedbackPopupWindow$1
  implements FeedbackCallback
{
  ReadInJoyFeedbackPopupWindow$1(ReadInJoyFeedbackPopupWindow paramReadInJoyFeedbackPopupWindow) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (ReadInJoyFeedbackPopupWindow.a(this.a) != null)
      {
        paramString = (Animation)ReadInJoyFeedbackPopupWindow.a(this.a).getTag(2131369613);
        paramString.setAnimationListener(new ReadInJoyFeedbackPopupWindow.1.1(this));
        ReadInJoyFeedbackPopupWindow.a(this.a).startAnimation(paramString);
      }
    }
    else {
      QQToast.a(ReadInJoyFeedbackPopupWindow.b(this.a), 1, 2131717909, 0).a();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (paramBoolean)
    {
      ReadInJoyFeedbackPopupWindow.a(this.a).a(ReadInJoyFeedbackPopupWindow.a(this.a), ReadInJoyFeedbackPopupWindow.a(this.a, paramInt), ReadInJoyFeedbackPopupWindow.e(this.a), "", "", paramString2, "", 0, "");
      return;
    }
    QQToast.a(ReadInJoyFeedbackPopupWindow.f(this.a), 1, 2131717913, 0).a();
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (ReadInJoyFeedbackPopupWindow.a(this.a) != null)
      {
        paramString = (Animation)ReadInJoyFeedbackPopupWindow.a(this.a).getTag(2131369613);
        paramString.setAnimationListener(new ReadInJoyFeedbackPopupWindow.1.2(this));
        ReadInJoyFeedbackPopupWindow.a(this.a).startAnimation(paramString);
      }
    }
    else {
      QQToast.a(ReadInJoyFeedbackPopupWindow.d(this.a), 1, 2131717915, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */
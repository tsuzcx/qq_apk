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
        paramString = (Animation)ReadInJoyFeedbackPopupWindow.a(this.a).getTag(2131436721);
        paramString.setAnimationListener(new ReadInJoyFeedbackPopupWindow.1.1(this));
        ReadInJoyFeedbackPopupWindow.a(this.a).startAnimation(paramString);
      }
    }
    else {
      QQToast.makeText(ReadInJoyFeedbackPopupWindow.f(this.a), 1, 2131915383, 0).show();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (paramBoolean)
    {
      ReadInJoyFeedbackPopupWindow.j(this.a).a(ReadInJoyFeedbackPopupWindow.c(this.a), ReadInJoyFeedbackPopupWindow.a(this.a, paramInt), ReadInJoyFeedbackPopupWindow.i(this.a), "", "", paramString2, "", 0, "");
      return;
    }
    QQToast.makeText(ReadInJoyFeedbackPopupWindow.k(this.a), 1, 2131915387, 0).show();
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (ReadInJoyFeedbackPopupWindow.a(this.a) != null)
      {
        paramString = (Animation)ReadInJoyFeedbackPopupWindow.a(this.a).getTag(2131436721);
        paramString.setAnimationListener(new ReadInJoyFeedbackPopupWindow.1.2(this));
        ReadInJoyFeedbackPopupWindow.a(this.a).startAnimation(paramString);
      }
    }
    else {
      QQToast.makeText(ReadInJoyFeedbackPopupWindow.h(this.a), 1, 2131915389, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */
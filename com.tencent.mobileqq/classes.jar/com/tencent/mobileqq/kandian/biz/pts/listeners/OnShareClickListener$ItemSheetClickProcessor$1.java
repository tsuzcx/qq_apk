package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.widget.QQToast;

class OnShareClickListener$ItemSheetClickProcessor$1
  implements FeedbackCallback
{
  OnShareClickListener$ItemSheetClickProcessor$1(OnShareClickListener.ItemSheetClickProcessor paramItemSheetClickProcessor) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if ((paramBoolean) && ((OnShareClickListener.d(this.a.a) instanceof Activity)))
    {
      if (OnShareClickListener.c(this.a.a) == null) {
        OnShareClickListener.a(this.a.a, new FastWebShareUtils());
      }
      if (OnShareClickListener.e(this.a.a) != -1) {
        paramInt = OnShareClickListener.e(this.a.a);
      } else {
        paramInt = OnShareClickListener.ItemSheetClickProcessor.a(this.a, paramInt);
      }
      OnShareClickListener.c(this.a.a).a(OnShareClickListener.ItemSheetClickProcessor.a(this.a), paramInt, (Activity)OnShareClickListener.d(this.a.a), "", "", paramString2, OnShareClickListener.f(this.a.a), OnShareClickListener.g(this.a.a), OnShareClickListener.h(this.a.a));
      OnShareClickListener.a(this.a.a, "");
      OnShareClickListener.a(this.a.a, 0);
      OnShareClickListener.b(this.a.a, "");
      OnShareClickListener.b(this.a.a, -1);
      return;
    }
    QQToast.makeText(OnShareClickListener.d(this.a.a), 1, 2131915387, 0).show();
  }
  
  public void b(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnShareClickListener.ItemSheetClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */
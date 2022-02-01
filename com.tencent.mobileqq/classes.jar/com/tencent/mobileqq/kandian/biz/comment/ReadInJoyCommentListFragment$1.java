package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;

class ReadInJoyCommentListFragment$1
  implements HippyCommentPageListener
{
  ReadInJoyCommentListFragment$1(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onHippyPageLoaded: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.getQBaseActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!this.a.isDetached()))
    {
      if (paramBoolean)
      {
        ReadInJoyCommentListFragment.a(this.a, true);
        ReadInJoyCommentListFragment.a(this.a);
      }
      else
      {
        if (ReadInJoyCommentListFragment.a(this.a) != null)
        {
          if (ReadInJoyCommentListFragment.a(this.a) != null)
          {
            ((FrameLayout)ReadInJoyCommentListFragment.a(this.a).findViewById(2131368189)).setVisibility(8);
            ReadInJoyCommentListFragment.b(this.a);
          }
          ReadInJoyCommentListFragment.a(this.a, null);
        }
        if (!ReadInJoyCommentListFragment.a(this.a))
        {
          localObject = this.a;
          ReadInJoyCommentListFragment.a((ReadInJoyCommentListFragment)localObject, ReadInJoyCommentListFragment.a((ReadInJoyCommentListFragment)localObject));
        }
      }
      ReadInJoyCommentListFragment.c(this.a);
      return;
    }
    QLog.d("ReadInJoyCommentListFragment", 1, "activity not exists or fragment detached");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment.1
 * JD-Core Version:    0.7.0.1
 */
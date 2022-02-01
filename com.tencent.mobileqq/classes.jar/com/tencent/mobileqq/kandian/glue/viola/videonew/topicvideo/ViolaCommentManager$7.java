package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.qphone.base.util.QLog;

class ViolaCommentManager$7
  implements ReadInJoyCommentUtils.FirstCommentEvent
{
  ViolaCommentManager$7(ViolaCommentManager paramViolaCommentManager) {}
  
  public void a()
  {
    if (ViolaCommentManager.h(this.a) != null) {
      ViolaCommentManager.h(this.a).a();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFirstCommentVisible: visible=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ViolaCommentManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      return;
    }
    ViolaCommentManager.a(this.a, true);
    ViolaCommentManager.g(this.a).l();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131430816) {
      return;
    }
    this.a.c(0);
    ViolaCommentManager.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.7
 * JD-Core Version:    0.7.0.1
 */
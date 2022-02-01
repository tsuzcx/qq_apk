package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;

class ConversationHongBaoV2$1
  implements Runnable
{
  ConversationHongBaoV2$1(ConversationHongBaoV2 paramConversationHongBaoV2) {}
  
  public void run()
  {
    FrameHelperActivity.b(true);
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "mTouchReleaseRunable  do Run");
    }
    if (this.this$0.c.getScrollY() == 0) {
      return;
    }
    if (this.this$0.e == 4)
    {
      this.this$0.c.setSpringbackOffset(-this.this$0.p);
      if (Math.abs(this.this$0.c.getScrollY() + this.this$0.p) > this.this$0.p * 1.0F / 13.0F) {
        this.this$0.c.springBackTo(-this.this$0.p);
      }
    }
    else
    {
      this.this$0.c.setSpringbackOffset(0);
      if (this.this$0.c.getScrollY() != 0) {
        this.this$0.c.springBackTo(0);
      }
    }
    if (!this.this$0.c.E) {
      this.this$0.b(false);
    }
    if (QLog.isColorLevel())
    {
      int i = ConversationHongBaoV2.a(this.this$0).getProgressViewAlpha();
      int j = ConversationHongBaoV2.a(this.this$0).getVisibility();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" [dddd] mTouchReleaseRunable mProgressViewRed alpha = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",visibility = ");
      localStringBuilder.append(j);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.1
 * JD-Core Version:    0.7.0.1
 */
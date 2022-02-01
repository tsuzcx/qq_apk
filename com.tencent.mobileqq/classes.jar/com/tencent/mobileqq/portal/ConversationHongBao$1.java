package com.tencent.mobileqq.portal;

import azms;
import com.tencent.widget.HongBaoListView;

public class ConversationHongBao$1
  implements Runnable
{
  public ConversationHongBao$1(azms paramazms) {}
  
  public void run()
  {
    if (this.this$0.a.getScrollY() == 0) {}
    for (;;)
    {
      return;
      if (this.this$0.d == 4)
      {
        this.this$0.a.setSpringbackOffset(-this.this$0.b);
        if (Math.abs(this.this$0.a.getScrollY() + this.this$0.b) > this.this$0.b * 1.0F / 13.0F) {
          this.this$0.a.springBackTo(-this.this$0.b);
        }
      }
      while (!this.this$0.a.m)
      {
        this.this$0.a(false);
        return;
        this.this$0.a.setSpringbackOffset(0);
        if (this.this$0.a.getScrollY() != 0) {
          this.this$0.a.springBackTo(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBao.1
 * JD-Core Version:    0.7.0.1
 */
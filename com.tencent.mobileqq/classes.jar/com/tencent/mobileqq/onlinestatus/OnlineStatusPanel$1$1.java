package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$1$1
  implements Runnable
{
  OnlineStatusPanel$1$1(OnlineStatusPanel.1 param1, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    this.c.this$0.b.a(this.a);
    this.c.this$0.b.a = this.b;
    OnlineStatusPanel.b(this.c.this$0);
    this.c.this$0.b.notifyDataSetChanged();
    if (OnlineStatusPanel.c(this.c.this$0) == null) {
      this.c.this$0.setCurrentItem();
    } else {
      this.c.this$0.b.a(OnlineStatusPanel.c(this.c.this$0));
    }
    QQViewPager localQQViewPager = this.c.this$0.a;
    int i = this.c.this$0.b.getCount();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    localQQViewPager.disableGesture(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1.1
 * JD-Core Version:    0.7.0.1
 */
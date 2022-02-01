package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$2$1
  implements Runnable
{
  OnlineStatusPanel$2$1(OnlineStatusPanel.2 param2, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    if (this.c.a)
    {
      localObject = this.a;
      if ((localObject != null) && (((ArrayList)localObject).equals(this.c.this$0.b.a())))
      {
        this.c.this$0.b.c();
        this.c.this$0.setCurrentItem();
        return;
      }
    }
    this.c.this$0.b.a(this.a);
    this.c.this$0.b.a = this.b;
    OnlineStatusPanel.b(this.c.this$0);
    this.c.this$0.b.notifyDataSetChanged();
    this.c.this$0.setCurrentItem();
    Object localObject = this.c.this$0.a;
    int i = this.c.this$0.b.getCount();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    ((QQViewPager)localObject).disableGesture(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.2.1
 * JD-Core Version:    0.7.0.1
 */
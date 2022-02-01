package com.tencent.mobileqq.kandian.biz.fastweb.event;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import mqq.os.MqqHandler;

public class ItemShowDispatcher$OneSecondCallbackLoop
  implements Runnable
{
  private AbsListView a;
  private int b;
  
  public ItemShowDispatcher$OneSecondCallbackLoop(ItemShowDispatcher paramItemShowDispatcher, AbsListView paramAbsListView, int paramInt)
  {
    this.a = paramAbsListView;
    this.b = paramInt;
  }
  
  public void run()
  {
    QLog.d(ItemShowDispatcher.b(), 2, "  1秒到了 ");
    ItemShowDispatcher.a(this.this$0, this.a, this.b);
    if (ItemShowDispatcher.b(this.this$0)) {
      ThreadManager.getUIHandler().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.OneSecondCallbackLoop
 * JD-Core Version:    0.7.0.1
 */
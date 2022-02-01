package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;

class DraggableGridView$ScrollThread
  implements Runnable
{
  boolean a = true;
  private DraggableGridView b;
  private int c;
  
  public DraggableGridView$ScrollThread(DraggableGridView paramDraggableGridView)
  {
    this.b = paramDraggableGridView;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.c) {
      DraggableGridView.c(this.b, 0);
    }
    this.c = paramInt;
    if (this.a)
    {
      this.a = false;
      ThreadManager.post(this, 8, null, true);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.a)
      {
        int i = 0;
        int j = this.c;
        if (j == 1) {
          i = DisplayUtil.a(this.b.getContext(), 10.0F);
        } else if (j == 2) {
          i = -DisplayUtil.a(this.b.getContext(), 10.0F);
        }
        Message localMessage = new Message();
        localMessage.arg1 = i;
        DraggableGridView.p(this.b).sendMessage(localMessage);
      }
      try
      {
        Thread.sleep(16L);
      }
      catch (InterruptedException localInterruptedException) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.ScrollThread
 * JD-Core Version:    0.7.0.1
 */
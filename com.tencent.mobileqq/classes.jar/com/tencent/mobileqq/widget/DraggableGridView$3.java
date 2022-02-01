package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.widget.ListView;

class DraggableGridView$3
  extends Handler
{
  DraggableGridView$3(DraggableGridView paramDraggableGridView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    DraggableGridView.c(this.a, paramMessage.arg1);
    DraggableGridView.m(this.a).smoothScrollBy(DraggableGridView.l(this.a), 0);
    paramMessage = this.a;
    DraggableGridView.a(paramMessage, (int)DraggableGridView.n(paramMessage), (int)DraggableGridView.o(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.3
 * JD-Core Version:    0.7.0.1
 */
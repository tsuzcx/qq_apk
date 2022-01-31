package com.tencent.tissue.miniapp.hdasync;

import android.os.Handler.Callback;
import android.os.Message;

class HdAsync$HandlerCallback
  implements Handler.Callback
{
  HdAsync$HandlerCallback(HdAsync paramHdAsync) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof HdAsync.Data)) {}
    do
    {
      return false;
      paramMessage = (HdAsync.Data)paramMessage.obj;
      paramMessage = paramMessage.action.call(paramMessage.args);
      HdAsync.access$000(this.this$0).finishOneAction();
    } while (paramMessage == null);
    HdAsync.access$100(this.this$0, paramMessage.value, paramMessage.needNext);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.HdAsync.HandlerCallback
 * JD-Core Version:    0.7.0.1
 */
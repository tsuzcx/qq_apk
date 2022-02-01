package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class DefaultDispatcher$InternalHandler
  extends Handler
{
  public DefaultDispatcher$InternalHandler(DefaultDispatcher paramDefaultDispatcher, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 16) {
      return;
    }
    paramMessage = (PendingPost)paramMessage.obj;
    DefaultDispatcher.access$000(this.this$0).enqueue(paramMessage.tag, paramMessage.group, paramMessage.dispatchable);
    PendingPost.releasePendingPost(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.InternalHandler
 * JD-Core Version:    0.7.0.1
 */
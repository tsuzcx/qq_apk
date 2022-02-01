package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class GroupVideoLoadingFragment$3
  extends Handler
{
  GroupVideoLoadingFragment$3(GroupVideoLoadingFragment paramGroupVideoLoadingFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (i < GroupVideoLoadingFragment.a(this.a)) {
      return;
    }
    GroupVideoLoadingFragment.b(this.a, i);
    GroupVideoLoadingFragment.a(this.a).a(GroupVideoLoadingFragment.a(this.a), 0L);
    paramMessage = Message.obtain();
    if (GroupVideoLoadingFragment.a(this.a) >= 90) {
      i += 1;
    }
    for (;;)
    {
      paramMessage.arg1 = i;
      sendMessageDelayed(paramMessage, 500L);
      return;
      i += 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.3
 * JD-Core Version:    0.7.0.1
 */
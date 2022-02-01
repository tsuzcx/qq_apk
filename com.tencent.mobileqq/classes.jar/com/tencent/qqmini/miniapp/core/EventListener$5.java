package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.sdk.MiniSDK;

class EventListener$5
  implements Runnable
{
  EventListener$5(EventListener paramEventListener) {}
  
  public void run()
  {
    MiniSDK.startMiniApp(this.this$0.mRuntime.getAttachedActivity(), EventListener.access$200(this.this$0), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.EventListener.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.viola.module;

import com.tencent.viola.adapter.VWebSocketAdapter;

class WebSocketModule$1
  implements Runnable
{
  WebSocketModule$1(WebSocketModule paramWebSocketModule) {}
  
  public void run()
  {
    if (WebSocketModule.access$500(this.this$0) != null) {
      WebSocketModule.access$500(this.this$0).destroy();
    }
    WebSocketModule.access$502(this.this$0, null);
    WebSocketModule.access$602(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.WebSocketModule.1
 * JD-Core Version:    0.7.0.1
 */
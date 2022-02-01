package com.tencent.mobileqq.mini.network.websocket;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.MiniAppWebsocketListener;

class WebsocketRequestTask$1
  implements Runnable
{
  WebsocketRequestTask$1(WebsocketRequestTask paramWebsocketRequestTask, int paramInt, String paramString) {}
  
  public void run()
  {
    WebsocketRequestTask.access$000(this.this$0).onActivelyClose(this.val$i, this.val$reson);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask.1
 * JD-Core Version:    0.7.0.1
 */
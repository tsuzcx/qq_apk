package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;

class WebSocketProxyImpl$1
  implements Runnable
{
  WebSocketProxyImpl$1(WebSocketProxyImpl paramWebSocketProxyImpl, WebSocketProxyImpl.WebSocketTask paramWebSocketTask, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onClose(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */
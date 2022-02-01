package com.tencent.qqmini.proxyimpl;

import blaz;
import blba;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;

public class WebSocketProxyImpl$1
  implements Runnable
{
  public WebSocketProxyImpl$1(blaz paramblaz, blba paramblba, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Blba.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Blba.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onClose(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */
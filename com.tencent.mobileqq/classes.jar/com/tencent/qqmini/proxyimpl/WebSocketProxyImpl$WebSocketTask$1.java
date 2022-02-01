package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

class WebSocketProxyImpl$WebSocketTask$1
  extends WebSocketListener
{
  WebSocketProxyImpl$WebSocketTask$1(WebSocketProxyImpl.WebSocketTask paramWebSocketTask, WebSocketProxyImpl paramWebSocketProxyImpl) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    paramWebSocket = this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask;
    paramWebSocket.jdField_a_of_type_Boolean = true;
    paramWebSocket.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onClose(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int, paramInt, paramString);
    this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl.a.remove(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int));
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    QLog.e("WebSocketProxyImpl", 1, "onFailure : ", paramThrowable);
    this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onError(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int, HttpUtil.a(paramThrowable, -1), paramThrowable.getMessage());
    this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl.a.remove(Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int));
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onMessage(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int, paramString);
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onMessage(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int, paramByteString.toByteArray());
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    WebSocketProxyImpl.WebSocketTask localWebSocketTask = this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask;
    localWebSocketTask.jdField_a_of_type_Okhttp3WebSocket = paramWebSocket;
    localWebSocketTask.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyWebSocketProxy$WebSocketListener.onOpen(this.jdField_a_of_type_ComTencentQqminiProxyimplWebSocketProxyImpl$WebSocketTask.jdField_a_of_type_Int, paramResponse.code(), paramResponse.headers().toMultimap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.WebSocketProxyImpl.WebSocketTask.1
 * JD-Core Version:    0.7.0.1
 */
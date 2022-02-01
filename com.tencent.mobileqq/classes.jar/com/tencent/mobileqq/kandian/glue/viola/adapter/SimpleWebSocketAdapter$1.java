package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

class SimpleWebSocketAdapter$1
  extends WebSocketListener
{
  SimpleWebSocketAdapter$1(SimpleWebSocketAdapter paramSimpleWebSocketAdapter) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    super.onClosed(paramWebSocket, paramInt, paramString);
    if (SimpleWebSocketAdapter.a(this.a) == null) {
      return;
    }
    SimpleWebSocketAdapter.a(this.a).onClose(paramInt, paramString, true);
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    super.onFailure(paramWebSocket, paramThrowable, paramResponse);
    if (SimpleWebSocketAdapter.a(this.a) == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWebSocket = SimpleWebSocketAdapter.a;
      paramResponse = new StringBuilder();
      paramResponse.append("onFailure Exception:");
      paramResponse.append(paramThrowable.getMessage());
      QLog.e(paramWebSocket, 2, paramResponse.toString());
    }
    paramThrowable.printStackTrace();
    if ((paramThrowable instanceof EOFException))
    {
      SimpleWebSocketAdapter.a(this.a).onClose(WebSocketCloseCodes.CLOSE_NORMAL.getCode(), WebSocketCloseCodes.CLOSE_NORMAL.name(), true);
      return;
    }
    SimpleWebSocketAdapter.a(this.a).onError(paramThrowable.getMessage());
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    if (SimpleWebSocketAdapter.a(this.a) == null) {
      return;
    }
    SimpleWebSocketAdapter.a(this.a).onMessage(paramString);
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    if (SimpleWebSocketAdapter.a(this.a) == null) {
      return;
    }
    SimpleWebSocketAdapter.a(this.a, paramWebSocket);
    SimpleWebSocketAdapter.a(this.a).onOpen();
    paramWebSocket = paramResponse.headers();
    paramResponse = new HashMap();
    Iterator localIterator = paramWebSocket.names().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramResponse.put(str, paramWebSocket.values(str).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.SimpleWebSocketAdapter.1
 * JD-Core Version:    0.7.0.1
 */
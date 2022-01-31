import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okio.Buffer;

class rjz
  implements WebSocketListener
{
  rjz(rjy paramrjy) {}
  
  public void onClose(int paramInt, String paramString)
  {
    if (rjy.a(this.a) == null) {
      return;
    }
    rjy.a(this.a).onClose(paramInt, paramString, true);
  }
  
  public void onFailure(IOException paramIOException, Response paramResponse)
  {
    if (rjy.a(this.a) == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(rjy.a, 2, "onFailure Exception:" + paramIOException.getMessage());
    }
    paramIOException.printStackTrace();
    if ((paramIOException instanceof EOFException))
    {
      rjy.a(this.a).onClose(WebSocketCloseCodes.CLOSE_NORMAL.getCode(), WebSocketCloseCodes.CLOSE_NORMAL.name(), true);
      return;
    }
    rjy.a(this.a).onError(paramIOException.getMessage());
  }
  
  public void onMessage(ResponseBody paramResponseBody)
  {
    if (rjy.a(this.a) == null) {
      return;
    }
    rjy.a(this.a).onMessage(paramResponseBody.string());
    paramResponseBody.close();
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    if (rjy.a(this.a) == null) {}
    for (;;)
    {
      return;
      rjy.a(this.a, paramWebSocket);
      rjy.a(this.a).onOpen();
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
  
  public void onPong(Buffer paramBuffer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjz
 * JD-Core Version:    0.7.0.1
 */
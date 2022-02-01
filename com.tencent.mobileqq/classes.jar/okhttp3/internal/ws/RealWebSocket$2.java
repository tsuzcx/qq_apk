package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

class RealWebSocket$2
  implements Callback
{
  RealWebSocket$2(RealWebSocket paramRealWebSocket, Request paramRequest) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    this.this$0.failWebSocket(paramIOException, null);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      this.this$0.checkResponse(paramResponse);
      paramCall = Internal.instance.streamAllocation(paramCall);
      paramCall.noNewStreams();
      RealWebSocket.Streams localStreams = paramCall.connection().newWebSocketStreams(paramCall);
      try
      {
        this.this$0.listener.onOpen(this.this$0, paramResponse);
        paramResponse = new StringBuilder();
        paramResponse.append("OkHttp WebSocket ");
        paramResponse.append(this.val$request.url().redact());
        paramResponse = paramResponse.toString();
        this.this$0.initReaderAndWriter(paramResponse, localStreams);
        paramCall.connection().socket().setSoTimeout(0);
        this.this$0.loopReader();
        return;
      }
      catch (Exception paramCall)
      {
        this.this$0.failWebSocket(paramCall, null);
        return;
      }
      return;
    }
    catch (ProtocolException paramCall)
    {
      this.this$0.failWebSocket(paramCall, paramResponse);
      Util.closeQuietly(paramResponse);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.2
 * JD-Core Version:    0.7.0.1
 */
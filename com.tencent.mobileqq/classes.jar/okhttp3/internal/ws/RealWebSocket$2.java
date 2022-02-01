package okhttp3.internal.ws;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;

class RealWebSocket$2
  implements Callback
{
  RealWebSocket$2(RealWebSocket paramRealWebSocket, Request paramRequest) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    this.this$0.failWebSocket(paramIOException, null);
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   4: aload_2
    //   5: invokevirtual 38	okhttp3/internal/ws/RealWebSocket:checkResponse	(Lokhttp3/Response;)V
    //   8: getstatic 44	okhttp3/internal/Internal:instance	Lokhttp3/internal/Internal;
    //   11: aload_1
    //   12: invokevirtual 48	okhttp3/internal/Internal:streamAllocation	(Lokhttp3/Call;)Lokhttp3/internal/connection/StreamAllocation;
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 53	okhttp3/internal/connection/StreamAllocation:noNewStreams	()V
    //   20: aload_1
    //   21: invokevirtual 57	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
    //   24: aload_1
    //   25: invokevirtual 63	okhttp3/internal/connection/RealConnection:newWebSocketStreams	(Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   33: getfield 67	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   36: aload_0
    //   37: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   40: aload_2
    //   41: invokevirtual 73	okhttp3/WebSocketListener:onOpen	(Lokhttp3/WebSocket;Lokhttp3/Response;)V
    //   44: new 75	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   51: ldc 78
    //   53: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 16	okhttp3/internal/ws/RealWebSocket$2:val$request	Lokhttp3/Request;
    //   60: invokevirtual 88	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   63: invokevirtual 94	okhttp3/HttpUrl:redact	()Ljava/lang/String;
    //   66: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual 101	okhttp3/internal/ws/RealWebSocket:initReaderAndWriter	(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V
    //   82: aload_1
    //   83: invokevirtual 57	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
    //   86: invokevirtual 105	okhttp3/internal/connection/RealConnection:socket	()Ljava/net/Socket;
    //   89: iconst_0
    //   90: invokevirtual 111	java/net/Socket:setSoTimeout	(I)V
    //   93: aload_0
    //   94: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   97: invokevirtual 114	okhttp3/internal/ws/RealWebSocket:loopReader	()V
    //   100: return
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual 28	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
    //   111: aload_2
    //   112: invokestatic 120	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   115: return
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 14	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
    //   121: aload_1
    //   122: aconst_null
    //   123: invokevirtual 28	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
    //   126: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	2
    //   0	127	1	paramCall	Call
    //   0	127	2	paramResponse	okhttp3.Response
    //   28	51	3	localStreams	RealWebSocket.Streams
    // Exception table:
    //   from	to	target	type
    //   0	8	101	java/net/ProtocolException
    //   29	100	116	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.2
 * JD-Core Version:    0.7.0.1
 */
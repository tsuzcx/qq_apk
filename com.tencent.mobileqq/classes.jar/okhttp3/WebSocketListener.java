package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

public abstract class WebSocketListener
{
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString) {}
  
  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString) {}
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse) {}
  
  public void onMessage(WebSocket paramWebSocket, String paramString) {}
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString) {}
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.WebSocketListener
 * JD-Core Version:    0.7.0.1
 */
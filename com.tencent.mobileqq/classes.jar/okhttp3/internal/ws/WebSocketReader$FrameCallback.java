package okhttp3.internal.ws;

import okio.ByteString;

public abstract interface WebSocketReader$FrameCallback
{
  public abstract void onReadClose(int paramInt, String paramString);
  
  public abstract void onReadMessage(String paramString);
  
  public abstract void onReadMessage(ByteString paramByteString);
  
  public abstract void onReadPing(ByteString paramByteString);
  
  public abstract void onReadPong(ByteString paramByteString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketReader.FrameCallback
 * JD-Core Version:    0.7.0.1
 */
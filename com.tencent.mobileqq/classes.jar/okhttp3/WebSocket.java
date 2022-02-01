package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

public abstract interface WebSocket
{
  public abstract void cancel();
  
  public abstract boolean close(int paramInt, @Nullable String paramString);
  
  public abstract long queueSize();
  
  public abstract Request request();
  
  public abstract boolean send(String paramString);
  
  public abstract boolean send(ByteString paramByteString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.WebSocket
 * JD-Core Version:    0.7.0.1
 */
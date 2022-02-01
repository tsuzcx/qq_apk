package okhttp3.internal.http2;

import java.util.List;
import okio.BufferedSource;
import okio.ByteString;

abstract interface Http2Reader$Handler
{
  public abstract void ackSettings();
  
  public abstract void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong);
  
  public abstract void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2);
  
  public abstract void goAway(int paramInt, ErrorCode paramErrorCode, ByteString paramByteString);
  
  public abstract void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList);
  
  public abstract void ping(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void pushPromise(int paramInt1, int paramInt2, List<Header> paramList);
  
  public abstract void rstStream(int paramInt, ErrorCode paramErrorCode);
  
  public abstract void settings(boolean paramBoolean, Settings paramSettings);
  
  public abstract void windowUpdate(int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Reader.Handler
 * JD-Core Version:    0.7.0.1
 */
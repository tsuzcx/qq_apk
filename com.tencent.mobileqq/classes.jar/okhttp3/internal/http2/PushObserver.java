package okhttp3.internal.http2;

import java.util.List;
import okio.BufferedSource;

public abstract interface PushObserver
{
  public static final PushObserver CANCEL = new PushObserver.1();
  
  public abstract boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean);
  
  public abstract boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean);
  
  public abstract boolean onRequest(int paramInt, List<Header> paramList);
  
  public abstract void onReset(int paramInt, ErrorCode paramErrorCode);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.PushObserver
 * JD-Core Version:    0.7.0.1
 */
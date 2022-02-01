package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import okhttp3.internal.NamedRunnable;

class Http2Connection$5
  extends NamedRunnable
{
  Http2Connection$5(Http2Connection paramHttp2Connection, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    boolean bool = this.this$0.pushObserver.onHeaders(this.val$streamId, this.val$requestHeaders, this.val$inFinished);
    if (bool) {}
    try
    {
      this.this$0.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
      if ((bool) || (this.val$inFinished)) {
        synchronized (this.this$0)
        {
          this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.5
 * JD-Core Version:    0.7.0.1
 */
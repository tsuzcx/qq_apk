package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Set;
import okhttp3.internal.NamedRunnable;
import okio.Buffer;

class Http2Connection$6
  extends NamedRunnable
{
  Http2Connection$6(Http2Connection paramHttp2Connection, String paramString, Object[] paramArrayOfObject, int paramInt1, Buffer paramBuffer, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      boolean bool = this.this$0.pushObserver.onData(this.val$streamId, this.val$buffer, this.val$byteCount, this.val$inFinished);
      if (bool) {
        this.this$0.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.6
 * JD-Core Version:    0.7.0.1
 */
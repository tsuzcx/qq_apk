package okhttp3.internal.http2;

import java.util.Set;
import okhttp3.internal.NamedRunnable;

class Http2Connection$7
  extends NamedRunnable
{
  Http2Connection$7(Http2Connection paramHttp2Connection, String paramString, Object[] paramArrayOfObject, int paramInt, ErrorCode paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    this.this$0.pushObserver.onReset(this.val$streamId, this.val$errorCode);
    synchronized (this.this$0)
    {
      this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.7
 * JD-Core Version:    0.7.0.1
 */
package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.platform.Platform;

class Http2Connection$ReaderRunnable$1
  extends NamedRunnable
{
  Http2Connection$ReaderRunnable$1(Http2Connection.ReaderRunnable paramReaderRunnable, String paramString, Object[] paramArrayOfObject, Http2Stream paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this.this$1.this$0.listener.onStream(this.val$newStream);
      return;
    }
    catch (IOException localIOException1)
    {
      Platform localPlatform = Platform.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Http2Connection.Listener failure for ");
      localStringBuilder.append(this.this$1.this$0.hostname);
      localPlatform.log(4, localStringBuilder.toString(), localIOException1);
      try
      {
        this.val$newStream.close(ErrorCode.PROTOCOL_ERROR);
        return;
      }
      catch (IOException localIOException2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
 * JD-Core Version:    0.7.0.1
 */
package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

class Http2Connection$ReaderRunnable$3
  extends NamedRunnable
{
  Http2Connection$ReaderRunnable$3(Http2Connection.ReaderRunnable paramReaderRunnable, String paramString, Object... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public void execute()
  {
    this.this$1.this$0.listener.onSettings(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
 * JD-Core Version:    0.7.0.1
 */
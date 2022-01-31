package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

class Http2Connection$ReaderRunnable$2
  extends NamedRunnable
{
  Http2Connection$ReaderRunnable$2(Http2Connection.ReaderRunnable paramReaderRunnable, String paramString, Object[] paramArrayOfObject, boolean paramBoolean, Settings paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    this.this$1.applyAndAckSettings(this.val$clearPrevious, this.val$settings);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
 * JD-Core Version:    0.7.0.1
 */
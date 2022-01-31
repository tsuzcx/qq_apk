package okio;

import java.io.IOException;

class AsyncTimeout$1
  implements Sink
{
  AsyncTimeout$1(AsyncTimeout paramAsyncTimeout, Sink paramSink) {}
  
  public void close()
  {
    this.this$0.enter();
    try
    {
      this.val$sink.close();
      this.this$0.exit(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.this$0.exit(localIOException);
    }
    finally
    {
      this.this$0.exit(false);
    }
  }
  
  public void flush()
  {
    this.this$0.enter();
    try
    {
      this.val$sink.flush();
      this.this$0.exit(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.this$0.exit(localIOException);
    }
    finally
    {
      this.this$0.exit(false);
    }
  }
  
  public Timeout timeout()
  {
    return this.this$0;
  }
  
  public String toString()
  {
    return "AsyncTimeout.sink(" + this.val$sink + ")";
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    this.this$0.enter();
    try
    {
      this.val$sink.write(paramBuffer, paramLong);
      this.this$0.exit(true);
      return;
    }
    catch (IOException paramBuffer)
    {
      throw this.this$0.exit(paramBuffer);
    }
    finally
    {
      this.this$0.exit(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.AsyncTimeout.1
 * JD-Core Version:    0.7.0.1
 */
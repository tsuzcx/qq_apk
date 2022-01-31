package okio;

import java.io.IOException;

class AsyncTimeout$2
  implements Source
{
  AsyncTimeout$2(AsyncTimeout paramAsyncTimeout, Source paramSource) {}
  
  public void close()
  {
    try
    {
      this.val$source.close();
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
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    this.this$0.enter();
    try
    {
      paramLong = this.val$source.read(paramBuffer, paramLong);
      this.this$0.exit(true);
      return paramLong;
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
  
  public Timeout timeout()
  {
    return this.this$0;
  }
  
  public String toString()
  {
    return "AsyncTimeout.source(" + this.val$source + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okio.AsyncTimeout.2
 * JD-Core Version:    0.7.0.1
 */
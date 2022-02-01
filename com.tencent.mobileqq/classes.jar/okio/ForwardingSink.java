package okio;

public abstract class ForwardingSink
  implements Sink
{
  private final Sink delegate;
  
  public ForwardingSink(Sink paramSink)
  {
    if (paramSink != null)
    {
      this.delegate = paramSink;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public final Sink delegate()
  {
    return this.delegate;
  }
  
  public void flush()
  {
    this.delegate.flush();
  }
  
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.delegate.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    this.delegate.write(paramBuffer, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.ForwardingSink
 * JD-Core Version:    0.7.0.1
 */
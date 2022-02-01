package okio;

public abstract class ForwardingSource
  implements Source
{
  private final Source delegate;
  
  public ForwardingSource(Source paramSource)
  {
    if (paramSource != null)
    {
      this.delegate = paramSource;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public final Source delegate()
  {
    return this.delegate;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    return this.delegate.read(paramBuffer, paramLong);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.ForwardingSource
 * JD-Core Version:    0.7.0.1
 */
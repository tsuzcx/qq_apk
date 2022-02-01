package okio;

public final class Pipe
{
  final Buffer buffer = new Buffer();
  final long maxBufferSize;
  private final Sink sink = new Pipe.PipeSink(this);
  boolean sinkClosed;
  private final Source source = new Pipe.PipeSource(this);
  boolean sourceClosed;
  
  public Pipe(long paramLong)
  {
    if (paramLong >= 1L)
    {
      this.maxBufferSize = paramLong;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxBufferSize < 1: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final Sink sink()
  {
    return this.sink;
  }
  
  public final Source source()
  {
    return this.source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Pipe
 * JD-Core Version:    0.7.0.1
 */
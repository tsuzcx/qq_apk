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
    if (paramLong < 1L) {
      throw new IllegalArgumentException("maxBufferSize < 1: " + paramLong);
    }
    this.maxBufferSize = paramLong;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okio.Pipe
 * JD-Core Version:    0.7.0.1
 */
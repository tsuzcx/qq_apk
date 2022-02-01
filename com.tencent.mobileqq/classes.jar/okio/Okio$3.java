package okio;

final class Okio$3
  implements Sink
{
  public void close() {}
  
  public void flush() {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    paramBuffer.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okio.Okio.3
 * JD-Core Version:    0.7.0.1
 */
package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.Util;

public final class RouteException
  extends RuntimeException
{
  private IOException firstException;
  private IOException lastException;
  
  public RouteException(IOException paramIOException)
  {
    super(paramIOException);
    this.firstException = paramIOException;
    this.lastException = paramIOException;
  }
  
  public void addConnectException(IOException paramIOException)
  {
    Util.addSuppressedIfPossible(this.firstException, paramIOException);
    this.lastException = paramIOException;
  }
  
  public IOException getFirstConnectException()
  {
    return this.firstException;
  }
  
  public IOException getLastConnectException()
  {
    return this.lastException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.connection.RouteException
 * JD-Core Version:    0.7.0.1
 */
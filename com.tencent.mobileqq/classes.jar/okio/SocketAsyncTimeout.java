package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, k=1, mv={1, 1, 16})
final class SocketAsyncTimeout
  extends AsyncTimeout
{
  private final Logger logger;
  private final Socket socket;
  
  public SocketAsyncTimeout(@NotNull Socket paramSocket)
  {
    this.socket = paramSocket;
    this.logger = Logger.getLogger("okio.Okio");
  }
  
  @NotNull
  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause((Throwable)paramIOException);
    }
    return (IOException)localSocketTimeoutException;
  }
  
  protected void timedOut()
  {
    try
    {
      this.socket.close();
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if (Okio.isAndroidGetsocknameError(localAssertionError))
      {
        localLogger = this.logger;
        localLevel = Level.WARNING;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to close timed out socket ");
        localStringBuilder.append(this.socket);
        localLogger.log(localLevel, localStringBuilder.toString(), (Throwable)localAssertionError);
        return;
      }
      throw ((Throwable)localAssertionError);
    }
    catch (Exception localException)
    {
      Logger localLogger = this.logger;
      Level localLevel = Level.WARNING;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to close timed out socket ");
      localStringBuilder.append(this.socket);
      localLogger.log(localLevel, localStringBuilder.toString(), (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.SocketAsyncTimeout
 * JD-Core Version:    0.7.0.1
 */
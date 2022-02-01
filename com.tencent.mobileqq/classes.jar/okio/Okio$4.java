package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class Okio$4
  extends AsyncTimeout
{
  Okio$4(Socket paramSocket) {}
  
  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void timedOut()
  {
    try
    {
      this.val$socket.close();
      return;
    }
    catch (Exception localException)
    {
      Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + this.val$socket, localException);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if (Okio.isAndroidGetsocknameError(localAssertionError))
      {
        Okio.logger.log(Level.WARNING, "Failed to close timed out socket " + this.val$socket, localAssertionError);
        return;
      }
      throw localAssertionError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okio.Okio.4
 * JD-Core Version:    0.7.0.1
 */
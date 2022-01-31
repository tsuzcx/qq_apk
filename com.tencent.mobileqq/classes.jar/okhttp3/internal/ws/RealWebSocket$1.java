package okhttp3.internal.ws;

import java.io.IOException;

class RealWebSocket$1
  implements Runnable
{
  RealWebSocket$1(RealWebSocket paramRealWebSocket) {}
  
  public void run()
  {
    try
    {
      boolean bool;
      do
      {
        bool = this.this$0.writeOneFrame();
      } while (bool);
      return;
    }
    catch (IOException localIOException)
    {
      this.this$0.failWebSocket(localIOException, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.1
 * JD-Core Version:    0.7.0.1
 */
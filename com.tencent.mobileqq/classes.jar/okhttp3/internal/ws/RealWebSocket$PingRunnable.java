package okhttp3.internal.ws;

final class RealWebSocket$PingRunnable
  implements Runnable
{
  RealWebSocket$PingRunnable(RealWebSocket paramRealWebSocket) {}
  
  public void run()
  {
    this.this$0.writePingFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket.PingRunnable
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qlink;

import java.util.concurrent.ConcurrentLinkedQueue;

class QlinkServiceProxy$2
  extends Thread
{
  QlinkServiceProxy$2(QlinkServiceProxy paramQlinkServiceProxy) {}
  
  public void run()
  {
    while (!QlinkServiceProxy.d(this.this$0).isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)QlinkServiceProxy.d(this.this$0).poll();
      if (localSendMsg != null) {
        try
        {
          QlinkServiceProxy.a(this.this$0, localSendMsg);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceProxy.2
 * JD-Core Version:    0.7.0.1
 */
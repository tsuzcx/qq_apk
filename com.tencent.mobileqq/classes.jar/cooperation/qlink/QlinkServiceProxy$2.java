package cooperation.qlink;

import blic;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QlinkServiceProxy$2
  extends Thread
{
  public QlinkServiceProxy$2(blic paramblic) {}
  
  public void run()
  {
    while (!blic.a(this.this$0).isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)blic.a(this.this$0).poll();
      if (localSendMsg != null) {
        try
        {
          blic.a(this.this$0, localSendMsg);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceProxy.2
 * JD-Core Version:    0.7.0.1
 */
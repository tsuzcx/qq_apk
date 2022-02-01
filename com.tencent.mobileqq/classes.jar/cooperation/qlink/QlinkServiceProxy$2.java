package cooperation.qlink;

import bmjf;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QlinkServiceProxy$2
  extends Thread
{
  public QlinkServiceProxy$2(bmjf parambmjf) {}
  
  public void run()
  {
    while (!bmjf.a(this.this$0).isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)bmjf.a(this.this$0).poll();
      if (localSendMsg != null) {
        try
        {
          bmjf.a(this.this$0, localSendMsg);
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
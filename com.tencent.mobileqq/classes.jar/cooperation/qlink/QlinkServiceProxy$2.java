package cooperation.qlink;

import bffz;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QlinkServiceProxy$2
  extends Thread
{
  public QlinkServiceProxy$2(bffz parambffz) {}
  
  public void run()
  {
    while (!bffz.a(this.this$0).isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)bffz.a(this.this$0).poll();
      if (localSendMsg != null) {
        try
        {
          bffz.a(this.this$0, localSendMsg);
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
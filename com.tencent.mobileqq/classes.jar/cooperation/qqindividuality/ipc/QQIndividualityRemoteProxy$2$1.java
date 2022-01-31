package cooperation.qqindividuality.ipc;

import biya;
import biyb;
import biyc;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(biyb parambiyb) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      biyc localbiyc = (biyc)this.a.a.a.poll();
      if (localbiyc != null) {
        this.a.a.a(localbiyc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
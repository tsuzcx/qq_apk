package cooperation.qqindividuality.ipc;

import bmno;
import bmnp;
import bmnq;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bmnp parambmnp) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bmnq localbmnq = (bmnq)this.a.a.a.poll();
      if (localbmnq != null) {
        this.a.a.a(localbmnq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
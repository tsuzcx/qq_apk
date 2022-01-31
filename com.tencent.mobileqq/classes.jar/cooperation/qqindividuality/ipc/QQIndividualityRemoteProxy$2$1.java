package cooperation.qqindividuality.ipc;

import bgsd;
import bgse;
import bgsf;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bgse parambgse) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bgsf localbgsf = (bgsf)this.a.a.a.poll();
      if (localbgsf != null) {
        this.a.a.a(localbgsf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
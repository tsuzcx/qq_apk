package cooperation.qqindividuality.ipc;

import bgsu;
import bgsv;
import bgsw;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bgsv parambgsv) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bgsw localbgsw = (bgsw)this.a.a.a.poll();
      if (localbgsw != null) {
        this.a.a.a(localbgsw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
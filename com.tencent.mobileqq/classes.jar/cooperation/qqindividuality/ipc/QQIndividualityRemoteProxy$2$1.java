package cooperation.qqindividuality.ipc;

import bkrv;
import bkrw;
import bkrx;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bkrw parambkrw) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bkrx localbkrx = (bkrx)this.a.a.a.poll();
      if (localbkrx != null) {
        this.a.a.a(localbkrx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
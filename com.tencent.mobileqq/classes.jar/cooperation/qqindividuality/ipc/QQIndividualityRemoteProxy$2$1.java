package cooperation.qqindividuality.ipc;

import blml;
import blmm;
import blmn;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(blmm paramblmm) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      blmn localblmn = (blmn)this.a.a.a.poll();
      if (localblmn != null) {
        this.a.a.a(localblmn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
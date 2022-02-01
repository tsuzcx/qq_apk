package cooperation.qqindividuality.ipc;

import bmde;
import bmdf;
import bmdg;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bmdf parambmdf) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bmdg localbmdg = (bmdg)this.a.a.a.poll();
      if (localbmdg != null) {
        this.a.a.a(localbmdg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
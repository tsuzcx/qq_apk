package cooperation.qqindividuality.ipc;

import bfkl;
import bfkm;
import bfkn;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bfkm parambfkm) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bfkn localbfkn = (bfkn)this.a.a.a.poll();
      if (localbfkn != null) {
        this.a.a.a(localbfkn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
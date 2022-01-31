package cooperation.qqindividuality.ipc;

import bitt;
import bitu;
import bitv;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  public QQIndividualityRemoteProxy$2$1(bitu parambitu) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bitv localbitv = (bitv)this.a.a.a.poll();
      if (localbitv != null) {
        this.a.a.a(localbitv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
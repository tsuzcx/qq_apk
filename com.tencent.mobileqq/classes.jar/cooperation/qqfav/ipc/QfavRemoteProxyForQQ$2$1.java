package cooperation.qqfav.ipc;

import bisb;
import bisc;
import bisd;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bisc parambisc) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bisd localbisd = (bisd)this.a.a.a.poll();
      if (localbisd != null) {
        bisb.a(this.a.a, localbisd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
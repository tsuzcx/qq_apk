package cooperation.qqfav.ipc;

import bfit;
import bfiu;
import bfiv;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bfiu parambfiu) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bfiv localbfiv = (bfiv)this.a.a.a.poll();
      if (localbfiv != null) {
        bfit.a(this.a.a, localbfiv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
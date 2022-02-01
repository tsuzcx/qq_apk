package cooperation.qqfav.ipc;

import bmlx;
import bmly;
import bmlz;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bmly parambmly) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bmlz localbmlz = (bmlz)this.a.a.a.poll();
      if (localbmlz != null) {
        bmlx.a(this.a.a, localbmlz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
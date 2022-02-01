package cooperation.qqfav.ipc;

import bmbm;
import bmbn;
import bmbo;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bmbn parambmbn) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bmbo localbmbo = (bmbo)this.a.a.a.poll();
      if (localbmbo != null) {
        bmbm.a(this.a.a, localbmbo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
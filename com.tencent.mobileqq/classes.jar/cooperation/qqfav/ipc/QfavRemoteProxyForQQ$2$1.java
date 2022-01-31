package cooperation.qqfav.ipc;

import biwi;
import biwj;
import biwk;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(biwj parambiwj) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      biwk localbiwk = (biwk)this.a.a.a.poll();
      if (localbiwk != null) {
        biwi.a(this.a.a, localbiwk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
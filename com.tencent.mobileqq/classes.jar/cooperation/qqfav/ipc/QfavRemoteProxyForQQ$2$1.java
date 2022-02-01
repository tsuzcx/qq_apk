package cooperation.qqfav.ipc;

import bkqe;
import bkqf;
import bkqg;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bkqf parambkqf) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bkqg localbkqg = (bkqg)this.a.a.a.poll();
      if (localbkqg != null) {
        bkqe.a(this.a.a, localbkqg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
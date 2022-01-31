package cooperation.qqfav.ipc;

import bgql;
import bgqm;
import bgqn;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bgqm parambgqm) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bgqn localbgqn = (bgqn)this.a.a.a.poll();
      if (localbgqn != null) {
        bgql.a(this.a.a, localbgqn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
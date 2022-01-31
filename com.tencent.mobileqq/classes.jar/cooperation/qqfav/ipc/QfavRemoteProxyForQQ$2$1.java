package cooperation.qqfav.ipc;

import bgrc;
import bgrd;
import bgre;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(bgrd parambgrd) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      bgre localbgre = (bgre)this.a.a.a.poll();
      if (localbgre != null) {
        bgrc.a(this.a.a, localbgre);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
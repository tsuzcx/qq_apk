package cooperation.qqfav.ipc;

import blku;
import blkv;
import blkw;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  public QfavRemoteProxyForQQ$2$1(blkv paramblkv) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      blkw localblkw = (blkw)this.a.a.a.poll();
      if (localblkw != null) {
        blku.a(this.a.a, localblkw);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
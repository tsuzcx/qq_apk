package cooperation.qqfav.ipc;

import java.util.concurrent.ConcurrentLinkedQueue;

class QfavRemoteProxyForQQ$2$1
  extends Thread
{
  QfavRemoteProxyForQQ$2$1(QfavRemoteProxyForQQ.2 param2) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper localQfavRemoteProxyCallWrapper = (QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper)this.a.a.a.poll();
      if (localQfavRemoteProxyCallWrapper != null) {
        QfavRemoteProxyForQQ.a(this.a.a, localQfavRemoteProxyCallWrapper);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ.2.1
 * JD-Core Version:    0.7.0.1
 */
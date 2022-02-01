package cooperation.qqindividuality.ipc;

import java.util.concurrent.ConcurrentLinkedQueue;

class QQIndividualityRemoteProxy$2$1
  extends Thread
{
  QQIndividualityRemoteProxy$2$1(QQIndividualityRemoteProxy.2 param2) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper localQQIndividualityRemoteProxyCallWrapper = (QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper)this.a.a.a.poll();
      if (localQQIndividualityRemoteProxyCallWrapper != null) {
        this.a.a.a(localQQIndividualityRemoteProxyCallWrapper);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.2.1
 * JD-Core Version:    0.7.0.1
 */
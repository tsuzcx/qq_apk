package cooperation.qzone.statistic.access;

import android.net.Proxy;

final class HttpDeliverer$IProxy$1
  extends HttpDeliverer.IProxy
{
  public String getHost()
  {
    return Proxy.getDefaultHost();
  }
  
  public int getPort()
  {
    return Proxy.getDefaultPort();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpDeliverer.IProxy.1
 * JD-Core Version:    0.7.0.1
 */
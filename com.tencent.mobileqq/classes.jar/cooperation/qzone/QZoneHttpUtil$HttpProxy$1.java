package cooperation.qzone;

import android.net.Proxy;

final class QZoneHttpUtil$HttpProxy$1
  extends QZoneHttpUtil.HttpProxy
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil.HttpProxy.1
 * JD-Core Version:    0.7.0.1
 */
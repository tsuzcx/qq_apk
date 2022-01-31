package cooperation.qzone.webviewplugin;

import bghk;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import mpl;

public class QZoneDNSAnalyzeJsPlugin$2
  implements Runnable
{
  public QZoneDNSAnalyzeJsPlugin$2(bghk parambghk, int paramInt) {}
  
  public void run()
  {
    int i = mpl.a();
    if ((i != 0) && (i != -1)) {
      try
      {
        String str = InetAddress.getByName("h5.qzone.qq.com").getHostAddress();
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "netType: " + i + " error code: " + this.a + ", Analyze h5.qzone.qq.com ip address : " + str);
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localUnknownHostException.printStackTrace();
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "netType: " + i + " error code: " + this.a + ", UnknownHostException:Analyze  h5.qzone.qq.com  ip address failed");
        return;
      }
    }
    QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "netType: " + i + " error code: " + this.a + ", No ActiveNetwork, Analyze  h5.qzone.qq.com  ip address failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
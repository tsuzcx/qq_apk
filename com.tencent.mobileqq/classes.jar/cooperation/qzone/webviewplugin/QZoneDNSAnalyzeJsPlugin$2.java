package cooperation.qzone.webviewplugin;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

class QZoneDNSAnalyzeJsPlugin$2
  implements Runnable
{
  QZoneDNSAnalyzeJsPlugin$2(QZoneDNSAnalyzeJsPlugin paramQZoneDNSAnalyzeJsPlugin, int paramInt) {}
  
  public void run()
  {
    int i = HttpUtil.getNetWorkType();
    if ((i != 0) && (i != -1)) {
      try
      {
        String str = InetAddress.getByName("h5.qzone.qq.com").getHostAddress();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("netType: ");
        localStringBuilder2.append(i);
        localStringBuilder2.append(" error code: ");
        localStringBuilder2.append(this.val$errorCode);
        localStringBuilder2.append(", Analyze h5.qzone.qq.com ip address : ");
        localStringBuilder2.append(str);
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, localStringBuilder2.toString());
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localUnknownHostException.printStackTrace();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("netType: ");
        localStringBuilder1.append(i);
        localStringBuilder1.append(" error code: ");
        localStringBuilder1.append(this.val$errorCode);
        localStringBuilder1.append(", UnknownHostException:Analyze  h5.qzone.qq.com  ip address failed");
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, localStringBuilder1.toString());
        return;
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("netType: ");
    localStringBuilder1.append(i);
    localStringBuilder1.append(" error code: ");
    localStringBuilder1.append(this.val$errorCode);
    localStringBuilder1.append(", No ActiveNetwork, Analyze  h5.qzone.qq.com  ip address failed");
    QLog.e("QZoneDNSAnalyzeJsPlugin", 1, localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
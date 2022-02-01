package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

class QZoneDNSAnalyzeJsPlugin$1
  implements Runnable
{
  QZoneDNSAnalyzeJsPlugin$1(QZoneDNSAnalyzeJsPlugin paramQZoneDNSAnalyzeJsPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "";
    try
    {
      String str = InetAddress.getByName(this.val$host).getHostAddress();
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "Analyze " + this.val$host + " ip address : " + str);
        localObject = str;
        QZoneDNSAnalyzeJsPlugin.access$000(this.this$0, this.val$callback, 0, str);
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "UnknownHostException:Analyze " + this.val$host + " ip address failed");
      QZoneDNSAnalyzeJsPlugin.access$000(this.this$0, this.val$callback, -1, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
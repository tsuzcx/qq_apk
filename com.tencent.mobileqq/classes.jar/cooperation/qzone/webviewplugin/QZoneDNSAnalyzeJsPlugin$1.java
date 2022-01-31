package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import bghk;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class QZoneDNSAnalyzeJsPlugin$1
  implements Runnable
{
  public QZoneDNSAnalyzeJsPlugin$1(bghk parambghk, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "";
    try
    {
      String str = InetAddress.getByName(this.a).getHostAddress();
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "Analyze " + this.a + " ip address : " + str);
        localObject = str;
        bghk.a(this.this$0, this.b, 0, str);
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      QLog.e("QZoneDNSAnalyzeJsPlugin", 1, "UnknownHostException:Analyze " + this.a + " ip address failed");
      bghk.a(this.this$0, this.b, -1, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
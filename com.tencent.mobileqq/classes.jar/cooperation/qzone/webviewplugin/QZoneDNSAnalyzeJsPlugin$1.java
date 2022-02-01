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
    Object localObject1 = "";
    try
    {
      localObject2 = InetAddress.getByName(this.val$host).getHostAddress();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append("Analyze ");
        localObject1 = localObject2;
        localStringBuilder.append(this.val$host);
        localObject1 = localObject2;
        localStringBuilder.append(" ip address : ");
        localObject1 = localObject2;
        localStringBuilder.append((String)localObject2);
        localObject1 = localObject2;
        QLog.e("QZoneDNSAnalyzeJsPlugin", 1, localStringBuilder.toString());
        localObject1 = localObject2;
        QZoneDNSAnalyzeJsPlugin.access$000(this.this$0, this.val$callback, 0, (String)localObject2);
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      Object localObject2;
      label98:
      break label98;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("UnknownHostException:Analyze ");
    ((StringBuilder)localObject2).append(this.val$host);
    ((StringBuilder)localObject2).append(" ip address failed");
    QLog.e("QZoneDNSAnalyzeJsPlugin", 1, ((StringBuilder)localObject2).toString());
    QZoneDNSAnalyzeJsPlugin.access$000(this.this$0, this.val$callback, -1, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QRPluginProxyActivity
  extends PluginProxyActivity
{
  public String getPluginID()
  {
    return "qqreaderplugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("com.qqreader.ReaderPage".equals(paramString)) {
      return QRReaderPageProxyActivity.class;
    }
    if ("com.qqreader.webview.activity.ReaderBrowserActivity".equals(paramString)) {
      return QRHardWareActivity.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
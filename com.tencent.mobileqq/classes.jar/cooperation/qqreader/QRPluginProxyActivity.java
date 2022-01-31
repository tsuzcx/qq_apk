package cooperation.qqreader;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QRPluginProxyActivity
  extends PluginProxyActivity
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if ("com.qqreader.pureader.SSReaderActivity".equals(paramString)) {
      return QRReaderPageProxyActivity.class;
    }
    return QRPluginProxyActivity.class;
  }
  
  public String getPluginID()
  {
    return "qqreaderplugin.apk";
  }
  
  public final Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.remove("android:fragments");
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    paramBundle = getIntent();
    if (paramBundle != null) {
      paramBundle.putExtra("big_brother_source_key", "biz_src_jc_neirong");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.QRPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */
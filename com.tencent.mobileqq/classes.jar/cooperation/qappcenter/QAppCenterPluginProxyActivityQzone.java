package cooperation.qappcenter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QAppCenterPluginProxyActivityQzone
  extends PluginProxyActivity
{
  public static boolean a;
  
  public void onCreate(Bundle paramBundle)
  {
    QAppCenterPluginProxyActivityTools.a(this);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("big_brother_source_key", "biz_src_yyb");
    }
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    a = false;
  }
  
  public void onResume()
  {
    super.onResume();
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qappcenter.QAppCenterPluginProxyActivityQzone
 * JD-Core Version:    0.7.0.1
 */
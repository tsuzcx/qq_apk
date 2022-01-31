package cooperation.qappcenter;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QAppCenterPluginProxyActivityTools
  extends PluginProxyActivity
{
  public static boolean a;
  
  protected void onPause()
  {
    super.onPause();
    a = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qappcenter.QAppCenterPluginProxyActivityTools
 * JD-Core Version:    0.7.0.1
 */
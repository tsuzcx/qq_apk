package cooperation.ilive;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.ilive.time.TimeMonitorConfig;

final class IlivePluginHelper$1
  implements EnterCallback
{
  public void onCloseLoadingView() {}
  
  public void onEnterComplete()
  {
    QLog.i("IlivePluginHelper", 1, "Ilive finish preloadOdexPlugin");
    TimeMonitorConfig.b("ilive_monitor_preload_odex");
  }
  
  public void onShowLoadingView(View paramView)
  {
    QLog.i("IlivePluginHelper", 1, "Ilive start preloadOdexPlugin");
    TimeMonitorConfig.a("ilive_monitor_preload_odex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IlivePluginHelper.1
 * JD-Core Version:    0.7.0.1
 */
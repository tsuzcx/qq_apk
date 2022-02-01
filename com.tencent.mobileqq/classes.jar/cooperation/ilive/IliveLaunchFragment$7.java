package cooperation.ilive;

import android.view.View;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.ilive.time.TimeMonitorConfig;
import cooperation.ilive.time.TimeMonitorData;
import cooperation.ilive.time.TimeMonitorManager;
import cooperation.ilive.util.ElapseStat;
import cooperation.ilive.util.IlivePreloadHelper;
import kotlin.Pair;

final class IliveLaunchFragment$7
  implements EnterCallback
{
  public void onCloseLoadingView()
  {
    if (IlivePreloadHelper.a) {
      IliveLaunchFragment.access$900();
    }
  }
  
  public void onEnterComplete()
  {
    TimeMonitorConfig.b("ilive_monitor_odex_plugin_load");
    if (IlivePreloadHelper.a) {
      return;
    }
    ElapseStat.b("IliveLaunch pluginParse");
    String str;
    if (QQVideoPlaySDKManager.isSoLoadSucess()) {
      str = "1";
    } else {
      str = "0";
    }
    VasStatisticCollector.b("live_player_ready", new Pair[] { new Pair("status_msg", str) });
    if (TimeMonitorManager.a().e("ANCHOR_ENTER_ROOM"))
    {
      TimeMonitorManager.a().d("ANCHOR_ENTER_ROOM").b("auchor_enter");
      TimeMonitorManager.a().a("ANCHOR_ENTER_ROOM");
    }
    if (TimeMonitorManager.a().e("WATCH_ENTER_ROOM"))
    {
      TimeMonitorManager.a().d("WATCH_ENTER_ROOM").b("watch_enter");
      TimeMonitorManager.a().a("WATCH_ENTER_ROOM");
    }
    TimeMonitorManager.a().d("PLUGIN_LOAD").b("enter_complete");
  }
  
  public void onShowLoadingView(View paramView)
  {
    ElapseStat.a("IliveLaunch pluginParse");
    TimeMonitorConfig.a("ilive_monitor_odex_plugin_load");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.7
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bmfw;
import bmgm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qqreader.host.ReaderHost;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nuz;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bmgm.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    paramContext = paramIntent.getStringExtra("params_uin_for_reader");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {
      ReaderHost.setAccount(str);
    }
    for (;;)
    {
      if (!paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
        bmfw.a(BaseApplicationImpl.getApplication(), false);
      }
      if (!a)
      {
        a = true;
        bmep.a = 2;
        bmgm.d("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ))
        {
          nuz.a();
          ThreadManager.post(new VipProxyRreLoadReaderProcess.1(this), 5, null, true);
        }
      }
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        ReaderHost.setAccount(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */
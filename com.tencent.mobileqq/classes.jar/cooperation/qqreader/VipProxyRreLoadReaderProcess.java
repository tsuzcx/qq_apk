package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bkun;
import bkvd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qqreader.host.ReaderHost;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nny;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bkvd.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    paramContext = paramIntent.getStringExtra("params_uin_for_reader");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {
      ReaderHost.setAccount(str);
    }
    for (;;)
    {
      if (!paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
        bkun.a(BaseApplicationImpl.getApplication(), false);
      }
      if (!a)
      {
        a = true;
        bktg.a = 2;
        bkvd.d("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ))
        {
          nny.a();
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
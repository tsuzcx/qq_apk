package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bhnv;
import bmqg;
import bmqw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.qqreader.host.ReaderHost;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nmj;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bmqw.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    paramContext = paramIntent.getStringExtra("params_uin_for_reader");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {
      ReaderHost.setAccount(str);
    }
    for (;;)
    {
      if (!paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
        bmqg.a(BaseApplicationImpl.getApplication(), false);
      }
      if (!a)
      {
        a = true;
        bmoz.a = 2;
        bmqw.d("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (bhnv.h(MobileQQ.sMobileQQ))
        {
          nmj.a();
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
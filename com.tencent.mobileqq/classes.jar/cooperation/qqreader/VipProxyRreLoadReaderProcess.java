package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bdin;
import bjat;
import bjbl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.qqreader.host.ReaderHost;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nbv;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bjbl.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    String str1 = paramIntent.getStringExtra("params_uin_for_reader");
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str2))
    {
      ReaderHost.setAccount(str2);
      if (!paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
        break label120;
      }
      bjat.b(paramContext);
    }
    for (;;)
    {
      if (!a)
      {
        a = true;
        bizm.a = 2;
        bjbl.d("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (bdin.h(MobileQQ.sMobileQQ))
        {
          nbv.a();
          ThreadManager.post(new VipProxyRreLoadReaderProcess.1(this), 5, null, true);
        }
      }
      return;
      if (TextUtils.isEmpty(str1)) {
        break;
      }
      ReaderHost.setAccount(str1);
      break;
      label120:
      bjat.a(BaseApplicationImpl.getApplication(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */
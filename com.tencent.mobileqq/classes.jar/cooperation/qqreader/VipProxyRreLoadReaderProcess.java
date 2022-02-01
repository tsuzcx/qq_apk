package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qqreader.host.ReaderHost;
import cooperation.qqreader.shadow.ReaderPluginHelper;
import cooperation.qqreader.utils.Log;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean a = false;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    paramContext = paramIntent.getStringExtra("params_uin_for_reader");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {
      ReaderHost.setAccount(str);
    }
    for (;;)
    {
      if (!paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
        ReaderPluginHelper.a(BaseApplicationImpl.getApplication(), false);
      }
      if (!a)
      {
        a = true;
        QReaderHelper.a = 2;
        Log.d("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (NetworkUtil.h(MobileQQ.sMobileQQ))
        {
          HtmlOffline.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */
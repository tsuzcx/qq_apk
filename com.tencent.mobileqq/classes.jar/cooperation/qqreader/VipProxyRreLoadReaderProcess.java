package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import bbfj;
import bgvn;
import bgwf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.MobileQQ;
import mzb;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  private static boolean a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bgwf.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess onReceive");
    super.onReceive(paramContext, paramIntent);
    if (paramIntent.getBooleanExtra("is_preload_reader_plugin", false)) {
      bgvn.b(paramContext);
    }
    for (;;)
    {
      if (!a)
      {
        a = true;
        bgug.a = 2;
        bgwf.d("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
        if (bbfj.h(MobileQQ.sMobileQQ))
        {
          mzb.a();
          ThreadManager.post(new VipProxyRreLoadReaderProcess.1(this), 5, null, true);
        }
      }
      return;
      bgvn.a(BaseApplicationImpl.getApplication(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */
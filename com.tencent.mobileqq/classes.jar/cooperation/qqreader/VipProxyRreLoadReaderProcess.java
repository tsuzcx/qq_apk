package cooperation.qqreader;

import android.content.Context;
import android.content.Intent;
import badq;
import bfmm;
import bfne;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mof;
import mqq.app.MobileQQ;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bfne.d("VipProxyRreLoadReaderProcess", "onReceive start");
    super.onReceive(paramContext, paramIntent);
    bfmm.a(BaseApplicationImpl.getApplication(), false);
    if (paramIntent.getBooleanExtra("isPreloadProcess", false))
    {
      bflp.a = 2;
      bfne.c("VipProxyRreLoadReaderProcess", "VipProxyRreLoadReaderProcess isPreloadProcess=true");
      if (badq.h(MobileQQ.sMobileQQ))
      {
        mof.a();
        ThreadManager.post(new VipProxyRreLoadReaderProcess.1(this), 5, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */
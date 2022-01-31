package cooperation.qqreader;

import amrb;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VipProxyRreLoadReaderProcess
  extends PluginProxyBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (paramIntent.getBooleanExtra("isPreloadProcess", false))
    {
      QReaderHelper.a = 2;
      paramContext = BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("qqreaderplugin.apk");
      if (QLog.isColorLevel()) {
        QLog.i("VipProxyRreLoadReaderProcess", 2, "VipProxyRreLoadReaderProcess isPreloadProcess=true");
      }
      if (NetworkUtil.h(MobileQQ.sMobileQQ))
      {
        HtmlOffline.a();
        ThreadManager.post(new amrb(this, paramContext), 5, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.VipProxyRreLoadReaderProcess
 * JD-Core Version:    0.7.0.1
 */
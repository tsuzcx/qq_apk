package cooperation.hce;

import android.os.Handler;
import bkkq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class HcePluginInstallActivity$1
  implements Runnable
{
  HcePluginInstallActivity$1(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public void run()
  {
    if ((HcePluginInstallActivity.a(this.this$0).a("vfc_plugin.apk") == null) || (!HcePluginInstallActivity.a(this.this$0).isReady()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("HcePluginInstallActivity", 4, "mPluginManager.queryPlugin->pluginInfo is null");
      }
      if (!HcePluginInstallActivity.a(this.this$0))
      {
        ThreadManager.getSubThreadHandler().postDelayed(this, 3000L);
        HcePluginInstallActivity.a(this.this$0, true);
        return;
      }
      QQToast.a(this.this$0.getApplicationContext(), 2131694501, 0).a();
      HcePluginInstallActivity.a(this.this$0, false);
      this.this$0.finish();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new HcePluginInstallActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.hce.HcePluginInstallActivity.1
 * JD-Core Version:    0.7.0.1
 */
package cooperation.buscard;

import bimg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class BuscardPluginInstallActivity$1
  implements Runnable
{
  BuscardPluginInstallActivity$1(BuscardPluginInstallActivity paramBuscardPluginInstallActivity) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if ((BuscardPluginInstallActivity.a(this.this$0).a("BuscardPlugin.apk") == null) || (!BuscardPluginInstallActivity.a(this.this$0).isReady()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("BuscardPluginInstallActivity", 4, "mPluginManager.queryPlugin->pluginInfo is null");
      }
      if (!BuscardPluginInstallActivity.a(this.this$0))
      {
        ThreadManager.getSubThreadHandler().postDelayed(this, 3000L);
        BuscardPluginInstallActivity.a(this.this$0, true);
        return;
      }
      QQToast.a(this.this$0.getApplicationContext(), 2131695368, 0);
      BuscardPluginInstallActivity.a(this.this$0, false);
      this.this$0.finish();
      return;
    }
    long l2 = System.currentTimeMillis();
    BuscardPluginInstallActivity.a(this.this$0).append(" ==step4:initPluginManager queryPlugin cost=" + (l2 - l1) + ";start time=" + l1);
    ThreadManager.getUIHandler().post(new BuscardPluginInstallActivity.1.1(this));
    BuscardPluginInstallActivity.a(this.this$0).append(" ==step5:initPluginManager UIHandler().post cost=" + (System.currentTimeMillis() - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.buscard.BuscardPluginInstallActivity.1
 * JD-Core Version:    0.7.0.1
 */
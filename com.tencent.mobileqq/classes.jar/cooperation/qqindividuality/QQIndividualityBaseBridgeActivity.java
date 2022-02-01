package cooperation.qqindividuality;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;

public abstract class QQIndividualityBaseBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  protected MqqWeakReferenceHandler a;
  protected IPluginManager b;
  
  public abstract void a();
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "handlePluginInfo null == pluginInfo");
      }
      this.a.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("pluginInfo.mState:");
      paramString.append(paramPluginBaseInfo.mState);
      paramString.append(", pluginInfo.mDownloadProgress:");
      paramString.append(paramPluginBaseInfo.mDownloadProgress);
      QLog.d("QQIndividuality", 2, paramString.toString());
    }
    int i = paramPluginBaseInfo.mState;
    if (i != -2)
    {
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            b();
            return;
          }
          this.a.sendEmptyMessageDelayed(1000, 200L);
        }
      }
      else
      {
        this.b.e("qqindividuality_plugin.apk");
        this.a.sendEmptyMessageDelayed(1000, 200L);
      }
      this.a.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    this.a.sendEmptyMessage(1001);
  }
  
  public abstract void b();
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new MqqWeakReferenceHandler(this);
    this.b = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    this.a.postDelayed(new QQIndividualityBaseBridgeActivity.1(this), 300L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    MqqWeakReferenceHandler localMqqWeakReferenceHandler = this.a;
    if (localMqqWeakReferenceHandler != null)
    {
      localMqqWeakReferenceHandler.removeMessages(1000);
      this.a.removeMessages(200);
      this.a.removeMessages(1001);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i == 1001)
      {
        QLog.e("QQIndividuality", 2, "install plugin action error");
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A99", 0, 0, "", "", "", "");
      }
    }
    else if (!isFinishing()) {
      a("qqindividuality_plugin.apk", this.b.d("qqindividuality_plugin.apk"));
    }
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBaseBridgeActivity
 * JD-Core Version:    0.7.0.1
 */
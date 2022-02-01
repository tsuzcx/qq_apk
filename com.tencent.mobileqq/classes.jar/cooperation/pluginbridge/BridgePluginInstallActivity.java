package cooperation.pluginbridge;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class BridgePluginInstallActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnPluginInstallListener, Runnable
{
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager = null;
  
  public IBinder asBinder()
  {
    return null;
  }
  
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
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "doOnCreate.");
    }
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(this, paramBundle, "/base/login");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10000L);
      return false;
    }
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    setContentView(2131558720);
    setTitle(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distPluginName"));
    setContentBackgroundResource(2130838739);
    ThreadManager.post(this, 8, null, false);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          return false;
        }
        QQToast.a(getApplicationContext(), 2131694930, 0);
        ReportController.b(this.app, "P_CliOper", "BridgePlatform", "", "start_bridge_plugin", "BridgePlugin.apk", 0, -1, "", "", "", "");
        finish();
        return false;
      }
      finish();
      return false;
    }
    if (!isFinishing())
    {
      boolean bool = this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("BridgePlugin.apk");
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("Bridge plugin installed:");
        paramMessage.append(bool);
        QLog.i("BridgePluginInstallActivity", 2, paramMessage.toString());
      }
      if (bool)
      {
        paramMessage = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distParamsString");
        String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distPluginId");
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distPluginName");
        try
        {
          BridgeHelper.a(this, this.app, this.jdField_a_of_type_AndroidContentIntent, paramMessage, str1, str2);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10000L);
          return false;
        }
        catch (Exception paramMessage)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BridgePluginInstallActivity", 2, "launchBridgePlugin fail.", paramMessage);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
          return false;
        }
      }
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("BridgePlugin.apk", this);
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallBegin.");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onInstallDownloadProgress.offset:");
      paramString.append(paramInt1);
      paramString.append(",total:");
      paramString.append(paramInt2);
      QLog.i("BridgePluginInstallActivity", 2, paramString.toString());
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInstallError.pluginId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(". errorCode:");
      localStringBuilder.append(paramInt);
      QLog.i("BridgePluginInstallActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallFinish.");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void run()
  {
    PluginInfo localPluginInfo = null;
    int i = 0;
    while (i < 300)
    {
      localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("BridgePlugin.apk");
      if ((localPluginInfo == null) && (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady())) {
        try
        {
          Thread.sleep(100L);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pluginInfo:");
      localStringBuilder.append(localPluginInfo);
      QLog.i("BridgePluginInstallActivity", 2, localStringBuilder.toString());
    }
    if (localPluginInfo == null)
    {
      if (this.jdField_a_of_type_CooperationPluginIPluginManager.isReady())
      {
        if (QLog.isColorLevel()) {
          QLog.i("BridgePluginInstallActivity", 2, "fail to load plugin.");
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    else {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.pluginbridge.BridgePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */
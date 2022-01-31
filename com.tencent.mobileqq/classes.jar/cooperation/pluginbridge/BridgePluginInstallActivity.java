package cooperation.pluginbridge;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;

public class BridgePluginInstallActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnPluginInstallListener, Runnable
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  
  public IBinder asBinder()
  {
    return null;
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
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 10000L);
      return false;
    }
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    setContentView(2130968730);
    setTitle(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distPluginName"));
    setContentBackgroundResource(2130838219);
    ThreadManager.post(this, 8, null, false);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
      do
      {
        return false;
      } while (isFinishing());
      boolean bool = this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("BridgePlugin.apk");
      if (QLog.isColorLevel()) {
        QLog.i("BridgePluginInstallActivity", 2, "Bridge plugin installed:" + bool);
      }
      if (bool)
      {
        paramMessage = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distParamsString");
        String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distPluginId");
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("distPluginName");
        try
        {
          BridgeHelper.b(this, this.app, this.jdField_a_of_type_AndroidContentIntent, paramMessage, str1, str2);
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
      return false;
    case 3: 
      finish();
      return false;
    }
    QQToast.a(getApplicationContext(), 2131438315, 0);
    ReportController.b(this.app, "P_CliOper", "BridgePlatform", "", "start_bridge_plugin", "BridgePlugin.apk", 0, -1, "", "", "", "");
    finish();
    return false;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallBegin.");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallDownloadProgress.offset:" + paramInt1 + ",total:" + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallError.pluginId:" + paramString + ". errorCode:" + paramInt);
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
    for (;;)
    {
      if (i < 300)
      {
        localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("BridgePlugin.apk");
        if ((localPluginInfo == null) && (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady())) {}
        try
        {
          Thread.sleep(100L);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "pluginInfo:" + localPluginInfo);
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
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.pluginbridge.BridgePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */
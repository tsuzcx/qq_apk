package cooperation.qqindividuality;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import axqy;
import bfnk;
import bglh;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class QQIndividualityBaseBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  protected bfnk a;
  protected bglh a;
  
  public abstract void a();
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "handlePluginInfo null == pluginInfo");
      }
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "pluginInfo.mState:" + paramPluginBaseInfo.mState + ", pluginInfo.mDownloadProgress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_Bfnk.sendEmptyMessage(1001);
      return;
    case 0: 
      this.jdField_a_of_type_Bglh.a("qqindividuality_plugin.apk");
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1000, 200L);
    case 1: 
    case 2: 
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1000, 200L);
      return;
    case 3: 
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    b();
  }
  
  public abstract void b();
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bfnk = new bfnk(this);
    this.jdField_a_of_type_Bglh = ((bglh)this.app.getManager(27));
    this.jdField_a_of_type_Bfnk.postDelayed(new QQIndividualityBaseBridgeActivity.1(this), 300L);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bfnk != null)
    {
      this.jdField_a_of_type_Bfnk.removeMessages(1000);
      this.jdField_a_of_type_Bfnk.removeMessages(200);
      this.jdField_a_of_type_Bfnk.removeMessages(1001);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        a("qqindividuality_plugin.apk", this.jdField_a_of_type_Bglh.a("qqindividuality_plugin.apk"));
        continue;
        QLog.e("QQIndividuality", 2, "install plugin action error");
        axqy.b(null, "CliOper", "", "", "ep_mall", "0X8006A99", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBaseBridgeActivity
 * JD-Core Version:    0.7.0.1
 */
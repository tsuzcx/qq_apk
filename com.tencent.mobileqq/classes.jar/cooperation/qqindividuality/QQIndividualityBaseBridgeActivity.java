package cooperation.qqindividuality;

import alzs;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;

public abstract class QQIndividualityBaseBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  protected MqqWeakReferenceHandler a;
  protected IPluginManager a;
  
  public abstract void a();
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "handlePluginInfo null == pluginInfo");
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
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
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqindividuality_plugin.apk");
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
    case 1: 
    case 2: 
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    b();
  }
  
  public abstract void b();
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new alzs(this), 300L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1000);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(200);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1001);
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
        a("qqindividuality_plugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqindividuality_plugin.apk"));
        continue;
        QLog.e("QQIndividuality", 2, "install plugin action error");
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A99", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBaseBridgeActivity
 * JD-Core Version:    0.7.0.1
 */
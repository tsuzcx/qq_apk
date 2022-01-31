import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class lcd
  implements Runnable
{
  public lcd(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void run()
  {
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_get_PA_head");
    ((IntentFilter)localObject).addAction("action_shop_set_read");
    ((IntentFilter)localObject).addAction("action_folder_set_read");
    ((IntentFilter)localObject).addAction("action_folder_destroy");
    ((IntentFilter)localObject).addAction("action_folder_msg_change");
    ((IntentFilter)localObject).addAction("action_set_folder_tab_red");
    ((IntentFilter)localObject).addAction("action_follow_status");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      ((EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).b();
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("ecshop_sp" + EcShopAssistantManager.a(this.a), 0);
      this.a.b = ((SharedPreferences)localObject).getBoolean("folder_tab_show", false);
      this.a.c = ((SharedPreferences)localObject).getBoolean("preload_web", false);
      EcShopAssistantManager.g = String.valueOf(((SharedPreferences)localObject).getLong("ad_puin", 0L));
      this.a.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("stayTime", 5000L);
      this.a.d = ((SharedPreferences)localObject).getInt("dayLimit", 3);
      this.a.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EcShopAssistantManager", 1, "Register receiver error:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcd
 * JD-Core Version:    0.7.0.1
 */
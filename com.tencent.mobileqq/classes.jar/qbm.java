import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.qfind.QFindConfig;
import com.tencent.device.qfind.QFindConfigUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class qbm
  implements Runnable
{
  public qbm(SmartDeviceProxyMgr paramSmartDeviceProxyMgr, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size() > 0))
    {
      localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(0);
      localObject2 = QFindConfigUtil.a((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("QFind", 2, "config0 " + (String)localObject1);
      }
      if (localObject2 != null) {}
    }
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      Object localObject2;
      return;
      int i = 1;
      while (i < this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size())
      {
        String str = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 65,content: " + str + ",version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
        }
        QFindConfig localQFindConfig = QFindConfigUtil.a(str);
        Object localObject4 = localObject2;
        localObject3 = localObject1;
        if (localQFindConfig != null)
        {
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (localQFindConfig.a > ((QFindConfig)localObject2).a)
          {
            localObject4 = localQFindConfig;
            localObject3 = str;
          }
        }
        i += 1;
        localObject2 = localObject4;
        localObject1 = localObject3;
      }
      Object localObject3 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
      ((SharedPreferences.Editor)localObject3).putString("qfind_assist" + this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.b.getCurrentAccountUin(), String.valueOf(((QFindConfig)localObject2).b));
      ((SharedPreferences.Editor)localObject3).commit();
      FileUtils.a(BaseApplicationImpl.getApplication().getFilesDir() + "/qfindconfig", (String)localObject1);
      this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(null, false);
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 65content_list is emtpy,version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qbm
 * JD-Core Version:    0.7.0.1
 */
package cooperation.vip.yyb;

import NS_MOBILE_COMM_CONF.MobileCommConf;
import NS_MOBILE_COMM_CONF.NewMobileGlobalConf;
import NS_MOBILE_COMM_CONF.NewMobileUserConf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class YYBInstallPackageManager
{
  private static YYBInstallPackageManager jdField_a_of_type_CooperationVipYybYYBInstallPackageManager;
  private long jdField_a_of_type_Long = -1L;
  
  public static YYBInstallPackageManager a()
  {
    if (jdField_a_of_type_CooperationVipYybYYBInstallPackageManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationVipYybYYBInstallPackageManager == null) {
        jdField_a_of_type_CooperationVipYybYYBInstallPackageManager = new YYBInstallPackageManager();
      }
      return jdField_a_of_type_CooperationVipYybYYBInstallPackageManager;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("new_report", 0).edit();
      localEditor.putLong("lastReportTime", paramLong);
      localEditor.apply();
    }
  }
  
  public void a(MobileCommConf paramMobileCommConf)
  {
    if ((paramMobileCommConf == null) || (paramMobileCommConf.new_mobile_global_conf == null) || (paramMobileCommConf.new_mobile_user_conf == null) || (paramMobileCommConf.vecAppList == null) || (paramMobileCommConf.maxScanNum <= 0)) {}
    long l;
    ArrayList localArrayList;
    do
    {
      do
      {
        do
        {
          return;
          l = paramMobileCommConf.new_mobile_global_conf.version;
        } while (paramMobileCommConf.new_mobile_user_conf.version < l);
        if (QLog.isColorLevel()) {
          QLog.d("YYBInstallPackageManager", 1, "invokeReport");
        }
        l = System.currentTimeMillis() / 1000L;
      } while (((this.jdField_a_of_type_Long >= paramMobileCommConf.new_mobile_user_conf.uBeginTime) && (this.jdField_a_of_type_Long <= paramMobileCommConf.new_mobile_user_conf.uEndTime)) || (l < paramMobileCommConf.new_mobile_user_conf.uBeginTime) || (l > paramMobileCommConf.new_mobile_user_conf.uEndTime));
      localArrayList = new ArrayList();
      Iterator localIterator = paramMobileCommConf.vecAppList.iterator();
      do
      {
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (PackageUtil.a(BaseApplicationImpl.getApplication(), str));
        localArrayList.add(str);
      } while (localArrayList.size() < paramMobileCommConf.maxScanNum);
    } while (localArrayList.size() <= 0);
    this.jdField_a_of_type_Long = l;
    a(this.jdField_a_of_type_Long);
    paramMobileCommConf = new NewIntent(BaseApplicationImpl.getApplication(), YYBInstallPackageReportServlet.class);
    try
    {
      l = Long.parseLong(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
      paramMobileCommConf.putExtra("selfuin", l);
      paramMobileCommConf.putStringArrayListExtra("uninstall_app_list", localArrayList);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMobileCommConf);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("YYBInstallPackageManager", 1, "get uin error " + localException);
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.yyb.YYBInstallPackageManager
 * JD-Core Version:    0.7.0.1
 */
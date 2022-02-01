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
    if (jdField_a_of_type_CooperationVipYybYYBInstallPackageManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationVipYybYYBInstallPackageManager == null) {
          jdField_a_of_type_CooperationVipYybYYBInstallPackageManager = new YYBInstallPackageManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationVipYybYYBInstallPackageManager;
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
  
  private void a(MobileCommConf paramMobileCommConf, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMobileCommConf.vecAppList.iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
      } while (PackageUtil.a(BaseApplicationImpl.getApplication(), (String)localObject));
      localArrayList.add(localObject);
    } while (localArrayList.size() < paramMobileCommConf.maxScanNum);
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_Long = paramLong;
      a(this.jdField_a_of_type_Long);
      paramMobileCommConf = new NewIntent(BaseApplicationImpl.getApplication(), YYBInstallPackageReportServlet.class);
      paramLong = 0L;
      try
      {
        long l = Long.parseLong(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin());
        paramLong = l;
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get uin error ");
        ((StringBuilder)localObject).append(localException);
        QLog.e("YYBInstallPackageManager", 1, ((StringBuilder)localObject).toString());
      }
      paramMobileCommConf.putExtra("selfuin", paramLong);
      paramMobileCommConf.putStringArrayListExtra("uninstall_app_list", localArrayList);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMobileCommConf);
    }
  }
  
  public void a(MobileCommConf paramMobileCommConf)
  {
    if ((paramMobileCommConf != null) && (paramMobileCommConf.new_mobile_global_conf != null) && (paramMobileCommConf.new_mobile_user_conf != null) && (paramMobileCommConf.vecAppList != null))
    {
      if (paramMobileCommConf.maxScanNum <= 0) {
        return;
      }
      long l = paramMobileCommConf.new_mobile_global_conf.version;
      if (paramMobileCommConf.new_mobile_user_conf.version < l) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("YYBInstallPackageManager", 1, "invokeReport");
      }
      l = System.currentTimeMillis() / 1000L;
      if (((this.jdField_a_of_type_Long < paramMobileCommConf.new_mobile_user_conf.uBeginTime) || (this.jdField_a_of_type_Long > paramMobileCommConf.new_mobile_user_conf.uEndTime)) && (l >= paramMobileCommConf.new_mobile_user_conf.uBeginTime) && (l <= paramMobileCommConf.new_mobile_user_conf.uEndTime)) {
        a(paramMobileCommConf, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.yyb.YYBInstallPackageManager
 * JD-Core Version:    0.7.0.1
 */
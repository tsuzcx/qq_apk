package cooperation.vip.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PackageUpdateManager
{
  private static PackageUpdateManager a;
  private boolean b = false;
  private boolean c = false;
  private int d = 0;
  
  public static long a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  public static PackageUpdateManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PackageUpdateManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static long b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
      return l;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0L;
  }
  
  private void b()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PackageUpdateManager", 4).edit();
    localEditor.putBoolean("HAS_PULL", this.b);
    localEditor.apply();
  }
  
  private int c()
  {
    if (this.c) {
      return this.d;
    }
    this.c = true;
    long l = a(BaseApplicationImpl.getApplication());
    if (b(BaseApplicationImpl.getApplication()) > l) {
      this.d = 1;
    } else {
      this.d = 0;
    }
    return this.d;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.b)
    {
      QLog.d("PackageUpdateManager", 1, "checkUpgrade has pulll");
      return;
    }
    if (c() == 1)
    {
      this.b = true;
      QLog.d("PackageUpdateManager", 1, "checkUpgrade need pull friendlist ");
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.PackageUpdateManager
 * JD-Core Version:    0.7.0.1
 */
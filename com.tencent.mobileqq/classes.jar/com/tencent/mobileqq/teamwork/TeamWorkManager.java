package com.tencent.mobileqq.teamwork;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigProcessor;
import com.tencent.mobileqq.doc.TencentDocUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class TeamWorkManager
  implements Manager
{
  private static String b = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
  private static String c = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
  private static String d = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
  private static String e = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
  AppInterface a;
  private volatile boolean f = false;
  
  public TeamWorkManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public static String b()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences(CommonUtils.a, 4);
    if (localSharedPreferences != null) {
      b = localSharedPreferences.getString(CommonUtils.b, "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png");
    }
    return b;
  }
  
  public static String c()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences(CommonUtils.a, 4);
    if (localSharedPreferences != null) {
      c = localSharedPreferences.getString(CommonUtils.c, "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
    }
    return c;
  }
  
  public static String d()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences(CommonUtils.a, 4);
    if (localSharedPreferences != null) {
      d = localSharedPreferences.getString(CommonUtils.d, "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png");
    }
    return d;
  }
  
  public static String e()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences(CommonUtils.a, 4);
    if (localSharedPreferences != null) {
      e = localSharedPreferences.getString(CommonUtils.e, "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png");
    }
    return e;
  }
  
  public Boolean a()
  {
    this.a.getApplication();
    this.a.getCurrentUin();
    boolean bool4 = TencentDocAIOPlusPanelEntryConfigProcessor.a().a();
    boolean bool1 = TencentDocUtils.a(this.a);
    String str = TencentDocAIOPlusPanelEntryConfigProcessor.a().b();
    boolean bool3 = true;
    if ((bool1) && (str != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG isShowTencentDocEntry isShowTencentDocEntry = ");
      localStringBuilder.append(bool4);
      localStringBuilder.append(", isUser = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", userConfigPlusURL = ");
      localStringBuilder.append(str);
      QLog.d("TeamWorkManager", 2, localStringBuilder.toString());
    }
    boolean bool2 = bool3;
    if (!bool4) {
      if (bool1) {
        bool2 = bool3;
      } else {
        bool2 = false;
      }
    }
    if ((!bool4) && (bool1)) {
      TencentDocUtils.a("0X80094DF");
    }
    return Boolean.valueOf(bool2);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkManager
 * JD-Core Version:    0.7.0.1
 */
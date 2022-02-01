package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class TimUpgradeHongdianManager
  implements Manager
{
  public static String a = "TimUpgradeHongdianManager";
  public boolean b = false;
  public String c;
  public String d;
  public String e;
  private QQAppInterface f;
  
  public TimUpgradeHongdianManager(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool4;
    try
    {
      Object localObject1 = this.f.getApp();
      bool2 = bool4;
      localObject2 = new StringBuilder();
      bool2 = bool4;
      ((StringBuilder)localObject2).append("tim_upgrade_hongdian_pre_");
      bool2 = bool4;
      ((StringBuilder)localObject2).append(this.f.getCurrentUin());
      bool2 = bool4;
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      bool2 = bool4;
      this.b = ((SharedPreferences)localObject1).getBoolean("tim_upgrade_hongdian_switch", false);
      bool2 = bool4;
      this.c = ((SharedPreferences)localObject1).getString("tim_upgrade_hongdian_title", null);
      bool2 = bool4;
      this.d = ((SharedPreferences)localObject1).getString("tim_upgrade_hongdian_sub_title", null);
      bool2 = bool4;
      this.e = ((SharedPreferences)localObject1).getString("tim_upgrade_hongdian_url", null);
      bool2 = bool4;
      long l2 = System.currentTimeMillis();
      boolean bool1 = bool3;
      bool2 = bool4;
      if (!TextUtils.isEmpty(this.c))
      {
        bool1 = bool3;
        bool2 = bool4;
        if (!TextUtils.isEmpty(this.d))
        {
          bool1 = bool3;
          bool2 = bool4;
          if (!TextUtils.isEmpty(this.e)) {
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        localObject1 = a;
        bool2 = bool1;
        localObject2 = new StringBuilder();
        bool2 = bool1;
        ((StringBuilder)localObject2).append("checkIfShowTimHongdian , switchKey = ");
        bool2 = bool1;
        ((StringBuilder)localObject2).append(this.b);
        bool2 = bool1;
        ((StringBuilder)localObject2).append(", mTitle = ");
        bool2 = bool1;
        ((StringBuilder)localObject2).append(this.c);
        bool2 = bool1;
        ((StringBuilder)localObject2).append(", mSubTitle =");
        bool2 = bool1;
        ((StringBuilder)localObject2).append(this.d);
        bool2 = bool1;
        ((StringBuilder)localObject2).append(", url=");
        bool2 = bool1;
        ((StringBuilder)localObject2).append(this.e);
        bool2 = bool1;
        ((StringBuilder)localObject2).append(", sp time cost = ");
        bool2 = bool1;
        ((StringBuilder)localObject2).append(l2 - l1);
        bool2 = bool1;
        ((StringBuilder)localObject2).append(", ifShow= ");
        bool2 = bool1;
        ((StringBuilder)localObject2).append(bool1);
        bool2 = bool1;
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return bool1;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkIfShowTimHongdian ");
        localStringBuilder.append(localException.toString());
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
        bool3 = bool2;
      }
    }
    return bool3;
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = this.f.getApp();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("tim_upgrade_hongdian_pre_");
      ((StringBuilder)localObject2).append(this.f.getCurrentUin());
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit();
      if (localObject1 != null)
      {
        ((SharedPreferences.Editor)localObject1).putBoolean("tim_upgrade_hongdian_switch", false);
        ((SharedPreferences.Editor)localObject1).putString("tim_upgrade_hongdian_title", null);
        ((SharedPreferences.Editor)localObject1).putString("tim_upgrade_hongdian_sub_title", null);
        ((SharedPreferences.Editor)localObject1).putString("tim_upgrade_hongdian_url", null);
      }
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "clearHondianSP done");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearHondianSP ");
        localStringBuilder.append(localException.toString());
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TimUpgradeHongdianManager
 * JD-Core Version:    0.7.0.1
 */
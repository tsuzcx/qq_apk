package com.tencent.timi.game.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.dataline.util.DBNetworkUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class DeviceInfoManager
{
  private static volatile DeviceInfoManager a;
  private String b = "";
  private String c = "";
  
  public static DeviceInfoManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DeviceInfoManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private static String e()
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder("");
    PackageManager localPackageManager = localBaseApplication.getPackageManager();
    try
    {
      localStringBuilder.append(localPackageManager.getPackageInfo(localBaseApplication.getPackageName(), 0).versionName);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label39:
      break label39;
    }
    localStringBuilder.append("0.0.0.000");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return MobileInfoUtil.getImei();
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.b))
    {
      this.b = e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppVerion ");
      localStringBuilder.append(this.b);
      Logger.a("DeviceInfoManager", localStringBuilder.toString());
    }
    return this.b;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.c))
    {
      this.c = DBNetworkUtil.a(false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIpAddress ");
      localStringBuilder.append(this.c);
      Logger.a("DeviceInfoManager", localStringBuilder.toString());
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.DeviceInfoManager
 * JD-Core Version:    0.7.0.1
 */
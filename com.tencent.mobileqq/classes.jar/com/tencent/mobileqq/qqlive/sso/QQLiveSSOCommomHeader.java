package com.tencent.mobileqq.qqlive.sso;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.utils.MachineUtil;
import com.tencent.util.QQDeviceInfo;

public class QQLiveSSOCommomHeader
  implements IQQLiveSSOCommonHeader
{
  private IQQLiveModuleLogin a;
  private QQLiveSDKConfig b;
  private ConfigData c;
  
  public QQLiveSSOCommomHeader(IQQLiveModuleLogin paramIQQLiveModuleLogin, QQLiveSDKConfig paramQQLiveSDKConfig, ConfigData paramConfigData)
  {
    this.a = paramIQQLiveModuleLogin;
    this.b = paramQQLiveSDKConfig;
    this.c = paramConfigData;
  }
  
  public long a()
  {
    LoginInfo localLoginInfo = this.a.getLoginInfo();
    if (localLoginInfo == null) {
      return 0L;
    }
    return localLoginInfo.uid;
  }
  
  public long b()
  {
    LoginInfo localLoginInfo = this.a.getLoginInfo();
    if (localLoginInfo == null) {
      return 0L;
    }
    return localLoginInfo.tinyid;
  }
  
  public String c()
  {
    LoginInfo localLoginInfo = this.a.getLoginInfo();
    if (localLoginInfo == null) {
      return "";
    }
    return localLoginInfo.a2;
  }
  
  public String d()
  {
    LoginInfo localLoginInfo = this.a.getLoginInfo();
    if (localLoginInfo == null) {
      return "";
    }
    return localLoginInfo.accessToken;
  }
  
  public String e()
  {
    LoginInfo localLoginInfo = this.a.getLoginInfo();
    if (localLoginInfo == null) {
      return "";
    }
    return localLoginInfo.openId;
  }
  
  public int f()
  {
    return this.c.getLiveClientType();
  }
  
  public String g()
  {
    String str = "8.8.17";
    if (TextUtils.isEmpty("8.8.17")) {
      str = "";
    }
    return str;
  }
  
  public int h()
  {
    if (this.b.versionCode == 0) {
      return 10800;
    }
    return this.b.versionCode;
  }
  
  public int i()
  {
    return this.b.streamType;
  }
  
  public int j()
  {
    LoginInfo localLoginInfo = this.a.getLoginInfo();
    if (localLoginInfo == null) {
      return 1;
    }
    return localLoginInfo.loginType;
  }
  
  public Boolean k()
  {
    return Boolean.valueOf(this.b.isTestEnv);
  }
  
  public String l()
  {
    String str2 = QQDeviceInfo.getQIMEI();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = MachineUtil.a();
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.QQLiveSSOCommomHeader
 * JD-Core Version:    0.7.0.1
 */
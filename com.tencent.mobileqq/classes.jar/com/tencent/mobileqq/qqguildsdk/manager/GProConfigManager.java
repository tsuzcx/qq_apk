package com.tencent.mobileqq.qqguildsdk.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.config.GProSdkConfigBean;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

public class GProConfigManager
{
  private GProSdkConfigBean a;
  
  public static GProConfigManager a()
  {
    try
    {
      GProConfigManager localGProConfigManager = new GProConfigManager();
      return localGProConfigManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(GProSdkConfigBean paramGProSdkConfigBean)
  {
    if (paramGProSdkConfigBean != null)
    {
      this.a = paramGProSdkConfigBean;
      if (this.a == null)
      {
        paramGProSdkConfigBean = "mGProSdkConfig is null";
      }
      else
      {
        paramGProSdkConfigBean = new StringBuilder();
        paramGProSdkConfigBean.append("headDomain: ");
        paramGProSdkConfigBean.append(this.a.a);
        paramGProSdkConfigBean.append("coverDomain: ");
        paramGProSdkConfigBean.append(this.a.b);
        paramGProSdkConfigBean = paramGProSdkConfigBean.toString();
      }
      GProLog.b("GProConfigManager", true, "config", paramGProSdkConfigBean);
    }
  }
  
  public String b()
  {
    GProSdkConfigBean localGProSdkConfigBean = this.a;
    if ((localGProSdkConfigBean != null) && (!TextUtils.isEmpty(localGProSdkConfigBean.a))) {
      return this.a.a;
    }
    return "groupprohead-76292.picgzc.qpic.cn";
  }
  
  public String c()
  {
    GProSdkConfigBean localGProSdkConfigBean = this.a;
    if ((localGProSdkConfigBean != null) && (!TextUtils.isEmpty(localGProSdkConfigBean.b))) {
      return this.a.b;
    }
    return "groupprocover-76483.picgzc.qpic.cn";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.GProConfigManager
 * JD-Core Version:    0.7.0.1
 */
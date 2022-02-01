package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.gprosdk.GProAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import java.util.List;

final class GProConvert$2
  implements IAppInfo
{
  GProConvert$2(GProAppInfo paramGProAppInfo) {}
  
  public long a()
  {
    return this.a.getAppid();
  }
  
  public String b()
  {
    return this.a.getIconUrl();
  }
  
  public String c()
  {
    return this.a.getAppName();
  }
  
  public String d()
  {
    return this.a.getAppDescription();
  }
  
  public List<String> e()
  {
    return this.a.getPreViewList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProConvert.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProClientAccount;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import org.jetbrains.annotations.NotNull;

public class GProClientAccountInfo
  implements IGProClientAccountInfo
{
  private final GProClientAccount a;
  
  public GProClientAccountInfo(GProClientAccount paramGProClientAccount)
  {
    this.a = paramGProClientAccount;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getClientId());
  }
  
  public String b()
  {
    return this.a.getClientName();
  }
  
  public String c()
  {
    return this.a.getAccountSecret();
  }
  
  public String d()
  {
    return this.a.getAccountName();
  }
  
  public IGProClientShowCfgInfo e()
  {
    return new GProClientShowCfgInfo(this.a.getClientConfig());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientAccountInfo{clientAccount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProClientAccountInfo
 * JD-Core Version:    0.7.0.1
 */
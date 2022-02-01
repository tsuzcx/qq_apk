package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import org.jetbrains.annotations.NotNull;

public class GProClientIdentityInfo
  implements IGProClientIdentityInfo
{
  private final GProClientIdentity a;
  
  public GProClientIdentityInfo(GProClientIdentity paramGProClientIdentity)
  {
    this.a = paramGProClientIdentity;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getClientId());
  }
  
  public String b()
  {
    return this.a.getDesc();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientIdentityInfo{clientIdentity=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProClientIdentityInfo
 * JD-Core Version:    0.7.0.1
 */
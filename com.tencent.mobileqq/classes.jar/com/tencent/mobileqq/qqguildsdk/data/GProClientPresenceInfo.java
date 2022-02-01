package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProClientPresence;
import org.jetbrains.annotations.NotNull;

public class GProClientPresenceInfo
  implements IGProClientPresenceInfo
{
  private final GProClientPresence a;
  
  public GProClientPresenceInfo(GProClientPresence paramGProClientPresence)
  {
    this.a = paramGProClientPresence;
  }
  
  public int a()
  {
    return this.a.getClientId();
  }
  
  public String b()
  {
    return this.a.getClientName();
  }
  
  public String c()
  {
    return this.a.getBigIcon();
  }
  
  public String d()
  {
    return this.a.getState();
  }
  
  public String e()
  {
    return this.a.getDetails();
  }
  
  public long f()
  {
    return this.a.getPartySize();
  }
  
  public long g()
  {
    return this.a.getPartyMax();
  }
  
  public String h()
  {
    return this.a.getRole();
  }
  
  public long i()
  {
    return this.a.getStartTimeStamp();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientPresenceInfo{presence=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProClientPresenceInfo
 * JD-Core Version:    0.7.0.1
 */
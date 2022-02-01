package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProClientShowCfg;
import org.jetbrains.annotations.NotNull;

public class GProClientShowCfgInfo
  implements IGProClientShowCfgInfo
{
  private final GProClientShowCfg a;
  
  public GProClientShowCfgInfo(GProClientShowCfg paramGProClientShowCfg)
  {
    this.a = paramGProClientShowCfg;
  }
  
  public boolean a()
  {
    return this.a.getShowPresence();
  }
  
  public boolean b()
  {
    return this.a.getShowArchives();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientShowCfgInfo{clientShowCfg=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProClientShowCfgInfo
 * JD-Core Version:    0.7.0.1
 */
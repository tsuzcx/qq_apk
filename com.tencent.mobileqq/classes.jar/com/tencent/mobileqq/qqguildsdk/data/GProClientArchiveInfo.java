package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProClientArchive;
import org.jetbrains.annotations.NotNull;

public class GProClientArchiveInfo
  implements IGProClientArchiveInfo
{
  private final GProClientArchive a;
  
  public GProClientArchiveInfo(GProClientArchive paramGProClientArchive)
  {
    this.a = paramGProClientArchive;
  }
  
  public int a()
  {
    return this.a.getTemplateId();
  }
  
  public IGProSmobaArchiveTemplateInfo b()
  {
    return new GProSmobaArchiveTemplateInfo(this.a.getTemplate1());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProClientArchiveInfo{archive=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProClientArchiveInfo
 * JD-Core Version:    0.7.0.1
 */
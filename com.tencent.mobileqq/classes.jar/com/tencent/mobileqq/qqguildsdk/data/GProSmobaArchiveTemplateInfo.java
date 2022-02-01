package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProSmobaArchiveTemplate;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class GProSmobaArchiveTemplateInfo
  implements IGProSmobaArchiveTemplateInfo
{
  private final GProSmobaArchiveTemplate a;
  
  public GProSmobaArchiveTemplateInfo(GProSmobaArchiveTemplate paramGProSmobaArchiveTemplate)
  {
    this.a = paramGProSmobaArchiveTemplate;
  }
  
  public int a()
  {
    return this.a.getGradeLevel();
  }
  
  public int b()
  {
    return this.a.getStarCnt();
  }
  
  public String c()
  {
    return this.a.getWinNum();
  }
  
  public String d()
  {
    return this.a.getMvpNum();
  }
  
  public String e()
  {
    return this.a.getWinRate();
  }
  
  public String f()
  {
    return this.a.getGoodBranch();
  }
  
  public List<String> g()
  {
    return this.a.getGoodHeroIconList();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProSmobaArchiveTemplateInfo{smobaArchiveTemplate=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProSmobaArchiveTemplateInfo
 * JD-Core Version:    0.7.0.1
 */
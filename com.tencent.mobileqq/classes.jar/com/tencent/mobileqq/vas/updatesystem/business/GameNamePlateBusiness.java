package com.tencent.mobileqq.vas.updatesystem.business;

import java.io.File;

public class GameNamePlateBusiness
  extends QQVasUpdateBusiness
{
  protected String a()
  {
    return "gamenameplate";
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e(paramString));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gamenameplate");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("icon.png");
    return localStringBuilder.toString();
  }
  
  public String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e(paramString));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gamenameplate");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ext_icon.png");
    return localStringBuilder.toString();
  }
  
  public long getBid()
  {
    return 55L;
  }
  
  public String getFrom()
  {
    return "gamenameplate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.GameNamePlateBusiness
 * JD-Core Version:    0.7.0.1
 */
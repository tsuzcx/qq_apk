package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProPopupConfig;
import org.jetbrains.annotations.NotNull;

public class GProPopupConfigInfo
  implements IGProPopupConfigInfo
{
  private final GProPopupConfig a;
  
  public GProPopupConfigInfo(GProPopupConfig paramGProPopupConfig)
  {
    this.a = paramGProPopupConfig;
  }
  
  public String a()
  {
    return this.a.getWording1();
  }
  
  public String b()
  {
    return this.a.getWording2();
  }
  
  public String c()
  {
    return this.a.getPicUrl();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProPopupConfigInfo{popupConfig : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProPopupConfigInfo
 * JD-Core Version:    0.7.0.1
 */
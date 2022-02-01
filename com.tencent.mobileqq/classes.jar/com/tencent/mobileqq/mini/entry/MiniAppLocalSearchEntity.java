package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class MiniAppLocalSearchEntity
  extends Entity
  implements Serializable
{
  @unique
  public String appId;
  public String appName;
  public String desc;
  public String iconUrl;
  public int miniAppType;
  public int showMask;
  
  public MiniAppLocalSearchEntity() {}
  
  public MiniAppLocalSearchEntity(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this.appId = paramString1;
    this.appName = paramString2;
    this.iconUrl = paramString3;
    this.desc = paramString4;
    this.showMask = paramInt1;
    this.miniAppType = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId: ");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", appName: ");
    localStringBuilder.append(this.appName);
    localStringBuilder.append(", iconUrl: ");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append(", showMask: ");
    localStringBuilder.append(this.showMask);
    localStringBuilder.append(", miniAppType: ");
    localStringBuilder.append(this.miniAppType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity
 * JD-Core Version:    0.7.0.1
 */
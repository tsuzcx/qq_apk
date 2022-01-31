package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TroopAioTopADInfo
  extends Entity
{
  public int adId;
  public String backgroundUrl;
  public String jumpUrl;
  public String moreUrl;
  public String picUrl;
  public int showType;
  public String strWord;
  @unique
  public String troopUin;
  public String uiUrl;
  public long validTime;
  
  public String toString()
  {
    Object localObject = new Date(this.validTime * 1000L);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE).format((Date)localObject);
    StringBuilder localStringBuilder = new StringBuilder("TroopAioTopADInfo{");
    localStringBuilder.append("troopUin='").append(this.troopUin).append('\'');
    localStringBuilder.append(", adId=").append(this.adId);
    localStringBuilder.append(", backgroundUrl='").append(this.backgroundUrl).append('\'');
    localStringBuilder.append(", moreUrl='").append(this.moreUrl).append('\'');
    localStringBuilder.append(", picUrl='").append(this.picUrl).append('\'');
    localStringBuilder.append(", validTime=").append((String)localObject);
    localStringBuilder.append(", showType=").append(this.showType);
    localStringBuilder.append(", strWord='").append(this.strWord).append('\'');
    localStringBuilder.append(", uiUrl='").append(this.uiUrl).append('\'');
    localStringBuilder.append(", jumpUrl='").append(this.jumpUrl).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioTopADInfo
 * JD-Core Version:    0.7.0.1
 */
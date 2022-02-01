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
    localStringBuilder.append("troopUin='");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adId=");
    localStringBuilder.append(this.adId);
    localStringBuilder.append(", backgroundUrl='");
    localStringBuilder.append(this.backgroundUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", moreUrl='");
    localStringBuilder.append(this.moreUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.picUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", validTime=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", showType=");
    localStringBuilder.append(this.showType);
    localStringBuilder.append(", strWord='");
    localStringBuilder.append(this.strWord);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uiUrl='");
    localStringBuilder.append(this.uiUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioTopADInfo
 * JD-Core Version:    0.7.0.1
 */
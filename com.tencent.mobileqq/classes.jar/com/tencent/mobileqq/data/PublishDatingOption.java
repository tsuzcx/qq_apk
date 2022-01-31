package com.tencent.mobileqq.data;

import appoint.define.appoint_define.LocaleInfo;

public class PublishDatingOption
{
  public appoint_define.LocaleInfo depLocal;
  public int depLocalState = -1;
  public appoint_define.LocaleInfo desLocal;
  public int destType = -1;
  public int genderId = -1;
  public int introId = -1001;
  public String introKey = "";
  public String introduce = "";
  public String maxTimeReqErr = "";
  public int maxTimeRequest = -1;
  public int partCountId = -1;
  public int payTypeId = -1;
  public PublishDatingOption.ShopInfo shopInfo = new PublishDatingOption.ShopInfo(this);
  public int themeId = -1;
  public String themeName = "";
  public long time = -1L;
  public int vehicleId = -1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("themeId:" + this.themeId);
    localStringBuilder.append(",time:" + this.time);
    localStringBuilder.append(",genderId:" + this.genderId);
    localStringBuilder.append(",introduce:" + this.introduce);
    localStringBuilder.append(",introId:" + this.introId);
    localStringBuilder.append(",introKey:" + this.introKey);
    localStringBuilder.append(",payTypeId:" + this.payTypeId);
    localStringBuilder.append(",vehicleId:" + this.vehicleId);
    localStringBuilder.append(",partCountId:" + this.partCountId);
    if (this.shopInfo != null) {
      localStringBuilder.append(",shopInfo:" + this.shopInfo.toString());
    }
    if (this.depLocal != null) {
      localStringBuilder.append(",depLocal:" + this.depLocal.str_name);
    }
    if (this.desLocal != null) {
      localStringBuilder.append(",desLocal:" + this.desLocal.str_name);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublishDatingOption
 * JD-Core Version:    0.7.0.1
 */
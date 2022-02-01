package com.tencent.mobileqq.data;

import appoint.define.appoint_define.LocaleInfo;

public class PublishDatingOption
{
  public appoint_define.LocaleInfo depLocal = null;
  public int depLocalState = -1;
  public appoint_define.LocaleInfo desLocal = null;
  public int destType = -1;
  public int genderId = -1;
  public boolean hasIntro = false;
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("themeId:");
    localStringBuilder2.append(this.themeId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",time:");
    localStringBuilder2.append(this.time);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",genderId:");
    localStringBuilder2.append(this.genderId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",introduce:");
    localStringBuilder2.append(this.introduce);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",introId:");
    localStringBuilder2.append(this.introId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",introKey:");
    localStringBuilder2.append(this.introKey);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",payTypeId:");
    localStringBuilder2.append(this.payTypeId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",vehicleId:");
    localStringBuilder2.append(this.vehicleId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",partCountId:");
    localStringBuilder2.append(this.partCountId);
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.shopInfo != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",shopInfo:");
      localStringBuilder2.append(this.shopInfo.toString());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.depLocal != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",depLocal:");
      localStringBuilder2.append(this.depLocal.str_name);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.desLocal != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",desLocal:");
      localStringBuilder2.append(this.desLocal.str_name);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublishDatingOption
 * JD-Core Version:    0.7.0.1
 */
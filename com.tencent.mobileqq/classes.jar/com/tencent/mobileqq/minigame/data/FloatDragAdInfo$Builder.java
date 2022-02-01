package com.tencent.mobileqq.minigame.data;

import cooperation.vip.pb.TianShuAccess.AdItem;

public class FloatDragAdInfo$Builder
{
  private TianShuAccess.AdItem adItem;
  private String appId;
  private String jumpUrl;
  private String pictureUrl;
  private int scene;
  private String type;
  
  public Builder adItem(TianShuAccess.AdItem paramAdItem)
  {
    this.adItem = paramAdItem;
    return this;
  }
  
  public Builder appId(String paramString)
  {
    this.appId = paramString;
    return this;
  }
  
  public FloatDragAdInfo build()
  {
    return new FloatDragAdInfo(this.adItem, this.type, this.pictureUrl, this.jumpUrl, this.appId, this.scene, null);
  }
  
  public Builder jumpUrl(String paramString)
  {
    this.jumpUrl = paramString;
    return this;
  }
  
  public Builder pictureUrl(String paramString)
  {
    this.pictureUrl = paramString;
    return this;
  }
  
  public Builder scene(int paramInt)
  {
    this.scene = paramInt;
    return this;
  }
  
  public Builder type(String paramString)
  {
    this.type = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.FloatDragAdInfo.Builder
 * JD-Core Version:    0.7.0.1
 */
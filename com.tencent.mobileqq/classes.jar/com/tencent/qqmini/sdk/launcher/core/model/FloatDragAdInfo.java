package com.tencent.qqmini.sdk.launcher.core.model;

import cooperation.vip.pb.TianShuAccess.AdItem;

public class FloatDragAdInfo
{
  public static final String TYPE_SCHEME = "1";
  public static final String TYPE_URL = "0";
  private TianShuAccess.AdItem adItem;
  private String appId;
  private String jumpUrl;
  private String pictureUrl;
  private int scene;
  private String type;
  
  private FloatDragAdInfo(TianShuAccess.AdItem paramAdItem, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.adItem = paramAdItem;
    this.type = paramString1;
    this.pictureUrl = paramString2;
    this.jumpUrl = paramString3;
    this.appId = paramString4;
    this.scene = paramInt;
  }
  
  public TianShuAccess.AdItem getAdItem()
  {
    return this.adItem;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  public String getPictureUrl()
  {
    return this.pictureUrl;
  }
  
  public int getScene()
  {
    return this.scene;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean isSchema()
  {
    return "1".equals(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo
 * JD-Core Version:    0.7.0.1
 */
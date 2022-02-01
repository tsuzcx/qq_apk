package com.tencent.qqmini.sdk.launcher.core.model;

import cooperation.vip.pb.TianShuAccess.AdItem;

public class PendantAdInfo$Builder
{
  private String absTimeRemovePendant;
  private String absTimeShowPendant;
  private String activeId;
  private TianShuAccess.AdItem adItem;
  private String appId;
  private String autoPopUpWebview;
  private String autoWebviewDelay;
  private String jumpUrl;
  private String numMaxConsumption;
  private String pendantUrl;
  private String pictureUrl;
  private String popUpTime;
  private int scene;
  private String showPendant;
  private String staticPendantUrl;
  private String type;
  
  public Builder absTimeRemovePendant(String paramString)
  {
    this.absTimeRemovePendant = paramString;
    return this;
  }
  
  public Builder absTimeShowPendant(String paramString)
  {
    this.absTimeShowPendant = paramString;
    return this;
  }
  
  public Builder activeId(String paramString)
  {
    this.activeId = paramString;
    return this;
  }
  
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
  
  public Builder autoPopUpWebview(String paramString)
  {
    this.autoPopUpWebview = paramString;
    return this;
  }
  
  public Builder autoWebviewDelay(String paramString)
  {
    this.autoWebviewDelay = paramString;
    return this;
  }
  
  public PendantAdInfo build()
  {
    return new PendantAdInfo(this.adItem, this.type, this.pictureUrl, this.pendantUrl, this.staticPendantUrl, this.jumpUrl, this.appId, this.scene, this.autoPopUpWebview, this.popUpTime, this.autoWebviewDelay, this.showPendant, this.absTimeShowPendant, this.absTimeRemovePendant, this.numMaxConsumption, this.activeId, null);
  }
  
  public Builder jumpUrl(String paramString)
  {
    this.jumpUrl = paramString;
    return this;
  }
  
  public Builder numMaxConsumption(String paramString)
  {
    this.numMaxConsumption = paramString;
    return this;
  }
  
  public Builder pendantUrl(String paramString)
  {
    this.pendantUrl = paramString;
    return this;
  }
  
  public Builder pictureUrl(String paramString)
  {
    this.pictureUrl = paramString;
    return this;
  }
  
  public Builder popUpTime(String paramString)
  {
    this.popUpTime = paramString;
    return this;
  }
  
  public Builder scene(int paramInt)
  {
    this.scene = paramInt;
    return this;
  }
  
  public Builder showPendant(String paramString)
  {
    this.showPendant = paramString;
    return this;
  }
  
  public Builder staticPendantUrl(String paramString)
  {
    this.staticPendantUrl = paramString;
    return this;
  }
  
  public Builder type(String paramString)
  {
    this.type = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo.Builder
 * JD-Core Version:    0.7.0.1
 */
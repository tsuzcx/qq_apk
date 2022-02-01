package com.tencent.qqmini.sdk.launcher.core.model;

import cooperation.vip.pb.TianShuAccess.AdItem;

public class PendantAdInfo
{
  public static final String SHOULD_PENDANT_SHOW = "1";
  public static final String TYPE_SCHEMA = "1";
  public static final String TYPE_URL = "0";
  public static final String WEBVIEW_AUTO_POPUP = "1";
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
  
  private PendantAdInfo(TianShuAccess.AdItem paramAdItem, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    this.adItem = paramAdItem;
    this.type = paramString1;
    this.pictureUrl = paramString2;
    this.pendantUrl = paramString3;
    this.staticPendantUrl = paramString4;
    this.jumpUrl = paramString5;
    this.appId = paramString6;
    this.scene = paramInt;
    this.autoPopUpWebview = paramString7;
    this.popUpTime = paramString8;
    this.autoWebviewDelay = paramString9;
    this.showPendant = paramString10;
    this.absTimeShowPendant = paramString11;
    this.absTimeRemovePendant = paramString12;
    this.numMaxConsumption = paramString13;
    this.activeId = paramString14;
  }
  
  public String getAbsTimeRemovePendant()
  {
    return this.absTimeRemovePendant;
  }
  
  public String getAbsTimeShowPendant()
  {
    return this.absTimeShowPendant;
  }
  
  public String getActiveId()
  {
    return this.activeId;
  }
  
  public TianShuAccess.AdItem getAdItem()
  {
    return this.adItem;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getAutoPopUpWebview()
  {
    return this.autoPopUpWebview;
  }
  
  public String getAutoWebviewDelay()
  {
    return this.autoWebviewDelay;
  }
  
  public String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  public String getNumMaxConsumption()
  {
    return this.numMaxConsumption;
  }
  
  public String getPendantUrl()
  {
    return this.pendantUrl;
  }
  
  public String getPictureUrl()
  {
    return this.pictureUrl;
  }
  
  public String getPopUpTime()
  {
    return this.popUpTime;
  }
  
  public int getScene()
  {
    return this.scene;
  }
  
  public String getShowPendant()
  {
    return this.showPendant;
  }
  
  public String getStaticPendantUrl()
  {
    return this.staticPendantUrl;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean isSchema()
  {
    return "1".equals(this.type);
  }
  
  public void setCurrentAvailableConsumption(String paramString)
  {
    this.numMaxConsumption = paramString;
  }
  
  public boolean shouldPendantShow()
  {
    return "1".equals(this.showPendant);
  }
  
  public boolean shouldWebviewAutoPopup()
  {
    return "1".equals(this.autoPopUpWebview);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo
 * JD-Core Version:    0.7.0.1
 */
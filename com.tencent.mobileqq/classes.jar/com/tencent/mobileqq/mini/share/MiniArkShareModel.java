package com.tencent.mobileqq.mini.share;

import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;

public class MiniArkShareModel
{
  private final String appId;
  private final String appidRich;
  private final String description;
  private final EntryModel entryModel;
  private final String iconUrl;
  private final String jumpUrl;
  private final String picUrl;
  private final String rcvOpenId;
  private final int shareBusinessType;
  private final ShareChatModel shareChatModel;
  private final int shareScene;
  private final int shareTarget;
  private final int shareTemplateType;
  private final String templateData;
  private final String templateId;
  private final String title;
  private final String versionId;
  private final int versionType;
  private final String vidUrl;
  private final String webURL;
  
  public MiniArkShareModel(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, EntryModel paramEntryModel, ShareChatModel paramShareChatModel, int paramInt5, String paramString13)
  {
    this.appId = paramString1;
    this.title = paramString2;
    this.description = paramString3;
    this.shareScene = paramInt1;
    this.shareTemplateType = paramInt2;
    this.shareBusinessType = paramInt3;
    this.picUrl = paramString4;
    this.vidUrl = paramString5;
    this.jumpUrl = paramString6;
    this.iconUrl = paramString7;
    this.versionType = paramInt4;
    this.versionId = paramString8;
    this.webURL = paramString9;
    this.appidRich = paramString10;
    this.entryModel = paramEntryModel;
    this.shareChatModel = paramShareChatModel;
    this.templateId = paramString11;
    this.templateData = paramString12;
    this.shareTarget = paramInt5;
    this.rcvOpenId = paramString13;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getAppidRich()
  {
    return this.appidRich;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public EntryModel getEntryModel()
  {
    return this.entryModel;
  }
  
  public String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  public String getPicUrl()
  {
    return this.picUrl;
  }
  
  public String getRcvOpenId()
  {
    return this.rcvOpenId;
  }
  
  public int getShareBusinessType()
  {
    return this.shareBusinessType;
  }
  
  public ShareChatModel getShareChatModel()
  {
    return this.shareChatModel;
  }
  
  public int getShareScene()
  {
    return this.shareScene;
  }
  
  public int getShareTarget()
  {
    return this.shareTarget;
  }
  
  public int getShareTemplateType()
  {
    return this.shareTemplateType;
  }
  
  public String getTemplateData()
  {
    return this.templateData;
  }
  
  public String getTemplateId()
  {
    return this.templateId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getVersionId()
  {
    return this.versionId;
  }
  
  public int getVersionType()
  {
    return this.versionType;
  }
  
  public String getVidUrl()
  {
    return this.vidUrl;
  }
  
  public String getWebURL()
  {
    return this.webURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareModel
 * JD-Core Version:    0.7.0.1
 */
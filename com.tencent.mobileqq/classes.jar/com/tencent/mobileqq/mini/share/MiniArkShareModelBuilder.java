package com.tencent.mobileqq.mini.share;

import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;

public class MiniArkShareModelBuilder
{
  private String appId;
  private String appidRich;
  private String description;
  private EntryModel entryModel;
  private String iconUrl;
  private String jumpUrl;
  private String picUrl;
  private String rcvOpenId;
  private int shareBusinessType;
  private ShareChatModel shareChatModel;
  private int shareScene;
  private int shareTarget;
  private int shareTemplateType;
  private String templateData;
  private String templateId;
  private String title;
  private String versionId;
  private int versionType;
  private String vidUrl;
  private String webURL;
  
  public MiniArkShareModel createMiniArkShareModel()
  {
    return new MiniArkShareModel(this.appId, this.title, this.description, this.shareScene, this.shareTemplateType, this.shareBusinessType, this.picUrl, this.vidUrl, this.jumpUrl, this.iconUrl, this.versionType, this.versionId, this.webURL, this.appidRich, this.templateId, this.templateData, this.entryModel, this.shareChatModel, this.shareTarget, this.rcvOpenId);
  }
  
  public MiniArkShareModelBuilder setAppId(String paramString)
  {
    this.appId = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setAppidRich(String paramString)
  {
    this.appidRich = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setDescription(String paramString)
  {
    this.description = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setEntryModel(EntryModel paramEntryModel)
  {
    this.entryModel = paramEntryModel;
    return this;
  }
  
  public MiniArkShareModelBuilder setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setJumpUrl(String paramString)
  {
    this.jumpUrl = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setPicUrl(String paramString)
  {
    this.picUrl = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setRcvOpenId(String paramString)
  {
    this.rcvOpenId = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setShareBusinessType(int paramInt)
  {
    this.shareBusinessType = paramInt;
    return this;
  }
  
  public MiniArkShareModelBuilder setShareChatModel(ShareChatModel paramShareChatModel)
  {
    this.shareChatModel = paramShareChatModel;
    return this;
  }
  
  public MiniArkShareModelBuilder setShareScene(int paramInt)
  {
    this.shareScene = paramInt;
    return this;
  }
  
  public MiniArkShareModelBuilder setShareTarget(int paramInt)
  {
    this.shareTarget = paramInt;
    return this;
  }
  
  public MiniArkShareModelBuilder setShareTemplateType(int paramInt)
  {
    this.shareTemplateType = paramInt;
    return this;
  }
  
  public MiniArkShareModelBuilder setTemplateData(String paramString)
  {
    this.templateData = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setTemplateId(String paramString)
  {
    this.templateId = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setTitle(String paramString)
  {
    this.title = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setVersionId(String paramString)
  {
    this.versionId = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setVersionType(int paramInt)
  {
    this.versionType = paramInt;
    return this;
  }
  
  public MiniArkShareModelBuilder setVidUrl(String paramString)
  {
    this.vidUrl = paramString;
    return this;
  }
  
  public MiniArkShareModelBuilder setWebURL(String paramString)
  {
    this.webURL = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder
 * JD-Core Version:    0.7.0.1
 */
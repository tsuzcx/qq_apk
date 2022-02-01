package com.tencent.qqmini.sdk.launcher.model;

import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;

public class InnerShareData$Builder
{
  private InnerShareData shareData = new InnerShareData(null);
  
  public InnerShareData build()
  {
    return this.shareData;
  }
  
  public Builder setCallbackId(int paramInt)
  {
    this.shareData.callbackId = paramInt;
    return this;
  }
  
  public Builder setEntryModel(EntryModel paramEntryModel)
  {
    this.shareData.entryModel = paramEntryModel;
    return this;
  }
  
  public Builder setEntryPath(String paramString)
  {
    this.shareData.entryPath = paramString;
    return this;
  }
  
  public Builder setEvent(String paramString)
  {
    this.shareData.event = paramString;
    return this;
  }
  
  public Builder setExtInfo(COMM.StCommonExt paramStCommonExt)
  {
    this.shareData.extInfo = paramStCommonExt;
    return this;
  }
  
  public Builder setFromActivity(Activity paramActivity)
  {
    this.shareData.fromActivity = paramActivity;
    return this;
  }
  
  public Builder setIsLocalPic(boolean paramBoolean)
  {
    this.shareData.isLocalPic = paramBoolean;
    return this;
  }
  
  public Builder setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.shareData.miniAppInfo = paramMiniAppInfo;
    return this;
  }
  
  public Builder setRecvOpenId(String paramString)
  {
    this.shareData.recvOpenId = paramString;
    return this;
  }
  
  public Builder setShareChatModel(ShareChatModel paramShareChatModel)
  {
    this.shareData.shareChatModel = paramShareChatModel;
    return this;
  }
  
  public Builder setShareInMiniProcess(boolean paramBoolean)
  {
    this.shareData.shareInMiniProcess = paramBoolean;
    return this;
  }
  
  public Builder setShareItemId(int paramInt)
  {
    this.shareData.shareItemId = paramInt;
    return this;
  }
  
  public Builder setSharePicPath(String paramString)
  {
    this.shareData.sharePicPath = paramString;
    return this;
  }
  
  public Builder setShareScene(int paramInt)
  {
    this.shareData.shareScene = paramInt;
    return this;
  }
  
  public Builder setShareSource(int paramInt)
  {
    this.shareData.shareSource = paramInt;
    return this;
  }
  
  public Builder setShareTarget(int paramInt)
  {
    this.shareData.shareTarget = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (MoreItem.isValidExtendedItemId(paramInt)) {
        setShareItemId(paramInt);
      }
      return this;
      setShareItemId(1);
      continue;
      setShareItemId(2);
      continue;
      setShareItemId(3);
      continue;
      setShareItemId(4);
    }
  }
  
  public Builder setSummary(String paramString)
  {
    this.shareData.summary = paramString;
    return this;
  }
  
  public Builder setTargetUrl(String paramString)
  {
    this.shareData.targetUrl = paramString;
    return this;
  }
  
  public Builder setTemplateData(String paramString)
  {
    this.shareData.templateData = paramString;
    return this;
  }
  
  public Builder setTemplateId(String paramString)
  {
    this.shareData.templateId = paramString;
    return this;
  }
  
  public Builder setTitle(String paramString)
  {
    this.shareData.title = paramString;
    return this;
  }
  
  public Builder setWebUrl(String paramString)
  {
    this.shareData.webURL = paramString;
    return this;
  }
  
  public Builder setWithShareTicket(boolean paramBoolean)
  {
    this.shareData.withShareTicket = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder
 * JD-Core Version:    0.7.0.1
 */
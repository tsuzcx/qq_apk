package com.tencent.qqmini.sdk.launcher.model;

import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import org.json.JSONObject;

public class InnerShareData
  extends ShareData
{
  public static final int SUB_SCENE_ARK_INVITE_API = 4023;
  public int callbackId;
  public EntryModel entryModel;
  public String entryPath;
  public String event;
  public COMM.StCommonExt extInfo;
  public Activity fromActivity;
  public JSONObject jsonObject;
  public String recvOpenId;
  public ShareChatModel shareChatModel;
  public int shareScene = 1;
  public int subScene;
  public String templateData;
  public String templateId;
  public String webURL;
  public boolean withShareTicket;
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.miniAppInfo;
  }
  
  public int getShareType()
  {
    switch (this.shareTarget)
    {
    default: 
      return 6;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 1: 
      return 1;
    }
    return 0;
  }
  
  public void shareAppMessage()
  {
    AppLoaderFactory.g().getMiniAppEnv().getShareManager().shareAppMessage(this);
  }
  
  public void shareAppPictureMessage(IMiniAppContext paramIMiniAppContext)
  {
    AppLoaderFactory.g().getMiniAppEnv().getShareManager().shareAppPictureMessage(paramIMiniAppContext, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InnerShareData{fromActivity=");
    localStringBuilder.append(this.fromActivity);
    localStringBuilder.append(", entryPath='");
    localStringBuilder.append(this.entryPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", webURL='");
    localStringBuilder.append(this.webURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", templateId='");
    localStringBuilder.append(this.templateId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", templateData='");
    localStringBuilder.append(this.templateData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", entryModel=");
    localStringBuilder.append(this.entryModel);
    localStringBuilder.append(", shareChatModel=");
    localStringBuilder.append(this.shareChatModel);
    localStringBuilder.append(", withShareTicket=");
    localStringBuilder.append(this.withShareTicket);
    localStringBuilder.append(", recvOpenId='");
    localStringBuilder.append(this.recvOpenId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", event='");
    localStringBuilder.append(this.event);
    localStringBuilder.append('\'');
    localStringBuilder.append(", callbackId=");
    localStringBuilder.append(this.callbackId);
    localStringBuilder.append(", jsonObject=");
    localStringBuilder.append(this.jsonObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.InnerShareData
 * JD-Core Version:    0.7.0.1
 */
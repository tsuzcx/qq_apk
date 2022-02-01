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
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 4;
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
    return "InnerShareData{fromActivity=" + this.fromActivity + ", entryPath='" + this.entryPath + '\'' + ", webURL='" + this.webURL + '\'' + ", templateId='" + this.templateId + '\'' + ", templateData='" + this.templateData + '\'' + ", entryModel=" + this.entryModel + ", shareChatModel=" + this.shareChatModel + ", withShareTicket=" + this.withShareTicket + ", recvOpenId='" + this.recvOpenId + '\'' + ", event='" + this.event + '\'' + ", callbackId=" + this.callbackId + ", jsonObject=" + this.jsonObject + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.InnerShareData
 * JD-Core Version:    0.7.0.1
 */
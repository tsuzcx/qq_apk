package com.tencent.mobileqq.qqgamepub.data;

import java.io.Serializable;

public class QQGameMsgInfo
  implements Serializable
{
  public static final int MSG_TYPE_ARK = 1;
  public static final int MSG_TYPE_IMGHEADER = 2;
  public static final int MSG_TYPE_TEXTHEADER = 3;
  public static final int REPORT_TYPE_CLICK = 2;
  public static final int REPORT_TYPE_RECEIVE = 1;
  public String actionUrl = "";
  public String adJson = null;
  public String advId = "";
  public String arkAppConfig = "";
  public String arkAppMinVersion = "";
  public String arkAppName = "";
  public String arkAppView = "";
  public int arkHeight;
  public String arkMetaList = "";
  public int arkWidth;
  public String contentText = "";
  public String coverUrl = "";
  public String dateTitle = "";
  public String desc = "";
  public String extJson = "";
  public String frienduin = "";
  public String gameAppId = "";
  public String icon = "";
  public boolean isAdMsg = false;
  public int istroop;
  public String limitText = "";
  public String loadArkResPath;
  public long msgTime;
  public int msgType;
  public String paMsgid = "";
  public String sortedConfigs = "";
  public String taskId = "";
  public String title = "";
  public String triggerInfo = "";
  public long uniseq;
  public String url = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGameMsgInfo{msgType=");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(", msgTime=");
    localStringBuilder.append(this.msgTime);
    localStringBuilder.append(", istroop=");
    localStringBuilder.append(this.istroop);
    localStringBuilder.append(", paMsgid='");
    localStringBuilder.append(this.paMsgid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gameAppId='");
    localStringBuilder.append(this.gameAppId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskId='");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extJson='");
    localStringBuilder.append(this.extJson);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sortedConfigs='");
    localStringBuilder.append(this.sortedConfigs);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkAppName='");
    localStringBuilder.append(this.arkAppName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkAppView='");
    localStringBuilder.append(this.arkAppView);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkAppMinVersion='");
    localStringBuilder.append(this.arkAppMinVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkMetaList='");
    localStringBuilder.append(this.arkMetaList);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkAppConfig='");
    localStringBuilder.append(this.arkAppConfig);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arkWidth=");
    localStringBuilder.append(this.arkWidth);
    localStringBuilder.append(", arkHeight=");
    localStringBuilder.append(this.arkHeight);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dateTitle='");
    localStringBuilder.append(this.dateTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentText='");
    localStringBuilder.append(this.contentText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", limitText='");
    localStringBuilder.append(this.limitText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", actionUrl='");
    localStringBuilder.append(this.actionUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", frienduin='");
    localStringBuilder.append(this.frienduin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uniseq=");
    localStringBuilder.append(this.uniseq);
    localStringBuilder.append(", advId='");
    localStringBuilder.append(this.advId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", triggerInfo='");
    localStringBuilder.append(this.triggerInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", icon='");
    localStringBuilder.append(this.icon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAdMsg=");
    localStringBuilder.append(this.isAdMsg);
    localStringBuilder.append(", adJson='");
    localStringBuilder.append(this.adJson);
    localStringBuilder.append('\'');
    localStringBuilder.append(", loadArkResPath='");
    localStringBuilder.append(this.loadArkResPath);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo
 * JD-Core Version:    0.7.0.1
 */
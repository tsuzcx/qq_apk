package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;
import java.util.ArrayList;

public class Kandian210Msg0xeeInfo$NotifyInfo
  implements Serializable
{
  public long algorithmID;
  public int appPushType;
  public int arkEnable;
  public int commentLength;
  public String contextBrief;
  public long contextId;
  public String contextTitle;
  public int contextType;
  public int duration;
  public long endTime;
  public String extCookie;
  public String extInfo;
  public long folderStatus = 10L;
  public int fontSize;
  public String orangeWord;
  public Kandian210Msg0xeeInfo.OrdinaryPushInfo ordinaryPushInfo;
  public String pictureJumpURL;
  public ArrayList<String> picturesURLList;
  public long sceneType;
  public int showLine;
  public Kandian210Msg0xeeInfo.SocialPushInfo socialPushInfo;
  public long strategyID;
  public int styleType;
  public Kandian210Msg0xeeInfo.UGCPushInfo ugcPushInfo;
  public long uin;
  public String userIconURL;
  public String username;
  public String videoBrief;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyInfo{\nappPushType=");
    localStringBuilder.append(this.appPushType);
    localStringBuilder.append("\n");
    Object localObject = this.ordinaryPushInfo;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.ordinaryPushInfo.toString());
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    if (this.socialPushInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.socialPushInfo.toString());
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (this.ugcPushInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.ugcPushInfo.toString());
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", contextId=");
    localStringBuilder.append(this.contextId);
    localStringBuilder.append(", contextBrief='");
    localStringBuilder.append(this.contextBrief);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contextTitle='");
    localStringBuilder.append(this.contextTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picturesURLList=");
    localStringBuilder.append(this.picturesURLList);
    localStringBuilder.append(", pictureJumpURL='");
    localStringBuilder.append(this.pictureJumpURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", orangeWord='");
    localStringBuilder.append(this.orangeWord);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contextType='");
    localStringBuilder.append(this.contextType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoBrief='");
    localStringBuilder.append(this.videoBrief);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", username='");
    localStringBuilder.append(this.username);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userIconURL='");
    localStringBuilder.append(this.userIconURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", styleType=");
    localStringBuilder.append(this.styleType);
    localStringBuilder.append(", arkEnable=");
    localStringBuilder.append(this.arkEnable);
    localStringBuilder.append(", sceneType=");
    localStringBuilder.append(this.sceneType);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", algorithmID=");
    localStringBuilder.append(this.algorithmID);
    localStringBuilder.append(", strategyID=");
    localStringBuilder.append(this.strategyID);
    localStringBuilder.append(", folderStatus=");
    localStringBuilder.append(this.folderStatus);
    localStringBuilder.append(", commentLength=");
    localStringBuilder.append(this.commentLength);
    localStringBuilder.append(", showLine=");
    localStringBuilder.append(this.showLine);
    localStringBuilder.append(", fontSize=");
    localStringBuilder.append(this.fontSize);
    localStringBuilder.append(", extInfo='");
    localStringBuilder.append(this.extInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extCookie='");
    localStringBuilder.append(this.extCookie);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.NotifyInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.data;

import awbv;
import awdg;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="subuin,trunkuin")
public class SubAccountInfo
  extends awbv
{
  public static final int INIT = 0;
  public static final int LOSS_OF_LOCAL_IDENTITY = 2;
  public static final int NORMAL = 1;
  public static final int SERVER_ERROR = 3;
  @awdg
  public String A2;
  public byte[] cookie;
  public boolean hintIsNew;
  public boolean isTop;
  public byte isbind;
  public long lastCleanQZoneMessageTime;
  @awdg
  public CharSequence lastMsg;
  @awdg
  public String lastUin;
  @awdg
  public String lastUinNick;
  public long lasttime;
  public String serverErrorMsg;
  public int serverErrorType;
  public int status;
  @Deprecated
  public String subname;
  public String subuin;
  public String trunkuin;
  @awdg
  public int unNotifySender;
  @awdg
  public int unreadMsgNum;
  @awdg
  public int unreadSenderNum;
  @awdg
  public int unreadTroopMsgNum;
  
  public void cloneTo(SubAccountInfo paramSubAccountInfo)
  {
    if ((paramSubAccountInfo != null) && (paramSubAccountInfo.subuin != null) && (paramSubAccountInfo.trunkuin != null))
    {
      this.subuin = paramSubAccountInfo.subuin;
      this.subname = paramSubAccountInfo.subname;
      this.trunkuin = paramSubAccountInfo.trunkuin;
      this.isbind = paramSubAccountInfo.isbind;
      this.lasttime = paramSubAccountInfo.lasttime;
      this.lastUin = paramSubAccountInfo.lastUin;
      this.lastUinNick = paramSubAccountInfo.lastUinNick;
      this.lastMsg = paramSubAccountInfo.lastMsg;
      this.A2 = paramSubAccountInfo.A2;
      this.unreadMsgNum = paramSubAccountInfo.unreadMsgNum;
      this.unreadSenderNum = paramSubAccountInfo.unreadSenderNum;
      this.unreadTroopMsgNum = paramSubAccountInfo.unreadTroopMsgNum;
      this.unNotifySender = paramSubAccountInfo.unNotifySender;
      this.isTop = paramSubAccountInfo.isTop;
      this.cookie = paramSubAccountInfo.cookie;
      this.serverErrorType = paramSubAccountInfo.serverErrorType;
      this.serverErrorMsg = paramSubAccountInfo.serverErrorMsg;
      this.lastCleanQZoneMessageTime = paramSubAccountInfo.lastCleanQZoneMessageTime;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountINfo,");
    localStringBuilder.append("subuin:").append(this.subuin).append(",subname:").append(this.subname).append(",trunk:").append(this.trunkuin).append(",isbind:").append(this.isbind).append(",unreadMsgNum:").append(this.unreadMsgNum).append(",unreadSenderNum:").append(this.unreadSenderNum).append(",unreadTroopMsgNum:").append(this.unreadTroopMsgNum).append(",unNotificationSender:").append(this.unNotifySender).append(",lasttime:").append(this.lasttime).append(",serverErrorType:").append(this.serverErrorType).append(",serverErrorMsg:").append(this.serverErrorMsg).append(",lastCleanQZoneMessageTime:").append(this.lastCleanQZoneMessageTime);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountInfo
 * JD-Core Version:    0.7.0.1
 */
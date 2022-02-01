package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="subuin,trunkuin")
public class SubAccountInfo
  extends Entity
{
  public static final int INIT = 0;
  public static final int LOSS_OF_LOCAL_IDENTITY = 2;
  public static final int NORMAL = 1;
  public static final int SERVER_ERROR = 3;
  @notColumn
  public String A2;
  public byte[] cookie;
  public boolean hintIsNew;
  public boolean isTop;
  public byte isbind;
  public long lastCleanQZoneMessageTime = 0L;
  @notColumn
  public CharSequence lastMsg;
  @notColumn
  public String lastUin;
  @notColumn
  public String lastUinNick;
  public long lasttime;
  public String serverErrorMsg = null;
  public int serverErrorType = 0;
  public int status;
  @Deprecated
  public String subname;
  public String subuin;
  public String trunkuin;
  @notColumn
  public int unNotifySender = 0;
  @notColumn
  public int unreadMsgNum;
  @notColumn
  public int unreadSenderNum = 0;
  @notColumn
  public int unreadTroopMsgNum;
  
  public void cloneTo(SubAccountInfo paramSubAccountInfo)
  {
    if (paramSubAccountInfo != null)
    {
      String str1 = paramSubAccountInfo.subuin;
      if (str1 != null)
      {
        String str2 = paramSubAccountInfo.trunkuin;
        if (str2 != null)
        {
          this.subuin = str1;
          this.subname = paramSubAccountInfo.subname;
          this.trunkuin = str2;
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
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountINfo,");
    localStringBuilder.append("subuin:");
    localStringBuilder.append(this.subuin);
    localStringBuilder.append(",subname:");
    localStringBuilder.append(this.subname);
    localStringBuilder.append(",trunk:");
    localStringBuilder.append(this.trunkuin);
    localStringBuilder.append(",isbind:");
    localStringBuilder.append(this.isbind);
    localStringBuilder.append(",unreadMsgNum:");
    localStringBuilder.append(this.unreadMsgNum);
    localStringBuilder.append(",unreadSenderNum:");
    localStringBuilder.append(this.unreadSenderNum);
    localStringBuilder.append(",unreadTroopMsgNum:");
    localStringBuilder.append(this.unreadTroopMsgNum);
    localStringBuilder.append(",unNotificationSender:");
    localStringBuilder.append(this.unNotifySender);
    localStringBuilder.append(",lasttime:");
    localStringBuilder.append(this.lasttime);
    localStringBuilder.append(",serverErrorType:");
    localStringBuilder.append(this.serverErrorType);
    localStringBuilder.append(",serverErrorMsg:");
    localStringBuilder.append(this.serverErrorMsg);
    localStringBuilder.append(",lastCleanQZoneMessageTime:");
    localStringBuilder.append(this.lastCleanQZoneMessageTime);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountInfo
 * JD-Core Version:    0.7.0.1
 */
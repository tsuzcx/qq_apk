package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import java.io.Serializable;

public class ImportantMsgItem$MsgInfo
  implements Serializable, Comparable<MsgInfo>
{
  public static final int NOT_SHOW_TYPE_CONFIG = 3;
  public static final int NOT_SHOW_TYPE_DEFAULT = 0;
  public static final int NOT_SHOW_TYPE_DEL = 1;
  public static final int NOT_SHOW_TYPE_REVOKE = 2;
  public static final int NOT_SHOW_TYPE_TROOPNOTIFICATION_SHOWWINDOW = 4;
  private static final long serialVersionUID = 1L;
  int msgEnum;
  public boolean msgNeedShow;
  public int msgNotShowType;
  String msgSendUin;
  long msgSeq;
  public String msgSummary;
  long msgTime;
  
  public ImportantMsgItem$MsgInfo()
  {
    this.msgTime = 0L;
    this.msgSeq = 0L;
    this.msgSendUin = "";
    this.msgEnum = 0;
    this.msgSummary = "";
    this.msgNeedShow = true;
    this.msgNotShowType = 0;
  }
  
  public ImportantMsgItem$MsgInfo(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2)
  {
    this.msgTime = paramLong1;
    this.msgSeq = paramLong2;
    this.msgSendUin = paramString1;
    this.msgEnum = paramInt1;
    this.msgSummary = paramString2;
    this.msgNeedShow = paramBoolean;
    this.msgNotShowType = paramInt2;
  }
  
  public int compareTo(MsgInfo paramMsgInfo)
  {
    if (this.msgSeq > paramMsgInfo.msgSeq) {
      return 1;
    }
    if (this.msgSeq == paramMsgInfo.msgSeq) {
      return 0;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof MsgInfo)) || (((MsgInfo)paramObject).msgSeq != this.msgSeq)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgTime").append("=").append(this.msgTime);
    localStringBuilder.append(", msgSeq").append("=").append(this.msgSeq);
    localStringBuilder.append(", msgSendUin").append("=").append(this.msgSendUin);
    localStringBuilder.append(", msgEnum").append("=").append(this.msgEnum);
    localStringBuilder.append(", msgNeedShow").append("=").append(this.msgNeedShow);
    localStringBuilder.append(", msgNotShowType").append("=").append(this.msgNotShowType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem.MsgInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.data;

import com.tencent.mobileqq.utils.ViewUtils;

public class MessageForGrayTips$HighlightItem
{
  public int actionType;
  public int color;
  public int end;
  public int groupId;
  public String icon;
  public String iconAlt;
  private int iconSize = ViewUtils.dpToPx(16.0F);
  public String mMsgActionData;
  public String mMsg_A_ActionData;
  public boolean needUpdateNick;
  public String remark;
  public int start;
  public int textColor;
  public long uin;
  
  MessageForGrayTips$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.uin = paramLong;
    if (paramInt3 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.needUpdateNick = bool;
      this.actionType = paramInt4;
      this.mMsgActionData = paramString1;
      this.mMsg_A_ActionData = paramString2;
      return;
    }
  }
  
  public MessageForGrayTips$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2);
    this.icon = paramString3;
    this.iconAlt = paramString4;
    this.textColor = paramInt5;
  }
  
  public MessageForGrayTips$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, String paramString5, int paramInt6)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramString4, paramInt5);
    this.remark = paramString5;
    this.groupId = paramInt6;
  }
  
  public int getIconSize()
  {
    return this.iconSize;
  }
  
  public String toString()
  {
    return "HighlightItem{start=" + this.start + ", end=" + this.end + ", uin=" + this.uin + ", needUpdateNick=" + this.needUpdateNick + ", actionType=" + this.actionType + ", color=" + this.color + ", icon='" + this.icon + '\'' + ", iconSize=" + this.iconSize + ", iconAlt='" + this.iconAlt + '\'' + ", textColor=" + this.textColor + ", remark='" + this.remark + '\'' + ", groupId=" + this.groupId + ", mMsgActionData='" + this.mMsgActionData + '\'' + ", mMsg_A_ActionData='" + this.mMsg_A_ActionData + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.data;

import bajq;

public class MessageForGrayTips$HightlightItem
{
  public int actionType;
  public int end;
  public int groupId;
  public String icon;
  public String iconAlt;
  private int iconSize = bajq.b(16.0F);
  public String mMsgActionData;
  public String mMsg_A_ActionData;
  public boolean needUpdateNick;
  public String remark;
  public int start;
  public int textColor;
  public long uin;
  
  MessageForGrayTips$HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2)
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
  
  public MessageForGrayTips$HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2);
    this.icon = paramString3;
    this.iconAlt = paramString4;
    this.textColor = paramInt5;
  }
  
  public MessageForGrayTips$HightlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, String paramString5, int paramInt6)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramString4, paramInt5);
    this.remark = paramString5;
    this.groupId = paramInt6;
  }
  
  public int getIconSize()
  {
    return this.iconSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem
 * JD-Core Version:    0.7.0.1
 */
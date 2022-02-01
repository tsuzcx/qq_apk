package com.tencent.mobileqq.data;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.ViewUtils;

public class GrayTipsMessageConstants$HighlightItem
{
  public int actionType;
  public int color;
  public int end;
  public int groupId;
  public String icon;
  public String iconAlt;
  private int iconSize = ViewUtils.dpToPx(16.0F);
  public Bitmap mBitmap = null;
  public String mMsgAActionData = null;
  public String mMsgActionData = null;
  public boolean needUpdateNick;
  public String remark = null;
  public int start;
  public int textColor;
  public long uin;
  
  GrayTipsMessageConstants$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.uin = paramLong;
    boolean bool;
    if (paramInt3 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.needUpdateNick = bool;
    this.actionType = paramInt4;
    this.mMsgActionData = paramString1;
    this.mMsgAActionData = paramString2;
  }
  
  public GrayTipsMessageConstants$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2);
    this.icon = paramString3;
    this.iconAlt = paramString4;
    this.textColor = paramInt5;
  }
  
  public GrayTipsMessageConstants$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, String paramString5, int paramInt6)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramString4, paramInt5);
    this.remark = paramString5;
    this.groupId = paramInt6;
  }
  
  public GrayTipsMessageConstants$HighlightItem(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, String paramString5, int paramInt6, Bitmap paramBitmap)
  {
    this(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramString4, paramInt5);
    this.remark = paramString5;
    this.groupId = paramInt6;
    this.mBitmap = paramBitmap;
  }
  
  public int getIconSize()
  {
    return this.iconSize;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HighlightItem{start=");
    localStringBuilder.append(this.start);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.end);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", needUpdateNick=");
    localStringBuilder.append(this.needUpdateNick);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.actionType);
    localStringBuilder.append(", color=");
    localStringBuilder.append(this.color);
    localStringBuilder.append(", icon='");
    localStringBuilder.append(this.icon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconSize=");
    localStringBuilder.append(this.iconSize);
    localStringBuilder.append(", iconAlt='");
    localStringBuilder.append(this.iconAlt);
    localStringBuilder.append('\'');
    localStringBuilder.append(", textColor=");
    localStringBuilder.append(this.textColor);
    localStringBuilder.append(", remark='");
    localStringBuilder.append(this.remark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupId=");
    localStringBuilder.append(this.groupId);
    localStringBuilder.append(", mMsgActionData='");
    localStringBuilder.append(this.mMsgActionData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMsg_A_ActionData='");
    localStringBuilder.append(this.mMsgAActionData);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem
 * JD-Core Version:    0.7.0.1
 */
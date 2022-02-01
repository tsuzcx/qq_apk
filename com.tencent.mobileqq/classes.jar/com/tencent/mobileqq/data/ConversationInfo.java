package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class ConversationInfo
  extends Entity
{
  public static final String SUB_ACCOUNT_TROOP_UNREAD_ERROR = " SUB_ACCOUNT_TROOP_UNREAD ERROR ";
  public static final String UNREAD_ERROR = " UNREAD ERROR ";
  public static final String UNREAD_GIFT_COUNT_ERROR = " UNREAD_GIFT_COUNT ERROR ";
  public static final String UNREAD_MARK_ERROR = " UNREAD_MARK ERROR ";
  public static final String UNREAD_RED_PACK_ERROR = " UNREAD_RED_PACK ERROR ";
  public static ConversationInfo.Callback sCallback = new ConversationInfo.1();
  private static final String tableName = "conversation_info";
  public byte[] extData;
  public int extInt1;
  public int extInt2;
  public int extInt3;
  public String extString;
  public boolean isImax = false;
  public long lastread;
  @notColumn
  public TinyInfo tinyInfo;
  public int type;
  public String uin;
  public int unreadCount;
  public int unreadGiftCount;
  public int unreadMark;
  
  static {}
  
  public ConversationInfo() {}
  
  public ConversationInfo(String paramString, int paramInt)
  {
    this.uin = paramString;
    setType(paramInt);
    sCallback.a(paramString, paramInt);
  }
  
  public ConversationInfo(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    this.uin = paramString;
    setType(paramInt1);
    this.lastread = paramLong;
    setUnread(paramInt2);
    sCallback.a(paramString, paramInt1);
  }
  
  public static String getConversationInfoTableName()
  {
    return "conversation_info";
  }
  
  public static void setCallback(ConversationInfo.Callback paramCallback)
  {
    sCallback = paramCallback;
  }
  
  public String getTableName()
  {
    return getConversationInfoTableName();
  }
  
  protected void postRead()
  {
    super.postRead();
    if (!TextUtils.isEmpty(this.extString)) {
      this.tinyInfo = new TinyInfo(this.extString);
    }
  }
  
  protected void prewrite()
  {
    super.prewrite();
    TinyInfo localTinyInfo = this.tinyInfo;
    if (localTinyInfo != null) {
      this.extString = localTinyInfo.toJsonStr();
    }
  }
  
  public void setExtInt1(int paramInt)
  {
    this.extInt1 = paramInt;
    sCallback.a(paramInt, this, " UNREAD_RED_PACK ERROR ");
  }
  
  public void setExtInt2(int paramInt)
  {
    this.extInt2 = paramInt;
    sCallback.a(paramInt, this, " SUB_ACCOUNT_TROOP_UNREAD ERROR ");
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
    sCallback.a(paramInt, this);
  }
  
  public void setUnread(int paramInt)
  {
    this.unreadCount = paramInt;
    sCallback.a(paramInt, this, " UNREAD ERROR ");
  }
  
  public void setUnreadGiftCount(int paramInt)
  {
    this.unreadGiftCount = paramInt;
    sCallback.a(paramInt, this, " UNREAD_GIFT_COUNT ERROR ");
  }
  
  public void setUnreadMark(int paramInt)
  {
    this.unreadMark = paramInt;
    sCallback.a(paramInt, this, " UNREAD_MARK ERROR ");
  }
  
  public String toString()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.uin;
    }
    else if ((!TextUtils.isEmpty(this.uin)) && (this.uin.length() >= 4))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("*");
      localObject2 = this.uin;
      ((StringBuilder)localObject1).append(((String)localObject2).substring(((String)localObject2).length() - 4, this.uin.length()));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = this.uin;
    }
    Object localObject2 = new StringBuilder("--ConversationInfo--");
    ((StringBuilder)localObject2).append(",shortUin:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(",type:");
    ((StringBuilder)localObject2).append(this.type);
    ((StringBuilder)localObject2).append(",lastread:");
    ((StringBuilder)localObject2).append(this.lastread);
    ((StringBuilder)localObject2).append(",unreadCount:");
    ((StringBuilder)localObject2).append(this.unreadCount);
    ((StringBuilder)localObject2).append(",unreadGiftCount:");
    ((StringBuilder)localObject2).append(this.unreadGiftCount);
    ((StringBuilder)localObject2).append(",unreadRedPacketCount:");
    ((StringBuilder)localObject2).append(this.extInt1);
    ((StringBuilder)localObject2).append(",subAccountTroopunReadMsg:");
    ((StringBuilder)localObject2).append(this.extInt2);
    ((StringBuilder)localObject2).append(",PublicAccountConversationRedMask:");
    ((StringBuilder)localObject2).append(this.extInt3);
    ((StringBuilder)localObject2).append(",unreadMark:");
    ((StringBuilder)localObject2).append(this.unreadMark);
    ((StringBuilder)localObject2).append(", extStr:");
    ((StringBuilder)localObject2).append(this.extString);
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfo
 * JD-Core Version:    0.7.0.1
 */
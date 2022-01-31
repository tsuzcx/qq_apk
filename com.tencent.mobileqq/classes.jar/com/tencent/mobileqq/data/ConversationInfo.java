package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class ConversationInfo
  extends Entity
{
  private static final String tableName = "conversation_info";
  public byte[] extData;
  public int extInt1;
  public int extInt2;
  public int extInt3;
  public String extString;
  public boolean isImax;
  public long lastread;
  public int type;
  public String uin;
  public int unreadCount;
  public int unreadGiftCount;
  public int unreadMark;
  
  public ConversationInfo() {}
  
  public ConversationInfo(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.type = paramInt;
  }
  
  public ConversationInfo(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.lastread = paramLong;
    this.unreadCount = paramInt2;
  }
  
  public static String getConversationInfoTableName()
  {
    return "conversation_info";
  }
  
  public String getTableName()
  {
    return getConversationInfoTableName();
  }
  
  public String toString()
  {
    String str;
    if (QLog.isColorLevel()) {
      str = this.uin;
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("--ConversationInfo--");
      localStringBuilder.append(",shortUin:").append(str).append(",type:").append(this.type).append(",lastread:").append(this.lastread).append(",unreadCount:").append(this.unreadCount).append(",unreadGiftCount:").append(this.unreadGiftCount).append(",unreadRedPacketCount:").append(this.extInt1).append(",unreadMark:").append(this.unreadMark);
      return localStringBuilder.toString();
      if ((TextUtils.isEmpty(this.uin)) || (this.uin.length() < 4)) {
        str = this.uin;
      } else {
        str = "*" + this.uin.substring(this.uin.length() - 4, this.uin.length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfo
 * JD-Core Version:    0.7.0.1
 */
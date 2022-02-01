package com.tencent.mobileqq.data;

import android.text.TextUtils;
import anvk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class ConversationInfo
  extends Entity
{
  @notColumn
  public static boolean publicaccountTypeErrorReported = false;
  private static final String tableName = "conversation_info";
  public byte[] extData;
  public int extInt1;
  public int extInt2;
  public int extInt3;
  public String extString;
  public boolean isImax;
  public long lastread;
  @notColumn
  public TinyInfo tinyInfo;
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
    reportPublicaccoutTypeError(paramString, paramInt);
  }
  
  public ConversationInfo(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.lastread = paramLong;
    this.unreadCount = paramInt2;
    reportPublicaccoutTypeError(paramString, paramInt1);
  }
  
  public static String getConversationInfoTableName()
  {
    return "conversation_info";
  }
  
  public static boolean reportPublicaccoutTypeError(String paramString, int paramInt)
  {
    if ((paramInt == 1008) && (!publicaccountTypeErrorReported))
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if (localObject != null)
        {
          paramString = ((anvk)((AppRuntime)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
          if ((paramString != null) && (paramString.isFriend()))
          {
            publicaccountTypeErrorReported = true;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public String getTableName()
  {
    return getConversationInfoTableName();
  }
  
  public void postRead()
  {
    super.postRead();
    if (!TextUtils.isEmpty(this.extString)) {
      this.tinyInfo = new TinyInfo(this.extString);
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    if (this.tinyInfo != null) {
      this.extString = this.tinyInfo.toJsonStr();
    }
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
      localStringBuilder.append(",shortUin:").append(str).append(",type:").append(this.type).append(",lastread:").append(this.lastread).append(",unreadCount:").append(this.unreadCount).append(",unreadGiftCount:").append(this.unreadGiftCount).append(",unreadRedPacketCount:").append(this.extInt1).append(",subAccountTroopunReadMsg:").append(this.extInt2).append(",unreadMark:").append(this.unreadMark).append(", extStr:").append(this.extString);
      return localStringBuilder.toString();
      if ((TextUtils.isEmpty(this.uin)) || (this.uin.length() < 4)) {
        str = this.uin;
      } else {
        str = "*" + this.uin.substring(this.uin.length() - 4, this.uin.length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfo
 * JD-Core Version:    0.7.0.1
 */
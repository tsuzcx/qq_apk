package com.tencent.mobileqq.confess;

import atmo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type,topicId,holmesCurCount,holmesTolCount")
public class ConfessConvInfo
  extends atmo
{
  private static final String tableName = "confess_conv_info";
  public int holmesCurCount;
  public int holmesTolCount;
  public long lastread;
  public int topicId;
  public int type;
  public String uin;
  public int unreadCount;
  
  public ConfessConvInfo() {}
  
  public ConfessConvInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.topicId = paramInt2;
  }
  
  public ConfessConvInfo(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.topicId = paramInt2;
    this.lastread = paramLong;
    this.unreadCount = paramInt3;
  }
  
  public static String getConversationInfoTableName()
  {
    return "confess_conv_info";
  }
  
  public String getTableName()
  {
    return getConversationInfoTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessConvInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;

public class QQGuildGuildEntry
  extends Entity
{
  public String avatarUrl;
  @unique
  public String guildId;
  public String guildName;
  public int userType;
  
  public QQGuildGuildEntry() {}
  
  public QQGuildGuildEntry(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.guildId = paramString1;
    this.guildName = paramString2;
    this.userType = paramInt;
    this.avatarUrl = paramString3;
  }
  
  public static QQGuildGuildEntry fromGuildInfo(IGProGuildInfo paramIGProGuildInfo)
  {
    QQGuildGuildEntry localQQGuildGuildEntry = new QQGuildGuildEntry();
    localQQGuildGuildEntry.guildId = paramIGProGuildInfo.getGuildID();
    localQQGuildGuildEntry.guildName = paramIGProGuildInfo.getGuildName();
    localQQGuildGuildEntry.userType = paramIGProGuildInfo.getUserType();
    localQQGuildGuildEntry.avatarUrl = paramIGProGuildInfo.getAvatarUrl(100);
    return localQQGuildGuildEntry;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.guildName = paramCursor.getString(paramCursor.getColumnIndex("guildName"));
    this.guildId = paramCursor.getString(paramCursor.getColumnIndex("guildId"));
    this.userType = paramCursor.getInt(paramCursor.getColumnIndex("userType"));
    this.avatarUrl = paramCursor.getString(paramCursor.getColumnIndex("avatarUrl"));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGuildGuildEntry{guildName='");
    localStringBuilder.append(this.guildName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", guildId='");
    localStringBuilder.append(this.guildId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userType=");
    localStringBuilder.append(this.userType);
    localStringBuilder.append(", avatarUrl='");
    localStringBuilder.append(this.avatarUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQGuildGuildEntry
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

public class QQGuildChannelEntry
  extends Entity
  implements Cloneable
{
  public String guildId;
  public String name;
  public int type;
  @unique
  public String uin;
  
  public QQGuildChannelEntry() {}
  
  public QQGuildChannelEntry(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.uin = paramString1;
    this.guildId = paramString2;
    this.type = paramInt;
    this.name = paramString3;
  }
  
  public static QQGuildChannelEntry ofGuildChannel(String paramString, IGProChannelInfo paramIGProChannelInfo)
  {
    return new QQGuildChannelEntry(paramIGProChannelInfo.getChannelUin(), paramString, 10014, paramIGProChannelInfo.getChannelName());
  }
  
  public static QQGuildChannelEntry ofGuildGroup(String paramString, ICategoryInfo paramICategoryInfo)
  {
    return new QQGuildChannelEntry(String.valueOf(paramICategoryInfo.b()), paramString, 10016, paramICategoryInfo.a());
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.guildId = paramCursor.getString(paramCursor.getColumnIndex("guildId"));
    this.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
    this.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGuildChannelEntry{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", guildId='");
    localStringBuilder.append(this.guildId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQGuildChannelEntry
 * JD-Core Version:    0.7.0.1
 */
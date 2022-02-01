package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class Groups
  extends Entity
{
  public int group_friend_count;
  @unique
  public int group_id;
  public String group_name;
  public byte seqid;
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
    this.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
    this.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
    this.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Groups{group_name='");
    localStringBuilder.append(this.group_name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", group_id=");
    localStringBuilder.append(this.group_id);
    localStringBuilder.append(", group_friend_count=");
    localStringBuilder.append(this.group_friend_count);
    localStringBuilder.append(", seqid=");
    localStringBuilder.append(this.seqid);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Groups
 * JD-Core Version:    0.7.0.1
 */
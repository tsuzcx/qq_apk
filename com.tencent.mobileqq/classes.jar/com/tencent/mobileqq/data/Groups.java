package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class Groups
  extends Entity
{
  @Deprecated
  public long datetime;
  public int group_friend_count;
  @unique
  public int group_id;
  public String group_name;
  @Deprecated
  public int group_online_friend_count;
  public byte seqid;
  @Deprecated
  public int sqqOnLine_count;
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
    this.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
    this.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
    this.group_online_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_online_friend_count"));
    this.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
    this.sqqOnLine_count = paramCursor.getInt(paramCursor.getColumnIndex("sqqOnLine_count"));
    this.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Groups
 * JD-Core Version:    0.7.0.1
 */
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
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    this.group_name = paramCursor.getString(paramCursor.getColumnIndex("group_name"));
    this.group_id = paramCursor.getInt(paramCursor.getColumnIndex("group_id"));
    this.group_friend_count = paramCursor.getInt(paramCursor.getColumnIndex("group_friend_count"));
    this.seqid = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("seqid")));
    return true;
  }
  
  public String toString()
  {
    return "Groups{group_name='" + this.group_name + '\'' + ", group_id=" + this.group_id + ", group_friend_count=" + this.group_friend_count + ", seqid=" + this.seqid + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Groups
 * JD-Core Version:    0.7.0.1
 */
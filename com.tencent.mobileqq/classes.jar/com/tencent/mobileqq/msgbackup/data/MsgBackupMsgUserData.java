package com.tencent.mobileqq.msgbackup.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class MsgBackupMsgUserData
  extends RecentBaseData
{
  public String extra;
  public String name;
  public String uin;
  public int uinType;
  
  public int a()
  {
    return this.uinType;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public String a()
  {
    return this.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public long b()
  {
    return 0L;
  }
  
  public String toString()
  {
    return this.uin + "_" + this.uinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData
 * JD-Core Version:    0.7.0.1
 */
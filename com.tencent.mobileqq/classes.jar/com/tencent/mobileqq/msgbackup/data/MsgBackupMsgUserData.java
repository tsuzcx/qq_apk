package com.tencent.mobileqq.msgbackup.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class MsgBackupMsgUserData
  extends RecentBaseData
{
  public String extra;
  public String name;
  public String uin;
  public int uinType;
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public long getLastDraftTime()
  {
    return 0L;
  }
  
  public long getLastMsgTime()
  {
    return 0L;
  }
  
  public int getRecentUserType()
  {
    return this.uinType;
  }
  
  public String getRecentUserUin()
  {
    return this.uin;
  }
  
  public String toString()
  {
    return this.uin + "_" + this.uinType;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      a((QQAppInterface)paramBaseQQAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData
 * JD-Core Version:    0.7.0.1
 */
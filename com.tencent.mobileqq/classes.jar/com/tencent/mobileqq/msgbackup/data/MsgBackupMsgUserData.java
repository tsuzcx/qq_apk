package com.tencent.mobileqq.msgbackup.data;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class MsgBackupMsgUserData
  extends RecentBaseData
{
  public String extra;
  public String name;
  public String uin;
  public int uinType;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.uin);
    localStringBuilder.append("_");
    localStringBuilder.append(this.uinType);
    return localStringBuilder.toString();
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    update(paramBaseQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData
 * JD-Core Version:    0.7.0.1
 */
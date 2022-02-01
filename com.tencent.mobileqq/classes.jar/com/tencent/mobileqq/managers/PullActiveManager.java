package com.tencent.mobileqq.managers;

import android.content.Intent;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import mqq.manager.Manager;

public class PullActiveManager
  implements Manager
{
  public static String a = "QQ";
  public static String b = "extra_notify_msg";
  public RecentItemPullActivePush c;
  public Intent d;
  private QQAppInterface e;
  private MessageForText f;
  
  public PullActiveManager(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.c == null) {
      return 0;
    }
    return 1;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.c == null)
    {
      localObject = new RecentUser(AppConstants.PULL_ACTIVE_PUSH_UIN, 9653);
      ((RecentUser)localObject).msgType = -1000;
      this.c = new RecentItemPullActivePush((RecentUser)localObject);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = paramIntent.getStringExtra(b);
    this.c.a((String)localObject, l);
    this.d = paramIntent;
  }
  
  public void b()
  {
    this.c = null;
  }
  
  public MessageForText c()
  {
    if (this.c == null) {
      return null;
    }
    if (this.f == null)
    {
      this.f = ((MessageForText)MessageRecordFactory.a(-1000));
      Object localObject = this.f;
      ((MessageForText)localObject).msgtype = -1000;
      ((MessageForText)localObject).istroop = 9653;
      ((MessageForText)localObject).isread = false;
      ((MessageForText)localObject).selfuin = this.e.getCurrentAccountUin();
      this.f.senderuin = AppConstants.PULL_ACTIVE_PUSH_UIN;
      this.f.frienduin = AppConstants.PULL_ACTIVE_PUSH_UIN;
      localObject = this.d;
      if (localObject != null) {
        this.f.msg = ((Intent)localObject).getStringExtra(b);
      }
      this.f.time = this.c.time;
    }
    if ((this.f.msg == null) || (!this.f.msg.equals(this.c.mTitleName))) {
      this.f.msg = this.c.mTitleName;
    }
    if (this.f.time != this.c.time) {
      this.f.time = this.c.time;
    }
    return this.f;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.PullActiveManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.newfriend.msg.controller;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class FriendSystemMsgController
{
  private static FriendSystemMsgController a;
  private boolean b = false;
  private HashMap<Long, structmsg.StructMsg> c = new HashMap();
  private long d = -1L;
  private long e = -1L;
  private String f = null;
  
  public static FriendSystemMsgController a()
  {
    if (a == null) {
      a = new FriendSystemMsgController();
    }
    return a;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    HashMap localHashMap = this.c;
    if (localHashMap != null) {
      return (structmsg.StructMsg)localHashMap.get(paramLong);
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUnReadFriendSystemMsgNum count = ");
      localStringBuilder.append(paramInt);
      QLog.d("FriendSystemMsgController", 2, localStringBuilder.toString(), new Throwable("debug"));
    }
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      paramAppInterface.edit().putInt("sp_unread_friendsys_count", paramInt).commit();
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      paramAppInterface.edit().putLong("sp_oldest_friendmsg", paramLong).commit();
    }
  }
  
  public void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      paramAppInterface.edit().putBoolean("sp_is_sysmsg_over", paramBoolean).commit();
    }
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.c != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("putStructMsgToMap key=");
        localStringBuilder.append(paramLong);
        QLog.d("FriendSystemMsgController", 2, localStringBuilder.toString());
      }
      this.c.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    this.b = paramBoolean;
    this.f = paramAppInterface.getCurrentAccountUin();
    ThreadManagerV2.excute(new FriendSystemMsgController.1(this, paramAppInterface, paramBoolean), 128, null, false);
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    String str = this.f;
    if ((str != null) && (!str.equals(paramAppInterface.getCurrentAccountUin()))) {
      this.b = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0).getBoolean("friend_system_msg_nomore_msg", false);
    }
    return this.b;
  }
  
  public int b(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getInt("sp_unread_friendsys_count", 0);
    }
    return 0;
  }
  
  public void b()
  {
    a = null;
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public long c()
  {
    return this.e;
  }
  
  public boolean c(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getBoolean("sp_is_sysmsg_over", false);
    }
    return false;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public long d(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    long l = 0L;
    if (paramAppInterface != null) {
      l = paramAppInterface.getLong("sp_oldest_friendmsg", 0L);
    }
    return l;
  }
  
  public void e()
  {
    HashMap localHashMap = this.c;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController
 * JD-Core Version:    0.7.0.1
 */
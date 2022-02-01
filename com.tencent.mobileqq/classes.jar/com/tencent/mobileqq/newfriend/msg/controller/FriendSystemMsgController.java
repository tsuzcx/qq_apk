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
  private static FriendSystemMsgController jdField_a_of_type_ComTencentMobileqqNewfriendMsgControllerFriendSystemMsgController;
  private long jdField_a_of_type_Long = -1L;
  private String jdField_a_of_type_JavaLangString = null;
  private HashMap<Long, structmsg.StructMsg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private long b = -1L;
  
  public static FriendSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqNewfriendMsgControllerFriendSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqNewfriendMsgControllerFriendSystemMsgController = new FriendSystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqNewfriendMsgControllerFriendSystemMsgController;
  }
  
  public int a(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getInt("sp_unread_friendsys_count", 0);
    }
    return 0;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public long a(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    long l = 0L;
    if (paramAppInterface != null) {
      l = paramAppInterface.getLong("sp_oldest_friendmsg", 0L);
    }
    return l;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      return (structmsg.StructMsg)localHashMap.get(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqNewfriendMsgControllerFriendSystemMsgController = null;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
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
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("putStructMsgToMap key=");
        localStringBuilder.append(paramLong);
        QLog.d("FriendSystemMsgController", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    ThreadManagerV2.excute(new FriendSystemMsgController.1(this, paramAppInterface, paramBoolean), 128, null, false);
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (!str.equals(paramAppInterface.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Boolean = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0).getBoolean("friend_system_msg_nomore_msg", false);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean b(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getBoolean("sp_is_sysmsg_over", false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController
 * JD-Core Version:    0.7.0.1
 */
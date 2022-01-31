package com.tencent.mobileqq.systemmsg;

import aiqs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class FriendSystemMsgController
{
  private static FriendSystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController;
  private long jdField_a_of_type_Long = -1L;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private long b = -1L;
  
  public static FriendSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController = new FriendSystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("sp_unread_friendsys_count", 0);
    }
    return i;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getLong("sp_oldest_friendmsg", 0L);
    }
    return l;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      localStructMsg = (structmsg.StructMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqSystemmsgFriendSystemMsgController = null;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putInt("sp_unread_friendsys_count", paramInt).commit();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putLong("sp_oldest_friendmsg", paramLong).commit();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putBoolean("sp_is_sysmsg_over", paramBoolean).commit();
    }
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendSystemMsgController", 2, "putStructMsgToMap key=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface.a(new aiqs(this, paramQQAppInterface, paramBoolean));
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Boolean = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("friend_system_msg_nomore_msg", false);
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      bool = paramQQAppInterface.getBoolean("sp_is_sysmsg_over", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.FriendSystemMsgController
 * JD-Core Version:    0.7.0.1
 */
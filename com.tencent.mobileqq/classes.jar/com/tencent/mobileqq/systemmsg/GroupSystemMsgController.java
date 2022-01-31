package com.tencent.mobileqq.systemmsg;

import aily;
import ailz;
import aima;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class GroupSystemMsgController
{
  private static GroupSystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = GroupSystemMsgController.class.getName();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public static GroupSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController == null) {
      jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController = new GroupSystemMsgController();
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController;
  }
  
  private int b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_Group_system_msg", 0);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = b(paramQQAppInterface);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getString("group_display", "");
    }
    return "";
  }
  
  public structmsg.StructMsg a()
  {
    return this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
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
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
    jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController = null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    long l = 0L;
    try
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1))) {
        l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1))).longValue();
      }
      if (l >= paramLong2) {
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "addSystemMsgOldData " + paramLong1 + " " + paramLong2);
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (paramQQAppInterface == null) {
        return;
      }
    }
    finally {}
    GroupSystemMsgOldData localGroupSystemMsgOldData = new GroupSystemMsgOldData();
    localGroupSystemMsgOldData.uin = paramLong1;
    localGroupSystemMsgOldData.msgtime = paramLong2;
    paramQQAppInterface.b(localGroupSystemMsgOldData);
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a(GroupSystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GroupSystemMsgOldData localGroupSystemMsgOldData = (GroupSystemMsgOldData)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localGroupSystemMsgOldData.uin), Long.valueOf(localGroupSystemMsgOldData.msgtime));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initSystemMsgOldData " + localGroupSystemMsgOldData.uin + " " + localGroupSystemMsgOldData.msgtime);
        }
      }
    }
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramQQAppInterface.a(new aily(this, paramQQAppInterface, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new ailz(this, paramQQAppInterface, paramString));
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "putStructMsgToMap key=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface.a(new aima(this, paramQQAppInterface, paramBoolean));
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Boolean = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("group_system_msg_nomore_msg", false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController
 * JD-Core Version:    0.7.0.1
 */
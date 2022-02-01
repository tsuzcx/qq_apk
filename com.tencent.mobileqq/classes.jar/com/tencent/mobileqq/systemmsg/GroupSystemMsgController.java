package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class GroupSystemMsgController
{
  private static volatile GroupSystemMsgController jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController;
  private static final String jdField_b_of_type_JavaLangString = "com.tencent.mobileqq.systemmsg.GroupSystemMsgController";
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private BaseMessageHandler jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private HashMap<String, structmsg.StructMsg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private HashMap<Long, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  private String d = null;
  
  public static GroupSystemMsgController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController == null) {
          jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController = new GroupSystemMsgController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController;
  }
  
  private int c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = BaseApplication.getContext().getSharedPreferences(paramAppRuntime.getAccount(), 0);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getInt("unread_Group_system_msg", 0);
    }
    return 0;
  }
  
  private int d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getApp().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getInt("unread_Group_suspicious_msg", 0);
    }
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = c(paramAppRuntime);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getApp().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getString("group_display", "");
    }
    return "";
  }
  
  public structmsg.StructMsg a()
  {
    return this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  }
  
  public structmsg.StructMsg a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      return (structmsg.StructMsg)localHashMap.get(paramString);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler = null;
    try
    {
      jdField_a_of_type_ComTencentMobileqqSystemmsgGroupSystemMsgController = null;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, AppRuntime paramAppRuntime)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
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
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addSystemMsgOldData ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramLong2);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
      if (paramAppRuntime == null) {
        return;
      }
      Object localObject2 = new GroupSystemMsgOldData();
      ((GroupSystemMsgOldData)localObject2).uin = paramLong1;
      ((GroupSystemMsgOldData)localObject2).msgtime = paramLong2;
      paramAppRuntime.persistOrReplace((Entity)localObject2);
      paramAppRuntime.close();
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    ThreadManagerV2.excute(new GroupSystemMsgController.1(this, paramAppInterface, paramInt), 128, null, false);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    ThreadManagerV2.excute(new GroupSystemMsgController.3(this, paramAppInterface, paramString), 128, null, false);
  }
  
  public void a(EntityManager paramEntityManager)
  {
    if (paramEntityManager == null) {
      return;
    }
    Object localObject = paramEntityManager.query(GroupSystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GroupSystemMsgOldData localGroupSystemMsgOldData = (GroupSystemMsgOldData)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localGroupSystemMsgOldData.uin), Long.valueOf(localGroupSystemMsgOldData.msgtime));
        if (QLog.isColorLevel())
        {
          String str = jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initSystemMsgOldData ");
          localStringBuilder.append(localGroupSystemMsgOldData.uin);
          localStringBuilder.append(" ");
          localStringBuilder.append(localGroupSystemMsgOldData.msgtime);
          QLog.i(str, 2, localStringBuilder.toString());
        }
      }
    }
    paramEntityManager.close();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("putStructMsgToMap key=");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramStructMsg);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
  }
  
  public void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.d = paramAppInterface.getCurrentAccountUin();
    ThreadManagerV2.excute(new GroupSystemMsgController.4(this, paramAppInterface, paramBoolean), 128, null, false);
  }
  
  public int b(AppRuntime paramAppRuntime)
  {
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_b_of_type_Int = d(paramAppRuntime);
    }
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void b(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    ThreadManagerV2.excute(new GroupSystemMsgController.2(this, paramAppInterface, paramInt), 128, null, false);
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController
 * JD-Core Version:    0.7.0.1
 */
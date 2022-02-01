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
  private static final String b = "com.tencent.mobileqq.systemmsg.GroupSystemMsgController";
  private static volatile GroupSystemMsgController c;
  public String a;
  private boolean d = false;
  private BaseMessageHandler e = null;
  private int f = -1;
  private int g = -1;
  private boolean h = false;
  private HashMap<String, structmsg.StructMsg> i = new HashMap();
  private structmsg.StructMsg j = null;
  private String k;
  private long l = -1L;
  private String m = null;
  private Object n = new Object();
  private HashMap<Long, Long> o = new HashMap();
  
  public static GroupSystemMsgController a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new GroupSystemMsgController();
        }
      }
      finally {}
    }
    return c;
  }
  
  private int d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = BaseApplication.getContext().getSharedPreferences(paramAppRuntime.getAccount(), 0);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getInt("unread_Group_system_msg", 0);
    }
    return 0;
  }
  
  private int e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getApp().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getInt("unread_Group_suspicious_msg", 0);
    }
    return 0;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getApp().getSharedPreferences(paramAppRuntime.getCurrentAccountUin(), 0);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getString("group_display", "");
    }
    return "";
  }
  
  public void a(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, AppRuntime paramAppRuntime)
  {
    Object localObject1 = this.n;
    long l1 = 0L;
    try
    {
      if (this.o.containsKey(Long.valueOf(paramLong1))) {
        l1 = ((Long)this.o.get(Long.valueOf(paramLong1))).longValue();
      }
      if (l1 >= paramLong2) {
        return;
      }
      this.o.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel())
      {
        localObject2 = b;
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
    this.f = paramInt;
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
        this.o.put(Long.valueOf(localGroupSystemMsgOldData.uin), Long.valueOf(localGroupSystemMsgOldData.msgtime));
        if (QLog.isColorLevel())
        {
          String str = b;
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
    this.a = paramString;
  }
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg)
  {
    if (this.i != null)
    {
      if (QLog.isColorLevel())
      {
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("putStructMsgToMap key=");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.i.put(paramString, paramStructMsg);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    this.j = paramStructMsg;
  }
  
  public void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    this.h = paramBoolean;
    this.m = paramAppInterface.getCurrentAccountUin();
    ThreadManagerV2.excute(new GroupSystemMsgController.4(this, paramAppInterface, paramBoolean), 128, null, false);
  }
  
  public int b(AppRuntime paramAppRuntime)
  {
    if (this.f == -1) {
      this.f = d(paramAppRuntime);
    }
    return this.f;
  }
  
  public structmsg.StructMsg b(String paramString)
  {
    HashMap localHashMap = this.i;
    if (localHashMap != null) {
      return (structmsg.StructMsg)localHashMap.get(paramString);
    }
    return null;
  }
  
  public void b()
  {
    this.f = -1;
    this.e = null;
    try
    {
      c = null;
      return;
    }
    finally {}
  }
  
  public void b(AppInterface paramAppInterface, int paramInt)
  {
    this.g = paramInt;
    ThreadManagerV2.excute(new GroupSystemMsgController.2(this, paramAppInterface, paramInt), 128, null, false);
  }
  
  public int c(AppRuntime paramAppRuntime)
  {
    if (this.g == -1) {
      this.g = e(paramAppRuntime);
    }
    return this.g;
  }
  
  public long c()
  {
    return this.l;
  }
  
  public void c(String paramString)
  {
    this.k = paramString;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public structmsg.StructMsg e()
  {
    return this.j;
  }
  
  public String f()
  {
    return this.k;
  }
  
  public void g()
  {
    HashMap localHashMap = this.i;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController
 * JD-Core Version:    0.7.0.1
 */
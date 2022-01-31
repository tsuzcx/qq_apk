package com.tencent.mobileqq.now.enter;

import afnf;
import afng;
import afnh;
import afni;
import afnj;
import afnk;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.format.DateFormat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class NowHongbaoPushManager
  implements Manager
{
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap c = new HashMap(5);
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 1000L;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afnf(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public NowEnterManager a;
  private volatile NowHongbaoPushManager.Callback jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Callback;
  private NowHongbaoPushManager.Entity jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    c.put(Integer.valueOf(1), "push为空");
    c.put(Integer.valueOf(2), "push show状态为关闭");
    c.put(Integer.valueOf(3), "push没到达开启时间");
    c.put(Integer.valueOf(4), "push过期");
    c.put(Integer.valueOf(5), "本地开关关闭");
    c.put(Integer.valueOf(6), "resume");
  }
  
  public NowHongbaoPushManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager = ((NowEnterManager)paramQQAppInterface.getManager(264));
    e();
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "checkAndNotify-----------------------------------------------------------------");
    }
    int i = 0;
    int j;
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      HashMap localHashMap2 = a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a());
      j = 1;
      if (j < 4)
      {
        NowHongbaoPushManager.Entity localEntity = (NowHongbaoPushManager.Entity)localHashMap2.get(Integer.valueOf(j));
        if (localEntity != null)
        {
          if (localEntity.isShowState())
          {
            if (localEntity.inShowTimeRange())
            {
              i += 1;
              if (localEntity.type == 1)
              {
                a(localEntity);
              }
              else if (a())
              {
                a(localEntity);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.i("NowHongbaoPushManager", 2, "checkAndNotify--" + (String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localEntity.type)) + " 本应该显示，但本地开关关闭了，所以不显示");
                }
                a(localEntity, 5);
              }
            }
            else if (localEntity.isTimeOut())
            {
              a(localEntity, 4);
            }
            else
            {
              a(localEntity, 3);
              i += 1;
            }
          }
          else {
            a(localEntity, 2);
          }
        }
        else if (j == 2)
        {
          a(2, 1);
        }
        else
        {
          if (j != 3) {
            break label267;
          }
          a(3, 1);
          break label267;
        }
      }
      else
      {
        return i;
      }
    }
    label267:
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private NowHongbaoPushManager.Entity a(int paramInt)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a(), paramInt);
  }
  
  private NowHongbaoPushManager.Entity a(long paramLong, int paramInt)
  {
    return (NowHongbaoPushManager.Entity)a(paramLong).get(Integer.valueOf(paramInt));
  }
  
  private NowHongbaoPushManager.Entity a(NowHongbaoPushManager.Entity paramEntity, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    NowHongbaoPushManager.Entity localEntity = paramEntity;
    if (paramEntity == null) {
      localEntity = new NowHongbaoPushManager.Entity();
    }
    localEntity.type = paramInt1;
    localEntity.setState(paramInt2);
    localEntity.startTime = paramLong1;
    localEntity.endTime = paramLong2;
    localEntity.version = paramLong4;
    localEntity.taskId = paramLong3;
    return localEntity;
  }
  
  public static String a(long paramLong)
  {
    return DateFormat.format("yyyy-MM-dd HH:mm:ss", 1000L * paramLong).toString();
  }
  
  private HashMap a(long paramLong)
  {
    HashMap localHashMap2 = (HashMap)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localHashMap1);
    }
    return localHashMap1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new afni(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    if (!a(paramInt1, paramInt2, paramLong1, paramLong2)) {
      return;
    }
    label365:
    for (;;)
    {
      NowHongbaoPushManager.Entity localEntity;
      synchronized (this.jdField_b_of_type_JavaUtilHashMap)
      {
        HashMap localHashMap1 = (HashMap)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong4));
        if (localHashMap1 != null) {
          break label365;
        }
        localHashMap1 = new HashMap();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong4), localHashMap1);
        localEntity = (NowHongbaoPushManager.Entity)localHashMap1.get(Integer.valueOf(paramInt1));
        if (localEntity == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NowHongbaoPushManager", 2, "handleLatestPush 新加 push type=" + paramInt1 + ", show=" + paramInt2 + ", startTime=" + a(paramLong1) + ", endTime=" + a(paramLong2) + ", version =" + paramLong4);
          }
          localHashMap1.put(Integer.valueOf(paramInt1), a(localEntity, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4));
          f();
          if (paramLong4 != this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a()) {
            break;
          }
          k();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NowHongbaoPushManager", 2, "handleLatestPush 更新 origin---" + localEntity.toString() + "\r\n NEW---type=" + paramInt1 + ", show=" + paramInt2 + ", startTime=" + a(paramLong1) + ", endTime=" + a(paramLong2) + ", version =" + paramLong4);
        }
        if (paramBoolean) {
          a(localEntity, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4);
        }
      }
      if (localEntity.taskId <= paramLong3) {
        a(localEntity, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4);
      }
    }
  }
  
  private void a(NowHongbaoPushManager.Entity paramEntity)
  {
    ThreadManager.getUIHandler().post(new afnj(this, paramEntity));
  }
  
  private void a(NowHongbaoPushManager.Entity paramEntity, int paramInt)
  {
    ThreadManager.getUIHandler().post(new afnh(this, paramEntity, paramInt));
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Int != -1) {
      return this.jdField_a_of_type_Int == 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.e()) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_Int == 1) {
        break;
      }
      return false;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    int i;
    if (paramInt1 == 1) {
      if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (paramLong2 >= paramLong1)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        paramInt2 = 1;
        label40:
        if ((paramInt1 != 1) && (paramInt1 != 3) && (paramInt1 != 2)) {
          break label83;
        }
      }
      label83:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((i == 0) || (paramInt2 == 0) || (paramInt1 == 0)) {
          break label88;
        }
        return true;
        i = 0;
        break;
        paramInt2 = 0;
        break label40;
      }
      label88:
      return false;
      i = 1;
    }
  }
  
  private boolean a(NowHongbaoPushManager.Entity paramEntity)
  {
    return a(paramEntity.type, NowHongbaoPushManager.Entity.access$600(paramEntity), paramEntity.startTime, paramEntity.endTime);
  }
  
  private boolean a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if ((paramNowPushMsg.uint32_version.get() == 0L) && (paramNowPushMsg.uint64_start_time.get() == 0L) && (paramNowPushMsg.uint64_end_time.get() == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, "发送wns日志请求");
      }
      paramNowPushMsg = (NowProxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      if (paramNowPushMsg != null) {
        paramNowPushMsg.c();
      }
      return true;
    }
    return false;
  }
  
  private long b()
  {
    long l1 = 9223372036854775L;
    long l3 = a();
    Object localObject1 = null;
    boolean bool = true;
    label227:
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a()).values().iterator();
        if (localIterator.hasNext())
        {
          NowHongbaoPushManager.Entity localEntity = (NowHongbaoPushManager.Entity)localIterator.next();
          if (localEntity.isShowState())
          {
            long l2;
            if (localEntity.startTime >= l3)
            {
              l2 = localEntity.startTime - l3;
              if (l2 >= l1) {
                break label227;
              }
              localObject1 = localEntity;
              l1 = l2;
              break label227;
            }
            if (localEntity.endTime >= l3)
            {
              l2 = localEntity.endTime - l3;
              if (l2 < l1)
              {
                l1 = l2;
                bool = false;
                localObject1 = localEntity;
                break label227;
              }
            }
          }
        }
        else
        {
          if ((localObject1 != null) && (QLog.isColorLevel())) {
            QLog.i("NowHongbaoPushManager", 2, "findTimeGapLeastPush " + localObject1.toString() + ",useST =" + bool + ",difftime =" + l1);
          }
          return l1;
        }
      }
    }
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a();
    ArrayList localArrayList = new ArrayList();
    Long localLong;
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      localIterator = this.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localLong = (Long)((Map.Entry)localIterator.next()).getKey();
        if (localLong.longValue() < i) {
          localArrayList.add(localLong);
        }
      }
    }
    Iterator localIterator = localObject.iterator();
    while (localIterator.hasNext())
    {
      localLong = (Long)localIterator.next();
      this.jdField_b_of_type_JavaUtilHashMap.remove(localLong);
    }
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "deleteOldPushes toRemove =" + localObject.toString());
    }
    return !localObject.isEmpty();
  }
  
  private boolean b(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    int i = ((NowEnterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
    if (paramNowPushMsg.uint32_version.get() >= i) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.i("NowHongbaoPushManager", 2, "isVersionBigger false getConfigVersion =" + i + ", pushVersion =" + paramNowPushMsg.uint32_version.get());
      }
      return bool;
    }
  }
  
  private long c()
  {
    if (this.jdField_b_of_type_Int <= 5) {
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, "caculateDelayTime retryCount = " + this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      long l;
      synchronized (this.jdField_b_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a()).values().iterator();
        if (!localIterator.hasNext()) {
          break label225;
        }
        NowHongbaoPushManager.Entity localEntity = (NowHongbaoPushManager.Entity)localIterator.next();
        if (localEntity.isNotified()) {
          continue;
        }
        i = 0;
        if (i == 0)
        {
          this.jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel()) {
            QLog.i("NowHongbaoPushManager", 2, "caculateDelayTime 计时器采用重试时间 1000,retryCount = " + this.jdField_b_of_type_Int + ", retryPush = " + localEntity.toString());
          }
          return 1000L;
        }
        this.jdField_b_of_type_Int = 0;
        l = b();
        if (l >= 1200L) {
          return 600000L;
        }
      }
      if (l >= 300L) {
        return 60000L;
      }
      return 1000L;
      label225:
      Object localObject2 = null;
      int i = 1;
    }
  }
  
  private void c(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if (a(paramNowPushMsg)) {}
    label120:
    do
    {
      do
      {
        do
        {
          return;
          if (paramNowPushMsg.uint32_type.get() != 1) {
            break label120;
          }
          if (paramNowPushMsg.uint32_switch.get() != 1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("NowHongbaoPushManager", 2, "checkAndHandlPush fail, 活动入口 show push，丢弃");
        return;
        if (b(paramNowPushMsg))
        {
          a(paramNowPushMsg.uint32_type.get(), paramNowPushMsg.uint32_switch.get(), paramNowPushMsg.uint64_start_time.get(), paramNowPushMsg.uint64_end_time.get(), paramNowPushMsg.uint32_task_id.get(), paramNowPushMsg.uint32_version.get(), true);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("NowHongbaoPushManager", 2, "checkAndHandlPush fail, version not match，丢弃这个push");
      return;
      if (b(paramNowPushMsg))
      {
        a(paramNowPushMsg.uint32_type.get(), paramNowPushMsg.uint32_switch.get(), paramNowPushMsg.uint64_start_time.get(), paramNowPushMsg.uint64_end_time.get(), paramNowPushMsg.uint32_task_id.get(), paramNowPushMsg.uint32_version.get(), false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NowHongbaoPushManager", 2, "checkAndHandlPush fail, version not match，丢弃这个push");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    a();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "saveToLocalFile");
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "NowPushInfo", this.jdField_b_of_type_JavaUtilHashMap);
      return;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "closeTimer");
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(17);
    }
  }
  
  private void h()
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a()).values().iterator();
      if (localIterator.hasNext()) {
        ((NowHongbaoPushManager.Entity)localIterator.next()).resetNotifyState();
      }
    }
  }
  
  private void i()
  {
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity == null)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      l = a();
      if (!((SharedPreferences)???).getBoolean("isActiveEnable" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false)) {
        break label425;
      }
    }
    label425:
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity = a(null, 1, i, ((SharedPreferences)???).getLong("activeStartTime" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), -1L), ((SharedPreferences)???).getLong("activeEndTime" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), -1L), l, ((SharedPreferences)???).getInt("version" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0));
      boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity);
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, "readCommonConfig " + this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.toString() + ",isValid =" + bool);
      }
      for (;;)
      {
        synchronized (this.jdField_b_of_type_JavaUtilHashMap)
        {
          HashMap localHashMap = a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a());
          NowHongbaoPushManager.Entity localEntity = (NowHongbaoPushManager.Entity)localHashMap.get(Integer.valueOf(1));
          if (localEntity != null)
          {
            if ((localEntity.isHideState()) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity.version <= localEntity.version))
            {
              if (QLog.isColorLevel()) {
                QLog.i("NowHongbaoPushManager", 2, "readCommonConfig 已存在关闭push且版本比通用配置更高或相等--- " + localEntity.toString());
              }
              return;
            }
            if (!bool) {
              continue;
            }
            localHashMap.put(Integer.valueOf(1), this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity);
          }
        }
        if (bool) {
          localObject2.put(Integer.valueOf(1), this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity);
        }
      }
    }
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("now_enter_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putBoolean("now_local_enter_switch_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), true).commit();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void k()
  {
    if (a() > 0)
    {
      l();
      return;
    }
    g();
  }
  
  private void l()
  {
    ThreadManager.getUIHandler().post(new afnk(this));
  }
  
  public long a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a();
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      NowHongbaoPushManager.Entity localEntity = a(paramInt);
      if (localEntity != null)
      {
        long l = localEntity.taskId;
        return l;
      }
    }
    return -1L;
  }
  
  public void a()
  {
    HashMap localHashMap = (HashMap)FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + "NowPushInfo");
    if (localHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap = localHashMap;
      QLog.i("NowHongbaoPushManager", 2, "readFromLocal--" + this.jdField_b_of_type_JavaUtilHashMap.values().toString());
      if (b()) {
        f();
      }
      k();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "receiveLocalPush type =" + paramInt);
    }
    if (paramBoolean) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilHashMap)
      {
        NowHongbaoPushManager.Entity localEntity = a(paramInt);
        if (localEntity == null) {
          break;
        }
        long l1 = localEntity.startTime;
        long l2 = localEntity.endTime;
        long l3 = localEntity.taskId;
        long l4 = localEntity.version;
        if (paramBoolean)
        {
          i = 1;
          a(paramInt, i, l1, l2, l3, l4, false);
          return;
        }
      }
      i = 2;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      a(paramInt, i, 0L, 0L, 1L, this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a(), true);
      break;
    }
  }
  
  public void a(NowHongbaoPushManager.Callback paramCallback)
  {
    try
    {
      Message localMessage = Message.obtain();
      localMessage.what = 18;
      localMessage.obj = paramCallback;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, 4000L);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public void a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    QLog.i("NowHongbaoPushManager", 1, "receiveOnLinePush ： type=" + paramNowPushMsg.uint32_type.get() + ", show=" + paramNowPushMsg.uint32_switch.get() + ", startTime=" + paramNowPushMsg.uint64_start_time.get() + ", endTime=" + paramNowPushMsg.uint64_end_time.get() + ",taskId =" + paramNowPushMsg.uint32_task_id.get() + ",version =" + paramNowPushMsg.uint32_version.get());
    c(paramNowPushMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity = null;
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "onConfigServerChange");
    }
    c();
  }
  
  public void b(NowHongbaoPushManager.Callback paramCallback)
  {
    try
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(18);
      a(1, 6);
      a(3, 6);
      a(2, 6);
      ThreadManager.getUIHandler().post(new afng(this));
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public void b(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    QLog.i("NowHongbaoPushManager", 1, "receiveOfflinePush ： type=" + paramNowPushMsg.uint32_type.get() + ", show=" + paramNowPushMsg.uint32_switch.get() + ", startTime=" + a(paramNowPushMsg.uint64_start_time.get()) + ", endTime=" + a(paramNowPushMsg.uint64_end_time.get()) + ",taskId =" + paramNowPushMsg.uint32_task_id.get() + ",version =" + paramNowPushMsg.uint32_version.get());
    c(paramNowPushMsg);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "resume");
    }
    h();
    i();
    k();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = 0;
    g();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowHongbaoPushManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNowEnterNowHongbaoPushManager$Entity = null;
    g();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(18);
    a(1, 6);
    a(3, 6);
    a(2, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowHongbaoPushManager
 * JD-Core Version:    0.7.0.1
 */
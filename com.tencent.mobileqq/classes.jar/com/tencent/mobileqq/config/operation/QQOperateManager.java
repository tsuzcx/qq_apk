package com.tencent.mobileqq.config.operation;

import acac;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQOperateManager
{
  private static QQOperateManager jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private CopyOnWriteArrayList jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList c = new CopyOnWriteArrayList();
  
  public static QQOperateManager a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager == null) || (!jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager.a()) || (!paramQQAppInterface.getCurrentAccountUin().equals(jdField_a_of_type_JavaLangString)))
      {
        jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager = new QQOperateManager();
        jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
        jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager.a(paramQQAppInterface);
      }
      return jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.c.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject1).getInt(jdField_a_of_type_JavaLangString + "QQOperationVoIPRequestCount", 0);
    long l = ((SharedPreferences)localObject1).getLong(jdField_a_of_type_JavaLangString + "QQOperationVoIPRequestCountTime", 0L);
    if ((this.jdField_a_of_type_Int == 0) || (l == 0L) || (!a(l)))
    {
      this.jdField_a_of_type_Int = 0;
      ((SharedPreferences)localObject1).edit().putInt(jdField_a_of_type_JavaLangString + "QQOperationVoIPRequestCount", 0).putLong(jdField_a_of_type_JavaLangString + "QQOperationVoIPRequestCountTime", System.currentTimeMillis()).commit();
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    for (;;)
    {
      Object localObject5;
      Object localObject6;
      Object localObject7;
      try
      {
        localObject1 = paramQQAppInterface.a(QQOperationViopTipTask.class, new QQOperationViopTipTask().getTableName(), false, null, null, null, null, null, null);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "init data config_task_size = " + ((List)localObject1).size());
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((ArrayList)localObject1);
          localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject5 = (QQOperationViopTipTask)((Iterator)localObject1).next();
            l = System.currentTimeMillis();
            localObject6 = ((QQOperationViopTipTask)localObject5).getEndDate();
            localObject7 = ((QQOperationViopTipTask)localObject5).getBeginDate();
            if (((localObject6 == null) || (l <= ((Date)localObject6).getTime())) && ((localObject7 == null) || (l >= ((Date)localObject7).getTime()))) {
              continue;
            }
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject5);
            if ((localObject6 == null) || (l <= ((Date)localObject6).getTime())) {
              continue;
            }
            paramQQAppInterface.b((Entity)localObject5);
            continue;
          }
        }
        Object localObject2;
        if (!QLog.isDevelopLevel()) {
          break label666;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        localObject2 = paramQQAppInterface.a(QQOperationTaskRecord.class, new QQOperationTaskRecord().getTableName(), false, null, null, null, null, null, null);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((ArrayList)localObject2);
          localObject2 = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject5 = (QQOperationTaskRecord)((Iterator)localObject2).next();
            localObject6 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            if (!((Iterator)localObject6).hasNext()) {
              break label1229;
            }
            localObject7 = (QQOperationViopTipTask)((Iterator)localObject6).next();
            if (((QQOperationTaskRecord)localObject5).taskid != ((QQOperationViopTipTask)localObject7).taskid) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject5);
              paramQQAppInterface.b((Entity)localObject5);
            }
            if (a(((QQOperationTaskRecord)localObject5).recordTime)) {
              continue;
            }
            ((QQOperationTaskRecord)localObject5).hasShowedUins = "";
            ((QQOperationTaskRecord)localObject5).recordTime = System.currentTimeMillis();
            paramQQAppInterface.b((Entity)localObject5);
            continue;
          }
        }
      }
      finally
      {
        paramQQAppInterface.a();
      }
      QLog.d("QQOperateVoIP", 4, "init data task_record_size = " + this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      label666:
      Object localObject4 = paramQQAppInterface.a(QQOperationVoipTipsTaskExcuteRecord.class, new QQOperationVoipTipsTaskExcuteRecord().getTableName(), false, null, null, null, null, null, null);
      if ((localObject4 != null) && (((List)localObject4).size() > 0))
      {
        this.c.addAll((ArrayList)localObject4);
        localObject4 = this.c.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (QQOperationVoipTipsTaskExcuteRecord)((Iterator)localObject4).next();
          if (!a(((QQOperationVoipTipsTaskExcuteRecord)localObject5).time))
          {
            this.c.remove(localObject5);
            paramQQAppInterface.b((Entity)localObject5);
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "init data task_excuted_record_size = " + this.c.size());
      }
      localObject4 = this.c.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (QQOperationVoipTipsTaskExcuteRecord)((Iterator)localObject4).next();
        if (((QQOperationVoipTipsTaskExcuteRecord)localObject5).taskid != -1)
        {
          localObject5 = a(((QQOperationVoipTipsTaskExcuteRecord)localObject5).taskid);
          if (localObject5 != null) {
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "init data net_task_show_size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
          }
        }
        else
        {
          localObject6 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          do
          {
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject7 = (QQOperateTipNativeShowInfo)((Iterator)localObject6).next();
          } while ((((QQOperateTipNativeShowInfo)localObject7).b != ((QQOperationVoipTipsTaskExcuteRecord)localObject5).uinType) || (((QQOperateTipNativeShowInfo)localObject7).jdField_a_of_type_Int != ((QQOperationVoipTipsTaskExcuteRecord)localObject5).tipType));
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject6 = new QQOperateTipNativeShowInfo();
          ((QQOperateTipNativeShowInfo)localObject6).b = ((QQOperationVoipTipsTaskExcuteRecord)localObject5).uinType;
          ((QQOperateTipNativeShowInfo)localObject6).jdField_a_of_type_Int = ((QQOperationVoipTipsTaskExcuteRecord)localObject5).tipType;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject6);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("QQOperateVoIP", 4, "init data native_task_show_size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        break;
        if (QLog.isDevelopLevel())
        {
          QLog.d("QQOperateVoIP", 4, "do Init tipsTask :" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
          QLog.d("QQOperateVoIP", 4, "do Init taskRecord :" + this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
          QLog.d("QQOperateVoIP", 4, "do Init excuteRecord :" + this.c);
          QLog.d("QQOperateVoIP", 4, "do Init netShowList :" + this.jdField_b_of_type_JavaUtilArrayList);
          QLog.d("QQOperateVoIP", 4, "do Init nativeShowList :" + this.jdField_a_of_type_JavaUtilArrayList);
        }
        paramQQAppInterface.a();
        return;
      }
      label1229:
      i = 0;
    }
  }
  
  public static boolean a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    localCalendar1.setTimeInMillis(paramLong);
    return localCalendar2.get(5) == localCalendar1.get(5);
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager == null) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager.a();
    jdField_a_of_type_ComTencentMobileqqConfigOperationQQOperateManager = null;
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((QQOperationVoipTipsTaskExcuteRecord)localIterator.next()).taskid != paramInt) {
        break label44;
      }
      i += 1;
    }
    label44:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public int a(int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localIterator.next();
      if ((localQQOperationVoipTipsTaskExcuteRecord.taskid == paramInt1) && (localQQOperationVoipTipsTaskExcuteRecord.uin.equals(paramString)) && (localQQOperationVoipTipsTaskExcuteRecord.uinType == paramInt2)) {
        return localQQOperationVoipTipsTaskExcuteRecord.count + 0;
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, QQOperationViopTipTask paramQQOperationViopTipTask, QQAppInterface paramQQAppInterface, List paramList)
  {
    if (paramList == null)
    {
      paramInt = 0;
      return paramInt;
    }
    if (paramList.size() == 1) {
      return 0;
    }
    long l1 = MessageCache.a();
    long l2 = paramQQOperationViopTipTask.frequencyTime * 60 * 1000;
    int n = paramQQOperationViopTipTask.frequencyMessage;
    l1 = (l1 * 1000L - l2) / 1000L;
    int k = paramList.size();
    paramInt = 0;
    int i = 0;
    int j = 0;
    k -= 1;
    label85:
    int m;
    if (k >= 0)
    {
      paramString = (ChatMessage)paramList.get(k);
      if (paramString.time >= l1)
      {
        if ((!MsgProxyUtils.n(paramString.msgtype)) || (paramString.extraflag != 0)) {
          break label221;
        }
        if (!paramString.isSend())
        {
          m = 1;
          i = j;
          j = m;
          label148:
          m = paramInt + 1;
          paramInt = i;
          i = j;
          j = paramInt;
          paramInt = m;
        }
      }
    }
    label221:
    for (;;)
    {
      k -= 1;
      break label85;
      m = 1;
      j = i;
      i = m;
      break label148;
      if ((paramInt >= n) && (i != 0) && (j != 0)) {}
      for (i = 1; i == 0; i = 0) {
        return 0;
      }
      break;
    }
  }
  
  public QQOperationRequestInfo a(String paramString, int paramInt1, QQAppInterface paramQQAppInterface, List paramList, boolean paramBoolean, int paramInt2)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        long l = System.currentTimeMillis();
        ArrayList localArrayList = new ArrayList();
        boolean bool = a(paramString, paramInt1, 1, paramQQAppInterface, paramList, localArrayList, paramBoolean, paramInt2);
        paramBoolean = a(paramString, paramInt1, 2, paramQQAppInterface, paramList, localArrayList, paramBoolean, paramInt2);
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, "voip_request_panduan_time = " + (System.currentTimeMillis() - l));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQOperateVoIP", 2, "voip_request_isNeed  blue = " + bool + " gray = " + paramBoolean);
        }
        paramString = new QQOperationRequestInfo();
        if (bool) {
          break label271;
        }
        if (paramBoolean)
        {
          break label271;
          paramString.jdField_a_of_type_Boolean = paramBoolean;
          paramString.jdField_a_of_type_JavaUtilArrayList = localArrayList;
          if (!QLog.isDevelopLevel()) {
            break label249;
          }
          paramQQAppInterface = localArrayList.iterator();
          if (!paramQQAppInterface.hasNext()) {
            break label249;
          }
          paramList = (QQOperationRequestTaskInfo)paramQQAppInterface.next();
          QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..request taskid = .... " + paramList.jdField_a_of_type_Int);
        }
      }
      paramBoolean = false;
      continue;
      label249:
      if (paramString.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Int += 1;
      }
      return paramString;
      label271:
      paramBoolean = true;
    }
  }
  
  public QQOperationTaskRecord a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationTaskRecord localQQOperationTaskRecord = (QQOperationTaskRecord)localIterator.next();
      if (paramInt == localQQOperationTaskRecord.taskid) {
        return localQQOperationTaskRecord;
      }
    }
    return null;
  }
  
  public QQOperationViopTipTask a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if (localQQOperationViopTipTask.taskid == paramInt) {
        return localQQOperationViopTipTask;
      }
    }
    return null;
  }
  
  public QQOperationViopTipTask a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((paramInt1 == localQQOperationViopTipTask.uinType) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        return localQQOperationViopTipTask;
      }
    }
    return null;
  }
  
  public QQOperationVoipTipsTaskExcuteRecord a(QQOperationVoipTipsTaskExcuteRecord paramQQOperationVoipTipsTaskExcuteRecord)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localIterator.next();
      if ((localQQOperationVoipTipsTaskExcuteRecord != null) && (localQQOperationVoipTipsTaskExcuteRecord.taskid == paramQQOperationVoipTipsTaskExcuteRecord.taskid) && (localQQOperationVoipTipsTaskExcuteRecord.tipType == paramQQOperationVoipTipsTaskExcuteRecord.tipType) && (localQQOperationVoipTipsTaskExcuteRecord.uin != null) && (localQQOperationVoipTipsTaskExcuteRecord.uin.equals(paramQQOperationVoipTipsTaskExcuteRecord.uin)) && (localQQOperationVoipTipsTaskExcuteRecord.uinType == paramQQOperationVoipTipsTaskExcuteRecord.uinType)) {
        return localQQOperationVoipTipsTaskExcuteRecord;
      }
    }
    return null;
  }
  
  public ArrayList a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((localQQOperationViopTipTask.uinType == paramInt1) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        localArrayList.add(localQQOperationViopTipTask);
      }
    }
    return localArrayList;
  }
  
  public ArrayList a(String paramString, int paramInt, QQOperationViopTipTask paramQQOperationViopTipTask, QQAppInterface paramQQAppInterface, List paramList)
  {
    paramString = paramQQOperationViopTipTask.getKeywordList();
    paramQQOperationViopTipTask = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramQQAppInterface = paramList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramList = (ChatMessage)paramQQAppInterface.next();
        if ((paramList.msgtype == -1000) && (!TextUtils.isEmpty(paramList.msg)))
        {
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!TextUtils.isEmpty(str)) && (paramList.msg.contains(str)) && (!paramQQOperationViopTipTask.contains(str))) {
              paramQQOperationViopTipTask.add(str);
            }
          }
        }
      }
    }
    return paramQQOperationViopTipTask;
  }
  
  public void a()
  {
    ThreadManager.post(new acac(this, this.jdField_a_of_type_Int), 8, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
    localQQOperationVoipTipsTaskExcuteRecord.taskid = -1;
    localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt1;
    localQQOperationVoipTipsTaskExcuteRecord.tipType = paramInt2;
    localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
    localQQOperationVoipTipsTaskExcuteRecord.uin = "0";
    a(paramQQAppInterface, localQQOperationVoipTipsTaskExcuteRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQOperationVoipTipsTaskExcuteRecord paramQQOperationVoipTipsTaskExcuteRecord)
  {
    int i = 1;
    if (paramQQOperationVoipTipsTaskExcuteRecord == null) {
      return;
    }
    Object localObject1;
    EntityManager localEntityManager;
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = a(paramQQOperationVoipTipsTaskExcuteRecord);
        if (localObject1 == null)
        {
          this.c.add(paramQQOperationVoipTipsTaskExcuteRecord);
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "addVoipTipTaskExcuteRecord record.taskid = " + paramQQOperationVoipTipsTaskExcuteRecord.taskid + " TodayRecord : " + this.c);
          }
          localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (paramQQOperationVoipTipsTaskExcuteRecord.taskid != -1) {
            break;
          }
          paramQQAppInterface = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!paramQQAppInterface.hasNext()) {
            break label720;
          }
          localObject1 = (QQOperateTipNativeShowInfo)paramQQAppInterface.next();
          if ((((QQOperateTipNativeShowInfo)localObject1).b != paramQQOperationVoipTipsTaskExcuteRecord.uinType) || (((QQOperateTipNativeShowInfo)localObject1).jdField_a_of_type_Int != paramQQOperationVoipTipsTaskExcuteRecord.tipType)) {
            continue;
          }
          if (i == 0)
          {
            paramQQAppInterface = new QQOperateTipNativeShowInfo();
            paramQQAppInterface.b = paramQQOperationVoipTipsTaskExcuteRecord.uinType;
            paramQQAppInterface.jdField_a_of_type_Int = paramQQOperationVoipTipsTaskExcuteRecord.tipType;
            this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "Update TodayNativeShow :" + this.jdField_a_of_type_JavaUtilArrayList);
          }
          label225:
          paramQQOperationVoipTipsTaskExcuteRecord.setStatus(1000);
          localEntityManager.b(paramQQOperationVoipTipsTaskExcuteRecord);
          localEntityManager.a();
          return;
        }
      }
      ((QQOperationVoipTipsTaskExcuteRecord)localObject1).count += 1;
      paramQQOperationVoipTipsTaskExcuteRecord = (QQOperationVoipTipsTaskExcuteRecord)localObject1;
    }
    paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    label309:
    Iterator localIterator;
    while (paramQQAppInterface.hasNext()) {
      if (((QQOperationViopTipTask)paramQQAppInterface.next()).taskid == paramQQOperationVoipTipsTaskExcuteRecord.taskid)
      {
        i = 1;
        if (i == 0)
        {
          paramQQAppInterface = a(paramQQOperationVoipTipsTaskExcuteRecord.taskid);
          this.jdField_b_of_type_JavaUtilArrayList.add(paramQQAppInterface);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, "Update TodayNetShow :" + this.jdField_b_of_type_JavaUtilArrayList);
        }
        paramQQAppInterface = null;
        localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      }
    }
    label720:
    label725:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (QQOperationTaskRecord)localIterator.next();
        if (((QQOperationTaskRecord)localObject1).taskid == paramQQOperationVoipTipsTaskExcuteRecord.taskid)
        {
          ((QQOperationTaskRecord)localObject1).addUinShowCount(paramQQOperationVoipTipsTaskExcuteRecord.uin);
          if (!((QQOperationTaskRecord)localObject1).hasShowedUins.contains(paramQQOperationVoipTipsTaskExcuteRecord.uin + "_" + paramQQOperationVoipTipsTaskExcuteRecord.uinType))
          {
            ((QQOperationTaskRecord)localObject1).hasShowedUins = (((QQOperationTaskRecord)localObject1).hasShowedUins + paramQQOperationVoipTipsTaskExcuteRecord.uin + "_" + paramQQOperationVoipTipsTaskExcuteRecord.uinType + "|");
            ((QQOperationTaskRecord)localObject1).aioCount += 1;
          }
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (!QLog.isDevelopLevel()) {
            break label725;
          }
          QLog.d("QQOperateVoIP", 4, "QQOperationTaskRecord record.taskid = " + ((QQOperationTaskRecord)localObject1).taskid + " existTaskRecord.showCount = " + ((QQOperationTaskRecord)localObject1).showCount + " existTaskRecord.aioCount = " + ((QQOperationTaskRecord)localObject1).aioCount);
          paramQQAppInterface = (QQAppInterface)localObject1;
          break label725;
        }
      }
      else
      {
        localObject1 = paramQQAppInterface;
        if (paramQQAppInterface == null)
        {
          localObject1 = new QQOperationTaskRecord();
          ((QQOperationTaskRecord)localObject1).taskid = paramQQOperationVoipTipsTaskExcuteRecord.taskid;
          ((QQOperationTaskRecord)localObject1).aioCount = 1;
          ((QQOperationTaskRecord)localObject1).addUinShowCount(paramQQOperationVoipTipsTaskExcuteRecord.uin);
          ((QQOperationTaskRecord)localObject1).recordTime = System.currentTimeMillis();
          ((QQOperationTaskRecord)localObject1).hasShowedUins = (paramQQOperationVoipTipsTaskExcuteRecord.uin + "_" + paramQQOperationVoipTipsTaskExcuteRecord.uinType + "|");
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject1);
        }
        ((QQOperationTaskRecord)localObject1).setStatus(1000);
        localEntityManager.b((Entity)localObject1);
        break label225;
      }
      break label725;
      i = 0;
      break label309;
      i = 0;
      break;
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: invokestatic 172	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 174
    //   8: iconst_4
    //   9: new 96	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 455
    //   19: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_2
    //   23: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_2
    //   33: ifnull +10 -> 43
    //   36: aload_2
    //   37: invokevirtual 264	java/util/ArrayList:size	()I
    //   40: ifne +4 -> 44
    //   43: return
    //   44: aload_1
    //   45: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   48: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 458	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 461	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   61: aload_3
    //   62: ldc 152
    //   64: invokevirtual 464	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   67: pop
    //   68: aload_2
    //   69: invokevirtual 265	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   72: astore 4
    //   74: aload 4
    //   76: invokeinterface 196 1 0
    //   81: ifeq +38 -> 119
    //   84: aload_3
    //   85: aload 4
    //   87: invokeinterface 200 1 0
    //   92: checkcast 152	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   95: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   98: goto -24 -> 74
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: invokevirtual 466	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   110: aload_3
    //   111: invokevirtual 223	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   114: aload_0
    //   115: invokevirtual 307	com/tencent/mobileqq/config/operation/QQOperateManager:a	()V
    //   118: return
    //   119: invokestatic 172	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   122: ifeq +32 -> 154
    //   125: ldc 174
    //   127: iconst_4
    //   128: new 96	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 468
    //   138: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: invokevirtual 264	java/util/ArrayList:size	()I
    //   145: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_1
    //   155: invokevirtual 470	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   158: aload_1
    //   159: invokevirtual 466	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   162: goto -52 -> 110
    //   165: astore_2
    //   166: aload_1
    //   167: invokevirtual 466	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   170: aload_2
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	QQOperateManager
    //   0	172	1	paramQQAppInterface	QQAppInterface
    //   0	172	2	paramArrayList	ArrayList
    //   51	60	3	localEntityManager	EntityManager
    //   72	14	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   57	74	101	java/lang/Exception
    //   74	98	101	java/lang/Exception
    //   119	154	101	java/lang/Exception
    //   154	158	101	java/lang/Exception
    //   57	74	165	finally
    //   74	98	165	finally
    //   102	106	165	finally
    //   119	154	165	finally
    //   154	158	165	finally
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    ((ConfigHandler)paramQQAppInterface.a(4)).a(paramString, paramInt, paramArrayList, false);
  }
  
  public boolean a()
  {
    return a(this.jdField_a_of_type_Long);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperateTipNativeShowInfo localQQOperateTipNativeShowInfo = (QQOperateTipNativeShowInfo)localIterator.next();
      if ((paramInt1 == localQQOperateTipNativeShowInfo.b) && (paramInt2 == localQQOperateTipNativeShowInfo.jdField_a_of_type_Int)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, List paramList, ArrayList paramArrayList, boolean paramBoolean, int paramInt3)
  {
    if (this.jdField_a_of_type_Int >= 100)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..requestCount >100 ...... ");
      }
      return false;
    }
    if (a(paramInt1, paramInt2)) {
      return false;
    }
    if (!c(paramInt1, paramInt2)) {
      return false;
    }
    Object localObject3;
    Object localObject1;
    label147:
    int i;
    label160:
    int j;
    Object localObject2;
    if (b(paramInt1, paramInt2))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..server has xiafa guo ...... ");
      }
      localObject3 = a(paramInt1, paramInt2);
      if (localObject3 == null) {
        return false;
      }
      localObject1 = a(((QQOperationViopTipTask)localObject3).taskid);
      if ((localObject1 != null) && (QLog.isDevelopLevel())) {
        QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 .." + localObject1);
      }
      if (localObject1 != null)
      {
        paramInt2 = ((QQOperationTaskRecord)localObject1).aioCount;
        if (localObject1 == null) {
          break label686;
        }
        i = ((QQOperationTaskRecord)localObject1).getUinTotalShowCount(paramString);
        j = a(((QQOperationViopTipTask)localObject3).taskid);
        int k = a(((QQOperationViopTipTask)localObject3).taskid, paramString, paramInt1);
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, " judge showLimit, thisTaskAIOShowedCount = " + paramInt2 + ",thisTaskTotalShowedCount = " + i + ",thisTaskTodayAIOShowCount = " + j + ",thisUinTodayShowedCount" + k);
        }
        if ((localObject3 == null) || ((paramInt2 >= ((QQOperationViopTipTask)localObject3).limitTotalAIOCount) && ((paramInt2 != ((QQOperationViopTipTask)localObject3).limitTotalAIOCount) || (localObject1 == null) || (((QQOperationTaskRecord)localObject1).hasShowedUins == null) || (!((QQOperationTaskRecord)localObject1).hasShowedUins.contains(paramString)))) || (i >= ((QQOperationViopTipTask)localObject3).limitTotalShowCount) || ((j >= ((QQOperationViopTipTask)localObject3).limitDayAIOCount) && ((k <= 0) || (j != ((QQOperationViopTipTask)localObject3).limitDayAIOCount))) || (k >= ((QQOperationViopTipTask)localObject3).limitDayAIOShowCount)) {
          break label1523;
        }
        if (!paramBoolean) {
          break label706;
        }
        localObject2 = null;
        if (paramList == null) {
          break label692;
        }
        paramInt2 = paramList.size();
        label363:
        if (paramInt2 <= 0) {
          break label1550;
        }
        localObject1 = localObject2;
        if (paramInt3 > -1)
        {
          localObject1 = localObject2;
          if (paramInt3 < paramList.size())
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).addAll(paramList.subList(paramInt3, paramList.size()));
          }
        }
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder().append(" request from open aio ,firstUnreadMsgIndex = ").append(paramInt3).append("unreadMsgList size = ");
          if (localObject1 != null) {
            break label697;
          }
          paramInt2 = 0;
          label463:
          QLog.d("QQOperateVoIP", 4, paramInt2);
        }
      }
    }
    for (;;)
    {
      localObject1 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, (List)localObject1);
      paramInt2 = a(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, paramList);
      paramString = (String)localObject1;
      label508:
      if (QLog.isDevelopLevel()) {
        QLog.d("QQOperateVoIP", 4, " judge taskid = " + ((QQOperationViopTipTask)localObject3).taskid + ", matchKeyWords = " + paramString + ",pinfanNum = " + paramInt2);
      }
      paramInt3 = 0;
      if ((TextUtils.isEmpty(((QQOperationViopTipTask)localObject3).keywordString)) && (((QQOperationViopTipTask)localObject3).frequencyTime == 0))
      {
        paramInt1 = 1;
        label588:
        if (paramInt1 == 0) {
          break label1544;
        }
        paramQQAppInterface = paramArrayList.iterator();
        for (;;)
        {
          if (paramQQAppInterface.hasNext()) {
            if (((QQOperationRequestTaskInfo)paramQQAppInterface.next()).jdField_a_of_type_Int == ((QQOperationViopTipTask)localObject3).taskid)
            {
              paramInt1 = 1;
              label632:
              if (paramInt1 == 0)
              {
                paramQQAppInterface = new QQOperationRequestTaskInfo();
                paramQQAppInterface.jdField_a_of_type_Int = ((QQOperationViopTipTask)localObject3).taskid;
                paramQQAppInterface.b = paramInt2;
                paramQQAppInterface.jdField_a_of_type_JavaUtilArrayList = paramString;
                paramArrayList.add(paramQQAppInterface);
              }
            }
          }
        }
      }
      label1156:
      label1544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        return paramBoolean;
        paramInt2 = 0;
        break label147;
        label686:
        i = 0;
        break label160;
        label692:
        paramInt2 = 0;
        break label363;
        label697:
        paramInt2 = ((ArrayList)localObject1).size();
        break label463;
        label706:
        paramString = a(paramString, paramInt1, (QQOperationViopTipTask)localObject3, paramQQAppInterface, paramList);
        if (paramString.size() == 0) {
          break;
        }
        paramInt2 = 0;
        break label508;
        if ((TextUtils.isEmpty(((QQOperationViopTipTask)localObject3).keywordString)) && (((QQOperationViopTipTask)localObject3).frequencyTime != 0))
        {
          paramInt1 = paramInt3;
          if (paramInt2 <= 0) {
            break label588;
          }
          paramInt1 = 1;
          break label588;
        }
        if ((!TextUtils.isEmpty(((QQOperationViopTipTask)localObject3).keywordString)) && (((QQOperationViopTipTask)localObject3).frequencyTime == 0))
        {
          paramInt1 = paramInt3;
          if (paramString.size() <= 0) {
            break label588;
          }
          paramInt1 = 1;
          break label588;
        }
        paramInt1 = paramInt3;
        if (paramString.size() <= 0) {
          break label588;
        }
        paramInt1 = paramInt3;
        if (paramInt2 <= 0) {
          break label588;
        }
        paramInt1 = 1;
        break label588;
        localObject1 = a(paramInt1, paramInt2);
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..server has not xiafa guo  ...... ");
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() < 1))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "isNeedRequestForTips2 ..this type no valid task  ...... ");
          }
          return false;
        }
        localObject3 = ((ArrayList)localObject1).iterator();
        boolean bool = false;
        QQOperationViopTipTask localQQOperationViopTipTask;
        if (((Iterator)localObject3).hasNext())
        {
          localQQOperationViopTipTask = (QQOperationViopTipTask)((Iterator)localObject3).next();
          localObject1 = a(localQQOperationViopTipTask.taskid);
          if (localObject1 != null)
          {
            paramInt2 = ((QQOperationTaskRecord)localObject1).aioCount;
            label926:
            if (localObject1 == null) {
              break label1381;
            }
            i = ((QQOperationTaskRecord)localObject1).getUinTotalShowCount(paramString);
            label939:
            if (QLog.isDevelopLevel()) {
              QLog.d("QQOperateVoIP", 4, " judge showLimit, thisTaskAIOShowedCount = " + paramInt2 + ",thisTaskTotalShowedCount = " + i);
            }
            if (((paramInt2 >= localQQOperationViopTipTask.limitTotalAIOCount) && ((paramInt2 != localQQOperationViopTipTask.limitTotalAIOCount) || (localObject1 == null) || (((QQOperationTaskRecord)localObject1).hasShowedUins == null) || (!((QQOperationTaskRecord)localObject1).hasShowedUins.contains(paramString)))) || (i >= localQQOperationViopTipTask.limitTotalShowCount)) {
              break label1530;
            }
            if (!paramBoolean) {
              break label1401;
            }
            if (paramList == null) {
              break label1387;
            }
            paramInt2 = paramList.size();
            label1053:
            localObject2 = null;
            if (paramInt2 <= 0) {
              break label1533;
            }
            localObject1 = localObject2;
            if (paramInt3 > -1)
            {
              localObject1 = localObject2;
              if (paramInt3 < paramList.size())
              {
                localObject1 = new ArrayList();
                ((ArrayList)localObject1).addAll(paramList.subList(paramInt3, paramList.size()));
              }
            }
            if (QLog.isDevelopLevel())
            {
              localObject2 = new StringBuilder().append(" request from open aio ,firstUnreadMsgIndex = ").append(paramInt3).append("unreadMsgList size = ");
              if (localObject1 != null) {
                break label1392;
              }
              paramInt2 = 0;
              QLog.d("QQOperateVoIP", 4, paramInt2);
            }
          }
        }
        for (;;)
        {
          localObject1 = a(paramString, paramInt1, localQQOperationViopTipTask, paramQQAppInterface, (List)localObject1);
          i = a(paramString, paramInt1, localQQOperationViopTipTask, paramQQAppInterface, paramList);
          label1199:
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, " judge taskid = " + localQQOperationViopTipTask.taskid + ", matchKeyWords = " + localObject1 + ",pinfanNum = " + i);
          }
          j = 0;
          if ((TextUtils.isEmpty(localQQOperationViopTipTask.keywordString)) && (localQQOperationViopTipTask.frequencyTime == 0))
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label1530;
            }
            localObject2 = paramArrayList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (((QQOperationRequestTaskInfo)((Iterator)localObject2).next()).jdField_a_of_type_Int == localQQOperationViopTipTask.taskid)
              {
                paramInt2 = 1;
                label1325:
                if (paramInt2 == 0)
                {
                  localObject2 = new QQOperationRequestTaskInfo();
                  ((QQOperationRequestTaskInfo)localObject2).jdField_a_of_type_Int = localQQOperationViopTipTask.taskid;
                  ((QQOperationRequestTaskInfo)localObject2).b = i;
                  ((QQOperationRequestTaskInfo)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
                  paramArrayList.add(localObject2);
                }
                bool = true;
              }
            }
          }
          label1381:
          label1387:
          label1392:
          label1401:
          label1530:
          for (;;)
          {
            break;
            paramInt2 = 0;
            break label926;
            i = 0;
            break label939;
            paramInt2 = 0;
            break label1053;
            paramInt2 = ((ArrayList)localObject1).size();
            break label1156;
            localObject1 = a(paramString, paramInt1, localQQOperationViopTipTask, paramQQAppInterface, paramList);
            if (((ArrayList)localObject1).size() == 0) {
              break;
            }
            i = 0;
            break label1199;
            if ((TextUtils.isEmpty(localQQOperationViopTipTask.keywordString)) && (localQQOperationViopTipTask.frequencyTime != 0))
            {
              paramInt2 = j;
              if (i <= 0) {
                break label1281;
              }
              paramInt2 = 1;
              break label1281;
            }
            if ((!TextUtils.isEmpty(localQQOperationViopTipTask.keywordString)) && (localQQOperationViopTipTask.frequencyTime == 0))
            {
              paramInt2 = j;
              if (((ArrayList)localObject1).size() <= 0) {
                break label1281;
              }
              paramInt2 = 1;
              break label1281;
            }
            paramInt2 = j;
            if (((ArrayList)localObject1).size() <= 0) {
              break label1281;
            }
            paramInt2 = j;
            if (i <= 0) {
              break label1281;
            }
            paramInt2 = 1;
            break label1281;
            return bool;
            return false;
            paramInt2 = 0;
            break label1325;
          }
          label1523:
          label1533:
          localObject1 = null;
        }
        paramInt1 = 0;
        break label632;
      }
      label1281:
      label1550:
      localObject1 = null;
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((paramInt1 == localQQOperationViopTipTask.uinType) && (paramInt2 == localQQOperationViopTipTask.tipType)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)localIterator.next();
      if ((localQQOperationViopTipTask.tipType == paramInt2) || (localQQOperationViopTipTask.uinType == paramInt1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperateManager
 * JD-Core Version:    0.7.0.1
 */
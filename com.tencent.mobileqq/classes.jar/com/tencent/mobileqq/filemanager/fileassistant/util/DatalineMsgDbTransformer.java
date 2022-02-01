package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DatalineMsgDbTransformer
{
  private QQAppInterface a;
  private Map<String, Long> b = new HashMap();
  private Map<String, Boolean> c = new HashMap();
  
  public DatalineMsgDbTransformer(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    long l = c(paramInt1);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("select * from ");
    localStringBuilder2.append(paramString);
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (l != -1L)
    {
      paramString = new StringBuilder();
      paramString.append("where time <= ");
      paramString.append(l);
      paramString.append(" ");
      localStringBuilder1.append(paramString.toString());
    }
    localStringBuilder1.append("order by time desc ");
    paramString = new StringBuilder();
    paramString.append("limit ");
    paramString.append(paramInt2);
    paramString.append(",");
    paramString.append(paramInt3);
    paramString.append(" ");
    localStringBuilder1.append(paramString.toString());
    return localStringBuilder1.toString();
  }
  
  private List<DataLineMsgRecord> a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = a(paramInt3, paramInt1, paramInt2, DataLineMsgRecord.tableName(paramInt3));
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadMessageRecordFromDB: sql[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("DatalineMsgDbTransformer", 1, ((StringBuilder)localObject2).toString());
    }
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject2 = localEntityManager.rawQuery(DataLineMsgRecord.class, (String)localObject1, null);
    localEntityManager.close();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2, List<DataLineMsgRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = this.a.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataline_msg_transform_");
      localStringBuilder.append(this.a.getCurrentUin());
      localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      if (paramInt2 == 0)
      {
        long l = ((DataLineMsgRecord)paramList.get(0)).getId();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("msg_transform_begin_id_");
        localStringBuilder.append(paramInt1);
        ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), l);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("saveLastTransformInfo:save beginIndex type[");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append("] beginIndex[");
          localStringBuilder.append(l);
          localStringBuilder.append("]");
          QLog.i("DatalineMsgDbTransformer", 1, localStringBuilder.toString());
        }
      }
      paramInt2 += paramList.size();
      paramList = new StringBuilder();
      paramList.append("msg_transform_count_");
      paramList.append(paramInt1);
      ((SharedPreferences.Editor)localObject).putInt(paramList.toString(), paramInt2);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("saveLastTransformInfo:save count type[");
        paramList.append(paramInt1);
        paramList.append("] count[");
        paramList.append(paramInt2);
        paramList.append("]");
        QLog.i("DatalineMsgDbTransformer", 1, paramList.toString());
      }
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_finish_");
      localStringBuilder.append(paramInt);
      ((Map)localObject1).put(localStringBuilder.toString(), Boolean.valueOf(paramBoolean));
      localObject1 = this.a.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataline_msg_transform_");
      localStringBuilder.append(this.a.getCurrentUin());
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_finish_");
      localStringBuilder.append(paramInt);
      ((SharedPreferences.Editor)localObject1).putBoolean(localStringBuilder.toString(), paramBoolean);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveTransformFinishFlag:save finish flag type[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("] finish[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.i("DatalineMsgDbTransformer", 1, localStringBuilder.toString());
      }
      ((SharedPreferences.Editor)localObject1).apply();
      return;
    }
    finally {}
  }
  
  private void d(int paramInt)
  {
    int i = e(paramInt);
    DatalineMsgHelper localDatalineMsgHelper = new DatalineMsgHelper(this.a);
    int j;
    do
    {
      List localList = a(i, 2, paramInt);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("transformMessages: type[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("] startIndex[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("] count[");
        ((StringBuilder)localObject).append(localList.size());
        ((StringBuilder)localObject).append("]");
        QLog.i("DatalineMsgDbTransformer", 1, ((StringBuilder)localObject).toString());
      }
      if (localList.size() > 0)
      {
        localObject = new ArrayList();
        DatalineMsgTransformer localDatalineMsgTransformer = new DatalineMsgTransformer(this.a);
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localDatalineMsgTransformer.a((DataLineMsgRecord)localIterator.next());
          ChatMessage localChatMessage = localDatalineMsgTransformer.a();
          localChatMessage.isread = true;
          j = 65793;
          if ((paramInt != 0) && (paramInt == 1)) {
            j = 68361;
          }
          QFileAssistantUtils.a(localChatMessage, j);
          ((List)localObject).add(localChatMessage);
        }
        localDatalineMsgHelper.a((List)localObject);
        a(paramInt, i, localList);
      }
      if (localList.size() < 2) {
        j = 1;
      } else {
        j = 0;
      }
      int k = i;
      if (j == 0) {
        k = i + 2;
      }
      i = k;
    } while (j == 0);
    a(paramInt, true);
  }
  
  private int e(int paramInt)
  {
    Object localObject = this.a.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dataline_msg_transform_");
    localStringBuilder.append(this.a.getCurrentUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("msg_transform_count_");
    localStringBuilder.append(paramInt);
    int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTransformCountIndex: type[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("] startIndex[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.i("DatalineMsgDbTransformer", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private boolean f(int paramInt)
  {
    try
    {
      Object localObject1 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_finish_");
      localStringBuilder.append(paramInt);
      if (((Map)localObject1).containsKey(localStringBuilder.toString()))
      {
        localObject1 = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("msg_transform_finish_");
        localStringBuilder.append(paramInt);
        bool = ((Boolean)((Map)localObject1).get(localStringBuilder.toString())).booleanValue();
        return bool;
      }
      localObject1 = this.a.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataline_msg_transform_");
      localStringBuilder.append(this.a.getCurrentUin());
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_finish_");
      localStringBuilder.append(paramInt);
      boolean bool = ((SharedPreferences)localObject1).getBoolean(localStringBuilder.toString(), false);
      localObject1 = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_finish_");
      localStringBuilder.append(paramInt);
      ((Map)localObject1).put(localStringBuilder.toString(), Boolean.valueOf(bool));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTransformFinishFlag: type[");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("] finishFlag[");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append("]");
        QLog.i("DatalineMsgDbTransformer", 1, ((StringBuilder)localObject1).toString());
      }
      return bool;
    }
    finally {}
  }
  
  public long a(int paramInt)
  {
    List localList = a(0, 1, paramInt);
    if (localList.size() > 0) {
      return ((DataLineMsgRecord)localList.get(0)).time;
    }
    return -1L;
  }
  
  public void a()
  {
    QLog.e("DatalineMsgDbTransformer", 1, "transform.");
    b(0);
    if (f(0))
    {
      QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline pc: finish.");
    }
    else
    {
      QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline pc: start.");
      d(0);
    }
    b(1);
    if (f(1))
    {
      QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline iPad: finish.");
      return;
    }
    QLog.i("DatalineMsgDbTransformer", 1, "transform: handle dataline iPad: start.");
    d(1);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    try
    {
      Object localObject1 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_begin_id_");
      localStringBuilder.append(paramInt);
      ((Map)localObject1).put(localStringBuilder.toString(), Long.valueOf(paramLong));
      localObject1 = this.a.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataline_msg_transform_");
      localStringBuilder.append(this.a.getCurrentUin());
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_begin_id_");
      localStringBuilder.append(paramInt);
      ((SharedPreferences.Editor)localObject1).putLong(localStringBuilder.toString(), paramLong);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveTransformBeginItemId: type[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("] beginItemId[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.i("DatalineMsgDbTransformer", 1, localStringBuilder.toString());
      }
      ((SharedPreferences.Editor)localObject1).apply();
      return;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (f(paramInt))
      {
        QLog.d("DatalineMsgDbTransformer", 2, "checkTransformBeginItemId: finish, do not check.");
        return;
      }
      long l = c(paramInt);
      StringBuilder localStringBuilder;
      if (l == -1L)
      {
        l = a(paramInt);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkTransformBeginItemId: query beginId[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.d("DatalineMsgDbTransformer", 2, localStringBuilder.toString());
        if (l != -1L) {
          a(paramInt, l);
        } else {
          a(paramInt, true);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkTransformBeginItemId: save beginId[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.d("DatalineMsgDbTransformer", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public long c(int paramInt)
  {
    try
    {
      Object localObject1 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_begin_id_");
      localStringBuilder.append(paramInt);
      if (((Map)localObject1).containsKey(localStringBuilder.toString()))
      {
        localObject1 = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("msg_transform_begin_id_");
        localStringBuilder.append(paramInt);
        l = ((Long)((Map)localObject1).get(localStringBuilder.toString())).longValue();
        return l;
      }
      localObject1 = this.a.getApp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataline_msg_transform_");
      localStringBuilder.append(this.a.getCurrentUin());
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_begin_id_");
      localStringBuilder.append(paramInt);
      long l = ((SharedPreferences)localObject1).getLong(localStringBuilder.toString(), -1L);
      localObject1 = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg_transform_begin_id_");
      localStringBuilder.append(paramInt);
      ((Map)localObject1).put(localStringBuilder.toString(), Long.valueOf(l));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTransformBeginItemId: type[");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("] beginItemId[");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append("]");
        QLog.i("DatalineMsgDbTransformer", 1, ((StringBuilder)localObject1).toString());
      }
      return l;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class FileManagerProxy
  extends BaseProxy
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long = 0L;
  List<FileManagerEntity> jdField_a_of_type_JavaUtilList = null;
  private Map<Long, FileManagerEntity> jdField_a_of_type_JavaUtilMap = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = null;
  List<FileManagerEntity> jdField_b_of_type_JavaUtilList = null;
  private Map<String, FileManagerEntity> jdField_b_of_type_JavaUtilMap = new Hashtable();
  List<FileManagerProxy.DeletedOlSessionInfo> c = new ArrayList();
  private List<FileManagerEntity> d = null;
  private List<Integer> e = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12) });
  
  public FileManagerProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = TableBuilder.getValidField(paramEntity.getClass());
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = (Field)localList.get(i);
      String str = ((Field)localObject2).getName();
      if (!((Field)localObject2).isAccessible()) {
        ((Field)localObject2).setAccessible(true);
      }
      Object localObject1 = null;
      try
      {
        localObject2 = ((Field)localObject2).get(paramEntity);
        localObject1 = localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      if ((localObject1 instanceof Integer)) {
        localContentValues.put(str, (Integer)localObject1);
      } else if ((localObject1 instanceof Long)) {
        localContentValues.put(str, (Long)localObject1);
      } else if ((localObject1 instanceof String)) {
        localContentValues.put(str, (String)localObject1);
      } else if ((localObject1 instanceof byte[])) {
        localContentValues.put(str, (byte[])localObject1);
      } else if ((localObject1 instanceof Short)) {
        localContentValues.put(str, (Short)localObject1);
      } else if ((localObject1 instanceof Boolean)) {
        localContentValues.put(str, (Boolean)localObject1);
      } else if ((localObject1 instanceof Double)) {
        localContentValues.put(str, (Double)localObject1);
      } else if ((localObject1 instanceof Float)) {
        localContentValues.put(str, (Float)localObject1);
      } else if ((localObject1 instanceof Byte)) {
        localContentValues.put(str, (Byte)localObject1);
      }
      i += 1;
    }
    return localContentValues;
  }
  
  private boolean a(int paramInt)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      int i = this.d.size();
      if (i == 0) {
        return false;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ( select * from ");
      ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
      ((StringBuilder)localObject1).append(" where srvTime <= ");
      ((StringBuilder)localObject1).append(String.valueOf(((FileManagerEntity)this.d.get(this.d.size() - 1)).srvTime));
      ((StringBuilder)localObject1).append(" and  nSessionId != ");
      ((StringBuilder)localObject1).append(String.valueOf(((FileManagerEntity)this.d.get(this.d.size() - 1)).nSessionId));
      ((StringBuilder)localObject1).append("  order by srvTime desc limit ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") order by srvTime desc");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject1 = this.app.getEntityManagerFactory().createEntityManager().rawQuery(FileManagerEntity.class, (String)localObject1, null);
      if (localObject1 == null) {
        return false;
      }
      paramInt = ((List)localObject1).size();
      if (paramInt == 0) {
        return false;
      }
      List localList = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getAllApps(BaseApplicationImpl.getContext());
      Iterator localIterator1 = ((List)localObject1).iterator();
      while (localIterator1.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator1.next();
        if ((localFileManagerEntity.nFileType == 5) && (localFileManagerEntity.getCloudType() == 3) && (!FileUtil.b(localFileManagerEntity.getFilePath())) && (localFileManagerEntity.strApkPackageName != null) && (localFileManagerEntity.strApkPackageName.length() > 0))
        {
          Iterator localIterator2 = localList.iterator();
          while (localIterator2.hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)localIterator2.next();
            if (localFileManagerEntity.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName)) {
              localFileManagerEntity.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
            }
          }
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)) == null) {
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
        }
        this.d.add(this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)));
      }
      paramInt = ((List)localObject1).size();
      return paramInt >= 30;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void e()
  {
    try
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_JavaUtilMap;
      if (localObject1 == null) {
        return;
      }
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      if (i == 0) {
        return;
      }
    }
    finally
    {
      Object localObject1;
      for (;;)
      {
        label56:
        label204:
        throw localObject2;
      }
    }
    try
    {
      localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Map.Entry)localObject3).getValue();
        if ((localFileManagerEntity.status == 2) || (localFileManagerEntity.status == 14) || (localFileManagerEntity.status == 15) || (localFileManagerEntity.status == 4)) {
          break label56;
        }
        long l = ((Long)((Map.Entry)localObject3).getKey()).longValue();
        ((Iterator)localObject1).remove();
        if (!QLog.isColorLevel()) {
          break label56;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("remove mem entiy [");
        ((StringBuilder)localObject3).append(l);
        ((StringBuilder)localObject3).append("]. remove the entity for free memory");
        QLog.d("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject3).toString());
        break label56;
      }
    }
    catch (Exception localException)
    {
      break label204;
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.d == null) {
      init();
    }
    Object localObject1 = ((QQAppInterface)this.app).getMessageFacade().a(String.valueOf(paramLong3), paramInt);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("------->FileManager findUinSeqForCache :msgIsTroop:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(",peerUin:");
      ((StringBuilder)localObject2).append(FileManagerUtil.d(String.valueOf(paramLong3)));
      ((StringBuilder)localObject2).append(",list size:");
      int i;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = ((List)localObject1).size();
      }
      ((StringBuilder)localObject2).append(i);
      QLog.i("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).msgUid != 0L) && (((MessageRecord)localObject2).msgUid == paramLong4)) {
          return ((MessageRecord)localObject2).uniseq;
        }
        if ((Math.abs(((MessageRecord)localObject2).time - paramLong2) < 30L) && (((MessageRecord)localObject2).shmsgseq == paramLong1) && (((MessageRecord)localObject2).senderuin.equals(Long.valueOf(paramLong3))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
          }
          return ((MessageRecord)localObject2).uniseq;
        }
      }
    }
    localObject1 = this.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if ((((FileManagerEntity)localObject2).peerType == paramInt) && (((FileManagerEntity)localObject2).msgSeq == paramLong1) && (((FileManagerEntity)localObject2).msgUid == paramLong4) && (((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(Long.valueOf(paramLong3)))) {
        return ((FileManagerEntity)localObject2).uniseq;
      }
    }
    return -1L;
  }
  
  public FileManagerEntity a(long paramLong)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Object localObject1 = this.d.iterator();
      FileManagerEntity localFileManagerEntity;
      long l;
      while (((Iterator)localObject1).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject1).next();
        l = localFileManagerEntity.nSessionId;
        if (l == paramLong) {
          return localFileManagerEntity;
        }
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)((Iterator)localObject1).next();
          l = localFileManagerEntity.nSessionId;
          if (l == paramLong) {
            return localFileManagerEntity;
          }
        }
      }
      localObject1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public FileManagerEntity a(long paramLong, String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      if (this.d == null) {
        init();
      }
      Iterator localIterator = this.d.iterator();
      FileManagerEntity localFileManagerEntity;
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if ((localFileManagerEntity.peerType == 1) && (localFileManagerEntity.TroopUin == paramLong) && (!TextUtils.isEmpty(localFileManagerEntity.strTroopFileID)))
        {
          bool = paramString.equals(localFileManagerEntity.strTroopFileID);
          if (bool) {
            return localFileManagerEntity;
          }
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if ((localFileManagerEntity.peerType == 1) && (localFileManagerEntity.TroopUin == paramLong) && (!TextUtils.isEmpty(localFileManagerEntity.strTroopFileID)))
        {
          bool = paramString.equals(localFileManagerEntity.strTroopFileID);
          if (bool) {
            return localFileManagerEntity;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if ((paramLong != -1L) && (paramString != null)) {
      try
      {
        if (paramString.length() != 0)
        {
          if (this.d == null) {
            init();
          }
          Iterator localIterator = this.d.iterator();
          FileManagerEntity localFileManagerEntity;
          while (localIterator.hasNext())
          {
            localFileManagerEntity = (FileManagerEntity)localIterator.next();
            if ((localFileManagerEntity.peerUin != null) && (localFileManagerEntity.uniseq == paramLong) && (localFileManagerEntity.peerUin.equals(paramString)))
            {
              if ((localFileManagerEntity.cloudType == 1) && (FileManagerUtil.b(localFileManagerEntity))) {
                localFileManagerEntity.status = 16;
              }
              return localFileManagerEntity;
            }
          }
          if (this.jdField_a_of_type_JavaUtilMap != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
            while (localIterator.hasNext())
            {
              localFileManagerEntity = (FileManagerEntity)((Map.Entry)localIterator.next()).getValue();
              if ((localFileManagerEntity.uniseq == paramLong) && (localFileManagerEntity.peerUin != null) && (localFileManagerEntity.peerUin.equals(paramString)) && (paramInt == localFileManagerEntity.peerType))
              {
                if ((localFileManagerEntity.cloudType == 1) && (FileManagerUtil.b(localFileManagerEntity))) {
                  localFileManagerEntity.status = 16;
                }
                return localFileManagerEntity;
              }
            }
          }
          return null;
        }
      }
      finally {}
    }
    return null;
  }
  
  public FileManagerEntity a(String paramString)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select * from ");
      ((StringBuilder)localObject).append(FileManagerEntity.tableName());
      ((StringBuilder)localObject).append(" where Uuid = ?");
      localObject = ((StringBuilder)localObject).toString();
      EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      if (localEntityManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
        }
        return null;
      }
      long l1 = System.currentTimeMillis();
      paramString = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject, new String[] { SecurityUtile.encode(paramString) });
      long l2 = System.currentTimeMillis();
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
        }
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("query over,startTime[");
        ((StringBuilder)localObject).append(String.valueOf(l1));
        ((StringBuilder)localObject).append("], overTime[");
        ((StringBuilder)localObject).append(String.valueOf(l2));
        ((StringBuilder)localObject).append("]");
        QLog.d("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramString.size() > 1) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("why size[");
        ((StringBuilder)localObject).append(String.valueOf(paramString.size()));
        ((StringBuilder)localObject).append("] over 1?");
        QLog.w("FileManagerProxy", 2, ((StringBuilder)localObject).toString());
      }
      paramString = (FileManagerEntity)paramString.get(0);
      if (paramString == null) {
        return null;
      }
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramString.nSessionId), paramString);
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(paramString);
      if ((paramString.cloudType == 1) && (FileManagerUtil.b(paramString))) {
        paramString.status = 16;
      }
      return paramString;
    }
    finally {}
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    try
    {
      if (this.d != null) {
        break label266;
      }
      init();
    }
    finally
    {
      for (;;)
      {
        Iterator localIterator;
        FileManagerEntity localFileManagerEntity;
        boolean bool;
        for (;;)
        {
          throw paramString;
        }
        label266:
        if (paramString != null) {
          if (paramLong > 0L) {}
        }
      }
    }
    localIterator = this.d.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.nOLfileSessionId == paramLong)
      {
        bool = paramString.equalsIgnoreCase(localFileManagerEntity.peerUin);
        if (bool) {
          return localFileManagerEntity;
        }
      }
    } while ((0L != localFileManagerEntity.nOLfileSessionId) || (paramLong != localFileManagerEntity.nSessionId) || (!paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)));
    localFileManagerEntity.nOLfileSessionId = paramLong;
    d(localFileManagerEntity);
    return localFileManagerEntity;
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.nOLfileSessionId == paramLong)
      {
        bool = paramString.equalsIgnoreCase(localFileManagerEntity.peerUin);
        if (bool) {
          return localFileManagerEntity;
        }
      }
      if ((0L == localFileManagerEntity.nOLfileSessionId) && (paramLong == localFileManagerEntity.nSessionId) && (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)))
      {
        localFileManagerEntity.nOLfileSessionId = paramLong;
        d(localFileManagerEntity);
        return localFileManagerEntity;
      }
    }
    return null;
    return null;
  }
  
  public List<FileManagerEntity> a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = a(200);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  public List<FileManagerEntity> a(int paramInt)
  {
    try
    {
      if ((this.d == null) || (this.d.isEmpty())) {
        init();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ( select * from ");
      ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
      ((StringBuilder)localObject1).append(" order by srvTime desc limit ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") order by srvTime desc");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = this.app.getEntityManagerFactory().createEntityManager();
      l1 = System.currentTimeMillis();
    }
    finally
    {
      Object localObject1;
      Object localObject4;
      long l1;
      label113:
      long l2;
      for (;;)
      {
        label168:
        throw localObject2;
      }
    }
    try
    {
      localObject1 = ((EntityManager)localObject4).rawQuery(FileManagerEntity.class, (String)localObject1, null);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label113;
      Object localObject3 = null;
      break label168;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" data,is oom!");
      QLog.e("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
      break label562;
      if (QLog.isDevelopLevel()) {
        if (localObject1 == null)
        {
          QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("QueryMoreEntity[");
          ((StringBuilder)localObject4).append(((List)localObject1).size());
          ((StringBuilder)localObject4).append("]");
          QLog.d("FileManagerProxy<FileAssistant>", 4, ((StringBuilder)localObject4).toString());
        }
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        localObject4 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          FileManagerEntity localFileManagerEntity1 = (FileManagerEntity)((Iterator)localObject1).next();
          int i = 0;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId)) == true)
          {
            localFileManagerEntity1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject4).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator = this.d.iterator();
            FileManagerEntity localFileManagerEntity2;
            do
            {
              paramInt = i;
              if (!localIterator.hasNext()) {
                break;
              }
              localFileManagerEntity2 = (FileManagerEntity)localIterator.next();
            } while (localFileManagerEntity2.nSessionId != localFileManagerEntity1.nSessionId);
            FileManagerUtil.a(localFileManagerEntity2);
            ((List)localObject4).add(localFileManagerEntity2);
            paramInt = 1;
            if (paramInt == 0)
            {
              FileManagerUtil.a(localFileManagerEntity1);
              ((List)localObject4).add(localFileManagerEntity1);
            }
          }
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QueryMoreEntity cost[");
          ((StringBuilder)localObject1).append(l2 - l1);
          ((StringBuilder)localObject1).append("], size[");
          ((StringBuilder)localObject1).append(((List)localObject4).size());
          ((StringBuilder)localObject1).append("]");
          QLog.d("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
        }
        return localObject4;
      }
      return null;
    }
  }
  
  public List<FileManagerEntity> a(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.d == null) || (this.d.isEmpty())) {
        init();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ( select * from ");
      ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
      ((StringBuilder)localObject1).append(" order by srvTime desc limit ");
      ((StringBuilder)localObject1).append(paramInt1 * paramInt2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append((paramInt2 + 1) * paramInt1);
      ((StringBuilder)localObject1).append(") order by srvTime desc");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = this.app.getEntityManagerFactory().createEntityManager();
      l1 = System.currentTimeMillis();
    }
    finally
    {
      Object localObject1;
      Object localObject4;
      long l1;
      label135:
      label190:
      long l2;
      for (;;)
      {
        throw localObject2;
      }
    }
    try
    {
      localObject1 = ((EntityManager)localObject4).rawQuery(FileManagerEntity.class, (String)localObject1, null);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label135;
      Object localObject3 = null;
      break label190;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" data,is oom!");
      QLog.e("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
      break label605;
      if (QLog.isDevelopLevel()) {
        if (localObject1 == null)
        {
          QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("QueryMoreEntity[");
          ((StringBuilder)localObject4).append(((List)localObject1).size());
          ((StringBuilder)localObject4).append("]");
          QLog.d("FileManagerProxy<FileAssistant>", 4, ((StringBuilder)localObject4).toString());
        }
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        localObject4 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          FileManagerEntity localFileManagerEntity1 = (FileManagerEntity)((Iterator)localObject1).next();
          paramInt2 = 0;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId)) == true)
          {
            localFileManagerEntity1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject4).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator = this.d.iterator();
            FileManagerEntity localFileManagerEntity2;
            do
            {
              paramInt1 = paramInt2;
              if (!localIterator.hasNext()) {
                break;
              }
              localFileManagerEntity2 = (FileManagerEntity)localIterator.next();
            } while (localFileManagerEntity2.nSessionId != localFileManagerEntity1.nSessionId);
            FileManagerUtil.a(localFileManagerEntity2);
            ((List)localObject4).add(localFileManagerEntity2);
            paramInt1 = 1;
            if (paramInt1 == 0)
            {
              FileManagerUtil.a(localFileManagerEntity1);
              ((List)localObject4).add(localFileManagerEntity1);
            }
          }
        }
        l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QueryMoreEntity cost[");
          ((StringBuilder)localObject1).append(l2 - l1);
          ((StringBuilder)localObject1).append("]");
          QLog.d("FileManagerProxy<FileAssistant>", 4, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QueryMoreEntity retList size");
        ((StringBuilder)localObject1).append(((List)localObject4).size());
        QLog.d("FileManagerProxy<FileAssistant>", 4, ((StringBuilder)localObject1).toString());
        return localObject4;
      }
      return null;
    }
  }
  
  public List<FileManagerEntity> a(int paramInt, String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      FileManagerEntity localFileManagerEntity;
      while (((Iterator)localObject).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if ((localFileManagerEntity != null) && (localFileManagerEntity.peerUin != null) && (localFileManagerEntity.peerUin.equals(paramString)) && ((localFileManagerEntity.getCloudType() != 2) || (localFileManagerEntity.nOpType == 3))) {
          localArrayList.add(localFileManagerEntity);
        }
        i = localArrayList.size();
        if (i >= paramInt) {
          return localArrayList;
        }
      }
      int i = 0;
      int j = localArrayList.size();
      if (j > 0) {
        return localArrayList;
      }
      localObject = a(200, i);
      if (localObject == null) {
        return localArrayList;
      }
      j = i + 1;
      localObject = ((List)localObject).iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if ((localFileManagerEntity != null) && (localFileManagerEntity.peerUin != null) && (!localArrayList.contains(localFileManagerEntity)) && (localFileManagerEntity.peerUin.equals(paramString)) && ((localFileManagerEntity.getCloudType() != 2) || (localFileManagerEntity.nOpType == 3)))
        {
          localArrayList.add(localFileManagerEntity);
          this.jdField_a_of_type_JavaUtilList.add(localFileManagerEntity);
        }
        i = localArrayList.size();
      } while (i < paramInt);
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<FileManagerEntity> a(String paramString)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_JavaUtilList.clear();
      } else {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilList = a(200, paramString);
      paramString = this.jdField_b_of_type_JavaUtilList;
      return paramString;
    }
    finally {}
  }
  
  public List<FileManagerEntity> a(String paramString, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("call thread:");
        ((StringBuilder)localObject1).append(Thread.currentThread().getName());
        QLog.i("FileManagerProxy<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      }
      if (this.d == null) {
        init();
      }
      Object localObject1 = new ArrayList();
      Iterator localIterator = this.d.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject2).fileSize == paramLong) && (((FileManagerEntity)localObject2).fileName.equals(paramString)) && (((FileManagerEntity)localObject2).status == 1) && (FileUtil.a(((FileManagerEntity)localObject2).getFilePath()))) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Long)localIterator.next();
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((!((ArrayList)localObject1).contains(localObject2)) && (((FileManagerEntity)localObject2).fileSize == paramLong) && (((FileManagerEntity)localObject2).fileName.equals(paramString)) && (((FileManagerEntity)localObject2).status == 1) && (FileUtil.a(((FileManagerEntity)localObject2).getFilePath()))) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<FileManagerEntity> a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        String str = localFileManagerEntity.fileName;
        if (localFileManagerEntity.peerUin.equals(paramString2)) {
          if (str.indexOf(paramString1) >= 0) {
            localArrayList.add(localFileManagerEntity);
          } else if (SearchUtils.b(paramString1, str, IContactSearchable.g) > -9223372036854775808L) {
            localArrayList.add(localFileManagerEntity);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public List<FileManagerEntity> a(List<Integer> paramList, String paramString)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        a();
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
        {
          int i = FileManagerUtil.a(localFileManagerEntity.fileName);
          if ((localFileManagerEntity.peerUin.equals(paramString)) && (paramList.contains(Integer.valueOf(i)))) {
            localArrayList.add(localFileManagerEntity);
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public Map<String, List<FileManagerEntity>> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    FileManagerEntity localFileManagerEntity;
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (localFileManagerEntity.fileName.indexOf(paramString) >= 0))
      {
        if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
          localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
        }
        ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!TextUtils.isEmpty(localFileManagerEntity.fileName))
      {
        String str = localFileManagerEntity.fileName;
        if (localLinkedHashMap.containsKey(localFileManagerEntity.fileName) != true) {
          if (SearchUtils.b(paramString, str, IContactSearchable.g) > -9223372036854775808L)
          {
            if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
              localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
            }
            ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
          }
          else
          {
            str = FileManagerUtil.b(localFileManagerEntity);
            if (TextUtils.isEmpty(str))
            {
              if (QLog.isDevelopLevel()) {
                throw new NullPointerException("get Full String error!!!");
              }
            }
            else if (SearchUtils.b(paramString, str.replace(HardCodeUtil.a(2131704632), "").replace(HardCodeUtil.a(2131704655), "").replace(HardCodeUtil.a(2131704650), "").replace(HardCodeUtil.a(2131704643), "").replace(HardCodeUtil.a(2131704633), "").replace(HardCodeUtil.a(2131704662), "").replace(HardCodeUtil.a(2131704648), "").replace(HardCodeUtil.a(2131704644), "").replace(HardCodeUtil.a(2131704641), "").trim(), IContactSearchable.g) > -9223372036854775808L)
            {
              if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
                localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
              }
              ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
            }
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public void a()
  {
    if (this.d == null) {
      init();
    }
    Object localObject2 = this.d.iterator();
    for (Object localObject1 = null; ((Iterator)localObject2).hasNext(); localObject1 = ((FileManagerEntity)localObject1).getTableName())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      ((FileManagerEntity)localObject1).isReaded = true;
    }
    if (localObject1 != null)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isReaded", Boolean.valueOf(true));
      a((String)localObject1, (ContentValues)localObject2, "isReaded=?", new String[] { "0" }, null);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (paramLong == ((FileManagerEntity)((Map.Entry)localIterator.next()).getValue()).nSessionId) {
            localIterator.remove();
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("FileManagerDBThread", 0);
      localHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    }
    jdField_a_of_type_AndroidOsHandler.post(new FileManagerProxy.4(this, paramLong, paramString));
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramString != null) && (paramLong1 >= 0L))
    {
      if (paramLong2 <= 0L) {
        return;
      }
      if (this.c.size() > 30) {
        this.c.remove(0);
      }
      FileManagerProxy.DeletedOlSessionInfo localDeletedOlSessionInfo = new FileManagerProxy.DeletedOlSessionInfo(this);
      localDeletedOlSessionInfo.jdField_a_of_type_Long = paramLong1;
      localDeletedOlSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      localDeletedOlSessionInfo.b = paramLong2;
      this.c.add(localDeletedOlSessionInfo);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("saveDeletedEntity nSessionId=");
        paramString.append(paramLong1);
        paramString.append(" nOlSessionId=");
        paramString.append(paramLong2);
        QLog.i("FileManagerProxy<FileAssistant>", 2, paramString.toString());
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      init();
      FileManagerUtil.a(paramFileManagerEntity);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  void a(FileManagerEntity paramFileManagerEntity, ProxyListener paramProxyListener)
  {
    try
    {
      paramProxyListener = this.app.getEntityManagerFactory().createEntityManager();
      if (paramProxyListener == null) {
        return;
      }
      paramProxyListener = new FileManagerEntity();
      if (paramFileManagerEntity.nFileType != 13) {
        paramFileManagerEntity.nFileType = FileManagerUtil.a(paramFileManagerEntity.fileName);
      }
      paramProxyListener.copyFrom(paramFileManagerEntity);
      paramProxyListener.nSessionId = paramFileManagerEntity.nSessionId;
      paramProxyListener.bSend = paramFileManagerEntity.bSend;
      paramProxyListener.bDelInAio = paramFileManagerEntity.bDelInAio;
      paramProxyListener.bDelInFM = paramFileManagerEntity.bDelInFM;
      if ((paramProxyListener.status != 1) && (paramProxyListener.status != -1) && (!paramProxyListener.bSend) && (paramProxyListener.status != 4)) {
        paramProxyListener.status = 0;
      }
      if ((paramProxyListener.status == 2) || (paramProxyListener.status == 18)) {
        paramProxyListener.status = 0;
      }
      if (paramFileManagerEntity.status == 16) {
        paramProxyListener.status = 16;
      }
      if (paramProxyListener.getStatus() == 1000)
      {
        this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 0, null);
      }
      else if (paramProxyListener.getStatus() == 1001)
      {
        this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 1, null);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity status[");
        localStringBuilder.append(String.valueOf(paramProxyListener.getStatus()));
        localStringBuilder.append("] is wrong");
        QLog.e("FileManagerProxy<FileAssistant>", 2, localStringBuilder.toString());
      }
      this.proxyManager.transSaveToDatabase();
      paramFileManagerEntity.setId(paramProxyListener.getId());
      paramFileManagerEntity.setStatus(paramProxyListener.getStatus());
      return;
    }
    finally {}
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.setFilePath(paramString);
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("strFilePath", paramString);
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Object localObject1 = this.d.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
        {
          ((FileManagerEntity)localObject2).uniseq = -1L;
          ((FileManagerEntity)localObject2).bDelInAio = true;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
        {
          ((FileManagerEntity)localObject2).uniseq = -1L;
          ((FileManagerEntity)localObject2).bDelInAio = true;
        }
      }
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("bDelInAio", Boolean.valueOf(true));
      ((ContentValues)localObject1).put("uniseq", Integer.valueOf(-1));
      a(FileManagerEntity.tableName(), (ContentValues)localObject1, " peerUin = ? and peerType = ? ", new String[] { paramString, String.valueOf(paramInt) }, null);
      a(FileManagerEntity.tableName(), " bDelInAio = ? and bDelInFM = ? ", new String[] { String.valueOf(1), String.valueOf(1) }, null);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((FileManagerProxy.DeletedOlSessionInfo)localIterator.next()).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "if item is null, why can choose???!!!");
      }
      return false;
    }
    finally
    {
      Object localObject;
      break label484;
    }
    localObject = this.app.getEntityManagerFactory().createEntityManager();
    if (localObject == null) {
      return false;
    }
    localObject = ((QQAppInterface)this.app).getMessageFacade().b(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.uniseq);
    if ((paramFileManagerEntity.bDelInAio) && (paramFileManagerEntity.bDelInFM) && (localObject == null))
    {
      a(FileManagerEntity.tableName(), "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      this.d.remove(paramFileManagerEntity);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((Iterator)localObject).next() == paramFileManagerEntity) {
            ((Iterator)localObject).remove();
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (paramFileManagerEntity.nSessionId == ((FileManagerEntity)localEntry.getValue()).nSessionId) {
          ((Iterator)localObject).remove();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Delete FileManagerEntity[");
        ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.nSessionId));
        ((StringBuilder)localObject).append("] for memory and db:");
        ((StringBuilder)localObject).append(FileManagerUtil.a(paramFileManagerEntity));
        QLog.i("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.nOLfileSessionId);
      paramBoolean = a(1);
      return paramBoolean;
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("bDelInAio", Boolean.valueOf(paramFileManagerEntity.bDelInAio));
    ((ContentValues)localObject).put("bDelInFM", Boolean.valueOf(paramFileManagerEntity.bDelInFM));
    ((ContentValues)localObject).put("uniseq", Long.valueOf(paramFileManagerEntity.uniseq));
    a(FileManagerEntity.tableName(), (ContentValues)localObject, "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
    if (paramBoolean) {
      this.proxyManager.transSaveToDatabase();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Update FileManagerEntity[");
      ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.nSessionId));
      ((StringBuilder)localObject).append("] for db:");
      ((StringBuilder)localObject).append(FileManagerUtil.a(paramFileManagerEntity));
      QLog.i("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    return true;
    label484:
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
  
  public boolean a(String paramString)
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    if (localSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      return false;
    }
    return localSet.contains(paramString);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FileManagerProxy.DeletedOlSessionInfo localDeletedOlSessionInfo = (FileManagerProxy.DeletedOlSessionInfo)localIterator.next();
      if ((localDeletedOlSessionInfo.b == paramLong) && (localDeletedOlSessionInfo.jdField_a_of_type_JavaLangString != null) && (localDeletedOlSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public FileManagerEntity b(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = null;
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      }
      return localFileManagerEntity;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      paramString = new StringBuilder();
      paramString.append("select * from ");
      paramString.append(FileManagerEntity.tableName());
      paramString.append(" where uniseq = ?");
      paramString = paramString.toString();
      Object localObject = this.app.getEntityManagerFactory().createEntityManager();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
        }
        return null;
      }
      long l = System.currentTimeMillis();
      paramString = ((EntityManager)localObject).rawQuery(FileManagerEntity.class, paramString, new String[] { String.valueOf(paramLong) });
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("query over,startTime[");
        ((StringBuilder)localObject).append(String.valueOf(l));
        ((StringBuilder)localObject).append("], overTime[");
        ((StringBuilder)localObject).append(String.valueOf(paramLong));
        ((StringBuilder)localObject).append("]");
        QLog.d("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramString != null) && (paramString.size() != 0))
      {
        if ((paramString.size() > 1) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("why size[");
          ((StringBuilder)localObject).append(String.valueOf(paramString.size()));
          ((StringBuilder)localObject).append("] over 1?");
          QLog.w("FileManagerProxy", 2, ((StringBuilder)localObject).toString());
        }
        paramString = (FileManagerEntity)paramString.get(0);
        try
        {
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramString.nSessionId), paramString);
          ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(paramString);
          if ((paramString.cloudType == 1) && (FileManagerUtil.b(paramString))) {
            paramString.status = 16;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.e("FileManagerProxy<FileAssistant>", 1, paramString.toString());
          QLog.e("FileManagerProxy<FileAssistant>", 1, new Throwable().getStackTrace());
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
      }
      return null;
    }
    finally {}
  }
  
  public FileManagerEntity b(String paramString)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Iterator localIterator = this.d.iterator();
      Object localObject;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if (((FileManagerEntity)localObject).getFilePath() != null)
        {
          bool = ((FileManagerEntity)localObject).getFilePath().equalsIgnoreCase(paramString);
          if (bool) {
            return localObject;
          }
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        localObject = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (((FileManagerEntity)localObject).getFilePath() != null)
        {
          bool = ((FileManagerEntity)localObject).getFilePath().equalsIgnoreCase(paramString);
          if (bool) {
            return localObject;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<FileManagerEntity> b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        a();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryMaxRecentRecords size[");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      return localObject1;
    }
    finally {}
  }
  
  public List<FileManagerEntity> b(String paramString)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      paramString = this.jdField_b_of_type_JavaUtilList;
      return paramString;
    }
    finally {}
  }
  
  public List<FileManagerEntity> b(List<Integer> paramList, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    ArrayList localArrayList = new ArrayList(paramList);
    paramList = new ArrayList(this.e);
    paramList.removeAll(localArrayList);
    localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        int i = FileManagerUtil.a(localFileManagerEntity.fileName);
        if ((localFileManagerEntity.peerUin.equals(paramString)) && (paramList.contains(Integer.valueOf(i)))) {
          localArrayList.add(localFileManagerEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if ((localObject != null) && (((Map)localObject).size() > 0) && (l - this.jdField_a_of_type_Long > 5000L)) {
      ThreadManager.getSubThreadHandler().post(new FileManagerProxy.2(this));
    }
    localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      ((Set)localObject).clear();
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      a(paramFileManagerEntity);
      Looper localLooper = Looper.getMainLooper();
      Thread localThread1 = Thread.currentThread();
      Thread localThread2 = localLooper.getThread();
      if (localThread1 == localThread2) {
        try
        {
          a(paramFileManagerEntity, null);
          c(paramFileManagerEntity);
        }
        catch (Exception paramFileManagerEntity)
        {
          paramFileManagerEntity.printStackTrace();
        }
      } else {
        new Handler(localLooper).post(new FileManagerProxy.1(this, paramFileManagerEntity));
      }
      return;
    }
    finally {}
  }
  
  public FileManagerEntity c(String paramString)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Iterator localIterator = this.d.iterator();
      Object localObject;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if (((FileManagerEntity)localObject).strServerPath != null)
        {
          bool = ((FileManagerEntity)localObject).strServerPath.equalsIgnoreCase(paramString);
          if (bool) {
            return localObject;
          }
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        localObject = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((((FileManagerEntity)localObject).strServerPath != null) && (((FileManagerEntity)localObject).bDelInFM != true))
        {
          bool = ((FileManagerEntity)localObject).strServerPath.equalsIgnoreCase(paramString);
          if (bool) {
            return localObject;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<FileManagerEntity> c()
  {
    List localList = this.d;
    if ((localList == null) || (localList.isEmpty())) {
      init();
    }
    return this.d;
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delete from ");
    ((StringBuilder)localObject).append(FileManagerEntity.tableName());
    localObject = ((StringBuilder)localObject).toString();
    this.app.getEntityManagerFactory().createEntityManager().execSQL((String)localObject);
  }
  
  /* Error */
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 178	com/tencent/mobileqq/filemanager/data/FileManagerProxy:init	()V
    //   13: aload_0
    //   14: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: aload_1
    //   18: invokeinterface 558 2 0
    //   23: ifeq +346 -> 369
    //   26: invokestatic 357	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +340 -> 369
    //   32: ldc_w 366
    //   35: iconst_2
    //   36: ldc_w 889
    //   39: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: goto +327 -> 369
    //   45: iload_2
    //   46: aload_0
    //   47: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   50: invokeinterface 95 1 0
    //   55: if_icmpge +331 -> 386
    //   58: aload_0
    //   59: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   62: iload_2
    //   63: invokeinterface 99 2 0
    //   68: checkcast 189	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   71: astore 4
    //   73: aload_1
    //   74: getfield 197	com/tencent/mobileqq/filemanager/data/FileManagerEntity:srvTime	J
    //   77: aload 4
    //   79: getfield 197	com/tencent/mobileqq/filemanager/data/FileManagerEntity:srvTime	J
    //   82: lcmp
    //   83: iflt +296 -> 379
    //   86: aload_1
    //   87: getfield 736	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bDelInFM	Z
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   97: iload_2
    //   98: aload_1
    //   99: invokeinterface 892 3 0
    //   104: aload_0
    //   105: getfield 38	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: ifnull +266 -> 374
    //   111: aload_0
    //   112: getfield 38	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   115: iload_2
    //   116: aload_1
    //   117: invokeinterface 892 3 0
    //   122: goto +252 -> 374
    //   125: iload_3
    //   126: ifne +90 -> 216
    //   129: aload_0
    //   130: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   133: invokeinterface 95 1 0
    //   138: ifne +42 -> 180
    //   141: aload_1
    //   142: getfield 736	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bDelInFM	Z
    //   145: ifne +14 -> 159
    //   148: aload_0
    //   149: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   152: iconst_0
    //   153: aload_1
    //   154: invokeinterface 892 3 0
    //   159: aload_0
    //   160: getfield 38	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   163: ifnull +53 -> 216
    //   166: aload_0
    //   167: getfield 38	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   170: iconst_0
    //   171: aload_1
    //   172: invokeinterface 892 3 0
    //   177: goto +39 -> 216
    //   180: aload_1
    //   181: getfield 736	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bDelInFM	Z
    //   184: ifne +14 -> 198
    //   187: aload_0
    //   188: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   191: aload_1
    //   192: invokeinterface 319 2 0
    //   197: pop
    //   198: aload_0
    //   199: getfield 38	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   202: ifnull +14 -> 216
    //   205: aload_0
    //   206: getfield 38	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   209: aload_1
    //   210: invokeinterface 319 2 0
    //   215: pop
    //   216: invokestatic 529	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   219: ifeq +59 -> 278
    //   222: new 180	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   229: astore 4
    //   231: aload 4
    //   233: ldc_w 894
    //   236: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: iload_3
    //   243: invokevirtual 897	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 4
    //   249: ldc_w 899
    //   252: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 4
    //   258: aload_1
    //   259: invokestatic 814	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)Ljava/lang/String;
    //   262: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: ldc_w 366
    //   269: iconst_4
    //   270: aload 4
    //   272: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_0
    //   279: getfield 34	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   282: aload_1
    //   283: getfield 205	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   286: invokestatic 309	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   289: aload_1
    //   290: invokeinterface 315 3 0
    //   295: pop
    //   296: aload_0
    //   297: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   300: invokeinterface 95 1 0
    //   305: bipush 30
    //   307: if_icmple +49 -> 356
    //   310: aload_0
    //   311: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   314: aload_0
    //   315: getfield 32	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   318: invokeinterface 95 1 0
    //   323: iconst_1
    //   324: isub
    //   325: invokeinterface 709 2 0
    //   330: pop
    //   331: goto +25 -> 356
    //   334: astore_1
    //   335: goto +24 -> 359
    //   338: astore_1
    //   339: invokestatic 357	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +14 -> 356
    //   345: ldc_w 366
    //   348: iconst_1
    //   349: aload_1
    //   350: invokevirtual 828	java/lang/Exception:toString	()Ljava/lang/String;
    //   353: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_0
    //   357: monitorexit
    //   358: return
    //   359: aload_0
    //   360: monitorexit
    //   361: goto +5 -> 366
    //   364: aload_1
    //   365: athrow
    //   366: goto -2 -> 364
    //   369: iconst_0
    //   370: istore_2
    //   371: goto -326 -> 45
    //   374: iconst_1
    //   375: istore_3
    //   376: goto -251 -> 125
    //   379: iload_2
    //   380: iconst_1
    //   381: iadd
    //   382: istore_2
    //   383: goto -338 -> 45
    //   386: iconst_0
    //   387: istore_3
    //   388: goto -263 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	FileManagerProxy
    //   0	391	1	paramFileManagerEntity	FileManagerEntity
    //   45	338	2	i	int
    //   125	263	3	bool	boolean
    //   71	200	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	334	finally
    //   13	42	334	finally
    //   45	104	334	finally
    //   104	122	334	finally
    //   129	159	334	finally
    //   159	177	334	finally
    //   180	198	334	finally
    //   198	216	334	finally
    //   216	278	334	finally
    //   278	331	334	finally
    //   339	356	334	finally
    //   2	13	338	java/lang/Exception
    //   13	42	338	java/lang/Exception
    //   45	104	338	java/lang/Exception
    //   104	122	338	java/lang/Exception
    //   129	159	338	java/lang/Exception
    //   159	177	338	java/lang/Exception
    //   180	198	338	java/lang/Exception
    //   198	216	338	java/lang/Exception
    //   216	278	338	java/lang/Exception
    //   278	331	338	java/lang/Exception
  }
  
  public FileManagerEntity d(String paramString)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Iterator localIterator = this.d.iterator();
      Object localObject;
      int i;
      while (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject).WeiYunFileId != null) && (((FileManagerEntity)localObject).WeiYunFileId.equalsIgnoreCase(paramString)) && (((FileManagerEntity)localObject).status == 1) && (((FileManagerEntity)localObject).imgHeight > 0))
        {
          i = ((FileManagerEntity)localObject).imgWidth;
          if (i > 0) {
            return localObject;
          }
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        localObject = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((((FileManagerEntity)localObject).WeiYunFileId != null) && (((FileManagerEntity)localObject).WeiYunFileId.equalsIgnoreCase(paramString)) && (((FileManagerEntity)localObject).status == 1) && (((FileManagerEntity)localObject).imgHeight > 0))
        {
          i = ((FileManagerEntity)localObject).imgWidth;
          if (i > 0) {
            return localObject;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "updateFileEntity, Error : entity is null!!!");
      }
      return;
    }
    FileManagerUtil.a(paramFileManagerEntity);
    int i = paramFileManagerEntity.status;
    if (i == 2) {
      paramFileManagerEntity.status = 0;
    }
    ContentValues localContentValues = a(paramFileManagerEntity);
    paramFileManagerEntity.status = i;
    long l = paramFileManagerEntity.nSessionId;
    paramFileManagerEntity = Looper.getMainLooper();
    if (Thread.currentThread() == paramFileManagerEntity.getThread()) {
      try
      {
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(l) }, null);
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramFileManagerEntity.printStackTrace();
        return;
      }
    }
    new Handler(paramFileManagerEntity).post(new FileManagerProxy.3(this, localContentValues, l));
  }
  
  public void destroy() {}
  
  public FileManagerEntity e(String paramString)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Iterator localIterator = this.d.iterator();
      Object localObject;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if (((FileManagerEntity)localObject).Uuid != null)
        {
          bool = ((FileManagerEntity)localObject).Uuid.equalsIgnoreCase(paramString);
          if (bool) {
            return localObject;
          }
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        localObject = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)))
        {
          bool = ((FileManagerEntity)localObject).Uuid.equalsIgnoreCase(paramString);
          if (bool) {
            return localObject;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      if (paramFileManagerEntity.bDelInFM) {
        localContentValues.put("bDelInFM", Boolean.valueOf(true));
      } else {
        localContentValues.put("bDelInFM", Boolean.valueOf(false));
      }
      a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      return;
    }
    finally {}
  }
  
  public FileManagerEntity f(String paramString)
  {
    try
    {
      if (this.d == null) {
        init();
      }
      Object localObject1 = new ArrayList();
      Iterator localIterator = this.d.iterator();
      Object localObject2;
      boolean bool;
      while (localIterator.hasNext())
      {
        localObject2 = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject2).WeiYunFileId != null) && (((FileManagerEntity)localObject2).WeiYunFileId.equalsIgnoreCase(paramString)))
        {
          if (((FileManagerEntity)localObject2).status == 1)
          {
            bool = FileUtil.a(((FileManagerEntity)localObject2).getFilePath());
            if (bool) {
              return localObject2;
            }
          }
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localIterator = ((ArrayList)localObject1).iterator();
      int i;
      while (localIterator.hasNext())
      {
        localObject2 = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject2).nOpType != 5) && (((FileManagerEntity)localObject2).nOpType != 50))
        {
          i = ((FileManagerEntity)localObject2).cloudType;
          if (i != 2) {
            break;
          }
        }
        else
        {
          return localObject2;
        }
      }
      ((ArrayList)localObject1).clear();
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Long)localIterator.next();
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if ((((FileManagerEntity)localObject2).WeiYunFileId != null) && (((FileManagerEntity)localObject2).WeiYunFileId.equalsIgnoreCase(paramString)))
        {
          if (((FileManagerEntity)localObject2).status == 1)
          {
            bool = FileUtil.a(((FileManagerEntity)localObject2).getFilePath());
            if (bool) {
              return localObject2;
            }
          }
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      paramString = ((ArrayList)localObject1).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (FileManagerEntity)paramString.next();
        if ((((FileManagerEntity)localObject1).nOpType != 5) && (((FileManagerEntity)localObject1).nOpType != 50))
        {
          i = ((FileManagerEntity)localObject1).cloudType;
          if (i != 2) {
            break;
          }
        }
        else
        {
          return localObject1;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("msgSeq", Long.valueOf(paramFileManagerEntity.msgSeq));
      localContentValues.put("msgUid", Long.valueOf(paramFileManagerEntity.msgUid));
      localContentValues.put("msgTime", Long.valueOf(paramFileManagerEntity.msgTime));
      a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public FileManagerEntity g(String arg1)
  {
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      if (this.jdField_b_of_type_JavaUtilMap.size() == 0) {
        return null;
      }
      FileManagerEntity localFileManagerEntity1 = (FileManagerEntity)this.jdField_b_of_type_JavaUtilMap.get(???);
      if (localFileManagerEntity1 == null) {
        return null;
      }
      ??? = b(localFileManagerEntity1.nSessionId);
      if (??? != null)
      {
        if (??? == localFileManagerEntity1)
        {
          if (!FileUtil.a(localFileManagerEntity1.getFilePath())) {
            synchronized (this.jdField_b_of_type_JavaUtilMap)
            {
              this.jdField_b_of_type_JavaUtilMap.remove(localFileManagerEntity1.zipInnerPath);
              ??? = new StringBuilder();
              ???.append("getZipFileListEntity : can find the Entity in cache, but raw file is not exist! [fileName] = ");
              ???.append(localFileManagerEntity1.fileName);
              ???.append("[sessionId] = ");
              ???.append(localFileManagerEntity1.nSessionId);
              QLog.e("FileManagerProxy<FileAssistant>", 1, ???.toString());
              return null;
            }
          }
          return localFileManagerEntity2;
        }
        synchronized (this.jdField_b_of_type_JavaUtilMap)
        {
          this.jdField_b_of_type_JavaUtilMap.put(???, ???);
          return ???;
        }
      }
      try
      {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(???.nSessionId), ???);
        return ???;
      }
      finally {}
    }
  }
  
  public void g(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramFileManagerEntity.zipInnerPath, paramFileManagerEntity);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertToZipListFile : [fileName] = ");
      localStringBuilder.append(paramFileManagerEntity.fileName);
      localStringBuilder.append("[sessionId] = ");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      QLog.e("FileManagerProxy<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
  }
  
  public void init()
  {
    if (this.d != null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ( select * from ");
    ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
    ((StringBuilder)localObject1).append(" order by srvTime desc limit ");
    ((StringBuilder)localObject1).append(30);
    ((StringBuilder)localObject1).append(") order by srvTime desc");
    Object localObject3 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("update  ");
    ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
    ((StringBuilder)localObject1).append(" set bDelInFM = ?  where ( srvTime + ?  ) < ? and cloudType = ? ");
    Object localObject4 = ((StringBuilder)localObject1).toString();
    localObject1 = this.app.getEntityManagerFactory().createEntityManager();
    ((EntityManager)localObject1).update((String)localObject4, new Object[] { Integer.valueOf(1), Long.valueOf(604800000L), Long.valueOf(MessageCache.a() * 1000L), Integer.valueOf(1) });
    this.d = ((EntityManager)localObject1).rawQuery(FileManagerEntity.class, (String)localObject3, null);
    if (this.d == null)
    {
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("init , buf fmList is null,maybe is not data!,sql[");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("]");
        QLog.i("FileManagerProxy<FileAssistant>", 2, ((StringBuilder)localObject4).toString());
      }
      this.d = new ArrayList();
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        localObject3 = this.d.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FileManagerEntity)((Iterator)localObject3).next();
          FileManagerUtil.a((FileManagerEntity)localObject4);
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((FileManagerEntity)localObject4).nSessionId), localObject4);
        }
      }
      ((EntityManager)localObject1).close();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy
 * JD-Core Version:    0.7.0.1
 */
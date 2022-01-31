package com.tencent.mobileqq.troop.utils;

import ajah;
import ajai;
import ajaj;
import ajak;
import ajal;
import android.database.Observable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.DeleteFileObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFileListObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqTransFileObserver;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;

public class TroopFileManager
  extends Observable
{
  public static Map a;
  public int a;
  public long a;
  public Handler a;
  public ArrayMap a;
  private TroopFileProtocol.DeleteFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$DeleteFileObserver = new ajaj(this);
  private TroopFileProtocol.GetFileListObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetFileListObserver = new ajal(this);
  private TroopFileProtocol.ReqTransFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqTransFileObserver = new ajak(this);
  public BizTroopObserver a;
  public QQAppInterface a;
  public TroopFileManager.Filter a;
  public TroopFileTransferManager a;
  public String a;
  public int b;
  public TroopFileManager.Filter b;
  public Map b;
  public Map c = new HashMap();
  public Map d = new HashMap();
  
  static
  {
    if (!TroopFileManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public TroopFileManager(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter = new TroopFileManager.NormalFileFilter();
    this.jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter = new TroopFileManager.UploadingFileFilter();
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ajai(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)localIterator.next();
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
      localTroopFileInfo.a(localTroopFileStatusInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      if ((localTroopFileInfo.b != null) && (!"/".equals(localTroopFileInfo.b))) {
        this.c.put(localTroopFileInfo.b, localTroopFileInfo);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new ajah(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  public static TroopFileManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      TroopFileManager localTroopFileManager2 = (TroopFileManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      TroopFileManager localTroopFileManager1;
      if (localTroopFileManager2 != null)
      {
        localTroopFileManager1 = localTroopFileManager2;
        if (localTroopFileManager2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localTroopFileManager1 = new TroopFileManager(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopFileManager1);
      }
      return localTroopFileManager1;
    }
    finally {}
  }
  
  public static List a(Collection paramCollection, TroopFileManager.Filter paramFilter)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramCollection.next();
      if (paramFilter.a(localTroopFileInfo)) {
        localArrayList.add(localTroopFileInfo);
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileManager)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  /* Error */
  public TroopFileInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/mobileqq/troop/utils/TroopFileManager:c	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 46	com/tencent/mobileqq/troop/utils/TroopFileManager:c	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 180 2 0
    //   19: checkcast 122	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	TroopFileManager
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public TroopFileInfo a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localTroopFileInfo.c = paramString;
      localTroopFileInfo.jdField_a_of_type_Long = paramLong;
      localTroopFileInfo.jdField_a_of_type_Int = paramInt;
      localTroopFileInfo.a((int)NetConnInfoCenter.getServerTime());
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      return localTroopFileInfo;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public TroopFileInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = null)
    {
      for (;;)
      {
        return paramString1;
        try
        {
          localTroopFileInfo = (TroopFileInfo)this.c.get(paramString1);
          if (localTroopFileInfo != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
            paramString1 = localTroopFileInfo;
          }
        }
        finally {}
      }
      if (paramInt != 0) {
        break;
      }
    }
    TroopFileInfo localTroopFileInfo = new TroopFileInfo();
    TroopFileStatusInfo localTroopFileStatusInfo = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
    if (localTroopFileStatusInfo != null) {
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
    }
    if (localTroopFileInfo.jdField_a_of_type_JavaUtilUUID == null) {
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
    }
    localTroopFileInfo.b = paramString1;
    localTroopFileInfo.c = paramString2;
    localTroopFileInfo.jdField_a_of_type_Long = paramLong;
    localTroopFileInfo.jdField_a_of_type_Int = paramInt;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
    {
      localTroopFileInfo.f = paramString2;
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      this.c.put(paramString1, localTroopFileInfo);
      paramString1 = localTroopFileInfo;
      break;
    }
  }
  
  public TroopFileInfo a(UUID paramUUID)
  {
    try
    {
      paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final List a()
  {
    try
    {
      List localList = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramInt);
    }
  }
  
  public final void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo != null) {}
    try
    {
      this.c.remove(paramTroopFileInfo.b);
      this.jdField_b_of_type_JavaUtilMap.remove(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      c(paramTroopFileInfo);
      return;
    }
    finally
    {
      paramTroopFileInfo = finally;
      throw paramTroopFileInfo;
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, int paramInt)
  {
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo.c, paramTroopFileInfo.e, paramInt);
  }
  
  public final void a(TroopFileInfo paramTroopFileInfo, int paramInt1, int paramInt2)
  {
    if (paramTroopFileInfo != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
        if (localUUID == null) {
          return;
        }
        if ((paramTroopFileInfo.b == null) || (paramTroopFileInfo.f == null) || ("".equals(paramTroopFileInfo.b)) || ("".equals(paramTroopFileInfo.f)))
        {
          b(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (paramTroopFileInfo.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      if (QLog.isDevelopLevel())
      {
        QLog.d("TroopFileManager", 4, "delTroopFile--begin");
        QLog.d("TroopFileManager", 4, "QUN_UIN:" + this.jdField_a_of_type_Long);
      }
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int, paramTroopFileInfo.b, paramTroopFileInfo.f, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$DeleteFileObserver);
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramTroopFileInfo, paramString);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      paramString = (TroopFileInfo)this.c.remove(paramString);
      if ((!jdField_a_of_type_Boolean) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaUtilUUID);
      c(paramString);
    }
  }
  
  public void a(String paramString, TroopFileInfo paramTroopFileInfo)
  {
    try
    {
      this.c.put(paramString, paramTroopFileInfo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
    }
  }
  
  public final void a(UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (;;)
    {
      return;
      try
      {
        paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if ((paramUUID == null) || (!paramUUID.jdField_a_of_type_Boolean)) {
          continue;
        }
        paramUUID.jdField_a_of_type_Boolean = false;
        d(paramUUID);
      }
      finally {}
    }
  }
  
  public final boolean a(int paramInt, String paramString, long paramLong)
  {
    try
    {
      TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.d.get(paramString + paramLong);
      if (localFileManagerStatus == null)
      {
        localFileManagerStatus = new TroopFileManager.FileManagerStatus(this, paramLong);
        this.d.put(paramString + paramLong, localFileManagerStatus);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = localFileManagerStatus.jdField_a_of_type_Long;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          localFileManagerStatus.jdField_a_of_type_Long = System.currentTimeMillis();
          TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localFileManagerStatus.jdField_a_of_type_Int, 1, 20, 3, 1, paramString, localFileManagerStatus.c, paramLong, 0, localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetFileListObserver);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(TroopFileInfo paramTroopFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 223	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_Int	I
    //   6: ifeq +12 -> 18
    //   9: aload_1
    //   10: getfield 138	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/lang/String;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +9 -> 24
    //   18: iconst_0
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 93	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: aload_0
    //   29: getfield 91	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Long	J
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 84	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqTransFileObserver	Lcom/tencent/biz/troop/file/TroopFileProtocol$ReqTransFileObserver;
    //   37: invokestatic 376	com/tencent/biz/troop/file/TroopFileProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLcom/tencent/mobileqq/troop/data/TroopFileInfo;Lcom/tencent/biz/troop/file/TroopFileProtocol$ReqTransFileObserver;)V
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 377	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Int	I
    //   45: iconst_1
    //   46: iadd
    //   47: putfield 377	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Int	I
    //   50: iconst_1
    //   51: istore_2
    //   52: goto -32 -> 20
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TroopFileManager
    //   0	60	1	paramTroopFileInfo	TroopFileInfo
    //   19	33	2	bool	boolean
    //   13	2	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	14	55	finally
    //   24	50	55	finally
  }
  
  public boolean a(TroopFileObserver paramTroopFileObserver)
  {
    return this.mObservers.contains(paramTroopFileObserver);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.d.get(paramString + paramLong);
      paramString = localFileManagerStatus;
      if (localFileManagerStatus == null) {
        paramString = new TroopFileManager.FileManagerStatus(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public TroopFileInfo b(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        TroopFileInfo localTroopFileInfo = new TroopFileInfo();
        localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localTroopFileInfo.h = paramString;
        paramString = new File(paramString);
        localTroopFileInfo.jdField_a_of_type_Long = paramString.length();
        localTroopFileInfo.c = paramString.getName();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramString = "/";
          localTroopFileInfo.f = paramString;
          this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
          paramString = localTroopFileInfo;
          break;
        }
      }
      finally {}
      paramString = this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public TroopFileInfo b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      paramString1 = a(paramString1, paramString2, paramLong, paramInt);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void b()
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileInfo)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public final void b(TroopFileInfo paramTroopFileInfo)
  {
    try
    {
      a(paramTroopFileInfo, 0, 0);
      return;
    }
    finally
    {
      paramTroopFileInfo = finally;
      throw paramTroopFileInfo;
    }
  }
  
  /* Error */
  public final void b(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 269 2 0
    //   12: checkcast 122	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 271	com/tencent/mobileqq/troop/utils/TroopFileManager:c	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   28: aload_0
    //   29: getfield 46	com/tencent/mobileqq/troop/utils/TroopFileManager:c	Ljava/util/Map;
    //   32: aload_1
    //   33: getfield 138	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/lang/String;
    //   36: invokeinterface 269 2 0
    //   41: pop
    //   42: goto -22 -> 20
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	TroopFileManager
    //   0	50	1	paramUUID	UUID
    // Exception table:
    //   from	to	target	type
    //   2	16	45	finally
    //   23	42	45	finally
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    try
    {
      TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.d.get(paramString + paramLong);
      if (localFileManagerStatus == null)
      {
        localFileManagerStatus = new TroopFileManager.FileManagerStatus(this, paramLong);
        this.d.put(paramString + paramLong, localFileManagerStatus);
      }
      for (;;)
      {
        if (!localFileManagerStatus.jdField_a_of_type_Boolean)
        {
          bool = localFileManagerStatus.jdField_b_of_type_Boolean;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, localFileManagerStatus.jdField_a_of_type_Int, 3, 20, 3, 1, paramString, localFileManagerStatus.c, paramLong, localFileManagerStatus.jdField_b_of_type_Int, localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetFileListObserver);
          localFileManagerStatus.jdField_b_of_type_Boolean = true;
        }
      }
    }
    finally {}
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramTroopFileInfo);
    }
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).b(paramTroopFileInfo);
    }
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).c(paramTroopFileInfo);
    }
  }
  
  public void i(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).e(paramTroopFileInfo);
    }
  }
  
  public void j(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).d(paramTroopFileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager
 * JD-Core Version:    0.7.0.1
 */
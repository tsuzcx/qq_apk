package com.tencent.mobileqq.troop.utils;

import ajvy;
import ajvz;
import ajwa;
import ajwb;
import ajwc;
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
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
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
  private TroopFileProtocol.DeleteFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$DeleteFileObserver = new ajwa(this);
  private TroopFileProtocol.GetFileListObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetFileListObserver = new ajwc(this);
  private TroopFileProtocol.ReqTransFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqTransFileObserver = new ajwb(this);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ajvz(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new ajvy(this, paramQQAppInterface.getApplication().getMainLooper());
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
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      Object localObject1;
      label34:
      try
      {
        localObject1 = TroopFileTransferUtil.a(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (TroopFileInfo)this.c.get(paramString1);
      if (localObject2 != null)
      {
        this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (TroopFileInfo)this.c.get(localObject1);
        if (localObject1 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new TroopFileInfo();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID = ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID;
            }
            if (((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID == null) {
              ((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((TroopFileInfo)localObject1).b = paramString1;
            ((TroopFileInfo)localObject1).c = paramString2;
            ((TroopFileInfo)localObject1).jdField_a_of_type_Long = paramLong;
            ((TroopFileInfo)localObject1).jdField_a_of_type_Int = paramInt;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
            for (paramString2 = "/";; paramString2 = this.jdField_a_of_type_JavaLangString)
            {
              ((TroopFileInfo)localObject1).f = paramString2;
              this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
              this.c.put(paramString1, localObject1);
              paramString1 = (String)localObject1;
              break;
            }
            break label34;
            localObject1 = "0";
            break label34;
          }
          paramString1 = null;
        }
      }
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
  
  /* Error */
  public final void a(TroopFileInfo paramTroopFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 279	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   9: istore_2
    //   10: new 281	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 284
    //   20: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 127	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 127	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   36: invokevirtual 292	java/util/UUID:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: ldc_w 294
    //   43: iload_2
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 296
    //   53: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 300	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 46	com/tencent/mobileqq/troop/utils/TroopFileManager:c	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 138	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/lang/String;
    //   70: invokeinterface 303 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 44	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 127	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   84: invokeinterface 303 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 305	com/tencent/mobileqq/troop/utils/TroopFileManager:c	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 307
    //   101: astore_3
    //   102: goto -62 -> 40
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	TroopFileManager
    //   0	110	1	paramTroopFileInfo	TroopFileInfo
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
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
        TroopFileTransferUtil.Log.c("TroopFileManager", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString() + "] delete. mFileId:" + paramTroopFileInfo.b + " mParentId:" + paramTroopFileInfo.f + " uint32_bus_id:" + paramTroopFileInfo.jdField_a_of_type_Int);
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
      TroopFileTransferUtil.Log.c("TroopFileManager", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "doUploadDelete: filePath:" + paramString);
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
    //   3: getfield 224	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_Int	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 138	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 279	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   29: istore_2
    //   30: new 281	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 284
    //   40: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 127	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 127	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   56: invokevirtual 292	java/util/UUID:toString	()Ljava/lang/String;
    //   59: astore 4
    //   61: ldc_w 294
    //   64: iload_2
    //   65: aload 5
    //   67: aload 4
    //   69: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 397
    //   75: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: getfield 138	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/lang/String;
    //   82: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 300	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 93	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 91	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Long	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 84	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqTransFileObserver	Lcom/tencent/biz/troop/file/TroopFileProtocol$ReqTransFileObserver;
    //   104: invokestatic 400	com/tencent/biz/troop/file/TroopFileProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLcom/tencent/mobileqq/troop/data/TroopFileInfo;Lcom/tencent/biz/troop/file/TroopFileProtocol$ReqTransFileObserver;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 401	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Int	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 401	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Int	I
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -97 -> 22
    //   122: ldc_w 307
    //   125: astore 4
    //   127: goto -66 -> 61
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	TroopFileManager
    //   0	135	1	paramTroopFileInfo	TroopFileInfo
    //   29	36	2	i	int
    //   21	98	3	bool	boolean
    //   13	113	4	str	String
    //   43	23	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	15	130	finally
    //   26	61	130	finally
    //   61	117	130	finally
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
    //   2: getstatic 279	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:jdField_a_of_type_Int	I
    //   5: istore_2
    //   6: new 281	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 284
    //   16: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 4
    //   21: aload_1
    //   22: ifnull +51 -> 73
    //   25: aload_1
    //   26: invokevirtual 292	java/util/UUID:toString	()Ljava/lang/String;
    //   29: astore_3
    //   30: ldc_w 294
    //   33: iload_2
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 425
    //   43: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 300	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 44	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 303 2 0
    //   62: checkcast 122	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull +13 -> 80
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: ldc_w 307
    //   76: astore_3
    //   77: goto -47 -> 30
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 305	com/tencent/mobileqq/troop/utils/TroopFileManager:c	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   85: aload_0
    //   86: getfield 46	com/tencent/mobileqq/troop/utils/TroopFileManager:c	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 138	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/lang/String;
    //   93: invokeinterface 303 2 0
    //   98: pop
    //   99: goto -29 -> 70
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	TroopFileManager
    //   0	107	1	paramUUID	UUID
    //   5	29	2	i	int
    //   29	48	3	str	String
    //   19	16	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	21	102	finally
    //   25	30	102	finally
    //   30	66	102	finally
    //   80	99	102	finally
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
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager
 * JD-Core Version:    0.7.0.1
 */
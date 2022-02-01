package com.tencent.mobileqq.troop.utils;

import android.database.Observable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileDeleteFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqTransFileObserver;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.data.TroopFileSearchByTypeItemData;
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
  extends Observable<TroopFileObserver>
{
  public static Map<Long, TroopFileManager> a;
  public int a;
  public long a;
  public Handler a;
  public ArrayMap<Integer, List<TroopFileSearchByTypeItemData>> a;
  private TroopFileDeleteFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileDeleteFileObserver = new TroopFileManager.3(this);
  private TroopFileGetFileListObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFileListObserver = new TroopFileManager.5(this);
  private TroopFileReqTransFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqTransFileObserver = new TroopFileManager.4(this);
  public BizTroopObserver a;
  public QQAppInterface a;
  public TroopFileManager.Filter a;
  public TroopFileTransferManager a;
  public String a;
  public int b;
  public TroopFileManager.Filter b;
  public Map<UUID, TroopFileInfo> b;
  public Map<String, TroopFileInfo> c = new HashMap();
  public Map<String, TroopFileManager.FileManagerStatus> d = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public TroopFileManager(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter = new TroopFileManager.NormalFileFilter();
    this.jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter = new TroopFileManager.UploadingFileFilter();
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileManager.2(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new TroopFileManager.1(this, paramQQAppInterface.getApplication().getMainLooper());
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
  
  public static List<TroopFileInfo> a(Collection<TroopFileInfo> paramCollection, TroopFileManager.Filter paramFilter)
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
  
  public TroopFileInfo a(String paramString)
  {
    try
    {
      if (this.c != null)
      {
        paramString = (TroopFileInfo)this.c.get(paramString);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
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
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = TroopFileTransferUtil.a(paramString1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() != 0)
          {
            localObject2 = (TroopFileInfo)this.c.get(paramString1);
            if (localObject2 != null)
            {
              this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject2).jdField_a_of_type_JavaUtilUUID, localObject2);
              return localObject2;
            }
            localObject1 = (TroopFileInfo)this.c.get(localObject1);
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
              return localObject1;
            }
            if (paramInt == 0) {
              return null;
            }
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
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              paramString2 = "/";
            } else {
              paramString2 = this.jdField_a_of_type_JavaLangString;
            }
            ((TroopFileInfo)localObject1).g = paramString2;
            this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject1).jdField_a_of_type_JavaUtilUUID, localObject1);
            this.c.put(paramString1, localObject1);
            return localObject1;
          }
        }
      }
      finally {}
      Object localObject1 = "0";
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
  
  public final List<TroopFileInfo> a()
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
    for (;;)
    {
      try
      {
        int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID == null) {
          break label118;
        }
        str = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString();
        localStringBuilder.append(str);
        localStringBuilder.append("] doDelete2");
        TroopFileTransferUtil.Log.c("TroopFileManager", i, localStringBuilder.toString());
        this.c.remove(paramTroopFileInfo.b);
        this.jdField_b_of_type_JavaUtilMap.remove(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
        c(paramTroopFileInfo);
      }
      finally {}
      return;
      label118:
      String str = "null";
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, int paramInt)
  {
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo.c, paramTroopFileInfo.e, paramInt);
  }
  
  public final void a(TroopFileInfo paramTroopFileInfo, int paramInt1, int paramInt2)
  {
    if (paramTroopFileInfo != null) {
      try
      {
        if (paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID != null)
        {
          int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString());
          localStringBuilder.append("] delete. mFileId:");
          localStringBuilder.append(paramTroopFileInfo.b);
          localStringBuilder.append(" mParentId:");
          localStringBuilder.append(paramTroopFileInfo.g);
          localStringBuilder.append(" uint32_bus_id:");
          localStringBuilder.append(paramTroopFileInfo.jdField_a_of_type_Int);
          TroopFileTransferUtil.Log.c("TroopFileManager", i, localStringBuilder.toString());
          if ((paramTroopFileInfo.b != null) && (paramTroopFileInfo.g != null) && (!"".equals(paramTroopFileInfo.b)) && (!"".equals(paramTroopFileInfo.g)))
          {
            i = paramTroopFileInfo.jdField_a_of_type_Int;
            if (i == 0) {
              return;
            }
            TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int, paramTroopFileInfo.b, paramTroopFileInfo.g, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileDeleteFileObserver);
            return;
          }
          b(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
          return;
        }
      }
      finally {}
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
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doUploadDelete: filePath:");
      localStringBuilder.append(paramString);
      TroopFileTransferUtil.Log.c("TroopFileManager", i, localStringBuilder.toString());
      paramString = (TroopFileInfo)this.c.remove(paramString);
      if ((!jdField_a_of_type_Boolean) && (paramString == null)) {
        throw new AssertionError();
      }
      if (paramString != null)
      {
        this.jdField_b_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaUtilUUID);
        c(paramString);
      }
      return;
    }
    finally {}
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
  
  public void a(Collection<TroopFileInfo> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
    }
  }
  
  public final void a(UUID paramUUID)
  {
    if (paramUUID == null) {
      return;
    }
    try
    {
      paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      if ((paramUUID != null) && (paramUUID.jdField_a_of_type_Boolean))
      {
        paramUUID.jdField_a_of_type_Boolean = false;
        d(paramUUID);
      }
      return;
    }
    finally {}
  }
  
  public final boolean a(int paramInt, String paramString, long paramLong)
  {
    try
    {
      Object localObject1 = this.d;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(paramLong);
      localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopFileManager.FileManagerStatus(this, paramLong);
        localObject2 = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramLong);
        ((Map)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      long l1 = System.currentTimeMillis();
      long l2 = ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Long;
      l1 -= l2;
      if ((0L < l1) && (l1 < paramInt * 1000L)) {
        return false;
      }
      ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Int, 1, 20, 3, 1, paramString, ((TroopFileManager.FileManagerStatus)localObject1).c, paramLong, 0, ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFileListObserver);
      return true;
    }
    finally {}
  }
  
  public final boolean a(TroopFileInfo paramTroopFileInfo)
  {
    for (;;)
    {
      try
      {
        if ((paramTroopFileInfo.jdField_a_of_type_Int != 0) && (paramTroopFileInfo.b != null))
        {
          int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          if (paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID != null)
          {
            str = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString();
            localStringBuilder.append(str);
            localStringBuilder.append("] transFile. mFileId:");
            localStringBuilder.append(paramTroopFileInfo.b);
            TroopFileTransferUtil.Log.c("TroopFileManager", i, localStringBuilder.toString());
            TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramTroopFileInfo, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqTransFileObserver);
            this.jdField_a_of_type_Int += 1;
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      finally {}
      String str = "null";
    }
  }
  
  public boolean a(TroopFileObserver paramTroopFileObserver)
  {
    return this.mObservers.contains(paramTroopFileObserver);
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    try
    {
      Object localObject = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramLong);
      localObject = (TroopFileManager.FileManagerStatus)((Map)localObject).get(localStringBuilder.toString());
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new TroopFileManager.FileManagerStatus(this, paramLong);
      }
      boolean bool = paramString.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public TroopFileInfo b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localTroopFileInfo.i = paramString;
      paramString = new File(paramString);
      localTroopFileInfo.jdField_a_of_type_Long = paramString.length();
      localTroopFileInfo.c = paramString.getName();
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramString = "/";
      } else {
        paramString = this.jdField_a_of_type_JavaLangString;
      }
      localTroopFileInfo.g = paramString;
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      return localTroopFileInfo;
    }
    finally {}
  }
  
  public TroopFileInfo b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localTroopFileInfo.b = paramString1;
      localTroopFileInfo.c = paramString2;
      localTroopFileInfo.jdField_a_of_type_Long = paramLong;
      localTroopFileInfo.jdField_a_of_type_Int = paramInt;
      localTroopFileInfo.g = "/";
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      this.c.put(paramString1, localTroopFileInfo);
      return localTroopFileInfo;
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
  
  public final void b(String paramString)
  {
    try
    {
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doTroopFileDelete: filePath:");
      localStringBuilder.append(paramString);
      TroopFileTransferUtil.Log.c("TroopFileManager", i, localStringBuilder.toString());
      paramString = (TroopFileInfo)this.c.remove(paramString);
      if ((!jdField_a_of_type_Boolean) && (paramString == null)) {
        throw new AssertionError();
      }
      if (paramString != null)
      {
        this.jdField_b_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaUtilUUID);
        c(paramString);
      }
      return;
    }
    finally {}
  }
  
  public final void b(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramUUID != null)
        {
          str = paramUUID.toString();
          localStringBuilder.append(str);
          localStringBuilder.append("] doDelete");
          TroopFileTransferUtil.Log.c("TroopFileManager", i, localStringBuilder.toString());
          paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.remove(paramUUID);
          if (paramUUID == null) {
            return;
          }
          c(paramUUID);
          this.c.remove(paramUUID.b);
          return;
        }
      }
      finally {}
      String str = "null";
    }
  }
  
  public final boolean b(String paramString, long paramLong)
  {
    try
    {
      Object localObject1 = this.d;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(paramLong);
      localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopFileManager.FileManagerStatus(this, paramLong);
        localObject2 = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramLong);
        ((Map)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      if ((!((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Boolean) && (!((TroopFileManager.FileManagerStatus)localObject1).jdField_b_of_type_Boolean))
      {
        TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Int, 3, 20, 3, 1, paramString, ((TroopFileManager.FileManagerStatus)localObject1).c, paramLong, ((TroopFileManager.FileManagerStatus)localObject1).jdField_b_of_type_Int, ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFileListObserver);
        ((TroopFileManager.FileManagerStatus)localObject1).jdField_b_of_type_Boolean = true;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public TroopFileInfo c(String paramString1, String paramString2, long paramLong, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager
 * JD-Core Version:    0.7.0.1
 */
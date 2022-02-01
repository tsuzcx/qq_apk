package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqResendFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.manager.ProxyIpManager;

public class TroopFileTransferManager
  implements INetInfoHandler
{
  private static Map<Long, TroopFileTransferManager> c;
  protected long a;
  private TroopFileGetOneFileInfoObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetOneFileInfoObserver = new TroopFileTransferManager.6(this);
  private TroopFileReqCopyToObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new TroopFileTransferManager.8(this);
  private TroopFileReqDownloadFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFileTransferManager.7(this);
  private TroopFileReqFeedsObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqFeedsObserver = new TroopFileTransferManager.5(this);
  private TroopFileReqResendFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqResendFileObserver = new TroopFileTransferManager.3(this);
  private TroopFileReqUploadFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqUploadFileObserver = new TroopFileTransferManager.4(this);
  protected QQAppInterface a;
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  protected Map<UUID, TroopFileTransferManager.Item> a;
  private ProxyIpManager jdField_a_of_type_MqqManagerProxyIpManager;
  public TroopFileTransferManager.TaskPool[] a;
  protected long b;
  private TroopFileReqCopyToObserver b;
  protected Map<UUID, Integer> b;
  protected boolean b;
  protected long c;
  public boolean c;
  protected long d = 0L;
  protected long e;
  private volatile long f;
  
  public TroopFileTransferManager()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new TroopFileTransferManager.9(this);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool = new TroopFileTransferManager.TaskPool[] { new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2) };
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static TroopFileTransferManager a(long paramLong)
  {
    try
    {
      TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localTroopFileTransferManager;
    }
    finally {}
  }
  
  public static TroopFileTransferManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if (jdField_c_of_type_JavaUtilMap == null)
      {
        jdField_c_of_type_JavaUtilMap = new HashMap();
        ThreadManager.post(new TroopFileTransferManager.1(), 2, null, true);
      }
      TroopFileUploadingManager.a(paramQQAppInterface);
      Object localObject2 = (TroopFileTransferManager)jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((TroopFileTransferManager)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
        {
          ((TroopFileTransferManager)localObject2).b();
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new TroopFileTransferMgr(paramQQAppInterface, paramLong);
        ((TroopFileTransferManager)localObject2).a();
        ThreadManager.post(new TroopFileTransferManager.2((TroopFileTransferManager)localObject2), 8, null, true);
        jdField_c_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localObject2);
      }
      return localObject2;
    }
    finally {}
  }
  
  private void a(int paramInt, long paramLong)
  {
    try
    {
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
      {
        if (paramInt == 0) {
          this.jdField_b_of_type_Long += paramLong;
        } else if (paramInt == 1) {
          this.jdField_a_of_type_Long += paramLong;
        }
      }
      else
      {
        if (paramInt == 0) {
          this.d += paramLong;
        } else if (paramInt == 1) {
          this.jdField_c_of_type_Long += paramLong;
        }
        g();
      }
      return;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    try
    {
      Iterator localIterator = jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        if (localTroopFileTransferManager.e == paramLong) {
          localTroopFileTransferManager.d();
        } else {
          localTroopFileTransferManager.j();
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
  
  private final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileTransferManager", 2, "TroopFileTransferManager.ReleaseAll called!");
    }
    try
    {
      if (jdField_c_of_type_JavaUtilMap == null) {
        return;
      }
      Iterator localIterator = jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).b();
      }
      jdField_c_of_type_JavaUtilMap.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private final void f(TroopFileTransferManager.Item paramItem)
  {
    paramItem.ErrorCode = 0;
    a(paramItem, 12);
  }
  
  public static void i()
  {
    try
    {
      Iterator localIterator = jdField_c_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).j();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    return 0;
  }
  
  public final TroopFileStatusInfo a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      Object localObject = a().a(paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, 102);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startCopy2TroopFromFav==>");
        localStringBuilder.append(((TroopFileInfo)localObject).toString());
        QLog.d("TroopFileTransferManager", 2, localStringBuilder.toString());
      }
      if (localObject == null) {
        return null;
      }
      c();
      ((TroopFileInfo)localObject).j = paramFileManagerEntity.strThumbPath;
      ((TroopFileInfo)localObject).l = paramFileManagerEntity.strMiddleThumPath;
      ((TroopFileInfo)localObject).k = paramFileManagerEntity.strLargeThumPath;
      localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
      a((TroopFileTransferManager.Item)localObject);
      ((TroopFileTransferManager.Item)localObject).RandomNum = paramInt2;
      ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = paramLong;
      ((TroopFileTransferManager.Item)localObject).ForwardBusId = paramInt1;
      ((TroopFileTransferManager.Item)localObject).Status = 4;
      ((TroopFileTransferManager.Item)localObject).LocalFile = paramFileManagerEntity.getFilePath();
      ((TroopFileTransferManager.Item)localObject).entrySessionID = paramFileManagerEntity.nSessionId;
      ((TroopFileTransferManager.Item)localObject).width = paramFileManagerEntity.imgWidth;
      ((TroopFileTransferManager.Item)localObject).height = paramFileManagerEntity.imgHeight;
      a((TroopFileTransferManager.Item)localObject, 4, 0);
      paramFileManagerEntity = ((TroopFileTransferManager.Item)localObject).getInfo(this.e);
      return paramFileManagerEntity;
    }
    finally {}
  }
  
  public final TroopFileStatusInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      c();
      localObject2 = TroopFileTransferUtil.a(paramString);
      if (localObject2 == null) {
        break label123;
      }
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        for (;;)
        {
          throw paramString;
        }
        Object localObject1 = "0";
      }
    }
    localObject2 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)((Iterator)localObject2).next();
      if ((paramString.equals(localItem.FilePath)) || (((String)localObject1).equals(localItem.FilePath)))
      {
        paramString = localItem.getInfo(this.e);
        return paramString;
      }
    }
    return null;
  }
  
  public TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    return null;
  }
  
  public TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    return null;
  }
  
  public final TroopFileStatusInfo a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    try
    {
      paramString1 = a().c(paramString1, paramString2, paramLong1, 102);
      if (paramString1 == null) {
        return null;
      }
      c();
      paramString1 = new TroopFileTransferManager.Item(paramString1);
      a(paramString1);
      paramString1.RandomNum = paramInt2;
      paramString1.ForwardTroopuin = paramLong2;
      paramString1.ForwardBusId = paramInt1;
      paramString1.Status = 4;
      paramString1.LocalFile = paramString3;
      a(paramString1, 4, 0);
      paramString1 = paramString1.getInfo(this.e);
      return paramString1;
    }
    finally {}
  }
  
  public final TroopFileStatusInfo a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramString1 = a().a(paramString2, paramLong1, 102);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("startCopy2TroopFromOfflineOrDisc==>");
        paramString2.append(paramString1.toString());
        QLog.d("TroopFileTransferManager", 2, paramString2.toString());
      }
      if (paramString1 == null) {
        return null;
      }
      c();
      paramString1 = new TroopFileTransferManager.Item(paramString1);
      a(paramString1);
      paramString1.RandomNum = paramInt2;
      paramString1.ForwardTroopuin = paramLong2;
      paramString1.ForwardBusId = paramInt1;
      paramString1.Status = 4;
      paramString1.LocalFile = paramString3;
      paramString1.entrySessionID = paramLong3;
      if (paramFileManagerEntity != null)
      {
        paramString1.width = paramFileManagerEntity.imgWidth;
        paramString1.height = paramFileManagerEntity.imgHeight;
        paramString1.yybApkPackageName = paramFileManagerEntity.yybApkPackageName;
        paramString1.yybApkName = paramFileManagerEntity.yybApkName;
        paramString1.yybApkIconUrl = paramFileManagerEntity.yybApkIconUrl;
      }
      a(paramString1, 4, 0);
      paramString1 = paramString1.getInfo(this.e);
      return paramString1;
    }
    finally {}
  }
  
  public TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  public final TroopFileStatusInfo a(UUID paramUUID)
  {
    try
    {
      c();
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      if (paramUUID == null) {
        return null;
      }
      paramUUID = paramUUID.getInfo(this.e);
      return paramUUID;
    }
    finally {}
  }
  
  protected TroopFileManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID)
  {
    try
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      if (localMap == null) {
        return null;
      }
      if (paramUUID != null)
      {
        paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
        return paramUUID;
      }
      throw new NullPointerException("TroopFileTransferManager getItem id is Null");
    }
    finally {}
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    return null;
  }
  
  public final Collection<TroopFileStatusInfo> a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TroopFileTransferManager.Item)localIterator.next()).getInfo(this.e));
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final List<TroopFileStatusInfo> a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem != null) && (localItem.FilePath != null)) {
          localArrayList.add(localItem.getInfo(this.e));
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected ProxyIpManager a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return null;
    }
    if (this.jdField_a_of_type_MqqManagerProxyIpManager == null) {
      this.jdField_a_of_type_MqqManagerProxyIpManager = ((ProxyIpManager)localQQAppInterface.getManager(3));
    }
    return this.jdField_a_of_type_MqqManagerProxyIpManager;
  }
  
  protected void a() {}
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, IForwardCallBack paramIForwardCallBack)
  {
    a(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramString1, paramString2, paramLong3, paramString3, paramBoolean, paramLong4, paramIForwardCallBack, 0L, 0, null);
  }
  
  /* Error */
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, IForwardCallBack paramIForwardCallBack, long paramLong5, int paramInt4, android.os.Bundle arg20)
  {
    // Byte code:
    //   0: iload 4
    //   2: istore 21
    //   4: new 425	java/util/Random
    //   7: dup
    //   8: invokespecial 426	java/util/Random:<init>	()V
    //   11: invokevirtual 429	java/util/Random:nextInt	()I
    //   14: invokestatic 435	java/lang/Math:abs	(I)I
    //   17: istore 22
    //   19: aload_0
    //   20: invokevirtual 243	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   23: astore 23
    //   25: aload 23
    //   27: monitorenter
    //   28: aload_0
    //   29: monitorenter
    //   30: iload 21
    //   32: istore 4
    //   34: iload 21
    //   36: bipush 102
    //   38: if_icmpeq +364 -> 402
    //   41: iload 21
    //   43: istore 4
    //   45: iload 21
    //   47: bipush 104
    //   49: if_icmpeq +353 -> 402
    //   52: aload_0
    //   53: getfield 384	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager	Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   56: ifnonnull +11 -> 67
    //   59: aload_0
    //   60: aload_0
    //   61: invokevirtual 243	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   64: putfield 384	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager	Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   67: aload_0
    //   68: getfield 384	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager	Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   71: aload 12
    //   73: invokevirtual 438	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   76: astore 24
    //   78: aload 24
    //   80: ifnull +306 -> 386
    //   83: aload 24
    //   85: getfield 440	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_Int	I
    //   88: istore 4
    //   90: goto +312 -> 402
    //   93: aload 23
    //   95: aload 8
    //   97: lload 10
    //   99: iload 4
    //   101: invokevirtual 256	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   104: astore 24
    //   106: aload 24
    //   108: ifnonnull +9 -> 117
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 23
    //   115: monitorexit
    //   116: return
    //   117: aload_0
    //   118: invokevirtual 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   121: new 204	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   124: dup
    //   125: aload 24
    //   127: invokespecial 294	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   130: astore 24
    //   132: aload_0
    //   133: aload 24
    //   135: invokevirtual 296	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   138: aload 24
    //   140: iload 22
    //   142: putfield 299	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   145: aload 24
    //   147: aload 12
    //   149: putfield 443	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardPath	Ljava/lang/String;
    //   152: aload 24
    //   154: lload_2
    //   155: putfield 302	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   158: aload 24
    //   160: aload 16
    //   162: putfield 447	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mForwardCallback	Lcom/tencent/mobileqq/filemanager/util/IForwardCallBack;
    //   165: aload 20
    //   167: ifnull +84 -> 251
    //   170: aload 20
    //   172: ldc_w 449
    //   175: invokevirtual 455	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   178: ifeq +19 -> 197
    //   181: aload 24
    //   183: aload 20
    //   185: ldc_w 449
    //   188: ldc_w 457
    //   191: invokevirtual 461	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   194: putfield 372	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkPackageName	Ljava/lang/String;
    //   197: aload 20
    //   199: ldc_w 463
    //   202: invokevirtual 455	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   205: ifeq +19 -> 224
    //   208: aload 24
    //   210: aload 20
    //   212: ldc_w 463
    //   215: ldc_w 457
    //   218: invokevirtual 461	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: putfield 376	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkName	Ljava/lang/String;
    //   224: aload 20
    //   226: ldc_w 465
    //   229: invokevirtual 455	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   232: ifeq +19 -> 251
    //   235: aload 24
    //   237: aload 20
    //   239: ldc_w 465
    //   242: ldc_w 457
    //   245: invokevirtual 461	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: putfield 380	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkIconUrl	Ljava/lang/String;
    //   251: iload 13
    //   253: ifne +195 -> 448
    //   256: aload 23
    //   258: astore 20
    //   260: aload 16
    //   262: lload 5
    //   264: invokestatic 468	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   267: iload 7
    //   269: lload_2
    //   270: invokestatic 468	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   273: iload 4
    //   275: aload 12
    //   277: aload 8
    //   279: aload 9
    //   281: lload 10
    //   283: iload_1
    //   284: lload 17
    //   286: iload 19
    //   288: invokeinterface 473 14 0
    //   293: lstore_2
    //   294: goto +3 -> 297
    //   297: aload 23
    //   299: astore 20
    //   301: aload 24
    //   303: iload 4
    //   305: putfield 305	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   308: aload 23
    //   310: astore 20
    //   312: aload 24
    //   314: iload 21
    //   316: putfield 476	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   319: aload 23
    //   321: astore 20
    //   323: aload_0
    //   324: getfield 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   327: iconst_0
    //   328: aload_0
    //   329: getfield 186	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   332: aload 24
    //   334: lload 5
    //   336: lload_2
    //   337: aload_0
    //   338: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver	Lcom/tencent/biz/troop/file/protocol/TroopFileReqCopyToObserver;
    //   341: invokestatic 481	com/tencent/biz/troop/file/TroopFileProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZJLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;JJLcom/tencent/biz/troop/file/protocol/TroopFileReqCopyToObserver;)V
    //   344: aload 23
    //   346: astore 20
    //   348: aload_0
    //   349: monitorexit
    //   350: aload 23
    //   352: astore 8
    //   354: aload 23
    //   356: monitorexit
    //   357: return
    //   358: aload 8
    //   360: astore 20
    //   362: aload_0
    //   363: monitorexit
    //   364: aload 9
    //   366: athrow
    //   367: aload 12
    //   369: astore 8
    //   371: aload 12
    //   373: monitorexit
    //   374: aload 9
    //   376: athrow
    //   377: astore 9
    //   379: aload 8
    //   381: astore 12
    //   383: goto -16 -> 367
    //   386: bipush 102
    //   388: istore 4
    //   390: goto +12 -> 402
    //   393: astore 9
    //   395: aload 23
    //   397: astore 8
    //   399: goto -41 -> 358
    //   402: iload 7
    //   404: sipush 3000
    //   407: if_icmpne +10 -> 417
    //   410: bipush 106
    //   412: istore 21
    //   414: goto -321 -> 93
    //   417: iload 7
    //   419: bipush 7
    //   421: if_icmpeq +20 -> 441
    //   424: iload 7
    //   426: sipush 6003
    //   429: if_icmpne +6 -> 435
    //   432: goto +9 -> 441
    //   435: iconst_3
    //   436: istore 21
    //   438: goto -345 -> 93
    //   441: bipush 38
    //   443: istore 21
    //   445: goto -352 -> 93
    //   448: lload 14
    //   450: lstore_2
    //   451: goto -154 -> 297
    //   454: astore 9
    //   456: aload 20
    //   458: astore 8
    //   460: goto -102 -> 358
    //   463: astore 9
    //   465: aload 23
    //   467: astore 12
    //   469: goto -102 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	TroopFileTransferManager
    //   0	472	1	paramInt1	int
    //   0	472	2	paramLong1	long
    //   0	472	4	paramInt2	int
    //   0	472	5	paramLong2	long
    //   0	472	7	paramInt3	int
    //   0	472	8	paramString1	String
    //   0	472	9	paramString2	String
    //   0	472	10	paramLong3	long
    //   0	472	12	paramString3	String
    //   0	472	13	paramBoolean	boolean
    //   0	472	14	paramLong4	long
    //   0	472	16	paramIForwardCallBack	IForwardCallBack
    //   0	472	17	paramLong5	long
    //   0	472	19	paramInt4	int
    //   2	442	21	i	int
    //   17	124	22	j	int
    //   23	443	23	localTroopFileManager	TroopFileManager
    //   76	257	24	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   354	357	377	finally
    //   364	367	377	finally
    //   371	374	377	finally
    //   52	67	393	finally
    //   67	78	393	finally
    //   83	90	393	finally
    //   93	106	393	finally
    //   111	113	393	finally
    //   117	165	393	finally
    //   170	197	393	finally
    //   197	224	393	finally
    //   224	251	393	finally
    //   260	294	454	finally
    //   301	308	454	finally
    //   312	319	454	finally
    //   323	344	454	finally
    //   348	350	454	finally
    //   362	364	454	finally
    //   28	30	463	finally
    //   113	116	463	finally
  }
  
  public void a(TroopFileInfo paramTroopFileInfo) {}
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = paramBoolean;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.e;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.b(paramTroopFileStatusInfo.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(paramTroopFileStatusInfo.a));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(FileManagerUtil.d(paramTroopFileStatusInfo.a));
    try
    {
      localFileManagerEntity.localModifyTime = new File(paramTroopFileStatusInfo.a).lastModified();
      label221:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label221;
    }
  }
  
  protected void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramItem, paramInt, 0);
  }
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2) {}
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo) {}
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramItem.FilePath;
      if (localObject == null) {
        return;
      }
      if (paramInt != 0)
      {
        if ((1 != NetworkUtil.getSystemNetwork(BaseApplication.getContext())) && (paramInt == 128))
        {
          paramItem.ThumbnailDownloading_Small = false;
          paramItem.ThumbnailFileTimeMS_Small = 0L;
        }
      }
      else if (!paramBoolean)
      {
        a(paramItem, 8);
        localObject = (TroopFileInfo)a().jdField_c_of_type_JavaUtilMap.get(paramItem.FilePath);
        if (localObject != null)
        {
          TroopFileInfo localTroopFileInfo = (TroopFileInfo)a().jdField_c_of_type_JavaUtilMap.get(((TroopFileInfo)localObject).g);
          if (localTroopFileInfo != null)
          {
            ((TroopFileInfo)localObject).e = 8;
            localTroopFileInfo.a((TroopFileInfo)localObject);
          }
        }
      }
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, paramInt, paramBoolean, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
      if ((!paramBoolean) && (paramInt == 0)) {
        TroopTechReportUtils.b();
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void a(Collection<String> paramCollection, boolean paramBoolean) {}
  
  public void a(List<TroopFileStatusInfo> paramList) {}
  
  public void a(UUID paramUUID) {}
  
  public final void a(UUID paramUUID, String paramString)
  {
    try
    {
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      if (paramUUID != null)
      {
        paramUUID.FilePath = paramString;
        paramUUID.BusId = 102;
      }
      return;
    }
    finally {}
  }
  
  protected boolean a()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (!bool) {
        return false;
      }
      bool = SerializableManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilMap, this.e);
      return bool;
    }
    finally {}
  }
  
  public boolean a(long paramLong, UUID paramUUID, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject2 = paramString2;
    synchronized (a())
    {
      Object localObject1 = localObject2;
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("/"))
          {
            paramString2 = new StringBuilder();
            paramString2.append("/");
            paramString2.append((String)localObject2);
            localObject1 = paramString2.toString();
          }
        }
        if (QLog.isColorLevel())
        {
          paramString2 = "";
          if (paramUUID != null) {
            paramString2 = paramUUID.toString();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("");
          QLog.d("TroopFileTransferManager", 2, String.format("finishCopyFrom - sessionId: %s, UUID: %s retCode: %d strNewPath:%s strErrorMsg:%s", new Object[] { ((StringBuilder)localObject2).toString(), paramString2, Integer.valueOf(paramInt), localObject1, paramString3 }));
        }
        paramString2 = null;
        if (paramUUID != null) {
          paramString2 = ???.a(paramUUID);
        }
        if (paramString1 != null) {
          paramString2 = ???.a(paramString1);
        }
        if (paramString2 == null) {
          return false;
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramString2.jdField_a_of_type_JavaUtilUUID);
        if (paramString1 == null) {
          return false;
        }
        if (paramString1.Status != 4) {
          return false;
        }
        if (paramInt < 0)
        {
          int i = 207;
          if (paramInt != -25087)
          {
            if (paramInt != -6101) {
              if (paramInt != -403) {
                if (paramInt != -36) {
                  if (paramInt != -30)
                  {
                    if ((paramInt != -25) && (paramInt != -22))
                    {
                      if ((paramInt == -20001) || (paramInt == -20000)) {
                        break label496;
                      }
                      if (paramInt != -4)
                      {
                        if (paramInt != -3)
                        {
                          if (TextUtils.isEmpty((CharSequence)localObject1))
                          {
                            if (TextUtils.isEmpty(paramString3)) {
                              paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.e, 5, 207);
                            } else {
                              paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.e, 5, 704, paramString3);
                            }
                            a(paramString1, 5, paramUUID);
                            return true;
                          }
                        }
                        else {
                          i = 202;
                        }
                      }
                      else {
                        i = 600;
                      }
                    }
                    else
                    {
                      i = 701;
                    }
                  }
                  else {
                    i = 705;
                  }
                }
              }
            }
            for (;;)
            {
              break;
              new Handler(Looper.getMainLooper()).postDelayed(new TroopFileTransferManager.10(this, paramString1), 1000L);
              return true;
              label496:
              paramUUID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
              if (paramUUID == null)
              {
                if (!TextUtils.isEmpty(paramString3))
                {
                  a(paramString1, 5, new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.e, 5, 704, paramString3));
                  return false;
                }
                paramUUID = new StringBuilder();
                paramUUID.append("finishCopyFrom, but entity is null!!!sessionId:");
                paramUUID.append(paramLong);
                QLog.e("TroopFileTransferManager", 1, paramUUID.toString());
              }
              else if (paramUUID.busId != 104)
              {
                paramUUID.busId = 104;
                paramString1.BusId = 104;
                if (paramUUID.nOpType == 27) {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramUUID, 27);
                } else if (paramUUID.nOpType == 26) {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(104, paramUUID);
                }
                if (QLog.isColorLevel()) {
                  QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", new Object[] { Integer.valueOf(paramInt) }));
                }
                return true;
                if ((!TextUtils.isEmpty(paramString1.LocalFile)) && (new File(paramString1.LocalFile).exists()))
                {
                  a(paramString1, 0);
                  paramString1.BusId = 102;
                  this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool[0].a(new TroopFileTransferManager.TaskScan(this, paramString1));
                  return true;
                }
                i = 603;
              }
            }
            a(paramString1, 5, i);
            return true;
          }
          a(paramString1, 5, new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.e, 5, 704, paramString3));
          return true;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (TextUtils.isEmpty(paramString3)) {
            paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.e, 5, 207);
          } else {
            paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.e, 5, 704, paramString3);
          }
          a(paramString1, 5, paramUUID);
          return true;
        }
        paramString2.b = ((String)localObject1);
        paramString1.FilePath = ((String)localObject1);
        paramUUID = paramString1.getInfo(this.e);
        if (paramUUID != null) {
          paramUUID.e = ((String)localObject1);
        }
        paramUUID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1.entrySessionID);
        if (paramUUID != null)
        {
          paramUUID.strTroopFilePath = ((String)localObject1);
          paramString3 = FileManagerUtil.e(paramUUID);
          paramUUID.strQRUrl = paramString3;
          paramString1.strQRUrl = paramString3;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(paramString2.b, paramString2);
        }
        a(paramString1, 6, 0);
        c(paramString1);
        return true;
      }
      finally {}
    }
    for (;;)
    {
      throw paramUUID;
    }
  }
  
  protected final boolean a(TroopFileTransferManager.Item paramItem)
  {
    boolean bool1 = false;
    if (paramItem == null) {
      return false;
    }
    int i = paramItem.Status;
    if ((i == 6) || (i == 11))
    {
      boolean bool2 = TextUtils.isEmpty(paramItem.LocalFile);
      String str = "null";
      StringBuilder localStringBuilder;
      if (!bool2)
      {
        if (new File(paramItem.LocalFile).exists()) {
          break label215;
        }
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramItem.Id != null) {
          str = paramItem.Id.toString();
        }
        localStringBuilder.append(str);
        localStringBuilder.append("] check localfile is not exsit. set to nodownload state");
        TroopFileTransferUtil.Log.b("TroopFileTransferManager", i, localStringBuilder.toString());
        a(paramItem, 7);
      }
      else
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramItem.Id != null) {
          str = paramItem.Id.toString();
        }
        localStringBuilder.append(str);
        localStringBuilder.append("] check localfile=null. set to nodownload state");
        TroopFileTransferUtil.Log.b("TroopFileTransferManager", i, localStringBuilder.toString());
        a(paramItem, 7);
      }
      bool1 = true;
    }
    label215:
    if ((!paramItem.ThumbnailDownloading_Small) && (!paramItem.ThumbnailDownloading_Large))
    {
      if (paramItem.ThumbnailDownloading_Middle) {
        return bool1;
      }
      if ((paramItem.HasThumbnailFile_Small) && (!a(paramItem, 128))) {
        return true;
      }
      if ((paramItem.HasThumbnailFile_Large) && (!a(paramItem, 640))) {
        return true;
      }
      if ((paramItem.HasThumbnailFile_Middle) && (!a(paramItem, 383))) {
        return true;
      }
      return bool1;
    }
    return bool1;
  }
  
  protected boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramString1 = UUID.fromString(paramString1);
      if (paramString1 == null) {
        return false;
      }
      c();
      paramString1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (paramString1 == null) {
        return false;
      }
      paramString1.NameForSave = paramString2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_PATH);
      localStringBuilder.append(paramString2);
      paramString1.LocalFile = localStringBuilder.toString();
      b(paramString1);
      ((TroopFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).a(paramString1.getInfo(this.e));
      return true;
    }
    finally {}
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt, TroopFileReqDownloadFileObserver paramTroopFileReqDownloadFileObserver)
  {
    synchronized (a())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, paramLong, paramInt);
        if (localTroopFileInfo == null) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("startDownload==>");
          paramString1.append(localTroopFileInfo.toString());
          QLog.d("TroopFileTransferManager", 2, paramString1.toString());
        }
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
        paramString1 = localItem;
        if (localItem == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramString1);
        }
        paramString1.FileName = paramString2;
        paramString1.ProgressTotal = paramLong;
        paramString1.ProgressValue = localTroopFileInfo.d;
        TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramString1, 0, false, true, paramTroopFileReqDownloadFileObserver);
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(UUID paramUUID)
  {
    return false;
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    return false;
  }
  
  public final boolean a(UUID paramUUID, int paramInt, String paramString1, String paramString2)
  {
    return a(0L, paramUUID, null, paramInt, paramString1, paramString2);
  }
  
  public final int[] a()
  {
    for (;;)
    {
      try
      {
        c();
        arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      }
      finally
      {
        int[] arrayOfInt;
        Iterator localIterator;
        TroopFileTransferManager.Item localItem;
        int i;
        continue;
        throw localObject;
        continue;
        localObject[0] += 1;
        continue;
      }
      if (!localIterator.hasNext()) {
        continue;
      }
      localItem = (TroopFileTransferManager.Item)localIterator.next();
      if (localItem != null)
      {
        i = localItem.Status;
        if ((i != 0) && (i != 1))
        {
          if ((i == 2) || (i == 3)) {
            continue;
          }
        }
        else
        {
          arrayOfInt[0] += 1;
          arrayOfInt[1] += 1;
        }
      }
    }
    return arrayOfInt;
  }
  
  protected void b()
  {
    e();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    h();
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (!bool) {
        return false;
      }
      bool = c();
      return bool;
    }
    finally {}
  }
  
  protected final boolean b(TroopFileTransferManager.Item paramItem)
  {
    for (;;)
    {
      try
      {
        if (paramItem.Pausing != 0)
        {
          if (paramItem.Pausing == 1)
          {
            i = 2;
            a(paramItem, i);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      int i = 3;
    }
  }
  
  public boolean b(UUID paramUUID)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqFeedsObserver);
  }
  
  protected final boolean c()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilMap.values();
      localObject1 = ((Collection)localObject1).iterator();
      boolean bool = false;
      while (((Iterator)localObject1).hasNext()) {
        bool |= a((TroopFileTransferManager.Item)((Iterator)localObject1).next());
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected final boolean c(TroopFileTransferManager.Item paramItem)
  {
    for (;;)
    {
      try
      {
        if (paramItem.Pausing != 0)
        {
          if (paramItem.Pausing == 1)
          {
            i = 9;
            a(paramItem, i);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      int i = 10;
    }
  }
  
  public boolean c(UUID paramUUID)
  {
    return false;
  }
  
  protected void d() {}
  
  protected void d(TroopFileTransferManager.Item paramItem) {}
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null;
  }
  
  public boolean d(UUID paramUUID)
  {
    return false;
  }
  
  protected void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        while (localIterator.hasNext())
        {
          TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
          int i = localItem.Status;
          if ((i == 0) || (i == 1) || (i == 8)) {
            localItem.Pausing = -1;
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
  
  protected void e(TroopFileTransferManager.Item paramItem)
  {
    a(paramItem, 1);
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, paramItem, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqUploadFileObserver);
  }
  
  public boolean e(UUID paramUUID)
  {
    return false;
  }
  
  public final boolean f(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null) {
          return false;
        }
        int i = paramUUID.Status;
        if ((i != 2) && (i != 3) && (i != 6) && (i != 7)) {}
        StringBuilder localStringBuilder;
        switch (i)
        {
        case 9: 
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("deleteItem error, status:");
            localStringBuilder.append(paramUUID.Status);
            QLog.e("TroopFileTransferManager", 4, localStringBuilder.toString());
          }
          return false;
        case 10: 
          if (paramUUID.TmpFile != null) {
            new File(paramUUID.TmpFile).delete();
          }
        case 11: 
          paramUUID.deleteThumbnailFile(this.e, 128);
          paramUUID.deleteThumbnailFile(this.e, 640);
          paramUUID.deleteThumbnailFile(this.e, 383);
          if (QLog.isDevelopLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("delete ");
            localStringBuilder.append(paramUUID.Id);
            localStringBuilder.append("[");
            localStringBuilder.append(paramUUID.FilePath);
            localStringBuilder.append("]");
            localStringBuilder.append(paramUUID.Status);
            QLog.d("TroopFileTransferManager", 4, localStringBuilder.toString());
          }
          f(paramUUID);
          return true;
        }
      }
      finally {}
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("");
        QLog.d("param_WIFIGroupFileDownloadFlow", 4, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = 0L;
    }
    if (this.jdField_b_of_type_Long != 0L) {
      this.jdField_b_of_type_Long = 0L;
    }
    if (((this.d != 0L) || (this.jdField_c_of_type_Long == 0L)) || (this.jdField_c_of_type_Long != 0L))
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_c_of_type_Long);
        localStringBuilder.append("");
        QLog.d("param_XGGroupFileDownloadFlow", 4, localStringBuilder.toString());
      }
      this.jdField_c_of_type_Long = 0L;
    }
    if (this.d != 0L)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d);
        localStringBuilder.append("");
        QLog.d("param_XGGroupFileUploadFlow", 4, localStringBuilder.toString());
      }
      this.d = 0L;
    }
  }
  
  protected final void h()
  {
    for (;;)
    {
      try
      {
        if (this.f == 0L)
        {
          i = 1;
          this.f = SystemClock.uptimeMillis();
          if (i != 0) {
            ThreadManager.post(new TroopFileTransferManager.11(this), 5, null, true);
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  protected void j()
  {
    try
    {
      c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause == 2) {
          localItem.W2MPause = 1;
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
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "onNetWifi2Mobile");
      }
      boolean bool = this.jdField_b_of_type_Boolean;
      if (!bool) {
        return;
      }
      int i = 0;
      paramString = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (paramString.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)paramString.next();
        int j = localItem.Status;
        if (((j == 0) || (j == 1) || (j == 8)) && (localItem.Pausing == 0))
        {
          localItem.Pausing = 1;
          localItem.W2MPause = 2;
          i = 1;
        }
      }
      if (i != 0) {
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.e, 107);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetWifi2None");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager
 * JD-Core Version:    0.7.0.1
 */
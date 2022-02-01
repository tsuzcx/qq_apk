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
  private static Map<Long, TroopFileTransferManager> a;
  private TroopFileManager b;
  private ProxyIpManager c;
  private TroopFileReqResendFileObserver d = new TroopFileTransferManager.3(this);
  protected long e = 0L;
  protected long f = 0L;
  protected long g = 0L;
  protected long h = 0L;
  public TroopFileTransferManager.TaskPool[] i = { new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2) };
  protected QQAppInterface j;
  protected long k;
  protected Map<UUID, TroopFileTransferManager.Item> l;
  protected Map<UUID, Integer> m;
  protected boolean n = false;
  public boolean o = false;
  private TroopFileReqUploadFileObserver p = new TroopFileTransferManager.4(this);
  private TroopFileReqFeedsObserver q = new TroopFileTransferManager.5(this);
  private TroopFileGetOneFileInfoObserver r = new TroopFileTransferManager.6(this);
  private TroopFileReqDownloadFileObserver s = new TroopFileTransferManager.7(this);
  private TroopFileReqCopyToObserver t = new TroopFileTransferManager.8(this);
  private TroopFileReqCopyToObserver u = new TroopFileTransferManager.9(this);
  private volatile long v;
  
  public static TroopFileTransferManager a(long paramLong)
  {
    try
    {
      TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)a.get(Long.valueOf(paramLong));
      return localTroopFileTransferManager;
    }
    finally {}
  }
  
  public static TroopFileTransferManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if (a == null)
      {
        a = new HashMap();
        ThreadManager.post(new TroopFileTransferManager.1(), 2, null, true);
      }
      TroopFileUploadingManager.a(paramQQAppInterface);
      Object localObject2 = (TroopFileTransferManager)a.get(Long.valueOf(paramLong));
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((TroopFileTransferManager)localObject2).j != paramQQAppInterface)
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
        a.put(Long.valueOf(paramLong), localObject2);
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
          this.f += paramLong;
        } else if (paramInt == 1) {
          this.e += paramLong;
        }
      }
      else
      {
        if (paramInt == 0) {
          this.h += paramLong;
        } else if (paramInt == 1) {
          this.g += paramLong;
        }
        m();
      }
      return;
    }
    finally {}
  }
  
  public static void b(long paramLong)
  {
    try
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        if (localTroopFileTransferManager.k == paramLong) {
          localTroopFileTransferManager.d();
        } else {
          localTroopFileTransferManager.r();
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
  
  private final void c(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    TroopFileError.a(this.j, this.k, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  public static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileTransferManager", 2, "TroopFileTransferManager.ReleaseAll called!");
    }
    try
    {
      if (a == null) {
        return;
      }
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).b();
      }
      a.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private final void i(TroopFileTransferManager.Item paramItem)
  {
    paramItem.ErrorCode = 0;
    b(paramItem, 12);
  }
  
  public static void q()
  {
    try
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).r();
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
      Object localObject = h().a(paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, 102);
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
      ((TroopFileInfo)localObject).w = paramFileManagerEntity.strThumbPath;
      ((TroopFileInfo)localObject).y = paramFileManagerEntity.strMiddleThumPath;
      ((TroopFileInfo)localObject).x = paramFileManagerEntity.strLargeThumPath;
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
      paramFileManagerEntity = ((TroopFileTransferManager.Item)localObject).getInfo(this.k);
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
      localObject2 = TroopFileTransferUtil.e(paramString);
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
    localObject2 = this.l.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)((Iterator)localObject2).next();
      if ((paramString.equals(localItem.FilePath)) || (((String)localObject1).equals(localItem.FilePath)))
      {
        paramString = localItem.getInfo(this.k);
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
      paramString1 = h().c(paramString1, paramString2, paramLong1, 102);
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
      paramString1 = paramString1.getInfo(this.k);
      return paramString1;
    }
    finally {}
  }
  
  public final TroopFileStatusInfo a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramString1 = h().a(paramString2, paramLong1, 102);
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
      paramString1 = paramString1.getInfo(this.k);
      return paramString1;
    }
    finally {}
  }
  
  public TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    return null;
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    return null;
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
    //   4: new 402	java/util/Random
    //   7: dup
    //   8: invokespecial 403	java/util/Random:<init>	()V
    //   11: invokevirtual 406	java/util/Random:nextInt	()I
    //   14: invokestatic 412	java/lang/Math:abs	(I)I
    //   17: istore 22
    //   19: aload_0
    //   20: invokevirtual 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:h	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
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
    //   53: getfield 414	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   56: ifnonnull +11 -> 67
    //   59: aload_0
    //   60: aload_0
    //   61: invokevirtual 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:h	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   64: putfield 414	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   67: aload_0
    //   68: getfield 414	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   71: aload 12
    //   73: invokevirtual 417	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   76: astore 24
    //   78: aload 24
    //   80: ifnull +306 -> 386
    //   83: aload 24
    //   85: getfield 419	com/tencent/mobileqq/troop/data/TroopFileInfo:f	I
    //   88: istore 4
    //   90: goto +312 -> 402
    //   93: aload 23
    //   95: aload 8
    //   97: lload 10
    //   99: iload 4
    //   101: invokevirtual 269	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   104: astore 24
    //   106: aload 24
    //   108: ifnonnull +9 -> 117
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 23
    //   115: monitorexit
    //   116: return
    //   117: aload_0
    //   118: invokevirtual 287	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   121: new 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   124: dup
    //   125: aload 24
    //   127: invokespecial 308	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   130: astore 24
    //   132: aload_0
    //   133: aload 24
    //   135: invokevirtual 310	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   138: aload 24
    //   140: iload 22
    //   142: putfield 313	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   145: aload 24
    //   147: aload 12
    //   149: putfield 422	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardPath	Ljava/lang/String;
    //   152: aload 24
    //   154: lload_2
    //   155: putfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   158: aload 24
    //   160: aload 16
    //   162: putfield 426	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mForwardCallback	Lcom/tencent/mobileqq/filemanager/util/IForwardCallBack;
    //   165: aload 20
    //   167: ifnull +84 -> 251
    //   170: aload 20
    //   172: ldc_w 428
    //   175: invokevirtual 434	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   178: ifeq +19 -> 197
    //   181: aload 24
    //   183: aload 20
    //   185: ldc_w 428
    //   188: ldc_w 436
    //   191: invokevirtual 440	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   194: putfield 386	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkPackageName	Ljava/lang/String;
    //   197: aload 20
    //   199: ldc_w 442
    //   202: invokevirtual 434	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   205: ifeq +19 -> 224
    //   208: aload 24
    //   210: aload 20
    //   212: ldc_w 442
    //   215: ldc_w 436
    //   218: invokevirtual 440	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: putfield 390	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkName	Ljava/lang/String;
    //   224: aload 20
    //   226: ldc_w 444
    //   229: invokevirtual 434	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   232: ifeq +19 -> 251
    //   235: aload 24
    //   237: aload 20
    //   239: ldc_w 444
    //   242: ldc_w 436
    //   245: invokevirtual 440	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: putfield 394	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkIconUrl	Ljava/lang/String;
    //   251: iload 13
    //   253: ifne +195 -> 448
    //   256: aload 23
    //   258: astore 20
    //   260: aload 16
    //   262: lload 5
    //   264: invokestatic 447	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   267: iload 7
    //   269: lload_2
    //   270: invokestatic 447	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   273: iload 4
    //   275: aload 12
    //   277: aload 8
    //   279: aload 9
    //   281: lload 10
    //   283: iload_1
    //   284: lload 17
    //   286: iload 19
    //   288: invokeinterface 452 14 0
    //   293: lstore_2
    //   294: goto +3 -> 297
    //   297: aload 23
    //   299: astore 20
    //   301: aload 24
    //   303: iload 4
    //   305: putfield 319	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   308: aload 23
    //   310: astore 20
    //   312: aload 24
    //   314: iload 21
    //   316: putfield 455	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   319: aload 23
    //   321: astore 20
    //   323: aload_0
    //   324: getfield 144	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:j	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   327: iconst_0
    //   328: aload_0
    //   329: getfield 210	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:k	J
    //   332: aload 24
    //   334: lload 5
    //   336: lload_2
    //   337: aload_0
    //   338: getfield 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:u	Lcom/tencent/biz/troop/file/protocol/TroopFileReqCopyToObserver;
    //   341: invokestatic 460	com/tencent/biz/troop/file/TroopFileProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZJLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;JJLcom/tencent/biz/troop/file/protocol/TroopFileReqCopyToObserver;)V
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
    //   2	442	21	i1	int
    //   17	124	22	i2	int
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
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.d);
    localFileManagerEntity.peerNick = ContactUtils.i(this.j, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = paramBoolean;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.k;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.e(paramTroopFileStatusInfo.k));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.d(paramTroopFileStatusInfo.k));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(FileManagerUtil.g(paramTroopFileStatusInfo.k));
    try
    {
      localFileManagerEntity.localModifyTime = new File(paramTroopFileStatusInfo.k).lastModified();
      label221:
      this.j.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.j.getFileManagerDataCenter().c(localFileManagerEntity);
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
      this.l.put(paramItem.Id, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
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
        b(paramItem, 8);
        localObject = (TroopFileInfo)h().f.get(paramItem.FilePath);
        if (localObject != null)
        {
          TroopFileInfo localTroopFileInfo = (TroopFileInfo)h().f.get(((TroopFileInfo)localObject).o);
          if (localTroopFileInfo != null)
          {
            ((TroopFileInfo)localObject).p = 8;
            localTroopFileInfo.a((TroopFileInfo)localObject);
          }
        }
      }
      TroopFileProtocol.a(this.j, this.k, paramItem, paramInt, paramBoolean, false, this.s);
      if ((!paramBoolean) && (paramInt == 0)) {
        TroopTechReportUtils.b();
      }
      return;
    }
    finally {}
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean) {}
  
  public void a(List<TroopFileStatusInfo> paramList) {}
  
  public void a(UUID paramUUID) {}
  
  public final void a(UUID paramUUID, String paramString)
  {
    try
    {
      paramUUID = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      if (paramUUID != null)
      {
        paramUUID.FilePath = paramString;
        paramUUID.BusId = 102;
      }
      return;
    }
    finally {}
  }
  
  public boolean a(long paramLong, UUID paramUUID, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject2 = paramString2;
    synchronized (h())
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
        paramString1 = (TroopFileTransferManager.Item)this.l.get(paramString2.b);
        if (paramString1 == null) {
          return false;
        }
        if (paramString1.Status != 4) {
          return false;
        }
        if (paramInt < 0)
        {
          int i1 = 207;
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
                              paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.k, 5, 207);
                            } else {
                              paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.k, 5, 704, paramString3);
                            }
                            a(paramString1, 5, paramUUID);
                            return true;
                          }
                        }
                        else {
                          i1 = 202;
                        }
                      }
                      else {
                        i1 = 600;
                      }
                    }
                    else
                    {
                      i1 = 701;
                    }
                  }
                  else {
                    i1 = 705;
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
              paramUUID = this.j.getFileManagerDataCenter().a(paramLong);
              if (paramUUID == null)
              {
                if (!TextUtils.isEmpty(paramString3))
                {
                  a(paramString1, 5, new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.k, 5, 704, paramString3));
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
                  this.j.getFileManagerEngine().c(paramUUID, 27);
                } else if (paramUUID.nOpType == 26) {
                  this.j.getFileTransferHandler().a(104, paramUUID);
                }
                if (QLog.isColorLevel()) {
                  QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", new Object[] { Integer.valueOf(paramInt) }));
                }
                return true;
                if ((!TextUtils.isEmpty(paramString1.LocalFile)) && (new File(paramString1.LocalFile).exists()))
                {
                  b(paramString1, 0);
                  paramString1.BusId = 102;
                  this.i[0].a(new TroopFileTransferManager.TaskScan(this, paramString1));
                  return true;
                }
                i1 = 603;
              }
            }
            a(paramString1, 5, i1);
            return true;
          }
          a(paramString1, 5, new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.k, 5, 704, paramString3));
          return true;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (TextUtils.isEmpty(paramString3)) {
            paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.k, 5, 207);
          } else {
            paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.k, 5, 704, paramString3);
          }
          a(paramString1, 5, paramUUID);
          return true;
        }
        paramString2.c = ((String)localObject1);
        paramString1.FilePath = ((String)localObject1);
        paramUUID = paramString1.getInfo(this.k);
        if (paramUUID != null) {
          paramUUID.r = ((String)localObject1);
        }
        paramUUID = this.j.getFileManagerDataCenter().a(paramString1.entrySessionID);
        if (paramUUID != null)
        {
          paramUUID.strTroopFilePath = ((String)localObject1);
          paramString3 = FileManagerUtil.r(paramUUID);
          paramUUID.strQRUrl = paramString3;
          paramString1.strQRUrl = paramString3;
        }
        if (this.b != null) {
          this.b.a(paramString2.c, paramString2);
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
      paramString1 = (TroopFileTransferManager.Item)this.l.get(paramString1);
      if (paramString1 == null) {
        return false;
      }
      paramString1.NameForSave = paramString2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_PATH);
      localStringBuilder.append(paramString2);
      paramString1.LocalFile = localStringBuilder.toString();
      b(paramString1);
      ((TroopFileHandler)this.j.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).a(paramString1.getInfo(this.k));
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
    synchronized (h())
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
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(localTroopFileInfo.b);
        paramString1 = localItem;
        if (localItem == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramString1);
        }
        paramString1.FileName = paramString2;
        paramString1.ProgressTotal = paramLong;
        paramString1.ProgressValue = localTroopFileInfo.r;
        TroopFileProtocol.a(this.j, this.k, paramString1, 0, false, true, paramTroopFileReqDownloadFileObserver);
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    return false;
  }
  
  public final boolean a(UUID paramUUID, int paramInt, String paramString1, String paramString2)
  {
    return a(0L, paramUUID, null, paramInt, paramString1, paramString2);
  }
  
  protected void b()
  {
    e();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    n();
  }
  
  public final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramItem, paramInt, 0);
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public boolean b(UUID paramUUID)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    TroopFileProtocol.a(this.j, this.k, paramItem, this.q);
  }
  
  public boolean c(UUID paramUUID)
  {
    return false;
  }
  
  protected void d() {}
  
  protected void d(TroopFileTransferManager.Item paramItem) {}
  
  public boolean d(UUID paramUUID)
  {
    return false;
  }
  
  protected void e()
  {
    try
    {
      if (this.l != null)
      {
        Iterator localIterator = this.l.values().iterator();
        while (localIterator.hasNext())
        {
          TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
          int i1 = localItem.Status;
          if ((i1 == 0) || (i1 == 1) || (i1 == 8)) {
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
    b(paramItem, 1);
    TroopFileProtocol.a(this.j, this.k, paramItem, this.p);
  }
  
  public boolean e(UUID paramUUID)
  {
    return false;
  }
  
  protected boolean f()
  {
    try
    {
      boolean bool = this.n;
      if (!bool) {
        return false;
      }
      bool = SerializableManager.a(this.j, this.l, this.k);
      return bool;
    }
    finally {}
  }
  
  protected final boolean f(TroopFileTransferManager.Item paramItem)
  {
    boolean bool1 = false;
    if (paramItem == null) {
      return false;
    }
    int i1 = paramItem.Status;
    if ((i1 == 6) || (i1 == 11))
    {
      boolean bool2 = TextUtils.isEmpty(paramItem.LocalFile);
      String str = "null";
      StringBuilder localStringBuilder;
      if (!bool2)
      {
        if (new File(paramItem.LocalFile).exists()) {
          break label215;
        }
        i1 = TroopFileTransferUtil.Log.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramItem.Id != null) {
          str = paramItem.Id.toString();
        }
        localStringBuilder.append(str);
        localStringBuilder.append("] check localfile is not exsit. set to nodownload state");
        TroopFileTransferUtil.Log.b("TroopFileTransferManager", i1, localStringBuilder.toString());
        b(paramItem, 7);
      }
      else
      {
        i1 = TroopFileTransferUtil.Log.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        if (paramItem.Id != null) {
          str = paramItem.Id.toString();
        }
        localStringBuilder.append(str);
        localStringBuilder.append("] check localfile=null. set to nodownload state");
        TroopFileTransferUtil.Log.b("TroopFileTransferManager", i1, localStringBuilder.toString());
        b(paramItem, 7);
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
  
  public boolean f(UUID paramUUID)
  {
    return false;
  }
  
  public final TroopFileStatusInfo g(UUID paramUUID)
  {
    try
    {
      c();
      paramUUID = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      if (paramUUID == null) {
        return null;
      }
      paramUUID = paramUUID.getInfo(this.k);
      return paramUUID;
    }
    finally {}
  }
  
  protected final boolean g(TroopFileTransferManager.Item paramItem)
  {
    for (;;)
    {
      try
      {
        if (paramItem.Pausing != 0)
        {
          if (paramItem.Pausing == 1)
          {
            i1 = 2;
            b(paramItem, i1);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      int i1 = 3;
    }
  }
  
  protected TroopFileManager h()
  {
    if (this.b == null) {
      this.b = TroopFileManager.a(this.j, this.k);
    }
    return this.b;
  }
  
  protected final boolean h(TroopFileTransferManager.Item paramItem)
  {
    for (;;)
    {
      try
      {
        if (paramItem.Pausing != 0)
        {
          if (paramItem.Pausing == 1)
          {
            i1 = 9;
            b(paramItem, i1);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      int i1 = 10;
    }
  }
  
  public final boolean h(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.l.get(paramUUID);
        if (paramUUID == null) {
          return false;
        }
        int i1 = paramUUID.Status;
        if ((i1 != 2) && (i1 != 3) && (i1 != 6) && (i1 != 7)) {}
        StringBuilder localStringBuilder;
        switch (i1)
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
          paramUUID.deleteThumbnailFile(this.k, 128);
          paramUUID.deleteThumbnailFile(this.k, 640);
          paramUUID.deleteThumbnailFile(this.k, 383);
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
          i(paramUUID);
          return true;
        }
      }
      finally {}
    }
  }
  
  public TroopFileTransferManager.Item i(UUID paramUUID)
  {
    try
    {
      Map localMap = this.l;
      if (localMap == null) {
        return null;
      }
      if (paramUUID != null)
      {
        paramUUID = (TroopFileTransferManager.Item)this.l.get(paramUUID);
        return paramUUID;
      }
      throw new NullPointerException("TroopFileTransferManager getItem id is Null");
    }
    finally {}
  }
  
  protected ProxyIpManager i()
  {
    QQAppInterface localQQAppInterface = this.j;
    if (localQQAppInterface == null) {
      return null;
    }
    if (this.c == null) {
      this.c = ((ProxyIpManager)localQQAppInterface.getManager(3));
    }
    return this.c;
  }
  
  public final List<TroopFileStatusInfo> j()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.l.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem != null) && (localItem.FilePath != null)) {
          localArrayList.add(localItem.getInfo(this.k));
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
  
  public final int[] k()
  {
    for (;;)
    {
      try
      {
        c();
        arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        localIterator = this.l.values().iterator();
      }
      finally
      {
        int[] arrayOfInt;
        Iterator localIterator;
        TroopFileTransferManager.Item localItem;
        int i1;
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
        i1 = localItem.Status;
        if ((i1 != 0) && (i1 != 1))
        {
          if ((i1 == 2) || (i1 == 3)) {
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
  
  public final Collection<TroopFileStatusInfo> l()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.l.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TroopFileTransferManager.Item)localIterator.next()).getInfo(this.k));
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void m()
  {
    if (this.j == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (this.e != 0L)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.e);
        localStringBuilder.append("");
        QLog.d("param_WIFIGroupFileDownloadFlow", 4, localStringBuilder.toString());
      }
      this.e = 0L;
    }
    if (this.f != 0L) {
      this.f = 0L;
    }
    if (((this.h != 0L) || (this.g == 0L)) || (this.g != 0L))
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.g);
        localStringBuilder.append("");
        QLog.d("param_XGGroupFileDownloadFlow", 4, localStringBuilder.toString());
      }
      this.g = 0L;
    }
    if (this.h != 0L)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.h);
        localStringBuilder.append("");
        QLog.d("param_XGGroupFileUploadFlow", 4, localStringBuilder.toString());
      }
      this.h = 0L;
    }
  }
  
  protected final void n()
  {
    for (;;)
    {
      try
      {
        if (this.v == 0L)
        {
          i1 = 1;
          this.v = SystemClock.uptimeMillis();
          if (i1 != 0) {
            ThreadManager.post(new TroopFileTransferManager.11(this), 5, null, true);
          }
          return;
        }
      }
      finally {}
      int i1 = 0;
    }
  }
  
  public final boolean o()
  {
    try
    {
      boolean bool = this.n;
      if (!bool) {
        return false;
      }
      bool = p();
      return bool;
    }
    finally {}
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
      boolean bool = this.n;
      if (!bool) {
        return;
      }
      int i1 = 0;
      paramString = this.l.values().iterator();
      while (paramString.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)paramString.next();
        int i2 = localItem.Status;
        if (((i2 == 0) || (i2 == 1) || (i2 == 8)) && (localItem.Pausing == 0))
        {
          localItem.Pausing = 1;
          localItem.W2MPause = 2;
          i1 = 1;
        }
      }
      if (i1 != 0) {
        TroopFileError.a(this.j, this.k, 107);
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
  
  protected final boolean p()
  {
    try
    {
      Object localObject1 = this.l.values();
      localObject1 = ((Collection)localObject1).iterator();
      boolean bool = false;
      while (((Iterator)localObject1).hasNext()) {
        bool |= f((TroopFileTransferManager.Item)((Iterator)localObject1).next());
      }
      return bool;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void r()
  {
    try
    {
      c();
      Iterator localIterator = this.l.values().iterator();
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
  
  public boolean s()
  {
    return this.j == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager
 * JD-Core Version:    0.7.0.1
 */
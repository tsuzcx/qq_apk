package com.tencent.mobileqq.troop.filemanager;

import ajlc;
import ajld;
import ajlf;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.FileUploadMgrObserver;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item.W2MPauseEnum;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TroopFileTransferMgr
  extends TroopFileTransferManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public int a;
  protected TroopFileDownloadMgr.FileDownloadMgrObserver a;
  protected TroopFileUploadMgr.FileUploadMgrObserver a;
  public int b;
  
  static
  {
    if (!TroopFileTransferMgr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public TroopFileTransferMgr(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = paramLong;
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      if ((paramBoolean) || (Thread.currentThread() != jdField_a_of_type_AndroidOsHandler.getLooper().getThread()))
      {
        jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
        return;
      }
    }
    finally {}
    paramRunnable.run();
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      TroopFileInfo localTroopFileInfo;
      TroopFileTransferManager.Item localItem;
      synchronized (a()) {}
      int i = 0;
    }
  }
  
  public TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
    try
    {
      paramString2 = ???.a(paramString2, paramLong2, 102);
      if (paramString2 == null) {
        return null;
      }
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      paramString2.RandomNum = paramInt2;
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = paramLong1;
      paramString2.ForwardBusId = paramInt1;
      paramString2.Status = 4;
      paramString2.LocalFile = paramString3;
      paramString2.entrySessionID = paramLong3;
      paramString1 = (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramLong1), 1, paramString1);
      if (paramString1 != null)
      {
        paramString2.width = paramString1.width;
        paramString2.height = paramString1.height;
      }
      a(paramString2);
      paramString1 = TroopFileToTroopForwarder.a(this.e, paramString2);
      if (paramString1 == null)
      {
        return null;
        paramString1 = finally;
        throw paramString1;
      }
      paramString1.a();
      paramString1 = paramString2.getInfo(this.e);
      return paramString1;
    }
    finally {}
  }
  
  public TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, paramLong, paramInt);
      if (localTroopFileInfo == null) {
        return null;
      }
      c();
      int i = 0;
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localTroopFileInfo.a);
      if (localItem == null)
      {
        paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
        paramInt = 1;
      }
      do
      {
        do
        {
          paramString1.FileName = paramString2;
          paramString1.ProgressTotal = paramLong;
          paramString1.ProgressValue = 0L;
          if (paramInt != 0) {
            a(paramString1);
          }
          TroopFileDownloadMgr.a().a(this.e, paramString1, null);
          paramString2 = FileUtil.a(paramString2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", this.e + "", paramString2, "");
          paramString1 = paramString1.getInfo(this.e);
          return paramString1;
          paramString1 = finally;
          throw paramString1;
          paramString1 = localItem;
          paramInt = i;
        } while (localItem.Status == 7);
        if (localItem.Status != 11) {
          break;
        }
        paramString1 = localItem;
        paramInt = i;
      } while (!FileUtils.a(localTroopFileInfo.h));
      return null;
    }
    finally {}
  }
  
  public TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      Object localObject = ???.b(paramString);
      if (localObject == null) {
        return null;
      }
      c();
      localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
      ((TroopFileTransferManager.Item)localObject).BusId = 102;
      ((TroopFileTransferManager.Item)localObject).isFromAIO = paramBoolean;
      ((TroopFileTransferManager.Item)localObject).RandomNum = paramInt;
      paramString = new File(paramString);
      if (paramString.exists()) {
        ((TroopFileTransferManager.Item)localObject).origLastModifyTime = paramString.lastModified();
      }
      a((TroopFileTransferManager.Item)localObject);
      if (NetworkUtil.a(BaseApplication.getContext()) == 0)
      {
        a((TroopFileTransferManager.Item)localObject, 3, 106);
        paramString = ((TroopFileTransferManager.Item)localObject).getInfo(this.e);
        return paramString;
        paramString = finally;
        throw paramString;
      }
      TroopFileUploadMgr.a().a(this.e, (TroopFileTransferManager.Item)localObject, null);
      paramString = ((TroopFileTransferManager.Item)localObject).getInfo(this.e);
      return paramString;
    }
    finally {}
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      if ((paramBoolean) && (localItem != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.e, paramUUID);
      }
      return localItem;
    }
    finally {}
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver = new ajlc(this);
      TroopFileUploadMgr.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver = new ajld(this);
      TroopFileDownloadMgr.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver);
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "init");
  }
  
  protected void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramItem);
      if (paramItem.troopuin == 0L) {
        paramItem.troopuin = this.e;
      }
      if (paramItem.troopuin != this.e)
      {
        TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "newItem troop confit. item.troopuin:" + paramItem.troopuin + " mTroopUin" + this.e);
        paramItem.troopuin = this.e;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramItem, null);
      return;
    }
    finally {}
  }
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    try
    {
      TroopFileDataCenter.a(this.e, paramItem, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    try
    {
      TroopFileDataCenter.a(this.e, paramItem, paramInt, paramSimpleErrorInfo);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  @Deprecated
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "!!!warning: oldver fun: doReqDownload be called");
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +9 -> 24
    //   18: aload_0
    //   19: monitorexit
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: aload 6
    //   26: aload_2
    //   27: lload_3
    //   28: bipush 25
    //   30: invokevirtual 219	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +15 -> 50
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 6
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload 6
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   54: new 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: putfield 225	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardPath	Ljava/lang/String;
    //   68: aload_2
    //   69: aload_0
    //   70: getfield 29	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokevirtual 436	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   76: invokestatic 441	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   79: invokevirtual 444	java/lang/Long:longValue	()J
    //   82: putfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   85: aload_2
    //   86: iload 5
    //   88: putfield 231	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   91: aload_2
    //   92: iconst_4
    //   93: putfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   96: aload_2
    //   97: bipush 25
    //   99: putfield 314	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual 163	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   107: aload_0
    //   108: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   111: aload_2
    //   112: invokestatic 449	com/tencent/mobileqq/troop/filemanager/forward/TroopFileFromTroopForwarder:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Lcom/tencent/mobileqq/troop/filemanager/forward/TroopFileFromTroopForwarder;
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +14 -> 131
    //   120: aload_1
    //   121: invokevirtual 450	com/tencent/mobileqq/troop/filemanager/forward/TroopFileFromTroopForwarder:a	()I
    //   124: pop
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 6
    //   129: monitorexit
    //   130: return
    //   131: ldc 165
    //   133: getstatic 392	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:a	I
    //   136: ldc_w 452
    //   139: invokestatic 454	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: goto -17 -> 125
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	TroopFileTransferMgr
    //   0	150	1	paramString1	String
    //   0	150	2	paramString2	String
    //   0	150	3	paramLong	long
    //   0	150	5	paramInt	int
    //   4	124	6	localTroopFileManager	TroopFileManager
    // Exception table:
    //   from	to	target	type
    //   9	11	44	finally
    //   20	23	44	finally
    //   40	43	44	finally
    //   45	48	44	finally
    //   127	130	44	finally
    //   148	150	44	finally
    //   11	20	145	finally
    //   24	34	145	finally
    //   38	40	145	finally
    //   50	116	145	finally
    //   120	125	145	finally
    //   125	127	145	finally
    //   131	142	145	finally
    //   146	148	145	finally
  }
  
  public void a(Collection paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (a())
      {
        try
        {
          if (NetworkUtil.a(BaseApplication.getContext()) == 0)
          {
            i = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            Object localObject1 = (String)paramCollection.next();
            localObject2 = ???.b((String)localObject1);
            if (localObject2 == null) {
              continue;
            }
            c();
            localObject2 = new TroopFileTransferManager.Item((TroopFileInfo)localObject2);
            ((TroopFileTransferManager.Item)localObject2).BusId = 102;
            ((TroopFileTransferManager.Item)localObject2).isFromAIO = paramBoolean;
            localObject1 = new File((String)localObject1);
            if (((File)localObject1).exists()) {
              ((TroopFileTransferManager.Item)localObject2).origLastModifyTime = ((File)localObject1).lastModified();
            }
            a((TroopFileTransferManager.Item)localObject2);
            if (i == 0) {
              break label158;
            }
            a((TroopFileTransferManager.Item)localObject2, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label158:
      TroopFileUploadMgr.a().a(this.e, (TroopFileTransferManager.Item)localObject2, null);
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (a())
    {
      try
      {
        c();
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramList.next();
          if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString))
          {
            Object localObject = ???.a(localTroopFileStatusInfo.g, localTroopFileStatusInfo.b, 25);
            if (localObject != null)
            {
              localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
              a((TroopFileTransferManager.Item)localObject);
              ((TroopFileTransferManager.Item)localObject).ForwardPath = localTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
              ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
              ((TroopFileTransferManager.Item)localObject).ForwardBusId = localTroopFileStatusInfo.jdField_e_of_type_Int;
              ((TroopFileTransferManager.Item)localObject).Status = 4;
              ((TroopFileTransferManager.Item)localObject).BusId = 25;
              localArrayList.add(localObject);
              continue;
              paramList = finally;
            }
          }
        }
      }
      finally {}
    }
    if (localArrayList.size() == 0) {
      return;
    }
    paramList = TroopFileMultiForwarder.a(this.e, localArrayList);
    if (paramList != null) {
      paramList.a();
    }
    for (;;)
    {
      return;
      TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "startMultiCopyToWeiyun forwarder=null");
    }
  }
  
  /* Error */
  public void a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   6: aload_0
    //   7: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 128 2 0
    //   16: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc 165
    //   29: getstatic 392	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:a	I
    //   32: new 167	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 506
    //   42: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 181	java/util/UUID:toString	()Ljava/lang/String;
    //   49: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 508
    //   55: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 396	com/tencent/mobileqq/troop/filemanager/TroopFileTransferUtil$Log:c	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: new 510	ajle
    //   67: dup
    //   68: aload_0
    //   69: aload_2
    //   70: aload_1
    //   71: invokespecial 513	ajle:<init>	(Lcom/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Ljava/util/UUID;)V
    //   74: iconst_5
    //   75: aconst_null
    //   76: iconst_0
    //   77: invokestatic 518	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   80: goto -56 -> 24
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	TroopFileTransferMgr
    //   0	88	1	paramUUID	UUID
    //   19	51	2	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   2	20	83	finally
    //   27	80	83	finally
  }
  
  @Deprecated
  protected boolean a()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "!!!warning: oldver fun: saveStatus be called");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    return TroopFileThumbnailMgr.a(this.e, paramItem, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    TroopFileInfo localTroopFileInfo;
    synchronized (a()) {}
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
    try
    {
      int i = FileManagerUtil.a(FileUtil.a(paramString2));
      if ((i != 0) && (i != 2)) {
        return false;
      }
      TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt1);
      if (localTroopFileInfo == null)
      {
        return false;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localTroopFileInfo.a);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
        a(paramString1);
      }
      TroopFileThumbnailMgr.a().a(this.e, paramString1, paramInt2);
      return true;
    }
    finally {}
  }
  
  /* Error */
  public boolean a(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 351	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 546	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +8 -> 50
    //   45: iconst_1
    //   46: istore_3
    //   47: goto -19 -> 28
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -5 -> 47
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TroopFileTransferMgr
    //   0	60	1	paramUUID	UUID
    //   40	2	2	i	int
    //   1	51	3	bool	boolean
    //   21	3	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	55	finally
    //   32	41	55	finally
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
      if (localTroopFileInfo == null) {
        return false;
      }
      int i = FileManagerUtil.a(FileUtil.a(localTroopFileInfo.c));
      if ((i != 0) && (i != 2))
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      paramUUID = localItem;
      if (localItem == null)
      {
        paramUUID = new TroopFileTransferManager.Item(localTroopFileInfo);
        a(paramUUID);
      }
      TroopFileThumbnailMgr.a().a(this.e, paramUUID, paramInt);
      return true;
    }
    finally {}
  }
  
  protected void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "release");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver != null)
    {
      TroopFileUploadMgr.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$FileUploadMgrObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver != null)
    {
      TroopFileDownloadMgr.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver = null;
    }
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    TroopFileDataCenter.a(this.e, paramItem);
  }
  
  /* Error */
  public boolean b(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: invokestatic 351	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr;
    //   33: aload_0
    //   34: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   37: aload_1
    //   38: aconst_null
    //   39: invokevirtual 352	com/tencent/mobileqq/troop/filemanager/upload/TroopFileUploadMgr:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +8 -> 52
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -23 -> 26
    //   52: iconst_0
    //   53: istore_3
    //   54: goto -5 -> 49
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TroopFileTransferMgr
    //   0	62	1	paramUUID	UUID
    //   42	2	2	i	int
    //   1	53	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	57	finally
    //   30	43	57	finally
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        label11:
        return;
      }
      this.b = true;
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.e);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      if ((!jdField_a_of_type_Boolean) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if (((TroopFileTansferItemEntity)localObject2).Id != null) {
          this.jdField_a_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        } else {
          TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "entity.Id is null");
        }
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ThreadManager.post(new ajlf(this), 8, null, true);
          break label11;
        }
        c();
        break label11;
      }
    }
  }
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    paramItem = TroopFileUploadFeedsSender.a(this.e, paramItem);
    if (paramItem != null) {
      paramItem.a();
    }
  }
  
  /* Error */
  public boolean c(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: aload_1
    //   31: getfield 145	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   34: ifeq +21 -> 55
    //   37: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   40: aload_0
    //   41: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   44: aload_1
    //   45: aconst_null
    //   46: invokevirtual 212	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:b	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   49: pop
    //   50: iconst_1
    //   51: istore_3
    //   52: goto -26 -> 26
    //   55: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   58: aload_0
    //   59: getfield 33	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:e	J
    //   62: aload_1
    //   63: aconst_null
    //   64: invokevirtual 278	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifne +8 -> 77
    //   72: iconst_1
    //   73: istore_3
    //   74: goto -48 -> 26
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -5 -> 74
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	TroopFileTransferMgr
    //   0	87	1	paramUUID	UUID
    //   67	2	2	i	int
    //   1	78	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	82	finally
    //   30	50	82	finally
    //   55	68	82	finally
  }
  
  protected void d()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      Bundle localBundle;
      try
      {
        c();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label208;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME) {
          continue;
        }
        localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
        localBundle = new Bundle();
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          localBundle.putBoolean("_wifi2mobile_resume_", true);
        }
      }
      finally {}
      TroopFileUploadMgr.a().a(this.e, localItem, localBundle);
      continue;
      localBundle.putBoolean("_wifi2mobile_resume_", true);
      if (localItem.isZipInnerFile)
      {
        TroopFileDownloadMgr.a().b(this.e, localItem, localBundle);
      }
      else
      {
        TroopFileDownloadMgr.a().a(this.e, localItem, localBundle);
        continue;
        label208:
        return;
      }
    }
  }
  
  protected void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      TroopFileDataCenter.b(this.e, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public boolean d(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 119	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   8: aload_0
    //   9: getfield 122	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 128 2 0
    //   18: checkcast 130	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 209	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	()Lcom/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 623	com/tencent/mobileqq/troop/filemanager/download/TroopFileDownloadMgr:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +8 -> 50
    //   45: iconst_1
    //   46: istore_3
    //   47: goto -19 -> 28
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -5 -> 47
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TroopFileTransferMgr
    //   0	60	1	paramUUID	UUID
    //   40	2	2	i	int
    //   1	51	3	bool	boolean
    //   21	3	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	55	finally
    //   32	41	55	finally
  }
  
  @Deprecated
  protected void e()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "!!!warning: oldver fun: Interrupt be called");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  protected void e(TroopFileTransferManager.Item paramItem)
  {
    TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "!!!warning: oldver fun: doReqUpload be called");
  }
  
  public boolean e(UUID paramUUID)
  {
    TroopFileInfo localTroopFileInfo;
    TroopFileTransferManager.Item localItem;
    synchronized (a()) {}
  }
  
  @Deprecated
  protected void f(TroopFileTransferManager.Item paramItem)
  {
    TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "!!!warning: oldver fun: doReqResend be called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.filemanager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.FileDownloadMgrObserver;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileFromTroopForwarder;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class TroopFileTransferMgr
  extends TroopFileTransferManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  protected int a;
  protected TroopFileDownloadMgr.FileDownloadMgrObserver a;
  protected int b;
  
  public TroopFileTransferMgr(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = paramLong;
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {
      try
      {
        jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      finally {}
    }
    if ((!paramBoolean) && (Thread.currentThread() == jdField_a_of_type_AndroidOsHandler.getLooper().getThread()))
    {
      paramRunnable.run();
      return;
    }
    jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (a())
    {
      try
      {
        Object localObject = ???.a(paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
        if (localObject == null) {
          return -1;
        }
        ((TroopFileInfo)localObject).a = UUID.fromString(paramFileManagerEntity.strTroopFileID);
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)localObject).a);
        int i;
        if (localItem == null)
        {
          localItem = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
          i = 1;
        }
        else
        {
          if (localItem.Status != 7) {
            return -2;
          }
          i = 0;
        }
        localItem.FileName = paramFileManagerEntity.fileName;
        localItem.ProgressTotal = paramFileManagerEntity.fileSize;
        localItem.ProgressValue = 0L;
        localItem.isZipInnerFile = true;
        localItem.zipType = paramFileManagerEntity.zipType;
        localItem.zipBusId = paramFileManagerEntity.busId;
        localItem.zipInnerPath = paramFileManagerEntity.zipInnerPath;
        localItem.zipFilePath = paramFileManagerEntity.zipFilePath;
        if (i != 0) {
          a(localItem);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<TroopFile> [");
        ((StringBuilder)localObject).append(localItem.Id.toString());
        ((StringBuilder)localObject).append("] startDownloadZipInnerFile strTroopFilePath. ");
        ((StringBuilder)localObject).append(paramFileManagerEntity.strTroopFilePath);
        ((StringBuilder)localObject).append(" zipFilePath:");
        ((StringBuilder)localObject).append(paramFileManagerEntity.zipFilePath);
        ((StringBuilder)localObject).append(" zipInnerPath:");
        ((StringBuilder)localObject).append(paramFileManagerEntity.zipInnerPath);
        ((StringBuilder)localObject).append(" zipFileId:");
        ((StringBuilder)localObject).append(paramFileManagerEntity.zipFileId);
        ((StringBuilder)localObject).append(" busId:");
        ((StringBuilder)localObject).append(paramFileManagerEntity.busId);
        QLog.i("TroopFileTransferMgr", 1, ((StringBuilder)localObject).toString());
        TroopFileDownloadMgr.a().b(this.e, localItem, null);
        return 0;
      }
      finally {}
    }
  }
  
  public TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a())
    {
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
        paramString1 = (MessageForTroopFile)FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), String.valueOf(paramLong1), 1, paramString1);
        if (paramString1 != null)
        {
          paramString2.width = paramString1.width;
          paramString2.height = paramString1.height;
          paramString2.yybApkPackageName = paramString1.yybApkPackageName;
          paramString2.yybApkName = paramString1.yybApkName;
          paramString2.yybApkIconUrl = paramString1.yybApkIconUrl;
        }
        paramString3 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1);
        if ((paramString3 != null) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.uuid)))
        {
          paramString1 = paramString3.a(UUID.fromString(paramString1.uuid));
          if (paramString1 != null)
          {
            paramString2.largeThumbnailFile = paramString1.largeThumbnailFile;
            paramString2.middleThumbnailFile = paramString1.middleThumbnailFile;
          }
        }
        a(paramString2);
        paramString1 = TroopFileToTroopForwarder.a(this.e, paramString2);
        if (paramString1 == null) {
          return null;
        }
        paramString1.a();
        paramString1 = paramString2.getInfo(this.e);
        return paramString1;
      }
      finally {}
    }
  }
  
  public TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a())
    {
      try
      {
        Object localObject2 = ???.a(paramString1, paramString2, paramLong, paramInt);
        if (localObject2 == null) {
          return null;
        }
        c();
        int i = 0;
        Object localObject1 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)localObject2).a);
        if (localObject1 == null)
        {
          paramString1 = new TroopFileTransferManager.Item((TroopFileInfo)localObject2);
          paramInt = 1;
        }
        else
        {
          paramInt = i;
          paramString1 = (String)localObject1;
          if (((TroopFileTransferManager.Item)localObject1).Status != 7) {
            if (((TroopFileTransferManager.Item)localObject1).Status == 11)
            {
              paramInt = i;
              paramString1 = (String)localObject1;
              if (!FileUtils.fileExists(((TroopFileInfo)localObject2).i)) {}
            }
            else if (((TroopFileTransferManager.Item)localObject1).Status == 6)
            {
              paramInt = i;
              paramString1 = (String)localObject1;
              if (!FileUtils.fileExists(((TroopFileInfo)localObject2).i)) {}
            }
            else
            {
              return null;
            }
          }
        }
        paramString1.FileName = paramString2;
        paramString1.ProgressTotal = paramLong;
        paramString1.ProgressValue = 0L;
        if (paramInt != 0) {
          a(paramString1);
        }
        if ((FileManagerUtil.a(paramString1.FileName) == 2) && (QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
        {
          localObject1 = paramString1.getInfo(this.e);
          FileVideoDownloadManager.a(new VideoForTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (TroopFileStatusInfo)localObject1)).a();
        }
        else
        {
          TroopFileDownloadMgr.a().a(this.e, paramString1, null);
        }
        paramString2 = FileUtil.a(paramString2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", ((StringBuilder)localObject2).toString(), paramString2, "");
        paramString1 = paramString1.getInfo(this.e);
        return paramString1;
      }
      finally {}
    }
  }
  
  public TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a())
    {
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
        VFSFile localVFSFile = new VFSFile(paramString);
        if (localVFSFile.exists()) {
          ((TroopFileTransferManager.Item)localObject).origLastModifyTime = localVFSFile.lastModified();
        }
        a((TroopFileTransferManager.Item)localObject);
        if (FileManagerUtil.a(paramString) == 5)
        {
          ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(paramString, new TroopFileTransferMgr.3(this, (TroopFileTransferManager.Item)localObject));
        }
        else
        {
          if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0) {
            a((TroopFileTransferManager.Item)localObject, 3, 106);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.e, (TroopFileTransferManager.Item)localObject, null);
        }
        paramString = ((TroopFileTransferManager.Item)localObject).getInfo(this.e);
        return paramString;
      }
      finally {}
    }
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      if ((paramBoolean) && (localItem != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.e, paramUUID);
      }
      return localItem;
    }
    finally {}
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver = new TroopFileTransferMgr.1(this);
      TroopFileDownloadMgr.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr$FileDownloadMgrObserver);
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "init");
  }
  
  /* Error */
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 81	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 4
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokevirtual 117	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   25: aload_0
    //   26: getfield 120	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   29: aload_1
    //   30: getfield 115	com/tencent/mobileqq/troop/data/TroopFileInfo:a	Ljava/util/UUID;
    //   33: invokeinterface 126 2 0
    //   38: checkcast 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: ifnonnull +17 -> 62
    //   48: new 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 164	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   62: aload_2
    //   63: aload_1
    //   64: getfield 473	com/tencent/mobileqq/troop/data/TroopFileInfo:k	Ljava/lang/String;
    //   67: putfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:largeThumbnailFile	Ljava/lang/String;
    //   70: aload_2
    //   71: aload_1
    //   72: getfield 476	com/tencent/mobileqq/troop/data/TroopFileInfo:l	Ljava/lang/String;
    //   75: putfield 295	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:middleThumbnailFile	Ljava/lang/String;
    //   78: aload_2
    //   79: aload_1
    //   80: getfield 479	com/tencent/mobileqq/troop/data/TroopFileInfo:j	Ljava/lang/String;
    //   83: putfield 482	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:smallThumbFile	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 484	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 4
    //   95: monitorexit
    //   96: return
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload 4
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	TroopFileTransferMgr
    //   0	108	1	paramTroopFileInfo	TroopFileInfo
    //   43	45	2	localItem1	TroopFileTransferManager.Item
    //   41	4	3	localItem2	TroopFileTransferManager.Item
    //   4	100	4	localTroopFileManager	TroopFileManager
    // Exception table:
    //   from	to	target	type
    //   15	17	97	finally
    //   21	42	97	finally
    //   48	62	97	finally
    //   62	93	97	finally
    //   98	100	97	finally
    //   9	11	102	finally
    //   17	20	102	finally
    //   93	96	102	finally
    //   100	102	102	finally
    //   103	106	102	finally
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
        int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newItem troop confit. item.troopuin:");
        localStringBuilder.append(paramItem.troopuin);
        localStringBuilder.append(" mTroopUin");
        localStringBuilder.append(this.e);
        TroopFileTransferUtil.Log.b("TroopFileTransferMgr", i, localStringBuilder.toString());
        paramItem.troopuin = this.e;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramItem, null);
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
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: doReqDownload be called");
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a())
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          return;
        }
        paramString2 = ???.a(paramString2, paramLong, 25);
        if (paramString2 == null) {
          return;
        }
        c();
        paramString2 = new TroopFileTransferManager.Item(paramString2);
        paramString2.ForwardPath = paramString1;
        paramString2.ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
        paramString2.ForwardBusId = paramInt;
        paramString2.Status = 4;
        paramString2.BusId = 25;
        a(paramString2);
        paramString1 = TroopFileFromTroopForwarder.a(this.e, paramString2);
        if (paramString1 != null) {
          paramString1.a();
        } else {
          TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "startCopyToWeiyun forwarder=null");
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    int i;
    synchronized (a())
    {
      try
      {
        if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0)
        {
          i = 1;
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext())
          {
            Object localObject1 = (String)paramCollection.next();
            Object localObject2 = ???.b((String)localObject1);
            if (localObject2 != null)
            {
              c();
              localObject2 = new TroopFileTransferManager.Item((TroopFileInfo)localObject2);
              ((TroopFileTransferManager.Item)localObject2).BusId = 102;
              ((TroopFileTransferManager.Item)localObject2).isFromAIO = paramBoolean;
              localObject1 = new VFSFile((String)localObject1);
              if (((VFSFile)localObject1).exists()) {
                ((TroopFileTransferManager.Item)localObject2).origLastModifyTime = ((VFSFile)localObject1).lastModified();
              }
              a((TroopFileTransferManager.Item)localObject2);
              if (i != 0) {
                a((TroopFileTransferManager.Item)localObject2, 3, 106);
              } else {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.e, (TroopFileTransferManager.Item)localObject2, null);
              }
            }
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(List<TroopFileStatusInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      synchronized (a())
      {
        try
        {
          c();
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramList.next();
            if (!TextUtils.isEmpty(localTroopFileStatusInfo.e))
            {
              Object localObject = ???.a(localTroopFileStatusInfo.g, localTroopFileStatusInfo.c, 25);
              if (localObject != null)
              {
                localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
                a((TroopFileTransferManager.Item)localObject);
                ((TroopFileTransferManager.Item)localObject).ForwardPath = localTroopFileStatusInfo.e;
                ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
                ((TroopFileTransferManager.Item)localObject).ForwardBusId = localTroopFileStatusInfo.h;
                ((TroopFileTransferManager.Item)localObject).Status = 4;
                ((TroopFileTransferManager.Item)localObject).BusId = 25;
                localArrayList.add(localObject);
              }
            }
          }
          if (localArrayList.size() == 0) {
            return;
          }
          paramList = TroopFileMultiForwarder.a(this.e, localArrayList);
          if (paramList != null) {
            paramList.a();
          } else {
            TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "startMultiCopyToWeiyun forwarder=null");
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(UUID paramUUID)
  {
    try
    {
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      if (localItem == null) {
        return;
      }
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramUUID.toString());
      localStringBuilder.append("] cancelDownload");
      TroopFileTransferUtil.Log.c("TroopFileTransferMgr", i, localStringBuilder.toString());
      ThreadManager.post(new TroopFileTransferMgr.2(this, localItem, paramUUID), 5, null, false);
      return;
    }
    finally {}
  }
  
  @Deprecated
  protected boolean a()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: saveStatus be called");
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
    synchronized (a())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(localTroopFileInfo.a);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramString1);
        }
        TroopFileDownloadMgr.a().a(this.e, paramString1);
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a())
    {
      try
      {
        int i = FileManagerUtil.a(FileUtil.a(paramString2));
        if ((i != 0) && (i != 2)) {
          return false;
        }
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt1);
        if (localTroopFileInfo == null) {
          return false;
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
  }
  
  public boolean a(UUID paramUUID)
  {
    try
    {
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      if (localItem == null) {
        return false;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramUUID);
      return bool;
    }
    finally {}
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
        if (localTroopFileInfo == null) {
          return false;
        }
        int i = FileManagerUtil.a(FileUtil.a(localTroopFileInfo.c));
        if ((i != 0) && (i != 2)) {
          return false;
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
  }
  
  protected void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "release");
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
  
  public boolean b(UUID paramUUID)
  {
    try
    {
      c();
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      boolean bool = false;
      if (paramUUID == null) {
        return false;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.e, paramUUID, null);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      if (bool) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.e);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      if ((!jdField_a_of_type_Boolean) && (localObject1 == null)) {
        throw new AssertionError();
      }
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (TroopFileTansferItemEntity)((Iterator)localObject1).next();
          if (((TroopFileTansferItemEntity)localObject3).Id != null)
          {
            if (!((TroopFileTansferItemEntity)localObject3).isCheckPrivateDir)
            {
              ((TroopFileTansferItemEntity)localObject3).isCheckPrivateDir = true;
              if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject3).smallThumbFile)) {
                ((TroopFileTansferItemEntity)localObject3).smallThumbFile = VFSAssistantUtils.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject3).smallThumbFile);
              }
              if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject3).largeThumbnailFile)) {
                ((TroopFileTansferItemEntity)localObject3).largeThumbnailFile = VFSAssistantUtils.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject3).largeThumbnailFile);
              }
              if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject3).middleThumbnailFile)) {
                ((TroopFileTansferItemEntity)localObject3).middleThumbnailFile = VFSAssistantUtils.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject3).middleThumbnailFile);
              }
            }
            this.jdField_a_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject3).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject3));
          }
          else
          {
            TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "entity.Id is null");
          }
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TroopFileTransferManager.Item)((Iterator)localObject1).next();
        int i = ((TroopFileTransferManager.Item)localObject3).Status;
        if ((i != 0) && (i != 1))
        {
          if (i == 8) {
            ((TroopFileTransferManager.Item)localObject3).Status = 10;
          }
        }
        else {
          ((TroopFileTransferManager.Item)localObject3).Status = 3;
        }
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.post(new TroopFileTransferMgr.4(this), 8, null, true);
      } else {
        c();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    paramItem = TroopFileUploadFeedsSender.a(this.e, paramItem);
    if (paramItem != null) {
      paramItem.a();
    }
  }
  
  public boolean c(UUID paramUUID)
  {
    try
    {
      c();
      paramUUID = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      boolean bool = false;
      if (paramUUID == null) {
        return false;
      }
      if (paramUUID.isZipInnerFile)
      {
        TroopFileDownloadMgr.a().b(this.e, paramUUID, null);
        return true;
      }
      int i = TroopFileDownloadMgr.a().a(this.e, paramUUID, null);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  protected void d()
  {
    try
    {
      c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause == 2)
        {
          localItem.W2MPause = 0;
          Bundle localBundle = new Bundle();
          int i = localItem.Status;
          if ((i != 0) && (i != 1)) {
            if (i != 2)
            {
              if (i != 8)
              {
                if (i != 9) {
                  continue;
                }
                localBundle.putBoolean("_wifi2mobile_resume_", true);
                if (localItem.isZipInnerFile)
                {
                  TroopFileDownloadMgr.a().b(this.e, localItem, localBundle);
                  continue;
                }
                TroopFileDownloadMgr.a().a(this.e, localItem, localBundle);
              }
            }
            else
            {
              localBundle.putBoolean("_wifi2mobile_resume_", true);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.e, localItem, localBundle);
              continue;
            }
          }
          localItem.Pausing = 0;
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
  
  public boolean d(UUID paramUUID)
  {
    try
    {
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
      boolean bool = false;
      if (localItem == null) {
        return false;
      }
      int i = TroopFileDownloadMgr.a().a(paramUUID, null);
      if ((FileManagerUtil.a(localItem.FileName) == 2) && (QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        FileVideoDownloadManager.a(localItem.FilePath);
        a(localItem, 9);
      }
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  protected void e()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: Interrupt be called");
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
    TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "!!!warning: oldver fun: doReqUpload be called");
  }
  
  public boolean e(UUID paramUUID)
  {
    synchronized (a())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_a_of_type_JavaUtilMap.get(paramUUID);
        paramUUID = localItem;
        if (localItem == null)
        {
          paramUUID = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramUUID);
        }
        TroopFileDownloadMgr.a().a(this.e, paramUUID);
        return true;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr
 * JD-Core Version:    0.7.0.1
 */
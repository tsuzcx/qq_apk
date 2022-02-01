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
import mqq.util.LogUtil;

public class TroopFileTransferMgr
  extends TroopFileTransferManager
{
  private static Handler p;
  protected TroopFileDownloadMgr.FileDownloadMgrObserver a;
  protected int b = 0;
  protected int c = 0;
  
  public TroopFileTransferMgr(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.j = paramQQAppInterface;
    this.k = paramLong;
  }
  
  public static void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (p == null) {
      try
      {
        p = new Handler(Looper.getMainLooper());
      }
      finally {}
    }
    if ((!paramBoolean) && (Thread.currentThread() == p.getLooper().getThread()))
    {
      paramRunnable.run();
      return;
    }
    p.post(paramRunnable);
  }
  
  public int a(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (h())
    {
      try
      {
        Object localObject = ???.a(paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
        if (localObject == null) {
          return -1;
        }
        ((TroopFileInfo)localObject).b = UUID.fromString(paramFileManagerEntity.strTroopFileID);
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(((TroopFileInfo)localObject).b);
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
        TroopFileDownloadMgr.a().c(this.k, localItem, null);
        return 0;
      }
      finally {}
    }
  }
  
  public TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (h())
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
        paramString1 = (MessageForTroopFile)FileOperaterUtils.a(this.j.getMessageFacade(), String.valueOf(paramLong1), 1, paramString1);
        if (paramString1 != null)
        {
          paramString2.width = paramString1.width;
          paramString2.height = paramString1.height;
          paramString2.yybApkPackageName = paramString1.yybApkPackageName;
          paramString2.yybApkName = paramString1.yybApkName;
          paramString2.yybApkIconUrl = paramString1.yybApkIconUrl;
        }
        paramString3 = TroopFileTransferManager.a(this.j, paramLong1);
        if ((paramString3 != null) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.uuid)))
        {
          paramString1 = paramString3.i(UUID.fromString(paramString1.uuid));
          if (paramString1 != null)
          {
            paramString2.largeThumbnailFile = paramString1.largeThumbnailFile;
            paramString2.middleThumbnailFile = paramString1.middleThumbnailFile;
          }
        }
        a(paramString2);
        paramString1 = TroopFileToTroopForwarder.a(this.k, paramString2);
        if (paramString1 == null) {
          return null;
        }
        paramString1.a();
        paramString1 = paramString2.getInfo(this.k);
        return paramString1;
      }
      finally {}
    }
  }
  
  public TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (h())
    {
      try
      {
        Object localObject2 = ???.a(paramString1, paramString2, paramLong, paramInt);
        if (localObject2 == null) {
          return null;
        }
        c();
        int i = 0;
        Object localObject1 = (TroopFileTransferManager.Item)this.l.get(((TroopFileInfo)localObject2).b);
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
              if (!FileUtils.fileExists(((TroopFileInfo)localObject2).t)) {}
            }
            else if (((TroopFileTransferManager.Item)localObject1).Status == 6)
            {
              paramInt = i;
              paramString1 = (String)localObject1;
              if (!FileUtils.fileExists(((TroopFileInfo)localObject2).t)) {}
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
        if ((FileManagerUtil.c(paramString1.FileName) == 2) && (QFileUtils.a(this.j)))
        {
          localObject1 = paramString1.getInfo(this.k);
          FileVideoDownloadManager.b(new VideoForTroop(this.j, (TroopFileStatusInfo)localObject1)).c();
        }
        else
        {
          TroopFileDownloadMgr.a().b(this.k, paramString1, null);
        }
        paramString2 = FileUtil.a(paramString2);
        localObject1 = this.j;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.k);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", ((StringBuilder)localObject2).toString(), paramString2, "");
        paramString1 = paramString1.getInfo(this.k);
        return paramString1;
      }
      finally {}
    }
  }
  
  public TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (h())
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
        if (FileManagerUtil.c(paramString) == 5)
        {
          ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(paramString, new TroopFileTransferMgr.3(this, (TroopFileTransferManager.Item)localObject));
        }
        else
        {
          if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0) {
            a((TroopFileTransferManager.Item)localObject, 3, 106);
          }
          this.j.getFileManagerEngine().m().a(this.k, (TroopFileTransferManager.Item)localObject, null);
        }
        paramString = ((TroopFileTransferManager.Item)localObject).getInfo(this.k);
        return paramString;
      }
      finally {}
    }
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.remove(paramUUID);
      if ((paramBoolean) && (localItem != null)) {
        this.j.getProxyManager().f().a(this.k, paramUUID);
      }
      return localItem;
    }
    finally {}
  }
  
  protected void a()
  {
    super.a();
    if (this.a == null)
    {
      this.a = new TroopFileTransferMgr.1(this);
      TroopFileDownloadMgr.a().addObserver(this.a);
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "init");
  }
  
  /* Error */
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 88	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:h	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
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
    //   22: invokevirtual 124	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:c	()V
    //   25: aload_0
    //   26: getfield 128	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:l	Ljava/util/Map;
    //   29: aload_1
    //   30: getfield 122	com/tencent/mobileqq/troop/data/TroopFileInfo:b	Ljava/util/UUID;
    //   33: invokeinterface 134 2 0
    //   38: checkcast 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: ifnonnull +17 -> 62
    //   48: new 136	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 172	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   62: aload_2
    //   63: aload_1
    //   64: getfield 484	com/tencent/mobileqq/troop/data/TroopFileInfo:x	Ljava/lang/String;
    //   67: putfield 300	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:largeThumbnailFile	Ljava/lang/String;
    //   70: aload_2
    //   71: aload_1
    //   72: getfield 487	com/tencent/mobileqq/troop/data/TroopFileInfo:y	Ljava/lang/String;
    //   75: putfield 303	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:middleThumbnailFile	Ljava/lang/String;
    //   78: aload_2
    //   79: aload_1
    //   80: getfield 490	com/tencent/mobileqq/troop/data/TroopFileInfo:w	Ljava/lang/String;
    //   83: putfield 493	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:smallThumbFile	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 495	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
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
      this.l.put(paramItem.Id, paramItem);
      if (paramItem.troopuin == 0L) {
        paramItem.troopuin = this.k;
      }
      if (paramItem.troopuin != this.k)
      {
        long l1 = paramItem.troopuin;
        long l2 = this.k;
        int i = TroopFileTransferUtil.Log.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newItem troop confit. item.troopuin:");
        localStringBuilder.append(LogUtil.wrapLogUin(String.valueOf(l1)));
        localStringBuilder.append(" mTroopUin");
        localStringBuilder.append(LogUtil.wrapLogUin(String.valueOf(l2)));
        TroopFileTransferUtil.Log.b("TroopFileTransferMgr", i, localStringBuilder.toString());
        paramItem.troopuin = this.k;
      }
      this.j.getProxyManager().f().a(paramItem, null);
      return;
    }
    finally {}
  }
  
  protected void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    try
    {
      TroopFileDataCenter.a(this.k, paramItem, paramInt1, paramInt2);
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
      TroopFileDataCenter.a(this.k, paramItem, paramInt, paramSimpleErrorInfo);
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
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "!!!warning: oldver fun: doReqDownload be called");
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    int i;
    synchronized (h())
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
                this.j.getFileManagerEngine().m().a(this.k, (TroopFileTransferManager.Item)localObject2, null);
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
      synchronized (h())
      {
        try
        {
          c();
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramList.next();
            if (!TextUtils.isEmpty(localTroopFileStatusInfo.r))
            {
              Object localObject = ???.a(localTroopFileStatusInfo.t, localTroopFileStatusInfo.i, 25);
              if (localObject != null)
              {
                localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
                a((TroopFileTransferManager.Item)localObject);
                ((TroopFileTransferManager.Item)localObject).ForwardPath = localTroopFileStatusInfo.r;
                ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = Long.valueOf(this.j.getCurrentAccountUin()).longValue();
                ((TroopFileTransferManager.Item)localObject).ForwardBusId = localTroopFileStatusInfo.u;
                ((TroopFileTransferManager.Item)localObject).Status = 4;
                ((TroopFileTransferManager.Item)localObject).BusId = 25;
                localArrayList.add(localObject);
              }
            }
          }
          if (localArrayList.size() == 0) {
            return;
          }
          paramList = TroopFileMultiForwarder.a(this.k, localArrayList);
          if (paramList != null) {
            paramList.a();
          } else {
            TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "startMultiCopyToWeiyun forwarder=null");
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
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      if (localItem == null) {
        return;
      }
      int i = TroopFileTransferUtil.Log.b;
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
  
  protected boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    return TroopFileThumbnailMgr.b(this.k, paramItem, paramInt);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    synchronized (h())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.l.get(localTroopFileInfo.b);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramString1);
        }
        TroopFileDownloadMgr.a().a(this.k, paramString1);
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (h())
    {
      try
      {
        int i = FileManagerUtil.c(FileUtil.a(paramString2));
        if ((i != 0) && (i != 2)) {
          return false;
        }
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt1);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.l.get(localTroopFileInfo.b);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramString1);
        }
        TroopFileThumbnailMgr.a().a(this.k, paramString1, paramInt2);
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (h())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
        if (localTroopFileInfo == null) {
          return false;
        }
        int i = FileManagerUtil.c(FileUtil.a(localTroopFileInfo.d));
        if ((i != 0) && (i != 2)) {
          return false;
        }
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(paramUUID);
        paramUUID = localItem;
        if (localItem == null)
        {
          paramUUID = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramUUID);
        }
        TroopFileThumbnailMgr.a().a(this.k, paramUUID, paramInt);
        return true;
      }
      finally {}
    }
  }
  
  protected void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "release");
    if (this.a != null)
    {
      TroopFileDownloadMgr.a().deleteObserver(this.a);
      this.a = null;
    }
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    TroopFileDataCenter.a(this.k, paramItem);
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (h())
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
        paramString2.ForwardTroopuin = Long.valueOf(this.j.getCurrentAccountUin()).longValue();
        paramString2.ForwardBusId = paramInt;
        paramString2.Status = 4;
        paramString2.BusId = 25;
        a(paramString2);
        paramString1 = TroopFileFromTroopForwarder.a(this.k, paramString2);
        if (paramString1 != null) {
          paramString1.b();
        } else {
          TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "startCopyToWeiyun forwarder=null");
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean b(UUID paramUUID)
  {
    try
    {
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      if (localItem == null) {
        return false;
      }
      boolean bool = this.j.getFileManagerEngine().m().a(paramUUID);
      return bool;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.n;
      if (bool) {
        return;
      }
      this.n = true;
      Object localObject1 = this.j.getProxyManager().f().a(this.k);
      this.l = new ConcurrentHashMap();
      if ((!d) && (localObject1 == null)) {
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
            this.l.put(((TroopFileTansferItemEntity)localObject3).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject3));
          }
          else
          {
            TroopFileTransferUtil.Log.a("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "entity.Id is null");
          }
        }
      }
      localObject1 = this.l.values().iterator();
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
        p();
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
    paramItem = TroopFileUploadFeedsSender.b(this.k, paramItem);
    if (paramItem != null) {
      paramItem.c();
    }
  }
  
  public boolean c(UUID paramUUID)
  {
    try
    {
      c();
      paramUUID = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      boolean bool = false;
      if (paramUUID == null) {
        return false;
      }
      int i = this.j.getFileManagerEngine().m().a(this.k, paramUUID, null);
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
      Iterator localIterator = this.l.values().iterator();
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
                  TroopFileDownloadMgr.a().c(this.k, localItem, localBundle);
                  continue;
                }
                TroopFileDownloadMgr.a().b(this.k, localItem, localBundle);
              }
            }
            else
            {
              localBundle.putBoolean("_wifi2mobile_resume_", true);
              this.j.getFileManagerEngine().m().a(this.k, localItem, localBundle);
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
      TroopFileDataCenter.b(this.k, paramItem);
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
      paramUUID = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      boolean bool = false;
      if (paramUUID == null) {
        return false;
      }
      if (paramUUID.isZipInnerFile)
      {
        TroopFileDownloadMgr.a().c(this.k, paramUUID, null);
        return true;
      }
      int i = TroopFileDownloadMgr.a().b(this.k, paramUUID, null);
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
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "!!!warning: oldver fun: Interrupt be called");
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
    TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "!!!warning: oldver fun: doReqUpload be called");
  }
  
  public boolean e(UUID paramUUID)
  {
    try
    {
      c();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(paramUUID);
      boolean bool = false;
      if (localItem == null) {
        return false;
      }
      int i = TroopFileDownloadMgr.a().a(paramUUID, null);
      if ((FileManagerUtil.c(localItem.FileName) == 2) && (QFileUtils.a(this.j)))
      {
        FileVideoDownloadManager.a(localItem.FilePath);
        b(localItem, 9);
      }
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  protected boolean f()
  {
    try
    {
      TroopFileTransferUtil.Log.b("TroopFileTransferMgr", TroopFileTransferUtil.Log.b, "!!!warning: oldver fun: saveStatus be called");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f(UUID paramUUID)
  {
    synchronized (h())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.l.get(paramUUID);
        paramUUID = localItem;
        if (localItem == null)
        {
          paramUUID = new TroopFileTransferManager.Item(localTroopFileInfo);
          a(paramUUID);
        }
        TroopFileDownloadMgr.a().a(this.k, paramUUID);
        return true;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr
 * JD-Core Version:    0.7.0.1
 */
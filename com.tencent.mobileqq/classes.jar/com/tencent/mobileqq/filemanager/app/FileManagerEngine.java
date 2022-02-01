package com.tencent.mobileqq.filemanager.app;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader;
import com.tencent.mobileqq.filemanager.core.DiscVideoThumbDownloader;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMConstants.RevertMsgCallback;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr;
import com.tencent.mobileqq.filemanager.fileassistant.util.FileResultWatchForObserver;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkSender;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.forward.QfavFileForwardManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;

public class FileManagerEngine
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  FileForwardManager jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileForwardManager;
  FileManagerEngine.MyRecv jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine$MyRecv = null;
  private FileMultiMsgPackageHandle jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgPackageHandle;
  private IQQFavProxy jdField_a_of_type_ComTencentMobileqqFilemanagerAppIQQFavProxy;
  private QFileAppStorePromoteManager jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager;
  private QFileMsgForwardManager jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager;
  private DiscPicThumbDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader = null;
  private DiscVideoThumbDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader = null;
  private MMApkFileSafeChecker jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker;
  private OfflineVideoThumbDownLoader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader = null;
  ThumbDownloadManager jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownloadManager;
  private ThumbHttpDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader = null;
  private FileAssistantMgr jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr;
  private FileResultWatchForObserver jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilFileResultWatchForObserver;
  private QFileC2CTransferWrapper jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper;
  private QFileDiscTransferWrapper jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper;
  private QFileTroopTransferWrapper jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper;
  WeiYunLogicCenter jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter;
  
  public FileManagerEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter == null) {
      a();
    }
    FileManagerUtil.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine$MyRecv == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine$MyRecv = new FileManagerEngine.MyRecv(this, null);
    }
    try
    {
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("android.intent.action.MEDIA_MOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTED");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_EJECT");
      paramQQAppInterface.addAction("android.intent.action.MEDIA_REMOVED");
      paramQQAppInterface.addDataScheme("file");
      BaseApplicationImpl.sApplication.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine$MyRecv, paramQQAppInterface);
      label136:
      e();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      break label136;
    }
  }
  
  private void a(long paramLong, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.getCloudType() == 0)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().b(paramLong);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("err cloud type.when reTry :");
    localStringBuilder.append(paramFileManagerEntity.getCloudType());
    QLog.e("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).equals(paramFileManagerEntity.peerUin)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reTry Fileassistant bSend:");
    localStringBuilder.append(paramFileManagerEntity.bSend);
    QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
    if (paramFileManagerEntity.isSend())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr.a(paramFileManagerEntity);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr.b(paramFileManagerEntity);
    return true;
  }
  
  private void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryFileManagerEntity is fail!,check sessionID[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong));
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (a((FileManagerEntity)localObject)) {
      return;
    }
    int i = ((FileManagerEntity)localObject).nOpType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 13)
        {
          if (i == 50) {
            break label345;
          }
          if ((i != 24) && (i != 25)) {
            if (i != 28) {
              if (i == 29) {}
            }
          }
        }
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            QLog.e("FileManagerEngine<FileAssistant>", 1, "unknow operation type!");
            return;
          }
          a((FileManagerEntity)localObject, ((FileManagerEntity)localObject).nOpType);
          return;
        case 9: 
        case 10: 
          break;
        case 4: 
          e((FileManagerEntity)localObject);
          return;
        case 3: 
          a().a((FileManagerEntity)localObject, ((FileManagerEntity)localObject).peerType, true);
          return;
          d((FileManagerEntity)localObject);
          return;
        case 7: 
          a((FileManagerEntity)localObject);
          return;
          TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin).a(((FileManagerEntity)localObject).forwardTroopFileEntrance, ((FileManagerEntity)localObject).TroopUin, ((FileManagerEntity)localObject).busId, Long.valueOf(((FileManagerEntity)localObject).peerUin).longValue(), ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).fileName, ((FileManagerEntity)localObject).strThumbPath, ((FileManagerEntity)localObject).fileSize, ((FileManagerEntity)localObject).strTroopFilePath, true, paramLong, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          return;
          a(paramLong, (FileManagerEntity)localObject);
          return;
        }
      }
      label345:
      if (((FileManagerEntity)localObject).getCloudType() == 0)
      {
        ((FileManagerEntity)localObject).setCloudType(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().b((FileManagerEntity)localObject);
      return;
    }
    if (((FileManagerEntity)localObject).peerType == 3000)
    {
      a().a((FileManagerEntity)localObject);
      return;
    }
    a().b((FileManagerEntity)localObject);
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e()
  {
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).initTbsReaderEngine(false);
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilFileResultWatchForObserver = new FileResultWatchForObserver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
  }
  
  private void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 4;
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(25, paramFileManagerEntity);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 192	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr	Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr;
    //   8: ifnonnull +25 -> 33
    //   11: aload_0
    //   12: new 194	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr
    //   15: dup
    //   16: invokespecial 400	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:<init>	()V
    //   19: putfield 192	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr	Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr;
    //   22: aload_0
    //   23: getfield 192	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr	Lcom/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr;
    //   26: aload_0
    //   27: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 402	com/tencent/mobileqq/filemanager/fileassistant/transfer/FileAssistantMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	FileManagerEngine
    //   38	4	1	localObject1	Object
    //   43	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	33	38	finally
    //   33	35	38	finally
    //   39	41	38	finally
    //   2	4	43	finally
    //   41	43	43	finally
  }
  
  /* Error */
  public FileForwardManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 405	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileForwardManager	Lcom/tencent/mobileqq/filemanager/app/FileForwardManager;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 407	com/tencent/mobileqq/filemanager/app/FileForwardManager
    //   15: dup
    //   16: aload_0
    //   17: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 408	com/tencent/mobileqq/filemanager/app/FileForwardManager:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 405	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileForwardManager	Lcom/tencent/mobileqq/filemanager/app/FileForwardManager;
    //   26: aload_0
    //   27: getfield 405	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileForwardManager	Lcom/tencent/mobileqq/filemanager/app/FileForwardManager;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	FileManagerEngine
    //   30	6	1	localFileForwardManager	FileForwardManager
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public FileMultiMsgPackageHandle a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 411	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgPackageHandle	Lcom/tencent/mobileqq/filemanager/app/FileMultiMsgPackageHandle;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 413	com/tencent/mobileqq/filemanager/app/FileMultiMsgPackageHandle
    //   15: dup
    //   16: aload_0
    //   17: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 414	com/tencent/mobileqq/filemanager/app/FileMultiMsgPackageHandle:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 411	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgPackageHandle	Lcom/tencent/mobileqq/filemanager/app/FileMultiMsgPackageHandle;
    //   26: aload_0
    //   27: getfield 411	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileMultiMsgPackageHandle	Lcom/tencent/mobileqq/filemanager/app/FileMultiMsgPackageHandle;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	FileManagerEngine
    //   30	6	1	localFileMultiMsgPackageHandle	FileMultiMsgPackageHandle
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public IQQFavProxy a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 417	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppIQQFavProxy	Lcom/tencent/mobileqq/filemanager/app/IQQFavProxy;
    //   8: ifnonnull +20 -> 28
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: ldc_w 419
    //   19: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   22: checkcast 419	com/tencent/mobileqq/filemanager/app/IQQFavProxy
    //   25: putfield 417	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppIQQFavProxy	Lcom/tencent/mobileqq/filemanager/app/IQQFavProxy;
    //   28: aload_0
    //   29: getfield 417	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppIQQFavProxy	Lcom/tencent/mobileqq/filemanager/app/IQQFavProxy;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	FileManagerEngine
    //   32	6	1	localIQQFavProxy	IQQFavProxy
    //   39	4	1	localObject1	Object
    //   44	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	28	39	finally
    //   28	35	39	finally
    //   40	42	39	finally
    //   2	4	44	finally
    //   42	44	44	finally
  }
  
  /* Error */
  public QFileAppStorePromoteManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 426	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager	Lcom/tencent/mobileqq/filemanager/app/QFileAppStorePromoteManager;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 428	com/tencent/mobileqq/filemanager/app/QFileAppStorePromoteManager
    //   15: dup
    //   16: aload_0
    //   17: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 429	com/tencent/mobileqq/filemanager/app/QFileAppStorePromoteManager:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 426	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager	Lcom/tencent/mobileqq/filemanager/app/QFileAppStorePromoteManager;
    //   26: aload_0
    //   27: getfield 426	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager	Lcom/tencent/mobileqq/filemanager/app/QFileAppStorePromoteManager;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	FileManagerEngine
    //   30	6	1	localQFileAppStorePromoteManager	QFileAppStorePromoteManager
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  /* Error */
  public QFileMsgForwardManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 432	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager	Lcom/tencent/mobileqq/filemanager/app/QFileMsgForwardManager;
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 434	com/tencent/mobileqq/filemanager/app/QFileMsgForwardManager
    //   15: dup
    //   16: aload_0
    //   17: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokespecial 435	com/tencent/mobileqq/filemanager/app/QFileMsgForwardManager:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 432	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager	Lcom/tencent/mobileqq/filemanager/app/QFileMsgForwardManager;
    //   26: aload_0
    //   27: getfield 432	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager	Lcom/tencent/mobileqq/filemanager/app/QFileMsgForwardManager;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	FileManagerEngine
    //   30	6	1	localQFileMsgForwardManager	QFileMsgForwardManager
    //   37	4	1	localObject1	Object
    //   42	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	26	37	finally
    //   26	33	37	finally
    //   38	40	37	finally
    //   2	4	42	finally
    //   40	42	42	finally
  }
  
  public MMApkFileSafeChecker a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker = new MMApkFileSafeChecker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker.a();
      }
      MMApkFileSafeChecker localMMApkFileSafeChecker = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker;
      return localMMApkFileSafeChecker;
    }
    finally {}
  }
  
  public ThumbDownloadManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownloadManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownloadManager = new ThumbDownloadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      ThumbDownloadManager localThumbDownloadManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbDownloadManager;
      return localThumbDownloadManager;
    }
    finally {}
  }
  
  public ThumbHttpDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getThumbHttpDownloader need new ThumbHttpDownloader, thread id:");
          localStringBuilder.append(Thread.currentThread().getId());
          QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader = new ThumbHttpDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreThumbHttpDownloader;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.Uuid = paramFileManagerEntity.Uuid;
    localFileManagerEntity.selfUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerUin = paramFileManagerEntity.selfUin;
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.fileName = paramFileManagerEntity.fileName;
    localFileManagerEntity.fileSize = paramFileManagerEntity.fileSize;
    localFileManagerEntity.strThumbPath = paramFileManagerEntity.strThumbPath;
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 29;
    localFileManagerEntity.busId = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    paramString = a().a(paramFileManagerEntity, paramString);
    if (paramFileManagerEntity.peerType == 3000)
    {
      a(paramString, 20);
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("=_=k Id[");
      paramFileManagerEntity.append(paramString.nSessionId);
      paramFileManagerEntity.append("] SendDisc2Weiyun[");
      paramFileManagerEntity.append(paramString.fileName);
      paramFileManagerEntity.append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, paramFileManagerEntity.toString());
      return paramString;
    }
    e(paramString);
    paramFileManagerEntity = new StringBuilder();
    paramFileManagerEntity.append("=_=k Id[");
    paramFileManagerEntity.append(paramString.nSessionId);
    paramFileManagerEntity.append("] SendOffline2Weiyun[");
    paramFileManagerEntity.append(paramString.fileName);
    paramFileManagerEntity.append("]");
    QLog.i("FileManagerEngine<FileAssistant>", 1, paramFileManagerEntity.toString());
    return paramString;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = FileManagerUtil.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    localFileManagerEntity.uniseq = MessageRecordFactory.a(-1000).uniseq;
    localFileManagerEntity.nOpType = 26;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramInt);
    if ((paramFileManagerEntity.peerType != 3000) && (paramFileManagerEntity.peerType != 1)) {
      localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    } else {
      localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;
    }
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(paramFileManagerEntity.cloudType);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    if (QLog.isColorLevel())
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("insertForwardOfflineEntity FilemanagerEntity:");
      paramFileManagerEntity.append(FileManagerUtil.a(localFileManagerEntity));
      QLog.i("FileManagerEngine<FileAssistant>", 2, paramFileManagerEntity.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramFileManagerEntity, paramString1, paramString2, paramInt, paramBoolean, 0L, 0);
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
      }
      FileManagerUtil.a();
      return null;
    }
    String str = TransfileUtile.makeTransFileProtocolData("", 0L, 0, true);
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    if ((localFileManagerEntity.fileName == null) || (localFileManagerEntity.fileName.length() == 0)) {
      localFileManagerEntity.fileName = FileManagerUtil.a(localFileManagerEntity.getFilePath());
    }
    if ((localFileManagerEntity.getFilePath() == null) || (localFileManagerEntity.getFilePath().length() == 0)) {
      localFileManagerEntity.setFilePath(localFileManagerEntity.fileName);
    }
    long l = MessageRecordFactory.a(-1000).uniseq;
    ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(l, paramLong, paramInt2);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.nOpType = 7;
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt1);
    localFileManagerEntity.selfUin = paramString1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertForwardOfflineEntity FilemanagerEntity:");
      localStringBuilder.append(FileManagerUtil.a(localFileManagerEntity));
      QLog.i("FileManagerEngine<FileAssistant>", 2, localStringBuilder.toString());
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, localFileManagerEntity);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString2, paramString1, true, localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, l, localFileManagerEntity.msgUid, -1L, MessageCache.a());
      return localFileManagerEntity;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramString3, paramInt, paramBoolean, 0L, 0);
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, long paramLong, int paramInt2)
  {
    boolean bool = QFileAssistantUtils.a(paramString3);
    Object localObject1 = null;
    if (bool)
    {
      paramString2 = (String)localObject1;
      if (paramInt2 != 0)
      {
        paramString2 = new Bundle();
        paramString2.putLong("forward_origin_uni_seq", paramLong);
        paramString2.putInt("forward_id", paramInt2);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr.a(paramString1, paramString2);
    }
    if (paramInt1 == 3000) {
      return a().a(paramString1, paramString3);
    }
    if (paramBoolean) {
      return a().a(paramString1, paramString2, paramString3, paramInt1, paramLong, paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
      }
      return null;
    }
    int i = 0;
    String str = TransfileUtile.makeTransFileProtocolData(paramString1, 0L, 0, true);
    localObject1 = FileManagerUtil.a(paramString1);
    if (!paramBoolean) {
      i = 6;
    }
    if (paramBoolean)
    {
      long l = MessageRecordFactory.a(-1000).uniseq;
      ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(l, paramLong, paramInt2);
      paramLong = l;
    }
    else
    {
      paramLong = -1L;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramLong, paramString3, paramInt1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = i;
    localFileManagerEntity.fileSize = FileManagerUtil.a(paramString1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("toOffline[");
      ((StringBuilder)localObject2).append(String.valueOf(paramBoolean));
      ((StringBuilder)localObject2).append("], filepath[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("]:size[");
      ((StringBuilder)localObject2).append(String.valueOf(localFileManagerEntity.fileSize));
      ((StringBuilder)localObject2).append("]");
      QLog.d("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
    }
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramString3;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt1);
    localFileManagerEntity.setFilePath(paramString1);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.fileName = ((String)localObject1);
    localFileManagerEntity.nFileType = FileManagerUtil.a(paramString1);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = paramBoolean;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    localFileManagerEntity.strThumbPath = FileManagerUtil.a(paramString1, 150, 150, null);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = paramString2;
    FileManagerUtil.a((QQAppInterface)localObject2, (String)localObject1, paramString3, localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramString2 = (String)localObject1;
    if (paramInt1 != 1004) {
      if (paramInt1 == 1000)
      {
        paramString2 = (String)localObject1;
      }
      else if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = ((String)localObject1);
        localFileManagerEntity.tmpSessionToPhone = paramString3;
        paramString2 = (String)localObject1;
      }
      else
      {
        paramString2 = (String)localObject2;
      }
    }
    if (TextUtils.isEmpty(localFileManagerEntity.getFilePath()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Err: Id[");
      ((StringBuilder)localObject1).append(localFileManagerEntity.nSessionId);
      ((StringBuilder)localObject1).append("] sendLocalFile entryFilePath is null,strFilePath[");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("]");
      QLog.e("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      localObject1 = FileManagerUtil.a();
    }
    else
    {
      localObject1 = "";
    }
    paramString1 = new FileManagerEngine.1(this, localFileManagerEntity, paramBoolean, paramString3, paramString2, paramString1, paramInt1, str, paramLong, (String)localObject1);
    if (localFileManagerEntity.nFileType == 5)
    {
      if (!((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(localFileManagerEntity.getFilePath(), new FileManagerEngine.2(this, localFileManagerEntity, paramString1)))
      {
        QQFileManagerUtil.FileExecutor.a().execute(paramString1);
        return localFileManagerEntity;
      }
    }
    else {
      QQFileManagerUtil.FileExecutor.a().execute(paramString1);
    }
    return localFileManagerEntity;
  }
  
  public QFileC2CTransferWrapper a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper = new QFileC2CTransferWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      QFileC2CTransferWrapper localQFileC2CTransferWrapper = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper;
      return localQFileC2CTransferWrapper;
    }
    finally {}
  }
  
  public QFileDiscTransferWrapper a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper = new QFileDiscTransferWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      QFileDiscTransferWrapper localQFileDiscTransferWrapper = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper;
      return localQFileDiscTransferWrapper;
    }
    finally {}
  }
  
  public QFileTroopTransferWrapper a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper = new QFileTroopTransferWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      QFileTroopTransferWrapper localQFileTroopTransferWrapper = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper;
      return localQFileTroopTransferWrapper;
    }
    finally {}
  }
  
  public WeiYunLogicCenter a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter = new WeiYunLogicCenter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      WeiYunLogicCenter localWeiYunLogicCenter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter;
      return localWeiYunLogicCenter;
    }
    finally {}
  }
  
  public String a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader = new OfflineVideoThumbDownLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineVideoThumbDownLoader.a(paramFileManagerEntity, 7);
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader = new DiscPicThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscPicThumbDownloader.a(paramFileManagerEntity, paramInt);
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().b(paramString1, paramString2, paramInt, paramObject);
  }
  
  public ArrayList<FileManagerEntity> a()
  {
    Object localObject2 = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int j = 0;
    int i;
    for (;;)
    {
      i = k;
      if (j >= ((IFMDataCacheApi)localObject2).getOfflineFiles().size()) {
        break;
      }
      localObject1 = (OfflineFileInfo)((IFMDataCacheApi)localObject2).getOfflineFiles().get(j);
      localArrayList.add(a(FileManagerUtil.a((OfflineFileInfo)localObject1, 0), String.valueOf(((OfflineFileInfo)localObject1).a)));
      j += 1;
    }
    FileManagerEntity localFileManagerEntity;
    while (i < ((IFMDataCacheApi)localObject2).getRecentFiles().size())
    {
      localFileManagerEntity = (FileManagerEntity)((IFMDataCacheApi)localObject2).getRecentFiles().get(i);
      if (!localFileManagerEntity.sendCloudUnsuccessful())
      {
        ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(localFileManagerEntity);
        localObject1 = null;
        j = localFileManagerEntity.getCloudType();
        if (j != 1)
        {
          if ((j == 3) || (j == 5))
          {
            if (!FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
              break label255;
            }
            localObject1 = a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          }
        }
        else {
          localObject1 = a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
        }
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
      label255:
      i += 1;
    }
    Object localObject1 = ((IFMDataCacheApi)localObject2).getLocalFiles().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileInfo)((Iterator)localObject1).next();
      localFileManagerEntity = a(((FileInfo)localObject2).c(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
      localFileManagerEntity.strApkPackageName = ((FileInfo)localObject2).b();
      localArrayList.add(localFileManagerEntity);
    }
    return localArrayList;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localFileManagerEntity != null) {
      a(paramInt1, a(localFileManagerEntity), paramInt2);
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    a(paramInt, paramLong, paramString, 0L, 0);
  }
  
  public void a(int paramInt1, long paramLong1, String paramString, long paramLong2, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((FileManagerEntity)localObject1, paramString, 1);
    localFileManagerEntity.fProgress = 0.0F;
    try
    {
      localFileManagerEntity.TroopUin = Long.parseLong(paramString);
    }
    catch (Exception localException)
    {
      label49:
      Object localObject2;
      break label49;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FileManagerEngine<FileAssistant>", 2, FileManagerUtil.a());
    }
    localFileManagerEntity.status = 2;
    if (((FileManagerEntity)localObject1).peerType == 0)
    {
      localFileManagerEntity.nOpType = 26;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_=k Id[");
      ((StringBuilder)localObject2).append(localFileManagerEntity.nSessionId);
      ((StringBuilder)localObject2).append("] sendOffline2Troop[");
      ((StringBuilder)localObject2).append(localFileManagerEntity.fileName);
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    else if (((FileManagerEntity)localObject1).peerType == 3000)
    {
      localFileManagerEntity.nOpType = 27;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_=k Id[");
      ((StringBuilder)localObject2).append(localFileManagerEntity.nSessionId);
      ((StringBuilder)localObject2).append("] sendDisce2Troop[");
      ((StringBuilder)localObject2).append(localFileManagerEntity.fileName);
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    else if (((FileManagerEntity)localObject1).peerType == 6000)
    {
      localFileManagerEntity.nOpType = 32;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("=_=k Id[");
      ((StringBuilder)localObject2).append(localFileManagerEntity.nSessionId);
      ((StringBuilder)localObject2).append("] sendDataline2Troop[");
      ((StringBuilder)localObject2).append(localFileManagerEntity.fileName);
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty(localFileManagerEntity.strTroopFileUuid)) && (localFileManagerEntity.mContext != null)) {
      break label425;
    }
    localObject2 = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localFileManagerEntity.strTroopFileUuid = ((IForwardCallBack)localObject2).a(localFileManagerEntity.peerUin, ((FileManagerEntity)localObject1).peerType, paramString, ((FileManagerEntity)localObject1).peerType, localFileManagerEntity.Uuid, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.nSessionId, paramLong2, paramInt2);
    localFileManagerEntity.mContext = localObject2;
    label425:
    if ((localFileManagerEntity.busId != 102) && (localFileManagerEntity.busId != 104)) {
      localFileManagerEntity.busId = 102;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject1 = BaseApplicationImpl.getContext().getString(2131694475);
      localFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 19, new Object[] { Integer.valueOf(9004), localObject1, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(localFileManagerEntity.nSessionId) });
      if ((localFileManagerEntity.mContext instanceof IForwardCallBack)) {
        ((IForwardCallBack)localFileManagerEntity.mContext).a(false, localFileManagerEntity.strTroopFileUuid, paramLong1, 9004, (String)localObject1, paramString, "");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(102, paramInt1, localFileManagerEntity);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    a().a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString)
  {
    a(38, paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    a(3, paramLong, paramString, 0L, paramInt);
  }
  
  public void a(Context paramContext)
  {
    IFMDataCacheApi localIFMDataCacheApi = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    int j = localIFMDataCacheApi.getWeiYunFiles().size();
    int m = localIFMDataCacheApi.getOfflineFiles().size();
    Object localObject1 = localIFMDataCacheApi.getRecentFiles().iterator();
    int k = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext()) {
      if (((FileManagerEntity)((Iterator)localObject1).next()).nFileType == 13) {
        i += 1;
      }
    }
    int n = localIFMDataCacheApi.getRecentFiles().size() - i;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("=_= v> Download All Select File Start!, weiyun[");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("],offline[");
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append("],recent[");
    ((StringBuilder)localObject1).append(n);
    ((StringBuilder)localObject1).append("]");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = "FileManagerEngine<FileAssistant>";
    QLog.i("FileManagerEngine<FileAssistant>", 1, (String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downLoadAllSelectFiles,weiyun[");
      ((StringBuilder)localObject2).append(localIFMDataCacheApi.getWeiYunFiles().size());
      ((StringBuilder)localObject2).append("], offline[");
      ((StringBuilder)localObject2).append(localIFMDataCacheApi.getOfflineFiles().size());
      ((StringBuilder)localObject2).append("], recent[");
      ((StringBuilder)localObject2).append(localIFMDataCacheApi.getRecentFiles().size() - i);
      ((StringBuilder)localObject2).append("], localfile[");
      ((StringBuilder)localObject2).append(localIFMDataCacheApi.getLocalFiles().size());
      ((StringBuilder)localObject2).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
    }
    if ((i > 0) && (n == 0) && (j == 0) && (m == 0))
    {
      DialogUtil.a(paramContext, 230).setMessage(paramContext.getString(2131692567)).setNegativeButton(2131719065, new FileManagerEngine.3(this)).show();
      return;
    }
    i = 0;
    paramContext = (Context)localObject1;
    while (i < j)
    {
      localObject1 = FileManagerUtil.a((WeiYunFileInfo)localIFMDataCacheApi.getWeiYunFiles().get(i));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a((FileManagerEntity)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downWeiYunFiles,weiyun[");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("]");
        QLog.i(paramContext, 2, ((StringBuilder)localObject2).toString());
      }
      a(((FileManagerEntity)localObject1).nSessionId, ((FileManagerEntity)localObject1).uniseq, ((FileManagerEntity)localObject1).peerUin, ((FileManagerEntity)localObject1).peerType, 5);
      i += 1;
    }
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      localObject1 = FileManagerUtil.a((OfflineFileInfo)localIFMDataCacheApi.getOfflineFiles().get(j), 0);
      ((FileManagerEntity)localObject1).status = 2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downOfflineFiles,weiyun[");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("]");
        QLog.i(paramContext, 2, ((StringBuilder)localObject2).toString());
      }
      a(((FileManagerEntity)localObject1).nSessionId, ((FileManagerEntity)localObject1).uniseq, ((FileManagerEntity)localObject1).peerUin, ((FileManagerEntity)localObject1).peerType, 8);
      j += 1;
    }
    while (i < localIFMDataCacheApi.getRecentFiles().size())
    {
      localObject1 = (FileManagerEntity)localIFMDataCacheApi.getRecentFiles().get(i);
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName((FileManagerEntity)localObject1);
      if (((FileManagerEntity)localObject1).status != 16)
      {
        for (;;)
        {
          if (((FileManagerEntity)localObject1).nFileType != 13)
          {
            j = ((FileManagerEntity)localObject1).getCloudType();
            if (j == 1) {
              break;
            }
            if (j != 2)
            {
              if (j != 3)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("unknow type,Engity:");
                ((StringBuilder)localObject2).append(FileManagerUtil.a((FileManagerEntity)localObject1));
                QLog.e(paramContext, 2, ((StringBuilder)localObject2).toString());
              }
              else if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("=_= v> downRecentFiles,local[");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append("] break");
                QLog.i(paramContext, 2, ((StringBuilder)localObject1).toString());
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("downRecentFiles,weiyun[");
                ((StringBuilder)localObject2).append(i);
                ((StringBuilder)localObject2).append("]");
                QLog.i(paramContext, 2, ((StringBuilder)localObject2).toString());
              }
              a(((FileManagerEntity)localObject1).nSessionId, ((FileManagerEntity)localObject1).uniseq, ((FileManagerEntity)localObject1).peerUin, ((FileManagerEntity)localObject1).peerType, 5);
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("downRecentFiles,offline[");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("]");
          QLog.i(paramContext, 2, ((StringBuilder)localObject2).toString());
        }
        if ((((FileManagerEntity)localObject1).bSend == true) && (((FileManagerEntity)localObject1).status != 1) && (((FileManagerEntity)localObject1).status != -1) && (((FileManagerEntity)localObject1).status != 3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("=_= v> downRecentFiles,but Id[");
          ((StringBuilder)localObject2).append(((FileManagerEntity)localObject1).nSessionId);
          ((StringBuilder)localObject2).append("] is sendStatus but no Success! continiu");
          QLog.w(paramContext, 2, ((StringBuilder)localObject2).toString());
        }
        else
        {
          a(((FileManagerEntity)localObject1).nSessionId, ((FileManagerEntity)localObject1).uniseq, ((FileManagerEntity)localObject1).peerUin, ((FileManagerEntity)localObject1).peerType, 8);
        }
      }
      i += 1;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, FileManagerEntity paramFileManagerEntity, FMConstants.RevertMsgCallback paramRevertMsgCallback)
  {
    if (paramFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramMessageRecord.frienduin, paramMessageRecord.senderuin, paramFileManagerEntity.Uuid, paramRevertMsgCallback);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramFileManagerEntity, paramRevertMsgCallback);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131692554);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 19, new Object[] { Integer.valueOf(0), localObject, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ForwardOfflineFile, nId[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("], opType[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nOpType);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if ((QFileAssistantUtils.a()) && (!QFileAssistantUtils.a(paramFileManagerEntity.peerUin)) && (localObject != null) && (((ShieldMsgManger)localObject).a(paramFileManagerEntity.peerUin)))
    {
      FileManagerUtil.a(HardCodeUtil.a(2131704661));
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 19, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    if (paramFileManagerEntity.nOpType == 28)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_=k Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] SendOf2Disc[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(106, paramFileManagerEntity);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_=k Id[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("] SendOf2Of[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramFileManagerEntity);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    a(paramFileManagerEntity, paramInt, 0L, 0);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.nOpType = paramInt1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ForwardDisc2X, nOperationType[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    QLog.e("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    int i = 3;
    if ((paramInt1 != 27) && (!NetworkUtil.isNetSupport(BaseApplication.getContext())))
    {
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 34, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ForwardDisc2X, nId[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject).append("], type[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    paramFileManagerEntity.bSend = true;
    paramFileManagerEntity.fProgress = 0.0F;
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = paramInt1;
    if (paramInt1 != 27)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = 0;
        break;
      case 22: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_=k Id[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("] Disc2Disc[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.fileSize, paramFileManagerEntity.selfUin, paramFileManagerEntity.fileName, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5);
        return;
      case 21: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_=k Id[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("] Disc2Offline[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        paramInt2 = i;
        break;
      case 20: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_=k Id[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("] Disc2Weiyun[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        paramInt2 = 25;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_=k Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] Disc2Troop[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      if ((!TextUtils.isEmpty(paramFileManagerEntity.strTroopFileUuid)) && (paramFileManagerEntity.mContext != null)) {
        break label722;
      }
      localObject = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramFileManagerEntity.strTroopFileUuid = ((IForwardCallBack)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileManagerEntity.peerType, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.nSessionId, paramLong, paramInt2);
      paramFileManagerEntity.mContext = localObject;
      label722:
      if ((paramFileManagerEntity.busId != 102) && (paramFileManagerEntity.busId != 104)) {
        paramFileManagerEntity.busId = 102;
      }
      i = paramFileManagerEntity.busId;
      paramInt2 = i;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramInt2 = i;
        if ((paramFileManagerEntity.mContext instanceof IForwardCallBack))
        {
          localObject = BaseApplicationImpl.getContext().getString(2131694475);
          ((IForwardCallBack)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, 9004, (String)localObject, String.valueOf(paramFileManagerEntity.peerUin), "");
          return;
        }
      }
    }
    if (paramFileManagerEntity.selfUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ForwardDisc2X, nId[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("], type[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("] error");
      localObject = ((StringBuilder)localObject).toString();
      String str = "FileManagerEngine<FileAssistant>";
      QLog.e(str, 1, (String)localObject);
      if (QLog.isDevelopLevel())
      {
        QLog.e(str, 1, "多人聊天转发，selfUin不能为自己！！！");
        throw new NullPointerException(HardCodeUtil.a(2131704659));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ForwardDisc2X");
      ((StringBuilder)localObject).append(FileManagerUtil.a(paramFileManagerEntity));
      QLog.i("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 20) {
      ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramFileManagerEntity, paramInt2);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    a(paramFileManagerEntity, paramString1, paramString2, paramInt, 0);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramFileManagerEntity = a().a(paramFileManagerEntity, paramString1, paramString2, paramInt1, paramInt2);
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, paramFileManagerEntity);
    a().a(paramFileManagerEntity, paramInt1, false);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    a().a(paramWeiYunFileInfo);
  }
  
  public void a(String paramString)
  {
    a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    IFMDataCacheApi localIFMDataCacheApi = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    int i = 0;
    while (i < localIFMDataCacheApi.getWeiYunFiles().size())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIFMDataCacheApi.getWeiYunFiles().get(i);
      FileManagerReporter.a("0X8005415");
      b(FileManagerUtil.a(localWeiYunFileInfo), paramString1, paramString2, paramInt);
      i += 1;
    }
    if (localIFMDataCacheApi.getWeiYunFiles().size() > 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB7", "0X800AFB7", 0, localIFMDataCacheApi.getWeiYunFiles().size(), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteOfflineFile, peerUin[");
    localStringBuilder.append(FileManagerUtil.d(paramString1));
    localStringBuilder.append("],fileName[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("],uuid[");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("]");
    QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString1, paramString3, paramString4, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("delAllSelectedFiles, bDelLocalFile[");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    Object localObject2 = new ArrayList();
    Iterator localIterator = ((IFMDataCacheApi)localObject1).getLocalFiles().iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (FileInfo)localIterator.next();
      if (((FileInfo)localObject3).a())
      {
        localObject3 = ((FileInfo)localObject3).c();
        Object localObject4;
        try
        {
          localObject4 = new VFSFile((String)localObject3);
          ((List)localObject2).add(localObject3);
          ((VFSFile)localObject4).delete();
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("delAllSelectedFiles local exception:");
          ((StringBuilder)localObject4).append(localException.toString());
          QLog.e("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject4).toString());
        }
      }
    }
    int i = ((List)localObject2).size();
    int k = 0;
    if (i > 0) {
      MediaScannerConnection.scanFile(BaseApplication.getContext(), (String[])((List)localObject2).toArray(new String[0]), null, null);
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= ((IFMDataCacheApi)localObject1).getWeiYunFiles().size()) {
        break;
      }
      a((WeiYunFileInfo)((IFMDataCacheApi)localObject1).getWeiYunFiles().get(i));
      i += 1;
    }
    while (j < ((IFMDataCacheApi)localObject1).getRecentFiles().size())
    {
      localObject2 = (FileManagerEntity)((IFMDataCacheApi)localObject1).getRecentFiles().get(j);
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName((FileManagerEntity)localObject2);
      b(((FileManagerEntity)localObject2).nSessionId);
      j += 1;
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 714
    //   3: invokestatic 319	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6: checkcast 714	com/tencent/mobileqq/filemanager/api/IFMDataCacheApi
    //   9: astore 9
    //   11: aload 9
    //   13: invokeinterface 861 1 0
    //   18: invokevirtual 725	java/util/ArrayList:size	()I
    //   21: istore 5
    //   23: aload 9
    //   25: invokeinterface 722 1 0
    //   30: invokevirtual 725	java/util/ArrayList:size	()I
    //   33: istore 6
    //   35: aload 9
    //   37: invokeinterface 743 1 0
    //   42: invokevirtual 725	java/util/ArrayList:size	()I
    //   45: istore 7
    //   47: aload 9
    //   49: invokeinterface 766 1 0
    //   54: invokeinterface 877 1 0
    //   59: istore 8
    //   61: new 138	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   68: astore 10
    //   70: aload 10
    //   72: ldc_w 1095
    //   75: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 10
    //   81: iload 5
    //   83: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 10
    //   89: ldc_w 866
    //   92: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 10
    //   98: iload 6
    //   100: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 10
    //   106: ldc_w 868
    //   109: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: iload 7
    //   117: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 10
    //   123: ldc_w 1097
    //   126: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 10
    //   132: iload 8
    //   134: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 10
    //   140: ldc_w 1099
    //   143: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 10
    //   149: aload_2
    //   150: invokestatic 1053	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 10
    //   159: ldc_w 1101
    //   162: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 10
    //   168: aload_3
    //   169: invokestatic 1053	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 10
    //   178: ldc_w 1103
    //   181: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 10
    //   187: iload 4
    //   189: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 10
    //   195: ldc 208
    //   197: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 150
    //   203: iconst_1
    //   204: aload 10
    //   206: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_0
    //   213: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: invokevirtual 1107	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   219: ldc_w 1109
    //   222: iconst_0
    //   223: invokevirtual 1115	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   226: invokeinterface 1121 1 0
    //   231: astore 10
    //   233: aload 10
    //   235: ldc_w 1123
    //   238: iconst_1
    //   239: invokeinterface 1129 3 0
    //   244: pop
    //   245: aload 10
    //   247: invokeinterface 1132 1 0
    //   252: pop
    //   253: aload 9
    //   255: invokeinterface 861 1 0
    //   260: invokevirtual 725	java/util/ArrayList:size	()I
    //   263: ifne +175 -> 438
    //   266: aload 9
    //   268: invokeinterface 722 1 0
    //   273: invokevirtual 725	java/util/ArrayList:size	()I
    //   276: ifne +162 -> 438
    //   279: aload 9
    //   281: invokeinterface 1135 1 0
    //   286: invokevirtual 725	java/util/ArrayList:size	()I
    //   289: ifne +149 -> 438
    //   292: aload 9
    //   294: invokeinterface 766 1 0
    //   299: astore 10
    //   301: aload 9
    //   303: invokeinterface 743 1 0
    //   308: astore 11
    //   310: aload 10
    //   312: invokeinterface 772 1 0
    //   317: astore 12
    //   319: iconst_0
    //   320: istore 5
    //   322: aload 12
    //   324: invokeinterface 777 1 0
    //   329: ifeq +31 -> 360
    //   332: aload 12
    //   334: invokeinterface 781 1 0
    //   339: checkcast 783	com/tencent/mobileqq/filemanager/data/FileInfo
    //   342: invokevirtual 785	com/tencent/mobileqq/filemanager/data/FileInfo:c	()Ljava/lang/String;
    //   345: invokestatic 1138	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   348: ifne -26 -> 322
    //   351: iload 5
    //   353: iconst_1
    //   354: iadd
    //   355: istore 5
    //   357: goto -35 -> 322
    //   360: aload 11
    //   362: invokevirtual 862	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   365: astore 12
    //   367: aload 12
    //   369: invokeinterface 777 1 0
    //   374: ifeq +30 -> 404
    //   377: aload 12
    //   379: invokeinterface 781 1 0
    //   384: checkcast 98	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   387: getfield 356	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   390: bipush 16
    //   392: if_icmpne -25 -> 367
    //   395: iload 5
    //   397: iconst_1
    //   398: iadd
    //   399: istore 5
    //   401: goto -34 -> 367
    //   404: iload 5
    //   406: aload 10
    //   408: invokeinterface 877 1 0
    //   413: aload 11
    //   415: invokevirtual 725	java/util/ArrayList:size	()I
    //   418: iadd
    //   419: if_icmpne +19 -> 438
    //   422: ldc 150
    //   424: iconst_1
    //   425: ldc_w 1140
    //   428: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: ldc_w 1141
    //   434: invokestatic 1145	com/tencent/mobileqq/filemanager/util/FMToastUtil:a	(I)V
    //   437: return
    //   438: aload_0
    //   439: aload_2
    //   440: aload_3
    //   441: iload 4
    //   443: invokevirtual 1147	com/tencent/mobileqq/filemanager/app/FileManagerEngine:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   446: aload_0
    //   447: aload_2
    //   448: aload_3
    //   449: iload 4
    //   451: invokevirtual 1149	com/tencent/mobileqq/filemanager/app/FileManagerEngine:b	(Ljava/lang/String;Ljava/lang/String;I)V
    //   454: aload_0
    //   455: iload_1
    //   456: aload_2
    //   457: aload_3
    //   458: iload 4
    //   460: invokevirtual 1151	com/tencent/mobileqq/filemanager/app/FileManagerEngine:b	(ZLjava/lang/String;Ljava/lang/String;I)V
    //   463: aload_0
    //   464: iload_1
    //   465: aload_2
    //   466: aload_3
    //   467: iload 4
    //   469: invokevirtual 1153	com/tencent/mobileqq/filemanager/app/FileManagerEngine:c	(ZLjava/lang/String;Ljava/lang/String;I)V
    //   472: aload_0
    //   473: aload_2
    //   474: aload_3
    //   475: iload 4
    //   477: invokevirtual 1155	com/tencent/mobileqq/filemanager/app/FileManagerEngine:c	(Ljava/lang/String;Ljava/lang/String;I)V
    //   480: iload 4
    //   482: iconst_1
    //   483: if_icmpne +257 -> 740
    //   486: aload 9
    //   488: invokeinterface 861 1 0
    //   493: invokevirtual 725	java/util/ArrayList:size	()I
    //   496: ifle +238 -> 734
    //   499: iconst_1
    //   500: istore 6
    //   502: goto +3 -> 505
    //   505: iload 6
    //   507: istore 5
    //   509: aload 9
    //   511: invokeinterface 766 1 0
    //   516: invokeinterface 877 1 0
    //   521: ifle +10 -> 531
    //   524: iload 6
    //   526: bipush 10
    //   528: iadd
    //   529: istore 5
    //   531: iload 5
    //   533: istore 6
    //   535: aload 9
    //   537: invokeinterface 743 1 0
    //   542: invokevirtual 725	java/util/ArrayList:size	()I
    //   545: ifle +10 -> 555
    //   548: iload 5
    //   550: bipush 100
    //   552: iadd
    //   553: istore 6
    //   555: aload_0
    //   556: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   559: astore_2
    //   560: ldc_w 1157
    //   563: iconst_1
    //   564: anewarray 4	java/lang/Object
    //   567: dup
    //   568: iconst_0
    //   569: iload 6
    //   571: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: aastore
    //   575: invokestatic 1161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   578: astore 9
    //   580: aload_2
    //   581: ldc_w 1163
    //   584: ldc_w 1165
    //   587: ldc_w 368
    //   590: ldc_w 1167
    //   593: ldc_w 1169
    //   596: iconst_0
    //   597: iconst_0
    //   598: aload_3
    //   599: aload 9
    //   601: ldc_w 368
    //   604: ldc_w 368
    //   607: invokestatic 1172	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   610: goto +3 -> 613
    //   613: aload_0
    //   614: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   617: invokevirtual 757	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   620: invokestatic 1174	com/tencent/mobileqq/filemanager/util/FileManagerUtil:d	(Ljava/lang/String;)I
    //   623: istore 5
    //   625: iload 4
    //   627: ifne +106 -> 733
    //   630: iload 5
    //   632: iconst_3
    //   633: if_icmpge +100 -> 733
    //   636: aload_0
    //   637: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   640: invokevirtual 757	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   643: aload_3
    //   644: invokestatic 1177	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   647: ifeq +86 -> 733
    //   650: aload_0
    //   651: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   654: invokevirtual 757	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   657: aload_3
    //   658: iconst_0
    //   659: invokestatic 1180	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   662: invokestatic 835	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   665: ldc_w 1181
    //   668: invokevirtual 840	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   671: astore_2
    //   672: aload_0
    //   673: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   676: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getFileManagerDataCenter	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   679: aload_3
    //   680: aload_0
    //   681: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   684: invokevirtual 757	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   687: iload 4
    //   689: sipush -3009
    //   692: aload_2
    //   693: invokevirtual 1184	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)J
    //   696: pop2
    //   697: aload_0
    //   698: getfield 41	com/tencent/mobileqq/filemanager/app/FileManagerEngine:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   701: invokevirtual 757	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   704: astore_2
    //   705: aload_2
    //   706: iload 5
    //   708: iconst_1
    //   709: iadd
    //   710: invokestatic 1186	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;I)V
    //   713: return
    //   714: astore_2
    //   715: goto +8 -> 723
    //   718: astore_2
    //   719: goto +4 -> 723
    //   722: astore_2
    //   723: ldc 150
    //   725: iconst_1
    //   726: aload_2
    //   727: invokevirtual 1189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   730: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: return
    //   734: iconst_0
    //   735: istore 6
    //   737: goto -232 -> 505
    //   740: goto -127 -> 613
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	FileManagerEngine
    //   0	743	1	paramBoolean	boolean
    //   0	743	2	paramString1	String
    //   0	743	3	paramString2	String
    //   0	743	4	paramInt	int
    //   21	689	5	i	int
    //   33	703	6	j	int
    //   45	71	7	k	int
    //   59	74	8	m	int
    //   9	591	9	localObject1	Object
    //   68	339	10	localObject2	Object
    //   308	106	11	localArrayList	ArrayList
    //   317	61	12	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   705	713	714	java/lang/Exception
    //   580	610	718	java/lang/Exception
    //   613	625	718	java/lang/Exception
    //   636	705	718	java/lang/Exception
    //   212	319	722	java/lang/Exception
    //   322	351	722	java/lang/Exception
    //   360	367	722	java/lang/Exception
    //   367	395	722	java/lang/Exception
    //   404	437	722	java/lang/Exception
    //   438	480	722	java/lang/Exception
    //   486	499	722	java/lang/Exception
    //   509	524	722	java/lang/Exception
    //   535	548	722	java/lang/Exception
    //   555	580	722	java/lang/Exception
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public boolean a(int paramInt1, FileManagerEntity paramFileManagerEntity, int paramInt2)
  {
    long l = paramFileManagerEntity.datalineEntitySessionId;
    Long localLong = Long.valueOf(0L);
    Object localObject;
    if (0L == l)
    {
      localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      paramFileManagerEntity.datalineEntitySessionId = ((IForwardCallBack)localObject).a(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.selfUin, paramInt1, paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.fileSize, 0);
      paramFileManagerEntity.mContext = localObject;
    }
    else if (paramFileManagerEntity.mContext == null)
    {
      paramFileManagerEntity.mContext = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = BaseApplicationImpl.getContext().getString(2131694475);
      paramFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 19, new Object[] { Integer.valueOf(9004), localObject, localLong, localLong, null, Long.valueOf(paramFileManagerEntity.nSessionId) });
      if ((paramFileManagerEntity.mContext instanceof IForwardCallBack)) {
        ((IForwardCallBack)paramFileManagerEntity.mContext).a(false, paramFileManagerEntity.datalineEntitySessionId, 9004, (String)localObject, null, null, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(38, paramInt1, paramFileManagerEntity);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sessionid[");
    ((StringBuilder)localObject).append(String.valueOf(paramLong));
    ((StringBuilder)localObject).append("] call Pause");
    QLog.i("FileManagerEngine<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sessionid[");
        ((StringBuilder)localObject).append(String.valueOf(paramLong));
        ((StringBuilder)localObject).append("] item is not exist");
        QLog.w("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if ((((FileManagerEntity)localObject).getCloudType() == 0) && (1 != ((FileManagerEntity)localObject).nOpType))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramLong);
      return true;
    }
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).equals(((FileManagerEntity)localObject).peerUin))
    {
      if (((FileManagerEntity)localObject).bSend) {
        return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr.a((FileManagerEntity)localObject);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr.b((FileManagerEntity)localObject);
    }
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData;
    if (1 == ((FileManagerEntity)localObject).nOpType)
    {
      localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "recv_file_cancel";
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
    }
    else if (((FileManagerEntity)localObject).nOpType == 0)
    {
      localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
      localFileAssistantReportData.b = "send_file_cancel";
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
    }
    if (((FileManagerEntity)localObject).nOpType == 0)
    {
      if (((FileManagerEntity)localObject).peerType == 3000) {
        return a().a(paramLong);
      }
      return a().a(paramLong);
    }
    if (paramLong > 0L) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(paramLong);
    }
    if ((((FileManagerEntity)localObject).peerUin != null) && (((FileManagerEntity)localObject).uniseq != -1L))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 2, "Pause: can not find file entity info.");
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).uniseq, ((FileManagerEntity)localObject).peerType);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    return a(paramLong1, paramString, paramLong2, paramLong3, paramInt1, paramInt2, 0L, 0);
  }
  
  public boolean a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, int paramInt3)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1);
    if (localFileManagerEntity == null) {
      return false;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = localFileManagerEntity.fileName;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("");
      QLog.d("FileManagerEngine<FileAssistant>", 2, String.format("ForwardTroopFile==>fileName:%s|mEntrySessionID:%s|old filePath:%s", new Object[] { localObject1, ((StringBuilder)localObject2).toString(), localFileManagerEntity.strTroopFilePath }));
    }
    Object localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2, localFileManagerEntity.Uuid, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
    if ((localObject1 != null) && (((TroopFileStatusInfo)localObject1).e != null))
    {
      if (paramInt1 == 1)
      {
        int k = Math.abs(new Random().nextInt());
        localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3).a(((TroopFileStatusInfo)localObject1).e, paramLong2, ((TroopFileStatusInfo)localObject1).g, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopFileStatusInfo)localObject1).c, ((TroopFileStatusInfo)localObject1).h, k, paramLong1);
        if (localObject2 == null)
        {
          QLog.e("FileManagerEngine<FileAssistant>", 1, "infoNew is null!!!");
          return false;
        }
        paramInt1 = FileManagerUtil.a(((TroopFileStatusInfo)localObject1).g);
        if (paramInt1 == 0)
        {
          if (FileUtil.b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString))
          {
            paramString = new BitmapFactory.Options();
            paramString.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString, paramString);
            paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), ((TroopFileStatusInfo)localObject2).g, ((TroopFileStatusInfo)localObject2).c, ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID.toString(), k, String.valueOf(((TroopFileStatusInfo)localObject1).b), paramLong1, paramString.outWidth, paramString.outHeight, paramLong4, paramInt3);
          }
          else
          {
            paramString = (MessageForTroopFile)FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), String.valueOf(((TroopFileStatusInfo)localObject1).b), 1, ((TroopFileStatusInfo)localObject1).e);
            if (paramString != null) {
              paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), ((TroopFileStatusInfo)localObject2).g, ((TroopFileStatusInfo)localObject2).c, ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID.toString(), k, String.valueOf(((TroopFileStatusInfo)localObject1).b), paramLong1, paramString.width, paramString.height, paramLong4, paramInt3);
            } else {
              paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), ((TroopFileStatusInfo)localObject2).g, ((TroopFileStatusInfo)localObject2).c, ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID.toString(), k, String.valueOf(((TroopFileStatusInfo)localObject1).b), paramLong1, paramLong4, paramInt3);
            }
          }
        }
        else if (paramInt1 == 2)
        {
          if (FileUtil.b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString))
          {
            paramString = ShortVideoUtils.getVideoFileRtAndTime(paramString);
            paramInt2 = paramString[0];
            paramInt1 = paramString[1];
          }
          for (int i = paramString[3];; i = paramString.duration)
          {
            int j = paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = j;
            break label589;
            paramString = (MessageForTroopFile)FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), String.valueOf(((TroopFileStatusInfo)localObject1).b), 1, ((TroopFileStatusInfo)localObject1).e);
            if (paramString == null) {
              break;
            }
            paramInt2 = paramString.width;
            paramInt1 = paramString.height;
          }
          paramInt1 = 0;
          paramInt2 = 0;
          i = 0;
          label589:
          paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), ((TroopFileStatusInfo)localObject2).g, ((TroopFileStatusInfo)localObject2).c, ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID.toString(), k, String.valueOf(((TroopFileStatusInfo)localObject1).b), paramLong1, paramInt1, paramInt2, i, paramLong4, paramInt3);
        }
        else
        {
          paramLong2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), ((TroopFileStatusInfo)localObject2).g, ((TroopFileStatusInfo)localObject2).c, ((TroopFileStatusInfo)localObject2).jdField_a_of_type_JavaUtilUUID.toString(), k, String.valueOf(((TroopFileStatusInfo)localObject1).b), paramLong1, paramLong4, paramInt3);
        }
        localFileManagerEntity.structMsgSeq = paramLong2;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("ForwardTroopFile, startCopyToGroup, entrySessionID:");
          paramString.append(paramLong1);
          paramString.append("|InsertAIOMsg, msgSeq:");
          paramString.append(paramLong2);
          QLog.d("FileManagerEngine<FileAssistant>", 2, paramString.toString());
        }
        return true;
      }
      if ((paramInt1 != 3000) && (paramInt1 != 0))
      {
        boolean bool;
        if (paramInt1 == 7)
        {
          paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
          if (paramLong2 == 0L) {
            paramLong2 = localFileManagerEntity.TroopUin;
          }
          if (localFileManagerEntity.datalineEntitySessionId != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramString.a(paramInt2, paramLong2, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0), paramLong4, paramInt3, null);
        }
        else if (paramInt1 == 6003)
        {
          paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
          if (paramLong2 == 0L) {
            paramLong2 = localFileManagerEntity.TroopUin;
          }
          if (localFileManagerEntity.datalineEntitySessionId != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramString.a(paramInt2, paramLong2, localFileManagerEntity.busId, paramLong3, 7, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, bool, localFileManagerEntity.datalineEntitySessionId, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1), paramLong4, paramInt3, null);
        }
        return true;
      }
      paramString = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong2);
      if (paramLong2 == 0L) {
        paramLong2 = localFileManagerEntity.TroopUin;
      }
      localObject1 = new Bundle();
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkPackageName)) {
        ((Bundle)localObject1).putString("yyb_apk_package_name_key", localFileManagerEntity.yybApkPackageName);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkName)) {
        ((Bundle)localObject1).putString("yyb_apk_name_key", localFileManagerEntity.yybApkName);
      }
      if (!TextUtils.isEmpty(localFileManagerEntity.yybApkIconUrl)) {
        ((Bundle)localObject1).putString("yyb_apk_icon_url_key", localFileManagerEntity.yybApkIconUrl);
      }
      paramString.a(paramInt2, paramLong2, localFileManagerEntity.busId, paramLong3, paramInt1, localFileManagerEntity.fileName, localFileManagerEntity.strThumbPath, localFileManagerEntity.fileSize, localFileManagerEntity.strTroopFilePath, false, 0L, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), paramLong4, paramInt3, (Bundle)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramLong, paramString1, paramString2, paramInt, paramBoolean, 0);
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
      }
      return false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Printe FileManagerEntity InfoItem [");
      ((StringBuilder)localObject).append(FileManagerUtil.a(localFileManagerEntity));
      ((StringBuilder)localObject).append(" ]");
      QLog.d("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.b(localFileManagerEntity);
    }
    if ((localFileManagerEntity.getCloudType() == 2) && (localFileManagerEntity.WeiYunFileId != null) && (paramBoolean))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Send lastOperation list type id weiyun to offlinefile, fileid[");
        ((StringBuilder)localObject).append(localFileManagerEntity.WeiYunFileId);
        ((StringBuilder)localObject).append("], filename[");
        ((StringBuilder)localObject).append(localFileManagerEntity.fileName);
        ((StringBuilder)localObject).append("], filename[");
        ((StringBuilder)localObject).append(localFileManagerEntity.fileSize);
        ((StringBuilder)localObject).append("]");
        QLog.d("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      FileManagerUtil.b(localFileManagerEntity.nSessionId);
      if (TextUtils.isEmpty(paramString1)) {
        a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2, paramInt1);
      } else {
        b(localFileManagerEntity, paramString1, paramString2, paramInt1);
      }
    }
    else
    {
      if (!FMConstants.a(localFileManagerEntity.Uuid)) {
        break label306;
      }
      ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).sendTDoc2Chat(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity, paramString2, paramInt1);
    }
    for (;;)
    {
      return false;
      label306:
      if ((localFileManagerEntity.getCloudType() == 1) && (!TextUtils.isEmpty(localFileManagerEntity.Uuid)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cloud is offline,so try offline to offline!, nSessionId[");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append("], strSendUin[");
          ((StringBuilder)localObject).append(FileManagerUtil.d(paramString1));
          ((StringBuilder)localObject).append("], recvUin[");
          ((StringBuilder)localObject).append(FileManagerUtil.d(paramString2));
          ((StringBuilder)localObject).append("], peerType[");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append("], toOffline[");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append("]");
          QLog.d("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((paramInt1 == 1004) || (paramInt1 == 1000) || (paramInt1 == 1006)) {
          localObject = paramString1;
        }
        if (paramInt1 == 1)
        {
          d(paramLong, paramString2);
          return false;
        }
        localObject = a(localFileManagerEntity, (String)localObject, paramString2, paramInt1, true, 0L, paramInt2);
        FileManagerUtil.b(((FileManagerEntity)localObject).nSessionId);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, (FileManagerEntity)localObject);
        ((FileManagerEntity)localObject).peerType = localFileManagerEntity.peerType;
        if (localFileManagerEntity.peerType == 3000)
        {
          ((FileManagerEntity)localObject).selfUin = localFileManagerEntity.peerUin;
          if (paramInt1 == 3000)
          {
            paramString1 = new StringBuilder();
            paramString1.append("=_=k Id[");
            paramString1.append(((FileManagerEntity)localObject).nSessionId);
            paramString1.append("] SendDisc2Disc[");
            paramString1.append(((FileManagerEntity)localObject).fileName);
            paramString1.append("]");
            QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.toString());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((FileManagerEntity)localObject, 22);
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("=_=k Id[");
            paramString1.append(((FileManagerEntity)localObject).nSessionId);
            paramString1.append("] SendDisc2Offline[");
            paramString1.append(((FileManagerEntity)localObject).fileName);
            paramString1.append("]");
            QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.toString());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((FileManagerEntity)localObject, 21);
          }
        }
        else
        {
          if (paramInt1 == 3000)
          {
            ((FileManagerEntity)localObject).nOpType = 28;
            paramString1 = new StringBuilder();
            paramString1.append("=_=k Id[");
            paramString1.append(((FileManagerEntity)localObject).nSessionId);
            paramString1.append("] SendOfline2Disc[");
            paramString1.append(((FileManagerEntity)localObject).fileName);
            paramString1.append("]");
            QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.toString());
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("=_=k Id[");
            paramString1.append(((FileManagerEntity)localObject).nSessionId);
            paramString1.append("] SendOfline2Offline[");
            paramString1.append(((FileManagerEntity)localObject).fileName);
            paramString1.append("]");
            QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.toString());
          }
          a((FileManagerEntity)localObject);
        }
      }
      else if (localFileManagerEntity.getFilePath() != null)
      {
        if (paramInt1 == 1) {
          a(localFileManagerEntity.getFilePath(), paramString2);
        } else {
          return a(localFileManagerEntity.getFilePath(), paramString1, paramString2, paramInt1, paramBoolean) != null;
        }
      }
      else
      {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=_= r [CS Send] Id[");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      localStringBuilder.append("]Send FavFile to Troop ");
      QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
      if (FileUtil.a(paramFileManagerEntity.getFilePath()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramFileManagerEntity.getFilePath(), paramString, 0L, paramInt2);
        return true;
      }
      new QfavFileForwardManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
      return true;
    }
    if (paramInt1 == 6000)
    {
      new QfavFileForwardManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
      return true;
    }
    if (paramInt1 == 0)
    {
      new QfavFileForwardManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramFileManagerEntity, Long.parseLong(paramString), 0L, paramInt2);
      paramString = new StringBuilder();
      paramString.append("=_= r [CS Send] Id[");
      paramString.append(paramFileManagerEntity.nSessionId);
      paramString.append("]Send QfavFile to offline ");
      QLog.i("FileManagerEngine<FileAssistant>", 1, paramString.toString());
      return true;
    }
    if (paramInt1 == 3000)
    {
      if (FileUtil.a(paramFileManagerEntity.getFilePath()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString, paramInt1, true, 0L, paramInt2);
        return true;
      }
      FMToastUtil.a(2131692730);
      return false;
    }
    paramString = new StringBuilder();
    paramString.append("=_= r [CS Send] Id[");
    paramString.append(paramFileManagerEntity.nSessionId);
    paramString.append("]Send QfavFile to peerType:");
    paramString.append(paramInt1);
    QLog.e("FileManagerEngine<FileAssistant>", 1, paramString.toString());
    FMToastUtil.a(2131692730);
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0L, 0);
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramString2));
    if (localObject != null)
    {
      int i = Math.abs(new Random().nextInt());
      localObject = ((TroopFileTransferManager)localObject).a(paramString1, true, i);
      if (localObject == null)
      {
        QLog.e("FileManagerEngine<FileAssistant>", 1, "sendLocalFileByTroop startUpload return info is nlll!");
        return false;
      }
      VFSFile localVFSFile = new VFSFile(paramString1);
      if (FileManagerUtil.a(paramString1) == 0)
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        FilePicURLDrawlableHelper.a(paramString1, localOptions);
        TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, localOptions.outWidth, localOptions.outHeight, paramLong, paramInt);
        return true;
      }
      if (FileManagerUtil.a(paramString1) == 2)
      {
        paramString1 = ShortVideoUtils.getVideoFileRtAndTime(paramString1);
        TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramString1[0], paramString1[1], paramString1[2], paramLong, paramInt);
        return true;
      }
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, localVFSFile.getName(), localVFSFile.length(), ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString(), i, null, 0L, paramLong, paramInt);
    }
    return true;
  }
  
  public String b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader = new DiscVideoThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreDiscVideoThumbDownloader.a(paramFileManagerEntity, 7);
  }
  
  public String b(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a().a(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void b()
  {
    BaseApplicationImpl.sApplication.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine$MyRecv);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine$MyRecv = null;
    FMSettings.a().free();
    FileViewMusicService.a().c();
    FileVideoDownloadManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilFileResultWatchForObserver;
    if (localObject != null)
    {
      ((FileResultWatchForObserver)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilFileResultWatchForObserver = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr;
    if (localObject != null) {
      ((FileAssistantMgr)localObject).a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObservers();
      QLog.i("FileManagerEngine<FileAssistant><QFile>", 1, "free: remove all file observers.");
      label124:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker;
      if (localObject != null) {
        ((MMApkFileSafeChecker)localObject).b();
      }
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).free();
      return;
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
  
  public void b(long paramLong, String paramString) {}
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "forwardToDatalineFromFileAssistant entity is null!");
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e("FileManagerEngine<FileAssistant>", 1, "forwardToDatalineFromFileAssistant netword is error!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(38, 3, paramFileManagerEntity);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.nFileType == 0)
    {
      a(paramFileManagerEntity, paramInt);
      return;
    }
    if (paramFileManagerEntity.peerType == 3000)
    {
      b(paramFileManagerEntity);
      return;
    }
    a(paramFileManagerEntity);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    b(paramFileManagerEntity, paramString1, paramString2, paramInt, 0);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramString1 = new StringBuilder();
      paramString1.append("=_= r [CS Send] Id[");
      paramString1.append(paramFileManagerEntity.nSessionId);
      paramString1.append("]Send WeiYun to Troop ");
      QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.toString());
      a().a(paramFileManagerEntity, paramString2, paramInt2);
      return;
    }
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    paramString1 = new StringBuilder();
    paramString1.append("=_= r [CS Send] Id[");
    paramString1.append(paramFileManagerEntity.nSessionId);
    paramString1.append("]Send WeiYun to offline ");
    QLog.i("FileManagerEngine<FileAssistant>", 1, paramString1.toString());
    a(paramFileManagerEntity, str, paramString2, paramInt1, paramInt2);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    IFMDataCacheApi localIFMDataCacheApi = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    int i = 0;
    while (i < localIFMDataCacheApi.getOfflineFiles().size())
    {
      Object localObject = (OfflineFileInfo)localIFMDataCacheApi.getOfflineFiles().get(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(FileManagerUtil.a((OfflineFileInfo)localObject, paramInt), paramString1, paramString2, paramInt, true);
      ((FileManagerEntity)localObject).peerType = paramInt;
      ((FileManagerEntity)localObject).status = 2;
      StringBuilder localStringBuilder;
      if (paramInt == 3000)
      {
        ((FileManagerEntity)localObject).nOpType = 28;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("=_=k Id[");
        localStringBuilder.append(((FileManagerEntity)localObject).nSessionId);
        localStringBuilder.append("] sendOffline2Disc[");
        localStringBuilder.append(((FileManagerEntity)localObject).fileName);
        localStringBuilder.append("]");
        QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("=_=k Id[");
        localStringBuilder.append(((FileManagerEntity)localObject).nSessionId);
        localStringBuilder.append("] sendOffline2Offline[");
        localStringBuilder.append(((FileManagerEntity)localObject).fileName);
        localStringBuilder.append("]");
        QLog.i("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
      }
      a((FileManagerEntity)localObject);
      i += 1;
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    IFMDataCacheApi localIFMDataCacheApi = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    int i = 0;
    while (i < localIFMDataCacheApi.getRecentFiles().size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIFMDataCacheApi.getRecentFiles().get(i);
      if (localFileManagerEntity.sendCloudUnsuccessful())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Id[");
        localStringBuilder.append(localFileManagerEntity.nSessionId);
        localStringBuilder.append("] unSend success!");
        QLog.w("FileManagerEngine<FileAssistant>", 1, localStringBuilder.toString());
      }
      else if ((localFileManagerEntity.fileSize <= 20971520L) && (paramBoolean) && (localIFMDataCacheApi.isDocsFile(localFileManagerEntity)))
      {
        new TeamWorkSender(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localFileManagerEntity, paramString1, paramString2, paramInt);
      }
      else
      {
        ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(localFileManagerEntity);
        FileManagerReporter.a("0X8005413");
        a(localFileManagerEntity.nSessionId, paramString1, paramString2, paramInt, true);
      }
      i += 1;
    }
    if (localIFMDataCacheApi.getRecentFiles().size() > 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB4", "0X800AFB4", 0, localIFMDataCacheApi.getRecentFiles().size(), 0, "", "", "", "");
    }
  }
  
  public boolean b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete record fail. entity is null, sessionid: ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.e("FileManagerEngine<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (((FileManagerEntity)localObject).getCloudType() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramLong);
    }
    else if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerRSCenter().a(paramLong)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Pause[");
      localStringBuilder.append(String.valueOf(paramLong));
      localStringBuilder.append("] faild!,status[");
      localStringBuilder.append(String.valueOf(((FileManagerEntity)localObject).status));
      localStringBuilder.append("]");
      QLog.w("FileManagerEngine<FileAssistant>", 2, localStringBuilder.toString());
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a((FileManagerEntity)localObject);
    if ((localObject != null) && (((FileManagerEntity)localObject).bDelInAio) && (((FileManagerEntity)localObject).bDelInFM) && (((FileManagerEntity)localObject).getCloudType() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().d(((FileManagerEntity)localObject).nSessionId);
    }
    if (FileManagerUtil.a(((FileManagerEntity)localObject).getFilePath())) {
      ((FileManagerEntity)localObject).cloudType = 3;
    } else {
      ((FileManagerEntity)localObject).status = 16;
    }
    if ((((FileManagerEntity)localObject).bDelInAio) && (((FileManagerEntity)localObject).bDelInFM)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
    return bool;
  }
  
  public String c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    String str = FileManagerUtil.d(paramFileManagerEntity);
    if (FileUtil.a(str)) {
      return str;
    }
    a().a(paramFileManagerEntity.nSessionId, str, paramFileManagerEntity.strServerPath);
    return null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", false).commit();
  }
  
  public void c(long paramLong, String paramString) {}
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerEngine<FileAssistant>", 2, "ReviceFile,entity is null!");
      }
      return;
    }
    StringBuilder localStringBuilder;
    if (QFileAssistantUtils.a(paramFileManagerEntity.peerUin))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ReviceFile, entity[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("] is newFileAssistant ");
        QLog.w("FileManagerEngine<FileAssistant>.NFRV", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferFileAssistantMgr.c(paramFileManagerEntity);
      return;
    }
    int i = paramFileManagerEntity.getCloudType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          if (QLog.isColorLevel()) {
            QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, but entity is localFile");
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ReviceFile, entity is CLOUD_TYPE_WEIYUN ,peerType[");
          localStringBuilder.append(paramFileManagerEntity.peerType);
          localStringBuilder.append("]");
          QLog.w("FileManagerEngine<FileAssistant>", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramFileManagerEntity);
        if (paramFileManagerEntity.nOpType == 50) {
          a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 50);
        } else {
          a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 5);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("]");
        QLog.w("FileManagerEngine<FileAssistant>", 2, localStringBuilder.toString());
      }
      a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.uniseq, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 1);
    }
    d();
  }
  
  public void c(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter.a(paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    if (paramString1.getFavFiles().size() > 0) {
      a().sendFavFiles(paramString1.getFavFiles(), paramString2, paramInt, null);
    }
    if (paramString1.getFavFiles().size() > 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB6", "0X800AFB6", 0, paramString1.getFavFiles().size(), 0, "", "", "", "");
      return;
    }
  }
  
  public void c(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    IFMDataCacheApi localIFMDataCacheApi = (IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class);
    Iterator localIterator = localIFMDataCacheApi.getLocalFiles().iterator();
    while (localIterator.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)localIterator.next();
      String str = localFileInfo.c();
      if ((paramBoolean) && (localFileInfo.a() <= 20971520L) && (localIFMDataCacheApi.isDocsFile(localFileInfo)))
      {
        new TeamWorkSender(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(str, paramString1, paramString2, paramInt);
      }
      else
      {
        FileManagerReporter.a("0X8005414");
        if (paramInt == 1) {
          a(str, paramString2);
        } else {
          a(str, paramString1, paramString2, paramInt, true).strApkPackageName = localFileInfo.b();
        }
      }
    }
    if (localIFMDataCacheApi.getLocalFiles().size() > 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB5", "0X800AFB5", 0, localIFMDataCacheApi.getLocalFiles().size(), 0, "", "", "", "");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", true).commit();
  }
  
  public void d(long paramLong, String paramString)
  {
    a(3, paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileManagerDataCenter
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FilePreViewControllerBase jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
  private List<Long> jdField_a_of_type_JavaUtilList;
  
  public FileManagerDataCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private TransFileInfo a(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((paramMessageRecord != null) && (localObject != null)) {
      localObject = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessageRecord.time), String.valueOf(paramMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin });
    } else {
      localObject = null;
    }
    if ((localObject == null) && (paramMessageRecord != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get TransferInfo null, time[");
      localStringBuilder.append(String.valueOf(paramMessageRecord.time));
      localStringBuilder.append("],msgseq[");
      localStringBuilder.append(String.valueOf(paramMessageRecord.msgseq));
      localStringBuilder.append("],uin[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("], frienduin[");
      localStringBuilder.append(paramMessageRecord.frienduin);
      localStringBuilder.append("]");
      QLog.e("FileManagerDataCenter<FileAssistant>", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void a(Bundle paramBundle)
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.3(this, paramBundle));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().a(paramString, paramInt1).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramInt2 == localMessageRecord.msgtype) {
        if (paramInt2 != -3011)
        {
          if (paramInt2 != -3010) {
            switch (paramInt2)
            {
            default: 
              paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
              break;
            case -4020: 
              paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
              break;
            case -4021: 
              paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
              break;
            case -4022: 
              paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
              break;
            }
          } else {
            paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
          }
        }
        else if (!QlinkHelper.a()) {
          paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new FileManagerDataCenter.1(paramQQAppInterface, paramString, paramInt1, paramInt2), 8, null, true);
  }
  
  public int a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, Bundle paramBundle)
  {
    if (paramString2 == null) {}
    try
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append(" insertExternalFileToFM. sourceId:");
        paramString1.append(paramInt2);
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, paramString1.toString());
      }
      return -1;
    }
    finally {}
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(" insertExternalFileToFM. filePath:");
      paramString1.append(paramString2);
      paramString1.append(" size:");
      paramString1.append(paramLong);
      paramString1.append(" sourceId:");
      paramString1.append(paramInt2);
      QLog.i("FileManagerDataCenter<FileAssistant>", 2, paramString1.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but app = null");
      }
      return -2;
    }
    long l = MessageRecordFactory.a(-1000).uniseq;
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, AppConstants.FM_EXTERNAL_SAVEFILE_UIN, 0);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but entry = null");
      }
      return -3;
    }
    paramString1.setCloudType(3);
    paramString1.fileName = FileManagerUtil.a(paramString2);
    if (0L == paramLong) {
      paramString1.fileSize = FileManagerUtil.a(paramString2);
    } else {
      paramString1.fileSize = paramLong;
    }
    paramString1.setFilePath(paramString2);
    paramString1.nOpType = paramInt2;
    paramString1.peerNick = null;
    paramString1.peerType = 0;
    paramString1.peerUin = AppConstants.FM_EXTERNAL_SAVEFILE_UIN;
    paramString1.srvTime = (MessageCache.a() * 1000L);
    paramString1.status = 1;
    paramString1.Uuid = null;
    paramString1.isReaded = true;
    paramString1.bSend = false;
    if (paramBundle != null) {
      if (paramBundle.getBoolean("FILE_TMP_IS_ZIPINNER_FILE"))
      {
        paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
        String str = paramBundle.getString("FILE_TMP_DIR_PATH");
        paramLong = paramBundle.getLong("FILE_TMP_RELATED_ID");
        paramBundle = paramBundle.getString("FILE_TMP_ZIP_FILEID");
        paramString1.isZipInnerFile = true;
        paramString1.nRelatedSessionId = paramLong;
        paramString1.zipInnerPath = str;
        paramString1.strServerPath = paramString3;
        paramString1.zipFileId = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().g(paramString1);
      }
      else
      {
        paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1.status = 1;
          paramString1.strServerPath = paramString3;
          paramString1.bDelInAio = true;
        }
        paramInt1 = paramBundle.getInt("FILE_FROM", -1);
        if (paramInt1 != -1) {
          paramString1.nOpType = paramInt1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1);
    FileManagerUtil.c(paramString2);
    return 0;
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    long l = 0L;
    if (paramLong1 <= 0L) {
      return 0L;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("strUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.d(paramString));
      ((StringBuilder)localObject).append("], peeryType[");
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append("], uniseq[");
      ((StringBuilder)localObject).append(String.valueOf(paramLong2));
      ((StringBuilder)localObject).append("]");
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramLong2 > 0L) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong2);
    }
    paramLong2 = l;
    if (localObject != null)
    {
      paramString = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(((MessageRecord)localObject).time), String.valueOf(((MessageRecord)localObject).msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
      paramLong2 = l;
      if (paramString != null) {
        paramLong2 = paramString.transferedSize * 100L / paramLong1;
      }
    }
    localEntityManager.close();
    return paramLong2;
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, null, paramString3, -1L, -1L, -1L);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt, String paramString4, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return a(paramString1, paramString2, paramBoolean1, paramString3, paramLong1, paramBoolean2, paramInt, paramString4, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, -1);
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public MessageRecord a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public FilePreViewControllerBase a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getTmpController mTmpController is null");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTmpController ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.getClass().getName());
      QLog.d("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
    return localObject;
  }
  
  public FileManagerEntity a(long paramLong)
  {
    if (paramLong == -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QueryFileEntityBySessionId nSessionId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] is error");
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QueryFileEntityBySessionId get FileManagerProxy null! nSessionId[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    FileManagerEntity localFileManagerEntity = ((FileManagerProxy)localObject).a(paramLong);
    if (localFileManagerEntity != null)
    {
      ((FileManagerProxy)localObject).a(localFileManagerEntity);
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(localFileManagerEntity);
      return localFileManagerEntity;
    }
    localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(FileManagerEntity.class, String.valueOf(paramLong));
    if (localFileManagerEntity != null)
    {
      ((FileManagerProxy)localObject).a(localFileManagerEntity);
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(localFileManagerEntity);
      return localFileManagerEntity;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QueryFileEntityBySessionId get entry null! nSessionId[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public FileManagerEntity a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1);
    if (localFileManagerEntity != null)
    {
      paramString = new StringBuilder();
      paramString.append("getFileEntityBySessionid for queryall, FileManagerEntity exist, sessionId[");
      paramString.append(String.valueOf(localFileManagerEntity.nSessionId));
      paramString.append("], uniseq[");
      paramString.append(String.valueOf(localFileManagerEntity.uniseq));
      paramString.append("], strUin[");
      paramString.append(FileManagerUtil.d(localFileManagerEntity.peerUin));
      paramString.append("], peerType[");
      paramString.append(String.valueOf(localFileManagerEntity.peerType));
      paramString.append("]");
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, paramString.toString());
      return localFileManagerEntity;
    }
    localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = paramLong1;
    localFileManagerEntity.uniseq = paramLong2;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(localFileManagerEntity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFileEntityBySessionid, new a FileManagerEntity, sessionId[");
    localStringBuilder.append(String.valueOf(localFileManagerEntity.nSessionId));
    localStringBuilder.append("], uniseq[");
    localStringBuilder.append(String.valueOf(paramLong2));
    localStringBuilder.append("], strUin[");
    localStringBuilder.append(FileManagerUtil.d(paramString));
    localStringBuilder.append("], peerType[");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("]");
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, localStringBuilder.toString());
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(long paramLong, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong, paramString);
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("QueryFileEntityByUniseq  strUin is null, uniseq[");
      paramString.append(paramLong);
      paramString.append("], peerType[");
      paramString.append(paramInt);
      paramString.append("]");
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, paramString.toString());
      return null;
    }
    if (paramLong <= 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QueryFileEntityByUniseq uniseq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] is error, strUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.d(paramString));
      ((StringBuilder)localObject).append("], peerType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QueryFileEntityByUniseq get FileManagerProxy null! strUin[");
      ((StringBuilder)localObject).append(FileManagerUtil.d(paramString));
      ((StringBuilder)localObject).append("], uniseq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], peerType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    FileManagerEntity localFileManagerEntity = ((FileManagerProxy)localObject).a(paramLong, paramString, paramInt);
    if (localFileManagerEntity != null)
    {
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(localFileManagerEntity);
      return localFileManagerEntity;
    }
    return ((FileManagerProxy)localObject).b(paramLong, paramString, paramInt);
  }
  
  public FileManagerEntity a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    FileManagerEntity localFileManagerEntity1;
    if (-1L != paramLong2) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    } else {
      localFileManagerEntity1 = null;
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = localFileManagerEntity1;
      if (paramLong1 > 0L) {
        localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1, paramString, paramInt);
      }
    }
    if (localFileManagerEntity2 == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("why sessionId[");
        paramString.append(String.valueOf(paramLong2));
        paramString.append("] and uniseq[");
        paramString.append(String.valueOf(paramLong1));
        paramString.append("] is wrong");
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, paramString.toString());
      }
      return null;
    }
    return localFileManagerEntity2;
  }
  
  public FileManagerEntity a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b(paramString);
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (paramLong <= 0L) {
        return null;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
      if (localObject1 == null)
      {
        paramString = new StringBuilder();
        paramString.append("QueryFileEntityByOLfileSessionId get FileManagerProxy null! nOLfileSessionId[");
        paramString.append(paramLong);
        paramString.append("]");
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, paramString.toString());
        return null;
      }
      FileManagerEntity localFileManagerEntity = ((FileManagerProxy)localObject1).a(paramString, paramLong);
      if (localFileManagerEntity != null) {
        return localFileManagerEntity;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ");
      ((StringBuilder)localObject1).append(FileManagerEntity.tableName());
      ((StringBuilder)localObject1).append(" where (nOLfileSessionId = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" or (nSessionId = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" and nOLfileSessionId = 0)) order by srvTime desc");
      localObject1 = ((StringBuilder)localObject1).toString();
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      Object localObject2 = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject1, null);
      localObject1 = localFileManagerEntity;
      if (localObject2 != null)
      {
        localObject1 = localFileManagerEntity;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            localObject1 = localFileManagerEntity;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          } while ((!paramString.equalsIgnoreCase(((FileManagerEntity)localObject1).peerUin)) || ((paramLong != ((FileManagerEntity)localObject1).nOLfileSessionId) && ((paramLong != ((FileManagerEntity)localObject1).nSessionId) || (0L != ((FileManagerEntity)localObject1).nOLfileSessionId))));
        }
      }
      if ((localObject1 != null) && (0L == ((FileManagerEntity)localObject1).nOLfileSessionId))
      {
        paramString = new StringBuilder();
        paramString.append("QueryOLfileSessionEntity find a old ver data. nOLfileSessionId[");
        paramString.append(paramLong);
        paramString.append("]");
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, paramString.toString());
        ((FileManagerEntity)localObject1).nOLfileSessionId = paramLong;
        c((FileManagerEntity)localObject1);
      }
      localEntityManager.close();
      return localObject1;
    }
    return null;
  }
  
  public List<FileManagerEntity> a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString, paramLong);
  }
  
  public List<FileManagerEntity> a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString1, paramString2, paramBoolean);
  }
  
  public List<FileManagerEntity> a(List<Integer> paramList, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramList, paramString);
  }
  
  public Map<String, List<FileManagerEntity>> a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 0, null);
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("sessionnid[");
        paramString.append(String.valueOf(paramLong));
        paramString.append("] item is not exist!may be is deleted!");
        QLog.w("FileManagerDataCenter<FileAssistant>", 2, paramString.toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(localFileManagerEntity, paramString);
  }
  
  public void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    Object localObject = a(paramLong1, paramString, paramInt, -1L);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateFileManagerTime error, entity is null,uinseq[");
        ((StringBuilder)localObject).append(String.valueOf(paramLong1));
        ((StringBuilder)localObject).append("], frienduin[");
        ((StringBuilder)localObject).append(String.valueOf(paramString));
        ((StringBuilder)localObject).append("], istroop[");
        ((StringBuilder)localObject).append(String.valueOf(paramInt));
        ((StringBuilder)localObject).append("], time[");
        ((StringBuilder)localObject).append(String.valueOf(paramLong2));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ((FileManagerEntity)localObject).srvTime = (paramLong2 * 1000L);
    c((FileManagerEntity)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(FilePreViewControllerBase paramFilePreViewControllerBase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("regTmpController");
    localStringBuilder.append(paramFilePreViewControllerBase.getClass().getName());
    QLog.d("FileManagerDataCenter<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = paramFilePreViewControllerBase;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertToFMList get FileManagerProxy null! nSessionId[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("], uniseq[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.uniseq);
        ((StringBuilder)localObject).append("], peerUin[");
        ((StringBuilder)localObject).append(FileManagerUtil.d(paramFileManagerEntity.peerUin));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert FM List:");
        localStringBuilder.append(FileManagerUtil.a(paramFileManagerEntity));
        QLog.i("FileManagerDataCenter<FileAssistant>", 2, localStringBuilder.toString());
      }
      ((FileManagerProxy)localObject).b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("Save of2of [");
        paramString1.append(String.valueOf(paramBoolean1));
        paramString1.append("],query FileManagerEntity renturn null, SessionId[");
        paramString1.append(String.valueOf(paramLong));
        paramString1.append("], ");
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, paramString1.toString());
      }
      return;
    }
    if (paramBoolean1)
    {
      localFileManagerEntity.lastTime = (MessageCache.a() * 1000L + 604800000L);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.Uuid = paramString2;
      localFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      localFileManagerEntity.fileIdCrc = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      FileManagerUtil.b(localFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity, 6, "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, paramInt, paramString1);
    localFileManagerEntity.isReaded = false;
    localFileManagerEntity.status = 0;
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      localFileManagerEntity.status = 16;
      if ((localFileManagerEntity.mContext != null) && ((localFileManagerEntity.mContext instanceof FileManagerEntity)))
      {
        paramString2 = (FileManagerEntity)localFileManagerEntity.mContext;
        paramString2.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramString2);
        localFileManagerEntity.mContext = null;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", "", localFileManagerEntity.peerUin, localFileManagerEntity.Uuid, paramInt, paramString1, 0L, 0L, 0L, "", "", 0, paramString1, null);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject2 = a(paramLong);
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("strUin[");
      ((StringBuilder)localObject1).append(FileManagerUtil.d(((FileManagerEntity)localObject2).peerUin));
      ((StringBuilder)localObject1).append("], peeryType[");
      ((StringBuilder)localObject1).append(String.valueOf(((FileManagerEntity)localObject2).peerType));
      ((StringBuilder)localObject1).append("], uniseq[");
      ((StringBuilder)localObject1).append(String.valueOf(((FileManagerEntity)localObject2).uniseq));
      ((StringBuilder)localObject1).append("]");
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    if (-1L != ((FileManagerEntity)localObject2).uniseq) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject1 = a((MessageRecord)localObject1);
    if ((localObject2 != null) && (localObject2 != null) && (localObject1 != null))
    {
      ((TransFileInfo)localObject1).status = paramInt;
      ((EntityManager)localObject2).update((Entity)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setFMDelete FileManagerEntity is null!!!");
      }
      return false;
    }
    finally {}
    paramFileManagerEntity.bDelInFM = true;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity, true);
    return bool;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SetRead: strUin[");
      localStringBuilder.append(FileManagerUtil.d(paramString));
      localStringBuilder.append("], peeryType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, localStringBuilder.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong);
    if (paramString != null)
    {
      paramString.isread = true;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramString, paramLong);
  }
  
  public FileManagerEntity b(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong);
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
    if (localObject == null) {
      return null;
    }
    if (paramLong > 0L)
    {
      localFileManagerEntity = ((FileManagerProxy)localObject).a(paramLong, paramString, paramInt);
      if (localFileManagerEntity != null)
      {
        paramString = new StringBuilder();
        paramString.append("getFileEntityByUniseq for memory, FileManagerEntity exist, sessionId[");
        paramString.append(String.valueOf(localFileManagerEntity.nSessionId));
        paramString.append("], uniseq[");
        paramString.append(String.valueOf(localFileManagerEntity.uniseq));
        paramString.append("], strUin[");
        paramString.append(FileManagerUtil.d(localFileManagerEntity.peerUin));
        paramString.append("], peerType[");
        paramString.append(String.valueOf(localFileManagerEntity.peerType));
        paramString.append("]");
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, paramString.toString());
        return localFileManagerEntity;
      }
      localFileManagerEntity = ((FileManagerProxy)localObject).b(paramLong, paramString, paramInt);
      if (localFileManagerEntity != null)
      {
        paramString = new StringBuilder();
        paramString.append("getFileEntityByUniseq for db, FileManagerEntity exist, sessionId[");
        paramString.append(String.valueOf(localFileManagerEntity.nSessionId));
        paramString.append("], uniseq[");
        paramString.append(String.valueOf(localFileManagerEntity.uniseq));
        paramString.append("], strUin[");
        paramString.append(FileManagerUtil.d(localFileManagerEntity.peerUin));
        paramString.append("], peerType[");
        paramString.append(String.valueOf(localFileManagerEntity.peerType));
        paramString.append("]");
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, paramString.toString());
        return localFileManagerEntity;
      }
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(localFileManagerEntity);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getFileEntityByUniseq, new a FileManagerEntity, sessionId[");
    ((StringBuilder)localObject).append(String.valueOf(localFileManagerEntity.nSessionId));
    ((StringBuilder)localObject).append("], uniseq[");
    ((StringBuilder)localObject).append(String.valueOf(paramLong));
    ((StringBuilder)localObject).append("], strUin[");
    ((StringBuilder)localObject).append(FileManagerUtil.d(paramString));
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(String.valueOf(paramInt));
    ((StringBuilder)localObject).append("]");
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return localFileManagerEntity;
  }
  
  public FileManagerEntity b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().c(paramString);
  }
  
  public List<FileManagerEntity> b(List<Integer> paramList, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b(paramList, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a();
  }
  
  public void b(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramLong));
      return;
    }
    finally {}
  }
  
  public void b(long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramLong, paramString);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertToFMListAddOrReplaceDB get FileManagerProxy null! nSessionId[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("], uniseq[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.uniseq);
        ((StringBuilder)localObject).append("], peerUin[");
        ((StringBuilder)localObject).append(FileManagerUtil.d(paramFileManagerEntity.peerUin));
        ((StringBuilder)localObject).append("]");
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(FileManagerEntity.class, String.valueOf(paramFileManagerEntity.nSessionId)) == null)
      {
        ((FileManagerProxy)localObject).b(paramFileManagerEntity);
      }
      else
      {
        ((FileManagerProxy)localObject).c(paramFileManagerEntity);
        ((FileManagerProxy)localObject).e(paramFileManagerEntity);
      }
      return;
    }
    finally {}
  }
  
  public boolean b(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      boolean bool = this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramLong));
      return bool;
    }
    finally {}
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setAioDelete FileManagerEntity is null!!!");
      }
      return false;
    }
    finally {}
    paramFileManagerEntity.bDelInAio = true;
    paramFileManagerEntity.uniseq = -1L;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity, true);
    return bool;
  }
  
  public FileManagerEntity c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().f(paramString);
  }
  
  public void c()
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.2(this));
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().d(paramFileManagerEntity);
  }
  
  public FileManagerEntity d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().d(paramString);
  }
  
  public void d()
  {
    ThreadManager.executeOnSubThread(new FileManagerDataCenter.4(this));
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramFileManagerEntity);
  }
  
  public FileManagerEntity e(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().g(paramString);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter
 * JD-Core Version:    0.7.0.1
 */
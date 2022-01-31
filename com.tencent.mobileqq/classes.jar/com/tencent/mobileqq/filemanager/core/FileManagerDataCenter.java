package com.tencent.mobileqq.filemanager.core;

import acky;
import acla;
import aclb;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FileManagerDataCenter
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public QQAppInterface a;
  private FilePreViewControllerBase jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase;
  
  public FileManagerDataCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private TransFileInfo a(MessageRecord paramMessageRecord)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if (localEntityManager != null) {
        localObject1 = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(paramMessageRecord.time), String.valueOf(paramMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin });
      }
    }
    if ((localObject1 == null) && (paramMessageRecord != null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 2, "get TransferInfo null, time[" + String.valueOf(paramMessageRecord.time) + "],msgseq[" + String.valueOf(paramMessageRecord.msgseq) + "],uin[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "], frienduin[" + paramMessageRecord.frienduin + "]");
    }
    return localObject1;
  }
  
  private void a(Bundle paramBundle)
  {
    ThreadManager.executeOnSubThread(new acla(this, paramBundle));
  }
  
  public int a(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, Bundle paramBundle)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. sourceId:" + paramInt2);
        }
        paramInt1 = -1;
        return paramInt1;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. filePath:" + paramString2 + " size:" + paramLong + " sourceId:" + paramInt2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but app = null");
        }
      }
      else
      {
        long l = MessageRecordFactory.a(-1000).uniseq;
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, AppConstants.u, 0);
        if (paramString1 == null)
        {
          if (!QLog.isColorLevel()) {
            break label443;
          }
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but entry = null");
          break label443;
        }
        paramString1.setCloudType(3);
        paramString1.fileName = FileManagerUtil.a(paramString2);
        if (0L == paramLong)
        {
          paramString1.fileSize = FileManagerUtil.a(paramString2);
          paramString1.setFilePath(paramString2);
          paramString1.nOpType = paramInt2;
          paramString1.peerNick = null;
          paramString1.peerType = 0;
          paramString1.peerUin = AppConstants.u;
          paramString1.srvTime = (MessageCache.a() * 1000L);
          paramString1.status = 1;
          paramString1.Uuid = null;
          paramString1.isReaded = true;
          paramString1.bSend = false;
          if (paramBundle != null)
          {
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(paramString1);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
            FileManagerUtil.c(paramString2);
            paramInt1 = 0;
          }
        }
        else
        {
          paramString1.fileSize = paramLong;
          continue;
        }
        paramString3 = paramBundle.getString("FILE_TMP_SERVER_PATH");
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1.status = 1;
          paramString1.strServerPath = paramString3;
          paramString1.bDelInAio = true;
        }
        paramInt1 = paramBundle.getInt("FILE_FROM", -1);
        if (paramInt1 == -1) {
          continue;
        }
        paramString1.nOpType = paramInt1;
        continue;
      }
      paramInt1 = -2;
      continue;
      label443:
      paramInt1 = -3;
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong1 <= 0L) {
      return 0L;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.e(paramString) + "], peeryType[" + String.valueOf(paramInt) + "], uniseq[" + String.valueOf(paramLong2) + "]");
    }
    MessageRecord localMessageRecord = null;
    if (paramLong2 > 0L) {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong2);
    }
    if ((localMessageRecord != null) && (localEntityManager != null))
    {
      paramString = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
      if (paramString == null) {}
    }
    for (paramLong1 = paramString.transferedSize * 100L / paramLong1;; paramLong1 = 0L)
    {
      localEntityManager.a();
      return paramLong1;
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, null, paramString3, -1L, -1L, -1L);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, Map paramMap, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramInt2);
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.msg = paramString3;
    localMessageRecord.msgtype = paramInt2;
    localMessageRecord.isread = true;
    long l;
    if (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      paramInt2 = 1;
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      if (paramLong2 <= 0L) {
        break label214;
      }
      l = paramLong2;
      label92:
      localMessageRecord.msgseq = l;
      if (paramLong2 <= 0L) {
        break label231;
      }
      label106:
      localMessageRecord.shmsgseq = paramLong2;
      if (paramLong1 <= 0L) {
        break label250;
      }
      label120:
      localMessageRecord.msgUid = paramLong1;
      if (paramLong3 <= 0L) {
        break label258;
      }
    }
    for (;;)
    {
      localMessageRecord.time = paramLong3;
      if ((paramMap == null) || (paramMap.size() <= 0)) {
        break label266;
      }
      paramString1 = paramMap.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localMessageRecord.saveExtInfoToExtStr(paramString2, (String)paramMap.get(paramString2));
      }
      paramInt2 = 0;
      break;
      label214:
      paramInt1 = MobileQQService.a;
      MobileQQService.a = paramInt1 + 1;
      l = paramInt1;
      break label92;
      label231:
      paramLong2 = Math.abs(new Random().nextInt());
      break label106;
      label250:
      paramLong1 = FileManagerUtil.b();
      break label120;
      label258:
      paramLong3 = MessageCache.a();
    }
    label266:
    localMessageRecord.extraflag |= 0xFFFF7FFF;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], msgtype[" + String.valueOf(paramString3) + "]");
    return localMessageRecord.uniseq;
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return a(paramString1, paramString2, paramBoolean1, paramString3, paramLong1, paramBoolean2, paramInt1, paramString4, paramLong2, paramLong3, paramString5, paramInt2, paramLong4, paramLong5, paramLong6, paramLong7, -1);
  }
  
  public long a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, long paramLong1, boolean paramBoolean2, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2005);
    localMessageRecord.uniseq = paramLong4;
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramString2;
    if (paramString4 != null)
    {
      paramString5 = paramString4;
      if (paramString4.length() >= 1) {}
    }
    else
    {
      paramString5 = TransfileUtile.a(paramString3, paramLong1, 0, paramBoolean2);
    }
    localMessageRecord.msg = paramString5;
    localMessageRecord.msgtype = -2005;
    localMessageRecord.isread = paramBoolean2;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      localMessageRecord.msgseq = paramLong2;
      localMessageRecord.shmsgseq = MessageUtils.a(paramLong2, paramInt1);
      paramLong1 = paramLong5;
      if (paramLong5 == 0L) {
        paramLong1 = MessageUtils.a(MessageUtils.a());
      }
      localMessageRecord.msgUid = paramLong1;
      localMessageRecord.time = paramLong7;
      if (paramInt1 == 3000) {
        localMessageRecord.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1).shmsgseq;
      }
      if (!localMessageRecord.isSend()) {
        break label495;
      }
      ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageRecord);
    }
    for (;;)
    {
      localMessageRecord.vipBubbleDiyTextId = paramInt3;
      if (TextUtils.isEmpty(((MessageForFile)localMessageRecord).fileName)) {
        ((MessageForFile)localMessageRecord).fileName = FileManagerUtil.a(paramString3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, paramInt1);
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "], vipBubbleDiyTextID[" + String.valueOf(paramInt3) + "]");
      return localMessageRecord.uniseq;
      paramInt2 = 0;
      break;
      label495:
      if (paramLong6 != -1L) {
        localMessageRecord.vipBubbleID = paramLong6;
      } else {
        localMessageRecord.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
      }
    }
  }
  
  public FilePreViewControllerBase a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase == null) {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getTmpController mTmpController is null");
    }
    for (;;)
    {
      FilePreViewControllerBase localFilePreViewControllerBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
      return localFilePreViewControllerBase;
      QLog.d("FileManagerDataCenter<FileAssistant>", 1, "getTmpController " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.getClass().getName());
    }
  }
  
  public FileManagerEntity a(long paramLong)
  {
    if (paramLong == -1L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId nSessionId[" + paramLong + "] is error");
      return null;
    }
    FileManagerProxy localFileManagerProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localFileManagerProxy == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get FileManagerProxy null! nSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localFileManagerProxy.a(paramLong);
    if (localFileManagerEntity != null)
    {
      localFileManagerProxy.a(localFileManagerEntity);
      FileCategoryUtil.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(FileManagerEntity.class, String.valueOf(paramLong));
    if (localFileManagerEntity != null)
    {
      localFileManagerProxy.a(localFileManagerEntity);
      FileCategoryUtil.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get entry null! nSessionId[" + paramLong + "]");
    return null;
  }
  
  public FileManagerEntity a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1);
    if (localFileManagerEntity != null)
    {
      QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid for queryall, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + FileManagerUtil.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      return localFileManagerEntity;
    }
    localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = paramLong1;
    localFileManagerEntity.uniseq = paramLong2;
    localFileManagerEntity.peerUin = paramString;
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityBySessionid, new a FileManagerEntity, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(paramLong2) + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq  strUin is null, uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    if (paramLong <= 0L)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq uniseq[" + paramLong + "] is error, strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + paramInt + "]");
      return null;
    }
    FileManagerProxy localFileManagerProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localFileManagerProxy == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByuniseq get FileManagerProxy null! strUin[" + FileManagerUtil.e(paramString) + "], uniseq[" + paramLong + "], peerType[" + paramInt + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity = localFileManagerProxy.a(paramLong, paramString, paramInt);
    if (localFileManagerEntity != null)
    {
      FileCategoryUtil.a(localFileManagerEntity);
      return localFileManagerEntity;
    }
    return localFileManagerProxy.b(paramLong, paramString, paramInt);
  }
  
  public FileManagerEntity a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (-1L != paramLong2) {}
    for (FileManagerEntity localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);; localFileManagerEntity1 = null)
    {
      FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
      if (localFileManagerEntity1 == null)
      {
        localFileManagerEntity2 = localFileManagerEntity1;
        if (paramLong1 > 0L) {
          localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramString, paramInt);
        }
      }
      if (localFileManagerEntity2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "why sessionId[" + String.valueOf(paramLong2) + "] and uniseq[" + String.valueOf(paramLong1) + "] is wrong");
        }
        return null;
      }
      return localFileManagerEntity2;
    }
  }
  
  public FileManagerEntity a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject == null)
    {
      QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByOLfileSessionId get FileManagerProxy null! nOLfileSessionId[" + paramLong + "]");
      return null;
    }
    FileManagerEntity localFileManagerEntity1 = ((FileManagerProxy)localObject).a(paramString, paramLong);
    if (localFileManagerEntity1 != null) {
      return localFileManagerEntity1;
    }
    localObject = "select * from " + FileManagerEntity.tableName() + " where (nOLfileSessionId = " + paramLong + " or (nSessionId = " + paramLong + " and nOLfileSessionId = 0)) order by srvTime desc";
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject = localEntityManager.a(FileManagerEntity.class, (String)localObject, null);
    FileManagerEntity localFileManagerEntity2;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localFileManagerEntity2 = (FileManagerEntity)localIterator.next();
        } while (!paramString.equalsIgnoreCase(localFileManagerEntity2.peerUin));
        localObject = localFileManagerEntity2;
        if (paramLong == localFileManagerEntity2.nOLfileSessionId) {
          break;
        }
      } while ((paramLong != localFileManagerEntity2.nSessionId) || (0L != localFileManagerEntity2.nOLfileSessionId));
    }
    for (localObject = localFileManagerEntity2;; localObject = localFileManagerEntity1)
    {
      if ((localObject != null) && (0L == ((FileManagerEntity)localObject).nOLfileSessionId))
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "QueryOLfileSessionEntity find a old ver data. nOLfileSessionId[" + paramLong + "]");
        ((FileManagerEntity)localObject).nOLfileSessionId = paramLong;
        c((FileManagerEntity)localObject);
      }
      localEntityManager.a();
      return localObject;
    }
  }
  
  public Map a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 0, null);
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
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
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerDataCenter<FileAssistant>", 2, "sessionnid[" + String.valueOf(paramLong) + "] item is not exist!may be is deleted!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, paramString);
  }
  
  public void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    FileManagerEntity localFileManagerEntity = a(paramLong1, paramString, paramInt, -1L);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "updateFileManagerTime error, entity is null,uinseq[" + String.valueOf(paramLong1) + "], frienduin[" + String.valueOf(paramString) + "], istroop[" + String.valueOf(paramInt) + "], time[" + String.valueOf(paramLong2) + "]");
      }
      return;
    }
    localFileManagerEntity.srvTime = (1000L * paramLong2);
    c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
  }
  
  public void a(FilePreViewControllerBase paramFilePreViewControllerBase)
  {
    QLog.d("FileManagerDataCenter<FileAssistant>", 1, "regTmpController" + paramFilePreViewControllerBase.getClass().getName());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = paramFilePreViewControllerBase;
  }
  
  /* Error */
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 251	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/data/FileManagerProxy;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +69 -> 80
    //   14: ldc 71
    //   16: iconst_1
    //   17: new 73	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 628
    //   27: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 527	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   34: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc_w 293
    //   40: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 528	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   47: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: ldc_w 630
    //   53: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: getfield 188	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   60: invokestatic 286	com/tencent/mobileqq/filemanager/util/FileManagerUtil:e	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 88
    //   68: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +32 -> 115
    //   86: ldc 71
    //   88: iconst_2
    //   89: new 73	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 632
    //   99: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokestatic 635	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)Ljava/lang/String;
    //   106: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 637	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   120: aload_0
    //   121: getfield 15	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 599	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   127: iconst_1
    //   128: iconst_3
    //   129: aconst_null
    //   130: invokevirtual 604	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   133: goto -56 -> 77
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	FileManagerDataCenter
    //   0	141	1	paramFileManagerEntity	FileManagerEntity
    //   9	107	2	localFileManagerProxy	FileManagerProxy
    // Exception table:
    //   from	to	target	type
    //   2	10	136	finally
    //   14	77	136	finally
    //   80	115	136	finally
    //   115	133	136	finally
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "Save of2of [" + String.valueOf(paramBoolean) + "],query FileManagerEntity renturn null, SessionId[" + String.valueOf(paramLong) + "], ");
      }
      return;
    }
    if (paramBoolean)
    {
      localFileManagerEntity.lastTime = (MessageCache.a() * 1000L + 604800000L);
      localFileManagerEntity.isReaded = false;
      localFileManagerEntity.bSend = true;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 0.0F;
      localFileManagerEntity.Uuid = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      FileManagerUtil.b(localFileManagerEntity.nSessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 6, "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, localFileManagerEntity.peerUin, localFileManagerEntity.peerType, 15, null, paramInt, paramString1);
    localFileManagerEntity.isReaded = false;
    localFileManagerEntity.status = 0;
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      localFileManagerEntity.status = 16;
      if ((localFileManagerEntity.mContext != null) && ((localFileManagerEntity.mContext instanceof FileManagerEntity)))
      {
        paramString2 = (FileManagerEntity)localFileManagerEntity.mContext;
        paramString2.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString2);
        localFileManagerEntity.mContext = null;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", "", localFileManagerEntity.peerUin, localFileManagerEntity.Uuid, paramInt, paramString1, 0L, 0L, 0L, "", "", 0, paramString1, null);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    Object localObject2 = a(paramLong);
    if (localObject2 == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.e(((FileManagerEntity)localObject2).peerUin) + "], peeryType[" + String.valueOf(((FileManagerEntity)localObject2).peerType) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject2).uniseq) + "]");
    }
    Object localObject1 = null;
    if (-1L != ((FileManagerEntity)localObject2).uniseq) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject1 = a((MessageRecord)localObject1);
    if ((localObject2 != null) && (localObject2 != null) && (localObject1 != null))
    {
      ((TransFileInfo)localObject1).status = paramInt;
      ((EntityManager)localObject2).a((Entity)localObject1);
      return true;
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setFMDelete FileManagerEntity is null!!!");
        }
        bool = false;
        return bool;
      }
      finally {}
      paramFileManagerEntity.bDelInFM = true;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, true);
    }
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerDataCenter<FileAssistant>", 2, "SetRead: strUin[" + FileManagerUtil.e(paramString) + "], peeryType[" + paramInt + "], uniseq[" + paramLong + "]");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    if (paramString != null)
    {
      paramString.isread = true;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
  }
  
  public FileManagerEntity b(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject == null) {
      return null;
    }
    if (paramLong > 0L)
    {
      FileManagerEntity localFileManagerEntity = ((FileManagerProxy)localObject).a(paramLong, paramString, paramInt);
      if (localFileManagerEntity != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq for memory, FileManagerEntity exist, sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(localFileManagerEntity.uniseq) + "], strUin[" + FileManagerUtil.e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
        return localFileManagerEntity;
      }
      localObject = ((FileManagerProxy)localObject).b(paramLong, paramString, paramInt);
      if (localObject != null)
      {
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq for db, FileManagerEntity exist, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(((FileManagerEntity)localObject).uniseq) + "], strUin[" + FileManagerUtil.e(((FileManagerEntity)localObject).peerUin) + "], peerType[" + String.valueOf(((FileManagerEntity)localObject).peerType) + "]");
        return localObject;
      }
    }
    localObject = new FileManagerEntity();
    ((FileManagerEntity)localObject).nSessionId = FileManagerUtil.a().longValue();
    ((FileManagerEntity)localObject).uniseq = paramLong;
    ((FileManagerEntity)localObject).peerUin = paramString;
    ((FileManagerEntity)localObject).peerType = paramInt;
    ((FileManagerEntity)localObject).selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((FileManagerEntity)localObject).isReaded = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((FileManagerEntity)localObject);
    QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByuniseq, new a FileManagerEntity, sessionId[" + String.valueOf(((FileManagerEntity)localObject).nSessionId) + "], uniseq[" + String.valueOf(paramLong) + "], strUin[" + FileManagerUtil.e(paramString) + "], peerType[" + String.valueOf(paramInt) + "]");
    return localObject;
  }
  
  public FileManagerEntity b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d();
  }
  
  public void b(long paramLong, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramString);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      FileManagerProxy localFileManagerProxy;
      try
      {
        localFileManagerProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localFileManagerProxy == null)
        {
          QLog.e("FileManagerDataCenter<FileAssistant>", 1, "insertToFMListAddOrReplaceDB get FileManagerProxy null! nSessionId[" + paramFileManagerEntity.nSessionId + "], uniseq[" + paramFileManagerEntity.uniseq + "], peerUin[" + FileManagerUtil.e(paramFileManagerEntity.peerUin) + "]");
          return;
        }
        if ((FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(FileManagerEntity.class, String.valueOf(paramFileManagerEntity.nSessionId)) == null)
        {
          localFileManagerProxy.b(paramFileManagerEntity);
          continue;
        }
        localFileManagerProxy.c(paramFileManagerEntity);
      }
      finally {}
      localFileManagerProxy.e(paramFileManagerEntity);
    }
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setAioDelete FileManagerEntity is null!!!");
        }
        bool = false;
        return bool;
      }
      finally {}
      paramFileManagerEntity.bDelInAio = true;
      paramFileManagerEntity.uniseq = -1L;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, true);
    }
  }
  
  public FileManagerEntity c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramFileManagerEntity);
  }
  
  public FileManagerEntity d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString);
  }
  
  public void d()
  {
    ThreadManager.executeOnSubThread(new acky(this));
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity);
  }
  
  public FileManagerEntity e(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(paramString);
  }
  
  public void e()
  {
    ThreadManager.executeOnSubThread(new aclb(this));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter
 * JD-Core Version:    0.7.0.1
 */
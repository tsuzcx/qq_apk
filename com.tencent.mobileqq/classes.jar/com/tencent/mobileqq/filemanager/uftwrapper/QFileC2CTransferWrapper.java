package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

public class QFileC2CTransferWrapper
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QFileC2CTransferWrapper.ITransferWrapperCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback = new QFileC2CTransferWrapper.1(this);
  private final Map<Long, QFileC2CTransferWrapper.C2CBaseUploadWrapper> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public QFileC2CTransferWrapper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private QFileC2CTransferWrapper.C2CBaseUploadWrapper a(long paramLong)
  {
    try
    {
      QFileC2CTransferWrapper.C2CBaseUploadWrapper localC2CBaseUploadWrapper = (QFileC2CTransferWrapper.C2CBaseUploadWrapper)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return localC2CBaseUploadWrapper;
    }
    finally {}
  }
  
  private void a(long paramLong, QFileC2CTransferWrapper.C2CBaseUploadWrapper paramC2CBaseUploadWrapper)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramC2CBaseUploadWrapper);
      return;
    }
    finally {}
  }
  
  private QFileC2CTransferWrapper.C2CBaseUploadWrapper b(long paramLong)
  {
    try
    {
      QFileC2CTransferWrapper.C2CBaseUploadWrapper localC2CBaseUploadWrapper = (QFileC2CTransferWrapper.C2CBaseUploadWrapper)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localC2CBaseUploadWrapper;
    }
    finally {}
  }
  
  public long a(QFileC2CTransferWrapper.C2CFileMultiFwdInfo paramC2CFileMultiFwdInfo, QFileC2CTransferWrapper.IC2CMultiFwdCallback paramIC2CMultiFwdCallback)
  {
    long l = FileManagerUtil.a().longValue();
    paramC2CFileMultiFwdInfo = new QFileC2CTransferWrapper.C2CMultiFwdUploadWrapper(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramC2CFileMultiFwdInfo, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback, paramIC2CMultiFwdCallback);
    a(l, paramC2CFileMultiFwdInfo);
    paramC2CFileMultiFwdInfo.a();
    return l;
  }
  
  public FileManagerEntity a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2)
  {
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, paramString3, paramInt1);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 0;
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileSize = QQFileManagerUtil.b(paramString1);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramString3;
    localFileManagerEntity.peerNick = QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, null, paramInt1);
    localFileManagerEntity.setFilePath(paramString1);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.fileName = QQFileManagerUtil.e(paramString1);
    localFileManagerEntity.nFileType = QQFileManagerUtil.b(paramString1);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.msgSeq = QQFileManagerUtil.a();
    localFileManagerEntity.msgUid = QQFileManagerUtil.b();
    localFileManagerEntity.strThumbPath = QQFileManagerUtil.a(paramString1, 150, 150, null);
    QQFileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString3, localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if ((paramInt1 != 1004) && (paramInt1 != 1000)) {
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString2;
        localFileManagerEntity.tmpSessionToPhone = paramString3;
      }
      else
      {
        paramString2 = str;
      }
    }
    ForwardOrderManager.a().a(l, paramLong, paramInt2);
    paramString1 = new QFileC2CTransferWrapper.2(this, localFileManagerEntity, paramString1, paramString3, paramString2, paramInt1, l);
    if (localFileManagerEntity.nFileType == 5)
    {
      if (!((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(localFileManagerEntity.getFilePath(), new QFileC2CTransferWrapper.3(this, localFileManagerEntity, paramString1))) {
        QQFileManagerUtil.FileExecutor.a().execute(paramString1);
      }
    }
    else {
      QQFileManagerUtil.FileExecutor.a().execute(paramString1);
    }
    paramString1 = new QFileC2CTransferWrapper.C2CUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback);
    a(localFileManagerEntity.nSessionId, paramString1);
    return localFileManagerEntity;
  }
  
  public void a()
  {
    Object localObject1 = new HashMap();
    try
    {
      ((Map)localObject1).putAll(this.jdField_a_of_type_JavaUtilMap);
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((QFileC2CTransferWrapper.C2CBaseUploadWrapper)((Iterator)localObject1).next()).a(3);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    QFileC2CTransferWrapper.C2CUploadWrapper localC2CUploadWrapper = new QFileC2CTransferWrapper.C2CUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback);
    a(paramFileManagerEntity.nSessionId, localC2CUploadWrapper);
    localC2CUploadWrapper.a();
  }
  
  public boolean a(long paramLong)
  {
    QFileC2CTransferWrapper.C2CBaseUploadWrapper localC2CBaseUploadWrapper = a(paramLong);
    if (localC2CBaseUploadWrapper != null) {
      return localC2CBaseUploadWrapper.a(0);
    }
    return false;
  }
  
  public void b()
  {
    Object localObject1 = new HashMap();
    try
    {
      ((Map)localObject1).putAll(this.jdField_a_of_type_JavaUtilMap);
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((QFileC2CTransferWrapper.C2CBaseUploadWrapper)((Iterator)localObject1).next()).a(4);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (!a(paramFileManagerEntity.nSessionId))
    {
      a(paramFileManagerEntity);
      return;
    }
    QQFileManagerUtil.FileExecutor.a().execute(new QFileC2CTransferWrapper.4(this, paramFileManagerEntity));
  }
  
  public boolean b(long paramLong)
  {
    return b(paramLong) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

public class QFileDiscTransferWrapper
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QFileDiscTransferWrapper.ITransferWrapperCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$ITransferWrapperCallback = new QFileDiscTransferWrapper.1(this);
  private final Map<Long, QFileDiscTransferWrapper.DiscBaseUploadWrapper> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public QFileDiscTransferWrapper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private QFileDiscTransferWrapper.DiscBaseUploadWrapper a(long paramLong)
  {
    try
    {
      QFileDiscTransferWrapper.DiscBaseUploadWrapper localDiscBaseUploadWrapper = (QFileDiscTransferWrapper.DiscBaseUploadWrapper)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return localDiscBaseUploadWrapper;
    }
    finally {}
  }
  
  private void a(long paramLong, QFileDiscTransferWrapper.DiscBaseUploadWrapper paramDiscBaseUploadWrapper)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramDiscBaseUploadWrapper);
      return;
    }
    finally {}
  }
  
  private QFileDiscTransferWrapper.DiscBaseUploadWrapper b(long paramLong)
  {
    try
    {
      QFileDiscTransferWrapper.DiscBaseUploadWrapper localDiscBaseUploadWrapper = (QFileDiscTransferWrapper.DiscBaseUploadWrapper)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localDiscBaseUploadWrapper;
    }
    finally {}
  }
  
  public long a(String paramString1, String paramString2, QFileDiscTransferWrapper.IDiscMultiFwdCallback paramIDiscMultiFwdCallback)
  {
    long l = FileManagerUtil.a().longValue();
    paramString1 = new QFileDiscTransferWrapper.DiscMultiFwdUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$ITransferWrapperCallback, paramIDiscMultiFwdCallback);
    a(l, paramString1);
    paramString1.a();
    return l;
  }
  
  public FileManagerEntity a(String paramString1, String paramString2)
  {
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, paramString2, 3000);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 0;
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileSize = FileManagerUtil.a(paramString1);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, 3000);
    localFileManagerEntity.setFilePath(paramString1);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.fileName = FileManagerUtil.a(paramString1);
    localFileManagerEntity.nFileType = FileManagerUtil.a(paramString1);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    localFileManagerEntity.strThumbPath = FileManagerUtil.a(paramString1, 150, 150, null);
    localFileManagerEntity.tmpSessionType = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    paramString1 = new QFileDiscTransferWrapper.2(this, localFileManagerEntity, paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), l);
    if (localFileManagerEntity.nFileType == 5)
    {
      if (!((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(localFileManagerEntity.getFilePath(), new QFileDiscTransferWrapper.3(this, localFileManagerEntity, paramString1))) {
        QQFileManagerUtil.FileExecutor.a().execute(paramString1);
      }
    }
    else {
      QQFileManagerUtil.FileExecutor.a().execute(paramString1);
    }
    paramString1 = new QFileDiscTransferWrapper.DiscUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$ITransferWrapperCallback);
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
        ((QFileDiscTransferWrapper.DiscBaseUploadWrapper)((Iterator)localObject1).next()).a(3);
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
    if (a(paramFileManagerEntity.nSessionId))
    {
      QQFileManagerUtil.FileExecutor.a().execute(new QFileDiscTransferWrapper.4(this, paramFileManagerEntity));
      return;
    }
    QFileDiscTransferWrapper.DiscUploadWrapper localDiscUploadWrapper = new QFileDiscTransferWrapper.DiscUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileDiscTransferWrapper$ITransferWrapperCallback);
    a(paramFileManagerEntity.nSessionId, localDiscUploadWrapper);
    localDiscUploadWrapper.a();
  }
  
  public boolean a(long paramLong)
  {
    QFileDiscTransferWrapper.DiscBaseUploadWrapper localDiscBaseUploadWrapper = a(paramLong);
    if (localDiscBaseUploadWrapper != null)
    {
      localDiscBaseUploadWrapper.a(0);
      return true;
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
        ((QFileDiscTransferWrapper.DiscBaseUploadWrapper)((Iterator)localObject1).next()).a(4);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper
 * JD-Core Version:    0.7.0.1
 */
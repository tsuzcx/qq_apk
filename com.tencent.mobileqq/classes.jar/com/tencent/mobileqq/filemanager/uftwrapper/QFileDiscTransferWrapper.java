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
  private final QQAppInterface a;
  private final Map<Long, QFileDiscTransferWrapper.DiscBaseUploadWrapper> b = new HashMap();
  private QFileDiscTransferWrapper.ITransferWrapperCallback c = new QFileDiscTransferWrapper.1(this);
  
  public QFileDiscTransferWrapper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(long paramLong, QFileDiscTransferWrapper.DiscBaseUploadWrapper paramDiscBaseUploadWrapper)
  {
    try
    {
      this.b.put(Long.valueOf(paramLong), paramDiscBaseUploadWrapper);
      return;
    }
    finally {}
  }
  
  private QFileDiscTransferWrapper.DiscBaseUploadWrapper b(long paramLong)
  {
    try
    {
      QFileDiscTransferWrapper.DiscBaseUploadWrapper localDiscBaseUploadWrapper = (QFileDiscTransferWrapper.DiscBaseUploadWrapper)this.b.remove(Long.valueOf(paramLong));
      return localDiscBaseUploadWrapper;
    }
    finally {}
  }
  
  private QFileDiscTransferWrapper.DiscBaseUploadWrapper c(long paramLong)
  {
    try
    {
      QFileDiscTransferWrapper.DiscBaseUploadWrapper localDiscBaseUploadWrapper = (QFileDiscTransferWrapper.DiscBaseUploadWrapper)this.b.get(Long.valueOf(paramLong));
      return localDiscBaseUploadWrapper;
    }
    finally {}
  }
  
  public long a(String paramString1, String paramString2, QFileDiscTransferWrapper.IDiscMultiFwdCallback paramIDiscMultiFwdCallback)
  {
    long l = FileManagerUtil.a().longValue();
    paramString1 = new QFileDiscTransferWrapper.DiscMultiFwdUploadWrapper(this.a, l, paramString1, paramString2, this.c, paramIDiscMultiFwdCallback);
    a(l, paramString1);
    paramString1.b();
    return l;
  }
  
  public FileManagerEntity a(String paramString1, String paramString2)
  {
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().b(l, paramString2, 3000);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.nOpType = 0;
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileSize = FileManagerUtil.h(paramString1);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.a, paramString2, null, 3000);
    localFileManagerEntity.setFilePath(paramString1);
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.fileName = FileManagerUtil.a(paramString1);
    localFileManagerEntity.nFileType = FileManagerUtil.c(paramString1);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.msgSeq = FileManagerUtil.f();
    localFileManagerEntity.msgUid = FileManagerUtil.g();
    localFileManagerEntity.strThumbPath = FileManagerUtil.a(paramString1, 150, 150, null);
    localFileManagerEntity.tmpSessionType = -1L;
    this.a.getFileManagerDataCenter().a(localFileManagerEntity);
    paramString1 = new QFileDiscTransferWrapper.2(this, localFileManagerEntity, paramString1, paramString2, this.a.getAccount(), l);
    if (localFileManagerEntity.nFileType == 5)
    {
      if (!((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(localFileManagerEntity.getFilePath(), new QFileDiscTransferWrapper.3(this, localFileManagerEntity, paramString1))) {
        QQFileManagerUtil.FileExecutor.a().execute(paramString1);
      }
    }
    else {
      QQFileManagerUtil.FileExecutor.a().execute(paramString1);
    }
    paramString1 = new QFileDiscTransferWrapper.DiscUploadWrapper(this.a, localFileManagerEntity, this.c);
    a(localFileManagerEntity.nSessionId, paramString1);
    return localFileManagerEntity;
  }
  
  public void a()
  {
    Object localObject1 = new HashMap();
    try
    {
      ((Map)localObject1).putAll(this.b);
      this.b.clear();
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
    QFileDiscTransferWrapper.DiscUploadWrapper localDiscUploadWrapper = new QFileDiscTransferWrapper.DiscUploadWrapper(this.a, paramFileManagerEntity, this.c);
    a(paramFileManagerEntity.nSessionId, localDiscUploadWrapper);
    localDiscUploadWrapper.b();
  }
  
  public boolean a(long paramLong)
  {
    QFileDiscTransferWrapper.DiscBaseUploadWrapper localDiscBaseUploadWrapper = b(paramLong);
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
      ((Map)localObject1).putAll(this.b);
      this.b.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper
 * JD-Core Version:    0.7.0.1
 */
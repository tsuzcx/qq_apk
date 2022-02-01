package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class OnlineFileSessionCenter
{
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new OnlineFileSessionCenter.2(this);
  private OnlineFileSessionCenter.UploadProgressMakeEvtPump jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter$UploadProgressMakeEvtPump = null;
  LinkedHashMap<Long, OnlineFileSessionWorker> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private LinkedHashMap<String, LinkedHashMap<Long, OnlineFileSessionCenter.HandleInfoBeforeRequest>> b = new LinkedHashMap();
  
  public OnlineFileSessionCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    try
    {
      ThreadManager.executeOnSubThread(new OnlineFileSessionCenter.1(this, paramQQAppInterface));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  OnlineFileSessionWorker a(long paramLong)
  {
    Object localObject2 = (OnlineFileSessionWorker)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
      localObject1 = localObject2;
      if (localFileManagerEntity != null)
      {
        localObject1 = new OnlineFileSessionWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
        ((OnlineFileSessionWorker)localObject1).a(localFileManagerEntity);
        try
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), localObject1);
        }
        finally {}
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OLfilesession[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("] getOnlineWorker, but user had deleted it, return null");
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      if (localOnlineFileSessionWorker != null)
      {
        localOnlineFileSessionWorker.n();
        c(paramLong);
      }
      return null;
    }
    if (localOnlineFileSessionWorker != null) {
      localOnlineFileSessionWorker.k();
    }
    b();
    return localOnlineFileSessionWorker;
  }
  
  OnlineFileSessionWorker a(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      long l = 0L;
      if (paramLong <= 0L) {
        return null;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (OnlineFileSessionWorker)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((OnlineFileSessionWorker)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (paramString.equalsIgnoreCase(((OnlineFileSessionWorker)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) && (paramLong == ((OnlineFileSessionWorker)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId)) {
          break label98;
        }
      }
      Object localObject1 = null;
      label98:
      if (localObject1 == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString, paramLong);
        paramLong = l;
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramLong = ((FileManagerEntity)localObject2).nSessionId;
          paramString = new OnlineFileSessionWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject2).nSessionId);
          paramString.a((FileManagerEntity)localObject2);
          try
          {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), paramString);
          }
          finally {}
        }
      }
      else
      {
        paramLong = l;
        paramString = (String)localObject1;
        if (((OnlineFileSessionWorker)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
        {
          paramLong = ((OnlineFileSessionWorker)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          paramString = (String)localObject1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OLfilesession[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("] getOnlineWorker, but user had deleted it, return null");
        QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        if (paramString != null)
        {
          paramString.n();
          c(paramLong);
        }
        return null;
      }
      if (paramString != null) {
        paramString.k();
      }
      b();
      return paramString;
    }
    return null;
  }
  
  public void a()
  {
    c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ((OnlineFileSessionWorker)((Map.Entry)localObject).getValue()).n();
      long l = ((Long)((Map.Entry)localObject).getKey()).longValue();
      int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      localIterator.remove();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]. stop. and remove the worker..[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      ((StringBuilder)localObject).append("]");
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)((Map.Entry)localObject).getValue();
      localOnlineFileSessionWorker.b(paramInt);
      if (localOnlineFileSessionWorker.c())
      {
        long l = ((Long)((Map.Entry)localObject).getKey()).longValue();
        localIterator.remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]. remove the worker....");
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
    }
    a();
  }
  
  public void a(long paramLong)
  {
    if (0L == paramLong)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] PauseTrans sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]. not find worker.PauseTrans");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((OnlineFileSessionWorker)localObject).f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("] had be deleted by user. stop it");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, localStringBuilder.toString());
      ((OnlineFileSessionWorker)localObject).n();
    }
    if (((OnlineFileSessionWorker)localObject).c()) {
      c(paramLong);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      Object localObject = a(paramString, paramLong);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]. not find worker.onSenderCancelUpload");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString, paramLong)) {
          a(paramString, paramLong, new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, 10));
        }
        return;
      }
      ((OnlineFileSessionWorker)localObject).e();
      if (((OnlineFileSessionWorker)localObject).c()) {
        c(((OnlineFileSessionWorker)localObject).jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onSenderCancelUpload sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      Object localObject = a(paramString, paramLong);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]. not find worker.onFileRequestBeHandledByPC");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString, paramLong)) {
          a(paramString, paramLong, new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, paramInt));
        }
        return;
      }
      ((OnlineFileSessionWorker)localObject).a(paramInt);
      if (((OnlineFileSessionWorker)localObject).c()) {
        c(((OnlineFileSessionWorker)localObject).jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onFileRequestBeHandledByPC sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("OLfilesession[");
        paramString.append(paramLong);
        paramString.append("]. not find worker.onSenderUploadProgressNotify");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      paramString.a(paramInt1, paramInt2);
      if (paramString.c()) {
        c(paramString.jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onSenderUploadProgressNotify sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if ((paramString1 != null) && (paramLong > 0L))
    {
      Object localObject = a(paramString1, paramLong);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]. not find worker.onSenderUploadException");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, paramLong))
        {
          localObject = new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, 12);
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).jdField_b_of_type_Int = paramInt;
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).jdField_a_of_type_JavaLangString = paramString2;
          a(paramString1, paramLong, (OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject);
        }
        return;
      }
      ((OnlineFileSessionWorker)localObject).a(paramInt, paramString2);
      if (((OnlineFileSessionWorker)localObject).c()) {
        c(((OnlineFileSessionWorker)localObject).jdField_a_of_type_Long);
      }
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OLfilesession[");
    paramString1.append(paramLong);
    paramString1.append("] onSenderUploadException sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    if ((paramString1 != null) && (paramLong1 > 0L))
    {
      Object localObject = a(paramString1, paramLong1);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append("]. not find worker.onSenderUploadCompleted");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, paramLong1))
        {
          localObject = new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, 11);
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).jdField_b_of_type_Int = paramInt;
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).jdField_b_of_type_Long = paramLong2;
          a(paramString1, paramLong1, (OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject);
        }
        return;
      }
      if (!((OnlineFileSessionWorker)localObject).a(paramInt, paramString2, paramLong2))
      {
        paramString1 = new StringBuilder();
        paramString1.append("OLfilesession[");
        paramString1.append(paramLong1);
        paramString1.append("] upload competed. but onlineworker handle failed!!!!");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      }
      if (((OnlineFileSessionWorker)localObject).c()) {
        c(((OnlineFileSessionWorker)localObject).jdField_a_of_type_Long);
      }
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OLfilesession[");
    paramString1.append(paramLong1);
    paramString1.append("]onSenderUploadCompleted  sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
  }
  
  void a(String paramString, long paramLong, OnlineFileSessionCenter.HandleInfoBeforeRequest paramHandleInfoBeforeRequest)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      if (paramHandleInfoBeforeRequest == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]  cacheHandleBeforeRequest handleType:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" info_1:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" info_2:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" info_3:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.jdField_b_of_type_Long);
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      localObject = (LinkedHashMap)this.b.get(paramString);
      if (localObject == null)
      {
        localObject = new LinkedHashMap();
        ((LinkedHashMap)localObject).put(Long.valueOf(paramLong), paramHandleInfoBeforeRequest);
        this.b.put(paramString, localObject);
        return;
      }
      ((LinkedHashMap)localObject).put(Long.valueOf(paramLong), paramHandleInfoBeforeRequest);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("OLfilesession[");
        paramString.append(paramLong);
        paramString.append("]. not find worker.onRecvOnLineFileResult");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      paramString.a(paramBoolean);
      if (paramString.c()) {
        c(paramString.jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onRecvOnLineFileResult sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt)
  {
    if (paramOnlineFileSessionInfo == null)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession. request come,but session = null");
      return;
    }
    if (0L == paramOnlineFileSessionInfo.jdField_b_of_type_Long)
    {
      paramString1 = new StringBuilder();
      paramString1.append("OLfilesession[");
      paramString1.append(paramOnlineFileSessionInfo.jdField_b_of_type_Long);
      paramString1.append("]  onFileRequestCome sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long) != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("OLfilesession[");
      paramString1.append(paramOnlineFileSessionInfo.jdField_b_of_type_Long);
      paramString1.append("] request come filename:");
      paramString1.append(paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString);
      paramString1.append(", but is repeat session and return");
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long))
    {
      paramString1 = new StringBuilder();
      paramString1.append("OLfilesession[");
      paramString1.append(paramOnlineFileSessionInfo.jdField_b_of_type_Long);
      paramString1.append("] request come filename:");
      paramString1.append(paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString);
      paramString1.append("but it had be deleted by user");
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      return;
    }
    String str = TransfileUtile.makeTransFileProtocolData(TransFileUtil.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString, 0, null), paramOnlineFileSessionInfo.jdField_a_of_type_Long, 0, false, null);
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, paramString1, 0);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.setCloudType(0);
    localFileManagerEntity.fileName = paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOnlineFileSessionInfo.jdField_a_of_type_Long;
    localFileManagerEntity.nOpType = -1;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
    localFileManagerEntity.peerType = 0;
    localFileManagerEntity.peerUin = paramString1;
    localFileManagerEntity.srvTime = (1000L * paramLong1);
    localFileManagerEntity.status = 4;
    localFileManagerEntity.Uuid = null;
    localFileManagerEntity.isReaded = paramBoolean;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.nFileType = -1;
    localFileManagerEntity.nOLfileSessionId = paramOnlineFileSessionInfo.jdField_b_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(paramOnlineFileSessionInfo.jdField_b_of_type_Long);
    localStringBuilder.append("] - nSessionId[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] request come filename:");
    localStringBuilder.append(paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString);
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, paramString2, false, paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString, paramOnlineFileSessionInfo.jdField_a_of_type_Long, false, 0, str, paramShort, l, localFileManagerEntity.nSessionId, paramLong2, paramLong1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("File Coming:");
      paramString2.append(FileManagerUtil.a(localFileManagerEntity));
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, paramString2.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(l, localFileManagerEntity.nSessionId, paramString1, 0, 17, null, 0, null);
    if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(1, true, true);
    }
    paramString2 = new OnlineFileSessionWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
    paramString2.a(localFileManagerEntity);
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(localFileManagerEntity.nSessionId), paramString2);
      paramString2.k();
      if (paramString2.c())
      {
        c(localFileManagerEntity.nSessionId);
      }
      else if (a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long))
      {
        paramString1 = new StringBuilder();
        paramString1.append("OLfilesession[");
        paramString1.append(paramOnlineFileSessionInfo.jdField_b_of_type_Long);
        paramString1.append("] had be handled before request come");
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
        return;
      }
      b();
      return;
    }
    finally {}
  }
  
  public boolean a(long paramLong)
  {
    if (0L == paramLong)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] recvOnLineFile sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]. not find worker.recvOnLineFile");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
    localFileAssistantReportData.b = "recv_file_online";
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
    boolean bool = ((OnlineFileSessionWorker)localObject).d();
    if (((OnlineFileSessionWorker)localObject).c()) {
      c(paramLong);
    }
    return bool;
  }
  
  boolean a(String paramString, long paramLong)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString != null)
    {
      if (paramLong <= 0L) {
        return false;
      }
      Object localObject1 = (LinkedHashMap)this.b.get(paramString);
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = (OnlineFileSessionCenter.HandleInfoBeforeRequest)((LinkedHashMap)localObject1).get(Long.valueOf(paramLong));
        if (localObject2 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("OLfilesession[");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append("]  isBeHandledBeforeRequest handleType:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append(" info_1:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_b_of_type_Int);
          ((StringBuilder)localObject3).append(" info_2:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append(" info_3:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_b_of_type_Long);
          QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
          int i = ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_a_of_type_Int;
          if ((i != 1) && (i != 2) && (i != 3) && (i != 4) && (i != 5)) {}
          switch (i)
          {
          default: 
            bool2 = bool1;
            break;
          case 12: 
            a(paramString, paramLong, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_b_of_type_Int, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_a_of_type_JavaLangString);
            break;
          case 11: 
            a(paramString, paramLong, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_b_of_type_Int, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_a_of_type_JavaLangString, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_b_of_type_Long);
            break;
          case 10: 
            a(paramString, paramLong);
            break;
            a(paramString, paramLong, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).jdField_a_of_type_Int);
          }
          bool2 = true;
          ((LinkedHashMap)localObject1).remove(Long.valueOf(paramLong));
          bool1 = bool2;
          if (((LinkedHashMap)localObject1).size() != 0) {
            break label355;
          }
          this.b.remove(paramString);
          bool1 = bool2;
          break label355;
        }
      }
      bool1 = bool3;
      label355:
      localObject1 = "OLfilesession[";
      paramString = " info_3:";
      paramLong = MessageCache.a();
      bool2 = bool1;
      if (paramLong - this.jdField_a_of_type_Long >= 3600L)
      {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  isBeHandledBeforeRequest handleType. start clear something");
        this.jdField_a_of_type_Long = paramLong;
        bool2 = bool1;
        if (this.b.size() > 0)
        {
          Iterator localIterator = this.b.entrySet().iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            LinkedHashMap localLinkedHashMap = (LinkedHashMap)((Map.Entry)localIterator.next()).getValue();
            if ((localLinkedHashMap != null) && (localLinkedHashMap.size() > 0))
            {
              localObject2 = localLinkedHashMap.entrySet().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
                localObject3 = (OnlineFileSessionCenter.HandleInfoBeforeRequest)((Map.Entry)localObject4).getValue();
                l = ((Long)((Map.Entry)localObject4).getKey()).longValue();
                if (localObject3 != null)
                {
                  if (paramLong - ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).jdField_a_of_type_Long >= 7200L)
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append((String)localObject1);
                    ((StringBuilder)localObject4).append(l);
                    ((StringBuilder)localObject4).append("]  isBeHandledBeforeRequest and clear it.handleType:");
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).jdField_a_of_type_Int);
                    ((StringBuilder)localObject4).append(" info_1:");
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).jdField_b_of_type_Int);
                    ((StringBuilder)localObject4).append(" info_2:");
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).jdField_a_of_type_JavaLangString);
                    ((StringBuilder)localObject4).append(paramString);
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).jdField_b_of_type_Long);
                    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject4).toString());
                    ((Iterator)localObject2).remove();
                  }
                }
                else {
                  ((Iterator)localObject2).remove();
                }
              }
              long l = paramLong;
              localObject2 = paramString;
              localObject3 = localObject1;
              localObject1 = localObject2;
              paramString = (String)localObject3;
              paramLong = l;
              if (localLinkedHashMap.size() == 0)
              {
                localIterator.remove();
                localObject1 = localObject2;
                paramString = (String)localObject3;
                paramLong = l;
              }
            }
            else
            {
              localObject2 = paramString;
              paramString = (String)localObject1;
              localIterator.remove();
              localObject1 = localObject2;
            }
            localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
          }
        }
      }
    }
    return bool2;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new OnlineFileSessionCenter.4(this, Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter$UploadProgressMakeEvtPump == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter$UploadProgressMakeEvtPump = new OnlineFileSessionCenter.UploadProgressMakeEvtPump(this, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter$UploadProgressMakeEvtPump.a();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] start progress make pump thread!!!");
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession onNeworkChanged set failed");
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new OnlineFileSessionCenter.3(this, paramInt));
      return;
    }
    a(paramInt);
  }
  
  public void b(long paramLong)
  {
    if (0L == paramLong)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("] ResumeTrans sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = a(paramLong);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]. not find worker.ResumeTrans");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ((OnlineFileSessionWorker)localObject).g();
    if (((OnlineFileSessionWorker)localObject).c()) {
      c(paramLong);
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("OLfilesession[");
        paramString.append(paramLong);
        paramString.append("]. not find worker.onSenderReplayComeOnRecv");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      paramString.i();
      if (paramString.c()) {
        c(paramString.jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onSenderReplayComeOnRecv sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("OLfilesession[");
        paramString.append(paramLong);
        paramString.append("]. not find worker.onAskSenderUpProgressResult");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      paramString.b(paramBoolean);
      if (paramString.c()) {
        c(paramString.jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onAskSenderUpProgressResult sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  void c()
  {
    OnlineFileSessionCenter.UploadProgressMakeEvtPump localUploadProgressMakeEvtPump = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter$UploadProgressMakeEvtPump;
    if (localUploadProgressMakeEvtPump != null)
    {
      localUploadProgressMakeEvtPump.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter$UploadProgressMakeEvtPump = null;
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] stop progress make pump thread!!!");
    }
  }
  
  void c(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]. remove the worker");
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void c(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramLong > 0L))
    {
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("OLfilesession[");
        paramString.append(paramLong);
        paramString.append("]. not find worker.onAskUpProgressAndSessionInvaid");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      paramString.m();
      if (paramString.c()) {
        c(paramString.jdField_a_of_type_Long);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onAskUpProgressAndSessionInvaid sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)((Map.Entry)localObject).getValue();
      localOnlineFileSessionWorker.b(l1);
      if (localOnlineFileSessionWorker.c())
      {
        long l2 = ((Long)((Map.Entry)localObject).getKey()).longValue();
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        localIterator.remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append("]. remove the worker..[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
        ((StringBuilder)localObject).append("]");
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0) {
      c();
    }
  }
  
  public void d(long paramLong)
  {
    try
    {
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localOnlineFileSessionWorker != null) {
        localOnlineFileSessionWorker.n();
      }
      c(paramLong);
      return;
    }
    finally {}
  }
  
  public void e()
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  clearHistory. session center stop. . .");
    a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      if ((localQQAppInterface.getApp() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter() != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter
 * JD-Core Version:    0.7.0.1
 */
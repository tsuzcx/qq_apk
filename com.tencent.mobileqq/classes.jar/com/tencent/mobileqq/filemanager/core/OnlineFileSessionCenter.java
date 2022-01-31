package com.tencent.mobileqq.filemanager.core;

import acnb;
import acnd;
import acne;
import acnf;
import acng;
import acnh;
import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
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
  private long jdField_a_of_type_Long;
  private acnh jdField_a_of_type_Acnh;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new acnd(this);
  LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private LinkedHashMap b = new LinkedHashMap();
  
  public OnlineFileSessionCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    try
    {
      ThreadManager.executeOnSubThread(new acnb(this, paramQQAppInterface));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 2, paramQQAppInterface.toString());
    }
  }
  
  public OnlineFileSessionWorker a(long paramLong)
  {
    OnlineFileSessionWorker localOnlineFileSessionWorker3 = (OnlineFileSessionWorker)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
    OnlineFileSessionWorker localOnlineFileSessionWorker1 = localOnlineFileSessionWorker3;
    if (localOnlineFileSessionWorker3 == null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
      localOnlineFileSessionWorker1 = localOnlineFileSessionWorker3;
      if (localFileManagerEntity != null)
      {
        localOnlineFileSessionWorker1 = new OnlineFileSessionWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
        localOnlineFileSessionWorker1.a(localFileManagerEntity);
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), localOnlineFileSessionWorker1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong))
      {
        QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
        if (localOnlineFileSessionWorker1 != null)
        {
          localOnlineFileSessionWorker1.n();
          c(paramLong);
        }
        return null;
      }
    }
    finally {}
    if (localOnlineFileSessionWorker2 != null) {
      localOnlineFileSessionWorker2.k();
    }
    b();
    return localOnlineFileSessionWorker2;
  }
  
  OnlineFileSessionWorker a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localOnlineFileSessionWorker = (OnlineFileSessionWorker)((Iterator)localObject).next();
    } while ((localOnlineFileSessionWorker == null) || (localOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (!paramString.equalsIgnoreCase(localOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) || (paramLong != localOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId));
    for (;;)
    {
      if (localOnlineFileSessionWorker == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
        if (localObject == null) {
          break label261;
        }
        paramLong = ((FileManagerEntity)localObject).nSessionId;
        paramString = new OnlineFileSessionWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).nSessionId);
        paramString.a((FileManagerEntity)localObject);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramLong), paramString);
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong)) {
            break label247;
          }
          QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] getOnlineWorker, but user had deleted it, return null");
          if (paramString != null)
          {
            paramString.n();
            c(paramLong);
          }
          return null;
        }
        finally {}
        if (localOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
        {
          paramLong = localOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
          paramString = localOnlineFileSessionWorker;
          continue;
          label247:
          if (paramString != null) {
            paramString.k();
          }
          b();
          return paramString;
        }
        else
        {
          label261:
          paramString = localOnlineFileSessionWorker;
          paramLong = 0L;
        }
      }
      localOnlineFileSessionWorker = null;
    }
  }
  
  public void a()
  {
    c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((OnlineFileSessionWorker)localEntry.getValue()).n();
      long l = ((Long)localEntry.getKey()).longValue();
      int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      localIterator.remove();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]. stop. and remove the worker..[" + i + " - " + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)localEntry.getValue();
      localOnlineFileSessionWorker.b(paramInt);
      if (localOnlineFileSessionWorker.c())
      {
        long l = ((Long)localEntry.getKey()).longValue();
        localIterator.remove();
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]. remove the worker....");
      }
    }
    a();
  }
  
  public void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] PauseTrans sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.PauseTrans");
        return;
      }
      localOnlineFileSessionWorker.f();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong))
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] had be deleted by user. stop it");
        localOnlineFileSessionWorker.n();
      }
    } while (!localOnlineFileSessionWorker.c());
    c(paramLong);
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderCancelUpload sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      do
      {
        return;
        localOnlineFileSessionWorker = a(paramString, paramLong);
        if (localOnlineFileSessionWorker != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderCancelUpload");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong));
      a(paramString, paramLong, new acng(this, 10));
      return;
      localOnlineFileSessionWorker.e();
    } while (!localOnlineFileSessionWorker.c());
    c(localOnlineFileSessionWorker.jdField_a_of_type_Long);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onFileRequestBeHandledByPC sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      do
      {
        return;
        localOnlineFileSessionWorker = a(paramString, paramLong);
        if (localOnlineFileSessionWorker != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onFileRequestBeHandledByPC");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong));
      a(paramString, paramLong, new acng(this, paramInt));
      return;
      localOnlineFileSessionWorker.a(paramInt);
    } while (!localOnlineFileSessionWorker.c());
    c(localOnlineFileSessionWorker.jdField_a_of_type_Long);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderUploadProgressNotify sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderUploadProgressNotify");
        return;
      }
      paramString.a(paramInt1, paramInt2);
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderUploadException sessionid error.return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(paramString1, paramLong);
        if (localObject != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderUploadException");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong));
      localObject = new acng(this, 12);
      ((acng)localObject).jdField_b_of_type_Int = paramInt;
      ((acng)localObject).jdField_a_of_type_JavaLangString = paramString2;
      a(paramString1, paramLong, (acng)localObject);
      return;
      ((OnlineFileSessionWorker)localObject).a(paramInt, paramString2);
    } while (!((OnlineFileSessionWorker)localObject).c());
    c(((OnlineFileSessionWorker)localObject).jdField_a_of_type_Long);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    if ((paramString1 == null) || (paramLong1 <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "]onSenderUploadCompleted  sessionid error.return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a(paramString1, paramLong1);
        if (localObject != null) {
          break;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "]. not find worker.onSenderUploadCompleted");
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramLong1));
      localObject = new acng(this, 11);
      ((acng)localObject).jdField_b_of_type_Int = paramInt;
      ((acng)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((acng)localObject).jdField_b_of_type_Long = paramLong2;
      a(paramString1, paramLong1, (acng)localObject);
      return;
      if (!((OnlineFileSessionWorker)localObject).a(paramInt, paramString2, paramLong2)) {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed. but onlineworker handle failed!!!!");
      }
    } while (!((OnlineFileSessionWorker)localObject).c());
    c(((OnlineFileSessionWorker)localObject).jdField_a_of_type_Long);
  }
  
  void a(String paramString, long paramLong, acng paramacng)
  {
    if ((paramString == null) || (paramLong <= 0L) || (paramacng == null)) {
      return;
    }
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  cacheHandleBeforeRequest handleType:" + paramacng.jdField_a_of_type_Int + " info_1:" + paramacng.jdField_b_of_type_Int + " info_2:" + paramacng.jdField_a_of_type_JavaLangString + " info_3:" + paramacng.jdField_b_of_type_Long);
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.b.get(paramString);
    if (localLinkedHashMap == null)
    {
      localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put(Long.valueOf(paramLong), paramacng);
      this.b.put(paramString, localLinkedHashMap);
      return;
    }
    localLinkedHashMap.put(Long.valueOf(paramLong), paramacng);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onRecvOnLineFileResult sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onRecvOnLineFileResult");
        return;
      }
      paramString.a(paramBoolean);
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt1, String paramString3, OnlineFileSessionInfo paramOnlineFileSessionInfo, long paramLong2, int paramInt2)
  {
    if (paramOnlineFileSessionInfo == null)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession. request come,but session = null");
      return;
    }
    if (0L == paramOnlineFileSessionInfo.jdField_b_of_type_Long)
    {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "]  onFileRequestCome sessionid error.return");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long) != null)
    {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] request come filename:" + paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString + ", but is repeat session and return");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long))
    {
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] request come filename:" + paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString + "but it had be deleted by user");
      return;
    }
    String str = TransfileUtile.a(BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString, 0, null), paramOnlineFileSessionInfo.jdField_a_of_type_Long, 0, false, null);
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l, paramString1, 0);
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
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] - nSessionId[" + localFileManagerEntity.nSessionId + "] request come filename:" + paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramString2, false, paramOnlineFileSessionInfo.jdField_a_of_type_JavaLangString, paramOnlineFileSessionInfo.jdField_a_of_type_Long, false, 0, str, paramShort, paramShort, paramString3, paramInt1, l, localFileManagerEntity.nSessionId, paramLong2, paramLong1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "File Coming:" + FileManagerUtil.a(localFileManagerEntity));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, localFileManagerEntity.nSessionId, paramString1, 0, 17, null, 0, null);
    if (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    }
    paramString2 = new OnlineFileSessionWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId);
    paramString2.a(localFileManagerEntity);
    do
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(localFileManagerEntity.nSessionId), paramString2);
        paramString2.k();
        if (paramString2.c())
        {
          c(localFileManagerEntity.nSessionId);
          b();
          return;
        }
      }
      finally {}
    } while (!a(paramString1, paramOnlineFileSessionInfo.jdField_b_of_type_Long));
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramOnlineFileSessionInfo.jdField_b_of_type_Long + "] had be handled before request come");
  }
  
  public boolean a(long paramLong)
  {
    boolean bool1 = false;
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] recvOnLineFile sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    boolean bool2;
    do
    {
      return bool1;
      localOnlineFileSessionWorker = a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.recvOnLineFile");
        return false;
      }
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.b = "recv_file_online";
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localfileAssistantReportData);
      bool2 = localOnlineFileSessionWorker.d();
      bool1 = bool2;
    } while (!localOnlineFileSessionWorker.c());
    c(paramLong);
    return bool2;
  }
  
  boolean a(String paramString, long paramLong)
  {
    boolean bool2;
    if ((paramString == null) || (paramLong <= 0L))
    {
      bool2 = false;
      return bool2;
    }
    LinkedHashMap localLinkedHashMap = (LinkedHashMap)this.b.get(paramString);
    Object localObject;
    boolean bool1;
    if (localLinkedHashMap != null)
    {
      localObject = (acng)localLinkedHashMap.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  isBeHandledBeforeRequest handleType:" + ((acng)localObject).jdField_a_of_type_Int + " info_1:" + ((acng)localObject).jdField_b_of_type_Int + " info_2:" + ((acng)localObject).jdField_a_of_type_JavaLangString + " info_3:" + ((acng)localObject).jdField_b_of_type_Long);
        switch (((acng)localObject).jdField_a_of_type_Int)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          bool1 = false;
          localLinkedHashMap.remove(Long.valueOf(paramLong));
          if (localLinkedHashMap.size() == 0) {
            this.b.remove(paramString);
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramLong = MessageCache.a();
      bool2 = bool1;
      if (paramLong - this.jdField_a_of_type_Long < 3600L) {
        break;
      }
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  isBeHandledBeforeRequest handleType. start clear something");
      this.jdField_a_of_type_Long = paramLong;
      bool2 = bool1;
      if (this.b.size() <= 0) {
        break;
      }
      paramString = this.b.entrySet().iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramString.hasNext()) {
          break;
        }
        localLinkedHashMap = (LinkedHashMap)((Map.Entry)paramString.next()).getValue();
        if ((localLinkedHashMap != null) && (localLinkedHashMap.size() > 0))
        {
          localObject = localLinkedHashMap.entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label597;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            acng localacng = (acng)localEntry.getValue();
            long l = ((Long)localEntry.getKey()).longValue();
            if (localacng != null)
            {
              if (paramLong - localacng.jdField_a_of_type_Long < 7200L) {
                continue;
              }
              QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l + "]  isBeHandledBeforeRequest and clear it.handleType:" + localacng.jdField_a_of_type_Int + " info_1:" + localacng.jdField_b_of_type_Int + " info_2:" + localacng.jdField_a_of_type_JavaLangString + " info_3:" + localacng.jdField_b_of_type_Long);
              ((Iterator)localObject).remove();
              continue;
              a(paramString, paramLong, ((acng)localObject).jdField_a_of_type_Int);
              bool1 = true;
              break;
              a(paramString, paramLong);
              bool1 = true;
              break;
              a(paramString, paramLong, ((acng)localObject).jdField_b_of_type_Int, ((acng)localObject).jdField_a_of_type_JavaLangString, ((acng)localObject).jdField_b_of_type_Long);
              bool1 = true;
              break;
              a(paramString, paramLong, ((acng)localObject).jdField_b_of_type_Int, ((acng)localObject).jdField_a_of_type_JavaLangString);
              bool1 = true;
              break;
            }
            ((Iterator)localObject).remove();
          }
          label597:
          if (localLinkedHashMap.size() == 0) {
            paramString.remove();
          }
        }
        else
        {
          paramString.remove();
        }
      }
      bool1 = false;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new acnf(this, Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_Acnh == null)
    {
      this.jdField_a_of_type_Acnh = new acnh(this, null);
      this.jdField_a_of_type_Acnh.a();
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] start progress make pump thread!!!");
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession onNeworkChanged set failed");
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acne(this, paramInt));
      return;
    }
    a(paramInt);
  }
  
  public void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] ResumeTrans sessionid error.return");
    }
    OnlineFileSessionWorker localOnlineFileSessionWorker;
    do
    {
      return;
      localOnlineFileSessionWorker = a(paramLong);
      if (localOnlineFileSessionWorker == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.ResumeTrans");
        return;
      }
      localOnlineFileSessionWorker.g();
    } while (!localOnlineFileSessionWorker.c());
    c(paramLong);
  }
  
  public void b(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onSenderReplayComeOnRecv sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onSenderReplayComeOnRecv");
        return;
      }
      paramString.i();
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onAskSenderUpProgressResult sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onAskSenderUpProgressResult");
        return;
      }
      paramString.b(paramBoolean);
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Acnh != null)
    {
      this.jdField_a_of_type_Acnh.b();
      this.jdField_a_of_type_Acnh = null;
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] stop progress make pump thread!!!");
    }
  }
  
  public void c(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. remove the worker");
      return;
    }
    finally {}
  }
  
  public void c(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong <= 0L)) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] onAskUpProgressAndSessionInvaid sessionid error.return");
    }
    do
    {
      return;
      paramString = a(paramString, paramLong);
      if (paramString == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.onAskUpProgressAndSessionInvaid");
        return;
      }
      paramString.m();
    } while (!paramString.c());
    c(paramString.jdField_a_of_type_Long);
  }
  
  public void d()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)localEntry.getValue();
      localOnlineFileSessionWorker.b(l1);
      if (localOnlineFileSessionWorker.c())
      {
        long l2 = ((Long)localEntry.getKey()).longValue();
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        localIterator.remove();
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + l2 + "]. remove the worker..[" + i + " - " + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter
 * JD-Core Version:    0.7.0.1
 */
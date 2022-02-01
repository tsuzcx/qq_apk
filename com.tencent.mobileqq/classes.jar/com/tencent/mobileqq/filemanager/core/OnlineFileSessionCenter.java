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
  QQAppInterface a;
  LinkedHashMap<Long, OnlineFileSessionWorker> b = new LinkedHashMap();
  Handler c = null;
  private BroadcastReceiver d;
  private FMObserver e = new OnlineFileSessionCenter.2(this);
  private OnlineFileSessionCenter.UploadProgressMakeEvtPump f = null;
  private LinkedHashMap<String, LinkedHashMap<Long, OnlineFileSessionCenter.HandleInfoBeforeRequest>> g = new LinkedHashMap();
  private long h = 0L;
  
  public OnlineFileSessionCenter(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.e);
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
    Object localObject2 = (OnlineFileSessionWorker)this.b.get(Long.valueOf(paramLong));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().a(paramLong);
      localObject1 = localObject2;
      if (localFileManagerEntity != null)
      {
        localObject1 = new OnlineFileSessionWorker(this.a, localFileManagerEntity.nSessionId);
        ((OnlineFileSessionWorker)localObject1).a(localFileManagerEntity);
        try
        {
          this.b.put(Long.valueOf(paramLong), localObject1);
        }
        finally {}
      }
    }
    if (this.a.getFileManagerDataCenter().d(paramLong))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OLfilesession[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("] getOnlineWorker, but user had deleted it, return null");
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      if (localOnlineFileSessionWorker != null)
      {
        localOnlineFileSessionWorker.r();
        e(paramLong);
      }
      return null;
    }
    if (localOnlineFileSessionWorker != null) {
      localOnlineFileSessionWorker.o();
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
      Object localObject2 = this.b.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (OnlineFileSessionWorker)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((OnlineFileSessionWorker)localObject1).c != null) && (paramString.equalsIgnoreCase(((OnlineFileSessionWorker)localObject1).c.peerUin)) && (paramLong == ((OnlineFileSessionWorker)localObject1).c.nOLfileSessionId)) {
          break label98;
        }
      }
      Object localObject1 = null;
      label98:
      if (localObject1 == null)
      {
        localObject2 = this.a.getFileManagerDataCenter().a(paramString, paramLong);
        paramLong = l;
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramLong = ((FileManagerEntity)localObject2).nSessionId;
          paramString = new OnlineFileSessionWorker(this.a, ((FileManagerEntity)localObject2).nSessionId);
          paramString.a((FileManagerEntity)localObject2);
          try
          {
            this.b.put(Long.valueOf(paramLong), paramString);
          }
          finally {}
        }
      }
      else
      {
        paramLong = l;
        paramString = (String)localObject1;
        if (((OnlineFileSessionWorker)localObject1).c != null)
        {
          paramLong = ((OnlineFileSessionWorker)localObject1).c.nSessionId;
          paramString = (String)localObject1;
        }
      }
      if (this.a.getFileManagerDataCenter().d(paramLong))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OLfilesession[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("] getOnlineWorker, but user had deleted it, return null");
        QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        if (paramString != null)
        {
          paramString.r();
          e(paramLong);
        }
        return null;
      }
      if (paramString != null) {
        paramString.o();
      }
      b();
      return paramString;
    }
    return null;
  }
  
  public void a()
  {
    c();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ((OnlineFileSessionWorker)((Map.Entry)localObject).getValue()).r();
      long l = ((Long)((Map.Entry)localObject).getKey()).longValue();
      int i = this.b.size();
      localIterator.remove();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]. stop. and remove the worker..[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(this.b.size());
      ((StringBuilder)localObject).append("]");
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)((Map.Entry)localObject).getValue();
      localOnlineFileSessionWorker.b(paramInt);
      if (localOnlineFileSessionWorker.g())
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
        if (!this.a.getFileManagerDataCenter().b(paramString, paramLong)) {
          a(paramString, paramLong, new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, paramInt));
        }
        return;
      }
      ((OnlineFileSessionWorker)localObject).a(paramInt);
      if (((OnlineFileSessionWorker)localObject).g()) {
        e(((OnlineFileSessionWorker)localObject).b);
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
      if (paramString.g()) {
        e(paramString.b);
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
        if (!this.a.getFileManagerDataCenter().b(paramString1, paramLong))
        {
          localObject = new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, 12);
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).c = paramInt;
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).d = paramString2;
          a(paramString1, paramLong, (OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject);
        }
        return;
      }
      ((OnlineFileSessionWorker)localObject).a(paramInt, paramString2);
      if (((OnlineFileSessionWorker)localObject).g()) {
        e(((OnlineFileSessionWorker)localObject).b);
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
        if (!this.a.getFileManagerDataCenter().b(paramString1, paramLong1))
        {
          localObject = new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, 11);
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).c = paramInt;
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).d = paramString2;
          ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject).e = paramLong2;
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
      if (((OnlineFileSessionWorker)localObject).g()) {
        e(((OnlineFileSessionWorker)localObject).b);
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
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.a);
      ((StringBuilder)localObject).append(" info_1:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.c);
      ((StringBuilder)localObject).append(" info_2:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.d);
      ((StringBuilder)localObject).append(" info_3:");
      ((StringBuilder)localObject).append(paramHandleInfoBeforeRequest.e);
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      localObject = (LinkedHashMap)this.g.get(paramString);
      if (localObject == null)
      {
        localObject = new LinkedHashMap();
        ((LinkedHashMap)localObject).put(Long.valueOf(paramLong), paramHandleInfoBeforeRequest);
        this.g.put(paramString, localObject);
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
      if (paramString.g()) {
        e(paramString.b);
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
    if (0L == paramOnlineFileSessionInfo.c)
    {
      paramString1 = new StringBuilder();
      paramString1.append("OLfilesession[");
      paramString1.append(paramOnlineFileSessionInfo.c);
      paramString1.append("]  onFileRequestCome sessionid error.return");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (this.a.getFileManagerDataCenter().a(paramString1, paramOnlineFileSessionInfo.c) != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("OLfilesession[");
      paramString1.append(paramOnlineFileSessionInfo.c);
      paramString1.append("] request come filename:");
      paramString1.append(paramOnlineFileSessionInfo.a);
      paramString1.append(", but is repeat session and return");
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (this.a.getFileManagerDataCenter().b(paramString1, paramOnlineFileSessionInfo.c))
    {
      paramString1 = new StringBuilder();
      paramString1.append("OLfilesession[");
      paramString1.append(paramOnlineFileSessionInfo.c);
      paramString1.append("] request come filename:");
      paramString1.append(paramOnlineFileSessionInfo.a);
      paramString1.append("but it had be deleted by user");
      QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
      return;
    }
    String str = TransfileUtile.makeTransFileProtocolData(TransFileUtil.getTransferFilePath(this.a.getAccount(), paramOnlineFileSessionInfo.a, 0, null), paramOnlineFileSessionInfo.b, 0, false, null);
    long l = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().b(l, paramString1, 0);
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.selfUin = this.a.getAccount();
    localFileManagerEntity.setCloudType(0);
    localFileManagerEntity.fileName = paramOnlineFileSessionInfo.a;
    localFileManagerEntity.fileSize = paramOnlineFileSessionInfo.b;
    localFileManagerEntity.nOpType = -1;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.a, paramString1, null, 0);
    localFileManagerEntity.peerType = 0;
    localFileManagerEntity.peerUin = paramString1;
    localFileManagerEntity.srvTime = (1000L * paramLong1);
    localFileManagerEntity.status = 4;
    localFileManagerEntity.Uuid = null;
    localFileManagerEntity.isReaded = paramBoolean;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.nFileType = -1;
    localFileManagerEntity.nOLfileSessionId = paramOnlineFileSessionInfo.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(paramOnlineFileSessionInfo.c);
    localStringBuilder.append("] - nSessionId[");
    localStringBuilder.append(localFileManagerEntity.nSessionId);
    localStringBuilder.append("] request come filename:");
    localStringBuilder.append(paramOnlineFileSessionInfo.a);
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, localStringBuilder.toString());
    this.a.getFileManagerProxy().a(localFileManagerEntity);
    this.a.getFileManagerDataCenter().a(localFileManagerEntity);
    this.a.getFileManagerDataCenter().a(paramString1, paramString2, false, paramOnlineFileSessionInfo.a, paramOnlineFileSessionInfo.b, false, 0, str, paramShort, l, localFileManagerEntity.nSessionId, paramLong2, paramLong1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("File Coming:");
      paramString2.append(FileManagerUtil.c(localFileManagerEntity));
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, paramString2.toString());
    }
    this.a.getFileManagerNotifyCenter().a(l, localFileManagerEntity.nSessionId, paramString1, 0, 17, null, 0, null);
    if (!paramString1.equals(this.a.getMessageFacade().l())) {
      this.a.handleReceivedMessage(1, true, true);
    }
    paramString2 = new OnlineFileSessionWorker(this.a, localFileManagerEntity.nSessionId);
    paramString2.a(localFileManagerEntity);
    try
    {
      this.b.put(Long.valueOf(localFileManagerEntity.nSessionId), paramString2);
      paramString2.o();
      if (paramString2.g())
      {
        e(localFileManagerEntity.nSessionId);
      }
      else if (e(paramString1, paramOnlineFileSessionInfo.c))
      {
        paramString1 = new StringBuilder();
        paramString1.append("OLfilesession[");
        paramString1.append(paramOnlineFileSessionInfo.c);
        paramString1.append("] had be handled before request come");
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, paramString1.toString());
        return;
      }
      b();
      return;
    }
    finally {}
  }
  
  void b()
  {
    if (this.c == null) {
      this.c = new OnlineFileSessionCenter.4(this, Looper.getMainLooper());
    }
    if (this.f == null)
    {
      this.f = new OnlineFileSessionCenter.UploadProgressMakeEvtPump(this, null);
      this.f.a();
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
  
  public void b(String paramString, long paramLong)
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
        if (!this.a.getFileManagerDataCenter().b(paramString, paramLong)) {
          a(paramString, paramLong, new OnlineFileSessionCenter.HandleInfoBeforeRequest(this, 10));
        }
        return;
      }
      ((OnlineFileSessionWorker)localObject).i();
      if (((OnlineFileSessionWorker)localObject).g()) {
        e(((OnlineFileSessionWorker)localObject).b);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onSenderCancelUpload sessionid error.return");
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
      if (paramString.g()) {
        e(paramString.b);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onAskSenderUpProgressResult sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public boolean b(long paramLong)
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
    FileManagerReporter.a(this.a.getCurrentAccountUin(), localFileAssistantReportData);
    boolean bool = ((OnlineFileSessionWorker)localObject).h();
    if (((OnlineFileSessionWorker)localObject).g()) {
      e(paramLong);
    }
    return bool;
  }
  
  void c()
  {
    OnlineFileSessionCenter.UploadProgressMakeEvtPump localUploadProgressMakeEvtPump = this.f;
    if (localUploadProgressMakeEvtPump != null)
    {
      localUploadProgressMakeEvtPump.b();
      this.f = null;
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] stop progress make pump thread!!!");
    }
  }
  
  public void c(long paramLong)
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
    ((OnlineFileSessionWorker)localObject).j();
    if (this.a.getFileManagerDataCenter().d(paramLong))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("] had be deleted by user. stop it");
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, localStringBuilder.toString());
      ((OnlineFileSessionWorker)localObject).r();
    }
    if (((OnlineFileSessionWorker)localObject).g()) {
      e(paramLong);
    }
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
        paramString.append("]. not find worker.onSenderReplayComeOnRecv");
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      paramString.m();
      if (paramString.g()) {
        e(paramString.b);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onSenderReplayComeOnRecv sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)((Map.Entry)localObject).getValue();
      localOnlineFileSessionWorker.b(l1);
      if (localOnlineFileSessionWorker.g())
      {
        long l2 = ((Long)((Map.Entry)localObject).getKey()).longValue();
        int i = this.b.size();
        localIterator.remove();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append("]. remove the worker..[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(this.b.size());
        ((StringBuilder)localObject).append("]");
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
    }
    if (this.b.size() == 0) {
      c();
    }
  }
  
  public void d(long paramLong)
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
    ((OnlineFileSessionWorker)localObject).k();
    if (((OnlineFileSessionWorker)localObject).g()) {
      e(paramLong);
    }
  }
  
  public void d(String paramString, long paramLong)
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
      paramString.q();
      if (paramString.g()) {
        e(paramString.b);
      }
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(paramLong);
    paramString.append("] onAskUpProgressAndSessionInvaid sessionid error.return");
    QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, paramString.toString());
  }
  
  public void e()
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  clearHistory. session center stop. . .");
    a();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      if ((localQQAppInterface.getApp() != null) && (this.d != null))
      {
        this.a.getApp().unregisterReceiver(this.d);
        this.d = null;
      }
      if ((this.a.getFileManagerNotifyCenter() != null) && (this.e != null)) {
        this.a.getFileManagerNotifyCenter().deleteObserver(this.e);
      }
    }
  }
  
  void e(long paramLong)
  {
    try
    {
      this.b.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]. remove the worker");
      QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  boolean e(String paramString, long paramLong)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString != null)
    {
      if (paramLong <= 0L) {
        return false;
      }
      Object localObject1 = (LinkedHashMap)this.g.get(paramString);
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
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).a);
          ((StringBuilder)localObject3).append(" info_1:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).c);
          ((StringBuilder)localObject3).append(" info_2:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).d);
          ((StringBuilder)localObject3).append(" info_3:");
          ((StringBuilder)localObject3).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).e);
          QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
          int i = ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).a;
          if ((i != 1) && (i != 2) && (i != 3) && (i != 4) && (i != 5)) {}
          switch (i)
          {
          default: 
            bool2 = bool1;
            break;
          case 12: 
            a(paramString, paramLong, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).c, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).d);
            break;
          case 11: 
            a(paramString, paramLong, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).c, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).d, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).e);
            break;
          case 10: 
            b(paramString, paramLong);
            break;
            a(paramString, paramLong, ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject2).a);
          }
          bool2 = true;
          ((LinkedHashMap)localObject1).remove(Long.valueOf(paramLong));
          bool1 = bool2;
          if (((LinkedHashMap)localObject1).size() != 0) {
            break label355;
          }
          this.g.remove(paramString);
          bool1 = bool2;
          break label355;
        }
      }
      bool1 = bool3;
      label355:
      localObject1 = "OLfilesession[";
      paramString = " info_3:";
      paramLong = MessageCache.c();
      bool2 = bool1;
      if (paramLong - this.h >= 3600L)
      {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  isBeHandledBeforeRequest handleType. start clear something");
        this.h = paramLong;
        bool2 = bool1;
        if (this.g.size() > 0)
        {
          Iterator localIterator = this.g.entrySet().iterator();
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
                  if (paramLong - ((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).b >= 7200L)
                  {
                    localObject4 = new StringBuilder();
                    ((StringBuilder)localObject4).append((String)localObject1);
                    ((StringBuilder)localObject4).append(l);
                    ((StringBuilder)localObject4).append("]  isBeHandledBeforeRequest and clear it.handleType:");
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).a);
                    ((StringBuilder)localObject4).append(" info_1:");
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).c);
                    ((StringBuilder)localObject4).append(" info_2:");
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).d);
                    ((StringBuilder)localObject4).append(paramString);
                    ((StringBuilder)localObject4).append(((OnlineFileSessionCenter.HandleInfoBeforeRequest)localObject3).e);
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
  
  public void f(long paramLong)
  {
    try
    {
      OnlineFileSessionWorker localOnlineFileSessionWorker = (OnlineFileSessionWorker)this.b.get(Long.valueOf(paramLong));
      if (localOnlineFileSessionWorker != null) {
        localOnlineFileSessionWorker.r();
      }
      e(paramLong);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter
 * JD-Core Version:    0.7.0.1
 */
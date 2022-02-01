package com.tencent.mobileqq.filemanager.core;

import android.util.Pair;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class OnlineFileSessionWorker
{
  QQAppInterface a;
  long b;
  FileManagerEntity c = null;
  long d = 0L;
  long e = 0L;
  long f = 0L;
  long g = 0L;
  OnlineFileSessionWorker.RecvOnlineFileOpContent h = new OnlineFileSessionWorker.RecvOnlineFileOpContent(this);
  private OnlineFileSessionWorker.StateBase i;
  private Timer j = null;
  private Object k = new Object();
  private Timer l = null;
  private Object m = new Object();
  
  public OnlineFileSessionWorker(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.a = paramQQAppInterface;
    this.b = paramLong;
    this.i = new OnlineFileSessionWorker.StateBase(this);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.c == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] setCurStateOfEntityTo can not find entity . state change :(");
      ((StringBuilder)localObject).append(this.i.a());
      ((StringBuilder)localObject).append("-> StateEnd)");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.i = new OnlineFileSessionWorker.StateEnd(this);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] state:");
    ((StringBuilder)localObject).append(this.i.a());
    ((StringBuilder)localObject).append(" curstate of entity change: (opType:");
    ((StringBuilder)localObject).append(this.c.nOpType);
    ((StringBuilder)localObject).append(" status:");
    ((StringBuilder)localObject).append(this.c.status);
    ((StringBuilder)localObject).append(") -> (opType:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("  status:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(") savedb=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.c;
    ((FileManagerEntity)localObject).nOpType = paramInt1;
    ((FileManagerEntity)localObject).status = paramInt2;
    if (paramBoolean) {
      this.a.getFileManagerDataCenter().c(this.c);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] setStateToDatabase can not find entity . state change :(");
      ((StringBuilder)localObject).append(this.i.a());
      ((StringBuilder)localObject).append("-> StateEnd)");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.i = new OnlineFileSessionWorker.StateEnd(this);
      return;
    }
    localObject = ((FileManagerEntity)localObject).clone();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("] current status(opType:");
    localStringBuilder.append(((FileManagerEntity)localObject).nOpType);
    localStringBuilder.append(" status:");
    localStringBuilder.append(((FileManagerEntity)localObject).status);
    localStringBuilder.append("). saveto db(opType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  status:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    if (-2 != paramInt1) {
      ((FileManagerEntity)localObject).nOpType = paramInt1;
    }
    if (-2 != paramInt2) {
      ((FileManagerEntity)localObject).status = paramInt2;
    }
    this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity = this.c;
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.nOpType = paramInt1;
      localFileManagerEntity.status = paramInt2;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] setDBStateOfEntityTo can not find entity . state change :(");
      ((StringBuilder)localObject).append(this.i.a());
      ((StringBuilder)localObject).append("-> StateEnd)");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      this.i = new OnlineFileSessionWorker.StateEnd(this);
      return;
    }
    localObject = ((FileManagerEntity)localObject).clone();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" curstate: (opType:");
    localStringBuilder.append(this.c.nOpType);
    localStringBuilder.append(" status:");
    localStringBuilder.append(this.c.status);
    localStringBuilder.append(").  save state:(opType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  status:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") to DB");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    ((FileManagerEntity)localObject).nOpType = paramInt1;
    ((FileManagerEntity)localObject).status = paramInt2;
    this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
  }
  
  private boolean d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] no status. when GOTO_UPLOAD:");
      localStringBuilder.append(paramInt);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return false;
    case 15: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateWaitResultWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateWaitResultWhenRecv(this);
      break;
    case 14: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateUploadingWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateUploadingWhenRecv(this);
      break;
    case 12: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateExcepInvalidWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this);
      break;
    case 11: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateLocalFailedWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this);
      break;
    case 10: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateChangeToOffFailedWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this);
      break;
    case 9: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateCancelUploadWhenRecv)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this);
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] can not set the status. when GOTO_UPLOAD:");
    localStringBuilder.append(paramInt);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    return false;
  }
  
  private boolean e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] no status. when STOP_UPLOAD:");
      localStringBuilder.append(paramInt);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return false;
    case 15: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateWaitResultWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateWaitResultWhenPause(this);
      break;
    case 14: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateUploadingWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateUploadingWhenPause(this);
      break;
    case 12: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateExcepInvalidWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateExcepInvalidWhenPause(this);
      break;
    case 11: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateLocalFailedWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateLocalFailedWhenPause(this);
      break;
    case 10: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateChangeToOffFailedWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateChangeToOffFailedWhenPause(this);
      break;
    case 9: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateCancelUploadWhenPause)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateCancelUploadWhenPause(this);
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] can not set the status. when STOP_UPLOAD:");
    localStringBuilder.append(paramInt);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    return false;
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    boolean bool;
    if (paramInt1 != -1)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 13) {
          switch (paramInt1)
          {
          default: 
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OLfilesession[");
            localStringBuilder.append(this.b);
            localStringBuilder.append("] error optype:");
            localStringBuilder.append(paramInt1);
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            bool = false;
            break;
          case 11: 
            bool = f(paramInt2);
            break;
          case 10: 
            bool = e(paramInt2);
            break;
          case 9: 
            bool = d(paramInt2);
            break;
          }
        } else {
          bool = h(paramInt2);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] state change :(");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append("->StateGotoOffFileProcess)");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        this.i = new OnlineFileSessionWorker.StateGotoOffFileProcess(this);
        bool = true;
      }
    }
    else {
      bool = g(paramInt2);
    }
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] goto next state failed. state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("-> StateEnd)");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateEnd(this);
    }
    return bool;
  }
  
  private boolean f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] no status. when BE_PC_HANDLED:");
      localStringBuilder.append(paramInt);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return false;
    case 14: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateUploadingWhenChangeToOff)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateUploadingWhenChangeToOff(this);
      break;
    case 13: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateUploadoneWhenChangeToOff)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateUploadoneWhenChangeToOff(this);
      break;
    case 12: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateExcepInvalidWhenChangeToOff)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateExcepInvalidWhenChangeToOff(this);
      break;
    case 11: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateLocalFailedWhenChangeToOff)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateLocalFailedWhenChangeToOff(this);
      break;
    case 9: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateCancelUploadWhenChangeToOff)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateCancelUploadWhenChangeToOff(this);
      break;
    case 8: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateSenderCancelSend)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateSenderCancelSend(this);
      break;
    case 7: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateSaveToWeiYunByPC)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateSaveToWeiYunByPC(this);
      break;
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateRefuseByPC)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateRefuseByPC(this);
      break;
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateAcceptByPC)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateAcceptByPC(this);
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] can not set the status. when BE_PC_HANDLED:");
    localStringBuilder.append(paramInt);
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    return false;
  }
  
  private boolean g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] no status. when TYPE_UNKNOW:");
      localStringBuilder.append(paramInt);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return false;
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] can not set the status. when TYPE_UNKNOW:");
      localStringBuilder.append(paramInt);
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append("->StateRequest)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.i = new OnlineFileSessionWorker.StateRequest(this);
    return true;
  }
  
  private boolean h(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 5)
    {
      if (paramInt != 6)
      {
        if (paramInt != 7)
        {
          if (paramInt != 8)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OLfilesession[");
            localStringBuilder.append(this.b);
            localStringBuilder.append("] can not set the status. when BE_PC_HANDLED_ON_RECV2OFF_FAILED:");
            localStringBuilder.append(paramInt);
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
            return false;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OLfilesession[");
          localStringBuilder.append(this.b);
          localStringBuilder.append("] state change :(");
          localStringBuilder.append(this.i.a());
          localStringBuilder.append("->StateSenderCancelSendWhenToOffFailed)");
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
          this.i = new OnlineFileSessionWorker.StateSenderCancelSendWhenToOffFailed(this);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OLfilesession[");
          localStringBuilder.append(this.b);
          localStringBuilder.append("] state change :(");
          localStringBuilder.append(this.i.a());
          localStringBuilder.append("->StateSaveToWeiYunByPCWhenToOffFailed)");
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
          this.i = new OnlineFileSessionWorker.StateSaveToWeiYunByPCWhenToOffFailed(this);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("] state change :(");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append("->StateRefuseByPCWhenToOffFailed)");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        this.i = new OnlineFileSessionWorker.StateRefuseByPCWhenToOffFailed(this);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append("->StateAcceptByPCWhenToOffFailed)");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i = new OnlineFileSessionWorker.StateAcceptByPCWhenToOffFailed(this);
    }
    return true;
  }
  
  private void u()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (0L != ((FileManagerEntity)localObject).lastTime)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("] state :");
        ((StringBuilder)localObject).append(this.i.a());
        ((StringBuilder)localObject).append(" initForMakeProgress. but had init. lastTime =");
        ((StringBuilder)localObject).append(this.c.lastTime);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      this.c.lastTime = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] state :");
      ((StringBuilder)localObject).append(this.i.a());
      ((StringBuilder)localObject).append(" initForMakeProgress lastTime =");
      ((StringBuilder)localObject).append(this.c.lastTime);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  void a()
  {
    long l1;
    if (FileManagerUtil.b()) {
      l1 = 50000L;
    } else {
      l1 = 30000L;
    }
    synchronized (this.k)
    {
      if (this.j != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.c.nSessionId);
        localStringBuilder.append("] state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" failure to startWaitSenderReplayOnRecvTimer ant it is runing");
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.c.nSessionId);
      localStringBuilder.append("] state:");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" startWaitSenderReplayOnRecvTimer. outTimerInterval=");
      localStringBuilder.append(l1);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.j = new Timer();
      this.j.schedule(new OnlineFileSessionWorker.1(this), l1);
      return;
    }
  }
  
  void a(float paramFloat)
  {
    ThreadManager.post(new OnlineFileSessionWorker.3(this, paramFloat), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    this.i.a(paramInt);
    this.i = this.i.c();
    s();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" stopWaitAskUpProgressResultTimer. stopWaitSenderReplayOnRecvTimer. when onSenderUploadProgressNotify");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    c();
    b();
    this.i.a(paramInt1, paramInt2);
    this.i = this.i.c();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.i.a(paramInt, paramString);
    this.i = this.i.c();
  }
  
  void a(long paramLong)
  {
    long l1 = paramLong;
    if (0L == paramLong)
    {
      l1 = 30000L;
      if (FileManagerUtil.b()) {
        l1 = 50000L;
      }
    }
    synchronized (this.m)
    {
      if (this.l != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.c.nSessionId);
        localStringBuilder.append("] state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" failure to startWaitAskUpProgressResultTimer ant it is runing");
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.c.nSessionId);
      localStringBuilder.append("] state:");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" startWaitAskUpProgressResultTimer. outTimerInterval=");
      localStringBuilder.append(l1);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.l = new Timer();
      this.l.schedule(new OnlineFileSessionWorker.2(this), l1);
      return;
    }
  }
  
  void a(long paramLong, String paramString)
  {
    if ((paramLong != 0L) && (paramLong != this.g))
    {
      Object localObject2 = null;
      Object localObject1 = this.a.getMessageFacade();
      int i1 = 0;
      List localList = ((QQMessageFacade)localObject1).h(paramString, 0);
      localObject1 = localObject2;
      int n;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (!localList.isEmpty())
        {
          n = localList.size() - 1;
          for (;;)
          {
            localObject1 = localObject2;
            if (n < 0) {
              break;
            }
            localObject1 = (MessageRecord)localList.get(n);
            if (!MessageRecordInfo.c(((MessageRecord)localObject1).issend)) {
              break;
            }
            n -= 1;
          }
        }
      }
      if (localObject1 != null)
      {
        n = i1;
        if (!((MessageRecord)localObject1).isread) {}
      }
      else
      {
        n = 1;
      }
      if (n != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OLfilesession[");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("] setMsgReadedAndReport curFriendUin is ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", shmsgseq  is ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(new Pair(Long.valueOf(paramString), Long.valueOf(paramLong)));
        ((C2CMessageProcessor)this.a.getMsgHandler().a("c2c_processor")).a((ArrayList)localObject1);
        this.g = paramLong;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    OnlineFileSessionWorker.RecvOnlineFileOpContent localRecvOnlineFileOpContent;
    if (paramBoolean)
    {
      localRecvOnlineFileOpContent = this.h;
      localRecvOnlineFileOpContent.a += 1;
      a();
    }
    else
    {
      localRecvOnlineFileOpContent = this.h;
      localRecvOnlineFileOpContent.b += 1;
    }
    this.i.a(paramBoolean);
    this.i = this.i.c();
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderUploadCompleted");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    d();
    boolean bool = this.i.a(paramInt, paramString, paramLong);
    this.i = this.i.c();
    return bool;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("OLfilesession[");
      paramFileManagerEntity.append(this.b);
      paramFileManagerEntity.append("] init failed. state change :(");
      paramFileManagerEntity.append(this.i.a());
      paramFileManagerEntity.append("-> StateEnd)");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramFileManagerEntity.toString());
      this.i = new OnlineFileSessionWorker.StateEnd(this);
      return false;
    }
    this.c = paramFileManagerEntity;
    boolean bool = e(this.c.nOpType, this.c.status);
    paramFileManagerEntity = new StringBuilder();
    paramFileManagerEntity.append("OLfilesession[");
    paramFileManagerEntity.append(this.b);
    paramFileManagerEntity.append("] init state to:");
    paramFileManagerEntity.append(this.i.a());
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramFileManagerEntity.toString());
    return bool;
  }
  
  boolean a(String paramString, long paramLong)
  {
    if (this.h.e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]  state:");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" internalRecvOnlineFile. recv is going on, why?? ");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    }
    boolean bool = this.a.getFileTransferHandler().a(paramString, paramLong);
    if (!bool)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.b);
      paramString.append("]  state:");
      paramString.append(this.i.a());
      paramString.append(" internalRecvOnlineFile. recv cmd send failed.... ");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      paramString = this.h;
      paramString.b += 1;
      return bool;
    }
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.b);
    paramString.append("]  state:");
    paramString.append(this.i.a());
    paramString.append(" internalRecvOnlineFile. recv cmd send success, and will ask progress .... ");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    paramString = this.h;
    paramString.e = true;
    paramString.c = false;
    paramString.d = false;
    if (!a(true, 0L))
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.b);
      paramString.append("]  state:");
      paramString.append(this.i.a());
      paramString.append(" internalRecvOnlineFile. ask progress failed.... ");
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      c(2);
    }
    return bool;
  }
  
  boolean a(boolean paramBoolean, long paramLong)
  {
    if (this.l == null)
    {
      localObject = this.c;
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("]. askUpProgress entity is null");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      int n = ((FileManagerEntity)localObject).nOlSenderProgress;
      paramBoolean = this.a.getFileTransferHandler().b(this.c.peerUin, this.c.nOLfileSessionId);
      this.d += 1L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.c.nSessionId);
      ((StringBuilder)localObject).append("] state:");
      ((StringBuilder)localObject).append(this.i.a());
      ((StringBuilder)localObject).append(" ask upload progress isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(". askUpProgressCount=");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      if (paramBoolean) {
        a(paramLong);
      }
      return paramBoolean;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("]. askUpProgress is going on. return");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  void b()
  {
    synchronized (this.k)
    {
      StringBuilder localStringBuilder;
      if (this.j != null)
      {
        this.j.cancel();
        this.j = null;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.c.nSessionId);
        localStringBuilder.append("]  state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" stopWaitSenderReplayOnRecvTimer");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.c.nSessionId);
        localStringBuilder.append("]  state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" stopWaitSenderReplayOnRecvTimer.but timer had stop");
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onNetworkChanged");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    d();
    this.i.b(1);
    this.i = this.i.c();
  }
  
  public void b(long paramLong)
  {
    this.i.a(paramLong);
    this.i = this.i.c();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.c.nSessionId);
      localStringBuilder.append("]  state:");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" stopWaitAskUpProgressResultTimer. when onAskSenderUpProgressResult = false");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      c();
    }
    this.i.b(paramBoolean);
    this.i = this.i.c();
  }
  
  void c()
  {
    synchronized (this.m)
    {
      StringBuilder localStringBuilder;
      if (this.l != null)
      {
        this.l.cancel();
        this.l = null;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.c.nSessionId);
        localStringBuilder.append("]  state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" stopWaitAskUpProgressResultTimer");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.c.nSessionId);
        localStringBuilder.append("]  state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" stopWaitAskUpProgressResultTimer.but timer had stop");
        QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      }
      return;
    }
  }
  
  void c(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (1 == paramInt)
    {
      if (this.h.e)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OLfilesession[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("]  state:");
        localStringBuilder.append(this.i.a());
        localStringBuilder.append(" recv olfile is going on. but the resp of sender is error");
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
        this.h.c = true;
      }
    }
    else if ((2 == paramInt) && (this.h.e))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]  state:");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" recv olfile is going on. but the resp of ask progress is error");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.h.d = true;
    }
  }
  
  void c(boolean paramBoolean)
  {
    if (this.h.e)
    {
      Object localObject = this.h;
      ((OnlineFileSessionWorker.RecvOnlineFileOpContent)localObject).e = false;
      ((OnlineFileSessionWorker.RecvOnlineFileOpContent)localObject).c = false;
      ((OnlineFileSessionWorker.RecvOnlineFileOpContent)localObject).d = false;
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfile session[");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("]  internalRecvOnlineFileOver.recv success!!");
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfile session[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]  internalRecvOnlineFileOver.recv failed!!");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  void d()
  {
    b();
    c();
  }
  
  boolean e()
  {
    FileManagerEntity localFileManagerEntity = this.c;
    if (localFileManagerEntity == null) {
      return false;
    }
    if (localFileManagerEntity.nOlSenderProgress != 0) {
      return true;
    }
    return this.c.fOlRecvSpeed > 1.0E-007F;
  }
  
  boolean f()
  {
    FileManagerEntity localFileManagerEntity = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFileManagerEntity != null)
    {
      bool1 = bool2;
      if (-1 != localFileManagerEntity.nOlSenderProgress) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean g()
  {
    return this.i.c;
  }
  
  public boolean h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" user recv online file....!!");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    boolean bool = this.i.d();
    this.i = this.i.c();
    return bool;
  }
  
  public void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderCancelUpload");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    d();
    this.i.e();
    this.i = this.i.c();
  }
  
  public void j()
  {
    this.i.f();
    this.i = this.i.c();
  }
  
  public void k()
  {
    this.i.b();
    this.i = this.i.c();
  }
  
  public void l()
  {
    this.i.i();
    this.i = this.i.c();
  }
  
  public void m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" stopWaitSenderReplayOnRecvTimer. stopWaitAskUpProgressResultTimer. when onSenderReplayComeOnRecv");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    b();
    c();
    this.i.g();
    this.i = this.i.c();
  }
  
  public void n()
  {
    this.i.h();
    this.i = this.i.c();
  }
  
  public void o()
  {
    if (this.c == null) {
      return;
    }
    long l1 = MessageCache.c();
    if ((this.c.getCloudType() == 0) && (l1 - this.c.srvTime > 172800L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] state :");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" is too long session and invaild!!!! invaild time=");
      localStringBuilder.append(172800L);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      this.i.j();
      this.i = this.i.c();
    }
  }
  
  public void p()
  {
    this.i.k();
    this.i = this.i.c();
  }
  
  public void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.c.nSessionId);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(this.i.a());
    localStringBuilder.append(" stopWaitAskUpProgressResultTimer. when onAskUpProgressAndSessionInvaid");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    c();
    this.i.l();
    this.i = this.i.c();
  }
  
  public void r()
  {
    if ((this.i != null) && (this.c != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.c.nSessionId);
      localStringBuilder.append("]  state:");
      localStringBuilder.append(this.i.a());
      localStringBuilder.append(" stop worker...");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      d();
      this.i.m();
      this.c = null;
      this.b = 0L;
      this.i = this.i.c();
    }
  }
  
  void s()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if ((5 == ((FileManagerEntity)localObject).status) || (6 == this.c.status) || (7 == this.c.status))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OLfilesession[");
        ((StringBuilder)localObject).append(this.c.nSessionId);
        ((StringBuilder)localObject).append("]  state:");
        ((StringBuilder)localObject).append(this.i.a());
        ((StringBuilder)localObject).append(" checkAndDeleteRecordFromFM mEntity.nOpType = ");
        ((StringBuilder)localObject).append(this.c.nOpType);
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        this.c.bDelInFM = true;
        this.a.getFileManagerProxy().a(this.c, false);
        this.a.getFileManagerNotifyCenter().a(true, 3, null);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[]  state:");
      ((StringBuilder)localObject).append(this.i.a());
      ((StringBuilder)localObject).append(" checkAndDeleteRecordFromFM. mEntity = null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  boolean t()
  {
    if (this.h.e) {
      return (this.h.c) && (this.h.d);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker
 * JD-Core Version:    0.7.0.1
 */
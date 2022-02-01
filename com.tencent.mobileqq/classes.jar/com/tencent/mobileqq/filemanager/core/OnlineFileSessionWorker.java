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
  long jdField_a_of_type_Long;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  OnlineFileSessionWorker.RecvOnlineFileOpContent jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent = new OnlineFileSessionWorker.RecvOnlineFileOpContent(this);
  private OnlineFileSessionWorker.StateBase jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Timer jdField_b_of_type_JavaUtilTimer = null;
  long c = 0L;
  long d = 0L;
  long e = 0L;
  
  public OnlineFileSessionWorker(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateBase(this);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] setCurStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "-> StateEnd)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateEnd(this);
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " curstate of entity change: (opType:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + ") -> (opType:" + paramInt1 + "  status:" + paramInt2 + ") savedb=" + paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt2;
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when GOTO_UPLOAD:" + paramInt);
      return false;
    case 9: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateCancelUploadWhenRecv)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateCancelUploadWhenRecv(this);
      return true;
    case 10: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateChangeToOffFailedWhenRecv)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateChangeToOffFailedWhenRecv(this);
      return true;
    case 11: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateLocalFailedWhenRecv)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateLocalFailedWhenRecv(this);
      return true;
    case 12: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateExcepInvalidWhenRecv)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateExcepInvalidWhenRecv(this);
      return true;
    case 14: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateUploadingWhenRecv)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateUploadingWhenRecv(this);
      return true;
    case 15: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateWaitResultWhenRecv)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateWaitResultWhenRecv(this);
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when GOTO_UPLOAD:" + paramInt);
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] error optype:" + paramInt1);
    }
    for (;;)
    {
      if (!bool)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] goto next state failed. state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "-> StateEnd)");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateEnd(this);
      }
      return bool;
      bool = a(paramInt2);
      continue;
      bool = b(paramInt2);
      continue;
      bool = c(paramInt2);
      continue;
      bool = d(paramInt2);
      continue;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateGotoOffFileProcess)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateGotoOffFileProcess(this);
      bool = true;
      continue;
      bool = e(paramInt2);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] setStateToDatabase can not find entity . state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "-> StateEnd)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateEnd(this);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] current status(opType:" + localFileManagerEntity.nOpType + " status:" + localFileManagerEntity.status + "). saveto db(opType:" + paramInt1 + "  status:" + paramInt2 + ")");
    if (-2 != paramInt1) {
      localFileManagerEntity.nOpType = paramInt1;
    }
    if (-2 != paramInt2) {
      localFileManagerEntity.status = paramInt2;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when STOP_UPLOAD:" + paramInt);
      return false;
    case 9: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateCancelUploadWhenPause)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateCancelUploadWhenPause(this);
      return true;
    case 10: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateChangeToOffFailedWhenPause)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateChangeToOffFailedWhenPause(this);
      return true;
    case 11: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateLocalFailedWhenPause)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateLocalFailedWhenPause(this);
      return true;
    case 12: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateExcepInvalidWhenPause)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateExcepInvalidWhenPause(this);
      return true;
    case 14: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateUploadingWhenPause)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateUploadingWhenPause(this);
      return true;
    case 15: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateWaitResultWhenPause)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateWaitResultWhenPause(this);
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when STOP_UPLOAD:" + paramInt);
    return false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt2;
    }
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when BE_PC_HANDLED:" + paramInt);
      return false;
    case 5: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateAcceptByPC)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateAcceptByPC(this);
      return true;
    case 6: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateRefuseByPC)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateRefuseByPC(this);
      return true;
    case 7: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateSaveToWeiYunByPC)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateSaveToWeiYunByPC(this);
      return true;
    case 8: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateSenderCancelSend)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateSenderCancelSend(this);
      return true;
    case 9: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateCancelUploadWhenChangeToOff)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateCancelUploadWhenChangeToOff(this);
      return true;
    case 12: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateExcepInvalidWhenChangeToOff)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateExcepInvalidWhenChangeToOff(this);
      return true;
    case 13: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateUploadoneWhenChangeToOff)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateUploadoneWhenChangeToOff(this);
      return true;
    case 14: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateUploadingWhenChangeToOff)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateUploadingWhenChangeToOff(this);
      return true;
    case 11: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateLocalFailedWhenChangeToOff)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateLocalFailedWhenChangeToOff(this);
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when BE_PC_HANDLED:" + paramInt);
    return false;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] setDBStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "-> StateEnd)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateEnd(this);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " curstate: (opType:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + ").  save state:(opType:" + paramInt1 + "  status:" + paramInt2 + ") to DB");
    localFileManagerEntity.nOpType = paramInt1;
    localFileManagerEntity.status = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
  }
  
  private boolean d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when TYPE_UNKNOW:" + paramInt);
      return false;
    case 4: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateRequest)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateRequest(this);
      return true;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when TYPE_UNKNOW:" + paramInt);
    return false;
  }
  
  private boolean e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when BE_PC_HANDLED_ON_RECV2OFF_FAILED:" + paramInt);
      return false;
    case 5: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateAcceptByPCWhenToOffFailed)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateAcceptByPCWhenToOffFailed(this);
      return true;
    case 6: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateRefuseByPCWhenToOffFailed)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateRefuseByPCWhenToOffFailed(this);
      return true;
    case 7: 
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateSaveToWeiYunByPCWhenToOffFailed(this);
      return true;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "->StateSenderCancelSendWhenToOffFailed)");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateSenderCancelSendWhenToOffFailed(this);
    return true;
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (0L != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state :" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " initForMakeProgress. but had init. lastTime =" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = System.currentTimeMillis();
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state :" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " initForMakeProgress lastTime =" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
    }
  }
  
  void a()
  {
    long l = 30000L;
    if (FileManagerUtil.a()) {
      l = 50000L;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " failure to startWaitSenderReplayOnRecvTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " startWaitSenderReplayOnRecvTimer. outTimerInterval=" + l);
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new OnlineFileSessionWorker.1(this), l);
      return;
    }
  }
  
  void a(float paramFloat)
  {
    ThreadManager.post(new OnlineFileSessionWorker.3(this, paramFloat), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
    o();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitAskUpProgressResultTimer. stopWaitSenderReplayOnRecvTimer. when onSenderUploadProgressNotify");
    c();
    b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  void a(long paramLong)
  {
    long l = paramLong;
    if (0L == paramLong)
    {
      l = 30000L;
      if (FileManagerUtil.a()) {
        l = 50000L;
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilTimer != null)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " failure to startWaitAskUpProgressResultTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " startWaitAskUpProgressResultTimer. outTimerInterval=" + l);
      this.jdField_b_of_type_JavaUtilTimer = new Timer();
      this.jdField_b_of_type_JavaUtilTimer.schedule(new OnlineFileSessionWorker.2(this), l);
      return;
    }
  }
  
  void a(long paramLong, String paramString)
  {
    int i;
    Object localObject;
    if ((paramLong != 0L) && (paramLong != this.e))
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, 0);
      if ((localList == null) || (localList.isEmpty())) {
        break label235;
      }
      i = localList.size() - 1;
      if (i < 0) {
        break label235;
      }
      localObject = (MessageRecord)localList.get(i);
      if (MessageRecordInfo.b(((MessageRecord)localObject).issend)) {
        break label214;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (!((MessageRecord)localObject).isread) {
          break label229;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] sendMsgReadedReport curFriendUin is " + paramString + ", shmsgseq  is " + paramLong);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(new Pair(Long.valueOf(paramString), Long.valueOf(paramLong)));
          ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a("c2c_processor")).a((ArrayList)localObject);
          this.e = paramLong;
        }
        return;
        label214:
        i -= 1;
        break;
        i = 1;
        continue;
        label229:
        i = 0;
      }
      label235:
      localObject = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    OnlineFileSessionWorker.RecvOnlineFileOpContent localRecvOnlineFileOpContent;
    if (paramBoolean)
    {
      localRecvOnlineFileOpContent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent;
      localRecvOnlineFileOpContent.jdField_a_of_type_Int += 1;
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
      return;
      localRecvOnlineFileOpContent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent;
      localRecvOnlineFileOpContent.jdField_b_of_type_Int += 1;
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress != 0) {
        return true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed <= 1.0E-007F);
    return true;
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderUploadCompleted");
    d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a(paramInt, paramString, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
    return bool;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] init failed. state change :(" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + "-> StateEnd)");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateEnd(this);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] init state to:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a());
    return bool;
  }
  
  boolean a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " internalRecvOnlineFile. recv is going on, why?? ");
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramString, paramLong);
    if (!bool)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " internalRecvOnlineFile. recv cmd send failed.... ");
      paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent;
      paramString.jdField_b_of_type_Int += 1;
    }
    do
    {
      return bool;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " internalRecvOnlineFile. recv cmd send success, and will ask progress .... ");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c = true;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_b_of_type_Boolean = false;
    } while (a(true, 0L));
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " internalRecvOnlineFile. ask progress failed.... ");
    c(2);
    return bool;
  }
  
  boolean a(boolean paramBoolean, long paramLong)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_JavaUtilTimer == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]. askUpProgress entity is null");
        paramBoolean = bool;
      }
      do
      {
        do
        {
          return paramBoolean;
          if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress == 0)) {}
          paramBoolean = bool;
        } while (1 == 0);
        bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId);
        this.jdField_b_of_type_Long += 1L;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " ask upload progress isSuccess = " + bool + ". askUpProgressCount=" + this.jdField_b_of_type_Long);
        paramBoolean = bool;
      } while (!bool);
      a(paramLong);
      return bool;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]. askUpProgress is going on. return");
    return false;
  }
  
  void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitSenderReplayOnRecvTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitSenderReplayOnRecvTimer.but timer had stop");
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onNetworkChanged");
    d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.b(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitAskUpProgressResultTimer. when onAskSenderUpProgressResult = false");
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      bool1 = bool2;
      if (-1 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  void c()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilTimer != null)
      {
        this.jdField_b_of_type_JavaUtilTimer.cancel();
        this.jdField_b_of_type_JavaUtilTimer = null;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitAskUpProgressResultTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitAskUpProgressResultTimer.but timer had stop");
    }
  }
  
  void c(int paramInt)
  {
    if (1 == paramInt) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " recv olfile is going on. but the resp of sender is error");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_a_of_type_Boolean = true;
      }
    }
    while ((2 != paramInt) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c)) {
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " recv olfile is going on. but the resp of ask progress is error");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_b_of_type_Boolean = true;
  }
  
  void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_b_of_type_Boolean = false;
      if (paramBoolean) {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Long + "]  internalRecvOnlineFileOver.recv success!!");
      }
    }
    else
    {
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfile session[" + this.jdField_a_of_type_Long + "]  internalRecvOnlineFileOver.recv failed!!");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.jdField_a_of_type_Boolean;
  }
  
  void d()
  {
    b();
    c();
  }
  
  public boolean d()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " user recv online file....!!");
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
    return bool;
  }
  
  public void e()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderCancelUpload");
    d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  boolean e()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.c) || ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$RecvOnlineFileOpContent.jdField_b_of_type_Boolean));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void i()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitSenderReplayOnRecvTimer. stopWaitAskUpProgressResultTimer. when onSenderReplayComeOnRecv");
    b();
    c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.e();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    long l;
    do
    {
      return;
      l = MessageCache.a();
    } while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 0) || (l - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime <= 172800L));
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state :" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " is too long session and invaild!!!! invaild time=" + 172800L);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.h();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void m()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stopWaitAskUpProgressResultTimer. when onAskUpProgressAndSessionInvaid");
    c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.i();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " stop worker...");
      d();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.j();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a();
    }
  }
  
  void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if ((5 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status) || (6 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status) || (7 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status))
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " checkAndDeleteRecordFromFM mEntity.nOpType = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
      }
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[]  state:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a() + " checkAndDeleteRecordFromFM. mEntity = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker
 * JD-Core Version:    0.7.0.1
 */
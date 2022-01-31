package com.tencent.mobileqq.filemanager.core;

import acnj;
import acnk;
import acnl;
import acnm;
import acno;
import acnp;
import acnq;
import acnr;
import acns;
import acnt;
import acnu;
import acnx;
import acny;
import acnz;
import acoa;
import acob;
import acoc;
import acod;
import acoe;
import acof;
import acoh;
import acoi;
import acoj;
import acol;
import acom;
import acoo;
import acop;
import acoq;
import acor;
import acos;
import acou;
import acov;
import acow;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class OnlineFileSessionWorker
{
  public long a;
  private acnp jdField_a_of_type_Acnp;
  public acow a;
  public QQAppInterface a;
  public FileManagerEntity a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Timer jdField_b_of_type_JavaUtilTimer;
  public long c = 0L;
  public long d = 0L;
  long e = 0L;
  
  public OnlineFileSessionWorker(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_Acow = new acow(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Acnp = new acnp(this);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] setCurStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_Acnp.a() + "-> StateEnd)");
      this.jdField_a_of_type_Acnp = new acnx(this);
    }
    do
    {
      return;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state:" + this.jdField_a_of_type_Acnp.a() + " curstate of entity change: (opType:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + ") -> (opType:" + paramInt1 + "  status:" + paramInt2 + ") savedb=" + paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt2;
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] error optype:" + paramInt1);
    }
    for (;;)
    {
      if (!bool)
      {
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] goto next state failed. state change :(" + this.jdField_a_of_type_Acnp.a() + "-> StateEnd)");
        this.jdField_a_of_type_Acnp = new acnx(this);
      }
      return bool;
      switch (paramInt2)
      {
      default: 
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when GOTO_UPLOAD:" + paramInt2);
        break;
      case 9: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateCancelUploadWhenRecv)");
        this.jdField_a_of_type_Acnp = new acns(this);
        bool = true;
        break;
      case 10: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateChangeToOffFailedWhenRecv)");
        this.jdField_a_of_type_Acnp = new acnu(this);
        bool = true;
        break;
      case 11: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateLocalFailedWhenRecv)");
        this.jdField_a_of_type_Acnp = new acoe(this);
        bool = true;
        break;
      case 12: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateExcepInvalidWhenRecv)");
        this.jdField_a_of_type_Acnp = new acoa(this);
        bool = true;
        break;
      case 14: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateUploadingWhenRecv)");
        this.jdField_a_of_type_Acnp = new acor(this);
        bool = true;
        break;
      case 15: 
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateWaitResultWhenRecv)");
        this.jdField_a_of_type_Acnp = new acov(this);
        bool = true;
        break;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 13: 
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when GOTO_UPLOAD:" + paramInt2);
        continue;
        switch (paramInt2)
        {
        default: 
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when STOP_UPLOAD:" + paramInt2);
          break;
        case 9: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateCancelUploadWhenPause)");
          this.jdField_a_of_type_Acnp = new acnr(this);
          bool = true;
          break;
        case 10: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateChangeToOffFailedWhenPause)");
          this.jdField_a_of_type_Acnp = new acnt(this);
          bool = true;
          break;
        case 11: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateLocalFailedWhenPause)");
          this.jdField_a_of_type_Acnp = new acod(this);
          bool = true;
          break;
        case 12: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateExcepInvalidWhenPause)");
          this.jdField_a_of_type_Acnp = new acnz(this);
          bool = true;
          break;
        case 14: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateUploadingWhenPause)");
          this.jdField_a_of_type_Acnp = new acoq(this);
          bool = true;
          break;
        case 15: 
          QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateWaitResultWhenPause)");
          this.jdField_a_of_type_Acnp = new acou(this);
          bool = true;
          break;
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 13: 
          QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when STOP_UPLOAD:" + paramInt2);
          continue;
          switch (paramInt2)
          {
          default: 
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when BE_PC_HANDLED:" + paramInt2);
            break;
          case 5: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateAcceptByPC)");
            this.jdField_a_of_type_Acnp = new acnm(this);
            bool = true;
            break;
          case 6: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateRefuseByPC)");
            this.jdField_a_of_type_Acnp = new acof(this);
            bool = true;
            break;
          case 7: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateSaveToWeiYunByPC)");
            this.jdField_a_of_type_Acnp = new acoj(this);
            bool = true;
            break;
          case 8: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateSenderCancelSend)");
            this.jdField_a_of_type_Acnp = new acom(this);
            bool = true;
            break;
          case 9: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateCancelUploadWhenChangeToOff)");
            this.jdField_a_of_type_Acnp = new acnq(this);
            bool = true;
            break;
          case 12: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateExcepInvalidWhenChangeToOff)");
            this.jdField_a_of_type_Acnp = new acny(this);
            bool = true;
            break;
          case 13: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateUploadoneWhenChangeToOff)");
            this.jdField_a_of_type_Acnp = new acos(this);
            bool = true;
            break;
          case 14: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateUploadingWhenChangeToOff)");
            this.jdField_a_of_type_Acnp = new acop(this);
            bool = true;
            break;
          case 11: 
            QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateLocalFailedWhenChangeToOff)");
            this.jdField_a_of_type_Acnp = new acoc(this);
            bool = true;
            break;
          case 4: 
          case 10: 
          case 15: 
            QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when BE_PC_HANDLED:" + paramInt2);
            continue;
            switch (paramInt2)
            {
            default: 
              QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] no status. when TYPE_UNKNOW:" + paramInt2);
              break;
            case 4: 
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateRequest)");
              this.jdField_a_of_type_Acnp = new acoi(this);
              bool = true;
              break;
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
              QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when TYPE_UNKNOW:" + paramInt2);
              continue;
              QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateGotoOffFileProcess)");
              this.jdField_a_of_type_Acnp = new acob(this);
              bool = true;
              continue;
              switch (paramInt2)
              {
              default: 
                QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] can not set the status. when BE_PC_HANDLED_ON_RECV2OFF_FAILED:" + paramInt2);
                break;
              case 5: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateAcceptByPCWhenToOffFailed)");
                this.jdField_a_of_type_Acnp = new acno(this);
                bool = true;
                break;
              case 6: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateRefuseByPCWhenToOffFailed)");
                this.jdField_a_of_type_Acnp = new acoh(this);
                bool = true;
                break;
              case 7: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateSaveToWeiYunByPCWhenToOffFailed)");
                this.jdField_a_of_type_Acnp = new acol(this);
                bool = true;
                break;
              case 8: 
                QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Acnp.a() + "->StateSenderCancelSendWhenToOffFailed)");
                this.jdField_a_of_type_Acnp = new acoo(this);
                bool = true;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] setStateToDatabase can not find entity . state change :(" + this.jdField_a_of_type_Acnp.a() + "-> StateEnd)");
      this.jdField_a_of_type_Acnp = new acnx(this);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt2;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] setDBStateOfEntityTo can not find entity . state change :(" + this.jdField_a_of_type_Acnp.a() + "-> StateEnd)");
      this.jdField_a_of_type_Acnp = new acnx(this);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state:" + this.jdField_a_of_type_Acnp.a() + " curstate: (opType:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + ").  save state:(opType:" + paramInt1 + "  status:" + paramInt2 + ") to DB");
    localFileManagerEntity.nOpType = paramInt1;
    localFileManagerEntity.status = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (0L != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state :" + this.jdField_a_of_type_Acnp.a() + " initForMakeProgress. but had init. lastTime =" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = System.currentTimeMillis();
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state :" + this.jdField_a_of_type_Acnp.a() + " initForMakeProgress lastTime =" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
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
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_Acnp.a() + " failure to startWaitSenderReplayOnRecvTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_Acnp.a() + " startWaitSenderReplayOnRecvTimer. outTimerInterval=" + l);
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new acnj(this), l);
      return;
    }
  }
  
  public void a(float paramFloat)
  {
    ThreadManager.post(new acnl(this, paramFloat), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Acnp.a(paramInt);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
    o();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitAskUpProgressResultTimer. stopWaitSenderReplayOnRecvTimer. when onSenderUploadProgressNotify");
    c();
    b();
    this.jdField_a_of_type_Acnp.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Acnp.a(paramInt, paramString);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
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
        QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_Acnp.a() + " failure to startWaitAskUpProgressResultTimer ant it is runing");
        return;
      }
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_Acnp.a() + " startWaitAskUpProgressResultTimer. outTimerInterval=" + l);
      this.jdField_b_of_type_JavaUtilTimer = new Timer();
      this.jdField_b_of_type_JavaUtilTimer.schedule(new acnk(this), l);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    int i;
    Object localObject;
    if ((paramLong != 0L) && (paramLong != this.e))
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, 0);
      if ((localList == null) || (localList.isEmpty())) {
        break label235;
      }
      i = localList.size() - 1;
      if (i < 0) {
        break label235;
      }
      localObject = (MessageRecord)localList.get(i);
      if (MsgUtils.b(((MessageRecord)localObject).issend)) {
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
          ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("c2c_processor")).b((ArrayList)localObject);
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
    acow localacow;
    if (paramBoolean)
    {
      localacow = this.jdField_a_of_type_Acow;
      localacow.jdField_a_of_type_Int += 1;
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Acnp.a(paramBoolean);
      this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
      return;
      localacow = this.jdField_a_of_type_Acow;
      localacow.jdField_b_of_type_Int += 1;
    }
  }
  
  public boolean a()
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
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderUploadCompleted");
    d();
    boolean bool = this.jdField_a_of_type_Acnp.a(paramInt, paramString, paramLong);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
    return bool;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] init failed. state change :(" + this.jdField_a_of_type_Acnp.a() + "-> StateEnd)");
      this.jdField_a_of_type_Acnp = new acnx(this);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] init state to:" + this.jdField_a_of_type_Acnp.a());
    return bool;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Acow.c) {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_Acnp.a() + " internalRecvOnlineFile. recv is going on, why?? ");
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramLong);
    if (!bool)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_Acnp.a() + " internalRecvOnlineFile. recv cmd send failed.... ");
      paramString = this.jdField_a_of_type_Acow;
      paramString.jdField_b_of_type_Int += 1;
    }
    do
    {
      return bool;
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_Acnp.a() + " internalRecvOnlineFile. recv cmd send success, and will ask progress .... ");
      this.jdField_a_of_type_Acow.c = true;
      this.jdField_a_of_type_Acow.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Acow.jdField_b_of_type_Boolean = false;
    } while (a(true, 0L));
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_Acnp.a() + " internalRecvOnlineFile. ask progress failed.... ");
    c(2);
    return bool;
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
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
        bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId);
        this.jdField_b_of_type_Long += 1L;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + this.jdField_a_of_type_Acnp.a() + " ask upload progress isSuccess = " + bool + ". askUpProgressCount=" + this.jdField_b_of_type_Long);
        paramBoolean = bool;
      } while (!bool);
      a(paramLong);
      return bool;
    }
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]. askUpProgress is going on. return");
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitSenderReplayOnRecvTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitSenderReplayOnRecvTimer.but timer had stop");
    }
  }
  
  public void b(int paramInt)
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onNetworkChanged");
    d();
    this.jdField_a_of_type_Acnp.b(1);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Acnp.a(paramLong);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitAskUpProgressResultTimer. when onAskSenderUpProgressResult = false");
      c();
    }
    this.jdField_a_of_type_Acnp.b(paramBoolean);
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public boolean b()
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
  
  public void c()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilTimer != null)
      {
        this.jdField_b_of_type_JavaUtilTimer.cancel();
        this.jdField_b_of_type_JavaUtilTimer = null;
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitAskUpProgressResultTimer");
        return;
      }
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitAskUpProgressResultTimer.but timer had stop");
    }
  }
  
  public void c(int paramInt)
  {
    if (1 == paramInt) {
      if (this.jdField_a_of_type_Acow.c)
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_Acnp.a() + " recv olfile is going on. but the resp of sender is error");
        this.jdField_a_of_type_Acow.jdField_a_of_type_Boolean = true;
      }
    }
    while ((2 != paramInt) || (!this.jdField_a_of_type_Acow.c)) {
      return;
    }
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "]  state:" + this.jdField_a_of_type_Acnp.a() + " recv olfile is going on. but the resp of ask progress is error");
    this.jdField_a_of_type_Acow.jdField_b_of_type_Boolean = true;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Acow.c)
    {
      this.jdField_a_of_type_Acow.c = false;
      this.jdField_a_of_type_Acow.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Acow.jdField_b_of_type_Boolean = false;
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
    return this.jdField_a_of_type_Acnp.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    b();
    c();
  }
  
  public boolean d()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " user recv online file....!!");
    boolean bool = this.jdField_a_of_type_Acnp.a();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
    return bool;
  }
  
  public void e()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitSenderReplayOnRecvTimer ant stopWaitAskUpProgressResultTimer. when onSenderCancelUpload");
    d();
    this.jdField_a_of_type_Acnp.b();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public boolean e()
  {
    return (!this.jdField_a_of_type_Acow.c) || ((this.jdField_a_of_type_Acow.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acow.jdField_b_of_type_Boolean));
  }
  
  public void f()
  {
    this.jdField_a_of_type_Acnp.c();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Acnp.a();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Acnp.f();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void i()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitSenderReplayOnRecvTimer. stopWaitAskUpProgressResultTimer. when onSenderReplayComeOnRecv");
    b();
    c();
    this.jdField_a_of_type_Acnp.d();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void j()
  {
    this.jdField_a_of_type_Acnp.e();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
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
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] state :" + this.jdField_a_of_type_Acnp.a() + " is too long session and invaild!!!! invaild time=" + 172800L);
    this.jdField_a_of_type_Acnp.g();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Acnp.h();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void m()
  {
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stopWaitAskUpProgressResultTimer. when onAskUpProgressAndSessionInvaid");
    c();
    this.jdField_a_of_type_Acnp.i();
    this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Acnp != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
    {
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " stop worker...");
      d();
      this.jdField_a_of_type_Acnp.j();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Acnp = this.jdField_a_of_type_Acnp.a();
    }
  }
  
  void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if ((5 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status) || (6 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status) || (7 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status))
      {
        QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]  state:" + this.jdField_a_of_type_Acnp.a() + " checkAndDeleteRecordFromFM mEntity.nOpType = " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      }
      return;
    }
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[]  state:" + this.jdField_a_of_type_Acnp.a() + " checkAndDeleteRecordFromFM. mEntity = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker
 * JD-Core Version:    0.7.0.1
 */
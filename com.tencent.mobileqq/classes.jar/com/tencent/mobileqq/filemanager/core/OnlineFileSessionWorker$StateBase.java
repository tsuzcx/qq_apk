package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateBase
{
  protected StateBase b = this;
  protected boolean c = false;
  protected boolean d = false;
  
  OnlineFileSessionWorker$StateBase(OnlineFileSessionWorker paramOnlineFileSessionWorker) {}
  
  protected String a()
  {
    return "StateBase";
  }
  
  protected void a(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("unknow:");
              ((StringBuilder)localObject).append(String.valueOf(paramInt));
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = "(pc change to off trans)";
            }
          }
          else {
            localObject = "(pc save to weiyun)";
          }
        }
        else {
          localObject = "(pc cancel send";
        }
      }
      else {
        localObject = "(pc refuse)";
      }
    }
    else {
      localObject = "(pc accept)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("] state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onFileRequestBeHandledByPC.handleType = ");
    localStringBuilder.append((String)localObject);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onSenderUploadProgressNotify. speed:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" progress:");
    localStringBuilder.append(paramInt2);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onSenderUploadException. errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" resason:");
    localStringBuilder.append(paramString);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(long paramLong) {}
  
  protected final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->");
    localStringBuilder.append(paramString);
    localStringBuilder.append(")");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onRecvOnLineFileResult. ret:");
    localStringBuilder.append(paramBoolean);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (this.e.c == null)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.e.b);
      paramString.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      return false;
    }
    this.e.c.Uuid = new String(paramString);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.e.b);
    paramString.append("]  state:");
    paramString.append(OnlineFileSessionWorker.a(this.e).a());
    paramString.append(" can not handle onSenderUploadCompleted. type:");
    paramString.append(paramInt);
    paramString.append("time:");
    paramString.append(paramLong);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    return false;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onResumeTrans. ");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onFailedOfLocalSomeThingHappen. type:");
    localStringBuilder.append(paramInt);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected final void b(int paramInt1, int paramInt2)
  {
    if (this.e.c == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.b);
      ((StringBuilder)localObject).append("] make progress entity = null.handleProgressNotify");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramInt2 > 100)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.b);
      ((StringBuilder)localObject).append("] handleProgressNotify progress > 100. progress=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramInt1 == 0) {}
    while ((paramInt2 <= this.e.c.nOlSenderProgress) && ((this.e.c.nOlSenderProgress != 0) || (this.e.c.fOlRecvSpeed > 1.0E-007F)))
    {
      i = 1;
      break;
    }
    int i = 0;
    long l = System.currentTimeMillis();
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.b);
      ((StringBuilder)localObject).append("]  handleProgressNotify. state:");
      ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.e).a());
      ((StringBuilder)localObject).append(". averspeed = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(". progress = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(". nOlSenderProgress =");
      ((StringBuilder)localObject).append(this.e.c.nOlSenderProgress);
      ((StringBuilder)localObject).append(". err notify. return");
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      if (-1 == this.e.c.nOlSenderProgress)
      {
        this.e.c.nOlSenderProgress = 0;
        this.e.c.lastTime = l;
        if ((this.e.c.status != 14) && (this.e.c.status != 15))
        {
          this.e.a.getFileManagerDataCenter().c(this.e.c);
          return;
        }
        localObject = this.e.c.clone();
        ((FileManagerEntity)localObject).status = 11;
        this.e.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
      }
      return;
    }
    this.d = false;
    b(l);
    float f1 = (100 - paramInt2) / 100.0F / (paramInt1 * 1024 / (float)this.e.c.fileSize);
    float f2 = this.e.c.fProgress;
    this.e.c.fOlRecvSpeed = ((0.9F - f2) / f1);
    this.e.c.lastTime = l;
    this.e.c.nOlSenderProgress = paramInt2;
    this.e.c.fOlRecvProgressOnNotify = this.e.c.fProgress;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.e.b);
    ((StringBuilder)localObject).append("]  -----handleProgressNotify. state:");
    ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.e).a());
    ((StringBuilder)localObject).append(". averspeed = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(". progress = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(". fOlRecvSpeed = ");
    ((StringBuilder)localObject).append(this.e.c.fOlRecvSpeed);
    ((StringBuilder)localObject).append("f/s. fOlRecvProgressOnNotify =");
    ((StringBuilder)localObject).append(this.e.c.fOlRecvProgressOnNotify);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((this.e.c.status != 14) && (this.e.c.status != 15))
    {
      this.e.a.getFileManagerDataCenter().c(this.e.c);
      return;
    }
    localObject = this.e.c.clone();
    ((FileManagerEntity)localObject).status = 11;
    this.e.a.getFileManagerDataCenter().c((FileManagerEntity)localObject);
  }
  
  protected final void b(long paramLong)
  {
    Object localObject;
    if (this.e.c == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.b);
      ((StringBuilder)localObject).append("] make progress entity = null.makeProgress");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.d) {
      return;
    }
    if (!this.e.f()) {
      return;
    }
    long l1;
    if (0L == this.e.f)
    {
      localObject = this.e;
      ((OnlineFileSessionWorker)localObject).f = 102400L;
      l1 = ((OnlineFileSessionWorker)localObject).c.fileSize;
      long l2 = ((float)this.e.c.fileSize * 0.1F);
      if (l1 > 104857600L)
      {
        localObject = this.e;
        ((OnlineFileSessionWorker)localObject).f = (l2 / 60L);
        if (l1 > 524288000L)
        {
          ((OnlineFileSessionWorker)localObject).f = (l2 / 120L);
          if (l1 > 1073741824L) {
            ((OnlineFileSessionWorker)localObject).f = (l2 / 180L);
          }
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.c.nSessionId);
      ((StringBuilder)localObject).append("] initGoSpeed =");
      ((StringBuilder)localObject).append(this.e.f);
      ((StringBuilder)localObject).append("b/s");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    float f1 = this.e.c.fOlRecvSpeed;
    if (!this.e.e())
    {
      double d1 = this.e.c.fileSize;
      double d2 = this.e.c.fOlRecvProgressOnNotify;
      Double.isNaN(d2);
      Double.isNaN(d1);
      l1 = (d1 * (1.0D - d2) / 102400.0D * 2000.0D);
      f1 = (float)this.e.f / (float)this.e.c.fileSize;
    }
    else
    {
      l1 = ((0.9F - this.e.c.fOlRecvProgressOnNotify) * 2000.0F / f1);
    }
    if (l1 <= 30000L) {
      l1 = 30000L;
    }
    if (paramLong - this.e.c.lastTime > l1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.c.nSessionId);
      ((StringBuilder)localObject).append("] state:");
      ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.e).a());
      ((StringBuilder)localObject).append(" the progress maker think time out. timeOutInterval=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("curRecvSpeed = ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(".lastTime =");
      ((StringBuilder)localObject).append(this.e.c.lastTime);
      ((StringBuilder)localObject).append(". makeTime =");
      ((StringBuilder)localObject).append(paramLong);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      if (!this.e.e())
      {
        this.e.a(true, 0L);
        this.d = true;
        return;
      }
      this.e.a(true, 0L);
      this.d = true;
      return;
    }
    float f2 = (float)(paramLong - this.e.c.lastTime) / 1000.0F;
    float f3 = f1 * f2;
    float f4 = this.e.c.fOlRecvProgressOnNotify + f3;
    if (!this.e.e())
    {
      if (this.e.c.fProgress <= 0.1F)
      {
        if (Math.abs(this.e.c.fProgress - 0.1F) < 1.0E-008D) {
          return;
        }
        if (f4 > 0.1F) {
          this.e.c.fProgress = 0.1F;
        } else {
          this.e.c.fProgress = f4;
        }
      }
    }
    else
    {
      if (this.e.c.fProgress > 0.9F) {
        return;
      }
      if (Math.abs(this.e.c.fProgress - 0.9F) < 1.0E-008D) {
        return;
      }
      if (f4 > 0.9F) {
        this.e.c.fProgress = 0.9F;
      } else {
        this.e.c.fProgress = f4;
      }
    }
    if (paramLong - this.e.e > 50000L)
    {
      this.e.e = paramLong;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.e.c.nSessionId);
      ((StringBuilder)localObject).append("] -----state:");
      ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.e).a());
      ((StringBuilder)localObject).append(" the making progress of upload is: ");
      ((StringBuilder)localObject).append(this.e.c.fProgress);
      ((StringBuilder)localObject).append("[curRecvSpeed=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(".maketime=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(".lastTime=");
      ((StringBuilder)localObject).append(this.e.c.lastTime);
      ((StringBuilder)localObject).append("f/s. makeTime_s=");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append("s. addProgress = ");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(". timeOutInterval=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(". filesize=");
      ((StringBuilder)localObject).append(this.e.c.fileSize);
      ((StringBuilder)localObject).append(". nOlSenderProgress=");
      ((StringBuilder)localObject).append(this.e.c.nOlSenderProgress);
      ((StringBuilder)localObject).append(". fOlRecvProgressOnNotify =");
      ((StringBuilder)localObject).append(this.e.c.fOlRecvProgressOnNotify);
      ((StringBuilder)localObject).append(" ] ");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    this.e.a.getFileManagerNotifyCenter().a(this.e.c.uniseq, this.e.c.nSessionId, this.e.c.peerUin, this.e.c.peerType, 16, null, 0, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.e.b);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(" recv  success response of ask progress");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append(" recv  failed response of ask progress");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.e.c();
    k();
  }
  
  protected final boolean b(String paramString)
  {
    if (this.e.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.e.b);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.b.a());
      localStringBuilder.append(paramString);
      localStringBuilder.append(" entity is null ");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  StateBase c()
  {
    return this.b;
  }
  
  protected boolean d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onRecvOnLineFile.");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    return true;
  }
  
  protected void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onSenderCancelUpload. ");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onPauseTrans. ");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onSenderReplayComeOnRecv:");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle onRecvButSenderReplayTimeOut:");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.e).a());
    localStringBuilder.append(" can not handle doSomeThingOnUploadDone:");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void j() {}
  
  protected void k()
  {
    a(4, null);
  }
  
  protected void l()
  {
    a(3, null);
  }
  
  protected void m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.e.b);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.b.a());
    localStringBuilder.append("->StateEnd)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.b = new OnlineFileSessionWorker.StateEnd(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateBase
 * JD-Core Version:    0.7.0.1
 */
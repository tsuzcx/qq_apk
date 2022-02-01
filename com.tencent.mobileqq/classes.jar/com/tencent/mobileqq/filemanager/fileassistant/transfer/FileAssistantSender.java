package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.WlanRecvNotify;

public class FileAssistantSender
{
  private QQAppInterface a;
  private WeakReference<FileAssistantResultCallbak> b;
  private DataLineObserver c = null;
  private FMObserver d = null;
  private String e = null;
  private FileManagerEntity f = null;
  private WLANSender g = null;
  private Runnable h = null;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  
  public FileAssistantSender(QQAppInterface paramQQAppInterface, FileAssistantResultCallbak paramFileAssistantResultCallbak, FileManagerEntity paramFileManagerEntity)
  {
    this.a = paramQQAppInterface;
    this.b = new WeakReference(paramFileAssistantResultCallbak);
    this.f = paramFileManagerEntity;
    this.f.status = 2;
  }
  
  FileAssistantSender(QQAppInterface paramQQAppInterface, FileAssistantResultCallbak paramFileAssistantResultCallbak, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = new WeakReference(paramFileAssistantResultCallbak);
    this.e = paramString;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == -10112) || (paramInt == -25087) || (paramInt == -98090);
  }
  
  private void b(boolean paramBoolean)
  {
    h();
    this.g = new WLANSender();
    this.g.a(this.a, this.f, paramBoolean);
    this.f.isStartWlan = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWlanSend[");
    localStringBuilder.append(this.f.nSessionId);
    localStringBuilder.append("],filePath:");
    localStringBuilder.append(this.f.getFilePath());
    localStringBuilder.append(",filename:");
    localStringBuilder.append(this.f.fileName);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  private void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOfflineSend[");
    localStringBuilder.append(this.f.nSessionId);
    localStringBuilder.append("] use extf upload. filename:");
    localStringBuilder.append(this.f.fileName);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    g();
    this.k = true;
    this.a.getFileManagerEngine().j().a(this.f);
  }
  
  private Runnable f()
  {
    return new FileAssistantSender.1(this);
  }
  
  private void g()
  {
    if (this.d != null) {
      return;
    }
    this.d = new FileAssistantSender.2(this);
    this.a.getFileManagerNotifyCenter().addObserver(this.d);
  }
  
  private void h()
  {
    if (this.c != null) {
      return;
    }
    this.c = new FileAssistantSender.3(this);
    this.a.addDefaultObservers(this.c);
  }
  
  private void i()
  {
    if (this.j)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "sendWlanNotify failed, isSendWlanNotify:true");
      return;
    }
    this.j = true;
    Object localObject = new SubMsgType0x4.WlanRecvNotify();
    int m = (int)MessageCache.c();
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_time.set(m);
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint64_file_size.set(this.f.fileSize);
    ((SubMsgType0x4.WlanRecvNotify)localObject).str_file_name.set(this.f.fileName);
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_send_client_type.set(QFileAssistantUtils.c());
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_target_client_type.set(QFileAssistantUtils.d());
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint64_session_id.set(this.f.nSessionId);
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_random.set(Math.abs(new Random().nextInt()));
    this.a.getFileTransferHandler().a((SubMsgType0x4.WlanRecvNotify)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendWlanNotify : ");
    ((StringBuilder)localObject).append(this.f.nSessionId);
    QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)localObject).toString());
  }
  
  public FileManagerEntity a(Bundle paramBundle)
  {
    FileInfo localFileInfo = FileInfo.e(this.e);
    if (localFileInfo == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("filePath maybe not exsited:");
      paramBundle.append(this.e);
      QLog.e("FileAssistantSender<FileAssistant>", 1, paramBundle.toString());
      return null;
    }
    this.f = FileManagerUtil.a(localFileInfo);
    String str = ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    Object localObject = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    this.f.nSessionId = ((DataLineHandler)localObject).f();
    this.f.uniseq = FileManagerUtil.a().longValue();
    this.f.msgSeq = FileManagerUtil.f();
    localObject = this.f;
    ((FileManagerEntity)localObject).peerUin = str;
    ((FileManagerEntity)localObject).cloudType = 3;
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).bDelInFM = true;
    ((FileManagerEntity)localObject).bSend = true;
    ((FileManagerEntity)localObject).nOpType = 51;
    if (paramBundle != null)
    {
      long l1 = paramBundle.getLong("forward_origin_uni_seq", -1L);
      int m = paramBundle.getInt("forward_id", -1);
      ForwardOrderManager.a().a(this.f.uniseq, l1, m);
    }
    ThreadManager.getFileThreadHandler().post(new FileAssistantSender.4(this, str, localFileInfo));
    return this.f;
  }
  
  public void a()
  {
    if (this.h != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "remove offlineSenderStartTimer");
      ThreadManager.getUIHandler().removeCallbacks(this.h);
    }
    if (this.g != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel mWlanSender");
      this.g.a();
    }
    if (this.a.getFileManagerEngine().j().a(this.f.nSessionId)) {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel offlineSender");
    }
    Object localObject = this.f;
    if ((localObject != null) && (((FileManagerEntity)localObject).status != 1))
    {
      this.f.status = 3;
      this.a.getFileManagerDataCenter().c(this.f);
    }
    this.k = false;
    this.l = false;
    this.a.getFileManagerNotifyCenter().a(true, 3, null);
    localObject = (FileAssistantResultCallbak)this.b.get();
    if (localObject != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "call onSendComplete");
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) && (QFileAssistantUtils.b(this.a, this.f.fileSize)))
    {
      this.k = true;
      e();
    }
    else
    {
      b(paramBoolean);
    }
    this.a.getFileManagerNotifyCenter().a(this.f.uniseq, this.f.nSessionId, this.f.peerUin, this.f.peerType, 16, null, 0, null);
  }
  
  public boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("equal id[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f.nSessionId);
    localStringBuilder.append("]");
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    return this.f.nSessionId == paramLong;
  }
  
  public void b()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((WLANSender)localObject).b();
    }
    this.a.getFileManagerEngine().j().a(this.f.nSessionId);
    this.k = false;
    this.l = false;
    localObject = (FileAssistantResultCallbak)this.b.get();
    if (localObject != null) {
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void c()
  {
    Object localObject = this.c;
    if (localObject != null) {
      this.a.removeObserver((BusinessObserver)localObject);
    }
    if (this.d != null) {
      this.a.getFileManagerNotifyCenter().deleteObserver(this.d);
    }
    this.k = false;
    this.l = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destory Sender:");
    ((StringBuilder)localObject).append(this.f.nSessionId);
    QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)localObject).toString());
  }
  
  public long d()
  {
    FileManagerEntity localFileManagerEntity = this.f;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.nSessionId;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender
 * JD-Core Version:    0.7.0.1
 */
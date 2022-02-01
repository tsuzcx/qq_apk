package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FileAssistantSender$3
  extends DataLineObserver
{
  FileAssistantSender$3(FileAssistantSender paramFileAssistantSender) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (!FileAssistantSender.a(this.a).a(paramLong)) {
      return;
    }
    FileAssistantSender.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWlanConnect:");
    localStringBuilder.append(FileAssistantSender.a(this.a).nSessionId);
    localStringBuilder.append(", channelType:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", connStep:");
    localStringBuilder.append(paramInt2);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    if (!FileAssistantSender.a(this.a).getFileManagerEngine().a().b(FileAssistantSender.a(this.a).nSessionId))
    {
      ThreadManager.getUIHandler().removeCallbacks(FileAssistantSender.b(this.a));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWlanConnect cancel timer:");
      localStringBuilder.append(FileAssistantSender.a(this.a).nSessionId);
      localStringBuilder.append("]");
      QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWlanConnect[");
    localStringBuilder.append(FileAssistantSender.a(this.a).nSessionId);
    localStringBuilder.append("] timer is started,tryCancel");
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    if (FileAssistantSender.a(this.a).getFileManagerEngine().a().a(FileAssistantSender.a(this.a).nSessionId)) {
      FileAssistantSender.a(this.a, false);
    }
  }
  
  protected void a(Session paramSession, float paramFloat)
  {
    if (!FileAssistantSender.a(this.a).a(paramSession.uSessionID)) {
      return;
    }
    paramSession = new StringBuilder();
    paramSession.append("onServiceSessionProgress:");
    paramSession.append(FileAssistantSender.a(this.a).nSessionId);
    paramSession.append(", fProgress:");
    paramSession.append(paramFloat);
    QLog.i("FileAssistantSender<FileAssistant>", 1, paramSession.toString());
    FileAssistantSender.a(this.a).fProgress = paramFloat;
    FileAssistantSender.a(this.a).getFileManagerNotifyCenter().a(FileAssistantSender.a(this.a).uniseq, FileAssistantSender.a(this.a).nSessionId, FileAssistantSender.a(this.a).peerUin, FileAssistantSender.a(this.a).peerType, 16, null, 0, null);
  }
  
  protected void a(Session paramSession, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void b(long paramLong)
  {
    if (!FileAssistantSender.a(this.a).a(paramLong)) {
      return;
    }
    FileAssistantSender.c(this.a, true);
    if (FileAssistantSender.b(this.a))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onWlanStartRun:");
      ((StringBuilder)???).append(FileAssistantSender.a(this.a).nSessionId);
      ((StringBuilder)???).append(",config isNotEnoughtSpace[");
      ((StringBuilder)???).append(FileAssistantSender.b(this.a));
      ((StringBuilder)???).append("] stop start offline!");
      QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)???).toString());
      return;
    }
    if (((IQFileConfigManager)FileAssistantSender.a(this.a).getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(FileAssistantSender.a(this.a).nSessionId);
      ((StringBuilder)???).append(":run only wlan mode, waiting for connect!");
      QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)???).toString());
      return;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onWlanStartRun:");
    ((StringBuilder)???).append(FileAssistantSender.a(this.a).nSessionId);
    ((StringBuilder)???).append(", start offline timer, wait 3s!");
    QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)???).toString());
    synchronized (this.a)
    {
      FileAssistantSender.a(this.a, FileAssistantSender.a(this.a));
      paramLong = QFileAssistantUtils.b(FileAssistantSender.a(this.a));
      ThreadManager.getUIHandler().postDelayed(FileAssistantSender.b(this.a), paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.3
 * JD-Core Version:    0.7.0.1
 */
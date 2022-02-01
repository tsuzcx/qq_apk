package com.tencent.mobileqq.filemanager.guild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

public class QFileGuildTransferWrapper
{
  private final QQAppInterface a;
  private final Map<Long, QFileGuildTransferWrapper.GuildBaseUploadWrapper> b = new HashMap();
  private QFileGuildTransferWrapper.ITransferWrapperCallback c = new QFileGuildTransferWrapper.1(this);
  
  public QFileGuildTransferWrapper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  @NotNull
  private MessageRecord a(String paramString1, String paramString2, FileInfo paramFileInfo, FileManagerEntity paramFileManagerEntity)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2005);
    this.a.getFileManagerProxy().a(paramFileManagerEntity);
    paramFileManagerEntity.uniseq = localMessageRecord.uniseq;
    paramFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    paramFileManagerEntity.selfUin = this.a.getAccount();
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.nOpType = 52;
    paramFileManagerEntity.fileSize = FileManagerUtil.h(paramFileInfo.d());
    paramFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    paramFileManagerEntity.lastTime = (paramFileManagerEntity.srvTime + 2592000L);
    paramFileManagerEntity.fileName = paramFileInfo.e();
    paramFileManagerEntity.nFileType = FileManagerUtil.c(paramFileInfo.d());
    paramFileManagerEntity.setCloudType(3);
    paramFileManagerEntity.setFilePath(paramFileInfo.d());
    paramFileManagerEntity.msgSeq = FileManagerUtil.f();
    paramFileManagerEntity.msgUid = FileManagerUtil.g();
    paramFileManagerEntity.peerType = 10014;
    paramFileManagerEntity.guildId = paramString1;
    paramFileManagerEntity.channelId = paramString2;
    paramFileManagerEntity.bSend = true;
    FileManagerUtil.g(paramFileManagerEntity);
    IGPSService localIGPSService = (IGPSService)this.a.getRuntimeService(IGPSService.class, "");
    paramFileInfo = localIGPSService.getGuildName(paramString1);
    paramString1 = localIGPSService.getChannelInfo(paramString2);
    if (paramString1 != null) {
      paramString1 = paramString1.getChannelName();
    } else {
      paramString1 = null;
    }
    paramFileManagerEntity.peerNick = paramFileInfo;
    paramFileManagerEntity.guildName = paramFileInfo;
    paramFileManagerEntity.channelName = paramString1;
    this.a.getFileManagerDataCenter().a(paramFileManagerEntity);
    localMessageRecord.init(this.a.getCurrentAccountUin(), paramString2, ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getSelfTinyId(), "", MessageCache.c(), -2005, 10014, paramFileManagerEntity.msgSeq);
    localMessageRecord.msg = TransfileUtile.makeTransFileProtocolData(paramFileManagerEntity.strFilePath, paramFileManagerEntity.fileSize, 0, true);
    localMessageRecord.isread = true;
    localMessageRecord.msgUid = paramFileManagerEntity.msgUid;
    localMessageRecord.issend = 1;
    ((MessageForFile)localMessageRecord).fileName = paramFileManagerEntity.fileName;
    return localMessageRecord;
  }
  
  private void a(long paramLong, QFileGuildTransferWrapper.GuildBaseUploadWrapper paramGuildBaseUploadWrapper)
  {
    try
    {
      this.b.put(Long.valueOf(paramLong), paramGuildBaseUploadWrapper);
      return;
    }
    finally {}
  }
  
  private QFileGuildTransferWrapper.GuildBaseUploadWrapper b(long paramLong)
  {
    try
    {
      QFileGuildTransferWrapper.GuildBaseUploadWrapper localGuildBaseUploadWrapper = (QFileGuildTransferWrapper.GuildBaseUploadWrapper)this.b.remove(Long.valueOf(paramLong));
      return localGuildBaseUploadWrapper;
    }
    finally {}
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    QFileGuildTransferWrapper.GuildUploadWrapper localGuildUploadWrapper = new QFileGuildTransferWrapper.GuildUploadWrapper(this.a, paramFileManagerEntity, this.c);
    a(paramFileManagerEntity.nSessionId, localGuildUploadWrapper);
    localGuildUploadWrapper.b();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resendFile Id[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("]");
    QLog.i("QFileGuildTransferWrapper", 1, localStringBuilder.toString());
    if (!a(paramFileManagerEntity.nSessionId))
    {
      b(paramFileManagerEntity);
      return;
    }
    QQFileManagerUtil.FileExecutor.a().execute(new QFileGuildTransferWrapper.3(this, paramFileManagerEntity));
  }
  
  public void a(String paramString1, String paramString2, FileInfo paramFileInfo)
  {
    paramString1 = new QFileGuildTransferWrapper.2(this, paramString1, paramString2, paramFileInfo);
    QQFileManagerUtil.FileExecutor.a().execute(paramString1);
  }
  
  public boolean a(long paramLong)
  {
    QFileGuildTransferWrapper.GuildBaseUploadWrapper localGuildBaseUploadWrapper = b(paramLong);
    if (localGuildBaseUploadWrapper != null) {
      return localGuildBaseUploadWrapper.a(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.QFileGuildTransferWrapper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.guild;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadInfo;
import java.text.DecimalFormat;

class QFileGuildTransferWrapper$GuildUploadWrapper
  extends QFileGuildTransferWrapper.GuildBaseUploadWrapper
{
  final FileManagerEntity e;
  int f = 0;
  
  QFileGuildTransferWrapper$GuildUploadWrapper(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, QFileGuildTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.e = paramFileManagerEntity;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    return 0;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (this.a) {
      return;
    }
    paramIUFTTransferKey = this.e;
    paramIUFTTransferKey.fProgress = 0.0F;
    if (paramIUFTTransferKey.status != 2)
    {
      this.e.status = 2;
      this.b.getFileManagerDataCenter().c(this.e);
    }
    this.b.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle)
  {
    this.f = paramInt;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    if (paramInt != 0)
    {
      this.e.status = 0;
      this.b.getFileManagerDataCenter().c(this.e);
      this.b.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 15, null, paramInt, paramIUFTUploadCompleteInfo.b());
    }
    else
    {
      paramIUFTTransferKey = new FileManagerReporter.FileAssistantReportData();
      paramIUFTTransferKey.b = "send_file_suc";
      paramIUFTTransferKey.c = 1;
      FileManagerReporter.a(this.b.getCurrentAccountUin(), paramIUFTTransferKey);
      if (paramIUFTUploadCompleteInfo.a())
      {
        FileManagerUtil.b(this.e.nSessionId);
        this.b.getFileManagerNotifyCenter().a(this.e, 11, "");
      }
      else
      {
        this.e.fProgress = 1.0F;
      }
      this.e.status = 1;
      this.b.getFileManagerDataCenter().c(this.e);
      this.b.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 14, new Object[] { this.e.getFilePath(), Long.valueOf(this.e.fileSize), Boolean.valueOf(true), paramIUFTUploadCompleteInfo.c() }, 0, null);
    }
    paramIUFTTransferKey = this.c.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.d.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a) {
      return;
    }
    float f1;
    StringBuilder localStringBuilder;
    if (paramLong3 > 1048576L)
    {
      f1 = (float)paramLong3 / 1048576.0F;
      paramIUFTTransferKey = new DecimalFormat("0.00").format(f1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("加速上传 ");
      localStringBuilder.append(paramIUFTTransferKey);
      localStringBuilder.append("MB/s");
      paramIUFTTransferKey = localStringBuilder.toString();
    }
    else if (paramLong3 > 1024L)
    {
      f1 = (float)paramLong3 / 1024.0F;
      paramIUFTTransferKey = new DecimalFormat("0.00").format(f1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("加速上传 ");
      localStringBuilder.append(paramIUFTTransferKey);
      localStringBuilder.append("KB/s");
      paramIUFTTransferKey = localStringBuilder.toString();
    }
    else
    {
      paramIUFTTransferKey = new StringBuilder();
      paramIUFTTransferKey.append("加速上传 ");
      paramIUFTTransferKey.append(paramLong3);
      paramIUFTTransferKey.append("KB/s");
      paramIUFTTransferKey = paramIUFTTransferKey.toString();
    }
    if (paramLong3 != 0L) {
      this.e.mExcitingSpeed = paramIUFTTransferKey;
    }
    this.e.fProgress = ((float)paramLong2 / (float)paramLong1);
    this.b.getFileManagerDataCenter().c(this.e);
    this.b.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.a) {
      return;
    }
    if (paramUFTFileLocalInfo.b() != null)
    {
      this.e.strFileMd5 = FileHttpUtils.a(paramUFTFileLocalInfo.b());
      this.e.str10Md5 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.b());
    }
    if (paramUFTFileLocalInfo.d() != null) {
      this.e.strFileSha3 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.d());
    }
    if (paramUFTFileLocalInfo.e() != null) {
      this.e.strFileSHA = FileHttpUtils.a(paramUFTFileLocalInfo.e());
    }
    if (paramUFTFileLocalInfo.g() != 0) {
      this.e.imgHeight = paramUFTFileLocalInfo.g();
    }
    if (paramUFTFileLocalInfo.f() != 0) {
      this.e.imgWidth = paramUFTFileLocalInfo.f();
    }
    this.b.getFileManagerDataCenter().c(this.e);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.a) {
      return;
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.e.Uuid = paramUFTFileUploadBusinessInfo.a();
    }
    this.e.bUseMediaPlatform = paramUFTFileUploadBusinessInfo.c();
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.e())) {
      this.e.strServerPath = paramUFTFileUploadBusinessInfo.e();
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.d())) {
      this.e.fileIdCrc = paramUFTFileUploadBusinessInfo.d();
    }
    this.e.svrPathIpType = paramUFTFileUploadBusinessInfo.f();
    this.b.getFileManagerDataCenter().c(this.e);
  }
  
  boolean a(int paramInt)
  {
    super.a(paramInt);
    this.e.status = 3;
    this.b.getFileManagerDataCenter().c(this.e);
    this.b.getFileManagerNotifyCenter().a(true, 3, null);
    return true;
  }
  
  public void b()
  {
    this.a = false;
    UFTGuildUploadInfo localUFTGuildUploadInfo = new UFTGuildUploadInfo();
    localUFTGuildUploadInfo.a(this.e.strFilePath);
    localUFTGuildUploadInfo.a(false);
    localUFTGuildUploadInfo.c(this.e.guildId);
    localUFTGuildUploadInfo.d(this.e.channelId);
    localUFTGuildUploadInfo.a(this.e.msgUid);
    localUFTGuildUploadInfo.a(Long.valueOf(this.e.nSessionId));
    localUFTGuildUploadInfo.b(this.e.guildId);
    localUFTGuildUploadInfo.a(10014);
    this.c = ((IUFTTransferService)this.b.getRuntimeService(IUFTTransferService.class, "")).uploadGuildFile(localUFTGuildUploadInfo, a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.QFileGuildTransferWrapper.GuildUploadWrapper
 * JD-Core Version:    0.7.0.1
 */
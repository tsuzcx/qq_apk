package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import java.text.DecimalFormat;
import java.util.concurrent.Executor;

class QFileC2CTransferWrapper$C2CUploadWrapper
  extends QFileC2CTransferWrapper.C2CBaseUploadWrapper
{
  final FileManagerEntity f;
  int g = 0;
  
  QFileC2CTransferWrapper$C2CUploadWrapper(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, QFileC2CTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.f = paramFileManagerEntity;
    this.e = QFileAssistantUtils.a(paramFileManagerEntity.peerUin);
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    this.a.getFileTransferHandler().a(this.f.peerUin, this.f, new QFileC2CTransferWrapper.C2CUploadWrapper.2(this, paramIUFTUploadSendMsgCallback));
    return 0;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (this.b) {
      return;
    }
    paramIUFTTransferKey = new FileManagerReporter.FileAssistantReportData();
    paramIUFTTransferKey.b = "send_file_number";
    FileManagerReporter.a(this.a.getCurrentAccountUin(), paramIUFTTransferKey);
    paramIUFTTransferKey = this.f;
    paramIUFTTransferKey.fProgress = 0.0F;
    if (paramIUFTTransferKey.status != 2)
    {
      this.f.status = 2;
      this.a.getFileManagerDataCenter().c(this.f);
    }
    this.a.getFileManagerNotifyCenter().a(this.f.uniseq, this.f.nSessionId, this.f.peerUin, this.f.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle)
  {
    this.g = paramInt;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    if (paramInt != 0)
    {
      this.f.status = 0;
      this.a.getFileManagerDataCenter().c(this.f);
      this.a.getFileManagerNotifyCenter().a(this.f.uniseq, this.f.nSessionId, this.f.peerUin, this.f.peerType, 15, null, paramInt, paramIUFTUploadCompleteInfo.b());
    }
    else
    {
      paramIUFTTransferKey = new FileManagerReporter.FileAssistantReportData();
      paramIUFTTransferKey.b = "send_file_suc";
      paramIUFTTransferKey.c = 1;
      FileManagerReporter.a(this.a.getCurrentAccountUin(), paramIUFTTransferKey);
      if (paramIUFTUploadCompleteInfo.a())
      {
        FileManagerUtil.b(this.f.nSessionId);
        this.a.getFileManagerNotifyCenter().a(this.f, 5, "");
      }
      else
      {
        this.f.fProgress = 1.0F;
      }
      this.f.status = 1;
      this.a.getFileManagerDataCenter().c(this.f);
      this.a.getFileManagerNotifyCenter().a(this.f.uniseq, this.f.nSessionId, this.f.peerUin, this.f.peerType, 14, new Object[] { this.f.getFilePath(), Long.valueOf(this.f.fileSize), Boolean.valueOf(true), paramIUFTUploadCompleteInfo.c() }, 0, null);
    }
    paramIUFTTransferKey = this.d.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.c.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.b) {
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
      this.f.mExcitingSpeed = paramIUFTTransferKey;
    }
    this.f.fProgress = ((float)paramLong2 / (float)paramLong1);
    this.a.getFileManagerNotifyCenter().a(this.f.uniseq, this.f.nSessionId, this.f.peerUin, this.f.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.b) {
      return;
    }
    if (paramUFTFileLocalInfo.b() != null)
    {
      this.f.strFileMd5 = FileHttpUtils.a(paramUFTFileLocalInfo.b());
      this.f.str10Md5 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.b());
    }
    if (paramUFTFileLocalInfo.d() != null) {
      this.f.strFileSha3 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.d());
    }
    if (paramUFTFileLocalInfo.e() != null) {
      this.f.strFileSHA = FileHttpUtils.a(paramUFTFileLocalInfo.e());
    }
    if (paramUFTFileLocalInfo.g() != 0) {
      this.f.imgHeight = paramUFTFileLocalInfo.g();
    }
    if (paramUFTFileLocalInfo.f() != 0) {
      this.f.imgWidth = paramUFTFileLocalInfo.f();
    }
    this.a.getFileManagerDataCenter().c(this.f);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.b) {
      return;
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.f.Uuid = paramUFTFileUploadBusinessInfo.a();
    }
    this.f.bUseMediaPlatform = paramUFTFileUploadBusinessInfo.c();
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.e())) {
      this.f.strServerPath = paramUFTFileUploadBusinessInfo.e();
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.d())) {
      this.f.fileIdCrc = paramUFTFileUploadBusinessInfo.d();
    }
    this.f.svrPathIpType = paramUFTFileUploadBusinessInfo.f();
    this.a.getFileManagerDataCenter().c(this.f);
  }
  
  boolean a(int paramInt)
  {
    if (((this.e) && (this.g == 5)) || (this.g == 6)) {
      return false;
    }
    super.a(paramInt);
    this.f.status = 3;
    this.a.getFileManagerDataCenter().c(this.f);
    this.a.getFileManagerNotifyCenter().a(true, 3, null);
    return true;
  }
  
  long b()
  {
    return this.f.fileSize;
  }
  
  public void c()
  {
    this.b = false;
    if (this.f.bDelInFM == true)
    {
      this.f.bDelInFM = false;
      this.a.getFileManagerDataCenter().b(this.f);
      this.a.getFileManagerNotifyCenter().a(true, 3, null);
    }
    Object localObject = (ShieldMsgManger)this.a.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if ((!QFileAssistantUtils.a(this.f.peerUin)) && (localObject != null) && (((ShieldMsgManger)localObject).a(this.f.peerUin)))
    {
      QQFileManagerUtil.FileExecutor.a().execute(new QFileC2CTransferWrapper.C2CUploadWrapper.1(this));
      return;
    }
    localObject = new UFTC2CUploadInfo();
    ((UFTC2CUploadInfo)localObject).a(this.f.strFilePath);
    ((UFTC2CUploadInfo)localObject).a(true);
    ((UFTC2CUploadInfo)localObject).b(this.f.peerUin);
    ((UFTC2CUploadInfo)localObject).a(this.f.peerType);
    ((UFTC2CUploadInfo)localObject).a(this.f.tmpSessionType);
    ((UFTC2CUploadInfo)localObject).a(this.f.tmpSessionSig);
    ((UFTC2CUploadInfo)localObject).c(this.f.tmpSessionToPhone);
    ((UFTC2CUploadInfo)localObject).a(Long.valueOf(this.f.nSessionId));
    this.d = ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).uploadC2CFile((UFTC2CUploadInfo)localObject, a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CUploadWrapper
 * JD-Core Version:    0.7.0.1
 */
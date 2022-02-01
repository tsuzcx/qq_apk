package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;

class QFileDiscTransferWrapper$DiscUploadWrapper
  extends QFileDiscTransferWrapper.DiscBaseUploadWrapper
{
  final FileManagerEntity e;
  
  QFileDiscTransferWrapper$DiscUploadWrapper(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, QFileDiscTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.e = paramFileManagerEntity;
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    paramBundle = this.e.fileName;
    paramIUFTTransferKey = paramBundle;
    if (this.e.nFileType == 5)
    {
      paramIUFTTransferKey = paramBundle;
      if (!TextUtils.isEmpty(this.e.strApkPackageName))
      {
        paramIUFTTransferKey = paramBundle;
        if (paramBundle.indexOf(".apk") < 0)
        {
          paramIUFTTransferKey = new StringBuilder();
          paramIUFTTransferKey.append(paramBundle);
          paramIUFTTransferKey.append(".apk");
          paramIUFTTransferKey = paramIUFTTransferKey.toString();
        }
      }
    }
    this.a.getFileTransferHandler().a(this.e.nSessionId, this.e.peerUin, this.a.getCurrentAccountUin(), paramIUFTTransferKey, this.e.fileSize, this.e.Uuid, this.e.uniseq, this.e.msgUid, new QFileDiscTransferWrapper.DiscUploadWrapper.1(this, paramIUFTUploadSendMsgCallback));
    return 0;
  }
  
  void a(int paramInt)
  {
    super.a(paramInt);
    this.e.status = 3;
    this.a.getFileManagerDataCenter().c(this.e);
    this.a.getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (this.b) {
      return;
    }
    paramIUFTTransferKey = this.e;
    paramIUFTTransferKey.fProgress = 0.0F;
    if (paramIUFTTransferKey.status != 2)
    {
      this.e.status = 2;
      this.a.getFileManagerDataCenter().c(this.e);
    }
    this.a.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    if (paramInt != 0)
    {
      this.e.status = 0;
      this.a.getFileManagerDataCenter().c(this.e);
      this.a.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 15, null, paramInt, paramIUFTUploadCompleteInfo.b());
    }
    else
    {
      if (paramIUFTUploadCompleteInfo.a())
      {
        FileManagerUtil.b(this.e.nSessionId);
        this.a.getFileManagerNotifyCenter().a(this.e, 5, "");
      }
      else
      {
        this.e.fProgress = 1.0F;
      }
      this.e.status = 1;
      this.a.getFileManagerDataCenter().c(this.e);
      this.a.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 14, new Object[] { this.e.getFilePath(), Long.valueOf(this.e.fileSize), Boolean.valueOf(true), paramIUFTUploadCompleteInfo.c() }, 0, null);
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
    paramIUFTTransferKey = this.e;
    paramIUFTTransferKey.fProgress = ((float)paramLong2 / (float)paramLong1);
    if (paramIUFTTransferKey.status != 2)
    {
      this.e.status = 2;
      this.a.getFileManagerDataCenter().c(this.e);
    }
    this.a.getFileManagerNotifyCenter().a(this.e.uniseq, this.e.nSessionId, this.e.peerUin, this.e.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.b) {
      return;
    }
    if (paramUFTFileLocalInfo.b() != null)
    {
      this.e.strFileMd5 = FileHttpUtils.a(paramUFTFileLocalInfo.b());
      this.e.str10Md5 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.b());
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
    this.a.getFileManagerDataCenter().c(this.e);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.b) {
      return;
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.e.Uuid = paramUFTFileUploadBusinessInfo.a();
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.e())) {
      this.e.strServerPath = paramUFTFileUploadBusinessInfo.e();
    }
    this.e.svrPathIpType = paramUFTFileUploadBusinessInfo.f();
    this.a.getFileManagerDataCenter().c(this.e);
  }
  
  public void b()
  {
    this.b = false;
    UFTDiscUploadInfo localUFTDiscUploadInfo = new UFTDiscUploadInfo();
    localUFTDiscUploadInfo.a(this.e.strFilePath);
    localUFTDiscUploadInfo.a(true);
    localUFTDiscUploadInfo.b(this.e.peerUin);
    localUFTDiscUploadInfo.a(this.e.peerType);
    localUFTDiscUploadInfo.a(Long.valueOf(this.e.nSessionId));
    this.d = ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).uploadDiscFile(localUFTDiscUploadInfo, a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.DiscUploadWrapper
 * JD-Core Version:    0.7.0.1
 */
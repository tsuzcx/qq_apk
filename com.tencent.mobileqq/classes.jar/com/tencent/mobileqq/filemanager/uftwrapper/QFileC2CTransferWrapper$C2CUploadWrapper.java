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
  int jdField_a_of_type_Int = 0;
  final FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  QFileC2CTransferWrapper$C2CUploadWrapper(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, QFileC2CTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramITransferWrapperCallback);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.b = QFileAssistantUtils.a(paramFileManagerEntity.peerUin);
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, new QFileC2CTransferWrapper.C2CUploadWrapper.2(this, paramIUFTUploadSendMsgCallback));
    return 0;
  }
  
  long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM == true)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
    }
    Object localObject = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if ((!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) && (localObject != null) && (((ShieldMsgManger)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)))
    {
      QQFileManagerUtil.FileExecutor.a().execute(new QFileC2CTransferWrapper.C2CUploadWrapper.1(this));
      return;
    }
    localObject = new UFTC2CUploadInfo();
    ((UFTC2CUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    ((UFTC2CUploadInfo)localObject).a(true);
    ((UFTC2CUploadInfo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
    ((UFTC2CUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
    ((UFTC2CUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
    ((UFTC2CUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig);
    ((UFTC2CUploadInfo)localObject).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionToPhone);
    ((UFTC2CUploadInfo)localObject).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey = ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).uploadC2CFile((UFTC2CUploadInfo)localObject, a(), this);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    paramIUFTTransferKey = new FileManagerReporter.FileAssistantReportData();
    paramIUFTTransferKey.b = "send_file_number";
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIUFTTransferKey);
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    paramIUFTTransferKey.fProgress = 0.0F;
    if (paramIUFTTransferKey.status != 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramInt, paramIUFTUploadCompleteInfo.a());
    }
    else
    {
      paramIUFTTransferKey = new FileManagerReporter.FileAssistantReportData();
      paramIUFTTransferKey.b = "send_file_suc";
      paramIUFTTransferKey.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIUFTTransferKey);
      if (paramIUFTUploadCompleteInfo.a())
      {
        FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, "");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), paramIUFTUploadCompleteInfo.b() }, 0, null);
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey.a();
    if ((paramIUFTTransferKey instanceof Long)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileC2CTransferWrapper$ITransferWrapperCallback.a(((Long)paramIUFTTransferKey).longValue());
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    float f;
    StringBuilder localStringBuilder;
    if (paramLong3 > 1048576L)
    {
      f = (float)paramLong3 / 1048576.0F;
      paramIUFTTransferKey = new DecimalFormat("0.00").format(f);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("加速上传 ");
      localStringBuilder.append(paramIUFTTransferKey);
      localStringBuilder.append("MB/s");
      paramIUFTTransferKey = localStringBuilder.toString();
    }
    else if (paramLong3 > 1024L)
    {
      f = (float)paramLong3 / 1024.0F;
      paramIUFTTransferKey = new DecimalFormat("0.00").format(f);
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = paramIUFTTransferKey;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong2 / (float)paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramUFTFileLocalInfo.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = FileHttpUtils.a(paramUFTFileLocalInfo.a());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.a());
    }
    if (paramUFTFileLocalInfo.c() != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(paramUFTFileLocalInfo.c());
    }
    if (paramUFTFileLocalInfo.d() != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = FileHttpUtils.a(paramUFTFileLocalInfo.d());
    }
    if (paramUFTFileLocalInfo.b() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight = paramUFTFileLocalInfo.b();
    }
    if (paramUFTFileLocalInfo.a() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth = paramUFTFileLocalInfo.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.a())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramUFTFileUploadBusinessInfo.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = paramUFTFileUploadBusinessInfo.a();
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = paramUFTFileUploadBusinessInfo.d();
    }
    if (!TextUtils.isEmpty(paramUFTFileUploadBusinessInfo.c())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc = paramUFTFileUploadBusinessInfo.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.svrPathIpType = paramUFTFileUploadBusinessInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  boolean a(int paramInt)
  {
    if (((this.b) && (this.jdField_a_of_type_Int == 5)) || (this.jdField_a_of_type_Int == 6)) {
      return false;
    }
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CUploadWrapper
 * JD-Core Version:    0.7.0.1
 */
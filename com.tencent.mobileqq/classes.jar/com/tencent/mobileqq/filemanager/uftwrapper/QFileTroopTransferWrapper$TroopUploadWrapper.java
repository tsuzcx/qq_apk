package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferKey;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCompleteInfo;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadSendMsgCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.text.DecimalFormat;
import java.util.UUID;

class QFileTroopTransferWrapper$TroopUploadWrapper
  extends QFileTroopTransferWrapper.TroopBaseUploadWrapper
{
  final Bundle jdField_a_of_type_AndroidOsBundle;
  final TroopFileTransferManager.Item jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
  long jdField_b_of_type_Long = 0L;
  boolean jdField_b_of_type_Boolean = false;
  
  QFileTroopTransferWrapper$TroopUploadWrapper(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, QFileTroopTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramLong, paramITransferWrapperCallback);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_b_of_type_Boolean = paramItem.isFromAIO;
  }
  
  private void b(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    int i = 3;
    if (paramInt == 1000)
    {
      paramInt = paramIUFTUploadCompleteInfo.b();
      paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
      paramIUFTTransferKey.Pausing = 1;
      if (paramInt == 1)
      {
        paramIUFTTransferKey.W2MPause = 2;
      }
      else
      {
        if (paramInt == 3)
        {
          paramIUFTTransferKey.Pausing = -1;
          paramInt = i;
          break label74;
        }
        if (paramInt == 2)
        {
          paramIUFTTransferKey.Pausing = -1;
          paramInt = i;
          break label74;
        }
      }
      paramInt = 2;
      label74:
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, paramInt);
      return;
    }
    if (paramInt == 206)
    {
      TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, paramInt);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
      return;
    }
    if (paramInt == 210)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new QFileTroopTransferWrapper.TroopUploadWrapper.1(this), 1000L);
      return;
    }
    if (paramIUFTUploadCompleteInfo.a() == 3)
    {
      paramIUFTTransferKey = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 3, paramInt);
      if (paramInt == 704) {
        paramIUFTTransferKey = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 3, 704, paramIUFTUploadCompleteInfo.a());
      }
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramIUFTTransferKey);
      return;
    }
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, paramInt);
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    paramIUFTTransferKey = TroopFileUploadFeedsSender.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    if (paramIUFTTransferKey != null) {
      paramIUFTTransferKey.a();
    }
    if (paramIUFTUploadSendMsgCallback != null) {
      paramIUFTUploadSendMsgCallback.a(true, 0L, new Bundle());
    }
    return 0;
  }
  
  long a()
  {
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
    }
    return this.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("_wifi2mobile_resume_", false)) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.W2MPause = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 0;
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    localObject = new UFTTroopUploadInfo();
    ((UFTTroopUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile);
    ((UFTTroopUploadInfo)localObject).a(true);
    ((UFTTroopUploadInfo)localObject).b(String.valueOf(this.jdField_a_of_type_Long));
    ((UFTTroopUploadInfo)localObject).a(1);
    ((UFTTroopUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id);
    ((UFTTroopUploadInfo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mParentId)) {
      ((UFTTroopUploadInfo)localObject).c(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mParentId);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath)) {
      ((UFTTroopUploadInfo)localObject).d(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns)) {
      ((UFTTroopUploadInfo)localObject).e(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 != null) {
      ((UFTTroopUploadInfo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha != null) {
      ((UFTTroopUploadInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3 != null) {
      ((UFTTroopUploadInfo)localObject).c(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3.getBytes());
    }
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = 5;
    } else {
      i = 4;
    }
    ((UFTTroopUploadInfo)localObject).c(i);
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey = ((IUFTTransferService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IUFTTransferService.class, "")).uploadTroopFile((UFTTroopUploadInfo)localObject, a(), this);
  }
  
  void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Pausing = 1;
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 2);
  }
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
    localFileManagerEntity.peerNick = ContactUtils.h(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.jdField_a_of_type_Long;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.b(paramTroopFileStatusInfo.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.a(paramTroopFileStatusInfo.a));
      }
    }
    localFileManagerEntity.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(FileManagerUtil.d(paramTroopFileStatusInfo.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramTroopFileStatusInfo.a).lastModified();
      label229:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramTroopFileStatusInfo)
    {
      break label229;
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt != 0)
    {
      b(paramIUFTTransferKey, paramInt, paramIUFTUploadCompleteInfo);
    }
    else
    {
      paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
      paramIUFTTransferKey.ProgressValue = paramIUFTTransferKey.ProgressTotal;
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 6);
      paramIUFTTransferKey = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
      paramIUFTUploadCompleteInfo = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_a_of_type_Long), paramIUFTTransferKey, paramIUFTUploadCompleteInfo, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
    }
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqUftransferApiIUFTTransferKey.a();
    if ((paramIUFTTransferKey instanceof UUID)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITransferWrapperCallback.a((UUID)paramIUFTTransferKey);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status;
    int j = 0;
    if (i != 0) {
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0);
    }
    if (paramLong2 == 0L)
    {
      i = j;
      if (paramLong1 != 0L)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramLong1;
          i = 1;
        }
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
        TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ScanPos = paramLong2;
      TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = paramLong2;
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
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = paramIUFTTransferKey;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status != 1) {
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    }
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramUFTFileLocalInfo.a() != 0L) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal = paramUFTFileLocalInfo.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramUFTFileLocalInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha = paramUFTFileLocalInfo.d();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramUFTFileLocalInfo.c());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width = paramUFTFileLocalInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height = paramUFTFileLocalInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.duration = paramUFTFileLocalInfo.c();
    paramIUFTTransferKey = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
    paramIUFTTransferKey.StatusUpdateTimeMs = 0L;
    if (paramIUFTTransferKey.Status != 1) {
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    }
    TroopFileDataCenter.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramUFTFileUploadBusinessInfo instanceof UFTTroopFileUploadBusinessInfo))
    {
      paramIUFTTransferKey = (UFTTroopFileUploadBusinessInfo)paramUFTFileUploadBusinessInfo;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath = paramIUFTTransferKey.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = paramIUFTTransferKey.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns = paramIUFTTransferKey.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = paramIUFTTransferKey.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId = paramIUFTTransferKey.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status != 1) {
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.TroopUploadWrapper
 * JD-Core Version:    0.7.0.1
 */
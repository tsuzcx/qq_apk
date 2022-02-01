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
  boolean f = false;
  final TroopFileTransferManager.Item g;
  final Bundle h;
  long i = 0L;
  
  QFileTroopTransferWrapper$TroopUploadWrapper(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, QFileTroopTransferWrapper.ITransferWrapperCallback paramITransferWrapperCallback)
  {
    super(paramQQAppInterface, paramLong, paramITransferWrapperCallback);
    this.g = paramItem;
    this.h = paramBundle;
    this.f = paramItem.isFromAIO;
  }
  
  private void b(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    int j = 3;
    if (paramInt == 1000)
    {
      paramInt = paramIUFTUploadCompleteInfo.e();
      paramIUFTTransferKey = this.g;
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
          paramInt = j;
          break label74;
        }
        if (paramInt == 2)
        {
          paramIUFTTransferKey.Pausing = -1;
          paramInt = j;
          break label74;
        }
      }
      paramInt = 2;
      label74:
      TroopFileDataCenter.a(this.c, this.g, paramInt);
      return;
    }
    if (paramInt == 206)
    {
      TroopFileDataCenter.b(this.c, this.g, paramInt);
      TroopFileDataCenter.a(this.c, this.g, 12);
      return;
    }
    if (paramInt == 210)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new QFileTroopTransferWrapper.TroopUploadWrapper.1(this), 1000L);
      return;
    }
    if (paramIUFTUploadCompleteInfo.d() == 3)
    {
      paramIUFTTransferKey = new TroopFileError.SimpleErrorInfo(this.g.FileName, this.c, 3, paramInt);
      if (paramInt == 704) {
        paramIUFTTransferKey = new TroopFileError.SimpleErrorInfo(this.g.FileName, this.c, 3, 704, paramIUFTUploadCompleteInfo.b());
      }
      TroopFileDataCenter.a(this.c, this.g, 3, paramIUFTTransferKey);
      return;
    }
    TroopFileDataCenter.a(this.c, this.g, 3, paramInt);
  }
  
  public int a(IUFTTransferKey paramIUFTTransferKey, Bundle paramBundle, IUFTUploadSendMsgCallback paramIUFTUploadSendMsgCallback)
  {
    paramIUFTTransferKey = TroopFileUploadFeedsSender.b(this.c, this.g);
    if (paramIUFTTransferKey != null) {
      paramIUFTTransferKey.c();
    }
    if (paramIUFTUploadSendMsgCallback != null) {
      paramIUFTUploadSendMsgCallback.a(true, 0L, new Bundle());
    }
    return 0;
  }
  
  long a()
  {
    if (this.i == 0L) {
      this.i = FileManagerUtil.h(this.g.LocalFile);
    }
    return this.i;
  }
  
  void a(int paramInt)
  {
    super.a(paramInt);
    this.g.Pausing = 1;
    TroopFileDataCenter.a(this.c, this.g, 2);
  }
  
  protected final void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.d);
    localFileManagerEntity.peerNick = ContactUtils.i(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = true;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.c;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = FileHttpUtils.a(FileManagerUtil.e(paramTroopFileStatusInfo.k));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = FileHttpUtils.a(FileManagerUtil.d(paramTroopFileStatusInfo.k));
      }
    }
    localFileManagerEntity.str10Md5 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(FileManagerUtil.g(paramTroopFileStatusInfo.k));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramTroopFileStatusInfo.k).lastModified();
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
    if (this.b) {
      return;
    }
    this.g.ProgressValue = 0L;
    TroopFileDataCenter.b(this.c, this.g);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, int paramInt, IUFTUploadCompleteInfo paramIUFTUploadCompleteInfo)
  {
    if (this.b) {
      return;
    }
    if (paramInt != 0)
    {
      b(paramIUFTTransferKey, paramInt, paramIUFTUploadCompleteInfo);
    }
    else
    {
      paramIUFTTransferKey = this.g;
      paramIUFTTransferKey.ProgressValue = paramIUFTTransferKey.ProgressTotal;
      TroopFileDataCenter.a(this.c, this.g, 6);
      paramIUFTTransferKey = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.g.Md5);
      paramIUFTUploadCompleteInfo = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.g.Sha);
      a(this.g.getInfo(this.c), paramIUFTTransferKey, paramIUFTUploadCompleteInfo, this.g.Sha3);
    }
    paramIUFTTransferKey = this.e.a();
    if ((paramIUFTTransferKey instanceof UUID)) {
      this.d.a((UUID)paramIUFTTransferKey);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2)
  {
    if (this.b) {
      return;
    }
    int j = this.g.Status;
    int k = 0;
    if (j != 0) {
      TroopFileDataCenter.a(this.c, this.g, 0);
    }
    if (paramLong2 == 0L)
    {
      j = k;
      if (paramLong1 != 0L)
      {
        j = k;
        if (this.g.ProgressTotal == 0L)
        {
          this.g.ProgressTotal = paramLong1;
          j = 1;
        }
      }
      if (j != 0)
      {
        this.g.StatusUpdateTimeMs = 0L;
        TroopFileDataCenter.b(this.c, this.g);
      }
    }
    else
    {
      this.g.ScanPos = paramLong2;
      TroopFileDataCenter.b(this.c, this.g);
    }
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.b) {
      return;
    }
    this.g.ProgressValue = paramLong2;
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
      this.g.mExcitingSpeed = paramIUFTTransferKey;
    }
    if (this.g.Status != 1) {
      TroopFileDataCenter.a(this.c, this.g, 1);
    }
    TroopFileDataCenter.b(this.c, this.g);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileLocalInfo paramUFTFileLocalInfo)
  {
    if (this.b) {
      return;
    }
    if ((paramUFTFileLocalInfo.a() != 0L) && (this.g.ProgressTotal == 0L)) {
      this.g.ProgressTotal = paramUFTFileLocalInfo.a();
    }
    this.g.Md5 = paramUFTFileLocalInfo.c();
    this.g.Sha = paramUFTFileLocalInfo.e();
    this.g.Sha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramUFTFileLocalInfo.d());
    this.g.width = paramUFTFileLocalInfo.f();
    this.g.height = paramUFTFileLocalInfo.g();
    this.g.duration = paramUFTFileLocalInfo.h();
    paramIUFTTransferKey = this.g;
    paramIUFTTransferKey.StatusUpdateTimeMs = 0L;
    if (paramIUFTTransferKey.Status != 1) {
      TroopFileDataCenter.a(this.c, this.g, 1);
    }
    TroopFileDataCenter.b(this.c, this.g);
  }
  
  public void a(IUFTTransferKey paramIUFTTransferKey, UFTFileUploadBusinessInfo paramUFTFileUploadBusinessInfo)
  {
    if (this.b) {
      return;
    }
    if ((paramUFTFileUploadBusinessInfo instanceof UFTTroopFileUploadBusinessInfo))
    {
      paramIUFTTransferKey = (UFTTroopFileUploadBusinessInfo)paramUFTFileUploadBusinessInfo;
      this.g.FilePath = paramIUFTTransferKey.a();
      this.g.UploadIp = paramIUFTTransferKey.b();
      this.g.ServerDns = paramIUFTTransferKey.i();
      this.g.CheckKey = paramIUFTTransferKey.g();
      this.g.BusId = paramIUFTTransferKey.h();
    }
    if (this.g.Status != 1) {
      TroopFileDataCenter.a(this.c, this.g, 1);
    }
  }
  
  public void c()
  {
    this.b = false;
    Object localObject = this.h;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("_wifi2mobile_resume_", false)) && (this.g.W2MPause == 2)) {
      this.g.W2MPause = 0;
    }
    this.g.Pausing = 0;
    TroopFileDataCenter.a(this.c, this.g, 0);
    localObject = new UFTTroopUploadInfo();
    ((UFTTroopUploadInfo)localObject).a(this.g.LocalFile);
    ((UFTTroopUploadInfo)localObject).a(true);
    ((UFTTroopUploadInfo)localObject).b(String.valueOf(this.c));
    ((UFTTroopUploadInfo)localObject).a(1);
    ((UFTTroopUploadInfo)localObject).a(this.g.Id);
    ((UFTTroopUploadInfo)localObject).b(this.g.BusId);
    if (!TextUtils.isEmpty(this.g.mParentId)) {
      ((UFTTroopUploadInfo)localObject).c(this.g.mParentId);
    }
    if (!TextUtils.isEmpty(this.g.FilePath)) {
      ((UFTTroopUploadInfo)localObject).d(this.g.FilePath);
    }
    if (!TextUtils.isEmpty(this.g.ServerDns)) {
      ((UFTTroopUploadInfo)localObject).e(this.g.ServerDns);
    }
    if (this.g.Md5 != null) {
      ((UFTTroopUploadInfo)localObject).b(this.g.Md5);
    }
    if (this.g.Sha != null) {
      ((UFTTroopUploadInfo)localObject).a(this.g.Sha);
    }
    if (this.g.Sha3 != null) {
      ((UFTTroopUploadInfo)localObject).c(this.g.Sha3.getBytes());
    }
    int j;
    if (this.f) {
      j = 5;
    } else {
      j = 4;
    }
    ((UFTTroopUploadInfo)localObject).c(j);
    this.e = ((IUFTTransferService)this.a.getRuntimeService(IUFTTransferService.class, "")).uploadTroopFile((UFTTroopUploadInfo)localObject, b(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.TroopUploadWrapper
 * JD-Core Version:    0.7.0.1
 */
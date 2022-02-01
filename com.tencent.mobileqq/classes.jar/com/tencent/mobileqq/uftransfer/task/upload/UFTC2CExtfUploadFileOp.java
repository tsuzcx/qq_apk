package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileTransferFactory;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFUperProp;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFileInfo;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfSvrInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class UFTC2CExtfUploadFileOp
  extends UFTC2CUploadFileOp
{
  protected boolean a = false;
  protected boolean b = false;
  protected ExcitingTransferUploadResultRp f = null;
  
  public UFTC2CExtfUploadFileOp(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
  }
  
  protected int a(UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] start c2c extf upload. useIPv6:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" useMediaPlat:");
    ((StringBuilder)localObject).append(this.b);
    UFTLog.b("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTFileUploaderProp.ExtfFUperProp();
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.n());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).b(Long.valueOf(paramUFTC2CUploadTaskInfo.c()).longValue());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).d(69);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).c(3);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).b(0);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(this.b);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).a(paramUFTC2CUploadTaskInfo.s().a().g());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().b(paramUFTC2CUploadTaskInfo.r().b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().a(paramUFTC2CUploadTaskInfo.r().c());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().c(paramUFTC2CUploadTaskInfo.r().e());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().d(paramUFTC2CUploadTaskInfo.r().d());
    if (this.b) {
      ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().f(paramC2CUploadSrvBusiProp.p());
    } else {
      ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().f(paramC2CUploadSrvBusiProp.m());
    }
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().e(paramC2CUploadSrvBusiProp.h());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().b(paramUFTC2CUploadTaskInfo.o());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().a(paramUFTC2CUploadTaskInfo.a());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).g().a(paramUFTC2CUploadTaskInfo.p());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).h().a(false);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).h().a(paramC2CUploadSrvBusiProp.q());
    paramUFTC2CUploadTaskInfo = new ArrayList();
    int i = UFTDependFeatureApi.a(this.g, this.a, 1, paramUFTC2CUploadTaskInfo);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject).h().a(paramUFTC2CUploadTaskInfo);
    if ((i != 2) && (i != 3))
    {
      paramC2CUploadSrvBusiProp.b(false);
    }
    else
    {
      paramC2CUploadSrvBusiProp.b(true);
      paramC2CUploadSrvBusiProp.c(false);
      if (i == 3) {
        paramC2CUploadSrvBusiProp.c(true);
      }
    }
    paramC2CUploadSrvBusiProp.a(false);
    this.c = UFTFileTransferFactory.a(this.g, (UFTFileUploaderProp.ExtfFUperProp)localObject);
    if (this.c == null)
    {
      paramUFTC2CUploadTaskInfo = new StringBuilder();
      paramUFTC2CUploadTaskInfo.append("TId[");
      paramUFTC2CUploadTaskInfo.append(i());
      paramUFTC2CUploadTaskInfo.append("] upload error. cannot create extf uploader");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
      c("file extf uploader can not create");
      return 9045;
    }
    this.c.a(this);
    if (!this.c.a(0L))
    {
      paramUFTC2CUploadTaskInfo = new StringBuilder();
      paramUFTC2CUploadTaskInfo.append("TId[");
      paramUFTC2CUploadTaskInfo.append(i());
      paramUFTC2CUploadTaskInfo.append("] upload error. extf uploader start fail");
      UFTLog.d("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, paramUFTC2CUploadTaskInfo.toString());
      c("run extf upload file fail");
      return 9360;
    }
    return 0;
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    if ((paramUploadFileOpRetData.f() != null) && ((paramUploadFileOpRetData.f() instanceof ExcitingTransferUploadResultRp))) {
      this.f = ((ExcitingTransferUploadResultRp)paramUploadFileOpRetData.f());
    }
    super.a(paramUploadFileOpRetData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public long b()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.f;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64HttpTime;
    }
    return super.b();
  }
  
  protected int c()
  {
    this.f = null;
    Object localObject = (UFTC2CUploadTaskInfo)this.h;
    this.a = ((UFTC2CUploadTaskInfo)localObject).s().a().d();
    localObject = ((UFTC2CUploadTaskInfo)localObject).l();
    if (localObject != null) {
      this.b = ((UFTUploadSrvBusiProp.C2CUploadSrvBusiProp)localObject).n();
    }
    return super.c();
  }
  
  public long d()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.f;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64TransferSpeed;
    }
    return super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfUploadFileOp
 * JD-Core Version:    0.7.0.1
 */
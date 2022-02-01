package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTHost;
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
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTTroopExtfUploadFileOp
  extends UFTTroopUploadFileOp
{
  protected boolean a = false;
  protected ExcitingTransferUploadResultRp b = null;
  
  public UFTTroopExtfUploadFileOp(AppRuntime paramAppRuntime, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTTroopUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
  }
  
  protected int a(UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTUploadSrvBusiProp.TroopUploadSrvBusiProp paramTroopUploadSrvBusiProp)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(i());
    ((StringBuilder)localObject1).append("] start troop extf upload. useIPv6:");
    ((StringBuilder)localObject1).append(this.a);
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new UFTFileUploaderProp.ExtfFUperProp();
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a(paramUFTTroopUploadTaskInfo.n());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).a(paramUFTTroopUploadTaskInfo.c());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).b(Long.valueOf(paramUFTTroopUploadTaskInfo.a()).longValue());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).d(71);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).c(102);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).b(1);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).c(Long.valueOf(paramUFTTroopUploadTaskInfo.a()).longValue());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().b(paramUFTTroopUploadTaskInfo.r().b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().a(paramUFTTroopUploadTaskInfo.r().c());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().c(paramUFTTroopUploadTaskInfo.r().e());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().d(paramUFTTroopUploadTaskInfo.r().d());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().f(paramTroopUploadSrvBusiProp.i());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().e(paramTroopUploadSrvBusiProp.k());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().b(paramUFTTroopUploadTaskInfo.o());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().a(paramUFTTroopUploadTaskInfo.b());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).g().a(paramUFTTroopUploadTaskInfo.p());
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).h().a(false);
    paramUFTTroopUploadTaskInfo = new ArrayList();
    int i = UFTDependFeatureApi.a(this.g, this.a, 3, paramUFTTroopUploadTaskInfo);
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).h().a(paramUFTTroopUploadTaskInfo);
    paramUFTTroopUploadTaskInfo = new ArrayList();
    Object localObject2 = paramTroopUploadSrvBusiProp.l();
    int j = paramTroopUploadSrvBusiProp.n();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramUFTTroopUploadTaskInfo.add(new UFTHost((String)((Iterator)localObject2).next(), j));
      }
    }
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).h().b(paramUFTTroopUploadTaskInfo);
    paramUFTTroopUploadTaskInfo = new ArrayList();
    localObject2 = paramTroopUploadSrvBusiProp.m();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramUFTTroopUploadTaskInfo.add(new UFTHost((String)((Iterator)localObject2).next(), j));
      }
    }
    ((UFTFileUploaderProp.ExtfFUperProp)localObject1).h().c(paramUFTTroopUploadTaskInfo);
    if ((i != 2) && (i != 3))
    {
      paramTroopUploadSrvBusiProp.b(false);
    }
    else
    {
      paramTroopUploadSrvBusiProp.b(true);
      paramTroopUploadSrvBusiProp.c(false);
      if (i == 3) {
        paramTroopUploadSrvBusiProp.c(true);
      }
    }
    paramTroopUploadSrvBusiProp.a(false);
    this.c = UFTFileTransferFactory.a(this.g, (UFTFileUploaderProp.ExtfFUperProp)localObject1);
    if (this.c == null)
    {
      paramUFTTroopUploadTaskInfo = new StringBuilder();
      paramUFTTroopUploadTaskInfo.append("TId[");
      paramUFTTroopUploadTaskInfo.append(i());
      paramUFTTroopUploadTaskInfo.append("] upload error. cannot create extf uploader");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
      c("file uploader cannt create");
      return 3;
    }
    this.c.a(this);
    if (!this.c.a(0L))
    {
      paramUFTTroopUploadTaskInfo = new StringBuilder();
      paramUFTTroopUploadTaskInfo.append("TId[");
      paramUFTTroopUploadTaskInfo.append(i());
      paramUFTTroopUploadTaskInfo.append("] upload error. extf uploader start fail");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTTroopUploadTaskInfo.toString());
      c("run upload file fail");
      return 4;
    }
    return 0;
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    if ((paramUploadFileOpRetData.f() != null) && ((paramUploadFileOpRetData.f() instanceof ExcitingTransferUploadResultRp))) {
      this.b = ((ExcitingTransferUploadResultRp)paramUploadFileOpRetData.f());
    }
    super.a(paramUploadFileOpRetData);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public long b()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.b;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64HttpTime;
    }
    return super.b();
  }
  
  protected int c()
  {
    this.b = null;
    this.a = ((UFTTroopUploadTaskInfo)this.h).s().a().d();
    return super.c();
  }
  
  public long d()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.b;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64TransferSpeed;
    }
    return super.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfUploadFileOp
 * JD-Core Version:    0.7.0.1
 */
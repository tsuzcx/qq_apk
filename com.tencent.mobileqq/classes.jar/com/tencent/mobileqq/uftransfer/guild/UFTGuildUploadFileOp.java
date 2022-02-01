package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.guild.file.UFTGuildUploadRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp.UFTUploadFileOpCallback;
import com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp.UploadFileOpRetData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

public class UFTGuildUploadFileOp
  extends UFTBaseUploadFileOp
{
  protected boolean a = false;
  protected ExcitingTransferUploadResultRp b = null;
  
  public UFTGuildUploadFileOp(AppRuntime paramAppRuntime, UFTGuildUploadTaskInfo paramUFTGuildUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTGuildUploadTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
  }
  
  protected int a(UFTGuildUploadTaskInfo paramUFTGuildUploadTaskInfo, UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    paramUFTGuildUploadRsp = new StringBuilder();
    paramUFTGuildUploadRsp.append("TId[");
    paramUFTGuildUploadRsp.append(i());
    paramUFTGuildUploadRsp.append("] start troop extf upload. useIPv6:");
    paramUFTGuildUploadRsp.append(this.a);
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTGuildUploadRsp.toString());
    paramUFTGuildUploadRsp = new UFTFileUploaderProp.ExtfFUperProp();
    paramUFTGuildUploadRsp.a(paramUFTGuildUploadTaskInfo.n());
    paramUFTGuildUploadRsp.a(paramUFTGuildUploadTaskInfo.h());
    paramUFTGuildUploadRsp.b(Long.parseLong(paramUFTGuildUploadTaskInfo.i()));
    paramUFTGuildUploadRsp.d(86);
    paramUFTGuildUploadRsp.c(102);
    paramUFTGuildUploadRsp.b(1);
    paramUFTGuildUploadRsp.c(Long.parseLong(paramUFTGuildUploadTaskInfo.i()));
    paramUFTGuildUploadRsp.g().b(paramUFTGuildUploadTaskInfo.r().b());
    paramUFTGuildUploadRsp.g().a(paramUFTGuildUploadTaskInfo.r().c());
    paramUFTGuildUploadRsp.g().c(paramUFTGuildUploadTaskInfo.r().e());
    paramUFTGuildUploadRsp.g().d(paramUFTGuildUploadTaskInfo.r().d());
    paramUFTGuildUploadRsp.g().f(paramUFTGuildUploadTaskInfo.j());
    paramUFTGuildUploadRsp.g().e(paramUFTGuildUploadTaskInfo.t());
    paramUFTGuildUploadRsp.g().b(paramUFTGuildUploadTaskInfo.o());
    paramUFTGuildUploadRsp.g().a(paramUFTGuildUploadTaskInfo.a());
    paramUFTGuildUploadRsp.g().a(paramUFTGuildUploadTaskInfo.p());
    paramUFTGuildUploadRsp.h().a(false);
    ArrayList localArrayList = new ArrayList();
    UFTDependFeatureApi.a(this.g, this.a, 3, localArrayList);
    paramUFTGuildUploadRsp.h().a(localArrayList);
    localArrayList = new ArrayList();
    Object localObject = paramUFTGuildUploadTaskInfo.k();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        oidb_0xfc2.Addr localAddr = (oidb_0xfc2.Addr)((Iterator)localObject).next();
        localArrayList.add(new UFTHost(localAddr.str_ip.get(), localAddr.uint32_https_port.get()));
      }
    }
    paramUFTGuildUploadRsp.h().b(localArrayList);
    localArrayList = new ArrayList();
    paramUFTGuildUploadTaskInfo = paramUFTGuildUploadTaskInfo.l();
    if ((paramUFTGuildUploadTaskInfo != null) && (paramUFTGuildUploadTaskInfo.size() > 0))
    {
      paramUFTGuildUploadTaskInfo = paramUFTGuildUploadTaskInfo.iterator();
      while (paramUFTGuildUploadTaskInfo.hasNext())
      {
        localObject = (oidb_0xfc2.Addr)paramUFTGuildUploadTaskInfo.next();
        localArrayList.add(new UFTHost(((oidb_0xfc2.Addr)localObject).str_ip.get(), ((oidb_0xfc2.Addr)localObject).uint32_https_port.get()));
      }
    }
    paramUFTGuildUploadRsp.h().c(localArrayList);
    this.c = UFTFileTransferFactory.a(this.g, paramUFTGuildUploadRsp);
    if (this.c == null)
    {
      paramUFTGuildUploadTaskInfo = new StringBuilder();
      paramUFTGuildUploadTaskInfo.append("TId[");
      paramUFTGuildUploadTaskInfo.append(i());
      paramUFTGuildUploadTaskInfo.append("] upload error. cannot create extf uploader");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTGuildUploadTaskInfo.toString());
      c("file uploader cannt create");
      return 3;
    }
    this.c.a(this);
    if (!this.c.a(0L))
    {
      paramUFTGuildUploadTaskInfo = new StringBuilder();
      paramUFTGuildUploadTaskInfo.append("TId[");
      paramUFTGuildUploadTaskInfo.append(i());
      paramUFTGuildUploadTaskInfo.append("] upload error. extf uploader start fail");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, paramUFTGuildUploadTaskInfo.toString());
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
    Object localObject1 = (UFTGuildUploadTaskInfo)this.h;
    this.a = ((UFTGuildUploadTaskInfo)localObject1).s().a().d();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TId[");
    ((StringBuilder)localObject2).append(i());
    ((StringBuilder)localObject2).append("] do start guild upload op");
    UFTLog.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, ((StringBuilder)localObject2).toString());
    localObject2 = ((UFTGuildUploadTaskInfo)localObject1).e();
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TId[");
      ((StringBuilder)localObject1).append(i());
      ((StringBuilder)localObject1).append("] do start troop upload fail. guildUploadRsp info is null");
      UFTLog.d("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, ((StringBuilder)localObject1).toString());
      c("upload file guildUploadRsp info is null");
      return 1;
    }
    return a((UFTGuildUploadTaskInfo)localObject1, (UFTGuildUploadRsp)localObject2);
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
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadFileOp
 * JD-Core Version:    0.7.0.1
 */
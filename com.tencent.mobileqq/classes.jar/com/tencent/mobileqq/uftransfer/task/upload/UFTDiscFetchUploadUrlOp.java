package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTDiscUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.DiscUploadSrvBusiProp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTDiscFetchUploadUrlOp
  extends UFTBaseOp
{
  protected final boolean a;
  protected final boolean b;
  
  public UFTDiscFetchUploadUrlOp(AppRuntime paramAppRuntime, UFTDiscUploadTaskInfo paramUFTDiscUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTDiscUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    this.a = paramUFTDiscUploadTaskInfo.s().a().c();
    this.b = paramUFTDiscUploadTaskInfo.s().a().d();
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" cfg = useHttps:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" useIPv6:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  protected void a(UFTUploadSrvBusiProp.DiscUploadSrvBusiProp paramDiscUploadSrvBusiProp)
  {
    if (paramDiscUploadSrvBusiProp == null) {
      return;
    }
    UFTDiscUploadTaskInfo localUFTDiscUploadTaskInfo = (UFTDiscUploadTaskInfo)this.h;
    if (!TextUtils.isEmpty(paramDiscUploadSrvBusiProp.i())) {
      localUFTDiscUploadTaskInfo.b(paramDiscUploadSrvBusiProp.i());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] updateUploadTaskInfo srvBusiProp:");
    localStringBuilder.append(paramDiscUploadSrvBusiProp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, localStringBuilder.toString());
    localUFTDiscUploadTaskInfo.a(paramDiscUploadSrvBusiProp);
  }
  
  protected void a(boolean paramBoolean, UFTDiscUploadRsp paramUFTDiscUploadRsp)
  {
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    int i;
    if (!paramBoolean)
    {
      j = paramUFTDiscUploadRsp.a();
      i = j;
      if (j == 0) {
        i = 9001;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TId[");
      ((StringBuilder)localObject1).append(i());
      ((StringBuilder)localObject1).append("] request disc upload url fail. errCode:");
      ((StringBuilder)localObject1).append(i);
      UFTLog.d("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
      a(new UFTUploadSrvBusiProp.DiscUploadSrvBusiProp(paramUFTDiscUploadRsp));
      localOpRetData.a(i);
      localOpRetData.a(paramUFTDiscUploadRsp.f());
      a(localOpRetData);
      return;
    }
    if (paramUFTDiscUploadRsp.a() != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TId[");
      ((StringBuilder)localObject1).append(i());
      ((StringBuilder)localObject1).append("] request disc upload url return error. errCode:");
      ((StringBuilder)localObject1).append(paramUFTDiscUploadRsp.a());
      UFTLog.d("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
      a(new UFTUploadSrvBusiProp.DiscUploadSrvBusiProp(paramUFTDiscUploadRsp));
      localOpRetData.a(paramUFTDiscUploadRsp.a());
      localOpRetData.a(paramUFTDiscUploadRsp.f());
      a(localOpRetData);
      return;
    }
    paramBoolean = TextUtils.isEmpty(paramUFTDiscUploadRsp.d());
    boolean bool1 = TextUtils.isEmpty(paramUFTDiscUploadRsp.b());
    if (((paramBoolean ^ true)) && (bool1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TId[");
      ((StringBuilder)localObject1).append(i());
      ((StringBuilder)localObject1).append("] request disc upload url return empty uuid.");
      UFTLog.d("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
      a(new UFTUploadSrvBusiProp.DiscUploadSrvBusiProp(paramUFTDiscUploadRsp));
      localOpRetData.a(9015);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uuid_null[");
      ((StringBuilder)localObject1).append(paramUFTDiscUploadRsp.toString());
      ((StringBuilder)localObject1).append("]");
      localOpRetData.a(((StringBuilder)localObject1).toString());
      a(localOpRetData);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(i());
    ((StringBuilder)localObject1).append("] request disc upload url suc rsp:");
    ((StringBuilder)localObject1).append(paramUFTDiscUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
    int j = (short)paramUFTDiscUploadRsp.e();
    if ((this.a) && (!TextUtils.isEmpty(paramUFTDiscUploadRsp.g())))
    {
      localObject1 = paramUFTDiscUploadRsp.g();
      j = paramUFTDiscUploadRsp.h();
      i = j;
      if (j == 0) {
        i = 443;
      }
      bool1 = true;
    }
    else
    {
      i = j;
      if (j == 0) {
        i = 80;
      }
      localObject1 = null;
      bool1 = false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramUFTDiscUploadRsp.d());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(i);
    localArrayList.add(0, ((StringBuilder)localObject2).toString());
    if ((this.b) && (!TextUtils.isEmpty(paramUFTDiscUploadRsp.i())))
    {
      localObject2 = new ArrayList();
      i = UFTDependFeatureApi.a(this.g, paramUFTDiscUploadRsp.i(), i, 5, (List)localObject2);
      if (((List)localObject2).size() > 0)
      {
        if (i == 1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localArrayList.addAll(0, (Collection)localObject2);
        bool2 = true;
        break label633;
      }
    }
    boolean bool2 = false;
    paramBoolean = false;
    label633:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TId[");
    ((StringBuilder)localObject2).append(i());
    ((StringBuilder)localObject2).append("] disc upload ftn host info is :UrlHostInfo{hostList=");
    ((StringBuilder)localObject2).append(localArrayList);
    ((StringBuilder)localObject2).append(", useHttps=");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(", httpsDomain='");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append('\'');
    ((StringBuilder)localObject2).append(", useIpV6=");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append(", useDnsIpV6=");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append('}');
    UFTLog.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new UFTUploadSrvBusiProp.DiscUploadSrvBusiProp(paramUFTDiscUploadRsp);
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).a(localArrayList);
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).a("/ftn_handler");
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).a(bool1);
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).b((String)localObject1);
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).b(bool2);
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).c(paramBoolean);
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).c(paramUFTDiscUploadRsp.c());
    ((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2).d(UFTDependFeatureApi.b(((UFTDiscUploadTaskInfo)this.h).r().e()));
    a((UFTUploadSrvBusiProp.DiscUploadSrvBusiProp)localObject2);
    localOpRetData.a(0);
    a(localOpRetData);
  }
  
  protected boolean a(UFTDiscUploadReq paramUFTDiscUploadReq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] request disc upload url.");
    UFTLog.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, localStringBuilder.toString());
    return UFTProtoRequestor.a().a(this.g, paramUFTDiscUploadReq, new UFTDiscFetchUploadUrlOp.1(this));
  }
  
  protected int c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] do fetch disc upload url op.");
    ((StringBuilder)localObject).append(a());
    UFTLog.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTDiscUploadTaskInfo)this.h;
    UFTDiscUploadReq localUFTDiscUploadReq = new UFTDiscUploadReq();
    localUFTDiscUploadReq.b(((UFTDiscUploadTaskInfo)localObject).c());
    localUFTDiscUploadReq.e(((UFTDiscUploadTaskInfo)localObject).o());
    localUFTDiscUploadReq.a(((UFTDiscUploadTaskInfo)localObject).p());
    localUFTDiscUploadReq.a(this.g.getCurrentUin());
    localUFTDiscUploadReq.c(UFTDependFeatureApi.b(((UFTDiscUploadTaskInfo)localObject).r().b()));
    localUFTDiscUploadReq.d(UFTDependFeatureApi.b(((UFTDiscUploadTaskInfo)localObject).r().e()));
    if (!a(localUFTDiscUploadReq))
    {
      c("request url fail");
      return 9001;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTDiscFetchUploadUrlOp
 * JD-Core Version:    0.7.0.1
 */
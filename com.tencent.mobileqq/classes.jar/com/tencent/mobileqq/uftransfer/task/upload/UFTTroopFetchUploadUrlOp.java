package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadReReq;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTTroopFetchUploadUrlOp
  extends UFTBaseOp
{
  protected Object a;
  protected final boolean b;
  protected final boolean c;
  protected final boolean d;
  protected final boolean e;
  
  public UFTTroopFetchUploadUrlOp(AppRuntime paramAppRuntime, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, UFTTransferKey paramUFTTransferKey, boolean paramBoolean, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTTroopUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    this.jdField_a_of_type_JavaLangObject = null;
    this.b = paramUFTTroopUploadTaskInfo.a().a().c();
    this.c = paramUFTTroopUploadTaskInfo.a().a().d();
    this.d = paramUFTTroopUploadTaskInfo.a().a().a();
    this.e = paramBoolean;
  }
  
  protected UFTTroopFetchUploadUrlOp.UrlHostInfo a(UFTTroopUploadRsp paramUFTTroopUploadRsp, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramUFTTroopUploadRsp.d());
    if (!TextUtils.isEmpty(paramUFTTroopUploadRsp.e())) {
      localArrayList.add(paramUFTTroopUploadRsp.e());
    }
    Object localObject2 = null;
    Object localObject1 = paramUFTTroopUploadRsp.e();
    if (paramBoolean) {
      localObject1 = ((UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).f();
    }
    paramBoolean = this.b;
    boolean bool2 = false;
    boolean bool1;
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = localObject1;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if ((this.c) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject1 = new ArrayList();
      int i = UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime, paramUFTTroopUploadRsp.e(), 0, 3, (List)localObject1);
      if (((List)localObject1).size() > 0)
      {
        if (i == 1)
        {
          localArrayList.removeAll((Collection)localObject1);
          paramBoolean = true;
        }
        else
        {
          paramBoolean = false;
        }
        localArrayList.addAll(0, (Collection)localObject1);
        bool2 = true;
        break label195;
      }
    }
    paramBoolean = false;
    label195:
    paramUFTTroopUploadRsp = new UFTTroopFetchUploadUrlOp.UrlHostInfo(this);
    paramUFTTroopUploadRsp.jdField_a_of_type_JavaUtilList = localArrayList;
    paramUFTTroopUploadRsp.jdField_a_of_type_Boolean = bool1;
    paramUFTTroopUploadRsp.jdField_a_of_type_JavaLangString = localObject2;
    paramUFTTroopUploadRsp.b = bool2;
    paramUFTTroopUploadRsp.c = paramBoolean;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("] troop upload ftn host info is :");
    ((StringBuilder)localObject1).append(paramUFTTroopUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
    return paramUFTTroopUploadRsp;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      UFTProtoRequestor.a().a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_JavaLangObject = null;
    }
  }
  
  protected void a(UFTUploadSrvBusiProp.TroopUploadSrvBusiProp paramTroopUploadSrvBusiProp)
  {
    if (paramTroopUploadSrvBusiProp == null) {
      return;
    }
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    if (!TextUtils.isEmpty(paramTroopUploadSrvBusiProp.e())) {
      localUFTTroopUploadTaskInfo.b(paramTroopUploadSrvBusiProp.e());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] updateUploadTaskInfo srvBusiProp:");
    localStringBuilder.append(paramTroopUploadSrvBusiProp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, localStringBuilder.toString());
    localUFTTroopUploadTaskInfo.a(paramTroopUploadSrvBusiProp);
  }
  
  protected void a(boolean paramBoolean1, UFTTroopUploadRsp paramUFTTroopUploadRsp, boolean paramBoolean2)
  {
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    if (!paramBoolean1)
    {
      int j = paramUFTTroopUploadRsp.a();
      int i = j;
      if (j == 0) {
        i = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] request troop upload url fail. errCode:");
      ((StringBuilder)localObject).append(i);
      UFTLog.d("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      a(new UFTUploadSrvBusiProp.TroopUploadSrvBusiProp(paramUFTTroopUploadRsp));
      localOpRetData.a(i);
      localOpRetData.a(paramUFTTroopUploadRsp.a());
      localOpRetData.b(paramUFTTroopUploadRsp.b());
      a(localOpRetData);
      return;
    }
    if (paramUFTTroopUploadRsp.a() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] request troop upload url return error. errCode:");
      ((StringBuilder)localObject).append(paramUFTTroopUploadRsp.a());
      UFTLog.d("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      localOpRetData.a(paramUFTTroopUploadRsp.a());
      localOpRetData.a(paramUFTTroopUploadRsp.a());
      localOpRetData.b(paramUFTTroopUploadRsp.b());
      a(new UFTUploadSrvBusiProp.TroopUploadSrvBusiProp(paramUFTTroopUploadRsp));
      a(localOpRetData);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] request troop upload url suc rsp:");
    ((StringBuilder)localObject).append(paramUFTTroopUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTUploadSrvBusiProp.TroopUploadSrvBusiProp(paramUFTTroopUploadRsp);
    if (!this.d)
    {
      UFTTroopFetchUploadUrlOp.UrlHostInfo localUrlHostInfo = a(paramUFTTroopUploadRsp, paramBoolean2);
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).a(localUrlHostInfo.jdField_a_of_type_Boolean);
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).b(localUrlHostInfo.jdField_a_of_type_JavaLangString);
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).a(localUrlHostInfo.jdField_a_of_type_JavaUtilList);
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).a("/ftn_handler");
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).b(localUrlHostInfo.b);
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).c(UFTDependFeatureApi.a(paramUFTTroopUploadRsp.a()));
      ((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject).d(UFTDependFeatureApi.b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d()));
    }
    a((UFTUploadSrvBusiProp.TroopUploadSrvBusiProp)localObject);
    localOpRetData.a(0);
    localOpRetData.a(paramUFTTroopUploadRsp.a());
    localOpRetData.b(paramUFTTroopUploadRsp.b());
    a(localOpRetData);
  }
  
  protected boolean a(UFTTroopUploadReReq paramUFTTroopUploadReReq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] request troop re upload url.");
    UFTLog.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangObject = UFTProtoRequestor.a().a(this.jdField_a_of_type_MqqAppAppRuntime, paramUFTTroopUploadReReq, new UFTTroopFetchUploadUrlOp.2(this));
    return this.jdField_a_of_type_JavaLangObject != null;
  }
  
  protected boolean a(UFTTroopUploadReq paramUFTTroopUploadReq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] request troop upload url.");
    UFTLog.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangObject = UFTProtoRequestor.a().a(this.jdField_a_of_type_MqqAppAppRuntime, paramUFTTroopUploadReq, new UFTTroopFetchUploadUrlOp.1(this));
    return this.jdField_a_of_type_JavaLangObject != null;
  }
  
  protected int b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("] do fetch troop upload url op.");
    ((StringBuilder)localObject1).append(b());
    UFTLog.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
    localObject1 = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    Object localObject2;
    boolean bool;
    if (this.e)
    {
      localObject2 = new UFTTroopUploadReReq();
      ((UFTTroopUploadReReq)localObject2).a(((UFTTroopUploadTaskInfo)localObject1).b());
      ((UFTTroopUploadReReq)localObject2).a(((UFTTroopUploadTaskInfo)localObject1).a().d());
      ((UFTTroopUploadReReq)localObject2).a(((UFTTroopUploadTaskInfo)localObject1).b());
      ((UFTTroopUploadReReq)localObject2).a(Long.valueOf(((UFTTroopUploadTaskInfo)localObject1).c()).longValue());
      bool = a((UFTTroopUploadReReq)localObject2);
    }
    else
    {
      localObject2 = new UFTTroopUploadReq();
      ((UFTTroopUploadReq)localObject2).a(((UFTTroopUploadTaskInfo)localObject1).b());
      ((UFTTroopUploadReq)localObject2).a(((UFTTroopUploadTaskInfo)localObject1).a().b());
      ((UFTTroopUploadReq)localObject2).b(((UFTTroopUploadTaskInfo)localObject1).a().d());
      ((UFTTroopUploadReq)localObject2).c(((UFTTroopUploadTaskInfo)localObject1).a().c());
      ((UFTTroopUploadReq)localObject2).b(((UFTTroopUploadTaskInfo)localObject1).c());
      ((UFTTroopUploadReq)localObject2).a(this.d);
      ((UFTTroopUploadReq)localObject2).b(((UFTTroopUploadTaskInfo)localObject1).b());
      ((UFTTroopUploadReq)localObject2).b(((UFTTroopUploadTaskInfo)localObject1).a());
      ((UFTTroopUploadReq)localObject2).c(((UFTTroopUploadTaskInfo)localObject1).d());
      ((UFTTroopUploadReq)localObject2).a(((UFTTroopUploadTaskInfo)localObject1).e());
      ((UFTTroopUploadReq)localObject2).a(Long.valueOf(((UFTTroopUploadTaskInfo)localObject1).c()).longValue());
      bool = a((UFTTroopUploadReq)localObject2);
    }
    if (!bool)
    {
      c("request url fail");
      return 1;
    }
    return 0;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" cfg = useHttps:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" useIPv6:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" useExtf:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" reUpload:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopFetchUploadUrlOp
 * JD-Core Version:    0.7.0.1
 */
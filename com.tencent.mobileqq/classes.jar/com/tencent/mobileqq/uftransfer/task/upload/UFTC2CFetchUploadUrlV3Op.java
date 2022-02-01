package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import mqq.app.AppRuntime;

public class UFTC2CFetchUploadUrlV3Op
  extends UFTC2CFetchUploadUrlOp
{
  protected boolean f = false;
  
  public UFTC2CFetchUploadUrlV3Op(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    if (this.d) {
      this.f = paramUFTC2CUploadTaskInfo.a().a().f();
    }
  }
  
  protected int a(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    int i = super.a(paramUFTC2CUploadReq);
    if (i != 0) {
      return i;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    paramUFTC2CUploadReq.e(localUFTC2CUploadTaskInfo.a().c());
    paramUFTC2CUploadReq.d(localUFTC2CUploadTaskInfo.a().d());
    paramUFTC2CUploadReq.c(localUFTC2CUploadTaskInfo.a().b());
    paramUFTC2CUploadReq.a(this.f);
    return i;
  }
  
  protected void a(UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] request c2c upload url v3 suc rsp:");
    ((StringBuilder)localObject).append(paramUFTC2CUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlV3Op", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTBaseOp.OpRetData();
    ((UFTBaseOp.OpRetData)localObject).a(0);
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = new UFTUploadSrvBusiProp.C2CUploadSrvBusiProp(paramUFTC2CUploadRsp);
    if (paramUFTC2CUploadRsp.a())
    {
      localC2CUploadSrvBusiProp.d(true);
      a(localC2CUploadSrvBusiProp);
      ((UFTBaseOp.OpRetData)localObject).a(paramUFTC2CUploadRsp.a());
      ((UFTBaseOp.OpRetData)localObject).a(paramUFTC2CUploadRsp.a());
      a((UFTBaseOp.OpRetData)localObject);
      return;
    }
    if (!this.d)
    {
      UFTC2CFetchUploadUrlOp.UrlHostInfo localUrlHostInfo = a(paramUFTC2CUploadRsp);
      String str = UFTDependFeatureApi.a(paramUFTC2CUploadRsp.b());
      if (paramUFTC2CUploadRsp.b() == 1)
      {
        paramUFTC2CUploadRsp = new StringBuilder();
        paramUFTC2CUploadRsp.append("/?ver=2&ukey=");
        paramUFTC2CUploadRsp.append(str);
        paramUFTC2CUploadRsp.append("&filekey=");
        paramUFTC2CUploadRsp.append(this.jdField_a_of_type_JavaLangString);
        paramUFTC2CUploadRsp.append("&filesize=");
        paramUFTC2CUploadRsp.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
        paramUFTC2CUploadRsp = paramUFTC2CUploadRsp.toString();
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.jdField_a_of_type_Boolean);
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.jdField_a_of_type_JavaLangString);
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.jdField_a_of_type_JavaUtilList);
        localC2CUploadSrvBusiProp.a(paramUFTC2CUploadRsp);
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.b);
      }
      else if (paramUFTC2CUploadRsp.b() == 2)
      {
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.jdField_a_of_type_Boolean);
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.jdField_a_of_type_JavaLangString);
        localC2CUploadSrvBusiProp.a(localUrlHostInfo.jdField_a_of_type_JavaUtilList);
        localC2CUploadSrvBusiProp.a("/ftn_handler");
        localC2CUploadSrvBusiProp.b(localUrlHostInfo.b);
        localC2CUploadSrvBusiProp.d(str);
        if (TextUtils.isEmpty(localC2CUploadSrvBusiProp.c())) {
          localC2CUploadSrvBusiProp.c(UFTDependFeatureApi.b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d()));
        }
      }
      else
      {
        ((UFTBaseOp.OpRetData)localObject).a(9045);
        ((UFTBaseOp.OpRetData)localObject).a("upload rsp param error. svr api ver no support");
      }
    }
    a(localC2CUploadSrvBusiProp);
    a((UFTBaseOp.OpRetData)localObject);
  }
  
  protected boolean a(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] request c2c upload url v3.");
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlV3Op", 1, localStringBuilder.toString());
    return UFTProtoRequestor.a().c(this.jdField_a_of_type_MqqAppAppRuntime, paramUFTC2CUploadReq, new UFTC2CFetchUploadUrlV3Op.1(this));
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.b());
    localStringBuilder.append(" useMediaPat:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CFetchUploadUrlV3Op
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

public class UFTDiscUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private final UFTDiscUploadInfo jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo;
  private UFTUploadSrvBusiProp.DiscUploadSrvBusiProp jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$DiscUploadSrvBusiProp;
  
  private UFTDiscUploadTaskInfo(long paramLong, int paramInt, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo = paramUFTDiscUploadInfo;
    a(UFTDependFeatureApi.a(paramUFTDiscUploadInfo.a()));
    paramUFTDiscUploadInfo = new File(paramUFTDiscUploadInfo.a());
    if (paramUFTDiscUploadInfo.exists()) {
      a(paramUFTDiscUploadInfo.length());
    }
  }
  
  public static UFTDiscUploadTaskInfo a(long paramLong, int paramInt, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTDiscUploadInfo == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramUFTDiscUploadInfo.b()))
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("TId[");
      paramUFTDiscUploadInfo.append(paramLong);
      paramUFTDiscUploadInfo.append("] create task info fail. peer uin is null");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTaskInfo", 1, paramUFTDiscUploadInfo.toString());
      return null;
    }
    return new UFTDiscUploadTaskInfo(paramLong, paramInt, paramUFTDiscUploadInfo, paramUFTTransferConfig);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo.a();
  }
  
  public UFTUploadSrvBusiProp.DiscUploadSrvBusiProp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$DiscUploadSrvBusiProp;
  }
  
  public void a(UFTUploadSrvBusiProp.DiscUploadSrvBusiProp paramDiscUploadSrvBusiProp)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$DiscUploadSrvBusiProp = paramDiscUploadSrvBusiProp;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo.a();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo.a();
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTDiscUploadInfo.b();
  }
  
  public String e()
  {
    UFTUploadSrvBusiProp.DiscUploadSrvBusiProp localDiscUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$DiscUploadSrvBusiProp;
    if (localDiscUploadSrvBusiProp != null) {
      return localDiscUploadSrvBusiProp.f();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTDiscUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */
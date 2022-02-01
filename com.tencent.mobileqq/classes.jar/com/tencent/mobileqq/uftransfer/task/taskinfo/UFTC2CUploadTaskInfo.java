package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

public class UFTC2CUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private final UFTC2CUploadInfo jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo;
  private UFTUploadSrvBusiProp.C2CUploadSrvBusiProp jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp;
  
  private UFTC2CUploadTaskInfo(long paramLong, int paramInt, UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo = paramUFTC2CUploadInfo;
    a(UFTDependFeatureApi.a(paramUFTC2CUploadInfo.a()));
    paramUFTC2CUploadInfo = new File(paramUFTC2CUploadInfo.a());
    if (paramUFTC2CUploadInfo.exists()) {
      a(paramUFTC2CUploadInfo.length());
    }
  }
  
  public static UFTC2CUploadTaskInfo a(long paramLong, int paramInt, UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTC2CUploadInfo == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramUFTC2CUploadInfo.b()))
    {
      paramUFTC2CUploadInfo = new StringBuilder();
      paramUFTC2CUploadInfo.append("TId[");
      paramUFTC2CUploadInfo.append(paramLong);
      paramUFTC2CUploadInfo.append("] create task info fail. peer uin is null");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTaskInfo", 1, paramUFTC2CUploadInfo.toString());
      return null;
    }
    return new UFTC2CUploadTaskInfo(paramLong, paramInt, paramUFTC2CUploadInfo, paramUFTTransferConfig);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.a();
  }
  
  public UFTUploadSrvBusiProp.C2CUploadSrvBusiProp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp;
  }
  
  public void a(UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp = paramC2CUploadSrvBusiProp;
  }
  
  public boolean a()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.e();
    }
    return false;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.a();
  }
  
  public boolean b()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.d();
    }
    return false;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.a();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.a();
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.b();
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTC2CUploadInfo.c();
  }
  
  public String f()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.e();
    }
    return "";
  }
  
  public String g()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$C2CUploadSrvBusiProp;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.f();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */
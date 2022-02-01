package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

public class UFTTroopUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private int jdField_a_of_type_Int;
  private UFTTroopUploadInfo jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo;
  private UFTUploadSrvBusiProp.TroopUploadSrvBusiProp jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$TroopUploadSrvBusiProp;
  
  private UFTTroopUploadTaskInfo(long paramLong, int paramInt, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo = paramUFTTroopUploadInfo;
    a(UFTDependFeatureApi.a(paramUFTTroopUploadInfo.a()));
    paramUFTTransferConfig = new File(paramUFTTroopUploadInfo.a());
    if (paramUFTTransferConfig.exists()) {
      a(paramUFTTransferConfig.length());
    }
    this.jdField_a_of_type_Int = paramUFTTroopUploadInfo.b();
  }
  
  public static UFTTroopUploadTaskInfo a(long paramLong, int paramInt, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTTroopUploadInfo == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramUFTTroopUploadInfo.b()))
    {
      paramUFTTroopUploadInfo = new StringBuilder();
      paramUFTTroopUploadInfo.append("TId[");
      paramUFTTroopUploadInfo.append(paramLong);
      paramUFTTroopUploadInfo.append("] create task info fail. peer uin is null");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTaskInfo", 1, paramUFTTroopUploadInfo.toString());
      return null;
    }
    return new UFTTroopUploadTaskInfo(paramLong, paramInt, paramUFTTroopUploadInfo, paramUFTTransferConfig);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.a();
  }
  
  public UFTUploadSrvBusiProp.TroopUploadSrvBusiProp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$TroopUploadSrvBusiProp;
  }
  
  public void a(UFTUploadSrvBusiProp.TroopUploadSrvBusiProp paramTroopUploadSrvBusiProp)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$TroopUploadSrvBusiProp = paramTroopUploadSrvBusiProp;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.a();
  }
  
  public byte[] a()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$TroopUploadSrvBusiProp;
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.c();
    }
    return null;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.c();
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.b();
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.a();
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.c();
  }
  
  public String f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiUFTTroopUploadInfo.e();
  }
  
  public String g()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$TroopUploadSrvBusiProp;
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.f();
    }
    return "";
  }
  
  public String h()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadSrvBusiProp$TroopUploadSrvBusiProp;
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.g();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */
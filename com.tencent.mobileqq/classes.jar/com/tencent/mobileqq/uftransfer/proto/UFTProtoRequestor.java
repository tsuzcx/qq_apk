package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.uftransfer.depend.proto.UFTPbProtoRequestor;
import com.tencent.mobileqq.uftransfer.depend.proto.UFTTroopPbProtoRequestor;
import mqq.app.AppRuntime;

public class UFTProtoRequestor
{
  static UFTProtoRequestor jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTProtoRequestor;
  private final UFTPbProtoRequestor jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor = new UFTPbProtoRequestor();
  private final UFTTroopPbProtoRequestor jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTTroopPbProtoRequestor = new UFTTroopPbProtoRequestor();
  
  public static UFTProtoRequestor a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTProtoRequestor == null) {
        jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTProtoRequestor = new UFTProtoRequestor();
      }
      UFTProtoRequestor localUFTProtoRequestor = jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTProtoRequestor;
      return localUFTProtoRequestor;
    }
    finally {}
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -100002) || (paramInt == -100001) || (paramInt == -100003) || (paramInt == -1) || (paramInt == 9043) || (paramInt == 9045) || (paramInt == 9001);
  }
  
  public Object a(AppRuntime paramAppRuntime, UFTTroopUploadReReq paramUFTTroopUploadReReq, UFTProtoRequestor.TroopReqUploadResponseCallback paramTroopReqUploadResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTTroopPbProtoRequestor.a(paramAppRuntime, paramUFTTroopUploadReReq, paramTroopReqUploadResponseCallback);
  }
  
  public Object a(AppRuntime paramAppRuntime, UFTTroopUploadReq paramUFTTroopUploadReq, UFTProtoRequestor.TroopReqUploadResponseCallback paramTroopReqUploadResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTTroopPbProtoRequestor.a(paramAppRuntime, paramUFTTroopUploadReq, paramTroopReqUploadResponseCallback);
  }
  
  public void a(AppRuntime paramAppRuntime, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTTroopPbProtoRequestor.a(paramAppRuntime, paramObject);
  }
  
  public boolean a(AppRuntime paramAppRuntime, UFTC2CSetUploadSucReq paramUFTC2CSetUploadSucReq, UFTProtoRequestor.C2CSetUploadSucResponseCallback paramC2CSetUploadSucResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor.a(paramAppRuntime, paramUFTC2CSetUploadSucReq, paramC2CSetUploadSucResponseCallback);
  }
  
  public boolean a(AppRuntime paramAppRuntime, UFTC2CUploadReq paramUFTC2CUploadReq, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor.a(paramAppRuntime, paramUFTC2CUploadReq, paramC2CReqUploadResponseCallback);
  }
  
  public boolean a(AppRuntime paramAppRuntime, UFTDiscUploadReq paramUFTDiscUploadReq, UFTProtoRequestor.DiscReqUploadResponseCallback paramDiscReqUploadResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor.a(paramAppRuntime, paramUFTDiscUploadReq, paramDiscReqUploadResponseCallback);
  }
  
  public boolean b(AppRuntime paramAppRuntime, UFTC2CUploadReq paramUFTC2CUploadReq, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor.b(paramAppRuntime, paramUFTC2CUploadReq, paramC2CReqUploadResponseCallback);
  }
  
  public boolean c(AppRuntime paramAppRuntime, UFTC2CUploadReq paramUFTC2CUploadReq, UFTProtoRequestor.C2CReqUploadResponseCallback paramC2CReqUploadResponseCallback)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferDependProtoUFTPbProtoRequestor.c(paramAppRuntime, paramUFTC2CUploadReq, paramC2CReqUploadResponseCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor
 * JD-Core Version:    0.7.0.1
 */
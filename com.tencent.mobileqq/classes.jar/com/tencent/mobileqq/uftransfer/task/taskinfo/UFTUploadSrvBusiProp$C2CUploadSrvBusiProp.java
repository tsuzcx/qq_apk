package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;

public class UFTUploadSrvBusiProp$C2CUploadSrvBusiProp
  extends UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
{
  protected final UFTC2CUploadRsp a;
  private String a;
  protected boolean a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  
  public UFTUploadSrvBusiProp$C2CUploadSrvBusiProp(UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp = paramUFTC2CUploadRsp;
    paramUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (paramUFTC2CUploadRsp != null)
    {
      this.jdField_b_of_type_Boolean = paramUFTC2CUploadRsp.a();
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp.c() != null) && (this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp.c().length > 0)) {
        this.jdField_b_of_type_JavaLangString = UFTDependFeatureApi.b(this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp.c());
      }
    }
  }
  
  public int a()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.b();
    }
    return 0;
  }
  
  public byte[] a()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.a();
    }
    return null;
  }
  
  public byte[] b()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.c();
    }
    return null;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public byte[] c()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.b();
    }
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public byte[] d()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.e();
    }
    return null;
  }
  
  public String e()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.e();
    }
    return "";
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] e()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.d();
    }
    return null;
  }
  
  public String f()
  {
    UFTC2CUploadRsp localUFTC2CUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localUFTC2CUploadRsp != null) {
      return localUFTC2CUploadRsp.a();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C2CUploadSrvBusiProp{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("fileExist=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", strCheckSum='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSHA='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", useMediaPlatform=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", uploadRsp=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTC2CUploadRsp;
    if (localObject != null) {
      localObject = ((UFTC2CUploadRsp)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */
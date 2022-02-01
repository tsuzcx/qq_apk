package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.uftransfer.proto.UFTDiscUploadRsp;

public class UFTUploadSrvBusiProp$DiscUploadSrvBusiProp
  extends UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
{
  private UFTDiscUploadRsp jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTDiscUploadRsp;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public UFTUploadSrvBusiProp$DiscUploadSrvBusiProp(UFTDiscUploadRsp paramUFTDiscUploadRsp)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTDiscUploadRsp = paramUFTDiscUploadRsp;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public String e()
  {
    UFTDiscUploadRsp localUFTDiscUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTDiscUploadRsp;
    if (localUFTDiscUploadRsp != null) {
      return localUFTDiscUploadRsp.a();
    }
    return "";
  }
  
  public String f()
  {
    UFTDiscUploadRsp localUFTDiscUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTDiscUploadRsp;
    if (localUFTDiscUploadRsp != null) {
      return localUFTDiscUploadRsp.d();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscUploadSrvBusiProp{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("strCheckSum='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSHA='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadRsp=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTDiscUploadRsp;
    if (localObject != null) {
      localObject = ((UFTDiscUploadRsp)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.DiscUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */
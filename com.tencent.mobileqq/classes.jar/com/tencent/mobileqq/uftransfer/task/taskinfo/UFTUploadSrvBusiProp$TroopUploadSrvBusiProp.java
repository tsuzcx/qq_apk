package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp;
import java.util.List;

public class UFTUploadSrvBusiProp$TroopUploadSrvBusiProp
  extends UFTUploadSrvBusiProp.BaseUploadSrvBusiProp
{
  private UFTTroopUploadRsp jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  
  public UFTUploadSrvBusiProp$TroopUploadSrvBusiProp(UFTTroopUploadRsp paramUFTTroopUploadRsp)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp = paramUFTTroopUploadRsp;
  }
  
  public int a()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.b();
    }
    return 0;
  }
  
  public byte[] a()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.a();
    }
    return null;
  }
  
  public List<String> b()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.a();
    }
    return null;
  }
  
  public byte[] b()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if ((localUFTTroopUploadRsp != null) && (!TextUtils.isEmpty(localUFTTroopUploadRsp.c()))) {
      return this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp.c().getBytes();
    }
    return null;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> c()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.b();
    }
    return null;
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public byte[] c()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.a();
    }
    return null;
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
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.c();
    }
    return "";
  }
  
  public String f()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.d();
    }
    return "";
  }
  
  public String g()
  {
    UFTTroopUploadRsp localUFTTroopUploadRsp = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localUFTTroopUploadRsp != null) {
      return localUFTTroopUploadRsp.e();
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopUploadSrvBusiProp{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("fileExist=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", strCheckSum='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strSHA='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uploadRsp=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferProtoUFTTroopUploadRsp;
    if (localObject != null) {
      localObject = ((UFTTroopUploadRsp)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp
 * JD-Core Version:    0.7.0.1
 */
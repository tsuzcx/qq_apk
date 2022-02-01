package com.tencent.mobileqq.extendfriend.network;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import expand.network.gateway.SSOUpStream;
import expand.network.gateway.SSOUpStreamHead;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ExpandReqInfo
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = 0;
  private int c = 30;
  
  public ExpandReqInfo(ExpandReqInfo.Builder paramBuilder)
  {
    this.jdField_a_of_type_Boolean = ExpandReqInfo.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangString = ExpandReqInfo.Builder.a(paramBuilder);
    this.jdField_a_of_type_ArrayOfByte = ExpandReqInfo.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = ExpandReqInfo.Builder.a(paramBuilder);
    this.b = ExpandReqInfo.Builder.b(paramBuilder);
    this.c = ExpandReqInfo.Builder.c(paramBuilder);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.c * 1000L;
  }
  
  protected String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(a());
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(b());
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(b()));
      return ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    }
    Object localObject = new gateway.SSOUpStream();
    ((gateway.SSOUpStream)localObject).head = new gateway.SSOUpStreamHead();
    ((gateway.SSOUpStream)localObject).body.set(ByteStringMicro.copyFrom(b()));
    return ((gateway.SSOUpStream)localObject).toByteArray();
  }
  
  public int b()
  {
    return this.b;
  }
  
  protected byte[] b()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExpandReqInfo
 * JD-Core Version:    0.7.0.1
 */
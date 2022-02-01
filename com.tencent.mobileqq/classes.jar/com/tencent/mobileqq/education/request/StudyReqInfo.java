package com.tencent.mobileqq.education.request;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StudyReqInfo
{
  private String a;
  private byte[] b;
  private int c = 0;
  private int d = 0;
  private int e = 30;
  private boolean f = false;
  
  public StudyReqInfo(StudyReqInfo.Builder paramBuilder)
  {
    this.f = StudyReqInfo.Builder.a(paramBuilder);
    this.a = StudyReqInfo.Builder.b(paramBuilder);
    this.b = StudyReqInfo.Builder.c(paramBuilder);
    this.c = StudyReqInfo.Builder.d(paramBuilder);
    this.d = StudyReqInfo.Builder.e(paramBuilder);
    this.e = StudyReqInfo.Builder.f(paramBuilder);
  }
  
  public byte[] a()
  {
    if (this.f)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(f());
      localOIDBSSOPkg.uint32_service_type.set(g());
      localOIDBSSOPkg.uint32_result.set(0);
      localOIDBSSOPkg.str_client_version.set(AppSetting.h());
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(e()));
      return localOIDBSSOPkg.toByteArray();
    }
    return e();
  }
  
  public long b()
  {
    return this.e * 1000L;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  protected String d()
  {
    return this.a;
  }
  
  protected byte[] e()
  {
    return this.b;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.StudyReqInfo
 * JD-Core Version:    0.7.0.1
 */
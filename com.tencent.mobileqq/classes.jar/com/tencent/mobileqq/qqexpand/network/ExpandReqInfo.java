package com.tencent.mobileqq.qqexpand.network;

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
  private String a;
  private byte[] b;
  private int c = 0;
  private int d = 0;
  private int e = 30;
  private boolean f = false;
  private boolean g = false;
  
  public ExpandReqInfo(ExpandReqInfo.Builder paramBuilder)
  {
    this.g = ExpandReqInfo.Builder.a(paramBuilder);
    this.f = ExpandReqInfo.Builder.b(paramBuilder);
    this.a = ExpandReqInfo.Builder.c(paramBuilder);
    this.b = ExpandReqInfo.Builder.d(paramBuilder);
    this.c = ExpandReqInfo.Builder.e(paramBuilder);
    this.d = ExpandReqInfo.Builder.f(paramBuilder);
    this.e = ExpandReqInfo.Builder.g(paramBuilder);
  }
  
  public byte[] a()
  {
    if (this.g)
    {
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(g());
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(h());
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.h());
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(f()));
      return ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    }
    Object localObject = new gateway.SSOUpStream();
    ((gateway.SSOUpStream)localObject).head = new gateway.SSOUpStreamHead();
    ((gateway.SSOUpStream)localObject).body.set(ByteStringMicro.copyFrom(f()));
    return ((gateway.SSOUpStream)localObject).toByteArray();
  }
  
  public long b()
  {
    return this.e * 1000L;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  protected String e()
  {
    return this.a;
  }
  
  protected byte[] f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public int h()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandReqInfo
 * JD-Core Version:    0.7.0.1
 */
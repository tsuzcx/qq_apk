package com.tencent.mobileqq.guild.file;

import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

public class UFTGuildPreviewThumbRsp
{
  public String a;
  public String b;
  public int c;
  public String d;
  public int e;
  public ByteStringMicro f;
  public List<oidb_0xfc2.Addr> g;
  public List<oidb_0xfc2.Addr> h;
  public List<oidb_0xfc2.Addr> i;
  public String j;
  public String k;
  public String l;
  
  public List<oidb_0xfc2.Addr> a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(ByteStringMicro paramByteStringMicro)
  {
    this.f = paramByteStringMicro;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<oidb_0xfc2.Addr> paramList)
  {
    this.g = paramList;
  }
  
  public List<oidb_0xfc2.Addr> b()
  {
    return this.i;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(List<oidb_0xfc2.Addr> paramList)
  {
    this.h = paramList;
  }
  
  public String c()
  {
    return this.k;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void c(List<oidb_0xfc2.Addr> paramList)
  {
    this.i = paramList;
  }
  
  public String d()
  {
    return this.l;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public void e(String paramString)
  {
    this.k = paramString;
  }
  
  public void f(String paramString)
  {
    this.l = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.UFTGuildPreviewThumbRsp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.guild.file;

import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

public class UFTGuildUploadRsp
{
  private String a;
  private String b;
  private int c;
  private String d;
  private int e;
  private String f;
  private byte[] g;
  private boolean h;
  private int i;
  private String j;
  private List<oidb_0xfc2.Addr> k;
  private List<oidb_0xfc2.Addr> l;
  private List<oidb_0xfc2.Addr> m;
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<oidb_0xfc2.Addr> paramList)
  {
    this.k = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.d;
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
    this.l = paramList;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void c(List<oidb_0xfc2.Addr> paramList)
  {
    this.m = paramList;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public byte[] d()
  {
    return this.g;
  }
  
  public void e(String paramString)
  {
    this.j = paramString;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public List<oidb_0xfc2.Addr> f()
  {
    return this.l;
  }
  
  public List<oidb_0xfc2.Addr> g()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.UFTGuildUploadRsp
 * JD-Core Version:    0.7.0.1
 */
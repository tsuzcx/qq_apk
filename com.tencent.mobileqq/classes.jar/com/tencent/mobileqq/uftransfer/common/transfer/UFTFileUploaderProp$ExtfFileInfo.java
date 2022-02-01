package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$ExtfFileInfo
{
  protected String a;
  protected String b;
  protected long c;
  protected byte[] d;
  protected byte[] e;
  protected byte[] f;
  protected byte[] g;
  protected byte[] h;
  protected byte[] i;
  protected String j;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    this.g = paramArrayOfByte;
  }
  
  public byte[] d()
  {
    return this.d;
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
  }
  
  public byte[] e()
  {
    return this.e;
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
  }
  
  public byte[] f()
  {
    return this.f;
  }
  
  public byte[] g()
  {
    return this.g;
  }
  
  public byte[] h()
  {
    return this.h;
  }
  
  public byte[] i()
  {
    return this.i;
  }
  
  public boolean j()
  {
    if (TextUtils.isEmpty(this.a))
    {
      this.j = "filePath is empty";
      return false;
    }
    return true;
  }
  
  public String k()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFileInfo
 * JD-Core Version:    0.7.0.1
 */
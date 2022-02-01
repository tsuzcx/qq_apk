package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$FtnFUperProp
{
  protected long a;
  protected int b;
  protected String c;
  protected String d;
  protected boolean e = false;
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.c))
    {
      this.d = "strFilePath is empty";
      return false;
    }
    return true;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnFUperProp
 * JD-Core Version:    0.7.0.1
 */
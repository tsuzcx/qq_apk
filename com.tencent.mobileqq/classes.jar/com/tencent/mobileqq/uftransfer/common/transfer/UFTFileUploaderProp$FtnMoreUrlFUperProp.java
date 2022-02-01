package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$FtnMoreUrlFUperProp
  extends UFTFileUploaderProp.FtnMoreUrlFUperPropV1
{
  protected String c;
  protected String d;
  protected String e;
  
  public boolean a()
  {
    if (!super.a()) {
      return false;
    }
    if (TextUtils.isEmpty(this.c))
    {
      this.b = "strCheckSum is empty";
      return false;
    }
    if (TextUtils.isEmpty(this.d))
    {
      this.b = "strSHA is empty";
      return false;
    }
    return true;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp
 * JD-Core Version:    0.7.0.1
 */
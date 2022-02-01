package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$FtnMoreUrlFUperProp
  extends UFTFileUploaderProp.FtnMoreUrlFUperPropV1
{
  protected String f;
  protected String g;
  protected String h;
  
  public boolean a()
  {
    if (!super.a()) {
      return false;
    }
    if (TextUtils.isEmpty(this.f))
    {
      this.d = "strCheckSum is empty";
      return false;
    }
    if (TextUtils.isEmpty(this.g))
    {
      this.d = "strSHA is empty";
      return false;
    }
    return true;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperProp
 * JD-Core Version:    0.7.0.1
 */
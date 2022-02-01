package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$FtnOneUrlFUperProp
  extends UFTFileUploaderProp.FtnOneUrlFUperPropV1
{
  protected String c;
  protected String d;
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnOneUrlFUperProp
 * JD-Core Version:    0.7.0.1
 */
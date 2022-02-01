package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTFileUploaderProp$FtnOneUrlFUperPropV1
  extends UFTFileUploaderProp.FtnFUperProp
{
  protected String e;
  
  public boolean a()
  {
    if (!super.a()) {
      return false;
    }
    if (TextUtils.isEmpty(this.e))
    {
      this.b = "strUrl is empty";
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnOneUrlFUperPropV1
 * JD-Core Version:    0.7.0.1
 */
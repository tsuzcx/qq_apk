package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

public class UFTFtnUploader$UperProp
{
  protected int a;
  protected long a;
  protected String a;
  protected boolean a;
  protected int b;
  protected String b;
  protected String c;
  protected String d;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      UFTLog.d("[UFTTransfer] UFTFtnDataUploader", 1, "strCheckSum is empty");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      UFTLog.d("[UFTTransfer] UFTFtnDataUploader", 1, "strSHA is empty");
      return false;
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnUploader.UperProp
 * JD-Core Version:    0.7.0.1
 */
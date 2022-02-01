package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;
import java.util.List;

public class UFTFileUploaderProp$FtnMoreUrlFUperPropV1
  extends UFTFileUploaderProp.FtnFUperProp
{
  protected List<String> a;
  protected boolean b;
  protected String f;
  protected String g;
  
  public List<String> a()
  {
    return this.a;
  }
  
  public void a(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public boolean a()
  {
    if (!super.a()) {
      return false;
    }
    List localList = this.a;
    if ((localList != null) && (localList.size() != 0))
    {
      if (TextUtils.isEmpty(this.f))
      {
        this.jdField_b_of_type_JavaLangString = "urlParams is empty";
        return false;
      }
      return true;
    }
    this.jdField_b_of_type_JavaLangString = "lstUrl is empty";
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void e(String paramString)
  {
    this.f = paramString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.g = paramString;
  }
  
  public String g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperPropV1
 * JD-Core Version:    0.7.0.1
 */
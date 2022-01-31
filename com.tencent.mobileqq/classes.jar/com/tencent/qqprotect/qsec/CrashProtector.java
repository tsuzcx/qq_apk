package com.tencent.qqprotect.qsec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;

public class CrashProtector
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public CrashProtector(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("CPSP", 0);
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = BaseApplication.getContext().getSharedPreferences("CPSP", 0);
    this.jdField_a_of_type_Boolean = true;
    try
    {
      long l3 = ((SharedPreferences)localObject).getLong(this.jdField_a_of_type_JavaLangString, 0L);
      l1 = new Date().getTime();
      long l2 = l1 - l3;
      if (l3 != 0L)
      {
        l3 = this.jdField_a_of_type_Long;
        if ((l2 >= l3) || (l2 <= 0L)) {}
      }
    }
    catch (Exception localException1)
    {
      long l1;
      bool = false;
    }
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    catch (Exception localException2)
    {
      break label120;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong(this.jdField_a_of_type_JavaLangString, l1);
    ((SharedPreferences.Editor)localObject).commit();
    return false;
    label120:
    localException1.printStackTrace();
    return bool;
  }
  
  public void a(CrashProtector.IProtectedMethod paramIProtectedMethod)
  {
    if (paramIProtectedMethod != null)
    {
      if (a()) {
        break label22;
      }
      paramIProtectedMethod.a();
    }
    for (;;)
    {
      a();
      return;
      label22:
      paramIProtectedMethod.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CrashProtector
 * JD-Core Version:    0.7.0.1
 */
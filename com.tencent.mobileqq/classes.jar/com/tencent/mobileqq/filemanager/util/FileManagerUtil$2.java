package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import anni;
import atvf;
import atvo;
import atwe;
import bgjw;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = atvo.a(this.jdField_a_of_type_JavaLangString);
      if (bgjw.b() < l)
      {
        atvf.a(anni.a(2131703313));
        return;
      }
      atwe.b(this.jdField_a_of_type_JavaLangString);
      atvf.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692488);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      atvf.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131703313);
      return;
    }
    catch (Exception localException)
    {
      atvf.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131692487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */
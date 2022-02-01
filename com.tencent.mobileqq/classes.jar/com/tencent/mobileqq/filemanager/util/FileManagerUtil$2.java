package com.tencent.mobileqq.filemanager.util;

import amtj;
import android.content.Context;
import aszk;
import aszt;
import ataj;
import bftf;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = aszt.a(this.jdField_a_of_type_JavaLangString);
      if (bftf.b() < l)
      {
        aszk.a(amtj.a(2131703650));
        return;
      }
      ataj.b(this.jdField_a_of_type_JavaLangString);
      aszk.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692542);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      aszk.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131703650);
      return;
    }
    catch (Exception localException)
    {
      aszk.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131692541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */
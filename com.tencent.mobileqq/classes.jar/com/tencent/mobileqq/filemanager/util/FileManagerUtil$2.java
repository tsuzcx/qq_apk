package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import anzj;
import auna;
import aunj;
import aunz;
import bhjx;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = aunj.a(this.jdField_a_of_type_JavaLangString);
      if (bhjx.b() < l)
      {
        auna.a(anzj.a(2131703420));
        return;
      }
      aunz.b(this.jdField_a_of_type_JavaLangString);
      auna.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692494);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      auna.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131703420);
      return;
    }
    catch (Exception localException)
    {
      auna.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131692493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import anvx;
import audr;
import auea;
import aueq;
import bhbx;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = auea.a(this.jdField_a_of_type_JavaLangString);
      if (bhbx.b() < l)
      {
        audr.a(anvx.a(2131704001));
        return;
      }
      aueq.b(this.jdField_a_of_type_JavaLangString);
      audr.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692644);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      audr.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131704001);
      return;
    }
    catch (Exception localException)
    {
      audr.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131692643);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */
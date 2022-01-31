package com.tencent.mobileqq.filemanager.util;

import alpo;
import android.content.Context;
import armz;
import aroo;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(Context paramContext, String paramString) {}
  
  public void run()
  {
    try
    {
      aroo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      armz.b(2131692960);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      armz.a(alpo.a(2131704904));
      return;
    }
    catch (Exception localException)
    {
      armz.a(2131692959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */
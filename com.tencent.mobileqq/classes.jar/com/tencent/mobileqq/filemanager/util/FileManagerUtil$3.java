package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.Utils;

final class FileManagerUtil$3
  implements Runnable
{
  FileManagerUtil$3(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
      if (Utils.b() < l)
      {
        FMToastUtil.a(HardCodeUtil.a(2131704550));
        return;
      }
      FilePathUtil.b(this.jdField_a_of_type_JavaLangString);
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692782);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131704550);
      return;
    }
    catch (Exception localException)
    {
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131692781);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.3
 * JD-Core Version:    0.7.0.1
 */
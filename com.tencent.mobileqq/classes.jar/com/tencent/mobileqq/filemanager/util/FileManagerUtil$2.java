package com.tencent.mobileqq.filemanager.util;

import ajya;
import android.app.Activity;
import aptx;
import apvm;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      apvm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
      aptx.b(2131692878);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      aptx.a(ajya.a(2131704532));
      return;
    }
    catch (Exception localException)
    {
      aptx.a(2131692877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */
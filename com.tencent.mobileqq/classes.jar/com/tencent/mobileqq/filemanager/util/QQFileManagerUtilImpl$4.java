package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.Utils;

final class QQFileManagerUtilImpl$4
  implements Runnable
{
  QQFileManagerUtilImpl$4(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = QQFileManagerUtilImpl.a(this.jdField_a_of_type_JavaLangString);
      if (Utils.b() < l)
      {
        FMToastUtil.a(HardCodeUtil.a(2131704630));
        return;
      }
      FilePathUtil.a(this.jdField_a_of_type_JavaLangString);
      FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692740);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label55;
    }
    catch (Exception localException)
    {
      label44:
      label55:
      break label44;
    }
    FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131692739);
    return;
    FMToastUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131704630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */
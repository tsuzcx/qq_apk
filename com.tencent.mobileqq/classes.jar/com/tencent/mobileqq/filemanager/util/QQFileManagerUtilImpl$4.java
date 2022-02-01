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
      long l = QQFileManagerUtilImpl.j(this.a);
      if (Utils.c() < l)
      {
        FMToastUtil.a(HardCodeUtil.a(2131902534));
        return;
      }
      FilePathUtil.a(this.a);
      FMToastUtil.a(this.b, 2, 2131889811);
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
    FMToastUtil.a(this.b, 0, 2131889810);
    return;
    FMToastUtil.a(this.b, 0, 2131902534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */
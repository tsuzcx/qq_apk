package com.tencent.mobileqq.startup.step;

import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class InjectBitmap
  extends Step
{
  protected boolean a()
  {
    try
    {
      SafeBitmapFactory.injectBitmapHotPatch();
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("InjectBitmap", 1, "", localThrowable);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InjectBitmap
 * JD-Core Version:    0.7.0.1
 */
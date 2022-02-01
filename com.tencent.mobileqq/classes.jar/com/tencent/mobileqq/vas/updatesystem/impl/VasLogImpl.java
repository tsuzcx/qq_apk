package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.factory.api.IVasLog;

public class VasLogImpl
  implements IVasLog
{
  public void a(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public boolean a()
  {
    return QLog.isColorLevel();
  }
  
  public void b(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasLogImpl
 * JD-Core Version:    0.7.0.1
 */
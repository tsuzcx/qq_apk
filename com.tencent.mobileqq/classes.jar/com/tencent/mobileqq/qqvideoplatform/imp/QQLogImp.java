package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.qphone.base.util.QLog;

public class QQLogImp
  implements ILog
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, paramInt, paramString2);
  }
  
  public void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public void v(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.imp.QQLogImp
 * JD-Core Version:    0.7.0.1
 */
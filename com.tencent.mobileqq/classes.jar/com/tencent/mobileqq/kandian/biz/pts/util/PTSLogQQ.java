package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.pts.utils.PTSLogger;
import com.tencent.qphone.base.util.QLog;

public class PTSLogQQ
  implements PTSLogger
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 2, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", t = ");
    localStringBuilder.append(paramThrowable);
    QLog.e(paramString1, 1, localStringBuilder.toString());
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isDebug()
  {
    return false;
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", t = ");
    localStringBuilder.append(paramThrowable);
    QLog.w(paramString1, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSLogQQ
 * JD-Core Version:    0.7.0.1
 */
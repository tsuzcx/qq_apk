package com.tencent.mobileqq.litelivesdk.utils.log;

import com.tencent.qphone.base.util.QLog;

public class LogUtil
  implements LogInterface
{
  public void a(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, "tag:" + paramString1 + ",msg:" + paramString2);
  }
  
  public void b(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, "tag:" + paramString1 + ",msg:" + paramString2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, "tag:" + paramString1 + ",msg:" + paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, "tag:" + paramString1 + ",msg:" + paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, "tag:" + paramString1 + ",msg:" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.log.LogUtil
 * JD-Core Version:    0.7.0.1
 */
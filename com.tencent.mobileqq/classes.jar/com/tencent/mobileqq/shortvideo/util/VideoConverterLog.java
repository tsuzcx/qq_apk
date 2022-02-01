package com.tencent.mobileqq.shortvideo.util;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.utils.Logger;

public class VideoConverterLog
  implements Logger
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramThrowable, new Object[0]);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.VideoConverterLog
 * JD-Core Version:    0.7.0.1
 */
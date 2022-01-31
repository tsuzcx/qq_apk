package com.tencent.mobileqq.intervideo;

import com.sixgod.pluginsdk.log.ISixGodLog;
import com.tencent.qphone.base.util.QLog;

public class SixgodLog
  implements ISixGodLog
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.SixgodLog
 * JD-Core Version:    0.7.0.1
 */
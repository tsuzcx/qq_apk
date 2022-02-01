package com.tencent.mobileqq.richmediabrowser;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class QQBrowserLog
  implements IBrowserLog
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      QLog.d(paramString1, paramInt, paramString2);
    }
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      QLog.e(paramString1, paramInt, paramString2);
    }
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      QLog.i(paramString1, paramInt, paramString2);
    }
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      QLog.w(paramString1, paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.QQBrowserLog
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.kwstudio.office.base.ILog;
import com.tencent.qphone.base.util.QLog;

final class TdsReaderGlobal$LogImpl
  implements ILog
{
  public void d(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.d(localStringBuilder.toString(), 2, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.d(localStringBuilder.toString(), 2, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public int getLogLevel()
  {
    return 1;
  }
  
  public void i(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 2, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 2, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 2, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 2, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdsReaderView_");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.LogImpl
 * JD-Core Version:    0.7.0.1
 */
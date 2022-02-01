package com.tencent.mobileqq.flutter.plugin;

import com.qflutter.log.qflutter_log.QflutterLogPlugin.Log;
import com.tencent.qphone.base.util.QLog;

public class QFlutterLog
  implements QflutterLogPlugin.Log
{
  private String a;
  
  public QFlutterLog(String paramString)
  {
    this.a = paramString;
    paramString = new StringBuilder();
    paramString.append("mSoPath: ");
    paramString.append(this.a);
    QLog.d("QFlutterLog", 1, paramString.toString());
  }
  
  public void d(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QFlutterLog", 4, paramString);
    }
  }
  
  public void e(String paramString)
  {
    QLog.e("QFlutterLog", 1, paramString);
  }
  
  public int getLogLevel()
  {
    if ((!QLog.isColorLevel()) && (!QLog.isDevelopLevel())) {
      return 2;
    }
    return 5;
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterLog", 2, paramString);
    }
  }
  
  public String soPath()
  {
    return this.a;
  }
  
  public void v(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterLog", 2, paramString);
    }
  }
  
  public void w(String paramString)
  {
    QLog.w("QFlutterLog", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterLog
 * JD-Core Version:    0.7.0.1
 */
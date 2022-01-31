package com.tencent.mobileqq.pluginsdk.exception;

import com.tencent.qphone.base.util.QLog;

final class a
  implements Runnable
{
  a(String paramString, Exception paramException) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a, 2, "ExceptinTracker", this.b);
    }
    throw new IllegalArgumentException(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.exception.a
 * JD-Core Version:    0.7.0.1
 */
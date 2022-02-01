package com.tencent.mobileqq.pluginsdk.exception;

import com.tencent.qphone.base.util.QLog;

final class ExceptionTracker$1
  implements Runnable
{
  ExceptionTracker$1(String paramString, Exception paramException) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.val$tag, 2, "ExceptinTracker", this.val$ex);
    }
    throw new IllegalArgumentException(this.val$ex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker.1
 * JD-Core Version:    0.7.0.1
 */
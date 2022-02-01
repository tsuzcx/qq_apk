package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

final class ExceptionTracker$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a, 2, "ExceptinTracker", this.b);
    }
    throw new IllegalArgumentException(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ExceptionTracker.1
 * JD-Core Version:    0.7.0.1
 */
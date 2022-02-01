package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

final class ExceptionTracker$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "ExceptinTracker", this.jdField_a_of_type_JavaLangException);
    }
    throw new IllegalArgumentException(this.jdField_a_of_type_JavaLangException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ExceptionTracker.1
 * JD-Core Version:    0.7.0.1
 */
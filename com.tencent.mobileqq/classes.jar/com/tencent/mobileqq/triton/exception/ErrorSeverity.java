package com.tencent.mobileqq.triton.exception;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;", "", "(Ljava/lang/String;I)V", "NONE", "MODERATE", "SEVER", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum ErrorSeverity
{
  static
  {
    ErrorSeverity localErrorSeverity1 = new ErrorSeverity("NONE", 0);
    NONE = localErrorSeverity1;
    ErrorSeverity localErrorSeverity2 = new ErrorSeverity("MODERATE", 1);
    MODERATE = localErrorSeverity2;
    ErrorSeverity localErrorSeverity3 = new ErrorSeverity("SEVER", 2);
    SEVER = localErrorSeverity3;
    $VALUES = new ErrorSeverity[] { localErrorSeverity1, localErrorSeverity2, localErrorSeverity3 };
  }
  
  private ErrorSeverity() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.exception.ErrorSeverity
 * JD-Core Version:    0.7.0.1
 */
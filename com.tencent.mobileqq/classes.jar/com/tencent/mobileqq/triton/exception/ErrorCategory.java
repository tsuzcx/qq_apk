package com.tencent.mobileqq.triton.exception;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/exception/ErrorCategory;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "INITIALIZE", "SCRIPT", "RENDER", "NATIVE", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum ErrorCategory
{
  static
  {
    ErrorCategory localErrorCategory1 = new ErrorCategory("UNKNOWN", 0);
    UNKNOWN = localErrorCategory1;
    ErrorCategory localErrorCategory2 = new ErrorCategory("INITIALIZE", 1);
    INITIALIZE = localErrorCategory2;
    ErrorCategory localErrorCategory3 = new ErrorCategory("SCRIPT", 2);
    SCRIPT = localErrorCategory3;
    ErrorCategory localErrorCategory4 = new ErrorCategory("RENDER", 3);
    RENDER = localErrorCategory4;
    ErrorCategory localErrorCategory5 = new ErrorCategory("NATIVE", 4);
    NATIVE = localErrorCategory5;
    $VALUES = new ErrorCategory[] { localErrorCategory1, localErrorCategory2, localErrorCategory3, localErrorCategory4, localErrorCategory5 };
  }
  
  private ErrorCategory() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.exception.ErrorCategory
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tmassistant.common.jce;

import java.io.Serializable;

public final class ResponseHeadErrorCode
  implements Serializable
{
  public static final ResponseHeadErrorCode EC_BUSINESS_ERROR = new ResponseHeadErrorCode(1, -11, "EC_BUSINESS_ERROR");
  public static final ResponseHeadErrorCode EC_SERVER_INTERNAL_ERROR;
  public static final int _EC_BUSINESS_ERROR = -11;
  public static final int _EC_SERVER_INTERNAL_ERROR = -10;
  private static ResponseHeadErrorCode[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    __values = new ResponseHeadErrorCode[2];
    EC_SERVER_INTERNAL_ERROR = new ResponseHeadErrorCode(0, -10, "EC_SERVER_INTERNAL_ERROR");
  }
  
  private ResponseHeadErrorCode(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static ResponseHeadErrorCode convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject = __values;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (a) {
      return null;
    }
    Object localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static ResponseHeadErrorCode convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ResponseHeadErrorCode[] arrayOfResponseHeadErrorCode = __values;
      if (i >= arrayOfResponseHeadErrorCode.length) {
        break;
      }
      if (arrayOfResponseHeadErrorCode[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    if (a) {
      return null;
    }
    paramString = new AssertionError();
    for (;;)
    {
      throw paramString;
    }
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.ResponseHeadErrorCode
 * JD-Core Version:    0.7.0.1
 */
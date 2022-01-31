package com.tencent.msf.service.protocol.security;

import java.io.Serializable;

public final class CMD_ID
  implements Serializable
{
  public static final CMD_ID CMD_ID_AUTH;
  public static final CMD_ID CMD_ID_AUTH_AND_GET_KEY;
  public static final CMD_ID CMD_ID_AUTH_MAIL;
  public static final CMD_ID CMD_ID_AUTH_MSF_ACCOUNT_LOGIN;
  public static final CMD_ID CMD_ID_AUTH_WLOGIN;
  public static final CMD_ID CMD_ID_AUTH_WLOGIN_AND_GET_KEY;
  public static final CMD_ID CMD_ID_CUSTOM_SIG;
  public static final CMD_ID CMD_ID_EMAIL_EXCHANGE_UIN;
  public static final CMD_ID CMD_ID_FETCH_VPIC_CODE;
  public static final CMD_ID CMD_ID_GET_SERVER_TIME;
  public static final CMD_ID CMD_ID_LOGGED_STAT_CUSTOM_SIG;
  public static final CMD_ID CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID;
  public static final CMD_ID CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN;
  public static final CMD_ID CMD_ID_NAME_EXCHANGE_UIN;
  public static final CMD_ID CMD_ID_REFETCH_SID;
  public static final CMD_ID CMD_ID_REFRESH_VPIC;
  public static final CMD_ID CMD_ID_REGISTQQ;
  public static final CMD_ID CMD_ID_SYNC;
  public static final CMD_ID CMD_ID_TOKEN_REQUEST;
  public static final CMD_ID CMD_ID_VERIFY_KEY;
  public static final CMD_ID CMD_ID_VERIFY_PIC;
  public static final CMD_ID CMD_ID_WB_EXCHANGE_UIN;
  public static final int _CMD_ID_AUTH = 0;
  public static final int _CMD_ID_AUTH_AND_GET_KEY = 12;
  public static final int _CMD_ID_AUTH_MAIL = 5;
  public static final int _CMD_ID_AUTH_MSF_ACCOUNT_LOGIN = 21;
  public static final int _CMD_ID_AUTH_WLOGIN = 14;
  public static final int _CMD_ID_AUTH_WLOGIN_AND_GET_KEY = 18;
  public static final int _CMD_ID_CUSTOM_SIG = 7;
  public static final int _CMD_ID_EMAIL_EXCHANGE_UIN = 10;
  public static final int _CMD_ID_FETCH_VPIC_CODE = 11;
  public static final int _CMD_ID_GET_SERVER_TIME = 15;
  public static final int _CMD_ID_LOGGED_STAT_CUSTOM_SIG = 9;
  public static final int _CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID = 20;
  public static final int _CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN = 19;
  public static final int _CMD_ID_NAME_EXCHANGE_UIN = 13;
  public static final int _CMD_ID_REFETCH_SID = 6;
  public static final int _CMD_ID_REFRESH_VPIC = 2;
  public static final int _CMD_ID_REGISTQQ = 17;
  public static final int _CMD_ID_SYNC = 4;
  public static final int _CMD_ID_TOKEN_REQUEST = 16;
  public static final int _CMD_ID_VERIFY_KEY = 3;
  public static final int _CMD_ID_VERIFY_PIC = 1;
  public static final int _CMD_ID_WB_EXCHANGE_UIN = 8;
  private static CMD_ID[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!CMD_ID.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new CMD_ID[22];
      CMD_ID_AUTH = new CMD_ID(0, 0, "CMD_ID_AUTH");
      CMD_ID_VERIFY_PIC = new CMD_ID(1, 1, "CMD_ID_VERIFY_PIC");
      CMD_ID_REFRESH_VPIC = new CMD_ID(2, 2, "CMD_ID_REFRESH_VPIC");
      CMD_ID_VERIFY_KEY = new CMD_ID(3, 3, "CMD_ID_VERIFY_KEY");
      CMD_ID_SYNC = new CMD_ID(4, 4, "CMD_ID_SYNC");
      CMD_ID_AUTH_MAIL = new CMD_ID(5, 5, "CMD_ID_AUTH_MAIL");
      CMD_ID_REFETCH_SID = new CMD_ID(6, 6, "CMD_ID_REFETCH_SID");
      CMD_ID_CUSTOM_SIG = new CMD_ID(7, 7, "CMD_ID_CUSTOM_SIG");
      CMD_ID_WB_EXCHANGE_UIN = new CMD_ID(8, 8, "CMD_ID_WB_EXCHANGE_UIN");
      CMD_ID_LOGGED_STAT_CUSTOM_SIG = new CMD_ID(9, 9, "CMD_ID_LOGGED_STAT_CUSTOM_SIG");
      CMD_ID_EMAIL_EXCHANGE_UIN = new CMD_ID(10, 10, "CMD_ID_EMAIL_EXCHANGE_UIN");
      CMD_ID_FETCH_VPIC_CODE = new CMD_ID(11, 11, "CMD_ID_FETCH_VPIC_CODE");
      CMD_ID_AUTH_AND_GET_KEY = new CMD_ID(12, 12, "CMD_ID_AUTH_AND_GET_KEY");
      CMD_ID_NAME_EXCHANGE_UIN = new CMD_ID(13, 13, "CMD_ID_NAME_EXCHANGE_UIN");
      CMD_ID_AUTH_WLOGIN = new CMD_ID(14, 14, "CMD_ID_AUTH_WLOGIN");
      CMD_ID_GET_SERVER_TIME = new CMD_ID(15, 15, "CMD_ID_GET_SERVER_TIME");
      CMD_ID_TOKEN_REQUEST = new CMD_ID(16, 16, "CMD_ID_TOKEN_REQUEST");
      CMD_ID_REGISTQQ = new CMD_ID(17, 17, "CMD_ID_REGISTQQ");
      CMD_ID_AUTH_WLOGIN_AND_GET_KEY = new CMD_ID(18, 18, "CMD_ID_AUTH_WLOGIN_AND_GET_KEY");
      CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN = new CMD_ID(19, 19, "CMD_ID_MSF_ACCOUNT_EXCHANGE_UIN");
      CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID = new CMD_ID(20, 20, "CMD_ID_MSF_ACCOUNT_EXCHANGE_MSFID");
      CMD_ID_AUTH_MSF_ACCOUNT_LOGIN = new CMD_ID(21, 21, "CMD_ID_AUTH_MSF_ACCOUNT_LOGIN");
      return;
    }
  }
  
  private CMD_ID(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static CMD_ID convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static CMD_ID convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.CMD_ID
 * JD-Core Version:    0.7.0.1
 */
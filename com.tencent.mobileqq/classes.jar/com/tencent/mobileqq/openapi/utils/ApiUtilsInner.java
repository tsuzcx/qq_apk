package com.tencent.mobileqq.openapi.utils;

import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;

public class ApiUtilsInner
{
  public static final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1073741824;
    case -1037: 
    case -1000: 
      return 1;
    case -2002: 
      return 2;
    case -2000: 
      return 8;
    case -2007: 
      return 16;
    case -2020: 
      return 32;
    case -2005: 
      return 64;
    }
    return 4;
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return 1005;
      case 1003: 
        return 1007;
      }
      return 1006;
    }
    switch (paramInt)
    {
    default: 
      return 1001;
    case -1: 
      return 1000;
    case 2003: 
      return 1003;
    }
    return 1002;
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    return a(paramQQAppInterface, PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt), paramMessageForPtt.isSendFromLocal());
  }
  
  public static final int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    }
    return 4;
  }
  
  public static final int c(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    default: 
      return 0;
    case 2: 
      return 3000;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.utils.ApiUtilsInner
 * JD-Core Version:    0.7.0.1
 */
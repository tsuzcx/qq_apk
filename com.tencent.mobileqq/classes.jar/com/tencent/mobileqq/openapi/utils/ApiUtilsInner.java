package com.tencent.mobileqq.openapi.utils;

import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;

public class ApiUtilsInner
{
  public static final int a(int paramInt)
  {
    if (paramInt != -2020)
    {
      if (paramInt != -2007)
      {
        if (paramInt != -2005)
        {
          if (paramInt != -2002)
          {
            if (paramInt != -2000)
            {
              if (paramInt != -1000) {
                switch (paramInt)
                {
                default: 
                  return 1073741824;
                case -1036: 
                case -1035: 
                  return 4;
                }
              }
              return 1;
            }
            return 8;
          }
          return 2;
        }
        return 64;
      }
      return 16;
    }
    return 32;
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return 1005;
      case 1004: 
      case 1005: 
        return 1006;
      }
      return 1007;
    }
    if (paramInt != -1)
    {
      switch (paramInt)
      {
      default: 
        return 1001;
      case 2004: 
      case 2005: 
        return 1002;
      }
      return 1003;
    }
    return 1000;
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    return a(paramQQAppInterface, PttItemBuilder.a(paramQQAppInterface, paramMessageForPtt), paramMessageForPtt.isSendFromLocal());
  }
  
  public static final int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 0;
        }
        return 2;
      }
      return 4;
    }
    return 1;
  }
  
  public static final int c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return 0;
        }
        return 1;
      }
      return 3000;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.utils.ApiUtilsInner
 * JD-Core Version:    0.7.0.1
 */
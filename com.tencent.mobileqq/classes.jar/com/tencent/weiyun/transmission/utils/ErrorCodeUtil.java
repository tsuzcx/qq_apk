package com.tencent.weiyun.transmission.utils;

import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorCodeUtil
{
  public static int getErrorCode4IOException(IOException paramIOException)
  {
    if (paramIOException == null) {}
    String str2;
    for (String str1 = null;; str1 = paramIOException.getMessage())
    {
      str2 = str1;
      if (str1 != null) {
        str2 = str1.toLowerCase();
      }
      if (!(paramIOException instanceof ConnectException)) {
        break label57;
      }
      if ((str2 == null) || (!Pattern.compile(".*network.*is.*unreachable.*").matcher(str2).matches())) {
        break;
      }
      return 1810003;
    }
    return 1830010;
    label57:
    if ((paramIOException instanceof MalformedURLException)) {
      return 1830026;
    }
    if ((paramIOException instanceof SocketTimeoutException))
    {
      if ((str2 != null) && (Pattern.compile(".*failed.*to.*connect.*").matcher(str2).matches())) {
        return 1830028;
      }
      return 1830002;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return 1830012;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return 1830013;
    }
    if ((paramIOException instanceof PortUnreachableException)) {
      return 1830014;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return 1830015;
    }
    if ((paramIOException instanceof EOFException)) {
      return 1830016;
    }
    if ((paramIOException instanceof BindException)) {
      return 1830008;
    }
    if ((paramIOException instanceof SocketException))
    {
      if (str2 == null) {
        return 1830018;
      }
      if (Pattern.compile(".*no.*route.*to.*").matcher(str2).matches()) {
        return 1830015;
      }
      if (Pattern.compile(".*etimedout.*").matcher(str2).matches()) {
        return 1830001;
      }
      if (Pattern.compile(".*socket.*is.*closed.*").matcher(str2).matches()) {
        return 1830003;
      }
      if (Pattern.compile(".*connect.*reset.*by.*peer.*").matcher(str2).matches()) {
        return 1830005;
      }
      if (Pattern.compile(".*connect.*reset.*").matcher(str2).matches()) {
        return 1830004;
      }
      if (Pattern.compile(".*broken.*pipe.*").matcher(str2).matches()) {
        return 1830006;
      }
      if (Pattern.compile(".*connection.*refused.*").matcher(str2).matches()) {
        return 1830011;
      }
      if (Pattern.compile(".*too.*many.*open.*files.*").matcher(str2).matches()) {
        return 1830007;
      }
      if (Pattern.compile(".*address.*family.*").matcher(str2).matches()) {
        return 1830009;
      }
      if (Pattern.compile(".*jvm_bind.*").matcher(str2).matches()) {
        return 1830008;
      }
    }
    else
    {
      if ((paramIOException instanceof ClosedByInterruptException)) {
        return 1830020;
      }
      if ((paramIOException instanceof AsynchronousCloseException)) {
        return 1830019;
      }
      if ((paramIOException instanceof ClosedChannelException)) {
        return 1830022;
      }
      if (str2 != null)
      {
        if (Pattern.compile(".*unexpected.*end.*of.*stream.*").matcher(str2).matches()) {
          return 1830027;
        }
        if (Pattern.compile(".*no.*space.*left.*on.*device.*").matcher(str2).matches()) {
          return 1810031;
        }
        if (Pattern.compile(".*no.*space.*available.*").matcher(str2).matches()) {
          return 1810031;
        }
      }
    }
    return 1830023;
  }
  
  public static String getErrorMsg(int paramInt)
  {
    return ErrorMessages.getErrorString(paramInt);
  }
  
  public static String getWnsErrorMsg(int paramInt, String paramString)
  {
    return null;
  }
  
  public static boolean isHttpError(int paramInt)
  {
    return (paramInt > 1829000) && (paramInt < 1829999);
  }
  
  public static boolean isNeedReLogin(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isNotLogin(int paramInt)
  {
    return false;
  }
  
  public static boolean isSessionDeprived(int paramInt)
  {
    return (paramInt == 190050) || (paramInt == 10025);
  }
  
  public static boolean isSocketError(int paramInt)
  {
    return paramInt > 1830000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.ErrorCodeUtil
 * JD-Core Version:    0.7.0.1
 */
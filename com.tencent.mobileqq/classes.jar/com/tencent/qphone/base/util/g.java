package com.tencent.qphone.base.util;

import com.tencent.msf.service.protocol.push.a.a;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
{
  public static int a(int paramInt)
  {
    return (paramInt & 0xFF) << 8 | (0xFF00 & paramInt) >> 8;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      int i = 0;
      while (i < paramString.length())
      {
        String str = Integer.toHexString(paramString.charAt(i));
        if (str.length() % 2 == 0)
        {
          localStringBuilder.append(str);
        }
        else
        {
          localStringBuilder.append("0");
          localStringBuilder.append(str);
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static InetAddress a(long paramLong)
  {
    int i = (byte)(int)(paramLong >> 24 & 0xFF);
    int j = (byte)(int)(paramLong >> 16 & 0xFF);
    int k = (byte)(int)(paramLong >> 8 & 0xFF);
    return InetAddress.getByAddress(new byte[] { (byte)(int)(paramLong & 0xFF), k, j, i });
  }
  
  public static InetAddress a(a parama)
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(parama.d);
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      label10:
      break label10;
    }
    return a(parama.a);
  }
  
  public static final long b(String paramString)
  {
    Object localObject = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3})").matcher(paramString);
    if (!((Matcher)localObject).find())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ip not match:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
      return -2L;
    }
    paramString = ((Matcher)localObject).group(1).split("\\.");
    return (Long.parseLong(paramString[3]) << 24) + (Long.parseLong(paramString[2]) << 16) + (Long.parseLong(paramString[1]) << 8) + Long.parseLong(paramString[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.g
 * JD-Core Version:    0.7.0.1
 */
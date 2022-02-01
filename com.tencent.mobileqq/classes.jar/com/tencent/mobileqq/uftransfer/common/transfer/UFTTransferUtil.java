package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;

public class UFTTransferUtil
{
  public static UFTTransferUtil.HostInfo a(String paramString)
  {
    UFTTransferUtil.HostInfo localHostInfo = new UFTTransferUtil.HostInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localHostInfo;
    }
    String str1 = null;
    String str2;
    label271:
    label278:
    do
    {
      for (;;)
      {
        try
        {
          i = paramString.indexOf("://");
          if (i != -1) {
            break label271;
          }
          i = 0;
          str2 = paramString.substring(i);
          k = str2.indexOf("/");
          int j = k;
          if (-1 == k) {
            j = str2.length() - 1;
          }
          k = paramString.indexOf("&bHost=");
          if (-1 == k) {
            break label278;
          }
          int m = paramString.indexOf("&bPort=", k);
          if (-1 == m) {
            break label278;
          }
          str1 = paramString.substring(k + 7, m);
          str2 = paramString.substring(m + 7);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          str1 = localStringBuilder.toString();
          k = 1;
          str2 = str1;
          if (str1 != null) {
            break;
          }
          str2 = paramString.substring(i, j + i);
        }
        catch (Exception paramString)
        {
          return localHostInfo;
        }
        int i = str2.indexOf(":");
        if (i >= 0)
        {
          paramString = str2.substring(0, i);
          str1 = str2.substring(i + 1);
          localHostInfo.a = paramString;
          localHostInfo.b = Integer.valueOf(str1).intValue();
        }
        else
        {
          localHostInfo.a = str2;
          localHostInfo.b = 0;
        }
        if (k != 0) {
          localHostInfo.c = 1;
        }
        return localHostInfo;
        i += 3;
        continue;
        int k = 0;
      }
    } while (str2 != null);
    return localHostInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTTransferUtil
 * JD-Core Version:    0.7.0.1
 */
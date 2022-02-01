package com.tencent.mobileqq.webview.utils;

import com.tencent.mobileqq.statistics.DcReportUtil;

public class WebViewReportUtils
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt1);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt3);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt4);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt5);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString1);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt6);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt7);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt8);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt9);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt10);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramString1 = new String[5];
      paramInt2 = Math.min(5, paramVarArgs.length);
      paramInt1 = 0;
      System.arraycopy(paramVarArgs, 0, paramString1, 0, paramInt2);
    }
    while (paramInt1 < 5)
    {
      if (paramString1[paramInt1] == null)
      {
        localStringBuffer.append("|");
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append("|");
        paramString2.append(paramString1[paramInt1]);
        localStringBuffer.append(paramString2.toString());
      }
      paramInt1 += 1;
      continue;
      localStringBuffer.append('|');
      localStringBuffer.append('|');
      localStringBuffer.append('|');
      localStringBuffer.append('|');
      localStringBuffer.append('|');
    }
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_qq_webview|qq_webview", localStringBuffer.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString3);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString4);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt1);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString5);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString6);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString7);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt3);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt4);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString8);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString9);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString10);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString11);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString12);
    DcReportUtil.a(null, "dc01183", localStringBuffer.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebViewReportUtils
 * JD-Core Version:    0.7.0.1
 */
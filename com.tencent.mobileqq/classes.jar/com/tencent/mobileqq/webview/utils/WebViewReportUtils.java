package com.tencent.mobileqq.webview.utils;

import com.tencent.mobileqq.statistics.DcReportUtil;

public class WebViewReportUtils
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt1).append('|');
    localStringBuffer.append(paramInt2).append('|');
    localStringBuffer.append(paramInt3).append('|');
    localStringBuffer.append(paramInt4).append('|');
    localStringBuffer.append(paramInt5).append('|');
    localStringBuffer.append(paramString1).append('|');
    localStringBuffer.append(paramString2).append('|');
    localStringBuffer.append(paramInt6).append('|');
    localStringBuffer.append(paramInt7).append('|');
    localStringBuffer.append(paramInt8).append('|');
    localStringBuffer.append(paramInt9).append('|');
    localStringBuffer.append(paramInt10);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramString1 = new String[5];
      System.arraycopy(paramVarArgs, 0, paramString1, 0, Math.min(5, paramVarArgs.length));
      paramInt1 = 0;
      if (paramInt1 < 5)
      {
        if (paramString1[paramInt1] == null) {
          localStringBuffer.append("|");
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          localStringBuffer.append("|" + paramString1[paramInt1]);
        }
      }
    }
    else
    {
      localStringBuffer.append('|').append('|').append('|').append('|').append('|');
    }
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_qq_webview|qq_webview", localStringBuffer.toString(), true);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, long paramLong15, long paramLong16, long paramLong17, String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramLong1).append('|');
    localStringBuffer.append(paramLong2).append('|');
    localStringBuffer.append(paramLong3).append('|');
    localStringBuffer.append(paramLong4).append('|');
    localStringBuffer.append(paramLong5).append('|');
    localStringBuffer.append(paramLong6).append('|');
    localStringBuffer.append(paramLong7).append('|');
    localStringBuffer.append(paramLong8).append('|');
    localStringBuffer.append(paramLong9).append('|');
    localStringBuffer.append(paramLong10).append('|');
    localStringBuffer.append(paramLong11).append('|');
    localStringBuffer.append(paramLong12).append('|');
    localStringBuffer.append(paramLong13).append('|');
    localStringBuffer.append(paramLong14).append('|');
    localStringBuffer.append(paramLong15).append('|');
    localStringBuffer.append(paramLong16).append('|');
    localStringBuffer.append(paramLong17).append('|');
    localStringBuffer.append(paramString1).append('|');
    localStringBuffer.append(paramString2).append('|');
    localStringBuffer.append(paramString3).append('|');
    DcReportUtil.a(null, "dc00763", localStringBuffer.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1).append('|');
    localStringBuffer.append(paramString2).append('|');
    localStringBuffer.append(paramString3).append('|');
    localStringBuffer.append(paramString4).append('|');
    localStringBuffer.append(paramInt1).append('|');
    localStringBuffer.append(paramLong).append('|');
    localStringBuffer.append(paramString5).append('|');
    localStringBuffer.append(paramString6).append('|');
    localStringBuffer.append(paramString7).append('|');
    localStringBuffer.append(paramInt2).append('|');
    localStringBuffer.append(paramInt3).append('|');
    localStringBuffer.append(paramInt4).append('|');
    localStringBuffer.append(paramString8).append('|');
    localStringBuffer.append(paramString9).append('|');
    localStringBuffer.append(paramString10).append('|');
    localStringBuffer.append(paramString11).append('|');
    localStringBuffer.append(paramString12);
    DcReportUtil.a(null, "dc01183", localStringBuffer.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebViewReportUtils
 * JD-Core Version:    0.7.0.1
 */
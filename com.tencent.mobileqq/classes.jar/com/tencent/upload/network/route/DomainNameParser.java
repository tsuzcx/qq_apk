package com.tencent.upload.network.route;

import android.text.TextUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.utils.UploadLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DomainNameParser
{
  private static final String TAG = "DomainNameParser";
  private static Map<String, String> sLastParseResults = new ConcurrentHashMap();
  
  public static void parse(String paramString, DomainNameParser.ParseResult paramParseResult)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("parse: start, domainName:");
    ((StringBuilder)???).append(paramString);
    UploadLog.i("DomainNameParser", ((StringBuilder)???).toString());
    if (paramString == null)
    {
      UploadLog.i("DomainNameParser", "parse: return, domainName == null");
      return;
    }
    synchronized (new byte[0])
    {
      DomainNameParser.1 local1 = new DomainNameParser.1(paramString, (byte[])???, paramParseResult);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("domainParser");
      localStringBuilder2.append(System.currentTimeMillis());
      new Thread(local1, localStringBuilder2.toString()).start();
      try
      {
        ???.wait(UploadConfiguration.getDomainNameParseTimeout());
      }
      catch (InterruptedException localInterruptedException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("parse: wait:");
        localStringBuilder2.append(localInterruptedException);
        UploadLog.w("DomainNameParser", localStringBuilder2.toString());
      }
      if ((TextUtils.isEmpty(paramParseResult.parsedIp)) && (!TextUtils.isEmpty((CharSequence)sLastParseResults.get(paramString))))
      {
        UploadLog.w("DomainNameParser", "used last domain ip");
        paramParseResult.parsedIp = ((String)sLastParseResults.get(paramString));
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("parse return, get domainName:");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(" to ip:");
      localStringBuilder1.append(paramParseResult.parsedIp);
      localStringBuilder1.append(" lock obj :");
      localStringBuilder1.append(???.hashCode());
      UploadLog.i("DomainNameParser", localStringBuilder1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.DomainNameParser
 * JD-Core Version:    0.7.0.1
 */
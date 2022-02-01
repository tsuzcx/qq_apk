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
    UploadLog.i("DomainNameParser", "parse: start, domainName:" + paramString);
    if (paramString == null)
    {
      UploadLog.i("DomainNameParser", "parse: return, domainName == null");
      return;
    }
    synchronized (new byte[0])
    {
      new Thread(new DomainNameParser.1(paramString, ???, paramParseResult), "domainParser" + System.currentTimeMillis()).start();
    }
    try
    {
      ???.wait(UploadConfiguration.getDomainNameParseTimeout());
      if ((TextUtils.isEmpty(paramParseResult.parsedIp)) && (!TextUtils.isEmpty((CharSequence)sLastParseResults.get(paramString))))
      {
        UploadLog.w("DomainNameParser", "used last domain ip");
        paramParseResult.parsedIp = ((String)sLastParseResults.get(paramString));
      }
      UploadLog.i("DomainNameParser", "parse return, get domainName:" + paramString + " to ip:" + paramParseResult.parsedIp + " lock obj :" + ???.hashCode());
      return;
      paramString = finally;
      throw paramString;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        UploadLog.w("DomainNameParser", "parse: wait:" + localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.upload.network.route.DomainNameParser
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.oskplayer.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpParser
{
  public static final int NOT_RANGE_REQUEST = -1;
  private static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:\\s*bytes=(\\d*)\\s*-\\s*(\\d*)");
  public static final int RANGE_NOT_SPECIFIED = -2;
  private static final String TAG = "HttpParser";
  public static HashMap<String, Map<String, String>> sParseParamsCacheMap = new HashMap();
  private LinkedHashMap<String, String> headers;
  private String mLogTag;
  private LinkedHashMap<String, String> params;
  private ArrayList<String> rawHeaders;
  private BufferedReader reader;
  private String requestMethod;
  private int[] ver;
  
  public HttpParser(InputStream paramInputStream, String paramString)
  {
    this.reader = new BufferedReader(new InputStreamReader(paramInputStream));
    this.headers = new LinkedHashMap();
    this.params = new LinkedHashMap();
    this.ver = new int[2];
    this.rawHeaders = new ArrayList();
    this.mLogTag = (paramString + "HttpParser");
    try
    {
      parseRequest();
      return;
    }
    catch (IOException paramInputStream)
    {
      PlayerUtils.log(6, this.mLogTag, "error parsing request " + PlayerUtils.getPrintableStackTrace(paramInputStream));
    }
  }
  
  public static String getDateHeader()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return "Date: " + localSimpleDateFormat.format(new Date()) + " GMT";
  }
  
  public static String getExpiresHeader(int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return "Expires: " + localSimpleDateFormat.format(new Date(System.currentTimeMillis() + 3600000 * paramInt)) + " GMT";
  }
  
  public static String getHeaders(Map<String, List<String>> paramMap)
  {
    return map2String(parseHeaders(paramMap));
  }
  
  public static long[] getRangeOffset(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = RANGE_HEADER_PATTERN.matcher(paramString);
      if (((Matcher)localObject).find())
      {
        paramString = ((Matcher)localObject).group(1);
        localObject = ((Matcher)localObject).group(2);
        try
        {
          l1 = Long.parseLong(paramString);
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            try
            {
              long l2 = Long.parseLong((String)localObject);
              return new long[] { l1, l2 };
            }
            catch (NumberFormatException paramString)
            {
              long l1;
              return new long[] { l1, -2L };
            }
            paramString = paramString;
            l1 = 0L;
          }
        }
      }
    }
    return new long[] { -1L, -1L };
  }
  
  public static String map2String(Map<String, String> paramMap)
  {
    Object localObject = "";
    Iterator localIterator = paramMap.entrySet().iterator();
    for (paramMap = (Map<String, String>)localObject; localIterator.hasNext(); paramMap = paramMap + "\r\n")
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject = paramMap;
      if (localEntry.getKey() != null)
      {
        paramMap = paramMap + (String)localEntry.getKey();
        localObject = paramMap + ": ";
      }
      paramMap = (String)localObject + (String)localEntry.getValue();
    }
    return paramMap;
  }
  
  public static String newResponseHeader(long paramLong1, long paramLong2, long paramLong3, String paramString, boolean paramBoolean)
  {
    int i;
    int j;
    label22:
    int k;
    label32:
    long l;
    label51:
    Object localObject2;
    Object localObject1;
    if (paramLong1 != -1L)
    {
      i = 1;
      if (TextUtils.isEmpty(paramString)) {
        break label475;
      }
      j = 1;
      if (paramLong3 < 0L) {
        break label481;
      }
      k = 1;
      if (i == 0) {
        break label554;
      }
      if (paramLong2 != -2L) {
        break label487;
      }
      l = paramLong3 - paramLong1;
      localObject2 = new StringBuilder().append("");
      if (i == 0) {
        break label561;
      }
      localObject1 = "HTTP/1.1 206 PARTIAL CONTENT\r\n";
      label74:
      localObject1 = (String)localObject1;
      localObject1 = (String)localObject1 + "Connection: close\r\n";
      if ((k == 0) || (i == 0)) {
        break label663;
      }
      if (paramLong2 != -2L) {
        break label569;
      }
      localObject1 = (String)localObject1 + String.format("Content-Range: bytes %d-%d/%d\r\n", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong3 - 1L), Long.valueOf(paramLong3) });
    }
    label649:
    label656:
    label663:
    for (;;)
    {
      label180:
      if (paramBoolean)
      {
        localObject1 = (String)localObject1 + String.format("Cache-Control: max-age=%d\r\n", new Object[] { Integer.valueOf(10800) });
        label224:
        localObject2 = (String)localObject1 + getDateHeader() + "\r\n";
        localObject1 = localObject2;
        if (paramBoolean) {
          localObject1 = (String)localObject2 + getExpiresHeader(3) + "\r\n";
        }
        localObject2 = new StringBuilder().append((String)localObject1);
        if (k == 0) {
          break label649;
        }
        localObject1 = String.format("Content-Length: %d\r\n", new Object[] { Long.valueOf(l) });
        label329:
        localObject1 = (String)localObject1;
        localObject1 = (String)localObject1 + "Accept-Ranges: bytes\r\n";
        localObject1 = new StringBuilder().append((String)localObject1);
        if (j == 0) {
          break label656;
        }
      }
      for (paramString = String.format("Content-Type: %s\r\n", new Object[] { paramString });; paramString = "")
      {
        paramString = paramString;
        paramString = paramString + String.format("X-Server: %s\r\n", new Object[] { "videoproxy 1.4.1" });
        return paramString + "\r\n";
        i = 0;
        break;
        label475:
        j = 0;
        break label22;
        label481:
        k = 0;
        break label32;
        label487:
        if (paramLong2 > paramLong3 - 1L) {
          PlayerUtils.log(5, "HttpParser", "fix rangeEnd. max=" + (paramLong3 - 1L) + " current=" + paramLong2);
        }
        paramLong2 = Math.min(paramLong2, paramLong3 - 1L);
        l = paramLong2 - paramLong1 + 1L;
        break label51;
        label554:
        l = paramLong3;
        break label51;
        label561:
        localObject1 = "HTTP/1.1 200 OK\r\n";
        break label74;
        label569:
        localObject1 = (String)localObject1 + String.format("Content-Range: bytes %d-%d/%d\r\n", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
        break label180;
        localObject1 = (String)localObject1 + "Cache-Control: no-cache\r\n";
        break label224;
        localObject1 = "";
        break label329;
      }
    }
  }
  
  public static Map<String, String> parseHeaders(String paramString)
  {
    paramString = paramString.split("\r\n");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramString[i];
      int k;
      if (!localObject.equals(""))
      {
        k = localObject.indexOf(':');
        if (k >= 0) {
          break label71;
        }
        localLinkedHashMap.put("null", localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        label71:
        localLinkedHashMap.put(localObject.substring(0, k).toLowerCase().trim(), localObject.substring(k + 1).trim());
      }
    }
    return localLinkedHashMap;
  }
  
  public static Map<String, String> parseHeaders(Map<String, List<String>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      int i = 0;
      label65:
      if (i < ((List)localObject).size())
      {
        if (str == null) {
          break label107;
        }
        localLinkedHashMap.put(str.toLowerCase().trim(), ((List)localObject).get(i));
      }
      for (;;)
      {
        i += 1;
        break label65;
        break;
        label107:
        localLinkedHashMap.put(str, ((List)localObject).get(i));
      }
    }
    return localLinkedHashMap;
  }
  
  private void parseHeaders()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.reader.readLine();
    localStringBuilder.append(str).append("|");
    for (;;)
    {
      int i;
      if (!str.equals(""))
      {
        i = str.indexOf(':');
        if (i < 0) {
          this.headers = null;
        }
      }
      else
      {
        PlayerUtils.log(4, this.mLogTag, localStringBuilder.toString());
        return;
      }
      this.headers.put(str.substring(0, i).toLowerCase().trim(), str.substring(i + 1).trim());
      this.rawHeaders.add(str);
      str = this.reader.readLine();
      localStringBuilder.append(str).append("|");
    }
  }
  
  public static Map<String, String> parseParams(String paramString)
  {
    int i = 0;
    if ((!TextUtils.isEmpty(paramString)) && (sParseParamsCacheMap.containsKey(paramString))) {
      localObject = (Map)sParseParamsCacheMap.get(paramString);
    }
    LinkedHashMap localLinkedHashMap;
    int j;
    do
    {
      do
      {
        return localObject;
        localLinkedHashMap = new LinkedHashMap();
        localObject = localLinkedHashMap;
      } while (paramString == null);
      j = paramString.indexOf('?');
      localObject = localLinkedHashMap;
    } while (j <= 0);
    Object localObject = paramString.substring(j + 1).split("&");
    for (;;)
    {
      try
      {
        if (i < localObject.length)
        {
          String[] arrayOfString = localObject[i].split("=");
          if (arrayOfString.length == 2) {
            localLinkedHashMap.put(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
          } else if ((arrayOfString.length == 1) && (localObject[i].indexOf('=') == localObject[i].length() - 1)) {
            localLinkedHashMap.put(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
          }
        }
      }
      catch (IOException paramString)
      {
        PlayerUtils.log(5, "HttpParser", PlayerUtils.getPrintableStackTrace(paramString));
        return localLinkedHashMap;
      }
      sParseParamsCacheMap.put(paramString, localLinkedHashMap);
      return localLinkedHashMap;
      i += 1;
    }
  }
  
  public static String replaceParam(String paramString1, String paramString2, String paramString3)
  {
    String str2 = paramString2 + "=";
    String str1 = paramString1;
    if (paramString1 != null)
    {
      str1 = paramString1;
      if (paramString1.contains(str2)) {
        str1 = paramString1.replaceAll(paramString2 + "=[^&]+", paramString2 + "=" + paramString3);
      }
    }
    return str1;
  }
  
  public Map<String, String> getHeaders()
  {
    return this.headers;
  }
  
  public String getParam(String paramString)
  {
    return (String)this.params.get(paramString);
  }
  
  public String getRawHeaders()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.rawHeaders.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  public String getRequestMethod()
  {
    return this.requestMethod;
  }
  
  public String getVersion()
  {
    return this.ver[0] + "." + this.ver[1];
  }
  
  public void parseRequest()
  {
    String[] arrayOfString2 = null;
    String str = this.reader.readLine();
    PlayerUtils.log(4, this.mLogTag, "initial=" + str);
    if ((str == null) || (str.length() == 0))
    {
      PlayerUtils.log(6, this.mLogTag, "initial is not valid");
      return;
    }
    if (Character.isWhitespace(str.charAt(0)))
    {
      PlayerUtils.log(6, this.mLogTag, "character first char is whitespace");
      return;
    }
    String[] arrayOfString3 = str.split("\\s");
    if (arrayOfString3.length != 3)
    {
      PlayerUtils.log(6, this.mLogTag, "cmd.length is not 3");
      return;
    }
    this.requestMethod = arrayOfString3[0];
    Object localObject;
    if ((arrayOfString3[2].indexOf("HTTP/") == 0) && (arrayOfString3[2].indexOf('.') > 5))
    {
      localObject = arrayOfString3[2];
      this.rawHeaders.add(str);
      if (localObject != null) {
        localObject = ((String)localObject).substring(5).split("\\.");
      }
    }
    for (;;)
    {
      try
      {
        this.ver[0] = Integer.parseInt(localObject[0]);
        this.ver[1] = Integer.parseInt(localObject[1]);
        if ((!arrayOfString3[0].equals("GET")) && (!arrayOfString3[0].equals("HEAD"))) {
          break label459;
        }
        i = arrayOfString3[1].indexOf('?');
        if (i >= 0) {
          break label327;
        }
        parseHeaders();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        PlayerUtils.log(6, this.mLogTag, "error parsing request NumberFormatException" + PlayerUtils.getPrintableStackTrace(localNumberFormatException));
        return;
      }
      localObject = arrayOfString2;
      if (arrayOfString3[0].indexOf("HTTP/") != 0) {
        break;
      }
      localObject = arrayOfString2;
      if (arrayOfString3[0].indexOf('.') <= 5) {
        break;
      }
      localObject = arrayOfString3[0];
      break;
      label327:
      String[] arrayOfString1 = arrayOfString3[1].substring(i + 1).split("&");
      this.params = new LinkedHashMap();
      int i = 0;
      label357:
      if (i < arrayOfString1.length)
      {
        arrayOfString2 = arrayOfString1[i].split("=");
        if (arrayOfString2.length != 2) {
          break label412;
        }
        this.params.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
      }
      for (;;)
      {
        i += 1;
        break label357;
        break;
        label412:
        if ((arrayOfString2.length == 1) && (arrayOfString1[i].indexOf('=') == arrayOfString1[i].length() - 1)) {
          this.params.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
        }
      }
      label459:
      if ((arrayOfString3[0].equals("POST")) || (arrayOfString3[0].equals("OPTIONS")) || (arrayOfString3[0].equals("PUT")) || (arrayOfString3[0].equals("DELETE")) || (arrayOfString3[0].equals("TRACE")) || (!arrayOfString3[0].equals("CONNECT"))) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.util.HttpParser
 * JD-Core Version:    0.7.0.1
 */
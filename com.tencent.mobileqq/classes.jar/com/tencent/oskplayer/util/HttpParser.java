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
    paramInputStream = new StringBuilder();
    paramInputStream.append(paramString);
    paramInputStream.append("HttpParser");
    this.mLogTag = paramInputStream.toString();
    try
    {
      parseRequest();
      return;
    }
    catch (IOException paramInputStream)
    {
      paramString = this.mLogTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error parsing request ");
      localStringBuilder.append(PlayerUtils.getPrintableStackTrace(paramInputStream));
      PlayerUtils.log(6, paramString, localStringBuilder.toString());
    }
  }
  
  public static String getDateHeader()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Date: ");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append(" GMT");
    return localStringBuilder.toString();
  }
  
  public static String getExpiresHeader(int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expires: ");
    localStringBuilder.append(localSimpleDateFormat.format(new Date(System.currentTimeMillis() + paramInt * 3600000)));
    localStringBuilder.append(" GMT");
    return localStringBuilder.toString();
  }
  
  public static String getHeaders(Map<String, List<String>> paramMap)
  {
    return map2String(parseHeaders(paramMap));
  }
  
  public static long[] getRangeOffset(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = RANGE_HEADER_PATTERN.matcher(paramString);
      if (((Matcher)localObject).find())
      {
        paramString = ((Matcher)localObject).group(1);
        localObject = ((Matcher)localObject).group(2);
      }
    }
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      label47:
      break label47;
    }
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject);
      return new long[] { l1, l2 };
    }
    catch (NumberFormatException paramString)
    {
      label67:
      break label67;
    }
    return new long[] { l1, -2L };
    return new long[] { -1L, -1L };
  }
  
  public static String map2String(Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    Object localObject;
    for (paramMap = ""; localIterator.hasNext(); paramMap = ((StringBuilder)localObject).toString())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObject = paramMap;
      if (localEntry.getKey() != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMap);
        ((StringBuilder)localObject).append((String)localEntry.getKey());
        paramMap = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMap);
        ((StringBuilder)localObject).append(": ");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramMap = new StringBuilder();
      paramMap.append((String)localObject);
      paramMap.append((String)localEntry.getValue());
      paramMap = paramMap.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMap);
      ((StringBuilder)localObject).append("\r\n");
    }
    return paramMap;
  }
  
  public static String newResponseHeader(long paramLong1, long paramLong2, long paramLong3, String paramString, boolean paramBoolean)
  {
    long l = paramLong2;
    int i;
    if (paramLong1 != -1L) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramString);
    int j;
    if (paramLong3 >= 0L) {
      j = 1;
    } else {
      j = 0;
    }
    if (i != 0)
    {
      if (l == -2L)
      {
        paramLong2 = paramLong3 - paramLong1;
      }
      else
      {
        paramLong2 = paramLong3 - 1L;
        if (l > paramLong2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("fix rangeEnd. max=");
          ((StringBuilder)localObject1).append(paramLong2);
          ((StringBuilder)localObject1).append(" current=");
          ((StringBuilder)localObject1).append(l);
          PlayerUtils.log(5, "HttpParser", ((StringBuilder)localObject1).toString());
        }
        l = Math.min(l, paramLong2);
        paramLong2 = l - paramLong1 + 1L;
      }
    }
    else {
      paramLong2 = paramLong3;
    }
    Object localObject2 = new StringBuilder();
    String str = "";
    ((StringBuilder)localObject2).append("");
    if (i != 0) {
      localObject1 = "HTTP/1.1 206 PARTIAL CONTENT\r\n";
    } else {
      localObject1 = "HTTP/1.1 200 OK\r\n";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    Object localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("Connection: close\r\n");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (j != 0)
    {
      localObject1 = localObject2;
      if (i != 0) {
        if (l == -2L)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(String.format("Content-Range: bytes %d-%d/%d\r\n", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong3 - 1L), Long.valueOf(paramLong3) }));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(String.format("Content-Range: bytes %d-%d/%d\r\n", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l), Long.valueOf(paramLong3) }));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    if (paramBoolean)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(String.format("Cache-Control: max-age=%d\r\n", new Object[] { Integer.valueOf(10800) }));
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("Cache-Control: no-cache\r\n");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(getDateHeader());
    ((StringBuilder)localObject2).append("\r\n");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(getExpiresHeader(3));
      ((StringBuilder)localObject1).append("\r\n");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    if (j != 0) {
      localObject1 = String.format("Content-Length: %d\r\n", new Object[] { Long.valueOf(paramLong2) });
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("Accept-Ranges: bytes\r\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = str;
    if ((bool ^ true)) {
      localObject1 = String.format("Content-Type: %s\r\n", new Object[] { paramString });
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    paramString = ((StringBuilder)localObject2).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(String.format("X-Server: %s\r\n", new Object[] { "videoproxy 1.4.1" }));
    paramString = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("\r\n");
    return ((StringBuilder)localObject1).toString();
  }
  
  public static Map<String, String> parseHeaders(String paramString)
  {
    paramString = paramString.split("\r\n");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (!localObject.equals(""))
      {
        int k = localObject.indexOf(':');
        if (k < 0) {
          localLinkedHashMap.put("null", localObject);
        } else {
          localLinkedHashMap.put(localObject.substring(0, k).toLowerCase().trim(), localObject.substring(k + 1).trim());
        }
      }
      i += 1;
    }
    return localLinkedHashMap;
  }
  
  public static Map<String, String> parseHeaders(Map<String, List<String>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      int i = 0;
      while (i < ((List)localObject).size())
      {
        if (str != null) {
          localLinkedHashMap.put(str.toLowerCase().trim(), ((List)localObject).get(i));
        } else {
          localLinkedHashMap.put(str, ((List)localObject).get(i));
        }
        i += 1;
      }
    }
    return localLinkedHashMap;
  }
  
  private void parseHeaders()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.reader.readLine();
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    while (!str.equals(""))
    {
      int i = str.indexOf(':');
      if (i < 0)
      {
        this.headers = null;
        break;
      }
      this.headers.put(str.substring(0, i).toLowerCase().trim(), str.substring(i + 1).trim());
      this.rawHeaders.add(str);
      str = this.reader.readLine();
      localStringBuilder.append(str);
      localStringBuilder.append("|");
    }
    PlayerUtils.log(4, this.mLogTag, localStringBuilder.toString());
  }
  
  public static Map<String, String> parseParams(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (sParseParamsCacheMap.containsKey(paramString))) {
      return (Map)sParseParamsCacheMap.get(paramString);
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i;
    String[] arrayOfString1;
    if (paramString != null)
    {
      i = paramString.indexOf('?');
      if (i > 0)
      {
        arrayOfString1 = paramString.substring(i + 1).split("&");
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length == 2)
          {
            localLinkedHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
            break label189;
          }
          if ((arrayOfString2.length != 1) || (arrayOfString1[i].indexOf('=') != arrayOfString1[i].length() - 1)) {
            break label189;
          }
          localLinkedHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
          break label189;
        }
        sParseParamsCacheMap.put(paramString, localLinkedHashMap);
        return localLinkedHashMap;
      }
      catch (IOException paramString)
      {
        PlayerUtils.log(5, "HttpParser", PlayerUtils.getPrintableStackTrace(paramString));
      }
      return localLinkedHashMap;
      label189:
      i += 1;
    }
  }
  
  public static String replaceParam(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("=");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = paramString1;
    if (paramString1 != null)
    {
      localObject1 = paramString1;
      if (paramString1.contains((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("=[^&]+");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append("=");
        ((StringBuilder)localObject2).append(paramString3);
        localObject1 = paramString1.replaceAll((String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
    return localObject1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.ver[0]);
    localStringBuilder.append(".");
    localStringBuilder.append(this.ver[1]);
    return localStringBuilder.toString();
  }
  
  public void parseRequest()
  {
    Object localObject2 = this.reader.readLine();
    Object localObject1 = this.mLogTag;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("initial=");
    ((StringBuilder)localObject3).append((String)localObject2);
    PlayerUtils.log(4, (String)localObject1, ((StringBuilder)localObject3).toString());
    if ((localObject2 != null) && (((String)localObject2).length() != 0))
    {
      if (Character.isWhitespace(((String)localObject2).charAt(0)))
      {
        PlayerUtils.log(6, this.mLogTag, "character first char is whitespace");
        return;
      }
      localObject3 = ((String)localObject2).split("\\s");
      if (localObject3.length != 3)
      {
        PlayerUtils.log(6, this.mLogTag, "cmd.length is not 3");
        return;
      }
      this.requestMethod = localObject3[0];
      if ((localObject3[2].indexOf("HTTP/") == 0) && (localObject3[2].indexOf('.') > 5)) {
        localObject1 = localObject3[2];
      } else if ((localObject3[0].indexOf("HTTP/") == 0) && (localObject3[0].indexOf('.') > 5)) {
        localObject1 = localObject3[0];
      } else {
        localObject1 = null;
      }
      this.rawHeaders.add(localObject2);
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).substring(5).split("\\.");
        try
        {
          this.ver[0] = Integer.parseInt(localObject1[0]);
          this.ver[1] = Integer.parseInt(localObject1[1]);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject2 = this.mLogTag;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("error parsing request NumberFormatException");
          ((StringBuilder)localObject3).append(PlayerUtils.getPrintableStackTrace(localNumberFormatException));
          PlayerUtils.log(6, (String)localObject2, ((StringBuilder)localObject3).toString());
          return;
        }
      }
      if ((!localObject3[0].equals("GET")) && (!localObject3[0].equals("HEAD")))
      {
        if ((!localObject3[0].equals("POST")) && (!localObject3[0].equals("OPTIONS")) && (!localObject3[0].equals("PUT")) && (!localObject3[0].equals("DELETE")) && (!localObject3[0].equals("TRACE"))) {
          localObject3[0].equals("CONNECT");
        }
      }
      else
      {
        int i = localObject3[1].indexOf('?');
        if (i >= 0)
        {
          String[] arrayOfString = localObject3[1].substring(i + 1).split("&");
          this.params = new LinkedHashMap();
          i = 0;
          while (i < arrayOfString.length)
          {
            localObject2 = arrayOfString[i].split("=");
            if (localObject2.length == 2) {
              this.params.put(URLDecoder.decode(localObject2[0], "UTF-8"), URLDecoder.decode(localObject2[1], "UTF-8"));
            } else if ((localObject2.length == 1) && (arrayOfString[i].indexOf('=') == arrayOfString[i].length() - 1)) {
              this.params.put(URLDecoder.decode(localObject2[0], "UTF-8"), "");
            }
            i += 1;
          }
        }
      }
      parseHeaders();
      return;
    }
    PlayerUtils.log(6, this.mLogTag, "initial is not valid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.HttpParser
 * JD-Core Version:    0.7.0.1
 */
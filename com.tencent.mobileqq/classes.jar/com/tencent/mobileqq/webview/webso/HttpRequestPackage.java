package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpVersion;
import org.json.JSONObject;

@Keep
public class HttpRequestPackage
{
  private static final String CRLF = "\r\n";
  public String accept_Charset;
  public String accept_Encoding;
  public String accept_Language;
  public String content_length;
  public String content_type;
  public String cookie;
  public String entity_body;
  public String expect;
  public String extendHeaderJsonStr;
  public String host;
  public String if_Match;
  public String if_Modified_Since;
  public String if_None_Match;
  public String if_Range;
  public String if_Unmodified_Since;
  public String method;
  public String no_Chunked;
  public String range;
  public String uri;
  public String user_Agent;
  public String web_page_version;
  
  public HttpRequestPackage(String paramString)
  {
    this.user_Agent = paramString;
    this.entity_body = "";
  }
  
  public HttpRequestPackage(String paramString, JSONObject paramJSONObject)
  {
    this(paramString);
    readFromJson(paramJSONObject);
  }
  
  private String addExtHeader(StringBuilder paramStringBuilder, String paramString)
  {
    StringBuilder localStringBuilder = paramStringBuilder;
    if (paramStringBuilder == null) {
      localStringBuilder = new StringBuilder();
    }
    try
    {
      paramStringBuilder = new JSONObject(paramString);
      new ArrayList();
      paramString = paramStringBuilder.keys();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        addHeaderItem(localStringBuilder, str, paramStringBuilder.getString(str));
      }
      return localStringBuilder.toString();
    }
    catch (Exception paramStringBuilder)
    {
      label78:
      break label78;
    }
    return null;
  }
  
  private StringBuilder addHeaderItem(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = paramStringBuilder;
    if (paramStringBuilder == null) {
      localStringBuilder = new StringBuilder();
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\r\n");
    }
    return localStringBuilder;
  }
  
  private String getRequest_Line()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.method);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.uri);
    localStringBuilder.append(" ");
    localStringBuilder.append(HttpVersion.HTTP_1_1);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
  
  private void put(String paramString1, String paramString2, String paramString3)
  {
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      if (paramString3 == null) {
        return;
      }
      if (paramString3.length() == 0) {
        return;
      }
      str = paramString3;
    }
    try
    {
      paramString2 = HttpRequestPackage.class.getDeclaredField(paramString1);
      if (paramString1.equals("uri"))
      {
        setUri(str);
        return;
      }
      if (paramString2 != null)
      {
        paramString2.set(this, str);
        return;
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchFieldException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  private void readFromJson(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +45 -> 46
    //   4: aload_2
    //   5: ifnull +41 -> 46
    //   8: aload_2
    //   9: invokevirtual 94	java/lang/String:length	()I
    //   12: ifle +34 -> 46
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 82	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: aload_1
    //   24: aload_3
    //   25: invokespecial 154	com/tencent/mobileqq/webview/webso/HttpRequestPackage:put	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: aload_2
    //   32: aconst_null
    //   33: aload_3
    //   34: invokespecial 154	com/tencent/mobileqq/webview/webso/HttpRequestPackage:put	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_1
    //   38: athrow
    //   39: aload_0
    //   40: aload_2
    //   41: aconst_null
    //   42: aload_3
    //   43: invokespecial 154	com/tencent/mobileqq/webview/webso/HttpRequestPackage:put	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   46: return
    //   47: astore_1
    //   48: goto -9 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	HttpRequestPackage
    //   0	51	1	paramJSONObject	JSONObject
    //   0	51	2	paramString1	String
    //   0	51	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   15	21	29	finally
    //   15	21	47	org/json/JSONException
  }
  
  public void addHeader(String paramString)
  {
    this.extendHeaderJsonStr = paramString;
  }
  
  public String getBodyString()
  {
    return this.entity_body;
  }
  
  public String getHeaderString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getRequest_Line());
    addHeaderItem(localStringBuilder, "Accept-Charset", this.accept_Charset);
    addHeaderItem(localStringBuilder, "Accept-Encoding", this.accept_Encoding);
    addHeaderItem(localStringBuilder, "Accept-Language", this.accept_Language);
    addHeaderItem(localStringBuilder, "Expect", this.expect);
    addHeaderItem(localStringBuilder, "Host", this.host);
    addHeaderItem(localStringBuilder, "If-Match", this.if_Match);
    addHeaderItem(localStringBuilder, "If-Modified-Since", this.if_Modified_Since);
    addHeaderItem(localStringBuilder, "If-None-Match", this.if_None_Match);
    addHeaderItem(localStringBuilder, "If-Range", this.if_Range);
    addHeaderItem(localStringBuilder, "If-Unmodified-Since", this.if_Unmodified_Since);
    addHeaderItem(localStringBuilder, "Range", this.range);
    addHeaderItem(localStringBuilder, "User-Agent", this.user_Agent);
    addHeaderItem(localStringBuilder, "Content-Type", this.content_type);
    addHeaderItem(localStringBuilder, "Content-Length", this.content_length);
    addHeaderItem(localStringBuilder, "webso-page-version", this.web_page_version);
    addHeaderItem(localStringBuilder, "Cookie", this.cookie);
    addHeaderItem(localStringBuilder, "No-Chunked", this.no_Chunked);
    if (!TextUtils.isEmpty(this.extendHeaderJsonStr)) {
      addExtHeader(localStringBuilder, this.extendHeaderJsonStr);
    }
    return localStringBuilder.toString();
  }
  
  public void readFromJson(JSONObject paramJSONObject)
  {
    readFromJson(paramJSONObject, "method", "GET");
    readFromJson(paramJSONObject, "uri", null);
    readFromJson(paramJSONObject, "accept_Charset", "utf-8");
    readFromJson(paramJSONObject, "accept_Encoding", "");
    readFromJson(paramJSONObject, "accept_Language", "zh-CN,zh;");
    readFromJson(paramJSONObject, "authorization", null);
    readFromJson(paramJSONObject, "expect", null);
    readFromJson(paramJSONObject, "if_Match", null);
    readFromJson(paramJSONObject, "if_Modified_Since", null);
    readFromJson(paramJSONObject, "if_None_Match", null);
    readFromJson(paramJSONObject, "if_Range", null);
    readFromJson(paramJSONObject, "if_Unmodified_Since", null);
    readFromJson(paramJSONObject, "range", null);
    readFromJson(paramJSONObject, "cookie", null);
    readFromJson(paramJSONObject, "entity_body", null);
    readFromJson(paramJSONObject, "content_type", null);
    readFromJson(paramJSONObject, "content_length", null);
    readFromJson(paramJSONObject, "no_Chunked", null);
    readFromJson(paramJSONObject, "web_page_version", null);
  }
  
  public void setUri(String paramString)
  {
    this.host = Uri.parse(paramString).getHost();
    this.uri = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HttpRequestPackage
 * JD-Core Version:    0.7.0.1
 */
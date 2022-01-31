package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpVersion;
import org.json.JSONObject;

public class HttpRequestPackage
{
  private static final String CRLF = "\r\n";
  public String accept_Charset;
  public String accept_Encoding;
  public String accept_Language;
  public String accept_diff;
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
  public String template_tag;
  public String uri;
  public String user_Agent;
  
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
    localStringBuilder = paramStringBuilder;
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
      return null;
    }
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
    return this.method + " " + this.uri + " " + HttpVersion.HTTP_1_1 + "\r\n";
  }
  
  private void put(String paramString1, String paramString2, String paramString3)
  {
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.length() != 0) {}
    }
    else if ((paramString3 != null) && (paramString3.length() != 0)) {}
    for (;;)
    {
      return;
      str = paramString3;
      try
      {
        paramString2 = HttpRequestPackage.class.getDeclaredField(paramString1);
        if (paramString1.equals("uri"))
        {
          setUri(str);
          return;
        }
      }
      catch (NoSuchFieldException paramString1)
      {
        paramString1.printStackTrace();
        return;
        if (paramString2 != null)
        {
          paramString2.set(this, str);
          return;
        }
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IllegalArgumentException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  /* Error */
  private void readFromJson(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +27 -> 28
    //   4: aload_2
    //   5: ifnull +23 -> 28
    //   8: aload_2
    //   9: invokevirtual 94	java/lang/String:length	()I
    //   12: ifle +16 -> 28
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
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: aload_2
    //   41: aconst_null
    //   42: aload_3
    //   43: invokespecial 154	com/tencent/mobileqq/webview/webso/HttpRequestPackage:put	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	HttpRequestPackage
    //   0	48	1	paramJSONObject	JSONObject
    //   0	48	2	paramString1	String
    //   0	48	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   15	21	29	org/json/JSONException
    //   15	21	38	finally
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
    addHeaderItem(localStringBuilder, "accept-diff", this.accept_diff);
    addHeaderItem(localStringBuilder, "template-tag", this.template_tag);
    addHeaderItem(localStringBuilder, "If-Range", this.if_Range);
    addHeaderItem(localStringBuilder, "If-Unmodified-Since", this.if_Unmodified_Since);
    addHeaderItem(localStringBuilder, "Range", this.range);
    addHeaderItem(localStringBuilder, "User-Agent", this.user_Agent);
    addHeaderItem(localStringBuilder, "Content-Type", this.content_type);
    addHeaderItem(localStringBuilder, "Content-Length", this.content_length);
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
    readFromJson(paramJSONObject, "accept_diff", null);
    readFromJson(paramJSONObject, "template_tag", null);
    readFromJson(paramJSONObject, "if_Range", null);
    readFromJson(paramJSONObject, "if_Unmodified_Since", null);
    readFromJson(paramJSONObject, "range", null);
    readFromJson(paramJSONObject, "cookie", null);
    readFromJson(paramJSONObject, "entity_body", null);
    readFromJson(paramJSONObject, "content_type", null);
    readFromJson(paramJSONObject, "content_length", null);
    readFromJson(paramJSONObject, "no_Chunked", null);
  }
  
  public void setUri(String paramString)
  {
    this.host = Uri.parse(paramString).getHost();
    this.uri = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HttpRequestPackage
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile.quic.internal;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class QuicDownloadRequest
{
  private static final int PORT_QUIC = 443;
  private static final int PORT_TCP = 80;
  private static final String SCHEME_HTTPS = "https";
  protected Map<String, String> headers = new LinkedHashMap();
  protected String host;
  public String ip;
  protected boolean isFinish = false;
  protected String method = "GET";
  protected String path;
  protected int port = 443;
  protected String scheme = "https";
  
  QuicDownloadRequest(String paramString1, int paramInt, String paramString2)
  {
    init(paramString1, paramInt, paramString2);
  }
  
  private void init(String paramString1, int paramInt, String paramString2)
  {
    this.path = paramString2;
    this.host = paramString1;
    this.ip = paramString1;
    this.port = paramInt;
    paramString1 = this.ip;
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
      this.ip = "";
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
  }
  
  public byte[] getRequestData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.method);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.path);
    localStringBuilder.append(" HTTP/1.1");
    localStringBuilder.append("\r\n");
    Iterator localIterator = this.headers.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append((String)this.headers.get(str));
      localStringBuilder.append("\r\n");
    }
    localStringBuilder.append("\r\n");
    this.isFinish = true;
    return localStringBuilder.toString().getBytes();
  }
  
  public void setHeader(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.headers = paramMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QuicDownloadRequest{method='");
    localStringBuilder.append(this.method);
    localStringBuilder.append('\'');
    localStringBuilder.append(", SCHEME_HTTPS='");
    localStringBuilder.append("https");
    localStringBuilder.append('\'');
    localStringBuilder.append(", PORT_QUIC=");
    localStringBuilder.append(443);
    localStringBuilder.append(", PORT_TCP=");
    localStringBuilder.append(80);
    localStringBuilder.append(", host='");
    localStringBuilder.append(this.host);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ip='");
    localStringBuilder.append(this.ip);
    localStringBuilder.append('\'');
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.port);
    localStringBuilder.append(", scheme='");
    localStringBuilder.append(this.scheme);
    localStringBuilder.append('\'');
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isFinish=");
    localStringBuilder.append(this.isFinish);
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.headers);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRequest
 * JD-Core Version:    0.7.0.1
 */
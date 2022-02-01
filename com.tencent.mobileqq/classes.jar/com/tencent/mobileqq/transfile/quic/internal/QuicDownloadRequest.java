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
    if ((this.ip == null) || (TextUtils.isEmpty(this.ip))) {
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
    localStringBuilder.append(" HTTP/1.1").append("\r\n");
    Iterator localIterator = this.headers.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append(": ").append((String)this.headers.get(str)).append("\r\n");
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
    return "QuicDownloadRequest{method='" + this.method + '\'' + ", SCHEME_HTTPS='" + "https" + '\'' + ", PORT_QUIC=" + 443 + ", PORT_TCP=" + 80 + ", host='" + this.host + '\'' + ", ip='" + this.ip + '\'' + ", port=" + this.port + ", scheme='" + this.scheme + '\'' + ", path='" + this.path + '\'' + ", isFinish=" + this.isFinish + ", headers=" + this.headers + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRequest
 * JD-Core Version:    0.7.0.1
 */
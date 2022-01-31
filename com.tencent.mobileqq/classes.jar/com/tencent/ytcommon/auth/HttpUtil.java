package com.tencent.ytcommon.auth;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil
{
  private static final String CHARSET_UTF8 = "UTF-8";
  private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
  
  private static HttpURLConnection buildConnection(String paramString, int paramInt)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(paramInt);
    paramString.setReadTimeout(paramInt);
    return paramString;
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection, HttpResponseListener paramHttpResponseListener)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      StringBuilder localStringBuilder = new StringBuilder();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        i = paramHttpURLConnection.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuilder.append(new String(arrayOfByte, 0, i));
      }
      paramHttpURLConnection.close();
      paramHttpURLConnection = localStringBuilder.toString();
      if (paramHttpResponseListener != null) {
        paramHttpResponseListener.onSuccess(paramHttpURLConnection);
      }
      return paramHttpURLConnection;
    }
    if (paramHttpResponseListener != null) {
      paramHttpResponseListener.onFail(i);
    }
    return null;
  }
  
  public static String post(String paramString1, String paramString2, HttpResponseListener paramHttpResponseListener)
    throws IOException
  {
    paramString1 = buildConnection(paramString1, 10000);
    paramString1.setRequestProperty("Content-Type", "application/json");
    paramString1.setRequestMethod("POST");
    if (!TextUtils.isEmpty(paramString2))
    {
      OutputStream localOutputStream = paramString1.getOutputStream();
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream, "UTF-8"));
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localOutputStream.close();
    }
    return getResponse(paramString1, paramHttpResponseListener);
  }
  
  public static abstract interface HttpResponseListener
  {
    public abstract void onFail(int paramInt);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ytcommon.auth.HttpUtil
 * JD-Core Version:    0.7.0.1
 */
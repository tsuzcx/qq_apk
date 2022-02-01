package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultMediaHTTPConnection
  implements IMediaHTTPConnection
{
  private static final int CONNECT_TIMEOUT_MS = 30000;
  private static final int HTTP_TEMP_REDIRECT = 307;
  private static final int MAX_REDIRECTS = 20;
  private static final String TAG = "MediaHTTPConnection";
  private static final boolean VERBOSE = false;
  private boolean mAllowCrossDomainRedirect = true;
  private boolean mAllowCrossProtocolRedirect = true;
  private HttpURLConnection mConnection = null;
  private long mCurrentOffset = -1L;
  private Map<String, String> mHeaders = null;
  private InputStream mInputStream = null;
  private long mTotalSize = -1L;
  private URL mURL = null;
  
  private boolean filterOutInternalHeaders(String paramString1, String paramString2)
  {
    if ("android-allow-cross-domain-redirect".equalsIgnoreCase(paramString1))
    {
      this.mAllowCrossDomainRedirect = parseBoolean(paramString2);
      this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
      return true;
    }
    return false;
  }
  
  private static final boolean isLocalHost(URL paramURL)
  {
    if (paramURL == null) {
      return false;
    }
    paramURL = paramURL.getHost();
    if (paramURL == null) {
      return false;
    }
    try
    {
      boolean bool = paramURL.equalsIgnoreCase("localhost");
      if (bool) {
        return true;
      }
    }
    catch (IllegalArgumentException paramURL)
    {
      Logger.e("MediaHTTPConnection", "isLocalHost", paramURL);
    }
    return false;
  }
  
  private boolean parseBoolean(String paramString)
  {
    boolean bool = true;
    try
    {
      long l = Long.parseLong(paramString);
      return l != 0L;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label17:
      break label17;
    }
    if (!"true".equalsIgnoreCase(paramString))
    {
      if ("yes".equalsIgnoreCase(paramString)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void seekTo(long paramLong)
  {
    teardownConnection();
    try
    {
      localObject1 = this.mURL;
      bool1 = isLocalHost((URL)localObject1);
      j = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject1;
        boolean bool1;
        int j;
        int i;
        Object localObject2;
        this.mTotalSize = -1L;
        this.mInputStream = null;
        this.mConnection = null;
        this.mCurrentOffset = -1L;
        Logger.e("MediaHTTPConnection", "seekTo", localIOException);
        for (;;)
        {
          throw localIOException;
        }
        int k = 0;
        continue;
        if (paramLong > 0L) {
          if (i == 206) {}
        }
      }
    }
    if (bool1) {
      this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection(Proxy.NO_PROXY));
    } else {
      this.mConnection = ((HttpURLConnection)((URL)localObject1).openConnection());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setConnectTimeout ");
    ((StringBuilder)localObject1).append(this.mURL);
    Logger.i("MediaHTTPConnection", ((StringBuilder)localObject1).toString());
    this.mConnection.setConnectTimeout(30000);
    this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
    if (this.mHeaders != null)
    {
      localObject1 = this.mHeaders.entrySet().iterator();
      for (i = 0;; i = 1) {
        do
        {
          k = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          this.mConnection.setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        } while ((i != 0) || (!"Accept-Encoding".equals(((Map.Entry)localObject2).getKey())));
      }
      if (paramLong > 0L)
      {
        localObject1 = this.mConnection;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bytes=");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("-");
        ((HttpURLConnection)localObject1).setRequestProperty("Range", ((StringBuilder)localObject2).toString());
      }
      if (k == 0) {
        this.mConnection.setRequestProperty("Accept-Encoding", "");
      }
      try
      {
        i = this.mConnection.getResponseCode();
        if ((i != 300) && (i != 301) && (i != 302) && (i != 303) && (i != 307))
        {
          if (this.mAllowCrossDomainRedirect) {
            this.mURL = this.mConnection.getURL();
          }
          if (i == 206)
          {
            localObject1 = this.mConnection.getHeaderField("Content-Range");
            this.mTotalSize = -1L;
            if (localObject1 == null) {
              break label895;
            }
            j = ((String)localObject1).lastIndexOf('/');
            if (j < 0) {
              break label895;
            }
            localObject1 = ((String)localObject1).substring(j + 1);
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool2;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("An suspicious exception occurred: ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        throw new IOException(((StringBuilder)localObject2).toString());
      }
      try
      {
        this.mTotalSize = Long.parseLong((String)localObject1);
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (i == 200)
      {
        this.mTotalSize = this.mConnection.getContentLength();
        break label895;
        throw new ProtocolException();
        this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
        this.mCurrentOffset = paramLong;
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("failed! status code: ");
      ((StringBuilder)localObject1).append(i);
      throw new IOException(((StringBuilder)localObject1).toString());
      j += 1;
      if (j <= 20)
      {
        localObject1 = this.mConnection.getRequestMethod();
        if ((i == 307) && (!((String)localObject1).equals("GET")) && (!((String)localObject1).equals("HEAD"))) {
          throw new NoRouteToHostException("Invalid redirect");
        }
        localObject1 = this.mConnection.getHeaderField("Location");
        if (localObject1 != null)
        {
          localObject1 = new URL(this.mURL, (String)localObject1);
          if ((!((URL)localObject1).getProtocol().equals("https")) && (!((URL)localObject1).getProtocol().equals("http"))) {
            throw new NoRouteToHostException("Unsupported protocol redirect");
          }
          bool2 = this.mURL.getProtocol().equals(((URL)localObject1).getProtocol());
          if ((!this.mAllowCrossProtocolRedirect) && (!bool2)) {
            throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
          }
          bool2 = this.mURL.getHost().equals(((URL)localObject1).getHost());
          if ((!this.mAllowCrossDomainRedirect) && (!bool2)) {
            throw new NoRouteToHostException("Cross-domain redirects are disallowed");
          }
          if (i == 307) {
            break label911;
          }
          this.mURL = ((URL)localObject1);
          break label911;
        }
        throw new NoRouteToHostException("Invalid redirect");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Too many redirects: ");
      ((StringBuilder)localObject1).append(j);
      throw new NoRouteToHostException(((StringBuilder)localObject1).toString());
    }
  }
  
  private void teardownConnection()
  {
    HttpURLConnection localHttpURLConnection = this.mConnection;
    if (localHttpURLConnection != null)
    {
      this.mInputStream = null;
      localHttpURLConnection.disconnect();
      this.mConnection = null;
      this.mCurrentOffset = -1L;
    }
  }
  
  public boolean connect(URL paramURL, Map<String, String> paramMap)
  {
    disconnect();
    this.mAllowCrossDomainRedirect = true;
    this.mURL = paramURL;
    this.mHeaders = paramMap;
    return true;
  }
  
  public void disconnect()
  {
    teardownConnection();
    this.mHeaders = null;
    this.mURL = null;
  }
  
  public String getMIMEType()
  {
    if (this.mConnection == null) {
      try
      {
        seekTo(0L);
      }
      catch (IOException localIOException)
      {
        Logger.e("MediaHTTPConnection", "getMIMEType", localIOException);
        return "application/octet-stream";
      }
    }
    return this.mConnection.getContentType();
  }
  
  public long getSize()
  {
    if (this.mConnection == null) {
      try
      {
        seekTo(0L);
      }
      catch (IOException localIOException)
      {
        Logger.e("MediaHTTPConnection", "getSize", localIOException);
        return -1L;
      }
    }
    return this.mTotalSize;
  }
  
  public String getUri()
  {
    return this.mURL.toString();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramLong != this.mCurrentOffset) {
        seekTo(paramLong);
      }
      int i = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = i;
      if (i == -1) {
        paramInt1 = 0;
      }
      this.mCurrentOffset += paramInt1;
      return paramInt1;
    }
    catch (UnknownServiceException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readAt ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" => ");
      localStringBuilder.append(paramArrayOfByte);
      Logger.w("MediaHTTPConnection", localStringBuilder.toString());
      return -1010;
    }
    catch (NoRouteToHostException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readAt ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" => ");
      localStringBuilder.append(paramArrayOfByte);
      Logger.w("MediaHTTPConnection", localStringBuilder.toString());
      return -1010;
    }
    catch (ProtocolException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readAt ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" => ");
      localStringBuilder.append(paramArrayOfByte);
      Logger.w("MediaHTTPConnection", localStringBuilder.toString());
      return -1010;
    }
    catch (IOException paramArrayOfByte)
    {
      break label59;
    }
    catch (Exception paramArrayOfByte)
    {
      label56:
      label59:
      break label56;
    }
    return -3;
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPConnection
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.sonic.sdk.download;

import android.text.TextUtils;
import com.tencent.sonic.sdk.SonicSessionStream;
import com.tencent.sonic.sdk.SonicSessionStream.Callback;
import com.tencent.sonic.sdk.SonicUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

public class SonicDownloadClient
  implements SonicSessionStream.Callback
{
  private static final int READ_BUFFER_SIZE = 2048;
  public static final String TAG = "SonicSdk_SonicDownloadClient";
  private final SonicDownloadConnection mConn;
  private boolean mDownloadFinished = false;
  private ByteArrayOutputStream mOutputStream;
  private DownloadTask mTask;
  
  public SonicDownloadClient(DownloadTask paramDownloadTask)
  {
    this.mTask = paramDownloadTask;
    this.mConn = new SonicDownloadConnection(paramDownloadTask.mResourceUrl);
    this.mOutputStream = new ByteArrayOutputStream();
  }
  
  private boolean getResponseStream(AtomicBoolean arg1)
  {
    for (;;)
    {
      try
      {
        if (!readServerResponse(???)) {
          break label170;
        }
        if (this.mDownloadFinished)
        {
          ??? = null;
          this.mTask.mInputStream = new SonicSessionStream(this, this.mOutputStream, ???);
        }
        synchronized (this.mTask.mWasInterceptInvoked)
        {
          this.mTask.mWasInterceptInvoked.notify();
          if (this.mDownloadFinished)
          {
            SonicUtils.log("SonicSdk_SonicDownloadClient", 4, "sub resource compose a memory stream (" + this.mTask.mResourceUrl + ").");
            bool = true;
            return bool;
            ??? = this.mConn.getResponseStream();
          }
        }
        SonicUtils.log("SonicSdk_SonicDownloadClient", 4, "sub resource compose a bridge stream (" + this.mTask.mResourceUrl + ").");
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
  }
  
  private void onError(int paramInt)
  {
    Iterator localIterator = this.mTask.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      SonicDownloadCallback localSonicDownloadCallback = (SonicDownloadCallback)localIterator.next();
      if (localSonicDownloadCallback != null) {
        localSonicDownloadCallback.onError(paramInt);
      }
    }
    onFinish();
  }
  
  private void onFinish()
  {
    Iterator localIterator = this.mTask.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      SonicDownloadCallback localSonicDownloadCallback = (SonicDownloadCallback)localIterator.next();
      if (localSonicDownloadCallback != null) {
        localSonicDownloadCallback.onFinish();
      }
    }
    this.mConn.disconnect();
  }
  
  private void onProgress(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.mTask.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      SonicDownloadCallback localSonicDownloadCallback = (SonicDownloadCallback)localIterator.next();
      if (localSonicDownloadCallback != null) {
        localSonicDownloadCallback.onProgress(paramInt1, paramInt2);
      }
    }
  }
  
  private void onStart()
  {
    Iterator localIterator = this.mTask.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      SonicDownloadCallback localSonicDownloadCallback = (SonicDownloadCallback)localIterator.next();
      if (localSonicDownloadCallback != null) {
        localSonicDownloadCallback.onStart();
      }
    }
  }
  
  private void onSuccess(byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    Iterator localIterator = this.mTask.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      SonicDownloadCallback localSonicDownloadCallback = (SonicDownloadCallback)localIterator.next();
      if (localSonicDownloadCallback != null) {
        localSonicDownloadCallback.onSuccess(paramArrayOfByte, paramMap);
      }
    }
    onFinish();
  }
  
  private boolean readServerResponse(AtomicBoolean paramAtomicBoolean)
  {
    BufferedInputStream localBufferedInputStream = this.mConn.getResponseStream();
    if (localBufferedInputStream == null)
    {
      SonicUtils.log("SonicSdk_SonicDownloadClient", 6, "readServerResponse error: bufferedInputStream is null!");
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[2048];
      int n = this.mConn.connectionImpl.getContentLength();
      int i = 0;
      int j = 0;
      while ((paramAtomicBoolean == null) || (!paramAtomicBoolean.get()))
      {
        int k = localBufferedInputStream.read(arrayOfByte);
        i = k;
        if (-1 == k) {
          break;
        }
        this.mOutputStream.write(arrayOfByte, 0, k);
        int m = j + k;
        i = k;
        j = m;
        if (n > 0)
        {
          onProgress(m, n);
          i = k;
          j = m;
        }
      }
      if (i != -1) {
        break label188;
      }
    }
    catch (Exception paramAtomicBoolean)
    {
      SonicUtils.log("SonicSdk_SonicDownloadClient", 6, "readServerResponse error:" + paramAtomicBoolean.getMessage() + ".");
      return false;
    }
    this.mDownloadFinished = true;
    onSuccess(this.mOutputStream.toByteArray(), this.mConn.getResponseHeaderFields());
    label188:
    return true;
  }
  
  public int download()
  {
    onStart();
    int i = this.mConn.connect();
    if (i != 0)
    {
      onError(i);
      return i;
    }
    i = this.mConn.getResponseCode();
    if (i != 200)
    {
      onError(i);
      return i;
    }
    this.mTask.mRspHeaders = this.mConn.getResponseHeaderFields();
    if (getResponseStream(this.mTask.mWasInterceptInvoked)) {
      return 0;
    }
    return -1;
  }
  
  public void onClose(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    SonicUtils.log("SonicSdk_SonicDownloadClient", 4, "sub resource bridge stream on close(" + this.mTask.mResourceUrl + ").");
    if (!this.mDownloadFinished) {
      onSuccess(paramByteArrayOutputStream.toByteArray(), this.mConn.getResponseHeaderFields());
    }
  }
  
  public static class DownloadTask
  {
    public static final int STATE_DOWNLOADED = 3;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_INITIATE = 0;
    public static final int STATE_LOAD_FROM_CACHE = 4;
    public static final int STATE_QUEUEING = 1;
    public List<SonicDownloadCallback> mCallbacks = new ArrayList();
    public String mCookie;
    public InputStream mInputStream;
    public String mIpAddress;
    public String mResourceUrl;
    public Map<String, List<String>> mRspHeaders;
    public AtomicInteger mState = new AtomicInteger(0);
    public final AtomicBoolean mWasInterceptInvoked = new AtomicBoolean(false);
  }
  
  public class SonicDownloadConnection
  {
    final URLConnection connectionImpl;
    private BufferedInputStream responseStream;
    private String url;
    
    public SonicDownloadConnection(String paramString)
    {
      this.url = paramString;
      this.connectionImpl = createConnection();
      initConnection(this.connectionImpl);
    }
    
    /* Error */
    int connect()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 30	com/tencent/sonic/sdk/download/SonicDownloadClient$SonicDownloadConnection:connectionImpl	Ljava/net/URLConnection;
      //   6: instanceof 41
      //   9: ifeq +29 -> 38
      //   12: aload_0
      //   13: getfield 30	com/tencent/sonic/sdk/download/SonicDownloadClient$SonicDownloadConnection:connectionImpl	Ljava/net/URLConnection;
      //   16: checkcast 41	java/net/HttpURLConnection
      //   19: astore_2
      //   20: aload_2
      //   21: invokevirtual 43	java/net/HttpURLConnection:connect	()V
      //   24: iconst_0
      //   25: istore_1
      //   26: aload_0
      //   27: monitorexit
      //   28: iload_1
      //   29: ireturn
      //   30: astore_2
      //   31: sipush -901
      //   34: istore_1
      //   35: goto -9 -> 26
      //   38: iconst_m1
      //   39: istore_1
      //   40: goto -14 -> 26
      //   43: astore_2
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_2
      //   47: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	48	0	this	SonicDownloadConnection
      //   25	15	1	i	int
      //   19	2	2	localHttpURLConnection	HttpURLConnection
      //   30	1	2	localIOException	IOException
      //   43	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   20	24	30	java/io/IOException
      //   2	20	43	finally
      //   20	24	43	finally
    }
    
    URLConnection createConnection()
    {
      String str = this.url;
      Object localObject2;
      if (TextUtils.isEmpty(str)) {
        localObject2 = null;
      }
      Object localObject1;
      for (;;)
      {
        return localObject2;
        URLConnection localURLConnection2 = null;
        URLConnection localURLConnection1 = localURLConnection2;
        try
        {
          URL localURL = new URL(str);
          localObject1 = null;
          localObject2 = localURL;
          localURLConnection1 = localURLConnection2;
          if (!TextUtils.isEmpty(SonicDownloadClient.this.mTask.mIpAddress))
          {
            localURLConnection1 = localURLConnection2;
            localObject1 = localURL.getHost();
            localURLConnection1 = localURLConnection2;
            localObject2 = new URL(str.replace((CharSequence)localObject1, SonicDownloadClient.this.mTask.mIpAddress));
            localURLConnection1 = localURLConnection2;
            SonicUtils.log("SonicSdk_SonicDownloadClient", 4, "create UrlConnection with DNS-Prefetch(" + (String)localObject1 + " -> " + SonicDownloadClient.this.mTask.mIpAddress + ").");
          }
          localURLConnection1 = localURLConnection2;
          localURLConnection2 = ((URL)localObject2).openConnection();
          localObject2 = localURLConnection2;
          if (localURLConnection2 != null)
          {
            localObject2 = localURLConnection2;
            localURLConnection1 = localURLConnection2;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localURLConnection1 = localURLConnection2;
              localURLConnection2.setRequestProperty("Host", (String)localObject1);
              return localURLConnection2;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localURLConnection1;
          if (localURLConnection1 != null) {
            localObject1 = null;
          }
          SonicUtils.log("SonicSdk_SonicDownloadClient", 6, "create UrlConnection fail, error:" + localThrowable.getMessage() + ".");
        }
      }
      return localObject1;
    }
    
    public void disconnect()
    {
      HttpURLConnection localHttpURLConnection;
      if ((this.connectionImpl instanceof HttpURLConnection)) {
        localHttpURLConnection = (HttpURLConnection)this.connectionImpl;
      }
      try
      {
        localHttpURLConnection.disconnect();
        return;
      }
      catch (Exception localException)
      {
        SonicUtils.log("SonicSdk_SonicDownloadClient", 6, "disconnect error:" + localException.getMessage());
      }
    }
    
    int getResponseCode()
    {
      if ((this.connectionImpl instanceof HttpURLConnection)) {
        try
        {
          int i = ((HttpURLConnection)this.connectionImpl).getResponseCode();
          return i;
        }
        catch (IOException localIOException)
        {
          String str = localIOException.getMessage();
          SonicUtils.log("SonicSdk_SonicDownloadClient", 6, "getResponseCode error:" + str);
          return -901;
        }
      }
      return -1;
    }
    
    Map<String, List<String>> getResponseHeaderFields()
    {
      if (this.connectionImpl == null) {
        return null;
      }
      return this.connectionImpl.getHeaderFields();
    }
    
    BufferedInputStream getResponseStream()
    {
      if ((this.responseStream == null) && (this.connectionImpl != null)) {}
      try
      {
        InputStream localInputStream = this.connectionImpl.getInputStream();
        if ("gzip".equalsIgnoreCase(this.connectionImpl.getContentEncoding())) {}
        for (this.responseStream = new BufferedInputStream(new GZIPInputStream(localInputStream));; this.responseStream = new BufferedInputStream(localInputStream)) {
          return this.responseStream;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          SonicUtils.log("SonicSdk_SonicDownloadClient", 6, "getResponseStream error:" + localThrowable.getMessage() + ".");
        }
      }
    }
    
    boolean initConnection(URLConnection paramURLConnection)
    {
      if (paramURLConnection != null)
      {
        paramURLConnection.setConnectTimeout(5000);
        paramURLConnection.setReadTimeout(15000);
        paramURLConnection.setRequestProperty("method", "GET");
        paramURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        paramURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;");
        if (!TextUtils.isEmpty(SonicDownloadClient.this.mTask.mCookie)) {
          paramURLConnection.setRequestProperty("Cookie", SonicDownloadClient.this.mTask.mCookie);
        }
        return true;
      }
      return false;
    }
  }
  
  public static class SubResourceDownloadCallback
    extends SonicDownloadCallback.SimpleDownloadCallback
  {
    private String resourceUrl;
    
    public SubResourceDownloadCallback(String paramString)
    {
      this.resourceUrl = paramString;
    }
    
    public void onError(int paramInt)
    {
      if (SonicUtils.shouldLog(4)) {
        SonicUtils.log("SonicSdk_SonicDownloadClient", 4, "session download sub resource error: code = " + paramInt + ", url=" + this.resourceUrl);
      }
    }
    
    public void onStart()
    {
      if (SonicUtils.shouldLog(4)) {
        SonicUtils.log("SonicSdk_SonicDownloadClient", 4, "session start download sub resource, url=" + this.resourceUrl);
      }
    }
    
    public void onSuccess(byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
    {
      SonicUtils.saveResourceFiles(SonicUtils.getMD5(this.resourceUrl), paramArrayOfByte, paramMap);
      SonicUtils.saveSonicResourceData(this.resourceUrl, SonicUtils.getSHA1(paramArrayOfByte), paramArrayOfByte.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.download.SonicDownloadClient
 * JD-Core Version:    0.7.0.1
 */
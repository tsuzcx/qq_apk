package com.tencent.thumbplayer.core.drm.httpclient;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

public class Request
  implements Comparable<Request>
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 8000;
  @GuardedBy("mLock")
  private boolean mCanceled = false;
  private final int mDefaultTrafficStatsTag;
  private final Map<String, String> mHttpHeaders;
  private int mHttpMethod;
  private final Object mLock = new Object();
  private final byte[] mPostBody;
  @GuardedBy("mLock")
  private Request.NetworkRequestCompleteListener mRequestCompleteListener;
  private Integer mSequence;
  private Object mTag;
  private final int mTimeoutMs;
  private final String mUrl;
  
  public Request(int paramInt, @Nullable String paramString, @Nullable Request.NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this(paramInt, paramString, null, 8000, paramNetworkRequestCompleteListener);
  }
  
  public Request(int paramInt1, @Nullable String paramString, Map<String, String> paramMap, int paramInt2, @Nullable Request.NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this(paramInt1, paramString, paramMap, null, paramInt2, paramNetworkRequestCompleteListener);
  }
  
  public Request(int paramInt1, @Nullable String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt2, Request.NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this.mHttpMethod = paramInt1;
    this.mUrl = paramString;
    this.mPostBody = paramArrayOfByte;
    if (paramInt2 <= 0) {
      paramInt2 = 8000;
    }
    this.mTimeoutMs = paramInt2;
    this.mHttpHeaders = paramMap;
    this.mRequestCompleteListener = paramNetworkRequestCompleteListener;
    this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(paramString);
  }
  
  private static int findDefaultTrafficStatsTag(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  @CallSuper
  public void cancel()
  {
    synchronized (this.mLock)
    {
      this.mCanceled = true;
      this.mRequestCompleteListener = null;
      return;
    }
  }
  
  public int compareTo(Request paramRequest)
  {
    Request.Priority localPriority1 = getPriority();
    Request.Priority localPriority2 = paramRequest.getPriority();
    if (localPriority1 == localPriority2) {
      return this.mSequence.intValue() - paramRequest.mSequence.intValue();
    }
    return localPriority2.ordinal() - localPriority1.ordinal();
  }
  
  public void deliverError(IOException paramIOException)
  {
    synchronized (this.mLock)
    {
      Request.NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onErrorResponse(this, paramIOException);
      }
      return;
    }
  }
  
  public void deliverResponse(Response paramResponse)
  {
    synchronized (this.mLock)
    {
      Request.NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onResponseReceived(this, paramResponse);
      }
      return;
    }
  }
  
  public Map<String, String> getHeaders()
  {
    return this.mHttpHeaders;
  }
  
  public int getHttpMethod()
  {
    return this.mHttpMethod;
  }
  
  public byte[] getPostBody()
  {
    return this.mPostBody;
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.NORMAL;
  }
  
  public final int getSequence()
  {
    Integer localInteger = this.mSequence;
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalStateException("getSequence called before setSequence");
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public int getTimeoutMs()
  {
    return this.mTimeoutMs;
  }
  
  public int getTrafficStatsTag()
  {
    return this.mDefaultTrafficStatsTag;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isCanceled()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mCanceled;
      return bool;
    }
  }
  
  public Request setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0x");
    ((StringBuilder)localObject).append(Integer.toHexString(getTrafficStatsTag()));
    String str = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled()) {
      localObject = "[X] ";
    } else {
      localObject = "[ ] ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(getUrl());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(getPriority());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.mSequence);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Request
 * JD-Core Version:    0.7.0.1
 */
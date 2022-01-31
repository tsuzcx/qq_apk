package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Builder;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Callback;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class UrlRequestBuilderImpl
  extends UrlRequest.Builder
{
  private static final String ACCEPT_ENCODING = "Accept-Encoding";
  private static final String TAG = UrlRequestBuilderImpl.class.getSimpleName();
  private String mAddress;
  private String mBody;
  private byte[] mBodyBytes;
  private final UrlRequest.Callback mCallback;
  private boolean mDisableCache;
  private final Executor mExecutor;
  private String mHost;
  private String mMethod;
  private int mPriority = 3;
  private final ArrayList<Pair<String, String>> mRequestHeaders = new ArrayList();
  private final String mUrl;
  
  public UrlRequestBuilderImpl(String paramString, UrlRequest.Callback paramCallback, Executor paramExecutor)
  {
    if (paramString == null) {
      throw new NullPointerException("URL is required.");
    }
    if (paramCallback == null) {
      throw new NullPointerException("Callback is required.");
    }
    if (paramExecutor == null) {
      throw new NullPointerException("Executor is required.");
    }
    this.mUrl = paramString;
    this.mCallback = paramCallback;
    this.mExecutor = paramExecutor;
  }
  
  public UrlRequestBuilderImpl addHeader(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new NullPointerException("Invalid header name.");
    }
    if (paramString2 == null) {
      throw new NullPointerException("Invalid header value.");
    }
    if ("Accept-Encoding".equalsIgnoreCase(paramString1)) {
      return this;
    }
    this.mRequestHeaders.add(Pair.create(paramString1, paramString2));
    return this;
  }
  
  public UrlRequest build()
  {
    Object localObject1 = X5CoreEngine.getInstance();
    if ((localObject1 != null) && (((X5CoreEngine)localObject1).isX5Core()))
    {
      localObject1 = ((X5CoreEngine)localObject1).wizard().dexLoader();
      Object localObject2 = Integer.TYPE;
      Class localClass = Boolean.TYPE;
      String str1 = this.mUrl;
      int i = this.mPriority;
      UrlRequest.Callback localCallback = this.mCallback;
      Executor localExecutor = this.mExecutor;
      boolean bool = this.mDisableCache;
      String str2 = this.mMethod;
      ArrayList localArrayList = this.mRequestHeaders;
      String str3 = this.mBody;
      byte[] arrayOfByte = this.mBodyBytes;
      String str4 = this.mHost;
      String str5 = this.mAddress;
      localObject2 = (UrlRequest)((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[] { String.class, localObject2, UrlRequest.Callback.class, Executor.class, localClass, String.class, ArrayList.class, String.class, [B.class, String.class, String.class }, new Object[] { str1, Integer.valueOf(i), localCallback, localExecutor, Boolean.valueOf(bool), str2, localArrayList, str3, arrayOfByte, str4, str5 });
      localObject1 = localObject2;
      if (localObject2 == null) {
        throw new NullPointerException("UrlRequest build fail");
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public UrlRequestBuilderImpl disableCache()
  {
    this.mDisableCache = true;
    return this;
  }
  
  public UrlRequestBuilderImpl setDns(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("host and address are required.");
    }
    this.mHost = paramString1;
    this.mAddress = paramString2;
    return this;
  }
  
  public UrlRequest.Builder setHttpMethod(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Method is required.");
    }
    this.mMethod = paramString;
    return this;
  }
  
  public UrlRequestBuilderImpl setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
  
  public UrlRequest.Builder setRequestBody(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Body is required.");
    }
    this.mBody = paramString;
    return this;
  }
  
  public UrlRequest.Builder setRequestBodyBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Body is required.");
    }
    this.mBodyBytes = paramArrayOfByte;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.UrlRequestBuilderImpl
 * JD-Core Version:    0.7.0.1
 */
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
  private static final String a = UrlRequestBuilderImpl.class.getSimpleName();
  private final String b;
  private final UrlRequest.Callback c;
  private final Executor d;
  private String e;
  private final ArrayList<Pair<String, String>> f = new ArrayList();
  private boolean g;
  private int h = 3;
  private String i;
  private byte[] j;
  private String k;
  private String l;
  
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
    this.b = paramString;
    this.c = paramCallback;
    this.d = paramExecutor;
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
    this.f.add(Pair.create(paramString1, paramString2));
    return this;
  }
  
  public UrlRequest build()
  {
    Object localObject1 = x.a();
    Object localObject2;
    if ((localObject1 != null) && (((x)localObject1).b()))
    {
      DexLoader localDexLoader = ((x)localObject1).c().b();
      localObject1 = Integer.TYPE;
      localObject2 = Boolean.TYPE;
      String str1 = this.b;
      int m = this.h;
      UrlRequest.Callback localCallback = this.c;
      Executor localExecutor = this.d;
      boolean bool = this.g;
      String str2 = this.e;
      ArrayList localArrayList = this.f;
      String str3 = this.i;
      byte[] arrayOfByte = this.j;
      String str4 = this.k;
      String str5 = this.l;
      localObject2 = (UrlRequest)localDexLoader.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[] { String.class, localObject1, UrlRequest.Callback.class, Executor.class, localObject2, String.class, ArrayList.class, String.class, [B.class, String.class, String.class }, new Object[] { str1, Integer.valueOf(m), localCallback, localExecutor, Boolean.valueOf(bool), str2, localArrayList, str3, arrayOfByte, str4, str5 });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Integer.TYPE;
        localObject2 = Boolean.TYPE;
        str1 = this.b;
        m = this.h;
        localCallback = this.c;
        localExecutor = this.d;
        bool = this.g;
        str2 = this.e;
        localArrayList = this.f;
        str3 = this.i;
        localObject1 = (UrlRequest)localDexLoader.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[] { String.class, localObject1, UrlRequest.Callback.class, Executor.class, localObject2, String.class, ArrayList.class, String.class }, new Object[] { str1, Integer.valueOf(m), localCallback, localExecutor, Boolean.valueOf(bool), str2, localArrayList, str3 });
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = Integer.TYPE;
        localObject2 = Boolean.TYPE;
        str1 = this.b;
        m = this.h;
        localCallback = this.c;
        localExecutor = this.d;
        bool = this.g;
        str2 = this.e;
        localArrayList = this.f;
        localObject2 = (UrlRequest)localDexLoader.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[] { String.class, localObject1, UrlRequest.Callback.class, Executor.class, localObject2, String.class, ArrayList.class }, new Object[] { str1, Integer.valueOf(m), localCallback, localExecutor, Boolean.valueOf(bool), str2, localArrayList });
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Integer.TYPE;
        localObject2 = Boolean.TYPE;
        str1 = this.b;
        m = this.h;
        localCallback = this.c;
        localExecutor = this.d;
        bool = this.g;
        str2 = this.e;
        localArrayList = this.f;
        str3 = this.i;
        arrayOfByte = this.j;
        str4 = this.k;
        str5 = this.l;
        localObject1 = (UrlRequest)localDexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[] { String.class, localObject1, UrlRequest.Callback.class, Executor.class, localObject2, String.class, ArrayList.class, String.class, [B.class, String.class, String.class }, new Object[] { str1, Integer.valueOf(m), localCallback, localExecutor, Boolean.valueOf(bool), str2, localArrayList, str3, arrayOfByte, str4, str5 });
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        throw new NullPointerException("UrlRequest build fail");
      }
    }
    else
    {
      localObject2 = null;
    }
    return localObject2;
  }
  
  public UrlRequestBuilderImpl disableCache()
  {
    this.g = true;
    return this;
  }
  
  public UrlRequestBuilderImpl setDns(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("host and address are required.");
    }
    this.k = paramString1;
    this.l = paramString2;
    try
    {
      paramString1 = x.a();
      if ((paramString1 != null) && (paramString1.b()))
      {
        paramString1 = paramString1.c().b();
        paramString2 = this.k;
        String str = this.l;
        paramString1.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "setDns", new Class[] { String.class, String.class }, new Object[] { paramString2, str });
      }
      return this;
    }
    catch (Exception paramString1) {}
    return this;
  }
  
  public UrlRequest.Builder setHttpMethod(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Method is required.");
    }
    this.e = paramString;
    return this;
  }
  
  public UrlRequestBuilderImpl setPriority(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public UrlRequest.Builder setRequestBody(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Body is required.");
    }
    this.i = paramString;
    return this;
  }
  
  public UrlRequest.Builder setRequestBodyBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Body is required.");
    }
    this.j = paramArrayOfByte;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.UrlRequestBuilderImpl
 * JD-Core Version:    0.7.0.1
 */
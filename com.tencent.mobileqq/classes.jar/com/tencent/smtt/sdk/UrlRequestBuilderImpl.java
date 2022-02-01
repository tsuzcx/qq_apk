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
  private static final String a = "UrlRequestBuilderImpl";
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
    if (paramString != null)
    {
      if (paramCallback != null)
      {
        if (paramExecutor != null)
        {
          this.b = paramString;
          this.c = paramCallback;
          this.d = paramExecutor;
          return;
        }
        throw new NullPointerException("Executor is required.");
      }
      throw new NullPointerException("Callback is required.");
    }
    throw new NullPointerException("URL is required.");
  }
  
  public UrlRequestBuilderImpl addHeader(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        if ("Accept-Encoding".equalsIgnoreCase(paramString1)) {
          return this;
        }
        this.f.add(Pair.create(paramString1, paramString2));
        return this;
      }
      throw new NullPointerException("Invalid header value.");
    }
    throw new NullPointerException("Invalid header name.");
  }
  
  public UrlRequest build()
  {
    Object localObject1 = x.a();
    if ((localObject1 != null) && (((x)localObject1).b()))
    {
      DexLoader localDexLoader = ((x)localObject1).c().b();
      localObject1 = Integer.TYPE;
      Object localObject2 = Boolean.TYPE;
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
      if (localObject1 != null) {
        return localObject1;
      }
      throw new NullPointerException("UrlRequest build fail");
    }
    return null;
  }
  
  public UrlRequestBuilderImpl disableCache()
  {
    this.g = true;
    return this;
  }
  
  public UrlRequestBuilderImpl setDns(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.k = paramString1;
      this.l = paramString2;
    }
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
    throw new NullPointerException("host and address are required.");
    return this;
  }
  
  public UrlRequest.Builder setHttpMethod(String paramString)
  {
    if (paramString != null)
    {
      this.e = paramString;
      return this;
    }
    throw new NullPointerException("Method is required.");
  }
  
  public UrlRequestBuilderImpl setPriority(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public UrlRequest.Builder setRequestBody(String paramString)
  {
    if (paramString != null)
    {
      this.i = paramString;
      return this;
    }
    throw new NullPointerException("Body is required.");
  }
  
  public UrlRequest.Builder setRequestBodyBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.j = paramArrayOfByte;
      return this;
    }
    throw new NullPointerException("Body is required.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.UrlRequestBuilderImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.weiyun.model;

import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class DownloadJobContext
{
  private final String a;
  private final DownloadFile b;
  private final String c;
  private volatile boolean d;
  private volatile boolean e;
  private volatile boolean f;
  private volatile boolean g;
  private final WeiyunDownloadStatusInfo h;
  private long i;
  private String j;
  private String k;
  private HttpNetReq l;
  private IDownloadStatusListener m;
  
  private DownloadJobContext(String paramString1, String paramString2, DownloadFile paramDownloadFile, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.b = paramDownloadFile;
    this.h = paramWeiyunDownloadStatusInfo;
  }
  
  public static HttpNetReq a(Object paramObject, String paramString1, String paramString2, String paramString3, boolean paramBoolean, INetEngineListener paramINetEngineListener)
  {
    return a(paramObject, paramString1, paramString2, paramString3, paramBoolean, paramINetEngineListener, null);
  }
  
  public static HttpNetReq a(Object paramObject, String paramString1, String paramString2, String paramString3, boolean paramBoolean, INetEngineListener paramINetEngineListener, String paramString4)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = paramINetEngineListener;
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localHttpNetReq.mReqProperties = new HashMap();
      localHttpNetReq.mReqProperties.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHttpNetReq.mTempPath = paramString4;
    }
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(paramObject);
    localHttpNetReq.mSupportBreakResume = paramBoolean;
    return localHttpNetReq;
  }
  
  public static DownloadJobContext a(String paramString1, DownloadFile paramDownloadFile, String paramString2, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramDownloadFile != null) && (paramWeiyunDownloadStatusInfo != null)) {
      return new DownloadJobContext(paramString1, IOUtils.getDirPathNoSeparator(paramString2), paramDownloadFile, paramWeiyunDownloadStatusInfo);
    }
    throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
  }
  
  public void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void a(HttpNetReq paramHttpNetReq)
  {
    this.l = paramHttpNetReq;
  }
  
  public void a(IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.m = paramIDownloadStatusListener;
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public DownloadFile c()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public long h()
  {
    return this.i;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.k;
  }
  
  public HttpNetReq k()
  {
    return this.l;
  }
  
  public IDownloadStatusListener l()
  {
    return this.m;
  }
  
  public WeiyunDownloadStatusInfo m()
  {
    return this.h;
  }
  
  public WeiyunDownloadStatusInfo n()
  {
    return this.h.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.model.DownloadJobContext
 * JD-Core Version:    0.7.0.1
 */
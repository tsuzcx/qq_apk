package com.tencent.mobileqq.kandian.base.image.imageloader;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class RIJImageOptReport
{
  public static int a;
  public static long b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static IRIJImageOptReport h;
  
  private static int a(String paramString)
  {
    Map localMap = URLUtil.a(paramString);
    if (localMap.get("busiType") != null) {
      try
      {
        int i = Integer.parseInt((String)localMap.get("busiType"));
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("urlString: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("  busiType:");
        localStringBuilder.append((String)localMap.get("busiType"));
        QLog.e("RIJImageOptReport", 2, localStringBuilder.toString(), localNumberFormatException);
      }
    }
    return -1;
  }
  
  public static void a(int paramInt, ImageRequest paramImageRequest)
  {
    if (paramImageRequest != null)
    {
      if (paramInt == 1)
      {
        paramImageRequest.h = System.currentTimeMillis();
        return;
      }
      if (paramImageRequest.h != 0L)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt != 6)
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("unknown type: ");
                  localStringBuilder.append(paramInt);
                  localStringBuilder.append(" ");
                  localStringBuilder.append(paramImageRequest);
                  QLog.d("RIJImageOptReport", 1, localStringBuilder.toString());
                  return;
                }
                paramImageRequest.o = System.currentTimeMillis();
                return;
              }
              paramImageRequest.n = System.currentTimeMillis();
              return;
            }
            paramImageRequest.k = System.currentTimeMillis();
            return;
          }
          paramImageRequest.j = System.currentTimeMillis();
          return;
        }
        paramImageRequest.i = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(ImageRequest paramImageRequest)
  {
    IRIJImageOptReport localIRIJImageOptReport = h;
    if (localIRIJImageOptReport != null) {
      localIRIJImageOptReport.reportSlowImageRequest(paramImageRequest);
    }
  }
  
  public static void a(ImageRequest paramImageRequest, boolean paramBoolean, String paramString)
  {
    a(6, paramImageRequest);
    ThreadManager.getSubThreadHandler().post(new RIJImageOptReport.1(paramImageRequest, paramString));
  }
  
  public static void b(int paramInt, ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return;
    }
    paramImageRequest.p = paramInt;
  }
  
  private static void d(ImageRequest paramImageRequest)
  {
    long l2 = paramImageRequest.j - paramImageRequest.i;
    long l3 = paramImageRequest.k - paramImageRequest.j;
    long l4 = paramImageRequest.l;
    long l5 = paramImageRequest.m;
    long l1;
    if (paramImageRequest.n > 0L) {
      l1 = paramImageRequest.o - paramImageRequest.n;
    } else {
      l1 = 0L;
    }
    long l6 = paramImageRequest.o - paramImageRequest.h;
    int j = paramImageRequest.p;
    int i = paramImageRequest.q;
    long l7 = paramImageRequest.t;
    if (paramImageRequest.a != null) {
      localObject = paramImageRequest.a.toString();
    } else {
      localObject = "";
    }
    int k = a((String)localObject);
    String str1 = paramImageRequest.s;
    String str2 = paramImageRequest.r;
    paramImageRequest = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l2);
    localStringBuilder.append("");
    paramImageRequest.put("subThreadWaitTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l3);
    localStringBuilder.append("");
    paramImageRequest.put("threadPoolWaitTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l2 + l3);
    localStringBuilder.append("");
    paramImageRequest.put("threadWaitTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l4);
    localStringBuilder.append("");
    paramImageRequest.put("downloadAndWriteFileTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l5);
    localStringBuilder.append("");
    paramImageRequest.put("decodeTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("");
    paramImageRequest.put("mainThreadWaitTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    paramImageRequest.put("cacheType", localStringBuilder.toString());
    paramImageRequest.put("errMsg", str2);
    paramImageRequest.put("contentType", str1);
    paramImageRequest.put("fileSize", Long.valueOf(l7));
    paramImageRequest.put("urlStr", localObject);
    paramImageRequest.put("busiType", Integer.valueOf(k));
    j = NetConnInfoCenter.getActiveNetIpFamily(true);
    boolean bool;
    if ((j != 2) && (j != 3)) {
      bool = false;
    } else {
      bool = true;
    }
    paramImageRequest.put("ipv6", Boolean.valueOf(bool));
    Object localObject = h;
    if (localObject != null) {
      ((IRIJImageOptReport)localObject).reportQualityDataDimension(i, 6, l6, paramImageRequest);
    }
    if (QLog.isColorLevel())
    {
      a += 1;
      b += l6;
      c += l3;
      d += l1;
      e += l4;
      f += l5;
      g += l7;
      if (a == 100)
      {
        paramImageRequest = new StringBuilder();
        paramImageRequest.append("average  total: ");
        paramImageRequest.append((float)b / a);
        paramImageRequest.append(" size: ");
        paramImageRequest.append(g / a);
        paramImageRequest.append(" threapool: ");
        paramImageRequest.append((float)c / a);
        paramImageRequest.append(" mainthread: ");
        paramImageRequest.append((float)d / a);
        paramImageRequest.append(" downloadAndWriteFileTime: ");
        paramImageRequest.append((float)e / a);
        paramImageRequest.append(" decodeTime: ");
        paramImageRequest.append((float)f / a);
        QLog.d("RIJImageOptReport", 2, paramImageRequest.toString());
        a = 0;
        b = 0L;
        c = 0L;
        d = 0L;
        e = 0L;
        f = 0L;
        g = 0L;
      }
    }
  }
  
  private static boolean e(ImageRequest paramImageRequest)
  {
    boolean bool3 = ((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).isReportOn();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramImageRequest != null)
      {
        bool1 = bool2;
        if (paramImageRequest.h != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport
 * JD-Core Version:    0.7.0.1
 */
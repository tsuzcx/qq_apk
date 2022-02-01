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
  public static long a;
  public static IRIJImageOptReport a;
  public static long b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  
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
    if ((((IRIJImageOptConfig)QRoute.api(IRIJImageOptConfig.class)).isReportOn()) && (paramImageRequest != null))
    {
      if (paramInt == 1)
      {
        paramImageRequest.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      if (paramImageRequest.jdField_a_of_type_Long != 0L)
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
                paramImageRequest.h = System.currentTimeMillis();
                return;
              }
              paramImageRequest.g = System.currentTimeMillis();
              return;
            }
            paramImageRequest.jdField_d_of_type_Long = System.currentTimeMillis();
            return;
          }
          paramImageRequest.c = System.currentTimeMillis();
          return;
        }
        paramImageRequest.jdField_b_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(ImageRequest paramImageRequest)
  {
    IRIJImageOptReport localIRIJImageOptReport = jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageloaderIRIJImageOptReport;
    if (localIRIJImageOptReport != null) {
      localIRIJImageOptReport.reportSlowImageRequest(paramImageRequest);
    }
  }
  
  public static void a(ImageRequest paramImageRequest, boolean paramBoolean, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new RIJImageOptReport.1(paramImageRequest, paramString));
  }
  
  public static void b(int paramInt, ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return;
    }
    paramImageRequest.jdField_d_of_type_Int = paramInt;
  }
  
  private static boolean b(ImageRequest paramImageRequest)
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
        if (paramImageRequest.jdField_a_of_type_Long != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static void c(ImageRequest paramImageRequest)
  {
    long l2 = paramImageRequest.c - paramImageRequest.jdField_b_of_type_Long;
    long l3 = paramImageRequest.jdField_d_of_type_Long - paramImageRequest.c;
    long l4 = paramImageRequest.jdField_e_of_type_Long;
    long l5 = paramImageRequest.f;
    long l1;
    if (paramImageRequest.g > 0L) {
      l1 = paramImageRequest.h - paramImageRequest.g;
    } else {
      l1 = 0L;
    }
    long l6 = paramImageRequest.h - paramImageRequest.jdField_a_of_type_Long;
    int j = paramImageRequest.jdField_d_of_type_Int;
    int i = paramImageRequest.jdField_e_of_type_Int;
    long l7 = paramImageRequest.i;
    if (paramImageRequest.jdField_a_of_type_JavaNetURL != null) {
      localObject = paramImageRequest.jdField_a_of_type_JavaNetURL.toString();
    } else {
      localObject = "";
    }
    int k = a((String)localObject);
    String str1 = paramImageRequest.jdField_b_of_type_JavaLangString;
    String str2 = paramImageRequest.jdField_a_of_type_JavaLangString;
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
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageloaderIRIJImageOptReport;
    if (localObject != null) {
      ((IRIJImageOptReport)localObject).reportQualityDataDimension(i, 6, l6, paramImageRequest);
    }
    if (QLog.isColorLevel())
    {
      jdField_a_of_type_Int += 1;
      jdField_a_of_type_Long += l6;
      jdField_b_of_type_Long += l3;
      c += l1;
      jdField_d_of_type_Long += l4;
      jdField_e_of_type_Long += l5;
      f += l7;
      if (jdField_a_of_type_Int == 100)
      {
        paramImageRequest = new StringBuilder();
        paramImageRequest.append("average  total: ");
        paramImageRequest.append((float)jdField_a_of_type_Long / jdField_a_of_type_Int);
        paramImageRequest.append(" size: ");
        paramImageRequest.append(f / jdField_a_of_type_Int);
        paramImageRequest.append(" threapool: ");
        paramImageRequest.append((float)jdField_b_of_type_Long / jdField_a_of_type_Int);
        paramImageRequest.append(" mainthread: ");
        paramImageRequest.append((float)c / jdField_a_of_type_Int);
        paramImageRequest.append(" downloadAndWriteFileTime: ");
        paramImageRequest.append((float)jdField_d_of_type_Long / jdField_a_of_type_Int);
        paramImageRequest.append(" decodeTime: ");
        paramImageRequest.append((float)jdField_e_of_type_Long / jdField_a_of_type_Int);
        QLog.d("RIJImageOptReport", 2, paramImageRequest.toString());
        jdField_a_of_type_Int = 0;
        jdField_a_of_type_Long = 0L;
        jdField_b_of_type_Long = 0L;
        c = 0L;
        jdField_d_of_type_Long = 0L;
        jdField_e_of_type_Long = 0L;
        f = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport
 * JD-Core Version:    0.7.0.1
 */
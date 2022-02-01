package com.tencent.mobileqq.soload;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoloadService;

public class DownSoLoader
{
  public static String a(String paramString)
  {
    ISoloadService localISoloadService = (ISoloadService)QRoute.api(ISoloadService.class);
    if (localISoloadService != null) {
      return localISoloadService.getInitVer(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.DownSoLoader
 * JD-Core Version:    0.7.0.1
 */
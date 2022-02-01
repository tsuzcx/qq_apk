package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import java.util.HashMap;

public class HuayangPluginNewDownloaderUtil
{
  private static HashMap<String, IHuayangPluginNewDownloader> a = new HashMap();
  
  public static IHuayangPluginNewDownloader a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString1);
      String str = ((StringBuilder)localObject).toString();
      localObject = (IHuayangPluginNewDownloader)a.get(str);
      paramString1 = (String)localObject;
      if (localObject == null)
      {
        paramString1 = (IHuayangPluginNewDownloader)QRoute.api(IHuayangPluginNewDownloader.class);
        paramString1.init(paramContext.getApplicationContext(), a(paramContext), paramString2);
        a.put(str, paramString1);
      }
      return paramString1;
    }
    finally {}
  }
  
  public static File a(Context paramContext)
  {
    return paramContext.getFilesDir();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloaderUtil
 * JD-Core Version:    0.7.0.1
 */
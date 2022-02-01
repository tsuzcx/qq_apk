package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

public class HuayangDowanloadHelperUtil
{
  private static HashMap<String, IHuayangDowanloadHelper> a = new HashMap();
  
  public static IHuayangDowanloadHelper a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString1);
      String str = ((StringBuilder)localObject).toString();
      IHuayangDowanloadHelper localIHuayangDowanloadHelper = (IHuayangDowanloadHelper)a.get(str);
      localObject = localIHuayangDowanloadHelper;
      if (localIHuayangDowanloadHelper == null)
      {
        localObject = ((IHuayangDowanloadHelper)QRoute.api(IHuayangDowanloadHelper.class)).init(paramContext, paramString1, paramString2);
        a.put(str, localObject);
      }
      return localObject;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelperUtil
 * JD-Core Version:    0.7.0.1
 */
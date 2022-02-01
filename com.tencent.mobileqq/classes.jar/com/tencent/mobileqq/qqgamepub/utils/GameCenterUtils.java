package com.tencent.mobileqq.qqgamepub.utils;

import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GameCenterUtils
{
  public static LruCache<String, List<String>> a = new LruCache(10);
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap)
  {
    paramAppInterface = new WadlReportBuilder();
    paramAppInterface.a("dc00087").h(paramString1).c(paramString2).b(paramString3).a(1, paramString4).a(11, paramString5).a(12, paramString6);
    if ((paramMap != null) && (paramMap.keySet().size() > 0))
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Map.Entry)paramString1.next();
        paramAppInterface.a(((Integer)paramString2.getKey()).intValue(), (String)paramString2.getValue());
      }
    }
    paramAppInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils
 * JD-Core Version:    0.7.0.1
 */
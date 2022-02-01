package com.tencent.mobileqq.qqguildsdk.util;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GProUtil
{
  public static void a(Map<String, Long> paramMap)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramMap.entrySet().removeIf(new GProUtil.1());
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (System.currentTimeMillis() - ((Long)paramMap.get(str)).longValue() > 5000L) {
        localIterator.remove();
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    return Pattern.compile("[0-9]+").matcher(paramString).matches() ^ true;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    if ((!a(paramString)) && (paramLong != 0L)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramString);
    localStringBuilder.append("， categoryId ：");
    localStringBuilder.append(paramLong);
    GProLog.a("GProUtil", "isCategoryLegal", localStringBuilder.toString());
    return false;
  }
  
  public static boolean a(String paramString1, long paramLong, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString2)) && (a(paramString1, paramLong));
  }
  
  public static boolean a(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList)
  {
    boolean bool2 = a(paramString);
    boolean bool1 = false;
    if (bool2)
    {
      paramCategoryChannelSortInfo = new StringBuilder();
      paramCategoryChannelSortInfo.append("guildId ：");
      paramCategoryChannelSortInfo.append(paramString);
      GProLog.a("GProUtil", "isCategoryLegalForSort", paramCategoryChannelSortInfo.toString());
      return false;
    }
    int i;
    if ((paramCategoryChannelSortInfo != null) && (paramCategoryChannelSortInfo.c() != null)) {
      i = paramCategoryChannelSortInfo.c().size() + 0;
    } else {
      i = 0;
    }
    int j = i;
    if (paramList != null)
    {
      paramString = paramList.iterator();
      while (paramString.hasNext()) {
        if (!((CategoryChannelSortInfo)paramString.next()).d()) {
          paramString.remove();
        }
      }
      j = i + paramList.size();
    }
    if (j >= 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(""))) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("， categoryName ：");
    localStringBuilder.append(paramString2);
    GProLog.a("GProUtil", "isCategoryLegal", localStringBuilder.toString());
    return false;
  }
  
  public static boolean a(String paramString, List<Long> paramList)
  {
    boolean bool2 = a(paramString);
    boolean bool1 = false;
    if ((!bool2) && (paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        if (l == 0L)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("guildId ：");
          localStringBuilder.append(paramString);
          localStringBuilder.append("， categoryId ：");
          localStringBuilder.append(l);
          GProLog.a("GProUtil", "isCategoryLegal", localStringBuilder.toString());
          localIterator.remove();
        }
      }
      if (paramList.size() > 0) {
        bool1 = true;
      }
      return bool1;
    }
    paramList = new StringBuilder();
    paramList.append("guildId ：");
    paramList.append(paramString);
    GProLog.a("GProUtil", "isCategoryLegal", paramList.toString());
    return false;
  }
  
  public static boolean a(List<String> paramList)
  {
    if (paramList == null) {
      return true;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (a((String)localIterator.next())) {
        localIterator.remove();
      }
    }
    return paramList.size() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.search.util.intercept;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.mobileqq.search.util.intercept.bean.SogouInterceptRuleItem;
import com.tencent.mobileqq.search.util.intercept.bean.SogouInterceptRuleListHolder;
import com.tencent.mobileqq.search.util.intercept.cache.SogouInterceptPatternCache;
import com.tencent.util.URLUtil;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SogouInterceptController
{
  private static final Map<String, String> a = new HashMap();
  private static final Object b = new Object();
  
  public static SogouInterceptController a()
  {
    return SogouInterceptController.Holder.a();
  }
  
  private boolean a(SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString)
  {
    if (paramSogouInterceptRuleItem != null)
    {
      if (!paramSogouInterceptRuleItem.h()) {
        return false;
      }
      if (!c(paramSogouInterceptRuleItem, paramString)) {
        return false;
      }
      Map localMap = URLUtil.a(paramString);
      if (localMap == null) {
        return false;
      }
      if (!d(paramSogouInterceptRuleItem, paramString, localMap)) {
        return false;
      }
      if (c(paramSogouInterceptRuleItem, paramString, localMap))
      {
        if (!b(paramSogouInterceptRuleItem, paramString, localMap)) {
          return false;
        }
        if (!a(paramSogouInterceptRuleItem, paramString, localMap)) {
          return false;
        }
        return b(paramSogouInterceptRuleItem, paramString);
      }
    }
    return false;
  }
  
  private boolean a(@NonNull SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString, Map<String, String> paramMap)
  {
    paramSogouInterceptRuleItem = paramSogouInterceptRuleItem.f();
    if (paramSogouInterceptRuleItem.size() == 0) {
      return true;
    }
    paramMap = (String)paramSogouInterceptRuleItem.get("regular");
    int i;
    try
    {
      i = Integer.parseInt((String)paramSogouInterceptRuleItem.get("startCount"));
    }
    catch (Exception paramSogouInterceptRuleItem)
    {
      paramSogouInterceptRuleItem.printStackTrace();
      i = 0;
    }
    if (!TextUtils.isEmpty(paramMap))
    {
      if (i <= 0) {
        return false;
      }
      paramSogouInterceptRuleItem = paramString;
      if (paramString.length() > i) {
        paramSogouInterceptRuleItem = paramString.substring(0, i);
      }
      return a(paramSogouInterceptRuleItem, paramMap);
    }
    return false;
  }
  
  private boolean a(@NonNull String paramString1, String paramString2)
  {
    paramString2 = SogouInterceptPatternCache.a(paramString2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString2 != null)
    {
      paramString1 = paramString2.matcher(paramString1);
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (paramString1.find()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean b(@NonNull SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString)
  {
    paramSogouInterceptRuleItem = paramSogouInterceptRuleItem.g();
    if (TextUtils.isEmpty(paramSogouInterceptRuleItem)) {
      return true;
    }
    return a(paramString, paramSogouInterceptRuleItem);
  }
  
  private boolean b(@NonNull SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString, @NonNull Map<String, String> paramMap)
  {
    if (paramSogouInterceptRuleItem.e().size() == 0) {
      return true;
    }
    paramSogouInterceptRuleItem = paramSogouInterceptRuleItem.e();
    paramString = paramSogouInterceptRuleItem.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if ((paramMap.containsKey(str)) && (TextUtils.equals((CharSequence)paramSogouInterceptRuleItem.get(str), (CharSequence)paramMap.get(str)))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean c(@NonNull SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString)
  {
    if (paramSogouInterceptRuleItem.b().size() == 0) {
      return true;
    }
    paramSogouInterceptRuleItem = paramSogouInterceptRuleItem.b().iterator();
    while (paramSogouInterceptRuleItem.hasNext()) {
      if (paramString.startsWith((String)paramSogouInterceptRuleItem.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean c(@NonNull SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString, @NonNull Map<String, String> paramMap)
  {
    paramSogouInterceptRuleItem = paramSogouInterceptRuleItem.d();
    paramString = paramSogouInterceptRuleItem.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      if ((!paramMap.containsKey(str)) || (!TextUtils.equals((CharSequence)paramSogouInterceptRuleItem.get(str), (CharSequence)paramMap.get(str)))) {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  private SogouInterceptRuleItem d(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = SogouInterceptRuleListHolder.a().iterator();
    while (localIterator.hasNext())
    {
      SogouInterceptRuleItem localSogouInterceptRuleItem = (SogouInterceptRuleItem)localIterator.next();
      if ((localSogouInterceptRuleItem != null) && (TextUtils.equals(localSogouInterceptRuleItem.a(), paramString))) {
        localObject = localSogouInterceptRuleItem;
      }
    }
    return localObject;
  }
  
  private boolean d(@NonNull SogouInterceptRuleItem paramSogouInterceptRuleItem, @NonNull String paramString, @NonNull Map<String, String> paramMap)
  {
    if (paramSogouInterceptRuleItem.c().size() == 0) {
      return false;
    }
    paramSogouInterceptRuleItem = paramSogouInterceptRuleItem.c().iterator();
    while (paramSogouInterceptRuleItem.hasNext())
    {
      paramString = (String)paramSogouInterceptRuleItem.next();
      if ((!TextUtils.isEmpty(paramString)) && (paramMap.containsKey(paramString)) && (!TextUtils.isEmpty((String)paramMap.get(paramString)))) {
        return true;
      }
    }
    return false;
  }
  
  @VisibleForTesting
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = new URL(paramString).getHost();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = localObject;
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.endsWith("sogou.com")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  public String b(String paramString)
  {
    boolean bool = a(paramString);
    String str2 = "";
    if (!bool) {
      return "";
    }
    Map localMap = URLUtil.a(paramString);
    String str1 = str2;
    if (localMap != null)
    {
      paramString = d(c(paramString));
      str1 = str2;
      if (paramString != null)
      {
        Iterator localIterator = paramString.c().iterator();
        str1 = str2;
        while (localIterator.hasNext())
        {
          paramString = (String)localMap.get((String)localIterator.next());
          str1 = paramString;
          if (!TextUtils.isEmpty(paramString)) {
            str1 = paramString;
          }
        }
      }
    }
    return str1;
  }
  
  public String c(@NonNull String paramString)
  {
    synchronized (b)
    {
      if (a.containsKey(paramString)) {
        ??? = (String)a.get(paramString);
      } else {
        ??? = "";
      }
      ??? = ???;
      if (TextUtils.isEmpty((CharSequence)???))
      {
        Iterator localIterator = SogouInterceptRuleListHolder.a().iterator();
        do
        {
          ??? = ???;
          if (!localIterator.hasNext()) {
            break;
          }
          ??? = (SogouInterceptRuleItem)localIterator.next();
        } while ((!a((SogouInterceptRuleItem)???, paramString)) || (TextUtils.isEmpty(((SogouInterceptRuleItem)???).a())));
        ??? = ((SogouInterceptRuleItem)???).a();
      }
      synchronized (b)
      {
        a.put(paramString, ???);
        return ???;
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.intercept.SogouInterceptController
 * JD-Core Version:    0.7.0.1
 */
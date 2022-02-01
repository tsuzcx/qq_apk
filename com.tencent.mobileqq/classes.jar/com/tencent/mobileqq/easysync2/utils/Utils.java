package com.tencent.mobileqq.easysync2.utils;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
  public static int a = 36;
  
  public static String a(String paramString1, String paramString2, StringReplacement paramStringReplacement)
  {
    paramString1 = Pattern.compile(paramString2).matcher(paramString1);
    paramString2 = new StringBuffer();
    while (paramString1.find()) {
      paramString1.appendReplacement(paramString2, paramStringReplacement.a(paramString1));
    }
    paramString1.appendTail(paramString2);
    return paramString2.toString();
  }
  
  @Nullable
  public static <E> List<E> a(List<E> paramList, int paramInt1, int paramInt2)
  {
    return a(paramList, paramInt1, paramInt2, null);
  }
  
  @Nullable
  public static <E> List<E> a(List<E> paramList1, int paramInt1, int paramInt2, List<E> paramList2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramList1 != null)
    {
      if (paramInt1 >= paramList1.size()) {
        return null;
      }
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = paramInt1 + paramList1.size();
      }
      if (paramInt2 > 0)
      {
        localObject2 = new ArrayList();
        paramInt1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject1 = localObject2;
          if (i >= paramList1.size()) {
            break;
          }
          ((List)localObject2).add(paramList1.get(i));
          paramList1.remove(i);
          paramInt1 += 1;
        }
      }
      localObject2 = localObject1;
      if (paramList2 != null)
      {
        paramList1.addAll(i, paramList2);
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (paramString1 == paramString2) || ((paramString1 != null) && (paramString1.equals(paramString2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.utils.Utils
 * JD-Core Version:    0.7.0.1
 */
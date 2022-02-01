package com.tencent.mobileqq.pic;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class URLDrawableDepWrapInit
{
  private static List<String> a = new CopyOnWriteArrayList();
  
  public static URLDrawableDepWrap a()
  {
    URLDrawableDepWrap localURLDrawableDepWrap = new URLDrawableDepWrap();
    localURLDrawableDepWrap.mCache = new URLDrawableDepWrapInit.1();
    localURLDrawableDepWrap.mTool = new URLDrawableDepWrapInit.2();
    localURLDrawableDepWrap.mLog = new URLDrawableDepWrapInit.3();
    localURLDrawableDepWrap.mThreadManager = new URLDrawableDepWrapInit.4();
    localURLDrawableDepWrap.mVersion = new URLDrawableDepWrapInit.5();
    a(localURLDrawableDepWrap);
    return localURLDrawableDepWrap;
  }
  
  private static void a(URLDrawableDepWrap paramURLDrawableDepWrap)
  {
    paramURLDrawableDepWrap.mReport = new URLDrawableDepWrapInit.6();
  }
  
  protected static void a(Long paramLong)
  {
    if (SystemClock.uptimeMillis() % 100L == 0L) {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "AioPicDispatchWait", true, paramLong.longValue(), 0L, null, null);
    }
  }
  
  protected static void a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 2)
    {
      String str = (String)paramArrayOfObject[0];
      paramArrayOfObject = (Exception)paramArrayOfObject[1];
    }
  }
  
  private static String b(Exception paramException, boolean paramBoolean)
  {
    if (paramException == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramException = paramException.getStackTrace();
    ArrayList localArrayList = new ArrayList(8);
    int m = paramException.length;
    int j = 0;
    int i;
    for (int k = 0; j < m; k = i)
    {
      Object localObject = paramException[j];
      String str = localObject.getClassName();
      i = k;
      if (!str.contains("URLDrawable"))
      {
        i = k;
        if (!str.startsWith("android."))
        {
          i = k;
          if (!str.startsWith("java."))
          {
            i = k;
            if (!str.startsWith("com.android.")) {
              if (str.startsWith("dalvik."))
              {
                i = k;
              }
              else
              {
                k += 1;
                if (k >= 8) {
                  break;
                }
                localArrayList.add(localObject.toString());
                localStringBuffer.append(localObject.toString());
                localStringBuffer.append(",");
                i = k;
                if (paramBoolean)
                {
                  localStringBuffer.append("\n");
                  i = k;
                }
              }
            }
          }
        }
      }
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split(",");
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = 0;
    while ((i < paramString.length) && (i < paramInt))
    {
      int j = paramString[i].indexOf("(");
      if (j > 0)
      {
        localStringBuilder.append(paramString[i].substring(0, j));
        localStringBuilder.append("()");
        localStringBuilder.append(",");
      }
      else
      {
        localStringBuilder.append(paramString[i]);
        localStringBuilder.append(",");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void b(Exception paramException, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong) {}
  
  protected static void b(Long paramLong)
  {
    if (SystemClock.uptimeMillis() % 100L == 0L) {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "AioPicDownloadWait", true, paramLong.longValue(), 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit
 * JD-Core Version:    0.7.0.1
 */
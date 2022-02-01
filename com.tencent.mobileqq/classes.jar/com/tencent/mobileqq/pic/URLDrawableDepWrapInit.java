package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.image.api.URLDrawableDepWrap;
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
  
  private static String b(Exception paramException, boolean paramBoolean)
  {
    int k = 0;
    if (paramException == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramException = paramException.getStackTrace();
    ArrayList localArrayList = new ArrayList(8);
    int m = paramException.length;
    int i = 0;
    Object localObject;
    int j;
    if (i < m)
    {
      localObject = paramException[i];
      String str = localObject.getClassName();
      j = k;
      if (!str.contains("URLDrawable"))
      {
        j = k;
        if (!str.startsWith("android."))
        {
          j = k;
          if (!str.startsWith("java."))
          {
            j = k;
            if (!str.startsWith("com.android."))
            {
              if (!str.startsWith("dalvik.")) {
                break label134;
              }
              j = k;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      k = j;
      break;
      label134:
      k += 1;
      if (k >= 8) {
        return localStringBuffer.toString();
      }
      localArrayList.add(localObject.toString());
      localStringBuffer.append(localObject.toString()).append(",");
      j = k;
      if (paramBoolean)
      {
        localStringBuffer.append("\n");
        j = k;
      }
    }
  }
  
  private static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split(",");
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = 0;
    if ((i < paramString.length) && (i < paramInt))
    {
      int j = paramString[i].indexOf("(");
      if (j > 0) {
        localStringBuilder.append(paramString[i].substring(0, j)).append("()").append(",");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString[i]).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void b(Exception paramException, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit
 * JD-Core Version:    0.7.0.1
 */
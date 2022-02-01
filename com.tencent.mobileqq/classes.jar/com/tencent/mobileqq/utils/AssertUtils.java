package com.tencent.mobileqq.utils;

import com.tencent.biz.qqstory.support.logging.SLog;

public class AssertUtils
{
  public static <T> T a(T paramT)
  {
    if (paramT == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNotNull failed:");
      localStringBuilder.append(a(2));
      SLog.e("Q.qqstory.AssertUtils", localStringBuilder.toString());
    }
    return paramT;
  }
  
  public static String a(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject = new RuntimeException("getStackTrace").getStackTrace();
        localStringBuilder1 = new StringBuilder();
        i = paramInt;
        if (localObject.length > paramInt) {
          continue;
        }
        i = localObject.length;
      }
      catch (Exception localException)
      {
        Object localObject;
        StringBuilder localStringBuilder1;
        int i;
        StringBuilder localStringBuilder2;
        continue;
        paramInt = 2;
        continue;
      }
      if (paramInt >= i) {
        continue;
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n");
      localStringBuilder2.append(localObject[paramInt].toString());
      localStringBuilder1.append(localStringBuilder2.toString());
      paramInt += 1;
    }
    localObject = localStringBuilder1.toString();
    return localObject;
    return "";
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("assertTrue failed:");
      localStringBuilder.append(a(4));
      SLog.e("Q.qqstory.AssertUtils", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AssertUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.qphone.base.util.QLog;

public class GProLog
{
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return b(paramString1, true, "parameter error", paramString2, paramString3, -1);
  }
  
  public static int a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(seq: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString3);
    a(paramString1, paramBoolean, paramString2, localStringBuilder.toString());
    return paramInt;
  }
  
  public static int a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString4);
    return a(paramString1, paramBoolean, paramString2, localStringBuilder.toString(), paramInt);
  }
  
  public static int a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    return a(paramString1, paramBoolean, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, -1);
  }
  
  public static int a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramString5 != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[result：");
      localStringBuilder2.append(paramInt1);
      localStringBuilder2.append(", errMsg: ");
      localStringBuilder2.append(paramString5);
      localStringBuilder2.append("]");
      paramString5 = localStringBuilder2.toString();
    }
    else
    {
      paramString5 = "";
    }
    localStringBuilder1.append(paramString5);
    localStringBuilder1.append(paramString6);
    return a(paramString1, paramBoolean, paramString2, paramString3, paramString4, localStringBuilder1.toString(), paramInt2);
  }
  
  public static int a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return a(paramString1, paramBoolean, paramString2, paramString3, paramString4, paramString5, -1);
  }
  
  public static int a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(desc:");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString5);
    return a(paramString1, paramBoolean, paramString2, paramString3, localStringBuilder.toString(), paramInt);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("【gpro_sdk】");
        localStringBuilder.append(paramString1);
        QLog.d(localStringBuilder.toString(), paramInt, paramString2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("【gpro_sdk】");
      localStringBuilder.append(paramString1);
      QLog.d(localStringBuilder.toString(), paramInt, paramString2);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("】 ");
    localStringBuilder.append(paramString3);
    b(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    a(paramString1, i, paramString2);
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("】 ");
    localStringBuilder.append(paramString3);
    a(paramString1, paramBoolean, localStringBuilder.toString());
  }
  
  public static int b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(seq: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString3);
    b(paramString1, paramBoolean, paramString2, localStringBuilder.toString());
    return paramInt;
  }
  
  public static int b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString4);
    return b(paramString1, paramBoolean, paramString2, localStringBuilder.toString(), paramInt);
  }
  
  public static int b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    return b(paramString1, paramBoolean, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, -1);
  }
  
  public static int b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramString5 != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[result：");
      localStringBuilder2.append(paramInt1);
      localStringBuilder2.append(", errMsg: ");
      localStringBuilder2.append(paramString5);
      localStringBuilder2.append("]");
      paramString5 = localStringBuilder2.toString();
    }
    else
    {
      paramString5 = "";
    }
    localStringBuilder1.append(paramString5);
    localStringBuilder1.append(paramString6);
    return b(paramString1, paramBoolean, paramString2, paramString3, paramString4, localStringBuilder1.toString(), paramInt2);
  }
  
  public static int b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return b(paramString1, paramBoolean, paramString2, paramString3, paramString4, paramString5, -1);
  }
  
  public static int b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(desc:");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString5);
    return b(paramString1, paramBoolean, paramString2, paramString3, localStringBuilder.toString(), paramInt);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("【gpro_sdk】");
        localStringBuilder.append(paramString1);
        QLog.w(localStringBuilder.toString(), paramInt, paramString2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("【gpro_sdk】");
      localStringBuilder.append(paramString1);
      QLog.w(localStringBuilder.toString(), paramInt, paramString2);
    }
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("】 ");
    localStringBuilder.append(paramString3);
    c(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    d(paramString1, i, paramString2);
  }
  
  public static void b(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("】 ");
    localStringBuilder.append(paramString3);
    b(paramString1, paramBoolean, localStringBuilder.toString());
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("【gpro_sdk】");
        localStringBuilder.append(paramString1);
        QLog.e(localStringBuilder.toString(), paramInt, paramString2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("【gpro_sdk】");
      localStringBuilder.append(paramString1);
      QLog.e(localStringBuilder.toString(), paramInt, paramString2);
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("】 ");
    localStringBuilder.append(paramString3);
    d(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramInt != 1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("【gpro_sdk】");
        localStringBuilder.append(paramString1);
        QLog.i(localStringBuilder.toString(), paramInt, paramString2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("【gpro_sdk】");
      localStringBuilder.append(paramString1);
      QLog.i(localStringBuilder.toString(), paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProLog
 * JD-Core Version:    0.7.0.1
 */
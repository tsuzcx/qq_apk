package com.tencent.mobileqq.now.utils;

public final class UrlUtil
{
  public static final String a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("?");
    if (i != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      i = paramString1.indexOf(localStringBuilder.toString(), i + 1);
      if (i != -1)
      {
        int j = paramString1.indexOf("&", paramString2.length() + i + 1);
        if (j != -1) {
          return paramString1.substring(i + paramString2.length() + 1, j);
        }
        return paramString1.substring(i + paramString2.length() + 1);
      }
    }
    return null;
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf("?");
    if (i != -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      i = paramString1.indexOf(localStringBuilder.toString(), i + 1);
      if (i != -1)
      {
        int j = paramString1.indexOf("&", paramString2.length() + i + 1);
        if (j != -1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1.substring(0, i));
          localStringBuilder.append(paramString2);
          localStringBuilder.append("=");
          localStringBuilder.append(paramString3);
          localStringBuilder.append(paramString1.substring(j));
          return localStringBuilder.toString();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1.substring(0, i));
        localStringBuilder.append(paramString2);
        localStringBuilder.append("=");
        localStringBuilder.append(paramString3);
        return localStringBuilder.toString();
      }
      if (paramString1.lastIndexOf("&") == paramString1.length() - 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        localStringBuilder.append("=");
        localStringBuilder.append(paramString3);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static final String b(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("?");
    Object localObject = paramString1;
    if (i != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("=");
      i = paramString1.indexOf(((StringBuilder)localObject).toString(), i + 1);
      localObject = paramString1;
      if (i != -1)
      {
        int j = paramString1.indexOf("&", paramString2.length() + i + 1);
        if (j != -1)
        {
          paramString2 = new StringBuilder();
          paramString2.append(paramString1.substring(0, i));
          paramString2.append(paramString1.substring(j + 1));
          return paramString2.toString();
        }
        localObject = paramString1.substring(0, i - 1);
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.utils.UrlUtil
 * JD-Core Version:    0.7.0.1
 */
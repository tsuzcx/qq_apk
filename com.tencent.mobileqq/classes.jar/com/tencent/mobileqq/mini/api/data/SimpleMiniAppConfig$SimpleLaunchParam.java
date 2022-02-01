package com.tencent.mobileqq.mini.api.data;

import android.text.TextUtils;

public class SimpleMiniAppConfig$SimpleLaunchParam
{
  public String entryPath;
  public String miniAppId;
  public String reportData;
  public int scene = 9999;
  
  public static String standardEntryPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.indexOf("?");
    String str = "";
    Object localObject1;
    if (i != -1)
    {
      localObject1 = paramString.substring(0, i);
      localObject2 = paramString.substring(i + 1, paramString.length());
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = paramString;
    if (!paramString.toLowerCase().endsWith(".html"))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".html");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString = str;
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("?");
      paramString.append((String)localObject1);
      paramString = paramString.toString();
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam
 * JD-Core Version:    0.7.0.1
 */
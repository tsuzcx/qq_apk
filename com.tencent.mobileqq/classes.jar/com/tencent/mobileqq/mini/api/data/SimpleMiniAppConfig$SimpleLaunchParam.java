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
    String str = "";
    int i = paramString.indexOf("?");
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = paramString.substring(0, i);
      str = paramString.substring(i + 1, paramString.length());
    }
    paramString = (String)localObject;
    if (!((String)localObject).toLowerCase().endsWith(".html")) {
      paramString = (String)localObject + ".html";
    }
    localObject = new StringBuilder().append(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (paramString = "";; paramString = "?" + str) {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam
 * JD-Core Version:    0.7.0.1
 */
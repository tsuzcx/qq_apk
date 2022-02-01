package com.tencent.qqmini.minigame.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@MiniKeep
public class PathUtil
{
  public static JSONObject getJSONQueryString(String paramString)
  {
    int i = 0;
    localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int j = paramString.indexOf("?");
        String str = paramString;
        if (j > -1)
        {
          str = paramString;
          if (paramString.length() > j + 1) {
            str = paramString.substring(j + 1);
          }
        }
        paramString = str.split("&");
        if ((paramString != null) && (paramString.length > 0))
        {
          j = paramString.length;
          while (i < j)
          {
            str = paramString[i];
            if (!TextUtils.isEmpty(str))
            {
              int k = str.indexOf("=");
              if (k >= 0) {
                localJSONObject.put(str.substring(0, k), str.substring(k + 1));
              }
            }
            i += 1;
          }
        }
      }
      return localJSONObject;
    }
    catch (Throwable paramString)
    {
      QMLog.e("PathUtil", "getJSONQueryString exception " + paramString);
    }
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("http://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.PathUtil
 * JD-Core Version:    0.7.0.1
 */
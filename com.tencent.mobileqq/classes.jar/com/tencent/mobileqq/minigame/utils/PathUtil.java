package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PathUtil
{
  public static JSONObject getJSONQueryString(String paramString)
  {
    localJSONObject = new JSONObject();
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString))
      {
        int j = paramString.indexOf("?");
        localObject = paramString;
        int i;
        if (j > -1)
        {
          i = paramString.length();
          j += 1;
          localObject = paramString;
          if (i > j) {
            localObject = paramString.substring(j);
          }
        }
        paramString = ((String)localObject).split("&");
        if ((paramString != null) && (paramString.length > 0))
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject = paramString[i];
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              int k = ((String)localObject).indexOf("=");
              if (k >= 0) {
                localJSONObject.put(((String)localObject).substring(0, k), ((String)localObject).substring(k + 1));
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getJSONQueryString exception ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("PathUtil", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("http://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.PathUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class MiniappHttpUtil
{
  public static final int LOCAL_RET_CODE_ABORTED = -5;
  public static final int LOCAL_RET_CODE_CONNECT = -2;
  public static final int LOCAL_RET_CODE_EXCEPTION = -1;
  public static final int LOCAL_RET_CODE_METHOD_NOT_SUPPORT = -3;
  public static final int LOCAL_RET_CODE_URL_INVALID = -4;
  private static final String TAG = "MiniappHttpUtil";
  
  public static void fillErrMsg(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramInt == -5) || ((paramInt != -3) && (paramInt != -2))) {}
    try
    {
      paramJSONObject.put("errMsg", "unknown reason");
      return;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder;
      break label86;
    }
    paramJSONObject.put("errMsg", "request protocol error");
    return;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "abort";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(":fail abort");
      paramString = localStringBuilder.toString();
    }
    paramJSONObject.put("errMsg", paramString);
    return;
    label86:
    QMLog.e("MiniappHttpUtil", "fillErrMsg", paramString);
  }
  
  public static boolean isRefererVersionValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("MiniappHttpUtil", "version is null, return.");
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (((k <= 31) && (k != 9)) || (k >= 127)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.repo.playfeeds;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class PlayFeedsSPUtils
{
  private static HashMap<String, Boolean> a = new HashMap();
  
  public static HashMap<String, Boolean> a(AppRuntime paramAppRuntime)
  {
    a.clear();
    a.putAll(b(paramAppRuntime));
    return a;
  }
  
  private static HashMap<String, Boolean> b(AppRuntime paramAppRuntime)
  {
    HashMap localHashMap = new HashMap();
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return localHashMap;
    }
    paramAppRuntime = paramAppRuntime.getString("READINJOY_VIDEO_CHANNEL_LIKE_UNLIKE_SP2", "");
    if (TextUtils.isEmpty(paramAppRuntime)) {
      return localHashMap;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLikeUnLikeSP likeUnLikeSp:");
      localStringBuilder.append(paramAppRuntime);
      QLog.d("PlayFeedsSPUtils", 2, localStringBuilder.toString());
    }
    paramAppRuntime = paramAppRuntime.split(";");
    if ((paramAppRuntime != null) && (paramAppRuntime.length > 0))
    {
      int i = 0;
      while (i < paramAppRuntime.length)
      {
        if (!TextUtils.isEmpty(paramAppRuntime[i])) {
          localHashMap.put(paramAppRuntime[i], Boolean.valueOf(true));
        }
        i += 1;
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.playfeeds.PlayFeedsSPUtils
 * JD-Core Version:    0.7.0.1
 */
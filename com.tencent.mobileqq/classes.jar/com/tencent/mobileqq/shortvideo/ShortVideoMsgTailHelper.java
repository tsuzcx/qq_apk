package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShortVideoMsgTailHelper
{
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).getInt("short_video_msg_config_version", 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = b(paramContext, paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = ((String)localObject).replace("$GCODE$", paramString);
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    QLog.i("ShortVideoMsgTailHelper", 1, "jumpUrl is empty");
  }
  
  public static void a(Context paramContext, List<String> paramList)
  {
    if (paramList == null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("ShortVideoMsgTailHelper", 2, "updateShortVideoMsgTailConfig, configs == null");
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.e("ShortVideoMsgTailHelper", 1, paramContext.toString(), paramContext);
    }
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject1 = (String)paramList.next();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateShortVideoMsgTailConfig, config=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("ShortVideoMsgTailHelper", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new JSONArray((String)localObject1);
        int j = ((JSONArray)localObject1).length();
        if (j > 0)
        {
          int i = 0;
          localObject2 = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).edit();
          while (i < j)
          {
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
            int k = localJSONObject.getInt("type");
            if (k != 0)
            {
              boolean bool = "1".equals(localJSONObject.optString("isShow"));
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("short_video_msg_tail_is_show_");
              localStringBuilder.append(k);
              ((SharedPreferences.Editor)localObject2).putBoolean(localStringBuilder.toString(), bool);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("short_video_msg_tail_wording_");
              localStringBuilder.append(k);
              ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), localJSONObject.optString("wording"));
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("short_video_msg_tail_jumping_url_");
              localStringBuilder.append(k);
              ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), localJSONObject.optString("jumpUrl"));
              ((SharedPreferences.Editor)localObject2).apply();
            }
            else
            {
              QLog.i("ShortVideoMsgTailHelper", 1, "type == 0");
            }
            i += 1;
          }
        }
      }
      else {}
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_msg_tail_is_show_");
    localStringBuilder.append(paramInt);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_msg_tail_jumping_url_");
    localStringBuilder.append(paramInt);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static String c(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_msg_tail_wording_");
    localStringBuilder.append(paramInt);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static void d(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).edit();
    paramContext.putInt("short_video_msg_config_version", paramInt);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper
 * JD-Core Version:    0.7.0.1
 */
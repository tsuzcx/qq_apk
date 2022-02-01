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
  
  public static String a(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).getString("short_video_msg_tail_jumping_url_" + paramInt, "");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).edit();
    paramContext.putInt("short_video_msg_config_version", paramInt);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = a(paramContext, paramInt);
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
        break label300;
      }
      QLog.i("ShortVideoMsgTailHelper", 2, "updateShortVideoMsgTailConfig, configs == null");
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.e("ShortVideoMsgTailHelper", 1, paramContext.toString(), paramContext);
      return;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      Object localObject;
      int j;
      SharedPreferences.Editor localEditor;
      int i;
      if (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoMsgTailHelper", 2, "updateShortVideoMsgTailConfig, config=" + (String)localObject);
        }
        localObject = new JSONArray((String)localObject);
        j = ((JSONArray)localObject).length();
        if (j > 0)
        {
          localEditor = paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).edit();
          i = 0;
        }
      }
      else
      {
        while (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          int k = localJSONObject.getInt("type");
          if (k != 0) {
            if (!"1".equals(localJSONObject.optString("isShow"))) {
              break label294;
            }
          }
          label294:
          for (boolean bool = true;; bool = false)
          {
            localEditor.putBoolean("short_video_msg_tail_is_show_" + k, bool);
            localEditor.putString("short_video_msg_tail_wording_" + k, localJSONObject.optString("wording"));
            localEditor.putString("short_video_msg_tail_jumping_url_" + k, localJSONObject.optString("jumpUrl"));
            localEditor.apply();
            break;
            QLog.i("ShortVideoMsgTailHelper", 1, "type == 0");
            break;
          }
          label300:
          return;
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).getBoolean("short_video_msg_tail_is_show_" + paramInt, false);
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return paramContext.getSharedPreferences("shortVideoMsgTailSp", 0).getString("short_video_msg_tail_wording_" + paramInt, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper
 * JD-Core Version:    0.7.0.1
 */
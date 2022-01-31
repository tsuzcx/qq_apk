package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgBoxUtil
{
  public static final Pattern a = Pattern.compile("\\{\\{(.\\d+):(.\\d?)\\}\\}", 2);
  
  public static QQText a(appoint_define.RichText paramRichText)
  {
    return a(paramRichText, 16);
  }
  
  public static QQText a(appoint_define.RichText paramRichText, int paramInt)
  {
    return a(FreshNewsUtil.a(paramRichText), paramInt);
  }
  
  public static QQText a(String paramString, int paramInt)
  {
    return new QQText(paramString, 5, paramInt);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      paramString = "";
      return paramString;
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        int i;
        try
        {
          localObject5 = new JSONObject(paramString);
          localObject3 = ((JSONObject)localObject5).optString("content");
          localObject4 = localObject3;
        }
        catch (JSONException localJSONException1)
        {
          Object localObject5;
          Object localObject1;
          String str;
          localObject4 = paramString;
        }
        try
        {
          if (((JSONObject)localObject5).has("audio_list"))
          {
            localObject1 = localObject3;
            localObject4 = localObject3;
            if (((JSONObject)localObject5).optJSONArray("audio_list").length() > 0)
            {
              localObject4 = localObject3;
              localObject1 = (String)localObject3 + "[语音]";
            }
            localObject3 = a.matcher((CharSequence)localObject1);
            paramString = (String)localObject1;
            if (!((Matcher)localObject3).find()) {
              break;
            }
            paramString = ((Matcher)localObject3).group(1);
            localObject1 = ((String)localObject1).replace(((Matcher)localObject3).group(0), paramString);
            continue;
          }
          localObject4 = localObject3;
          if (((JSONObject)localObject5).has("video_list"))
          {
            localObject1 = localObject3;
            localObject4 = localObject3;
            if (((JSONObject)localObject5).optJSONArray("video_list").length() > 0)
            {
              localObject4 = localObject3;
              localObject1 = (String)localObject3 + "[视频]";
            }
          }
          else
          {
            localObject4 = localObject3;
            if (((JSONObject)localObject5).has("pic_list"))
            {
              localObject1 = localObject3;
              localObject4 = localObject3;
              if (((JSONObject)localObject5).optJSONArray("pic_list").length() > 0)
              {
                localObject4 = localObject3;
                localObject1 = (String)localObject3 + "[图片]";
              }
            }
            else
            {
              localObject1 = localObject3;
              localObject4 = localObject3;
              if (((JSONObject)localObject5).has("post_array"))
              {
                localObject4 = localObject3;
                localObject5 = ((JSONObject)localObject5).optJSONArray("post_array");
                i = 0;
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          label391:
          Object localObject2;
          break label391;
          i += 1;
          localObject3 = localJSONException2;
        }
      }
      localObject1 = localObject3;
      localObject4 = localObject3;
      if (i < ((JSONArray)localObject5).length())
      {
        localObject4 = localObject3;
        str = ((JSONArray)localObject5).optJSONObject(i).optString("type");
        localObject4 = localObject3;
        if (TextUtils.isEmpty(str))
        {
          localObject1 = localObject3;
          break label435;
        }
        localObject4 = localObject3;
        if (str.equals("qqmusic"))
        {
          localObject4 = localObject3;
          localObject1 = (String)localObject3 + "[音乐]";
          break label435;
        }
        localObject4 = localObject3;
        localObject1 = localObject3;
        if (!str.equals("audio")) {
          break label435;
        }
        localObject4 = localObject3;
        localObject1 = (String)localObject3 + "[语音]";
        break label435;
        localObject2 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.e("Q..msgbox.util", 2, "getTribeJsonContent content:" + paramString);
          localObject2 = localObject4;
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    do
    {
      return str1;
      str1 = paramString;
    } while (paramString.indexOf("/") == -1);
    int i = 0;
    String str1 = paramString;
    for (;;)
    {
      try
      {
        if (i >= EmotcationConstants.a.length) {
          break label274;
        }
        str1 = paramString;
        str2 = paramString;
        if (paramString.indexOf('\024' + EmotcationConstants.a[i]) == -1) {
          break label265;
        }
        str1 = paramString;
        str2 = paramString.replace('\024' + EmotcationConstants.a[i], "\024" + (char)i);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString = new StringBuilder().append("TextUtils:");
        if (str1.length() <= 200) {
          break label255;
        }
        i = 200;
        QLog.e("Q..msgbox.util", 2, str1.substring(0, i));
        str2 = str1;
      }
      str1 = paramString;
      String str2 = paramString;
      if (i < EmotcationConstants.a.length)
      {
        str2 = paramString;
        str1 = paramString;
        if (paramString.indexOf(EmotcationConstants.a[i]) != -1)
        {
          str1 = paramString;
          str2 = paramString.replace(EmotcationConstants.a[i], "\024" + (char)i);
        }
        i += 1;
        paramString = str2;
      }
      else
      {
        return str2;
        label255:
        i = str1.length() - 1;
        continue;
        label265:
        i += 1;
        paramString = str2;
        break;
        label274:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxUtil
 * JD-Core Version:    0.7.0.1
 */
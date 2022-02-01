package com.tencent.timi.game.liveroom.impl.share.iliveshare;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.share.TgLiveShareParam;
import org.json.JSONException;
import org.json.JSONObject;

public class ILiveShareHelper
{
  public static Intent a(TgLiveShareParam paramTgLiveShareParam)
  {
    if (paramTgLiveShareParam == null) {
      return null;
    }
    Intent localIntent = new Intent();
    try
    {
      paramTgLiveShareParam = a(paramTgLiveShareParam.a, paramTgLiveShareParam.b, paramTgLiveShareParam.c, paramTgLiveShareParam.d, paramTgLiveShareParam.e, paramTgLiveShareParam.f, paramTgLiveShareParam);
      if (TextUtils.isEmpty(paramTgLiveShareParam)) {
        return null;
      }
      JSONObject localJSONObject = new JSONObject(paramTgLiveShareParam);
      paramTgLiveShareParam = localJSONObject.optString("appName");
      String str1 = localJSONObject.optString("appView");
      String str2 = localJSONObject.optString("metaData");
      String str3 = localJSONObject.optString("promptText");
      String str4 = localJSONObject.optString("ver");
      localJSONObject = localJSONObject.optJSONObject("appConfig");
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", paramTgLiveShareParam);
      localIntent.putExtra("forward_ark_app_view", str1);
      localIntent.putExtra("forward_ark_app_ver", str4);
      localIntent.putExtra("forward_ark_app_prompt", str3);
      localIntent.putExtra("forward_ark_app_meta", str2);
      if (localJSONObject != null) {
        localIntent.putExtra("forward_ark_app_config", localJSONObject.toString());
      }
      localIntent.putExtra("appName", paramTgLiveShareParam);
      localIntent.putExtra("appView", str1);
      localIntent.putExtra("appMinVersion", str4);
      localIntent.putExtra("metaData", str2);
      return localIntent;
    }
    catch (JSONException paramTgLiveShareParam)
    {
      paramTgLiveShareParam.printStackTrace();
    }
    return localIntent;
  }
  
  private static String a(long paramLong1, String paramString1, String paramString2, long paramLong2, String paramString3, String paramString4, TgLiveShareParam paramTgLiveShareParam)
  {
    String str1 = "{\n    \"appName\":\"com.tencent.subscription\",\n    \"appView\":\"baseView\",\n    \"appConfig\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    },\n \"ver\":\"1.0.0.45\",\n    \"appDesc\":\"QQ直播\",\n    \"promptText\":\"[QQ直播] {nick_name}的直播\",\n    \"metaData\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"QQ直播\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}";
    Object localObject1 = str1;
    try
    {
      String str2 = "mqqapi://vaslive/watch?roomid={roomid}".replace("{roomid}", String.valueOf(paramLong1));
      localObject1 = str1;
      String str3 = "https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(paramLong1));
      localObject1 = str1;
      Object localObject2 = new StringBuilder();
      localObject1 = str1;
      ((StringBuilder)localObject2).append(str3);
      localObject1 = str1;
      ((StringBuilder)localObject2).append("&_proxy=1");
      localObject1 = str1;
      str3 = ((StringBuilder)localObject2).toString();
      localObject1 = str1;
      localObject2 = a(str2, "source", "qqhy");
      localObject1 = str1;
      str2 = a(str3, paramTgLiveShareParam);
      localObject1 = str1;
      str3 = a((String)localObject2, paramTgLiveShareParam);
      localObject1 = str1;
      paramTgLiveShareParam = "{\n    \"appName\":\"com.tencent.subscription\",\n    \"appView\":\"baseView\",\n    \"appConfig\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    },\n \"ver\":\"1.0.0.45\",\n    \"appDesc\":\"QQ直播\",\n    \"promptText\":\"[QQ直播] {nick_name}的直播\",\n    \"metaData\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"QQ直播\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}".replace("{avatar_jump_url}", "mqqapi://qsubscribe/openhomepage?src_type=ilive&uid={uid}".replace("{uid}", String.valueOf(paramLong2)));
      localObject1 = paramTgLiveShareParam;
      paramTgLiveShareParam = paramTgLiveShareParam.replace("{content_jump_url}", str3);
      localObject1 = paramTgLiveShareParam;
      paramTgLiveShareParam = paramTgLiveShareParam.replace("{icon_jump_url}", "mqqapi://qsubscribe/opendiscoverpage?src_type=ilive");
      localObject1 = paramTgLiveShareParam;
      paramTgLiveShareParam = paramTgLiveShareParam.replace("{h5_jump_url}", str2);
      localObject1 = paramTgLiveShareParam;
      paramString2 = d(paramString2);
      localObject1 = paramTgLiveShareParam;
      str1 = d(paramString4);
      localObject1 = paramTgLiveShareParam;
      paramString4 = d("");
      localObject1 = paramTgLiveShareParam;
      paramTgLiveShareParam = paramTgLiveShareParam.replace("{nick_name}", str1);
      localObject1 = paramTgLiveShareParam;
      paramTgLiveShareParam = paramTgLiveShareParam.replace("{cover_url}", paramString1);
      paramString1 = paramString4;
      localObject1 = paramTgLiveShareParam;
      if (TextUtils.isEmpty(paramString4)) {
        paramString1 = paramString2;
      }
      localObject1 = paramTgLiveShareParam;
      paramString1 = paramTgLiveShareParam.replace("{title}", paramString1);
      localObject1 = paramString1;
      paramString1 = paramString1.replace("{avatar_url}", paramString3);
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = (String)localObject1;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(" share QQ replaceArkData = \n ");
      paramString2.append(paramString1);
      QLog.i("iLiveShareHelper", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  public static String a(TgLiveShareParam paramTgLiveShareParam, int paramInt)
  {
    if (paramTgLiveShareParam == null) {
      return "";
    }
    Object localObject2 = "qqhy";
    if (paramInt != 0)
    {
      localObject1 = localObject2;
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            localObject1 = localObject2;
          } else {
            localObject1 = "wxhy";
          }
        }
        else {
          localObject1 = "wxpyq";
        }
      }
    }
    else
    {
      localObject1 = "qqkj";
    }
    Object localObject1 = a("https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(paramTgLiveShareParam.a)), "source", (String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&_proxy=1");
    return a(((StringBuilder)localObject2).toString(), paramTgLiveShareParam);
  }
  
  public static String a(String paramString)
  {
    return c("我正在看[{nick_name}]的直播，快来一起围观吧!".replace("{nick_name}", paramString));
  }
  
  public static String a(String paramString, TgLiveShareParam paramTgLiveShareParam)
  {
    return a(a(a(a(paramString, "room_type", paramTgLiveShareParam.h), "game_id", paramTgLiveShareParam.j), "game_tag_id", paramTgLiveShareParam.k), "video_source", paramTgLiveShareParam.i);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return "";
    }
    if (paramString1.contains("?"))
    {
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
  
  public static String b(String paramString)
  {
    return c("{room_title}，快来跟我一起围观吧!".replace("{room_title}", paramString));
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.length() > 30) {
      localObject = paramString.substring(0, 30);
    }
    paramString = (String)localObject;
    if (Math.min(((String)localObject).getBytes().length, 100) == 100)
    {
      int i = ((String)localObject).length() / 2;
      paramString = new StringBuilder(((String)localObject).substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(((String)localObject).charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("...");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\f')
      {
        if (c != '\r')
        {
          if ((c != '"') && (c != '/') && (c != '\\')) {}
          switch (c)
          {
          default: 
            if (c <= '\037') {
              localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
            } else {
              localStringBuilder.append(c);
            }
            break;
          case '\n': 
            localStringBuilder.append("\\n");
            break;
          case '\t': 
            localStringBuilder.append("\\t");
            break;
          case '\b': 
            localStringBuilder.append("\\b");
            break;
            localStringBuilder.append('\\');
            localStringBuilder.append(c);
            break;
          }
        }
        else
        {
          localStringBuilder.append("\\r");
        }
      }
      else {
        localStringBuilder.append("\\f");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.iliveshare.ILiveShareHelper
 * JD-Core Version:    0.7.0.1
 */
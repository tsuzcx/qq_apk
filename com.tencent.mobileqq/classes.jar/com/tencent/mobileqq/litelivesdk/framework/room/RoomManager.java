package com.tencent.mobileqq.litelivesdk.framework.room;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.EnterRoomConfig.VideoFormat;
import com.tencent.ilive.LiveSDK;
import com.tencent.ilive.base.ReportInfo.Builder;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class RoomManager
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("00000MEVUX3CBYO1"));
  }
  
  /* Error */
  private static String a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 31
    //   3: invokeinterface 37 2 0
    //   8: checkcast 39	java/lang/String
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +6 -> 22
    //   19: ldc 47
    //   21: areturn
    //   22: aload_0
    //   23: ldc 49
    //   25: invokestatic 55	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: new 57	org/json/JSONArray
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 58	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   39: iconst_0
    //   40: invokevirtual 61	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   43: checkcast 39	java/lang/String
    //   46: astore_0
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 64	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   54: goto -23 -> 31
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 65	org/json/JSONException:printStackTrace	()V
    //   62: ldc 47
    //   64: astore_0
    //   65: goto -18 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramMap	Map<String, String>
    //   28	2	1	str	String
    //   49	2	1	localUnsupportedEncodingException	UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   22	29	49	java/io/UnsupportedEncodingException
    //   31	47	57	org/json/JSONException
  }
  
  public static Map<String, String> a(String paramString)
  {
    int k = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      int j;
      try
      {
        Object localObject2 = paramString.split("&");
        int m = localObject2.length;
        i = 0;
        j = 0;
        String[] arrayOfString;
        if (i < m)
        {
          localObject1 = localObject2[i].split("=");
          if (localObject1.length != 2) {
            break label293;
          }
          arrayOfString = localObject1[0];
          localObject1 = arrayOfString;
          if (arrayOfString != null)
          {
            localObject1 = arrayOfString;
            if (arrayOfString.contains("?")) {
              localObject1 = arrayOfString.substring(arrayOfString.indexOf("?") + 1);
            }
          }
          if ("roomid".equals(localObject1)) {
            break label300;
          }
          if (!"vid".equals(localObject1)) {
            break label293;
          }
          break label300;
        }
        Object localObject1 = localObject2;
        if (j == 0) {
          localObject1 = URLDecoder.decode(paramString, "UTF-8").split("&");
        }
        j = localObject1.length;
        i = k;
        if (i < j)
        {
          arrayOfString = localObject1[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label305;
          }
          localObject2 = arrayOfString[0];
          paramString = (String)localObject2;
          if (localObject2 != null)
          {
            paramString = (String)localObject2;
            if (((String)localObject2).contains("?")) {
              paramString = ((String)localObject2).substring(((String)localObject2).indexOf("?") + 1);
            }
          }
          localObject2 = paramString;
          if (paramString != null)
          {
            localObject2 = paramString;
            if (paramString.equalsIgnoreCase("pagetype")) {
              localObject2 = "pagetype";
            }
          }
          localHashMap.put(localObject2, URLDecoder.decode(arrayOfString[1]));
        }
      }
      catch (Exception paramString)
      {
        QLog.e("RoomManager", 1, "parse mqq schema error " + paramString);
      }
      return localHashMap;
      for (;;)
      {
        label293:
        i += 1;
        break;
        label300:
        j = 1;
      }
      label305:
      i += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    LogFactory.a().c("RoomManager", "enterRoom-----start");
    if (LoginManager.a.a() == null)
    {
      LogFactory.a().c("RoomManager", "getLoginRequest null");
      return;
    }
    LiveSDK.initLoginData(LoginManager.a.a());
    EnterRoomConfig localEnterRoomConfig = new EnterRoomConfig();
    Map localMap = a(paramString);
    if (localMap.containsKey("fromid"))
    {
      localEnterRoomConfig.source = ((String)localMap.get("fromid"));
      BusinessManager.a.a((String)localMap.get("fromid"));
    }
    if (localMap.containsKey("roomid")) {}
    try
    {
      localEnterRoomConfig.roomId = Long.parseLong((String)localMap.get("roomid"));
      if (!localMap.containsKey("pageType")) {
        if (!localMap.containsKey("pagetype")) {
          break label1103;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          if (localMap.containsKey("pageType"))
          {
            i = Integer.parseInt((String)localMap.get("pageType"));
            try
            {
              if (!localMap.containsKey("pagetype")) {
                continue;
              }
              int j = Integer.parseInt((String)localMap.get("pagetype"));
              i = j;
            }
            catch (Exception localException3)
            {
              long l;
              continue;
              continue;
            }
            if ((i == 2) || (i == 4))
            {
              localEnterRoomConfig.videoFormat = 3;
              if (localMap.containsKey("videoUrl")) {
                localEnterRoomConfig.videoUrl = a(localMap);
              }
              if (localMap.containsKey("vid")) {
                localEnterRoomConfig.videoId = b(localMap);
              }
              localEnterRoomConfig.supportVideoFormats = new EnterRoomConfig.VideoFormat[] { EnterRoomConfig.VideoFormat.RTMP, EnterRoomConfig.VideoFormat.FLV, EnterRoomConfig.VideoFormat.MP4 };
              localEnterRoomConfig.isLiteSdk = true;
              localEnterRoomConfig.extData = new Bundle();
              localEnterRoomConfig.extData.putString("mqqschema", paramString);
              localEnterRoomConfig.extData.putInt("content_type", i);
              if (!localMap.containsKey("enter_record_if_finish")) {
                continue;
              }
              localEnterRoomConfig.extData.putString("enter_record_if_finish", (String)localMap.get("enter_record_if_finish"));
              if (!localMap.containsKey("scroollEnable")) {
                continue;
              }
              localEnterRoomConfig.extData.putString("scroll_enable", (String)localMap.get("scroollEnable"));
              if (localMap.containsKey("vid")) {
                localEnterRoomConfig.extData.putString("vid", (String)localMap.get("vid"));
              }
              if (RoomUtil.a(i))
              {
                localEnterRoomConfig.extData.putString("topicid", (String)localMap.get("topicid"));
                localEnterRoomConfig.extData.putString("programid", (String)localMap.get("programid"));
                localEnterRoomConfig.extData.putString("optionid", (String)localMap.get("optionid"));
                localEnterRoomConfig.extData.putString("topicTime", (String)localMap.get("topicTime"));
                localEnterRoomConfig.extData.putString("liveTime", (String)localMap.get("liveTime"));
              }
              if (localMap.containsKey("toolProcessState"))
              {
                paramString = (String)localMap.get("toolProcessState");
                BusinessManager.a.b(paramString);
                localEnterRoomConfig.extData.putString("roomProcessState", paramString);
              }
              if (!localMap.containsKey("startEnterTime")) {}
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            l = Long.parseLong((String)localMap.get("startEnterTime"));
            BusinessManager.a.a(l);
            localEnterRoomConfig.extData.putLong("startEnterTime", l);
            if (localMap.containsKey("ab_token")) {
              localEnterRoomConfig.extData.putString("ab_token", (String)localMap.get("ab_token"));
            }
            if (localMap.containsKey("trace_info")) {
              localEnterRoomConfig.extData.putString("trace_info", (String)localMap.get("trace_info"));
            }
            BusinessManager.a.a(localEnterRoomConfig);
            LiveSDK.setReportInfo(ReportInfo.Builder.newBuilder().setFromId(localEnterRoomConfig.source));
            LiveSDK.enterLive(paramContext, localEnterRoomConfig);
            if (BusinessManager.a.b())
            {
              paramString = new HashMap();
              paramString.put("appid", "1014");
              if (BusinessManager.a.c())
              {
                paramContext = "1";
                paramString.put("zt_int4", paramContext);
                paramString.put("zt_int5", BusinessManager.a.c());
                paramString.put("act_type", "qq_start_enter_live");
                paramString.put("timelong", String.valueOf(System.currentTimeMillis() - BusinessManager.a.a()));
                if (!TextUtils.isEmpty(localEnterRoomConfig.source)) {
                  continue;
                }
                paramContext = "";
                paramString.put("fromid", paramContext);
                paramString.put("userid", BusinessManager.a.a());
                UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "qq_start_enter_live#room_page#room", true, -1L, -1L, paramString, true, true);
              }
            }
            else
            {
              LogFactory.a().c("RoomManager", "enterRoom-----end");
              return;
              localException1 = localException1;
              localException1.printStackTrace();
              continue;
              localException2 = localException2;
              i = 1;
              localException2.printStackTrace();
              continue;
              localEnterRoomConfig.videoFormat = 1;
              continue;
              localEnterRoomConfig.extData.putString("enter_record_if_finish", "0");
              continue;
              if (localMap.containsKey("scroll_enable"))
              {
                localEnterRoomConfig.extData.putString("scroll_enable", (String)localMap.get("scroll_enable"));
                continue;
              }
              localEnterRoomConfig.extData.putString("scroll_enable", "0");
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            continue;
            paramContext = "0";
            continue;
            paramContext = localEnterRoomConfig.source;
            continue;
          }
          i = 1;
          continue;
        }
        label1103:
        int i = 1;
      }
    }
  }
  
  private static String b(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("vid");
    if (TextUtils.isEmpty(paramMap)) {
      return "";
    }
    try
    {
      String str = URLDecoder.decode(paramMap, "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.room.RoomManager
 * JD-Core Version:    0.7.0.1
 */
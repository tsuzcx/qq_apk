package com.tencent.mobileqq.litelivesdk.framework.room;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.EnterRoomConfig.VideoFormat;
import com.tencent.ilive.LiveSDK;
import com.tencent.ilive.base.ReportInfo.Builder;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class RoomManager
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("00000MEVUX3CBYO1"));
  }
  
  private static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    paramString = a(paramString);
    try
    {
      long l = Long.parseLong((String)paramString.get("starttime"));
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  private static String a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("videoUrl");
    if (TextUtils.isEmpty(paramMap)) {
      return "";
    }
    try
    {
      String str = URLDecoder.decode(paramMap, "utf-8");
      paramMap = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    try
    {
      paramMap = (String)new JSONArray(paramMap).get(0);
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
    return "";
  }
  
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = paramString.split("&");
        int k = localObject2.length;
        i = 0;
        j = 0;
        Object localObject1;
        String[] arrayOfString;
        if (i < k)
        {
          localObject1 = localObject2[i].split("=");
          if (localObject1.length != 2) {
            break label305;
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
          if (!"roomid".equals(localObject1)) {
            if (!"vid".equals(localObject1)) {
              break label305;
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if (j == 0) {
            localObject1 = URLDecoder.decode(paramString, "UTF-8").split("&");
          }
          j = localObject1.length;
          i = 0;
          if (i < j)
          {
            arrayOfString = localObject1[i].split("=");
            if ((arrayOfString != null) && (arrayOfString.length == 2))
            {
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
            i += 1;
            continue;
          }
          return localHashMap;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse mqq schema error ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("RoomManager", 1, ((StringBuilder)localObject1).toString());
      }
      int j = 1;
      label305:
      i += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    IliveLiteMonitorUtil.a("live_enter_tick_time", a(paramString));
    IliveLiteMonitorUtil.a("live_enter_tick_time", "start_enter_room");
    LogFactory.a().e("RoomManager", "enterRoom-----start");
    if (LoginManager.a.a() == null)
    {
      LogFactory.a().e("RoomManager", "getLoginRequest null");
      return;
    }
    LiveSDK.initLoginData(LoginManager.a.a());
    LogFactory.a().e("RoomManager", "enterRoom-----initLoginData finish");
    EnterRoomConfig localEnterRoomConfig = new EnterRoomConfig();
    Map localMap = a(paramString);
    if (localMap.containsKey("fromid"))
    {
      localEnterRoomConfig.source = ((String)localMap.get("fromid"));
      BusinessManager.a.a((String)localMap.get("fromid"));
    }
    if (localMap.containsKey("roomid")) {
      try
      {
        localEnterRoomConfig.roomId = Long.parseLong((String)localMap.get("roomid"));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    int j;
    if ((!localMap.containsKey("pageType")) && (!localMap.containsKey("pagetype")))
    {
      j = 1;
    }
    else
    {
      int i;
      try
      {
        if (localMap.containsKey("pageType")) {
          i = Integer.parseInt((String)localMap.get("pageType"));
        } else {
          i = 1;
        }
        j = i;
        try
        {
          if (!localMap.containsKey("pagetype")) {
            break label289;
          }
          j = Integer.parseInt((String)localMap.get("pagetype"));
        }
        catch (Exception localException2) {}
        localException3.printStackTrace();
      }
      catch (Exception localException3)
      {
        i = 1;
      }
      j = i;
    }
    label289:
    if ((j != 2) && (j != 4)) {
      localEnterRoomConfig.videoFormat = 1;
    } else {
      localEnterRoomConfig.videoFormat = 3;
    }
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
    localEnterRoomConfig.extData.putInt("content_type", j);
    if (localMap.containsKey("enter_record_if_finish")) {
      localEnterRoomConfig.extData.putString("enter_record_if_finish", (String)localMap.get("enter_record_if_finish"));
    } else {
      localEnterRoomConfig.extData.putString("enter_record_if_finish", "0");
    }
    if (localMap.containsKey("scroollEnable")) {
      localEnterRoomConfig.extData.putString("scroll_enable", (String)localMap.get("scroollEnable"));
    } else if (localMap.containsKey("scroll_enable")) {
      localEnterRoomConfig.extData.putString("scroll_enable", (String)localMap.get("scroll_enable"));
    } else if (localMap.containsKey("scrooll_enable")) {
      localEnterRoomConfig.extData.putString("scrooll_enable", (String)localMap.get("scroll_enable"));
    } else {
      localEnterRoomConfig.extData.putString("scroll_enable", "1");
    }
    if (localMap.containsKey("vid")) {
      localEnterRoomConfig.extData.putString("vid", (String)localMap.get("vid"));
    }
    if (RoomUtil.a(j))
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
    if (localMap.containsKey("startEnterTime")) {
      try
      {
        long l = Long.parseLong((String)localMap.get("startEnterTime"));
        BusinessManager.a.a(l);
        localEnterRoomConfig.extData.putLong("startEnterTime", l);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    if (localMap.containsKey("ab_token")) {
      localEnterRoomConfig.extData.putString("ab_token", (String)localMap.get("ab_token"));
    }
    if (localMap.containsKey("trace_info")) {
      localEnterRoomConfig.extData.putString("trace_info", (String)localMap.get("trace_info"));
    }
    if (localMap.containsKey("session_id")) {
      localEnterRoomConfig.extData.putString("session_id", (String)localMap.get("session_id"));
    }
    if (localMap.containsKey("ext_action")) {
      localEnterRoomConfig.extData.putString("ext_action", (String)localMap.get("ext_action"));
    }
    BusinessManager.a.a(localEnterRoomConfig);
    LiveSDK.setReportInfo(ReportInfo.Builder.newBuilder().setFromId(localEnterRoomConfig.source));
    LogFactory.a().e("RoomManager", "enterRoom-----enterLive");
    if ((localMap.containsKey("multiRoomMode")) && ("1".equals(localMap.get("multiRoomMode")))) {
      localEnterRoomConfig.mutilRoom = true;
    }
    if (localMap.containsKey("remove_last_room")) {
      localEnterRoomConfig.extData.putString("remove_last_room", (String)localMap.get("remove_last_room"));
    }
    paramString = BusinessManager.a.a();
    if ((BusinessManager.a.c()) && (paramString != null) && (paramString.a != null)) {
      localEnterRoomConfig.extData.putString("enter_room", (String)paramString.a.get("enter_room"));
    }
    LiveSDK.enterLive(paramContext, localEnterRoomConfig);
    a(localEnterRoomConfig);
    LogFactory.a().e("RoomManager", "enterRoom-----end");
  }
  
  private static void a(EnterRoomConfig paramEnterRoomConfig)
  {
    IliveLiteMonitorUtil.a("live_enter_tick_time", "enter_live_finish");
    IliveLiteMonitorUtil.a();
    boolean bool = BusinessManager.a.b();
    String str = "1";
    Object localObject;
    if (bool)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", "1014");
      if (BusinessManager.a.d()) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("zt_int4", localObject);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      localHashMap.put("act_type", "qq_start_enter_live");
      localHashMap.put("timelong", String.valueOf(System.currentTimeMillis() - BusinessManager.a.a()));
      if (TextUtils.isEmpty(paramEnterRoomConfig.source)) {
        paramEnterRoomConfig = "";
      } else {
        paramEnterRoomConfig = paramEnterRoomConfig.source;
      }
      localHashMap.put("fromid", paramEnterRoomConfig);
      localHashMap.put("userid", BusinessManager.a.a());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "qq_start_enter_live#room_page#room", true, -1L, -1L, localHashMap, true, true);
    }
    paramEnterRoomConfig = BusinessManager.a.a();
    if ((BusinessManager.a.c()) && (paramEnterRoomConfig != null) && (paramEnterRoomConfig.a != null))
    {
      localObject = paramEnterRoomConfig.a;
      if (LiveFloatWindowManager.getInstance().appFloatIsShow("FloatWindowComponentImpl")) {
        paramEnterRoomConfig = str;
      } else {
        paramEnterRoomConfig = "0";
      }
      ((HashMap)localObject).put("is_float_window_in", paramEnterRoomConfig);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.room.RoomManager
 * JD-Core Version:    0.7.0.1
 */
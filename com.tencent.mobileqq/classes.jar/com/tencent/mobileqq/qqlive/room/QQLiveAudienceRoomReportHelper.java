package com.tencent.mobileqq.qqlive.room;

import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.data.QQLiveAudienceDtReportData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQLiveAudienceRoomReportHelper
{
  private static String a()
  {
    if (BaseGesturePWDUtil.isAppOnForeground(MobileQQ.context)) {
      return "0";
    }
    return "1";
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap, IAudienceRoom paramIAudienceRoom, IQQLiveSDK paramIQQLiveSDK, QQLiveAudienceDtReportData paramQQLiveAudienceDtReportData)
  {
    if ("event_room_enter".equals(paramString))
    {
      a(paramHashMap, paramIAudienceRoom, paramIQQLiveSDK, paramQQLiveAudienceDtReportData);
      return;
    }
    if ("event_room_exit".equals(paramString))
    {
      b(paramHashMap, paramIAudienceRoom, paramIQQLiveSDK, paramQQLiveAudienceDtReportData);
      return;
    }
    if ("event_room_heart".equals(paramString)) {
      c(paramHashMap, paramIAudienceRoom, paramIQQLiveSDK, paramQQLiveAudienceDtReportData);
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap, IAudienceRoom paramIAudienceRoom, IQQLiveSDK paramIQQLiveSDK, QQLiveAudienceDtReportData paramQQLiveAudienceDtReportData)
  {
    paramIAudienceRoom = new HashMap();
    a(paramHashMap, paramIAudienceRoom);
    paramIAudienceRoom.put("dt_pgid", "pg_qqlive_audience");
    paramIAudienceRoom.put("dt_qq", MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin());
    if (paramIQQLiveSDK != null) {
      paramIAudienceRoom.put("qqlive_user_id", String.valueOf(paramIQQLiveSDK.getLoginModule().getLoginInfo().uid));
    }
    if (paramQQLiveAudienceDtReportData != null)
    {
      paramIAudienceRoom.put("qqlive_zhibo_type", String.valueOf(paramQQLiveAudienceDtReportData.roomType));
      paramIAudienceRoom.put("qqlive_start_source", String.valueOf(paramQQLiveAudienceDtReportData.videoSource));
      paramIAudienceRoom.put("qqlive_zhibo_content", String.valueOf(paramQQLiveAudienceDtReportData.gameId));
      paramIAudienceRoom.put("qqlive_coming_way", paramQQLiveAudienceDtReportData.source);
      VideoReport.setPublicParam("zengzhi_tracedetail", paramQQLiveAudienceDtReportData.traceInfo);
      paramIAudienceRoom.put("qqlive_abtoken", paramQQLiveAudienceDtReportData.traceInfo);
    }
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("ev_qqlive_enterroom", paramIAudienceRoom);
  }
  
  private static void a(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    Iterator localIterator = paramHashMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("key_room_anchor_id".equals(str)) {
        paramHashMap2.put("qqlive_anchor_id", paramHashMap1.get(str));
      } else if ("key_room_room_id".equals(str)) {
        paramHashMap2.put("qqlive_room_id", paramHashMap1.get(str));
      } else if ("key_room_window_mode".equals(str)) {
        paramHashMap2.put("qqlive_seeway", paramHashMap1.get(str));
      } else if ("key_room_enter_time".equals(str)) {
        paramHashMap2.put("qqlive_entertime", paramHashMap1.get(str));
      } else if ("key_room_seq".equals(str)) {
        paramHashMap2.put("qqlive_enter_id", paramHashMap1.get(str));
      } else if ("key_room_program_id".equals(str)) {
        paramHashMap2.put("qqlive_program_id", paramHashMap1.get(str));
      } else if ("key_room_duration".equals(str)) {
        paramHashMap2.put("qqlive_timelong", paramHashMap1.get(str));
      }
    }
  }
  
  private static void b(HashMap<String, String> paramHashMap, IAudienceRoom paramIAudienceRoom, IQQLiveSDK paramIQQLiveSDK, QQLiveAudienceDtReportData paramQQLiveAudienceDtReportData)
  {
    paramIAudienceRoom = new HashMap();
    a(paramHashMap, paramIAudienceRoom);
    paramIAudienceRoom.put("dt_pgid", "pg_qqlive_audience");
    paramIAudienceRoom.put("dt_qq", MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin());
    if (paramIQQLiveSDK != null) {
      paramIAudienceRoom.put("qqlive_user_id", String.valueOf(paramIQQLiveSDK.getLoginModule().getLoginInfo().uid));
    }
    if (paramQQLiveAudienceDtReportData != null)
    {
      paramIAudienceRoom.put("qqlive_zhibo_type", String.valueOf(paramQQLiveAudienceDtReportData.roomType));
      paramIAudienceRoom.put("qqlive_start_source", String.valueOf(paramQQLiveAudienceDtReportData.videoSource));
      paramIAudienceRoom.put("qqlive_zhibo_content", String.valueOf(paramQQLiveAudienceDtReportData.gameId));
      paramIAudienceRoom.put("qqlive_coming_way", paramQQLiveAudienceDtReportData.source);
      VideoReport.setPublicParam("zengzhi_tracedetail", paramQQLiveAudienceDtReportData.traceInfo);
      paramIAudienceRoom.put("qqlive_abtoken", paramQQLiveAudienceDtReportData.traceInfo);
    }
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("ev_qqlive_quitroom", paramIAudienceRoom);
  }
  
  private static void c(HashMap<String, String> paramHashMap, IAudienceRoom paramIAudienceRoom, IQQLiveSDK paramIQQLiveSDK, QQLiveAudienceDtReportData paramQQLiveAudienceDtReportData)
  {
    paramIAudienceRoom = new HashMap();
    a(paramHashMap, paramIAudienceRoom);
    paramIAudienceRoom.put("dt_pgid", "pg_qqlive_audience");
    paramIAudienceRoom.put("dt_qq", MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin());
    if (paramIQQLiveSDK != null) {
      paramIAudienceRoom.put("qqlive_user_id", String.valueOf(paramIQQLiveSDK.getLoginModule().getLoginInfo().uid));
    }
    if (paramQQLiveAudienceDtReportData != null)
    {
      paramIAudienceRoom.put("qqlive_zhibo_type", String.valueOf(paramQQLiveAudienceDtReportData.roomType));
      paramIAudienceRoom.put("qqlive_zhibo_content", String.valueOf(paramQQLiveAudienceDtReportData.gameId));
      paramIAudienceRoom.put("qqlive_coming_way", paramQQLiveAudienceDtReportData.source);
      VideoReport.setPublicParam("zengzhi_tracedetail", paramQQLiveAudienceDtReportData.traceInfo);
      paramIAudienceRoom.put("qqlive_abtoken", paramQQLiveAudienceDtReportData.traceInfo);
      paramIAudienceRoom.put("qq_live_appstatus", a());
      paramIAudienceRoom.put("qqlive_start_source", String.valueOf(paramQQLiveAudienceDtReportData.videoSource));
    }
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("ev_qqlive_heartbeat", paramIAudienceRoom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.room.QQLiveAudienceRoomReportHelper
 * JD-Core Version:    0.7.0.1
 */
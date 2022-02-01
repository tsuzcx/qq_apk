package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class DataReportMgr
{
  private static DataReportMgr a = new DataReportMgr();
  private String b;
  private String c;
  private String d;
  private long e = 0L;
  private OnGetRoomExtInfoListener f;
  
  public static DataReportMgr a()
  {
    return a;
  }
  
  public void a(long paramLong, Map<String, String> paramMap)
  {
    paramMap.put("timelong", String.valueOf(paramLong));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportExitRoom roomId = ");
    localStringBuilder.append((String)paramMap.get("roomid"));
    localStringBuilder.append(", program_id = ");
    localStringBuilder.append((String)paramMap.get("program_id"));
    localStringBuilder.append(", timelong = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", state = ");
    localStringBuilder.append((String)paramMap.get("state"));
    localStringBuilder.append(", zt_int4 = ");
    localStringBuilder.append((String)paramMap.get("zt_int4"));
    localStringBuilder.append(", zt_int5 = ");
    localStringBuilder.append((String)paramMap.get("zt_int5"));
    localStringBuilder.append(", anchor = ");
    localStringBuilder.append((String)paramMap.get("anchor"));
    QLog.i("DataReportMgr", 1, localStringBuilder.toString());
    DataReportUtil.a("room_page", "房间", "room", "房间", "quit", "退房", paramMap);
  }
  
  public void a(RoomExtInfo paramRoomExtInfo)
  {
    Map localMap = d();
    if (paramRoomExtInfo != null)
    {
      localMap.put("zt_int4", paramRoomExtInfo.followStatus);
      localMap.put("zt_int5", paramRoomExtInfo.liveType);
      localMap.put("state", paramRoomExtInfo.state);
      if ("1".equals(paramRoomExtInfo.liveType)) {
        localMap.put("program_id", paramRoomExtInfo.programId);
      }
      localMap.put("anchor", paramRoomExtInfo.anchorUid);
    }
    paramRoomExtInfo = new StringBuilder();
    paramRoomExtInfo.append("reportWebContentLoaded roomId = ");
    paramRoomExtInfo.append((String)localMap.get("roomid"));
    paramRoomExtInfo.append(", program_id = ");
    paramRoomExtInfo.append((String)localMap.get("program_id"));
    paramRoomExtInfo.append(", state = ");
    paramRoomExtInfo.append((String)localMap.get("state"));
    paramRoomExtInfo.append(", zt_int4 = ");
    paramRoomExtInfo.append((String)localMap.get("zt_int4"));
    paramRoomExtInfo.append(", zt_int5 = ");
    paramRoomExtInfo.append((String)localMap.get("zt_int5"));
    paramRoomExtInfo.append(", anchor = ");
    paramRoomExtInfo.append((String)localMap.get("anchor"));
    QLog.i("DataReportMgr", 1, paramRoomExtInfo.toString());
    DataReportUtil.a("room_page", "房间", "room", "房间", "web_content_load_android", "web页面加载", localMap);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, OnGetRoomExtInfoListener paramOnGetRoomExtInfoListener)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.f = paramOnGetRoomExtInfoListener;
    paramString3 = new StringBuilder();
    paramString3.append("setCurrentRoomInfo roomId = ");
    paramString3.append(paramString1);
    paramString3.append(", programId = ");
    paramString3.append(paramString2);
    QLog.i("DataReportMgr", 1, paramString3.toString());
  }
  
  public void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFirstFrame roomId = ");
    ((StringBuilder)localObject).append((String)paramMap.get("roomid"));
    ((StringBuilder)localObject).append(", program_id = ");
    ((StringBuilder)localObject).append((String)paramMap.get("program_id"));
    ((StringBuilder)localObject).append(", visible = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", timelong = ");
    ((StringBuilder)localObject).append((String)paramMap.get("timelong"));
    ((StringBuilder)localObject).append(", switchRoom = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_str1"));
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append((String)paramMap.get("state"));
    ((StringBuilder)localObject).append(", zt_int4 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int4"));
    ((StringBuilder)localObject).append(", zt_int5 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int5"));
    ((StringBuilder)localObject).append(", anchor = ");
    ((StringBuilder)localObject).append((String)paramMap.get("anchor"));
    ((StringBuilder)localObject).append(", zt_str2 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_str2"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "real_frame_view";
    } else {
      localObject = "first_frame_view";
    }
    String str;
    if (paramBoolean) {
      str = "首帧真实展示";
    } else {
      str = "加载首帧";
    }
    DataReportUtil.a("room_page", "房间", "room", "房间", (String)localObject, str, paramMap);
  }
  
  public void b()
  {
    this.e = System.currentTimeMillis();
    Object localObject2 = new HashMap();
    Object localObject1;
    if ((TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(this.c)))
    {
      localObject1 = localObject2;
      if (BusinessManager.a.c() != null)
      {
        ((Map)localObject2).put("roomid", String.valueOf(BusinessManager.a.c().roomId));
        if (BusinessManager.a.c().videoId == null) {
          localObject1 = "";
        } else {
          localObject1 = BusinessManager.a.c().videoId;
        }
        ((Map)localObject2).put("program_id", localObject1);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = d();
    }
    ((Map)localObject1).put("zt_str2", BusinessManager.a.h());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reportEnterSdk roomId = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("roomid"));
    ((StringBuilder)localObject2).append(", program_id = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("program_id"));
    ((StringBuilder)localObject2).append(", state = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("state"));
    ((StringBuilder)localObject2).append(", zt_int4 = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("zt_int4"));
    ((StringBuilder)localObject2).append(", zt_int5 = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("zt_int5"));
    ((StringBuilder)localObject2).append(", anchor = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("anchor"));
    ((StringBuilder)localObject2).append(", zt_str2 = ");
    ((StringBuilder)localObject2).append((String)((Map)localObject1).get("zt_str2"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject2).toString());
    DataReportUtil.a("room_page", "房间", "room", "房间", "start_sdk", "启动SDK", (Map)localObject1);
  }
  
  public void b(boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    paramMap.put("zt_int2", localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportSwitchRoom roomId = ");
    ((StringBuilder)localObject).append((String)paramMap.get("roomid"));
    ((StringBuilder)localObject).append(", program_id = ");
    ((StringBuilder)localObject).append((String)paramMap.get("program_id"));
    ((StringBuilder)localObject).append(", topDirection = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append((String)paramMap.get("state"));
    ((StringBuilder)localObject).append(", zt_int4 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int4"));
    ((StringBuilder)localObject).append(", zt_int5 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int5"));
    ((StringBuilder)localObject).append(", anchor = ");
    ((StringBuilder)localObject).append((String)paramMap.get("anchor"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject).toString());
    DataReportUtil.a("room_page", "房间", "room", "房间", "slide", "上下滑切房", paramMap);
  }
  
  public void c()
  {
    long l;
    if (this.e > 0L) {
      l = System.currentTimeMillis() - this.e;
    } else {
      l = 0L;
    }
    this.e = 0L;
    Map localMap = d();
    localMap.put("timelong", String.valueOf(l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportQuitSdk roomId = ");
    localStringBuilder.append((String)localMap.get("roomid"));
    localStringBuilder.append(", program_id = ");
    localStringBuilder.append((String)localMap.get("program_id"));
    localStringBuilder.append(", timelong = ");
    localStringBuilder.append(l);
    localStringBuilder.append(", state = ");
    localStringBuilder.append((String)localMap.get("state"));
    localStringBuilder.append(", zt_int4 = ");
    localStringBuilder.append((String)localMap.get("zt_int4"));
    localStringBuilder.append(", zt_int5 = ");
    localStringBuilder.append((String)localMap.get("zt_int5"));
    localStringBuilder.append(", anchor = ");
    localStringBuilder.append((String)localMap.get("anchor"));
    QLog.i("DataReportMgr", 1, localStringBuilder.toString());
    DataReportUtil.a("room_page", "房间", "room", "房间", "quit_sdk", "退出SDK", localMap);
    this.f = null;
  }
  
  public Map<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    String str = this.b;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localHashMap.put("roomid", localObject);
    str = this.c;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localHashMap.put("program_id", localObject);
    str = this.d;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localHashMap.put("ab_token", localObject);
    localObject = this.f;
    if ((localObject != null) && (((OnGetRoomExtInfoListener)localObject).c() != null))
    {
      localHashMap.put("zt_int4", this.f.c().followStatus);
      localHashMap.put("zt_int5", this.f.c().liveType);
      localHashMap.put("state", this.f.c().state);
      if ("1".equals(this.f.c().liveType)) {
        localHashMap.put("program_id", this.f.c().programId);
      }
      localHashMap.put("anchor", this.f.c().anchorUid);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportMgr
 * JD-Core Version:    0.7.0.1
 */
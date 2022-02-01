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
  private static DataReportMgr jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportDataReportMgr = new DataReportMgr();
  private long jdField_a_of_type_Long = 0L;
  private OnGetRoomExtInfoListener jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public static DataReportMgr a()
  {
    return jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportDataReportMgr;
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      str = "";
      localHashMap.put("roomid", str);
      if (this.b != null) {
        break label222;
      }
      str = "";
      label38:
      localHashMap.put("program_id", str);
      if (this.c != null) {
        break label230;
      }
    }
    label222:
    label230:
    for (String str = "";; str = this.c)
    {
      localHashMap.put("ab_token", str);
      if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener != null) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a() != null))
      {
        localHashMap.put("zt_int4", this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a().followStatus);
        localHashMap.put("zt_int5", this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a().liveType);
        localHashMap.put("state", this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a().state);
        if ("1".equals(this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a().liveType)) {
          localHashMap.put("program_id", this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a().programId);
        }
        localHashMap.put("anchor", this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener.a().anchorUid);
      }
      return localHashMap;
      str = this.jdField_a_of_type_JavaLangString;
      break;
      str = this.b;
      break label38;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.b)))
    {
      localObject = localHashMap;
      if (BusinessManager.a.a() != null)
      {
        localHashMap.put("roomid", String.valueOf(BusinessManager.a.a().roomId));
        if (BusinessManager.a.a().videoId != null) {
          break label275;
        }
        localObject = "";
        localHashMap.put("program_id", localObject);
      }
    }
    for (Object localObject = localHashMap;; localObject = a())
    {
      ((Map)localObject).put("zt_str2", BusinessManager.a.c());
      QLog.i("DataReportMgr", 1, "reportEnterSdk roomId = " + (String)((Map)localObject).get("roomid") + ", program_id = " + (String)((Map)localObject).get("program_id") + ", state = " + (String)((Map)localObject).get("state") + ", zt_int4 = " + (String)((Map)localObject).get("zt_int4") + ", zt_int5 = " + (String)((Map)localObject).get("zt_int5") + ", anchor = " + (String)((Map)localObject).get("anchor") + ", zt_str2 = " + (String)((Map)localObject).get("zt_str2"));
      DataReportUtil.a("room_page", "房间", "room", "房间", "start_sdk", "启动SDK", (Map)localObject);
      return;
      label275:
      localObject = BusinessManager.a.a().videoId;
      break;
    }
  }
  
  public void a(long paramLong, Map<String, String> paramMap)
  {
    paramMap.put("timelong", String.valueOf(paramLong));
    QLog.i("DataReportMgr", 1, "reportExitRoom roomId = " + (String)paramMap.get("roomid") + ", program_id = " + (String)paramMap.get("program_id") + ", timelong = " + paramLong + ", state = " + (String)paramMap.get("state") + ", zt_int4 = " + (String)paramMap.get("zt_int4") + ", zt_int5 = " + (String)paramMap.get("zt_int5") + ", anchor = " + (String)paramMap.get("anchor"));
    DataReportUtil.a("room_page", "房间", "room", "房间", "quit", "退房", paramMap);
  }
  
  public void a(RoomExtInfo paramRoomExtInfo)
  {
    Map localMap = a();
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
    QLog.i("DataReportMgr", 1, "reportWebContentLoaded roomId = " + (String)localMap.get("roomid") + ", program_id = " + (String)localMap.get("program_id") + ", state = " + (String)localMap.get("state") + ", zt_int4 = " + (String)localMap.get("zt_int4") + ", zt_int5 = " + (String)localMap.get("zt_int5") + ", anchor = " + (String)localMap.get("anchor"));
    DataReportUtil.a("room_page", "房间", "room", "房间", "web_content_load_android", "web页面加载", localMap);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, OnGetRoomExtInfoListener paramOnGetRoomExtInfoListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener = paramOnGetRoomExtInfoListener;
    QLog.i("DataReportMgr", 1, "setCurrentRoomInfo roomId = " + paramString1 + ", programId = " + paramString2);
  }
  
  public void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    QLog.i("DataReportMgr", 1, "reportFirstFrame roomId = " + (String)paramMap.get("roomid") + ", program_id = " + (String)paramMap.get("program_id") + ", visible = " + paramBoolean + ", timelong = " + (String)paramMap.get("timelong") + ", switchRoom = " + (String)paramMap.get("zt_str1") + ", state = " + (String)paramMap.get("state") + ", zt_int4 = " + (String)paramMap.get("zt_int4") + ", zt_int5 = " + (String)paramMap.get("zt_int5") + ", anchor = " + (String)paramMap.get("anchor") + ", zt_str2 = " + (String)paramMap.get("zt_str2"));
    String str1;
    if (paramBoolean)
    {
      str1 = "real_frame_view";
      if (!paramBoolean) {
        break label233;
      }
    }
    label233:
    for (String str2 = "首帧真实展示";; str2 = "加载首帧")
    {
      DataReportUtil.a("room_page", "房间", "room", "房间", str1, str2, paramMap);
      return;
      str1 = "first_frame_view";
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long > 0L) {}
    for (long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;; l = 0L)
    {
      this.jdField_a_of_type_Long = 0L;
      Map localMap = a();
      localMap.put("timelong", String.valueOf(l));
      QLog.i("DataReportMgr", 1, "reportQuitSdk roomId = " + (String)localMap.get("roomid") + ", program_id = " + (String)localMap.get("program_id") + ", timelong = " + l + ", state = " + (String)localMap.get("state") + ", zt_int4 = " + (String)localMap.get("zt_int4") + ", zt_int5 = " + (String)localMap.get("zt_int5") + ", anchor = " + (String)localMap.get("anchor"));
      DataReportUtil.a("room_page", "房间", "room", "房间", "quit_sdk", "退出SDK", localMap);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener = null;
      return;
    }
  }
  
  public void b(boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      paramMap.put("zt_int2", str);
      QLog.i("DataReportMgr", 1, "reportSwitchRoom roomId = " + (String)paramMap.get("roomid") + ", program_id = " + (String)paramMap.get("program_id") + ", topDirection = " + paramBoolean + ", state = " + (String)paramMap.get("state") + ", zt_int4 = " + (String)paramMap.get("zt_int4") + ", zt_int5 = " + (String)paramMap.get("zt_int5") + ", anchor = " + (String)paramMap.get("anchor"));
      DataReportUtil.a("room_page", "房间", "room", "房间", "slide", "上下滑切房", paramMap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportMgr
 * JD-Core Version:    0.7.0.1
 */
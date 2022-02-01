package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class KandianCustomDataReportModule
  extends RoomBizModule
  implements IPlayerState
{
  private long jdField_a_of_type_Long;
  private HeartbeatReportMgr jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr = new HeartbeatReportMgr(this);
  private OnGetRoomExtInfoListener jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener;
  private String jdField_a_of_type_JavaLangString = "1";
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  
  public KandianCustomDataReportModule(OnGetRoomExtInfoListener paramOnGetRoomExtInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener = paramOnGetRoomExtInfoListener;
  }
  
  private int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private Map<String, String> a()
  {
    String str3 = b();
    String str2 = c();
    String str1 = d();
    HashMap localHashMap = new HashMap();
    Object localObject = str3;
    if (str3 == null) {
      localObject = "";
    }
    localHashMap.put("roomid", localObject);
    localObject = str2;
    if (str2 == null) {
      localObject = "";
    }
    localHashMap.put("program_id", localObject);
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localHashMap.put("ab_token", localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener;
    if ((localObject != null) && (((OnGetRoomExtInfoListener)localObject).a() != null))
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
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener);
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("DataReportMgr", 1, "firstFrameVisibleReported true");
      return;
    }
    this.jdField_a_of_type_Boolean = a();
    Map localMap = a();
    localMap.put("timelong", String.valueOf(paramLong));
    String str;
    if (this.jdField_c_of_type_Boolean) {
      str = "1";
    } else {
      str = "0";
    }
    localMap.put("zt_str1", str);
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      localMap.put("zt_str2", BusinessManager.a.c());
    }
    DataReportMgr.a().a(this.jdField_a_of_type_Boolean, localMap);
  }
  
  private boolean a()
  {
    int j = a();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i;
    if (localIAudienceRoomPager != null) {
      i = getAudienceRoomPager().getCurrentIndex();
    } else {
      i = 0;
    }
    if (j == i) {
      bool = true;
    }
    return bool;
  }
  
  private String b()
  {
    RoomBizContext localRoomBizContext = this.roomBizContext;
    String str2 = "";
    String str1 = str2;
    if (localRoomBizContext != null)
    {
      str1 = str2;
      if (this.roomBizContext.getEnterRoomInfo() != null)
      {
        if (this.roomBizContext.getEnterRoomInfo().roomId != 0L) {
          return String.valueOf(this.roomBizContext.getEnterRoomInfo().roomId);
        }
        str1 = str2;
        if (this.roomBizContext.getEnterRoomInfo().extData != null) {
          str1 = this.roomBizContext.getEnterRoomInfo().extData.getString("roomid", "");
        }
      }
    }
    return str1;
  }
  
  private void b()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null))
    {
      String str1 = b();
      String str2 = c();
      String str3 = d();
      DataReportMgr.a().a(str1, str2, str3, this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener);
      return;
    }
    QLog.i("DataReportMgr", 1, "roomBizContext or getEnterRoomInfo null");
  }
  
  private String c()
  {
    RoomBizContext localRoomBizContext = this.roomBizContext;
    String str2 = "";
    String str1 = str2;
    if (localRoomBizContext != null)
    {
      str1 = str2;
      if (this.roomBizContext.getEnterRoomInfo() != null)
      {
        if ((this.roomBizContext.getEnterRoomInfo().programId != null) && (!this.roomBizContext.getEnterRoomInfo().programId.equals("0"))) {
          return this.roomBizContext.getEnterRoomInfo().programId;
        }
        str1 = str2;
        if (this.roomBizContext.getEnterRoomInfo().extData != null) {
          str1 = this.roomBizContext.getEnterRoomInfo().extData.getString("vid", "");
        }
      }
    }
    return str1;
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("DataReportMgr", 1, "exitRoomReported true");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom roomId = ");
    localStringBuilder.append(b());
    localStringBuilder.append(", vid = ");
    localStringBuilder.append(c());
    QLog.i("DataReportMgr", 1, localStringBuilder.toString());
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.b(a());
    DataReportMgr.a().a(System.currentTimeMillis() - this.jdField_c_of_type_Long, a());
  }
  
  private String d()
  {
    RoomBizContext localRoomBizContext = this.roomBizContext;
    String str2 = "";
    String str1 = str2;
    if (localRoomBizContext != null)
    {
      str1 = str2;
      if (this.roomBizContext.getEnterRoomInfo() != null)
      {
        if (this.roomBizContext.getEnterRoomInfo().extData == null) {
          return "";
        }
        str1 = this.roomBizContext.getEnterRoomInfo().extData.getString("ab_token");
      }
    }
    return str1;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString.equals("3")) {
      return "3";
    }
    try
    {
      Object localObject = (AVPlayerBuilderServiceInterface)getRoomEngine().getService(AVPlayerBuilderServiceInterface.class);
      if (localObject == null)
      {
        this.jdField_a_of_type_JavaLangString = "3";
        return this.jdField_a_of_type_JavaLangString;
      }
      if ((((AVPlayerBuilderServiceInterface)localObject).isPlaying()) && (((AVPlayerBuilderServiceInterface)localObject).isPaused()))
      {
        this.jdField_a_of_type_JavaLangString = "2";
        localObject = this.jdField_a_of_type_JavaLangString;
        return localObject;
      }
      this.jdField_a_of_type_JavaLangString = "1";
      return this.jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.a(false);
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.a(true);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
    if (a() == 0) {
      this.jdField_a_of_type_Long = BusinessManager.a.a();
    }
    getEvent().observe(PlayerStateEvent.class, new KandianCustomDataReportModule.1(this));
    if ((a() == 0) && (a())) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.a(a());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.isUserVisibleHint) || ((a()) && (a() == 0))) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.a();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener = null;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom roomId = ");
    localStringBuilder.append(b());
    localStringBuilder.append(", vid = ");
    localStringBuilder.append(c());
    QLog.i("DataReportMgr", 1, localStringBuilder.toString());
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    a();
    b();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportHeartbeatReportMgr.a(a());
    if (this.jdField_b_of_type_Long > 0L) {
      a(0L);
    }
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      c();
      int i = getAudienceRoomPager().getScrollDirection();
      paramBoolean = true;
      if (i != 1) {
        paramBoolean = false;
      }
      DataReportMgr.a().b(paramBoolean, a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.KandianCustomDataReportModule
 * JD-Core Version:    0.7.0.1
 */
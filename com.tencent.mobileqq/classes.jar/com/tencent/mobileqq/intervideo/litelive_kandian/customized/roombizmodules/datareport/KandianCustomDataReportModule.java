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
  private HeartbeatReportMgr a = new HeartbeatReportMgr(this);
  private String b = "1";
  private boolean c = false;
  private boolean d = false;
  private long e;
  private long f = 0L;
  private long g = 0L;
  private boolean h = false;
  private OnGetRoomExtInfoListener i;
  
  public KandianCustomDataReportModule(OnGetRoomExtInfoListener paramOnGetRoomExtInfoListener)
  {
    this.i = paramOnGetRoomExtInfoListener;
  }
  
  private void a(long paramLong)
  {
    if (this.c)
    {
      QLog.i("DataReportMgr", 1, "firstFrameVisibleReported true");
      return;
    }
    this.c = e();
    Map localMap = g();
    localMap.put("timelong", String.valueOf(paramLong));
    String str;
    if (this.h) {
      str = "1";
    } else {
      str = "0";
    }
    localMap.put("zt_str1", str);
    if ((this.c) && (!this.h)) {
      localMap.put("zt_str2", BusinessManager.a.h());
    }
    DataReportMgr.a().a(this.c, localMap);
  }
  
  private void b()
  {
    this.e = System.currentTimeMillis();
    this.g = System.currentTimeMillis();
    this.c = false;
    this.d = false;
    this.h = false;
    this.a.a(this.i);
  }
  
  private void c()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null))
    {
      String str1 = h();
      String str2 = i();
      String str3 = j();
      DataReportMgr.a().a(str1, str2, str3, this.i);
      return;
    }
    QLog.i("DataReportMgr", 1, "roomBizContext or getEnterRoomInfo null");
  }
  
  private void d()
  {
    if (this.d)
    {
      QLog.i("DataReportMgr", 1, "exitRoomReported true");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom roomId = ");
    localStringBuilder.append(h());
    localStringBuilder.append(", vid = ");
    localStringBuilder.append(i());
    QLog.i("DataReportMgr", 1, localStringBuilder.toString());
    this.d = true;
    this.c = false;
    this.a.b(g());
    DataReportMgr.a().a(System.currentTimeMillis() - this.g, g());
  }
  
  private boolean e()
  {
    int k = f();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int j;
    if (localIAudienceRoomPager != null) {
      j = getAudienceRoomPager().getCurrentIndex();
    } else {
      j = 0;
    }
    if (k == j) {
      bool = true;
    }
    return bool;
  }
  
  private int f()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private Map<String, String> g()
  {
    String str3 = h();
    String str2 = i();
    String str1 = j();
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
    localObject = this.i;
    if ((localObject != null) && (((OnGetRoomExtInfoListener)localObject).c() != null))
    {
      localHashMap.put("zt_int4", this.i.c().followStatus);
      localHashMap.put("zt_int5", this.i.c().liveType);
      localHashMap.put("state", this.i.c().state);
      if ("1".equals(this.i.c().liveType)) {
        localHashMap.put("program_id", this.i.c().programId);
      }
      localHashMap.put("anchor", this.i.c().anchorUid);
    }
    return localHashMap;
  }
  
  private String h()
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
  
  private String i()
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
  
  private String j()
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
    if (this.b.equals("3")) {
      return "3";
    }
    try
    {
      Object localObject = (AVPlayerBuilderServiceInterface)getRoomEngine().getService(AVPlayerBuilderServiceInterface.class);
      if (localObject == null)
      {
        this.b = "3";
        return this.b;
      }
      if ((((AVPlayerBuilderServiceInterface)localObject).isPlaying()) && (((AVPlayerBuilderServiceInterface)localObject).isPaused()))
      {
        this.b = "2";
        localObject = this.b;
        return localObject;
      }
      this.b = "1";
      return this.b;
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    return this.b;
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.a.a(false);
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    this.a.a(true);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    b();
    if (f() == 0) {
      this.e = BusinessManager.a.i();
    }
    getEvent().observe(PlayerStateEvent.class, new KandianCustomDataReportModule.1(this));
    if ((f() == 0) && (e())) {
      this.a.a(g());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.isUserVisibleHint) || ((e()) && (f() == 0))) {
      d();
    }
    this.a.a();
    this.i = null;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom roomId = ");
    localStringBuilder.append(h());
    localStringBuilder.append(", vid = ");
    localStringBuilder.append(i());
    QLog.i("DataReportMgr", 1, localStringBuilder.toString());
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    b();
    c();
    this.h = true;
    this.a.a(g());
    if (this.f > 0L) {
      a(0L);
    }
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      d();
      int j = getAudienceRoomPager().getScrollDirection();
      paramBoolean = true;
      if (j != 1) {
        paramBoolean = false;
      }
      DataReportMgr.a().b(paramBoolean, g());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.KandianCustomDataReportModule
 * JD-Core Version:    0.7.0.1
 */
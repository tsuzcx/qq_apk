package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom;

import android.content.Context;
import android.os.Bundle;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil;

public class CustomSwitchRoomModule
  extends RoomBizModule
  implements ThreadCenter.HandlerKeyable
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private RoomSwitchInterface.QueryRoomListTrigger jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CustomSwitchRoomModule.1(this);
  
  protected boolean a()
  {
    return true;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    LogFactory.a().c("CustomSwitchRoomModule", "onCreate index = " + getRoomBizContext().getEnterRoomInfo().bootModulesIndex);
    LogFactory.a().c("CustomSwitchRoomModule", "onCreate roomid = " + getRoomBizContext().getEnterRoomInfo().roomId);
    LogFactory.a().c("CustomSwitchRoomModule", "onCreate vid = " + getRoomBizContext().getEnterRoomInfo().videoId);
    paramContext = getRoomBizContext().getEnterRoomInfo().extData;
    if (getRoomBizContext().getEnterRoomInfo().bootModulesIndex == 0)
    {
      paramContext.putBoolean("read", true);
      if (paramContext == null) {
        break label221;
      }
      this.jdField_a_of_type_Int = paramContext.getInt("content_type");
      LogFactory.a().c("CustomSwitchRoomModule", paramContext.toString());
    }
    for (;;)
    {
      paramContext = (AudienceRoomViewPager)getAudienceRoomPager().getViewPager();
      if ((RoomUtil.a(this.jdField_a_of_type_Int)) && (paramContext != null)) {
        paramContext.setScrollForbidden(true);
      }
      return;
      paramContext.putBoolean("is_preload", true);
      break;
      label221:
      LogFactory.a().c("CustomSwitchRoomModule", "extData = null");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ThreadCenter.clear(this);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger = ((RoomSwitchInterface)getRoomEngine().getService(RoomSwitchInterface.class)).getQueryRoomListTrigger();
    LogFactory.a().c("CustomSwitchRoomModule", "onEnterRoom contentType = " + this.jdField_a_of_type_Int);
    if ((a()) && (!RoomUtil.a(this.jdField_a_of_type_Int))) {
      ThreadCenter.postDelayedUITask(this, this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    ThreadCenter.removeUITask(this, this.jdField_a_of_type_JavaLangRunnable);
    long l = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L;
    getRoomBizContext().getEnterRoomInfo().extData.putInt("watch_sec", (int)l);
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    LogFactory.a().c("CustomSwitchRoomModule", "onSwitchRoom index = " + getRoomBizContext().getEnterRoomInfo().bootModulesIndex);
    LogFactory.a().c("CustomSwitchRoomModule", "roomid = " + getRoomBizContext().getEnterRoomInfo().roomId);
    LogFactory.a().c("CustomSwitchRoomModule", "vid = " + getRoomBizContext().getEnterRoomInfo().videoId);
    paramSwitchRoomInfo = getRoomBizContext().getEnterRoomInfo().extData;
    LogFactory.a().c("CustomSwitchRoomModule", "onSwitchRoom read = " + paramSwitchRoomInfo.getBoolean("read", false));
    if (paramSwitchRoomInfo.getBoolean("read", false))
    {
      paramSwitchRoomInfo.putInt("count", 0);
      return;
    }
    paramSwitchRoomInfo.putBoolean("read", true);
    paramSwitchRoomInfo.putInt("count", 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule
 * JD-Core Version:    0.7.0.1
 */
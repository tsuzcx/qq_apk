package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom;

import android.content.Context;
import android.os.Bundle;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
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
  private boolean jdField_a_of_type_Boolean = true;
  
  protected boolean a()
  {
    return true;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    paramContext = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate index = ");
    localStringBuilder.append(getRoomBizContext().getEnterRoomInfo().bootModulesIndex);
    paramContext.c("CustomSwitchRoomModule", localStringBuilder.toString());
    paramContext = LogFactory.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate roomid = ");
    localStringBuilder.append(getRoomBizContext().getEnterRoomInfo().roomId);
    paramContext.c("CustomSwitchRoomModule", localStringBuilder.toString());
    paramContext = LogFactory.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate vid = ");
    localStringBuilder.append(getRoomBizContext().getEnterRoomInfo().videoId);
    paramContext.c("CustomSwitchRoomModule", localStringBuilder.toString());
    paramContext = getRoomBizContext().getEnterRoomInfo().extData;
    if (paramContext != null)
    {
      if (getRoomBizContext().getEnterRoomInfo().bootModulesIndex == 0) {
        paramContext.putBoolean("read", true);
      } else {
        paramContext.putBoolean("is_preload", true);
      }
      this.jdField_a_of_type_Int = paramContext.getInt("content_type");
      LogFactory.a().c("CustomSwitchRoomModule", paramContext.toString());
    }
    else
    {
      LogFactory.a().c("CustomSwitchRoomModule", "extData = null");
    }
    paramContext = getAudienceRoomPager();
    if ((RoomUtil.a(this.jdField_a_of_type_Int)) || ((paramContext != null) && (!this.jdField_a_of_type_Boolean))) {
      paramContext.setScrollForbidden(true);
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
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom contentType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localLogInterface.c("CustomSwitchRoomModule", localStringBuilder.toString());
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
    paramSwitchRoomInfo = LogFactory.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSwitchRoom index = ");
    ((StringBuilder)localObject).append(getRoomBizContext().getEnterRoomInfo().bootModulesIndex);
    paramSwitchRoomInfo.c("CustomSwitchRoomModule", ((StringBuilder)localObject).toString());
    paramSwitchRoomInfo = LogFactory.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("roomid = ");
    ((StringBuilder)localObject).append(getRoomBizContext().getEnterRoomInfo().roomId);
    paramSwitchRoomInfo.c("CustomSwitchRoomModule", ((StringBuilder)localObject).toString());
    paramSwitchRoomInfo = LogFactory.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vid = ");
    ((StringBuilder)localObject).append(getRoomBizContext().getEnterRoomInfo().videoId);
    paramSwitchRoomInfo.c("CustomSwitchRoomModule", ((StringBuilder)localObject).toString());
    paramSwitchRoomInfo = getRoomBizContext().getEnterRoomInfo().extData;
    localObject = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchRoom read = ");
    localStringBuilder.append(paramSwitchRoomInfo.getBoolean("read", false));
    ((LogInterface)localObject).c("CustomSwitchRoomModule", localStringBuilder.toString());
    if (paramSwitchRoomInfo.getBoolean("read", false))
    {
      paramSwitchRoomInfo.putInt("count", 0);
      return;
    }
    paramSwitchRoomInfo.putBoolean("read", true);
    paramSwitchRoomInfo.putInt("count", 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule
 * JD-Core Version:    0.7.0.1
 */
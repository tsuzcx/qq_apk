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
  private long a = 0L;
  private RoomSwitchInterface.QueryRoomListTrigger b;
  private int c = 1;
  private boolean d = true;
  private Runnable e = new CustomSwitchRoomModule.1(this);
  
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
      this.c = paramContext.getInt("content_type");
      LogFactory.a().c("CustomSwitchRoomModule", paramContext.toString());
    }
    else
    {
      LogFactory.a().c("CustomSwitchRoomModule", "extData = null");
    }
    paramContext = getAudienceRoomPager();
    if ((RoomUtil.a(this.c)) || ((paramContext != null) && (!this.d))) {
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
    this.a = System.currentTimeMillis();
    this.b = ((RoomSwitchInterface)getRoomEngine().getService(RoomSwitchInterface.class)).getQueryRoomListTrigger();
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom contentType = ");
    localStringBuilder.append(this.c);
    localLogInterface.c("CustomSwitchRoomModule", localStringBuilder.toString());
    if ((a()) && (!RoomUtil.a(this.c))) {
      ThreadCenter.postDelayedUITask(this, this.e, 30000L);
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    ThreadCenter.removeUITask(this, this.e);
    long l = (System.currentTimeMillis() - this.a) / 1000L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule
 * JD-Core Version:    0.7.0.1
 */
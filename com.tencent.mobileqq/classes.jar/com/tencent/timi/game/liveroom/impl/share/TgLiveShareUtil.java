package com.tencent.timi.game.liveroom.impl.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomStatusInfo;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.impl.more.AnchorMoreSettingUtil;
import com.tencent.timi.game.liveroom.impl.share.timishare.TgShareParam;
import com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TgLiveShareUtil
{
  private static TgShareParam a(long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    TgLiveShareParam localTgLiveShareParam = new TgLiveShareParam();
    localTgLiveShareParam.a = paramLong;
    Object localObject2 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).f();
    if (localObject2 != null) {
      localObject1 = ((LiveUserInfo)localObject2).nick;
    } else {
      localObject1 = "我";
    }
    localTgLiveShareParam.g = ((String)localObject1);
    Object localObject1 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).i(paramLong);
    if (localObject1 != null)
    {
      localTgLiveShareParam.d = ((TgLiveAnchorUserInfo)localObject1).a;
      localTgLiveShareParam.e = ((TgLiveAnchorUserInfo)localObject1).c;
      localTgLiveShareParam.f = ((TgLiveAnchorUserInfo)localObject1).b;
    }
    IAudienceRoom localIAudienceRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(paramLong);
    QQLiveAnchorRoomInfo localQQLiveAnchorRoomInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).d(paramLong);
    int i;
    if ((localObject2 != null) && (localObject1 != null) && (((LiveUserInfo)localObject2).uid == ((TgLiveAnchorUserInfo)localObject1).a)) {
      i = 1;
    } else {
      i = 0;
    }
    if (localIAudienceRoom != null)
    {
      localObject1 = localIAudienceRoom.getRoomLiveInfo();
      if (localObject1 != null)
      {
        localTgLiveShareParam.b = ((LiveInfo)localObject1).roomInfo.roomLogo;
        localTgLiveShareParam.c = ((LiveInfo)localObject1).roomInfo.roomName;
      }
      if (paramLiveRoomExtraInfo != null)
      {
        localTgLiveShareParam.h = String.valueOf(paramLiveRoomExtraInfo.a);
        localTgLiveShareParam.i = String.valueOf(paramLiveRoomExtraInfo.d);
        localTgLiveShareParam.j = String.valueOf(paramLiveRoomExtraInfo.b);
        localTgLiveShareParam.k = String.valueOf(paramLiveRoomExtraInfo.c);
      }
      else
      {
        if (localObject1 != null) {
          paramLiveRoomExtraInfo = ((LiveInfo)localObject1).roomInfo.extData;
        } else {
          paramLiveRoomExtraInfo = null;
        }
        if ((paramLiveRoomExtraInfo != null) && (!paramLiveRoomExtraInfo.isEmpty()))
        {
          localTgLiveShareParam.h = a(paramLiveRoomExtraInfo);
          localTgLiveShareParam.i = b(paramLiveRoomExtraInfo);
          localTgLiveShareParam.j = c(paramLiveRoomExtraInfo);
          localTgLiveShareParam.k = d(paramLiveRoomExtraInfo);
        }
      }
    }
    else if ((localQQLiveAnchorRoomInfo != null) && (localQQLiveAnchorRoomInfo.roomAttr != null))
    {
      localTgLiveShareParam.b = localQQLiveAnchorRoomInfo.roomAttr.poster16v9;
      localTgLiveShareParam.c = localQQLiveAnchorRoomInfo.roomAttr.roomName;
      localTgLiveShareParam.h = String.valueOf(localQQLiveAnchorRoomInfo.roomAttr.liveRoomType);
      if (localQQLiveAnchorRoomInfo.roomAttr.gameInfo != null)
      {
        localTgLiveShareParam.j = String.valueOf(localQQLiveAnchorRoomInfo.roomAttr.gameInfo.id);
        localTgLiveShareParam.k = String.valueOf(localQQLiveAnchorRoomInfo.roomAttr.gameInfo.secondTagId);
      }
    }
    paramLiveRoomExtraInfo = localTgLiveShareParam.f;
    localObject1 = localTgLiveShareParam.c;
    localObject2 = new TgShareParam();
    ((TgShareParam)localObject2).a = localTgLiveShareParam;
    ((TgShareParam)localObject2).i = (0x1 ^ i);
    ((TgShareParam)localObject2).h = "QQ直播";
    ((TgShareParam)localObject2).b = paramLiveRoomExtraInfo;
    ((TgShareParam)localObject2).c = ((String)localObject1);
    ((TgShareParam)localObject2).d = localTgLiveShareParam.b();
    ((TgShareParam)localObject2).e = localTgLiveShareParam.c();
    ((TgShareParam)localObject2).f = localTgLiveShareParam.b;
    return localObject2;
  }
  
  private static String a(Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle != null) {
      i = paramBundle.getInt("roomType", 1);
    }
    return String.valueOf(i);
  }
  
  public static void a(Context paramContext, long paramLong, LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = AnchorMoreSettingUtil.a(paramLong, paramLiveRoomExtraInfo);
    Object localObject2 = new FrameLayout(paramContext);
    boolean bool = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e().b();
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (bool) {
      localObject1 = "pg_qqlive_anchorlive";
    } else {
      localObject1 = "pg_qqlive_audience";
    }
    localILiveReportService.a(localObject2, (String)localObject1, localConcurrentHashMap);
    Object localObject1 = new View(paramContext);
    ((FrameLayout)localObject2).addView((View)localObject1);
    localObject2 = new ConcurrentHashMap();
    ((ConcurrentHashMap)localObject2).put("zengzhi_moduleid", "em_qqlive_share");
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).b((View)localObject1, false, null, "em_qqlive_share_panel", (Map)localObject2);
    TimiGameShareUtil.a(paramContext, a(paramLong, paramLiveRoomExtraInfo), new TgLiveShareUtil.1((View)localObject1, (ConcurrentHashMap)localObject2), new TgLiveShareUtil.2((View)localObject1, (ConcurrentHashMap)localObject2), new TgLiveShareUtil.3((View)localObject1, (ConcurrentHashMap)localObject2), new TgLiveShareUtil.4((View)localObject1, (ConcurrentHashMap)localObject2));
  }
  
  private static String b(Bundle paramBundle)
  {
    long l = 1037L;
    if (paramBundle != null) {
      l = paramBundle.getLong("videoSource", 1037L);
    }
    return String.valueOf(l);
  }
  
  private static String c(Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle != null) {
      i = paramBundle.getInt("gameId", 1);
    }
    return String.valueOf(i);
  }
  
  private static String d(Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle != null) {
      i = paramBundle.getInt("gameTagId", 1);
    }
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.TgLiveShareUtil
 * JD-Core Version:    0.7.0.1
 */
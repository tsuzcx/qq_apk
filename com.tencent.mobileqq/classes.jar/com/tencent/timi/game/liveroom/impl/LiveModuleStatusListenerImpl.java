package com.tencent.timi.game.liveroom.impl;

import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/LiveModuleStatusListenerImpl;", "Lcom/tencent/timi/game/api/live/ILiveModuleStatusListener;", "()V", "onAudiencePageOnCreate", "", "roomId", "", "onAudiencePageOnDestroy", "onAudiencePageOnStart", "onAudiencePageOnStop", "onAudiencePageVisibleToUser", "isVisibleToUser", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveModuleStatusListenerImpl
  implements ILiveModuleStatusListener
{
  public static final LiveModuleStatusListenerImpl a = new LiveModuleStatusListenerImpl();
  
  public void a() {}
  
  public void a(long paramLong)
  {
    TGLiveFloatManager.a.b();
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
      localObject = ((ITgLiveRoomService)localObject).h(0L);
      if (localObject != null) {
        localObject = Long.valueOf(((BaseRoomInfo)localObject).getRoomId());
      } else {
        localObject = null;
      }
      if (((localObject == null) || (((Long)localObject).longValue() != paramLong)) && (localObject != null))
      {
        paramLong = ((Number)localObject).longValue();
        TGLiveFloatManager.a.a(paramLong);
      }
    }
  }
  
  public void b() {}
  
  public void b(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.LiveModuleStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */
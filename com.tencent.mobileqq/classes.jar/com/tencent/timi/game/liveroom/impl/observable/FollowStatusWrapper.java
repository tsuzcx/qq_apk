package com.tencent.timi.game.liveroom.impl.observable;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/observable/FollowStatusWrapper;", "Ljava/util/Observable;", "()V", "anchorId", "", "<set-?>", "", "isFollow", "()Z", "roomId", "fetchFollowStateFromNetwork", "", "reset", "updateValue", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FollowStatusWrapper
  extends Observable
{
  public static final FollowStatusWrapper.Companion a = new FollowStatusWrapper.Companion(null);
  private long b;
  private long c;
  private boolean d;
  
  private final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    setChanged();
    notifyObservers(Boolean.valueOf(paramBoolean));
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = false;
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…java).qqLiveSDK ?: return");
      ((IQQLiveSDK)localObject).getFollowMsgService().checkFollowAnchor(paramLong1, (IQQLiveCheckFollowCallback)new FollowStatusWrapper.fetchFollowStateFromNetwork.1(this, paramLong1, paramLong2));
    }
  }
  
  public final boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.observable.FollowStatusWrapper
 * JD-Core Version:    0.7.0.1
 */
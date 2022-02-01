package com.tencent.timi.game.room.impl.operation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/room/impl/operation/RoomOperationService$delegateRoomOperation$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class RoomOperationService$delegateRoomOperation$1
  implements LifecycleEventObserver
{
  public void onStateChanged(@NotNull LifecycleOwner paramLifecycleOwner, @NotNull Lifecycle.Event paramEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "source");
    Intrinsics.checkParameterIsNotNull(paramEvent, "event");
    if (paramEvent == Lifecycle.Event.ON_DESTROY)
    {
      paramLifecycleOwner = this.a;
      RoomOperationService.a(paramLifecycleOwner, RoomOperationService.a(paramLifecycleOwner), this.b);
      this.c.getLifecycle().removeObserver((LifecycleObserver)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.operation.RoomOperationService.delegateRoomOperation.1
 * JD-Core Version:    0.7.0.1
 */
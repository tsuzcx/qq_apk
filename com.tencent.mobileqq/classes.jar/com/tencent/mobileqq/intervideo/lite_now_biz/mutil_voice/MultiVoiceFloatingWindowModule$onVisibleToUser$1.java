package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.RoomEventInterceptor;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/MultiVoiceFloatingWindowModule$onVisibleToUser$1", "Lcom/tencent/livesdk/liveengine/FloatRoomManager$RoomEventInterceptor;", "closeFloatWindow", "", "manager", "Lcom/tencent/livesdk/liveengine/FloatRoomManager;", "getLifeOwner", "Landroidx/lifecycle/LifecycleOwner;", "interceptBackPress", "", "interceptDestroy", "", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class MultiVoiceFloatingWindowModule$onVisibleToUser$1
  implements FloatRoomManager.RoomEventInterceptor
{
  public int a()
  {
    if (!MultiVoiceFloatingWindowModule.l(this.a))
    {
      Context localContext = MultiVoiceFloatingWindowModule.m(this.a);
      if ((localContext instanceof Activity))
      {
        ((Activity)localContext).finish();
        return 0;
      }
      return -1;
    }
    this.a.getEvent().post((ModuleEventInterface)new MultiVoicePageEvent(2));
    return 0;
  }
  
  public void a(@NotNull FloatRoomManager paramFloatRoomManager)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatRoomManager, "manager");
    FloatWindowComponent localFloatWindowComponent = MultiVoiceFloatingWindowModule.k(this.a);
    if ((localFloatWindowComponent != null) && (localFloatWindowComponent.isReallyShow() == true)) {
      paramFloatRoomManager.c();
    }
  }
  
  public boolean b()
  {
    FloatWindowComponent localFloatWindowComponent = MultiVoiceFloatingWindowModule.k(this.a);
    if (localFloatWindowComponent != null) {
      return localFloatWindowComponent.isCalledShow();
    }
    return false;
  }
  
  @Nullable
  public LifecycleOwner c()
  {
    return MultiVoiceFloatingWindowModule.j(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.onVisibleToUser.1
 * JD-Core Version:    0.7.0.1
 */
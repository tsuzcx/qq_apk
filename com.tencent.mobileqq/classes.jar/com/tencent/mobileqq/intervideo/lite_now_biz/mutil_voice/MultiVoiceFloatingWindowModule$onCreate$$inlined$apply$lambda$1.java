package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/MultiVoiceFloatingWindowModule$onCreate$1$1", "Lcom/tencent/ilive/uicomponent/floatwindowcomponent_interface/FloatWindowHandleCallback;", "invokePlayerContainer", "", "p0", "Landroid/view/View;", "onDismissed", "", "onDragEnd", "onShow", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class MultiVoiceFloatingWindowModule$onCreate$$inlined$apply$lambda$1
  implements FloatWindowHandleCallback
{
  MultiVoiceFloatingWindowModule$onCreate$$inlined$apply$lambda$1(FloatWindowComponent paramFloatWindowComponent, MultiVoiceFloatingWindowModule paramMultiVoiceFloatingWindowModule, Context paramContext) {}
  
  public void invokePlayerContainer(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "p0");
    View.OnClickListener localOnClickListener = (View.OnClickListener)new MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1.1(this);
    paramView.findViewById(2131445137).setOnClickListener(localOnClickListener);
    paramView.findViewById(2131449302).setOnClickListener(localOnClickListener);
    MultiVoiceFloatingWindowModule.a(this.b, (TextView)paramView.findViewById(2131447062));
  }
  
  public void onDismissed(int paramInt)
  {
    MultiVoiceFloatingWindowModule.a(this.b).post((ModuleEventInterface)new FloatWindowStateEvent(false, 0));
    RoomBizContext localRoomBizContext = MultiVoiceFloatingWindowModule.b(this.b);
    Intrinsics.checkExpressionValueIsNotNull(localRoomBizContext, "roomBizContext");
    localRoomBizContext.getRoomState().isFloatWindowShow = false;
    if (MultiVoiceFloatingWindowModule.c(this.b)) {
      MultiVoiceFloatingWindowModule.d(this.b).c();
    }
  }
  
  public void onDragEnd(@Nullable View paramView) {}
  
  public void onShow()
  {
    MultiVoiceFloatingWindowModule.a(this.b).post((ModuleEventInterface)new FloatWindowStateEvent(true, 0));
    if (!MultiVoiceFloatingWindowModule.c(this.b)) {
      return;
    }
    LifecycleOwner localLifecycleOwner = MultiVoiceFloatingWindowModule.j(this.b);
    if ((localLifecycleOwner instanceof FloatRoomManager.Room))
    {
      FloatRoomManager localFloatRoomManager = MultiVoiceFloatingWindowModule.d(this.b);
      localFloatRoomManager.a((FloatRoomManager.Room)localLifecycleOwner);
      localFloatRoomManager.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */
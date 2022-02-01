package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/MultiVoiceFloatingWindowModule$onCreate$1$1$invokePlayerContainer$clickListener$1"}, k=3, mv={1, 1, 16})
final class MultiVoiceFloatingWindowModule$onCreate$$inlined$apply$lambda$1$1
  implements View.OnClickListener
{
  MultiVoiceFloatingWindowModule$onCreate$$inlined$apply$lambda$1$1(MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1 param1) {}
  
  public final void onClick(View paramView)
  {
    if (!this.a.a.isDragEnd()) {
      return;
    }
    MultiVoiceFloatingWindowModule.a(this.a.b, false);
    this.a.a.dismiss(3);
    Runnable localRunnable = (Runnable)new MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1.1.1(this);
    Object localObject = this.a.b.getAudienceRoomPager();
    if (localObject != null)
    {
      localObject = ((IAudienceRoomPager)localObject).getRoomPageAction();
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((RoomPageActionInterface)localObject).onFloatWindowClick(localRunnable, MultiVoiceFloatingWindowModule.h(this.a.b)));
        break label114;
      }
    }
    localObject = null;
    label114:
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      localObject = this.a.b;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
      boolean bool;
      if (paramView.getId() == 2131449302) {
        bool = true;
      } else {
        bool = false;
      }
      MultiVoiceFloatingWindowModule.b((MultiVoiceFloatingWindowModule)localObject, bool);
      localRunnable.run();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    int i = paramView.getId();
    if (i != 2131445137)
    {
      if (i != 2131449302) {
        return;
      }
      MultiVoiceFloatingWindowModule.a(true);
      return;
    }
    MultiVoiceFloatingWindowModule.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */
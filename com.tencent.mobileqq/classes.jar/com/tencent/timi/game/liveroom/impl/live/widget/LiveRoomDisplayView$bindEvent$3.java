package com.tencent.timi.game.liveroom.impl.live.widget;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.timi.game.live.api.DanmakuChooserView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "onLayoutChange"}, k=3, mv={1, 1, 16})
final class LiveRoomDisplayView$bindEvent$3
  implements View.OnLayoutChangeListener
{
  LiveRoomDisplayView$bindEvent$3(LiveRoomDisplayView paramLiveRoomDisplayView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!LiveRoomDisplayView.c(this.a)) {
      return;
    }
    Object localObject = (DanmakuChooserView)this.a.a(2131431566);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "danmakuChooserView");
    localObject = ((DanmakuChooserView)localObject).getLayoutParams();
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)localObject;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "v");
      ((FrameLayout.LayoutParams)localObject).bottomMargin = paramView.getHeight();
      paramView = (DanmakuChooserView)this.a.a(2131431566);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "danmakuChooserView");
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.LiveRoomDisplayView.bindEvent.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.floating;

import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$roomPlayerListener$1$onResume$1
  implements Runnable
{
  TGLiveAudienceFloatingView$roomPlayerListener$1$onResume$1(TGLiveAudienceFloatingView.roomPlayerListener.1 param1) {}
  
  public final void run()
  {
    Object localObject = (TextView)this.this$0.a.a(2131437625);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingText");
    ((TextView)localObject).setVisibility(4);
    localObject = (LinearLayout)this.this$0.a.a(2131437610);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "load_failed");
    ((LinearLayout)localObject).setVisibility(4);
    TGLiveAudienceFloatingView.a(this.this$0.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.roomPlayerListener.1.onResume.1
 * JD-Core Version:    0.7.0.1
 */
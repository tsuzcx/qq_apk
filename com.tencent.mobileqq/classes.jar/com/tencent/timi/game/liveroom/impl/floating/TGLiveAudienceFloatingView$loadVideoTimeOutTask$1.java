package com.tencent.timi.game.liveroom.impl.floating;

import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$loadVideoTimeOutTask$1
  implements Runnable
{
  TGLiveAudienceFloatingView$loadVideoTimeOutTask$1(TGLiveAudienceFloatingView paramTGLiveAudienceFloatingView) {}
  
  public final void run()
  {
    Object localObject = (LinearLayout)this.this$0.a(2131437610);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "load_failed");
    ((LinearLayout)localObject).setVisibility(0);
    localObject = (TextView)this.this$0.a(2131437625);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "loadingText");
    ((TextView)localObject).setVisibility(8);
    TGLiveAudienceFloatingView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.loadVideoTimeOutTask.1
 * JD-Core Version:    0.7.0.1
 */
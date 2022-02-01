package com.tencent.timi.game.expand.hall.impl.view;

import android.os.Handler;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallInfoView$hideAnim$1
  implements Runnable
{
  ExpandHallInfoView$hideAnim$1(ExpandHallInfoView paramExpandHallInfoView) {}
  
  public final void run()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.a(2131431332);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "contentRoot");
    int i = localRelativeLayout.getHeight();
    localRelativeLayout = (RelativeLayout)this.this$0.a(2131431332);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "contentRoot");
    localRelativeLayout.setTranslationY(0.0F);
    localRelativeLayout = (RelativeLayout)this.this$0.a(2131431332);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "contentRoot");
    localRelativeLayout.setVisibility(0);
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new ExpandHallInfoView.hideAnim.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.hideAnim.1
 * JD-Core Version:    0.7.0.1
 */
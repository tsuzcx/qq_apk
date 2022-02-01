package com.tencent.tkd.topicsdk.widget.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.tkd.R.id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SlidingUpDialog$slidingUp$1
  implements Runnable
{
  SlidingUpDialog$slidingUp$1(SlidingUpDialog paramSlidingUpDialog) {}
  
  public final void run()
  {
    Object localObject1 = (RelativeLayout)this.this$0.findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "rootView");
    ((RelativeLayout)localObject1).setVisibility(0);
    localObject1 = this.this$0;
    Object localObject2 = (RelativeLayout)((Dialog)localObject1).findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "rootView");
    localObject2 = (View)localObject2;
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "rootView");
    SlidingUpDialog.a((SlidingUpDialog)localObject1, (View)localObject2, localRelativeLayout.getHeight(), 0.0F, 200L, null, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog.slidingUp.1
 * JD-Core Version:    0.7.0.1
 */
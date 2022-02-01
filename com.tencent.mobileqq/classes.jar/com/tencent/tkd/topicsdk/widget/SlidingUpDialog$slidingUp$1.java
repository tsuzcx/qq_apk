package com.tencent.tkd.topicsdk.widget;

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
    SlidingUpDialog localSlidingUpDialog = this.this$0;
    Object localObject = (RelativeLayout)this.this$0.findViewById(R.id.bf);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView");
    localObject = (View)localObject;
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.findViewById(R.id.bf);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "rootView");
    SlidingUpDialog.a(localSlidingUpDialog, (View)localObject, localRelativeLayout.getHeight(), 0.0F, 200L, null, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.SlidingUpDialog.slidingUp.1
 * JD-Core Version:    0.7.0.1
 */
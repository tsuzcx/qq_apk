package com.tencent.tkd.topicsdk.entry.controller;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class BaseEntryViewController$addEntryView$2
  extends Lambda
  implements Function0<Unit>
{
  BaseEntryViewController$addEntryView$2(BaseEntryViewController paramBaseEntryViewController, View paramView, FrameLayout.LayoutParams paramLayoutParams, Function1 paramFunction1, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    BaseEntryViewController.a(this.this$0).a(this.$entryView, this.$lp);
    Object localObject = this.$callback;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(this.$viewId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.controller.BaseEntryViewController.addEntryView.2
 * JD-Core Version:    0.7.0.1
 */
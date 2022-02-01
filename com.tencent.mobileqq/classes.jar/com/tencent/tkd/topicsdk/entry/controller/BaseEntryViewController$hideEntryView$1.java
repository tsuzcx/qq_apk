package com.tencent.tkd.topicsdk.entry.controller;

import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class BaseEntryViewController$hideEntryView$1
  extends Lambda
  implements Function0<Unit>
{
  BaseEntryViewController$hideEntryView$1(BaseEntryViewController paramBaseEntryViewController, String paramString, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = BaseEntryViewController.a(this.this$0).get(this.$viewId);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      localObject = this.$callback;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.$viewId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.controller.BaseEntryViewController.hideEntryView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.entry;

import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EntryViewController$showEntryView$1
  extends Lambda
  implements Function0<Unit>
{
  EntryViewController$showEntryView$1(EntryViewController paramEntryViewController, String paramString, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = EntryViewController.a(this.this$0).get(this.$viewId);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      localObject = this.$callback;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.$viewId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryViewController.showEntryView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.entry;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EntryViewController$updateEntryViewData$1
  extends Lambda
  implements Function0<Unit>
{
  EntryViewController$updateEntryViewData$1(EntryViewController paramEntryViewController, String paramString, Bundle paramBundle1, Bundle paramBundle2, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = (View)EntryViewController.a(this.this$0).get(this.$viewId);
    if ((localObject != null) && ((localObject instanceof EntryView)))
    {
      ((EntryView)localObject).a(this.$innerBundle, this.$outerBundle);
      localObject = this.$callback;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(this.$viewId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryViewController.updateEntryViewData.1
 * JD-Core Version:    0.7.0.1
 */
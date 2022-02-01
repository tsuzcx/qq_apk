package com.tencent.tkd.topicsdk.entry;

import com.tencent.tkd.topicsdk.widget.RoundProgressView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EntryView$publishListener$1$onSuccess$2
  extends Lambda
  implements Function0<Unit>
{
  EntryView$publishListener$1$onSuccess$2(EntryView.publishListener.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    EntryView.a(this.this$0.a).setNeedNumProgress(false);
    EntryView.b(this.this$0.a, (Function0)new EntryView.publishListener.1.onSuccess.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryView.publishListener.1.onSuccess.2
 * JD-Core Version:    0.7.0.1
 */
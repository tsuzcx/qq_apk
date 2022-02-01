package com.tencent.tkd.topicsdk.entry;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.publisharticle.PublishManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class EntryView$onCancelPublishViewClicked$1
  extends Lambda
  implements Function1<PublishArticleInfo, Unit>
{
  EntryView$onCancelPublishViewClicked$1(EntryView paramEntryView)
  {
    super(1);
  }
  
  public final void invoke(@Nullable PublishArticleInfo paramPublishArticleInfo)
  {
    PublishManager.a.a(EntryView.a(this.this$0));
    EntryView.a(this.this$0, "");
    if (EntryView.a(this.this$0)) {
      EntryView.a(this.this$0);
    }
    for (;;)
    {
      EntryView.a(this.this$0, paramPublishArticleInfo);
      return;
      EntryView.a(this.this$0, (Function0)new EntryView.onCancelPublishViewClicked.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.EntryView.onCancelPublishViewClicked.1
 * JD-Core Version:    0.7.0.1
 */
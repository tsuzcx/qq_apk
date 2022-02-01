package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.adapter.widget.RichEditTextMenuView;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "count", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initRichEditText$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  PublishArticlePage$initRichEditText$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    PublishArticlePage.k(this.this$0).a(paramInt, PublishArticlePage.h(this.this$0).getCountLimit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initRichEditText.1
 * JD-Core Version:    0.7.0.1
 */
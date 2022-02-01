package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.view.View;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.widget.CustomScrollView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$updateRichEditTextMaxHeightRunnable$1
  implements Runnable
{
  PublishArticlePage$updateRichEditTextMaxHeightRunnable$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    if (this.this$0.b() != null)
    {
      int i = ViewKt.a((View)PublishArticlePage.n(this.this$0));
      PublishArticlePage.o(this.this$0).setMaxScrollViewHeight(ViewKt.a((View)PublishArticlePage.p(this.this$0)) - i);
      PublishArticlePage.o(this.this$0).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.updateRichEditTextMaxHeightRunnable.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.view.View;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.widget.CustomScrollView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$updateRichEditTextMaxHeightRunnable$1
  implements Runnable
{
  PublishArticlePage$updateRichEditTextMaxHeightRunnable$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    if (this.this$0.a() != null)
    {
      int k = ViewKt.a((View)PublishArticlePage.b(this.this$0));
      int i = ((View)PublishArticlePage.a(this.this$0)).getVisibility();
      int j = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        i = j;
      } else if (PublishArticlePage.a(this.this$0).b() != 1) {
        i = ViewKt.a((View)PublishArticlePage.a(this.this$0)) - PublishArticlePage.a(this.this$0).e();
      } else {
        i = PublishArticlePage.a(this.this$0).a();
      }
      PublishArticlePage.a(this.this$0).setMaxScrollViewHeight(ViewKt.a((View)PublishArticlePage.a(this.this$0)) - k - i);
      PublishArticlePage.a(this.this$0).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.updateRichEditTextMaxHeightRunnable.1
 * JD-Core Version:    0.7.0.1
 */
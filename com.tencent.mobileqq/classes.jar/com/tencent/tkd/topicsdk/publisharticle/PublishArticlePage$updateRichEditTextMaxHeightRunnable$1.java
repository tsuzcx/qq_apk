package com.tencent.tkd.topicsdk.publisharticle;

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
    int k = 0;
    if (this.this$0.a() != null)
    {
      int m = ViewKt.a((View)PublishArticlePage.a(this.this$0));
      int i;
      int j;
      if (((View)PublishArticlePage.a(this.this$0)).getVisibility() == 0)
      {
        i = 1;
        if (i == 0) {
          break label136;
        }
        j = ViewKt.a((View)PublishArticlePage.a(this.this$0)) - 100;
        label66:
        if (((View)PublishArticlePage.a(this.this$0)).getVisibility() != 0) {
          break label141;
        }
        i = 1;
        label84:
        if (i != 0) {
          break label146;
        }
        i = k;
      }
      for (;;)
      {
        PublishArticlePage.a(this.this$0).setMaxScrollViewHeight(ViewKt.a((View)PublishArticlePage.a(this.this$0)) - m - j - i);
        PublishArticlePage.a(this.this$0).requestLayout();
        return;
        i = 0;
        break;
        label136:
        j = 0;
        break label66;
        label141:
        i = 0;
        break label84;
        label146:
        if (PublishArticlePage.a(this.this$0).c() != 1) {
          i = ViewKt.a((View)PublishArticlePage.a(this.this$0)) - PublishArticlePage.a(this.this$0).f();
        } else {
          i = PublishArticlePage.a(this.this$0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.updateRichEditTextMaxHeightRunnable.1
 * JD-Core Version:    0.7.0.1
 */
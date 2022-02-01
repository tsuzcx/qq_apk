package com.tencent.tkd.topicsdk.publisharticle;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$updateAndShowRecentTopic$2
  implements Runnable
{
  PublishArticlePage$updateAndShowRecentTopic$2(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    PublishArticlePage.a(this.this$0).setTranslationY(PublishArticlePage.a(this.this$0).getTranslationY() - ViewKt.a((View)PublishArticlePage.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.updateAndShowRecentTopic.2
 * JD-Core Version:    0.7.0.1
 */
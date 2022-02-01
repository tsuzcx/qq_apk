package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.view.View;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayoutWithData$1
  implements Runnable
{
  PublishArticlePage$initBottomSelectorLayoutWithData$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    if (PublishArticlePage.a(this.this$0).getShowBottomSelectorPanel()) {
      PublishArticlePage.a(this.this$0).setVisibility(0);
    }
    PublishArticlePage localPublishArticlePage = this.this$0;
    int i = PublishArticlePage.a(localPublishArticlePage, PublishArticlePage.a(localPublishArticlePage).a());
    int j = PublishArticlePage.a(this.this$0).a();
    PublishArticlePage.a(this.this$0).setInitY(ViewKt.b((View)PublishArticlePage.a(this.this$0)) - (j + i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initBottomSelectorLayoutWithData.1
 * JD-Core Version:    0.7.0.1
 */
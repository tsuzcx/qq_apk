package com.tencent.tkd.topicsdk.publisharticle;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayoutWithData$2
  implements Runnable
{
  PublishArticlePage$initBottomSelectorLayoutWithData$2(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    if (PublishArticlePage.a(this.this$0).getShowBottomSelectorPanel()) {
      PublishArticlePage.a(this.this$0).setVisibility(0);
    }
    if (!PublishArticlePage.a(this.this$0).getShowExtraPropertyContainer()) {
      PublishArticlePage.a(this.this$0).setVisibility(8);
    }
    int i = PublishArticlePage.a(this.this$0, PublishArticlePage.a(this.this$0).a());
    int j = PublishArticlePage.a(this.this$0).a();
    PublishArticlePage.a(this.this$0).setInitY(ViewKt.b((View)PublishArticlePage.a(this.this$0)) - (j + i));
    if (PublishArticlePage.a(this.this$0).getOriginContentInfo() != null) {
      PublishArticlePage.a(this.this$0).a(false);
    }
    PublishArticlePage.a(this.this$0).setTranslationY(PublishArticlePage.a(this.this$0).b() - ViewKt.a((View)PublishArticlePage.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initBottomSelectorLayoutWithData.2
 * JD-Core Version:    0.7.0.1
 */
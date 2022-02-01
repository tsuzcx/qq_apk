package com.tencent.tkd.topicsdk.publisharticle;

import android.text.Editable;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initOriginTextInEditText$2
  implements Runnable
{
  PublishArticlePage$initOriginTextInEditText$2(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    PublishArticlePage.a(this.this$0).b(PublishArticlePage.a(this.this$0).a() - PublishArticlePage.a(this.this$0).getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initOriginTextInEditText.2
 * JD-Core Version:    0.7.0.1
 */
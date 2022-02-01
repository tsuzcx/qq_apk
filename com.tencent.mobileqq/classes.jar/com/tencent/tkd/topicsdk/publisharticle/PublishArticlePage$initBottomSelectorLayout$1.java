package com.tencent.tkd.topicsdk.publisharticle;

import android.widget.TextView;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "count", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayout$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  PublishArticlePage$initBottomSelectorLayout$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    PublishArticlePage.a(this.this$0).b(PublishArticlePage.a(this.this$0).a() - paramInt);
    TextView localTextView = PublishArticlePage.a(this.this$0);
    if (paramInt == 0) {}
    for (float f = 0.3F;; f = 1.0F)
    {
      localTextView.setAlpha(f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initBottomSelectorLayout.1
 * JD-Core Version:    0.7.0.1
 */
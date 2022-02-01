package com.tencent.tkd.topicsdk.publisharticle;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.tkd.topicsdk.common.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "translateY", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayout$2
  extends Lambda
  implements Function1<Float, Unit>
{
  PublishArticlePage$initBottomSelectorLayout$2(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(float paramFloat)
  {
    PublishArticlePage.a(this.this$0).setTranslationY(paramFloat - ViewKt.a((View)PublishArticlePage.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initBottomSelectorLayout.2
 * JD-Core Version:    0.7.0.1
 */
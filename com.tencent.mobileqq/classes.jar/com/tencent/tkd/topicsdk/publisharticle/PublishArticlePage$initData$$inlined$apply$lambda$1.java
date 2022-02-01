package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.view.View;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$initData$1$3$1", "com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$$special$$inlined$isNotNull$lambda$1"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initData$$inlined$apply$lambda$1
  implements Runnable
{
  PublishArticlePage$initData$$inlined$apply$lambda$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void run()
  {
    InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
    Context localContext = PublishArticlePage.a(this.this$0).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "richEditText.context");
    localInputMethodUtils.a(localContext, (View)PublishArticlePage.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initData..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */
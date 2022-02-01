package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ReprintAuthorityConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "allowReprint", "", "invoke", "com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$initEditVideoSettingsLayout$4$1"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$$inlined$apply$lambda$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  PublishArticlePage$initEditVideoSettingsLayout$$inlined$apply$lambda$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    PublishArticlePage.a(this.this$0).getReprintAuthorityConfig().setAllowReprint(paramBoolean);
    PublishArticlePage.a(this.this$0, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initEditVideoSettingsLayout..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */
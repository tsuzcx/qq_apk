package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PrivacySettingConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "privacy", "", "invoke", "com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$initEditVideoSettingsLayout$6$1"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$$inlined$apply$lambda$2
  extends Lambda
  implements Function1<Integer, Unit>
{
  PublishArticlePage$initEditVideoSettingsLayout$$inlined$apply$lambda$2(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    PublishArticlePage.a(this.this$0).getPrivacySettingConfig().setPrivacySetting(paramInt);
    PublishArticlePage.a(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initEditVideoSettingsLayout..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */
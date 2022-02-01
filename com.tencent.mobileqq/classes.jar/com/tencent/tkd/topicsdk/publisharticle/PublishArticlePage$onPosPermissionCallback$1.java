package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$onPosPermissionCallback$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  PublishArticlePage$onPosPermissionCallback$1(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    if (paramBoolean) {
      TopicSDK.a.a().a().a().a(PublishArticlePage.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.onPosPermissionCallback.1
 * JD-Core Version:    0.7.0.1
 */
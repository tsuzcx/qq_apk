package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$publishArticle$1$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$publishArticle$1$1(PublishManager.publishArticle.1 param1, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PublishArticleInfo localPublishArticleInfo = this.this$0.$info;
    localPublishArticleInfo.setContentId(this.$id);
    localPublishArticleInfo.setPublishErrorCode(this.$errorCode);
    localPublishArticleInfo.setPublishErrorMsg(this.$errorMsg);
    if (this.$errorCode == 0)
    {
      PublishManager.a(PublishManager.a, PublishStage.PUBLISH_STAGE_PUBLISH_VIDEO, this.this$0.$config, this.this$0.$info, this.$serverData);
      PublishManager.a(PublishManager.a, this.$errorCode, this.$errorMsg, this.this$0.$config);
      return;
    }
    PublishManager.a(PublishManager.a, PublishStage.PUBLISH_STAGE_PUBLISH_VIDEO, this.this$0.$config, this.this$0.$info);
    PublishManager.b(PublishManager.a, this.$errorCode, this.$errorMsg, this.this$0.$config);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.publishArticle.1.1
 * JD-Core Version:    0.7.0.1
 */
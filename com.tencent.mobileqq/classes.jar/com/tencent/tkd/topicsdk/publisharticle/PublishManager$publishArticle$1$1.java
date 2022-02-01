package com.tencent.tkd.topicsdk.publisharticle;

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
    PublishArticleInfo localPublishArticleInfo = this.this$0.$publishArticleInfo;
    localPublishArticleInfo.setContentId(this.$id);
    localPublishArticleInfo.setPublishErrorCode(this.$errorCode);
    localPublishArticleInfo.setPublishErrorMsg(this.$errorMsg);
    if (this.$errorCode == 0)
    {
      PublishManager.a(PublishManager.a, this.this$0.$config, this.this$0.$publishArticleInfo, this.$serverPublishData);
      PublishManager.a(PublishManager.a, this.$errorCode, this.$errorMsg, this.this$0.$config);
      return;
    }
    PublishManager.a.c(this.this$0.$config, this.this$0.$publishArticleInfo);
    PublishManager.b(PublishManager.a, this.$errorCode, this.$errorMsg, this.this$0.$config);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.publishArticle.1.1
 * JD-Core Version:    0.7.0.1
 */
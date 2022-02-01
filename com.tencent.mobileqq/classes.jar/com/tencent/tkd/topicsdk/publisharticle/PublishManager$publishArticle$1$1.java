package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.BusinessToastConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
    Object localObject = this.this$0.$publishArticleInfo;
    ((PublishArticleInfo)localObject).setContentId(this.$id);
    ((PublishArticleInfo)localObject).setPublishErrorCode(this.$errorCode);
    ((PublishArticleInfo)localObject).setPublishErrorMsg(this.$errorMsg);
    if (this.$errorCode == 0)
    {
      PublishManager.a(PublishManager.a, this.this$0.$config, this.this$0.$publishArticleInfo, this.$serverPublishData);
      if (Intrinsics.areEqual(this.this$0.$config.getPublishScene(), "rijugc"))
      {
        localObject = AppContext.a.a().getString(R.string.aG);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "AppContext.instance.getS…ing.video_upload_success)");
        TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
      }
      do
      {
        return;
        localObject = this.this$0.$config.getBusinessToastConfig().getPublishSuccessToast();
      } while (TextUtils.isEmpty((CharSequence)localObject));
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
      return;
    }
    PublishManager.a.c(this.this$0.$config, this.this$0.$publishArticleInfo);
    if (Intrinsics.areEqual(this.this$0.$config.getPublishScene(), "rijugc"))
    {
      localObject = AppContext.a.a().getString(R.string.aF);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AppContext.instance.getS…ring.video_upload_failed)");
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)this.$errorMsg))
    {
      localObject = AppContext.a.a().getString(R.string.U);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AppContext.instance.getS…ng(R.string.publish_fail)");
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
      return;
    }
    TopicSDKHelperKt.a(this.$errorMsg, false, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.publishArticle.1.1
 * JD-Core Version:    0.7.0.1
 */
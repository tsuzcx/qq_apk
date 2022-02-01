package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.qq_adapter.R.string;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "invoke", "com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$initEditVideoSettingsLayout$8$1$1"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$8$$special$$inlined$let$lambda$1
  extends Lambda
  implements Function1<CommunityInfo, Unit>
{
  PublishArticlePage$initEditVideoSettingsLayout$8$$special$$inlined$let$lambda$1(Activity paramActivity, PublishArticlePage.initEditVideoSettingsLayout.8 param8)
  {
    super(1);
  }
  
  public final void invoke(@Nullable CommunityInfo paramCommunityInfo)
  {
    String str = this.$it.getString(R.string.b);
    if (paramCommunityInfo != null) {
      localObject1 = paramCommunityInfo.getCommunityId();
    } else {
      localObject1 = null;
    }
    Object localObject2 = PublishArticlePage.a(this.this$0.a);
    if (localObject2 != null) {
      localObject2 = ((CommunityInfo)localObject2).getCommunityId();
    } else {
      localObject2 = null;
    }
    if (Intrinsics.areEqual(localObject1, localObject2))
    {
      PublishArticlePage.a(this.this$0.a, (CommunityInfo)null);
      PublishArticlePage.a(this.this$0.a).setText((CharSequence)str);
      QQPublishArticleReportUtils.a.a(paramCommunityInfo, ReportEventElement.BUTTON_CANCEL);
      return;
    }
    QQPublishArticleReportUtils.a.a(PublishArticlePage.a(this.this$0.a), ReportEventElement.BUTTON_CANCEL);
    QQPublishArticleReportUtils.a.a(paramCommunityInfo, ReportEventElement.BUTTON_CONFIRM);
    PublishArticlePage.a(this.this$0.a, paramCommunityInfo);
    Object localObject1 = PublishArticlePage.a(this.this$0.a);
    if (paramCommunityInfo != null)
    {
      paramCommunityInfo = paramCommunityInfo.getTitle();
      if (paramCommunityInfo != null)
      {
        paramCommunityInfo = (CharSequence)paramCommunityInfo;
        break label180;
      }
    }
    paramCommunityInfo = (CharSequence)str;
    label180:
    ((TextView)localObject1).setText(paramCommunityInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initEditVideoSettingsLayout.8..special..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */
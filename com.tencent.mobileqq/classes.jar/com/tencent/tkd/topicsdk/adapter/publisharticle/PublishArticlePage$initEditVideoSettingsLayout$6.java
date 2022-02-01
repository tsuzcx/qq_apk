package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView;
import com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$6
  implements View.OnClickListener
{
  PublishArticlePage$initEditVideoSettingsLayout$6(PublishArticlePage paramPublishArticlePage) {}
  
  public final void onClick(View paramView)
  {
    PublishArticlePage.a(this.a, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_DELIVER_TO_KD_COMMUNITY);
    Activity localActivity = this.a.b();
    if (localActivity != null)
    {
      SelectKDCommunityView.Companion localCompanion = SelectKDCommunityView.a;
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "it");
      paramView = PublishArticlePage.e(this.a);
      if (paramView != null)
      {
        paramView = paramView.getCommunityId();
        if (paramView != null) {}
      }
      else
      {
        paramView = "";
      }
      localCompanion.a(localActivity, paramView, (Function1)new PublishArticlePage.initEditVideoSettingsLayout.6..special..inlined.let.lambda.1(localActivity, this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initEditVideoSettingsLayout.6
 * JD-Core Version:    0.7.0.1
 */
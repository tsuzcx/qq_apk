package com.tencent.tkd.topicsdk.publisharticle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.widget.AddLocationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$2
  implements View.OnClickListener
{
  PublishArticlePage$initEditVideoSettingsLayout$2(PublishArticlePage paramPublishArticlePage) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.a();
    if (paramView != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
      TopicSDKHelperKt.b(paramView, null);
    }
    PublishArticlePage.a(this.a, PublishArticlePage.a(this.a).a());
    PublishArticlePage.a(this.a, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_ADD_LOCATION);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initEditVideoSettingsLayout.2
 * JD-Core Version:    0.7.0.1
 */
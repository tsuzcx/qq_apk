package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initTitleBar$1
  implements View.OnClickListener
{
  PublishArticlePage$initTitleBar$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void onClick(View paramView)
  {
    if (PublishArticlePage.i(this.a))
    {
      paramView = this.a.b();
      if (paramView != null) {
        paramView.finish();
      }
    }
    PublishArticlePage.a(this.a, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_CANCEL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initTitleBar.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$showExitDialog$1", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "onClick", "", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$showExitDialog$1
  implements CommonDialogBuilder.ICommonDialogListener
{
  PublishArticlePage$showExitDialog$1(Activity paramActivity) {}
  
  public void a()
  {
    PublishArticlePage.a(this.a, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH_EXIT_DIALOG, ReportEventElement.BUTTON_CONFIRM);
    PublishManager.a.b();
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.showExitDialog.1
 * JD-Core Version:    0.7.0.1
 */
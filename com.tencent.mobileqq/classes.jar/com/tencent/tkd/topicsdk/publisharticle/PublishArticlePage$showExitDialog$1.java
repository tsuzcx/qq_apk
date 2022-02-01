package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$showExitDialog$1", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "onClick", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$showExitDialog$1
  implements CommonDialogBuilder.ICommonDialogListener
{
  PublishArticlePage$showExitDialog$1(Activity paramActivity) {}
  
  public void a()
  {
    PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH_EXIT_DIALOG, ReportEventElement.BUTTON_CONFIRM);
    PublishManager.a.b();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.showExitDialog.1
 * JD-Core Version:    0.7.0.1
 */
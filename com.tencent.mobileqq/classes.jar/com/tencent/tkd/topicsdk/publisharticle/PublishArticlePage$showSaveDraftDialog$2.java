package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager;
import com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager.Companion;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$showSaveDraftDialog$2", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "onClick", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$showSaveDraftDialog$2
  implements CommonDialogBuilder.ICommonDialogListener
{
  PublishArticlePage$showSaveDraftDialog$2(Activity paramActivity) {}
  
  public void a()
  {
    PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH_DRAFT_DIALOG, ReportEventElement.BUTTON_CANCEL);
    PublishManager.a.b();
    DraftManager.a.a().a(PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage));
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.showSaveDraftDialog.2
 * JD-Core Version:    0.7.0.1
 */
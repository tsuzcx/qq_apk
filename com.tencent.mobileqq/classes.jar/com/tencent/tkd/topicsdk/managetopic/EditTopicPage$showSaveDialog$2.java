package com.tencent.tkd.topicsdk.managetopic;

import android.app.Activity;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/managetopic/EditTopicPage$showSaveDialog$2", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "onClick", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EditTopicPage$showSaveDialog$2
  implements CommonDialogBuilder.ICommonDialogListener
{
  EditTopicPage$showSaveDialog$2(Activity paramActivity) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicEditTopicPage.a().c();
    this.jdField_a_of_type_AndroidAppActivity.finish();
    TopicEventDispatcher.a.b(EditTopicPage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicEditTopicPage));
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN_DRAFT_DIALOG, ReportEventElement.BUTTON_CANCEL, this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicEditTopicPage.a(), this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicEditTopicPage.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.EditTopicPage.showSaveDialog.2
 * JD-Core Version:    0.7.0.1
 */
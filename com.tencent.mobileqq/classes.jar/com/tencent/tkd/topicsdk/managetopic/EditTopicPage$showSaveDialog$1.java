package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TopicPublishInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import com.tencent.tkd.topicsdk.widget.LimitWordEditText;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/managetopic/EditTopicPage$showSaveDialog$1", "Lcom/tencent/tkd/topicsdk/widget/CommonDialogBuilder$ICommonDialogListener;", "onClick", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EditTopicPage$showSaveDialog$1
  implements CommonDialogBuilder.ICommonDialogListener
{
  public void a()
  {
    int i;
    if (((CharSequence)this.a.a().a()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      String str = this.a.a();
      ManageTopicPresenter localManageTopicPresenter = this.a.a();
      TopicInfo localTopicInfo = EditTopicPage.a(this.a);
      long l;
      if (localTopicInfo != null) {
        l = localTopicInfo.getTopicId();
      } else {
        l = 0L;
      }
      localManageTopicPresenter.a(l, new TopicPublishInfo(str, this.a.a().a(), this.a.b().a(), this.a.a()));
    }
    else
    {
      this.a.a(R.string.x);
    }
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN_DRAFT_DIALOG, ReportEventElement.BUTTON_CONFIRM, this.a.a(), this.a.a(), null, 65, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.EditTopicPage.showSaveDialog.1
 * JD-Core Version:    0.7.0.1
 */
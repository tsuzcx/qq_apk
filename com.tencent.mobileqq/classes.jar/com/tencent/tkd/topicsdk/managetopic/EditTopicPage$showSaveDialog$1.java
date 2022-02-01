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
    long l;
    if (((CharSequence)this.a.a().a()).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label157;
      }
      String str = this.a.b();
      ManageTopicPresenter localManageTopicPresenter = this.a.a();
      TopicInfo localTopicInfo = EditTopicPage.a(this.a);
      if (localTopicInfo == null) {
        break label152;
      }
      l = localTopicInfo.getTopicId();
      label65:
      localManageTopicPresenter.a(l, new TopicPublishInfo(str, this.a.a().a(), this.a.b().a(), this.a.f()));
    }
    for (;;)
    {
      DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN_DRAFT_DIALOG, ReportEventElement.BUTTON_CONFIRM, this.a.a(), this.a.a()));
      return;
      i = 0;
      break;
      label152:
      l = 0L;
      break label65;
      label157:
      this.a.a(R.string.C);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.EditTopicPage.showSaveDialog.1
 * JD-Core Version:    0.7.0.1
 */
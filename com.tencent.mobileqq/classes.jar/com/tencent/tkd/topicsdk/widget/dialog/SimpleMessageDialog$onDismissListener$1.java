package com.tencent.tkd.topicsdk.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SimpleMessageDialog$onDismissListener$1
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    paramView = DispatchManager.a;
    UserActionEvent localUserActionEvent = new UserActionEvent();
    localUserActionEvent.a(ReportEventKey.EVENT_CLICK);
    localUserActionEvent.a(ReportEventPage.PAGE_SIMPLE_MESSAGE_DIALOG);
    localUserActionEvent.a(ReportEventElement.BUTTON_CONFIRM);
    paramView.a((IEvent)localUserActionEvent);
    paramView = this.b;
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(SimpleMessageDialog.a(this.a).getText().toString(), Integer.valueOf(2));
    }
    SimpleMessageDialog.a(this.a).setText((CharSequence)"");
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog.onDismissListener.1
 * JD-Core Version:    0.7.0.1
 */
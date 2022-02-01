package com.tencent.tkd.topicsdk.widget.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.tkd.R.color;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/SimpleMessageDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearIconView", "Landroid/widget/ImageView;", "contentView", "Lcom/tencent/tkd/weibo/richEditText/RichEditText;", "value", "", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "countLimitView", "Landroid/widget/TextView;", "", "hint", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "lastContent", "getLastContent", "setLastContent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "type", "", "onDismissListener", "getOnDismissListener", "()Lkotlin/jvm/functions/Function2;", "setOnDismissListener", "(Lkotlin/jvm/functions/Function2;)V", "publishTextView", "rootView", "Landroid/view/View;", "onAttachedToWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "updatePublishLayoutStyle", "isValid", "", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SimpleMessageDialog
  extends Dialog
{
  public static final SimpleMessageDialog.Companion a = new SimpleMessageDialog.Companion(null);
  private int b;
  @NotNull
  private String c;
  private final View d;
  private final RichEditText e;
  private final TextView f;
  private final TextView g;
  
  private final void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = R.color.h;
    } else {
      i = R.color.g;
    }
    this.g.setTextColor(ContextCompat.getColor(getContext(), i));
    if (paramBoolean) {
      i = R.color.f;
    } else {
      i = R.color.e;
    }
    this.g.setBackgroundColor(ContextCompat.getColor(getContext(), i));
    this.g.setEnabled(paramBoolean);
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DispatchManager localDispatchManager = DispatchManager.a;
    UserActionEvent localUserActionEvent = new UserActionEvent();
    localUserActionEvent.a(ReportEventKey.EVENT_EXPOSURE);
    localUserActionEvent.a(ReportEventPage.PAGE_SIMPLE_MESSAGE_DIALOG);
    localDispatchManager.a((IEvent)localUserActionEvent);
    this.e.setText((CharSequence)this.c);
    this.c = "";
    this.e.postDelayed((Runnable)new SimpleMessageDialog.onAttachedToWindow.2(this), 300L);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setContentView(this.d);
    }
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAttributes();
      if (paramBundle != null)
      {
        paramBundle.width = -1;
        paramBundle.height = -2;
        paramBundle.gravity = 80;
        break label62;
      }
    }
    paramBundle = null;
    label62:
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setAttributes(paramBundle);
    }
    setCanceledOnTouchOutside(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DispatchManager localDispatchManager = DispatchManager.a;
    UserActionEvent localUserActionEvent = new UserActionEvent();
    localUserActionEvent.a(ReportEventKey.EVENT_DISMISS);
    localUserActionEvent.a(ReportEventPage.PAGE_SIMPLE_MESSAGE_DIALOG);
    localDispatchManager.a((IEvent)localUserActionEvent);
    this.e.clearFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SimpleMessageDialog
 * JD-Core Version:    0.7.0.1
 */
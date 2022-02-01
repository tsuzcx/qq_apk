package com.tencent.tkd.topicsdk.managetopic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import com.tencent.tkd.topicsdk.widget.LimitWordEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/CreateTopicPage;", "Lcom/tencent/tkd/topicsdk/managetopic/AbsManageTopicPage;", "()V", "handleCoverViewClick", "", "handleLeftBtnClick", "handleRightClick", "isModified", "", "isRightBtnClickable", "onBackEvent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onTopicCreated", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "isSuccess", "showSaveDialog", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CreateTopicPage
  extends AbsManageTopicPage
{
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup);
    a().setText(R.string.m);
    b().setText(R.string.l);
    a().b();
    return paramLayoutInflater;
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    super.a(paramTopicInfo, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onColumnCreated, result = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", id= ");
    localStringBuilder.append(paramTopicInfo.getTopicId());
    localStringBuilder.append(", title = ");
    localStringBuilder.append(paramTopicInfo.getTitle());
    TLog.a("AbsManageTopicPage", localStringBuilder.toString());
    if (paramBoolean)
    {
      TopicEventDispatcher.a.a(paramTopicInfo);
      paramTopicInfo = a();
      if (paramTopicInfo != null) {
        paramTopicInfo.finish();
      }
    }
    else
    {
      TopicEventDispatcher.a.a();
    }
  }
  
  protected boolean b()
  {
    int i;
    if (((CharSequence)a()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (a().b() > 0);
  }
  
  public boolean c()
  {
    if (h())
    {
      g();
      return true;
    }
    TopicEventDispatcher.a.b();
    return false;
  }
  
  public void g()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      super.g();
      new CommonDialogBuilder((Context)localActivity).a((CharSequence)localActivity.getResources().getString(R.string.ab)).a(localActivity.getResources().getString(R.string.r), (CommonDialogBuilder.ICommonDialogListener)new CreateTopicPage.showSaveDialog.1(this, localActivity)).b(localActivity.getResources().getString(R.string.q), (CommonDialogBuilder.ICommonDialogListener)new CreateTopicPage.showSaveDialog.2(this, localActivity)).a().show();
      DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_CREATE_COLUMN_DRAFT_DIALOG, ReportEventElement.ELEMENT_INVALID, a(), a(), null, 65, null));
    }
  }
  
  protected boolean h()
  {
    int i = ((CharSequence)a()).length();
    boolean bool2 = true;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (a().b() <= 0)
      {
        if (b().b() > 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void l()
  {
    super.l();
    if (h())
    {
      g();
    }
    else
    {
      Activity localActivity = a();
      if (localActivity != null) {
        localActivity.finish();
      }
      TopicEventDispatcher.a.b();
    }
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_CREATE_COLUMN, ReportEventElement.BUTTON_CANCEL, a(), a(), null, 65, null));
  }
  
  public void m()
  {
    super.m();
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_CREATE_COLUMN, ReportEventElement.BUTTON_CONFIRM, a(), a(), null, 65, null));
    Object localObject = a();
    if (localObject != null)
    {
      NetworkUtils localNetworkUtils = NetworkUtils.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
      if (!localNetworkUtils.a((Context)localObject))
      {
        localObject = ((Activity)localObject).getString(R.string.I);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "this.getString(R.string.net_failed)");
        TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
        return;
      }
      a().b(a());
    }
  }
  
  public void n()
  {
    super.n();
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_CREATE_COLUMN, ReportEventElement.BUTTON_CHANGE_COVER, a(), a(), null, 65, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.CreateTopicPage
 * JD-Core Version:    0.7.0.1
 */
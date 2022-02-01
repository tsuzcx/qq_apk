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
import com.tencent.tkd.topicsdk.common.report.ReportKeys;
import com.tencent.tkd.topicsdk.common.report.ReportValues;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter.ACTION;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder.ICommonDialogListener;
import com.tencent.tkd.topicsdk.widget.LimitWordEditText;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/CreateTopicPage;", "Lcom/tencent/tkd/topicsdk/managetopic/AbsManageTopicPage;", "()V", "handleCoverViewClick", "", "handleLeftBtnClick", "handleRightClick", "isModified", "", "isRightBtnClickable", "onBackEvent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onTopicCreated", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "isSuccess", "reportOpenCreateTopicPage", "showSaveDialog", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CreateTopicPage
  extends AbsManageTopicPage
{
  private final void o()
  {
    Map localMap = a().a(a(), h(), g());
    localMap.put(ReportKeys.a.h(), ReportValues.a.a());
    localMap.put(ReportKeys.a.i(), "");
    TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_CREATE_TOPIC, localMap, null, 4, null);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup);
    a().setText(R.string.q);
    b().setText(R.string.p);
    a().b();
    o();
    return paramLayoutInflater;
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    super.a(paramTopicInfo, paramBoolean);
    TLog.a("AbsManageTopicPage", "onColumnCreated, result = " + paramBoolean + ", id= " + paramTopicInfo.getTopicId() + ", title = " + paramTopicInfo.getTitle());
    if (paramBoolean)
    {
      TopicEventDispatcher.a.a(paramTopicInfo);
      paramTopicInfo = a();
      if (paramTopicInfo != null) {
        paramTopicInfo.finish();
      }
      return;
    }
    TopicEventDispatcher.a.a();
  }
  
  public boolean e()
  {
    if (j())
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
      new CommonDialogBuilder((Context)localActivity).a((CharSequence)localActivity.getResources().getString(R.string.ai)).a(localActivity.getResources().getString(R.string.v), (CommonDialogBuilder.ICommonDialogListener)new CreateTopicPage.showSaveDialog.1(this, localActivity)).b(localActivity.getResources().getString(R.string.u), (CommonDialogBuilder.ICommonDialogListener)new CreateTopicPage.showSaveDialog.2(this, localActivity)).a().show();
      DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_CREATE_COLUMN_DRAFT_DIALOG, ReportEventElement.ELEMENT_INVALID, a(), a()));
    }
  }
  
  protected boolean i()
  {
    if (((CharSequence)b()).length() > 0) {}
    for (int i = 1; (i != 0) && (a().b() > 0); i = 0) {
      return true;
    }
    return false;
  }
  
  protected boolean j()
  {
    if (((CharSequence)b()).length() > 0) {}
    for (int i = 1; (i != 0) || (a().b() > 0) || (b().b() > 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public void l()
  {
    super.l();
    if (j()) {
      g();
    }
    for (;;)
    {
      DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_CREATE_COLUMN, ReportEventElement.BUTTON_CANCEL, a(), a()));
      return;
      Activity localActivity = a();
      if (localActivity != null) {
        localActivity.finish();
      }
      TopicEventDispatcher.a.b();
    }
  }
  
  public void m()
  {
    super.m();
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_CREATE_COLUMN, ReportEventElement.BUTTON_CONFIRM, a(), a()));
    Object localObject = a();
    if (localObject != null)
    {
      NetworkUtils localNetworkUtils = NetworkUtils.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
      if (!localNetworkUtils.a((Context)localObject))
      {
        localObject = ((Activity)localObject).getString(R.string.N);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "this.getString(R.string.net_failed)");
        TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
      }
    }
    else
    {
      return;
    }
    a().b(a());
  }
  
  public void n()
  {
    super.n();
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_CREATE_COLUMN, ReportEventElement.BUTTON_CHANGE_COVER, a(), a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.CreateTopicPage
 * JD-Core Version:    0.7.0.1
 */
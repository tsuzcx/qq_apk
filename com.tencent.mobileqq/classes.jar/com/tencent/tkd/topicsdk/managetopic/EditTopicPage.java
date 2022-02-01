package com.tencent.tkd.topicsdk.managetopic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/EditTopicPage;", "Lcom/tencent/tkd/topicsdk/managetopic/AbsManageTopicPage;", "()V", "oldTopicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "handleCoverViewClick", "", "handleLeftBtnClick", "handleRightClick", "isModified", "", "isRightBtnClickable", "onBackEvent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onTopicEdited", "topicInfo", "isSuccess", "reportOpenEditTopicPage", "showSaveDialog", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EditTopicPage
  extends AbsManageTopicPage
{
  public static final EditTopicPage.Companion a;
  private TopicInfo a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkManagetopicEditTopicPage$Companion = new EditTopicPage.Companion(null);
  }
  
  private final void o()
  {
    Map localMap = a().a(a(), h(), g());
    localMap.put(ReportKeys.a.h(), ReportValues.a.b());
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
    if (localObject != null) {
      if (localObject != null)
      {
        localMap.put(ReportKeys.a.i(), String.valueOf(((TopicInfo)localObject).getTopicId()));
        localObject = Unit.INSTANCE;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        localMap.put(ReportKeys.a.i(), "");
      }
      TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_EDIT_TOPIC, localMap, null, 4, null);
      return;
      localObject = null;
      continue;
      localObject = null;
    }
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramViewGroup = super.a(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = a();
    if (paramLayoutInflater != null) {}
    for (paramLayoutInflater = (TopicInfo)paramLayoutInflater.getParcelable("topic_info");; paramLayoutInflater = null)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo = paramLayoutInflater;
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo == null) {
        TLog.d("AbsManageTopicPage", "EditTopicFragment, mEditedTopicInfo == null");
      }
      b().setText(R.string.ag);
      a().setText(R.string.y);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
      if (paramLayoutInflater != null) {
        b(paramLayoutInflater);
      }
      b().setCountChangeListener((Function1)new EditTopicPage.onCreateView.2(this));
      o();
      return paramViewGroup;
    }
  }
  
  public void b(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    super.b(paramTopicInfo, paramBoolean);
    TLog.a("AbsManageTopicPage", "onColumnEdited, result = " + paramBoolean + ", id= " + paramTopicInfo.getTopicId() + ", title = " + paramTopicInfo.getTitle());
    if (paramBoolean)
    {
      Activity localActivity = a();
      if (localActivity != null) {
        localActivity.finish();
      }
      TopicEventDispatcher.a.c(paramTopicInfo);
    }
  }
  
  public boolean e()
  {
    if (j())
    {
      g();
      return true;
    }
    TopicEventDispatcher.a.b(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo);
    return false;
  }
  
  public void g()
  {
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity ?: return");
      super.g();
      new CommonDialogBuilder((Context)localActivity).a((CharSequence)localActivity.getResources().getString(R.string.ai)).a(localActivity.getResources().getString(R.string.v), (CommonDialogBuilder.ICommonDialogListener)new EditTopicPage.showSaveDialog.1(this)).b(localActivity.getResources().getString(R.string.u), (CommonDialogBuilder.ICommonDialogListener)new EditTopicPage.showSaveDialog.2(this, localActivity)).a().show();
      DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_EDIT_COLUMN_DRAFT_DIALOG, ReportEventElement.ELEMENT_INVALID, a(), a()));
    }
  }
  
  protected boolean i()
  {
    if (((CharSequence)b()).length() > 0) {}
    for (int i = 1; (i != 0) && (a().b() > 0) && (j()); i = 0) {
      return true;
    }
    return false;
  }
  
  protected boolean j()
  {
    TopicInfo localTopicInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
    if (localTopicInfo != null)
    {
      if ((!TextUtils.equals((CharSequence)localTopicInfo.getCoverUrl(), (CharSequence)b())) || (!TextUtils.equals((CharSequence)localTopicInfo.getTitle(), (CharSequence)a().a())) || (!TextUtils.equals((CharSequence)localTopicInfo.getIntro(), (CharSequence)b().a()))) {
        return true;
      }
    }
    else {
      return false;
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
      DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN, ReportEventElement.BUTTON_CANCEL, a(), a()));
      return;
      Activity localActivity = a();
      if (localActivity != null) {
        localActivity.finish();
      }
      TopicEventDispatcher.a.b(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo);
    }
  }
  
  public void m()
  {
    super.m();
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN, ReportEventElement.BUTTON_CONFIRM, a(), a()));
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject2 = NetworkUtils.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "this");
      if (!((NetworkUtils)localObject2).a((Context)localObject1))
      {
        localObject1 = ((Activity)localObject1).getString(R.string.N);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "this.getString(R.string.net_failed)");
        TopicSDKHelperKt.a((String)localObject1, false, null, 6, null);
      }
    }
    else
    {
      return;
    }
    localObject1 = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
    if (localObject2 != null) {}
    for (long l = ((TopicInfo)localObject2).getTopicId();; l = 0L)
    {
      ((ManageTopicPresenter)localObject1).a(l, a());
      return;
    }
  }
  
  public void n()
  {
    super.n();
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN, ReportEventElement.BUTTON_CHANGE_COVER, a(), a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.EditTopicPage
 * JD-Core Version:    0.7.0.1
 */
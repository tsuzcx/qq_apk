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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/EditTopicPage;", "Lcom/tencent/tkd/topicsdk/managetopic/AbsManageTopicPage;", "()V", "oldTopicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "handleCoverViewClick", "", "handleLeftBtnClick", "handleRightClick", "isModified", "", "isRightBtnClickable", "onBackEvent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onTopicEdited", "topicInfo", "isSuccess", "showSaveDialog", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class EditTopicPage
  extends AbsManageTopicPage
{
  public static final EditTopicPage.Companion a;
  private TopicInfo a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkManagetopicEditTopicPage$Companion = new EditTopicPage.Companion(null);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramViewGroup = super.a(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = a();
    if (paramLayoutInflater != null) {
      paramLayoutInflater = (TopicInfo)paramLayoutInflater.getParcelable("topic_info");
    } else {
      paramLayoutInflater = null;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo = paramLayoutInflater;
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo == null) {
      TLog.d("AbsManageTopicPage", "EditTopicFragment, mEditedTopicInfo == null");
    }
    b().setText(R.string.aa);
    a().setText(R.string.t);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
    if (paramLayoutInflater != null) {
      b(paramLayoutInflater);
    }
    b().setCountChangeListener((Function1)new EditTopicPage.onCreateView.2(this));
    return paramViewGroup;
  }
  
  public void b(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    super.b(paramTopicInfo, paramBoolean);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onColumnEdited, result = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", id= ");
    ((StringBuilder)localObject).append(paramTopicInfo.getTopicId());
    ((StringBuilder)localObject).append(", title = ");
    ((StringBuilder)localObject).append(paramTopicInfo.getTitle());
    TLog.a("AbsManageTopicPage", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = a();
      if (localObject != null) {
        ((Activity)localObject).finish();
      }
      TopicEventDispatcher.a.c(paramTopicInfo);
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
    return (i != 0) && (a().b() > 0) && (h());
  }
  
  public boolean c()
  {
    if (h())
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
      new CommonDialogBuilder((Context)localActivity).a((CharSequence)localActivity.getResources().getString(R.string.ab)).a(localActivity.getResources().getString(R.string.r), (CommonDialogBuilder.ICommonDialogListener)new EditTopicPage.showSaveDialog.1(this)).b(localActivity.getResources().getString(R.string.q), (CommonDialogBuilder.ICommonDialogListener)new EditTopicPage.showSaveDialog.2(this, localActivity)).a().show();
      DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_EDIT_COLUMN_DRAFT_DIALOG, ReportEventElement.ELEMENT_INVALID, a(), a(), null, 65, null));
    }
  }
  
  protected boolean h()
  {
    TopicInfo localTopicInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTopicInfo != null) {
      if ((TextUtils.equals((CharSequence)localTopicInfo.getCoverUrl(), (CharSequence)a())) && (TextUtils.equals((CharSequence)localTopicInfo.getTitle(), (CharSequence)a().a())))
      {
        bool1 = bool2;
        if (TextUtils.equals((CharSequence)localTopicInfo.getIntro(), (CharSequence)b().a())) {}
      }
      else
      {
        bool1 = true;
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
      TopicEventDispatcher.a.b(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo);
    }
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN, ReportEventElement.BUTTON_CANCEL, a(), a(), null, 65, null));
  }
  
  public void m()
  {
    super.m();
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN, ReportEventElement.BUTTON_CONFIRM, a(), a(), null, 65, null));
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = NetworkUtils.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "this");
      if (!((NetworkUtils)localObject2).a((Context)localObject1))
      {
        localObject1 = ((Activity)localObject1).getString(R.string.I);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "this.getString(R.string.net_failed)");
        TopicSDKHelperKt.a((String)localObject1, false, null, 6, null);
        return;
      }
      localObject1 = a();
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
      long l;
      if (localObject2 != null) {
        l = ((TopicInfo)localObject2).getTopicId();
      } else {
        l = 0L;
      }
      ((ManageTopicPresenter)localObject1).a(l, a());
    }
  }
  
  public void n()
  {
    super.n();
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_EDIT_COLUMN, ReportEventElement.BUTTON_CHANGE_COVER, a(), a(), null, 65, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.EditTopicPage
 * JD-Core Version:    0.7.0.1
 */
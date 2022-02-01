package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.mvp.ListContract.IListView;
import com.tencent.mobileqq.kandian.base.mvp.ListPresenter;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.managecolumn.CreateTopicDispatcher;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicView;", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectView;", "Lcom/tencent/mobileqq/kandian/repo/db/struct/ColumnInfo;", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicView$MyTopicViewHolder;", "context", "Lcom/tencent/mobileqq/app/BaseActivity;", "listPresenter", "Lcom/tencent/mobileqq/kandian/base/mvp/ListPresenter;", "Lcom/tencent/mobileqq/kandian/base/mvp/ListContract$IListView;", "(Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/kandian/base/mvp/ListPresenter;)V", "adapter", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter;", "getContext", "()Lcom/tencent/mobileqq/app/BaseActivity;", "createTopicListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "topicInfo", "", "rightActionText", "", "getRightActionText", "()Ljava/lang/String;", "selectTip", "getSelectTip", "topicAdapter", "com/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicView$topicAdapter$1", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicView$topicAdapter$1;", "handleRightActionClick", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "MyTopicViewHolder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicView
  extends BaseSelectView<ColumnInfo, SelectTopicView.MyTopicViewHolder>
{
  public static final SelectTopicView.Companion a;
  @NotNull
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final SelectTopicView.topicAdapter.1 jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelecttopicSelectTopicView$topicAdapter$1;
  private final Function1<ColumnInfo, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelecttopicSelectTopicView$Companion = new SelectTopicView.Companion(null);
  }
  
  public SelectTopicView(@NotNull BaseActivity paramBaseActivity, @NotNull ListPresenter<ColumnInfo, ListContract.IListView<ColumnInfo>> paramListPresenter)
  {
    super((Activity)paramBaseActivity, paramListPresenter);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelecttopicSelectTopicView$topicAdapter$1 = new SelectTopicView.topicAdapter.1(this, (Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = ((Function1)new SelectTopicView.createTopicListener.1(this));
  }
  
  @NotNull
  public BaseSelectAdapter<ColumnInfo, SelectTopicView.MyTopicViewHolder> a()
  {
    return (BaseSelectAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelecttopicSelectTopicView$topicAdapter$1;
  }
  
  @NotNull
  public String a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717996);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…joy_publish_to_topic_tip)");
    return str;
  }
  
  public void a()
  {
    RIJUgcUtils.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 4);
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder().addValueSafe("uin", ((QQAppInterface)localObject).getCurrentAccountUin()).addValueSafe("source", Integer.valueOf(1)).build();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJTransMergeKanDianRepo…                 .build()");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC60", (String)localObject);
      return;
    }
    QLog.e("SelectTopicView", 1, "handleRightActionClick, app == null");
  }
  
  @NotNull
  public String b()
  {
    if (RIJUgcUtils.h())
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717833);
      Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…ate_column_entry_wording)");
      return str;
    }
    return "";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    CreateTopicDispatcher.a(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  protected void onDetachedFromWindow()
  {
    CreateTopicDispatcher.b(this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
    super.onDetachedFromWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SelectTopicView
 * JD-Core Version:    0.7.0.1
 */
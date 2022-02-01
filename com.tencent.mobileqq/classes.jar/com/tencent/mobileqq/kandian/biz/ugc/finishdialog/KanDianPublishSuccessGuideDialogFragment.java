package com.tencent.mobileqq.kandian.biz.ugc.finishdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/finishdialog/KanDianPublishSuccessGuideDialogFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianPublishSuccessGuideDialogFragment
  extends QPublicBaseFragment
{
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return paramLayoutInflater;
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivity();
    if (paramView != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
      paramView = new KanDianPublishFinishGuideDialog((Activity)paramView);
    }
    else
    {
      paramView = null;
    }
    ReadInJoyHelper.p((AppRuntime)RIJQQAppInterfaceUtil.b(), true);
    if (paramView != null) {
      paramView.show();
    }
    paramView = RIJTransMergeKanDianReport.g().addTime();
    paramView.addString("uin", RIJQQAppInterfaceUtil.d());
    PublicAccountReportUtils.a(null, "", "0x800BC44", "0x800BC44", 0, 0, "", "", "", paramView.build(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.finishdialog.KanDianPublishSuccessGuideDialogFragment
 * JD-Core Version:    0.7.0.1
 */
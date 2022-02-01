package com.tencent.mobileqq.kandian.biz.xtab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.tab.RIJTabFrameDeliverPopupUtil;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardConfigUtil;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardRedUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$initTopBar$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$OnBtnClickListener;", "handleHashBtnDataReport", "", "handleHashBtnJump", "handleMessageBoardBtnClick", "onDeliverBtnClick", "view", "Landroid/view/View;", "onHashBtnClick", "onMoreChannelBtnClick", "onSearchBtnClick", "onSelfBtnClick", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$initTopBar$1
  implements RIJXTabBar.OnBtnClickListener
{
  private final void a()
  {
    String str = RIJXTabMessageBoardConfigUtil.a.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onHashBtnClick], decodeJumpUrl = ");
    localStringBuilder.append(str);
    QLog.i("RIJXTabFrame", 1, localStringBuilder.toString());
    RIJJumpUtils.c((Context)this.a.P(), str);
  }
  
  private final void b()
  {
    if (RIJXTabMessageBoardConfigUtil.a.b())
    {
      RIJXTabMessageBoardRedUtil.a.a(NetConnInfoCenter.getServerTimeMillis() / 1000L);
      RIJXTabMessageBoardRedUtil.a.b();
      RIJXTabFrame.f(this.a).b(RIJXTabMessageBoardRedUtil.a.a());
    }
  }
  
  private final void c()
  {
    if (RIJXTabMessageBoardConfigUtil.a.b())
    {
      RIJXTabMessageBoardRedUtil.a.a("0X800BCB5", RIJXTabMessageBoardRedUtil.a.d());
      return;
    }
    RIJXTabReport.a(RIJXTabFrame.f(this.a).a(), "0X800BA08");
    RIJXTabFrame.f(this.a).setTopicIconHasClicked();
  }
  
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    UniteSearchActivity.a((Activity)this.a.P(), null, 25);
    RIJChannelReporter.a("0X80067D3", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().build());
  }
  
  public void a(@NotNull RedTouch paramRedTouch)
  {
    Intrinsics.checkParameterIsNotNull(paramRedTouch, "view");
    boolean bool = RIJXTabFrame.f(this.a).getSelfBtnNotifyIcon().h();
    RIJXTabFrame.f(this.a).getSelfBtnNotifyIcon().g();
    paramRedTouch = ReadInJoyActivityHelper.INSTANCE;
    QBaseActivity localQBaseActivity = this.a.P();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "activity");
    paramRedTouch.launchReadInJoySelfActivity((Context)localQBaseActivity, bool);
    PublicTracker.a(null, "self_tab_cost");
    paramRedTouch = RIJXTabFrame.g(this.a).g();
    if (paramRedTouch != null)
    {
      int i = paramRedTouch.mChannelCoverId;
      RIJChannelReporter.a("0X8007DB4", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().addChannelId(i).build());
    }
  }
  
  public void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = new Intent();
    PublicTransFragmentActivity.b((Context)this.a.P(), paramView, RIJXTabChannelPanelFragment.class);
    RIJXTabFrame.f(this.a).a(false);
    RIJChannelReporter.a("0X8009497", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().build());
  }
  
  public void c(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    RIJTabFrameDeliverPopupUtil.a((Frame)this.a, paramView, true);
    if (BaseApplicationImpl.sProcessId != 9) {
      ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess((Context)BaseApplicationImpl.getContext());
    }
    RIJFrameworkReportManager.a("1");
  }
  
  public void d(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    a();
    c();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initTopBar.1
 * JD-Core Version:    0.7.0.1
 */
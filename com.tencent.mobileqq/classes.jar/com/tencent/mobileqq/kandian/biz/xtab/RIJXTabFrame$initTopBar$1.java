package com.tencent.mobileqq.kandian.biz.xtab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.tab.RIJTabFrameDeliverPopupUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame$initTopBar$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar$OnBtnClickListener;", "onDeliverBtnClick", "", "view", "Landroid/view/View;", "onMoreChannelBtnClick", "onSearchBtnClick", "onSelfBtnClick", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "onTopicBtnClick", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$initTopBar$1
  implements RIJXTabBar.OnBtnClickListener
{
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    UniteSearchActivity.a((Activity)this.a.a(), null, 25);
    RIJChannelReporter.a("0X80067D3", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().build());
  }
  
  public void a(@NotNull RedTouch paramRedTouch)
  {
    Intrinsics.checkParameterIsNotNull(paramRedTouch, "view");
    boolean bool = RIJXTabFrame.a(this.a).a().c();
    RIJXTabFrame.a(this.a).a().d();
    paramRedTouch = (IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class);
    QBaseActivity localQBaseActivity = this.a.a();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "activity");
    paramRedTouch.launchReadInJoySelfActivity((Context)localQBaseActivity, bool);
    PublicTracker.a(null, "self_tab_cost");
    paramRedTouch = this.a.a().a();
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
    PublicTransFragmentActivity.b((Context)this.a.a(), paramView, RIJXTabChannelPanelFragment.class);
    RIJXTabFrame.a(this.a).a(false);
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
    paramView = Aladdin.getConfig(440);
    if (paramView != null) {
      paramView = paramView.getString("hashTag_jump_url", "");
    } else {
      paramView = null;
    }
    String str1 = URLDecoder.decode(paramView, "UTF-8");
    String str2 = this.a.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onTopicBtnClick], jumpUrl = ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(", decodeJumpUrl = ");
    localStringBuilder.append(str1);
    QLog.i(str2, 1, localStringBuilder.toString());
    RIJXTabReport.a(RIJXTabFrame.a(this.a).a(), "0X800BA08");
    RIJJumpUtils.a((Context)this.a.a(), str1);
    RIJXTabFrame.a(this.a).setTopicIconHasClicked();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame.initTopBar.1
 * JD-Core Version:    0.7.0.1
 */
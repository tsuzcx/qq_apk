package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyDailyOverScrollListener
  implements ReadInJoyOverScrollViewListener
{
  private Interpolator a = new AccelerateInterpolator();
  private float b = 0.0F;
  
  private ImageView a(ListView paramListView)
  {
    if ((paramListView != null) && (paramListView.getOverScrollFooterView() != null)) {
      return (ImageView)paramListView.getOverScrollFooterView().findViewById(2131436487);
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    return (String)RIJSPUtils.b("kandian_daily_wrapper_default_text", paramContext.getResources().getString(2131915314));
  }
  
  public static void a(int paramInt)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
    localReportR5Builder.addStringNotThrow("jump_src", DailyModeConfigHandler.e());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localReportR5Builder.addStringNotThrow("entrance", localStringBuilder.toString());
    localReportR5Builder.addStringNotThrow("cmd", ReadInJoyHelper.O());
    PublicAccountReportUtils.a(null, "", "0X8009883", "0X8009883", 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    List localList = ReadInJoyLogicEngine.a().c(Integer.valueOf(DailyModeConfigHandler.j()));
    if ((localList != null) && (!localList.isEmpty()))
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      InsertArticleInfo localInsertArticleInfo = new InsertArticleInfo();
      localInsertArticleInfo.a = ((Long)localList.get(localList.size() - 1)).longValue();
      localInsertArticleInfo.b = 13;
      localKandianMergeManager.a(localInsertArticleInfo);
    }
    paramActivity.finish();
    paramActivity.overridePendingTransition(2130772007, 2130772490);
    localBundle.putString("folder_status", KandianDailyReportUtils.e());
    localBundle.putBoolean("force_refresh", true);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(paramActivity, 13, 0, localBundle);
  }
  
  private void b(ListView paramListView)
  {
    paramListView = a(paramListView);
    if (paramListView == null) {
      return;
    }
    paramListView.setPivotX(paramListView.getWidth() / 2);
    paramListView.setPivotY(paramListView.getHeight() / 2);
    paramListView.setRotation(0.0F);
  }
  
  private void c(ListView paramListView)
  {
    if (ReadInJoyDailyViewController.m() == 1)
    {
      a((Activity)paramListView.getContext());
      a(1);
      return;
    }
    String str = DailyModeConfigHandler.c();
    if (!TextUtils.isEmpty(str))
    {
      ReadInJoyUtils.a(paramListView.getContext(), str);
      a(1);
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = new StringBuilder();
    paramView.append("[onNotCompleteVisable] ");
    paramView.append(paramInt);
    QLog.d("ReadInJoyDailyOverScrollListener", 2, paramView.toString());
    if (paramInt == 1) {
      b(paramListView);
    }
  }
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    paramView = new StringBuilder();
    paramView.append("[onNotCompleteVisable] ");
    paramView.append(paramInt1);
    QLog.d("ReadInJoyDailyOverScrollListener", 2, paramView.toString());
    if (paramInt1 == 1) {
      b(paramListView);
    }
  }
  
  public void onScrollView(View paramView, ListView paramListView, int paramInt)
  {
    float f1 = paramView.getHeight();
    double d1 = paramInt;
    Double.isNaN(d1);
    double d2 = f1;
    Double.isNaN(d2);
    float f2 = (float)(d1 * 1.0D / d2);
    f1 = f2;
    if (f2 >= 1.0D) {
      f1 = 1.0F;
    }
    this.b = f1;
    f1 = this.a.getInterpolation(f1);
    paramView = a(paramListView);
    if (paramView == null) {
      return;
    }
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setRotation(f1 * 180.0F);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisable] ");
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramView = new StringBuilder();
    paramView.append("[onViewCompleteVisableAndReleased] ");
    paramView.append(paramInt);
    QLog.d("ReadInJoyDailyOverScrollListener", 2, paramView.toString());
    if (paramInt == 1) {
      c(paramListView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramView = new StringBuilder();
    paramView.append("[onViewNotCompleteVisableAndReleased] ");
    paramView.append(paramInt);
    QLog.d("ReadInJoyDailyOverScrollListener", 2, paramView.toString());
    if (paramInt != 1) {
      return;
    }
    b(paramListView);
    if (this.b > DailyModeConfigHandler.b())
    {
      QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] ");
      c(paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyOverScrollListener
 * JD-Core Version:    0.7.0.1
 */
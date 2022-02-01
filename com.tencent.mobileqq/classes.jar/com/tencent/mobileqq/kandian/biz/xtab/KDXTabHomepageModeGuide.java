package com.tencent.mobileqq.kandian.biz.xtab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabHomepageModeGuide;", "Lcom/tencent/mobileqq/kandian/biz/xtab/IKDXTabHomepageModeGuide;", "()V", "clickListener", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/kandian/biz/xtab/OnGuideClickListener;", "popupView", "Landroid/view/View;", "dismiss", "parent", "Landroid/widget/FrameLayout;", "hide", "report", "wording", "", "actionName", "reportClick", "reportExposure", "resume", "setOnClickListener", "onClickListener", "show", "duration", "", "guideText", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabHomepageModeGuide
  implements IKDXTabHomepageModeGuide
{
  public static final KDXTabHomepageModeGuide.Companion a = new KDXTabHomepageModeGuide.Companion(null);
  private View b;
  private Function1<? super IKDXTabHomepageModeGuide, Unit> c;
  
  private final void a(String paramString)
  {
    a(paramString, "0X800BD29");
  }
  
  private final void a(String paramString1, String paramString2)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addStringNotThrow("uin", RIJQQAppInterfaceUtil.d());
    localReportR5Builder.addStringNotThrow("enter_page", "2");
    localReportR5Builder.addStringNotThrow("wording", paramString1);
    PublicAccountReportUtils.a(null, RIJQQAppInterfaceUtil.d(), paramString2, paramString2, 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
  
  private final void b(String paramString)
  {
    a(paramString, "0X800BD28");
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hide popupView:");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("KDXTabHomepageModeGuide", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void a(@NotNull FrameLayout paramFrameLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramFrameLayout, "parent");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dismiss popupView:");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("KDXTabHomepageModeGuide", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      paramFrameLayout.removeView((View)localObject);
      this.b = ((View)null);
    }
  }
  
  public void a(@NotNull FrameLayout paramFrameLayout, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFrameLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramString, "guideText");
    if (this.b != null)
    {
      QLog.w("KDXTabHomepageModeGuide", 1, "popup is already showing");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("show duration:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" guideText:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("KDXTabHomepageModeGuide", 1, ((StringBuilder)localObject1).toString());
    localObject1 = LayoutInflater.from(paramFrameLayout.getContext()).inflate(2131629136, (ViewGroup)paramFrameLayout, false);
    Object localObject2 = ((View)localObject1).findViewById(2131431322);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById<TextView>(R.id.content)");
    ((TextView)localObject2).setText((CharSequence)paramString);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new KDXTabHomepageModeGuide.show.1(this, paramString));
    this.b = ((View)localObject1);
    localObject2 = new FrameLayout.LayoutParams(-2, LayoutAttrsKt.getDp(58));
    ((FrameLayout.LayoutParams)localObject2).gravity = 51;
    ((FrameLayout.LayoutParams)localObject2).leftMargin = LayoutAttrsKt.getDp(14);
    ((FrameLayout.LayoutParams)localObject2).topMargin = LayoutAttrsKt.getDp(76);
    paramFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramFrameLayout.postDelayed((Runnable)new KDXTabHomepageModeGuide.show.2(this, paramFrameLayout), paramInt * 1000L);
    b(paramString);
  }
  
  public void a(@NotNull Function1<? super IKDXTabHomepageModeGuide, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onClickListener");
    this.c = paramFunction1;
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resume popupView:");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("KDXTabHomepageModeGuide", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.KDXTabHomepageModeGuide
 * JD-Core Version:    0.7.0.1
 */
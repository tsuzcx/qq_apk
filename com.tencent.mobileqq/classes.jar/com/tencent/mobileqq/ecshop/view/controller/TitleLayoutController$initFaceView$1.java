package com.tencent.mobileqq.ecshop.view.controller;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$initFaceView$1
  implements View.OnClickListener
{
  TitleLayoutController$initFaceView$1(TitleLayoutController paramTitleLayoutController, List paramList) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = TitleLayoutController.a(this.a);
    if (localObject != null) {
      ((BubbleController)localObject).b();
    }
    TitleLayoutController.a(this.a, this.b);
    localObject = TitleLayoutController.b(this.a).get("pvsrc");
    String str = "";
    if (localObject != null) {
      localObject = (String)TitleLayoutController.b(this.a).get("pvsrc");
    } else {
      localObject = "";
    }
    if (TitleLayoutController.b(this.a).get("ext10") != null) {
      str = (String)TitleLayoutController.b(this.a).get("ext10");
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i;
    if (TitleLayoutController.c(this.a).getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    ReportUtil.a("qgg_pnavigation_click", "", String.valueOf(l), String.valueOf(i), (String)localObject, str, "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.initFaceView.1
 * JD-Core Version:    0.7.0.1
 */
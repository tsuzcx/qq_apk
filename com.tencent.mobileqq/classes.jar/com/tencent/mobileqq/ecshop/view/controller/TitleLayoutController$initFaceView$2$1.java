package com.tencent.mobileqq.ecshop.view.controller;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.MenuConfBean;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$initFaceView$2$1
  implements View.OnClickListener
{
  TitleLayoutController$initFaceView$2$1(TitleLayoutController.initFaceView.2 param2, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = this.a.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((EcshopConfBean.MenuConfBean)((Iterator)localObject).next()).a = 0;
    }
    ReportUtil.a("qgg_orderbubble_click", "", String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", this.b, this.c, "");
    TitleLayoutController.c(this.a.this$0).setVisibility(8);
    JumpUtil.b((Context)this.a.this$0.c());
    localObject = TitleLayoutController.a(this.a.this$0);
    if (localObject != null) {
      ((BubbleController)localObject).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.initFaceView.2.1
 * JD-Core Version:    0.7.0.1
 */
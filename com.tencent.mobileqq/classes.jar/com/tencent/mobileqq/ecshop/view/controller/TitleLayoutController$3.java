package com.tencent.mobileqq.ecshop.view.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$3
  implements View.OnClickListener
{
  TitleLayoutController$3(TitleLayoutController paramTitleLayoutController) {}
  
  public final void onClick(View paramView)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest((Context)this.a.c(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", "3046055438");
    localActivityURIRequest.extra().putInt("source", 5);
    QRoute.startUri((URIRequest)localActivityURIRequest, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.3
 * JD-Core Version:    0.7.0.1
 */
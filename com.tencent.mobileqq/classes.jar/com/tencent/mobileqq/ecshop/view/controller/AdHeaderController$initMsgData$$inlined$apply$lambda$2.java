package com.tencent.mobileqq.ecshop.view.controller;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardController;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/ecshop/view/controller/AdHeaderController$initMsgData$adCardController$1$2"}, k=3, mv={1, 1, 16})
final class AdHeaderController$initMsgData$$inlined$apply$lambda$2
  implements View.OnClickListener
{
  AdHeaderController$initMsgData$$inlined$apply$lambda$2(AdCardController paramAdCardController, AdHeaderController paramAdHeaderController, AdCardModel paramAdCardModel, List paramList, IEcshopMessageApi paramIEcshopMessageApi) {}
  
  public final void onClick(View paramView)
  {
    new EcshopAdViewHelper().a(this.a.a().getContext(), this.c.h(), (View)this.a.a(), this.e.getSourceAd(this.c.h()), this.c.n());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdHeaderController.initMsgData..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/ecshop/view/controller/AdViewPagerController$initMsgData$adCardController$1$2"}, k=3, mv={1, 1, 16})
final class AdViewPagerController$initMsgData$$inlined$apply$lambda$2
  implements View.OnClickListener
{
  AdViewPagerController$initMsgData$$inlined$apply$lambda$2(AdCardController paramAdCardController, AdViewPagerController paramAdViewPagerController, AdCardModel paramAdCardModel, List paramList, IEcshopMessageApi paramIEcshopMessageApi) {}
  
  public final void onClick(View paramView)
  {
    EcshopAdViewHelper localEcshopAdViewHelper = new EcshopAdViewHelper();
    LinearLayout localLinearLayout = this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardController.a();
    Intrinsics.checkExpressionValueIsNotNull(localLinearLayout, "adCardAdSourceLayout");
    localEcshopAdViewHelper.a(localLinearLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.a(), (View)this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardController.a(), this.jdField_a_of_type_ComTencentMobileqqEcshopTempApiIEcshopMessageApi.getSourceAd(this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.a()), this.jdField_a_of_type_ComTencentMobileqqEcshopViewAdcardAdCardModel.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdViewPagerController.initMsgData..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */
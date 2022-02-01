package com.tencent.mobileqq.ecshop.view.adcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.app.AppRuntime;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AdCardController$1
  implements View.OnClickListener
{
  AdCardController$1(AdCardController paramAdCardController) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1;
    if (AdCardController.a(this.a).b())
    {
      localObject1 = (IEcshopService)AppUtils.a().getRuntimeService(IEcshopService.class, "");
      Object localObject2 = AdCardController.a(this.a).a();
      boolean bool = AdCardController.a(this.a).a();
      Context localContext = AdCardController.a(this.a).getContext();
      if (localContext != null)
      {
        ((IEcshopService)localObject1).enterGdtCanvasActivity((qq_ad_get.QQAdGetRsp.AdInfo)localObject2, "3046055438", bool, (Activity)localContext);
        localObject1 = (IEcshopReportApi)QRoute.api(IEcshopReportApi.class);
        localObject2 = AppUtils.a();
        if (localObject2 != null) {
          ((IEcshopReportApi)localObject1).doClickReport((BaseQQAppInterface)localObject2, AdCardController.a(this.a).a(), 1);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
    }
    else
    {
      localObject1 = new Intent(AdCardController.a(this.a).getContext(), QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", AdCardController.a(this.a).b());
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
      AdCardController.a(this.a).getContext().startActivity((Intent)localObject1);
    }
    AdCardController.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardController.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipGrayConfigHelper$3
  implements View.OnClickListener
{
  VipGrayConfigHelper$3(VipGrayConfigHelper paramVipGrayConfigHelper, URLImageView paramURLImageView, IGameCardManager.GameCardInfo paramGameCardInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject = VasUtil.a().getGameCardManager();
    ((IGameCardManager)localObject).gotoGameIconSetWeb(this.a.getContext(), this.b.b, this.b.e, this.b.f);
    if (((IGameCardManager)localObject).isSelf(this.b.b)) {
      localObject = "owner";
    } else {
      localObject = "visitor";
    }
    ((IMobileReportManager)QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(this.b.f), "4", "platform898", this.b.a, (String)localObject, 102, 1, System.currentTimeMillis());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipGrayConfigHelper.3
 * JD-Core Version:    0.7.0.1
 */
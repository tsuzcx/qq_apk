package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IPSiteListGoodsAdapter$1
  implements View.OnClickListener
{
  IPSiteListGoodsAdapter$1(IPSiteListGoodsAdapter paramIPSiteListGoodsAdapter, IPSiteModel.Goods paramGoods) {}
  
  public void onClick(View paramView)
  {
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(IPSiteListGoodsAdapter.access$100(this.this$0), this.val$goods.url, -1L, null, false, -1);
    VasWebviewUtil.a(IPSiteListGoodsAdapter.access$200(this.this$0), "IP", "aio_productclk", "", 0, 0, 0, IPSiteListGoodsAdapter.access$300(this.this$0), IPSiteListGoodsAdapter.access$400(this.this$0), "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPSiteListGoodsAdapter.1
 * JD-Core Version:    0.7.0.1
 */
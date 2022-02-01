package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BigEmotionDownloadedAdapter$7
  implements View.OnClickListener
{
  BigEmotionDownloadedAdapter$7(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter, IPSiteModel.Book paramBook, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openQQBrowserWithoutAD(this.this$0.mContext, this.val$book.jumpUrl, -1L, null, false, -1);
    VasWebviewUtil.a(this.this$0.app.getCurrentAccountUin(), "IP", "aio_bookclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.7
 * JD-Core Version:    0.7.0.1
 */
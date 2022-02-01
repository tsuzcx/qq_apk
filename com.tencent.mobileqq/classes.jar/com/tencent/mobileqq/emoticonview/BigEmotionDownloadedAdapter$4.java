package com.tencent.mobileqq.emoticonview;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BigEmotionDownloadedAdapter$4
  implements View.OnClickListener
{
  BigEmotionDownloadedAdapter$4(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter, IPSiteModel.Comic paramComic, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.mContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, this.val$comic.jumpUrl, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "IP", "aio_comicclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.4
 * JD-Core Version:    0.7.0.1
 */
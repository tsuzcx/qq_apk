package com.tencent.mobileqq.emoticonview;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BigEmotionDownloadedAdapter$6
  implements View.OnClickListener
{
  BigEmotionDownloadedAdapter$6(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter, IPSiteModel.Video paramVideo, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.this$0.mContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_operation_bar", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, this.val$video.redirectUrl, -1L, localIntent, false, -1);
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "IP", "aio_movieclk", "", 0, 0, 0, this.val$netStr, this.val$ipId, "", "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.6
 * JD-Core Version:    0.7.0.1
 */
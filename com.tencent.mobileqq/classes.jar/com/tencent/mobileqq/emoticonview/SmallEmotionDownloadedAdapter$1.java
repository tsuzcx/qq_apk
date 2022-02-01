package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SmallEmotionDownloadedAdapter$1
  implements View.OnClickListener
{
  SmallEmotionDownloadedAdapter$1(SmallEmotionDownloadedAdapter paramSmallEmotionDownloadedAdapter, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if (this.this$0.app == null) {
      str1 = "";
    } else {
      str1 = this.this$0.app.getCurrentAccountUin();
    }
    String str3 = this.this$0.emotionPkg.epId;
    String str2;
    if (this.val$hasRecommendDressup) {
      str2 = "1";
    } else {
      str2 = "2";
    }
    VasWebviewUtil.a(str1, "ep_mall", "0X8007192", null, 1, 0, 0, null, str3, str2);
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.this$0.mContext, this.this$0.app, this.this$0.app.getAccount(), 0, String.valueOf(this.this$0.emotionPkg.epId), false, null, true, this.val$hasRecommendDressup, this.this$0.emotionPkg.extraFlags, this.this$0.emotionPkg.epId);
    ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.this$0.emotionPkg.epId, "2", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter.1
 * JD-Core Version:    0.7.0.1
 */
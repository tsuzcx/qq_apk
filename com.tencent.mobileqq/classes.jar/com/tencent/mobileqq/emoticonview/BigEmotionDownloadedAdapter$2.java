package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class BigEmotionDownloadedAdapter$2
  implements View.OnClickListener
{
  BigEmotionDownloadedAdapter$2(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.this$0.mContext, this.this$0.app, this.this$0.app.getAccount(), 0, String.valueOf(this.this$0.emotionPkg.epId), false, null, false, this.val$finalHasRecommendDressup, this.this$0.emotionPkg.extraFlags, this.this$0.emotionPkg.epId);
    if (this.this$0.app.getCurrentAccountUin() == null) {
      localObject1 = "";
    } else {
      localObject1 = this.this$0.app.getCurrentAccountUin();
    }
    Object localObject2 = this.this$0.emotionPkg.epId;
    if (this.val$finalHasRecommendDressup) {
      str = "1";
    } else {
      str = "2";
    }
    VasWebviewUtil.a((String)localObject1, "ep_mall", "0X8007192", null, 1, 0, 0, null, (String)localObject2, str);
    int j = this.this$0.emotionPkg.extraFlags;
    int i = 1;
    if ((j & 0x1) > 0) {
      i = 3;
    } else if (this.this$0.emotionPkg.subType == 4) {
      i = 4;
    }
    Object localObject1 = this.this$0.app.getQQAppInterface();
    String str = this.this$0.emotionPkg.epId;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("");
    ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", str, ((StringBuilder)localObject2).toString(), "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.2
 * JD-Core Version:    0.7.0.1
 */
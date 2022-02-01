package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class BigEmotionDownloadedAdapter$2
  implements View.OnClickListener
{
  BigEmotionDownloadedAdapter$2(BigEmotionDownloadedAdapter paramBigEmotionDownloadedAdapter, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).openEmojiDetailPage(this.this$0.mContext, this.this$0.app, this.this$0.app.getAccount(), 0, String.valueOf(this.this$0.emotionPkg.epId), false, null, false, this.val$hasRecommendDressup, this.this$0.emotionPkg.extraFlags, this.this$0.emotionPkg.epId);
    IBigEmotionService localIBigEmotionService = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
    Object localObject;
    String str1;
    label141:
    int i;
    if ((this.this$0.app == null) || (this.this$0.app.getCurrentAccountUin() == null))
    {
      localObject = "";
      String str2 = this.this$0.emotionPkg.epId;
      if (!this.val$hasRecommendDressup) {
        break label264;
      }
      str1 = "1";
      localIBigEmotionService.reportCommercialDrainage((String)localObject, "ep_mall", "0X8007192", null, 1, 0, 0, null, str2, str1);
      if ((this.this$0.emotionPkg.extraFlags & 0x1) <= 0) {
        break label271;
      }
      i = 3;
    }
    for (;;)
    {
      label179:
      if (this.this$0.app == null) {}
      for (localObject = null;; localObject = this.this$0.app.getQQAppInterface())
      {
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "ep_mall", "0X8007192", 0, 0, "", this.this$0.emotionPkg.epId, i + "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = this.this$0.app.getCurrentAccountUin();
        break;
        label264:
        str1 = "2";
        break label141;
        label271:
        if (this.this$0.emotionPkg.subType != 4) {
          break label306;
        }
        i = 4;
        break label179;
      }
      label306:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BigEmotionDownloadedAdapter.2
 * JD-Core Version:    0.7.0.1
 */
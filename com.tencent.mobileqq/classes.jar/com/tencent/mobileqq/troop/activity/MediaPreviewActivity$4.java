package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class MediaPreviewActivity$4
  implements Runnable
{
  MediaPreviewActivity$4(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.app != null)
    {
      int j = ((INearbyCardManager)this.this$0.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).b();
      int i;
      if ((this.this$0.b > 0) && (((MediaPreviewInfo)this.this$0.a.get(0)).a == 2)) {
        i = 1;
      } else {
        i = 0;
      }
      IFaceScoreUtils localIFaceScoreUtils = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      String str2 = "1";
      String str1;
      if (j == 0) {
        str1 = "1";
      } else {
        str1 = "2";
      }
      if (i != 0) {
        str2 = "2";
      }
      localIFaceScoreUtils.report("clk_detail", "", new String[] { "", str1, "", str2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */
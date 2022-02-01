package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;

class ReadInJoyBaseDeliverActivity$9
  implements PublicAccountGifListener
{
  ReadInJoyBaseDeliverActivity$9(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(HotPicData paramHotPicData)
  {
    ReadInJoyBaseDeliverActivity localReadInJoyBaseDeliverActivity = this.a;
    if ((localReadInJoyBaseDeliverActivity instanceof ReadInJoyDeliverUGCActivity)) {
      ((ReadInJoyDeliverUGCActivity)localReadInJoyBaseDeliverActivity).a(paramHotPicData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.9
 * JD-Core Version:    0.7.0.1
 */
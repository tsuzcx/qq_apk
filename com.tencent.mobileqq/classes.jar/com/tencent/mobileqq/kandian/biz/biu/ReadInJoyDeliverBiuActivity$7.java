package com.tencent.mobileqq.kandian.biz.biu;

import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import java.util.ArrayList;

class ReadInJoyDeliverBiuActivity$7
  extends IPublicAccountObserver.OnCallback
{
  public void onGetGuideFriends(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    if (paramBoolean) {
      ReadInJoyDeliverBiuActivity.a(this.a, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.7
 * JD-Core Version:    0.7.0.1
 */
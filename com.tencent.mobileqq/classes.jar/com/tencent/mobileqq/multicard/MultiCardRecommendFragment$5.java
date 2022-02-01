package com.tencent.mobileqq.multicard;

import android.os.Message;
import mqq.os.MqqHandler;

class MultiCardRecommendFragment$5
  extends MqqHandler
{
  MultiCardRecommendFragment$5(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      MultiCardRecommendFragment.e(this.a);
      sendEmptyMessageDelayed(3, 500L);
      return;
      MultiCardRecommendFragment.a(this.a, MultiCardRecommendFragment.b(this.a));
      MultiCardRecommendFragment.e(this.a);
      return;
      MultiCardRecommendFragment.d(this.a);
      return;
    } while (MultiCardRecommendFragment.a(this.a) == null);
    MultiCardRecommendFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.5
 * JD-Core Version:    0.7.0.1
 */
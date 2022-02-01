package com.tencent.mobileqq.multicard;

import android.os.Message;
import mqq.os.MqqHandler;

class MultiCardRecommendFragment$5
  extends MqqHandler
{
  MultiCardRecommendFragment$5(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (MultiCardRecommendFragment.a(this.a) != null) {
            MultiCardRecommendFragment.a(this.a).notifyDataSetChanged();
          }
        }
        else
        {
          MultiCardRecommendFragment.e(this.a);
        }
      }
      else
      {
        paramMessage = this.a;
        MultiCardRecommendFragment.a(paramMessage, MultiCardRecommendFragment.h(paramMessage));
        MultiCardRecommendFragment.g(this.a);
      }
    }
    else
    {
      MultiCardRecommendFragment.g(this.a);
      sendEmptyMessageDelayed(3, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.5
 * JD-Core Version:    0.7.0.1
 */
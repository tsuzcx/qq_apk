package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ChannelCoverView$4
  implements View.OnTouchListener
{
  ChannelCoverView$4(ChannelCoverView paramChannelCoverView, Context paramContext) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = this.a;
      int i;
      if ((paramView != null) && ((paramView instanceof Activity)) && (((Activity)paramView).getIntent() != null)) {
        i = ((Activity)this.a).getIntent().getIntExtra("channel_from", -1);
      } else {
        i = 0;
      }
      ChannelCoverView.a("0X8007BE7", null, null, null, null, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView.4
 * JD-Core Version:    0.7.0.1
 */
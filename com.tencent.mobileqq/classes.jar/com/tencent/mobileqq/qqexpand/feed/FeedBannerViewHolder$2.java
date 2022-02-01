package com.tencent.mobileqq.qqexpand.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.TextView;

class FeedBannerViewHolder$2
  implements View.OnTouchListener
{
  FeedBannerViewHolder$2(FeedBannerViewHolder paramFeedBannerViewHolder, View paramView, FrameLayout paramFrameLayout, TextView paramTextView1, TextView paramTextView2, FeedBannerTabItem paramFeedBannerTabItem, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        this.a.setVisibility(4);
        this.b.setAlpha(1.0F);
        this.c.setAlpha(1.0F);
        this.d.setAlpha(1.0F);
        return true;
      }
      this.a.setVisibility(4);
      this.b.setAlpha(1.0F);
      this.c.setAlpha(1.0F);
      this.d.setAlpha(1.0F);
      FeedBannerViewHolder.a(this.g, this.e, this.f);
      return true;
    }
    this.a.setVisibility(0);
    this.b.setAlpha(0.5F);
    this.c.setAlpha(0.5F);
    this.d.setAlpha(0.5F);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FeedBannerViewHolder.2
 * JD-Core Version:    0.7.0.1
 */
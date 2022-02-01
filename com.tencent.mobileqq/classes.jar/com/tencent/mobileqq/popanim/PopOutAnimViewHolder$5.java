package com.tencent.mobileqq.popanim;

import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PopOutAnimViewHolder$5
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  PopOutAnimViewHolder$5(PopOutAnimViewHolder paramPopOutAnimViewHolder) {}
  
  public void a()
  {
    PopOutAnimViewHolder localPopOutAnimViewHolder = this.a;
    PopOutAnimViewHolder.a(localPopOutAnimViewHolder, PopOutAnimViewHolder.b(localPopOutAnimViewHolder));
  }
  
  public void a(int paramInt)
  {
    PopOutAnimViewHolder localPopOutAnimViewHolder = this.a;
    PopOutAnimViewHolder.a(localPopOutAnimViewHolder, PopOutAnimViewHolder.b(localPopOutAnimViewHolder), paramInt);
    ThreadManager.getUIHandler().post(new PopOutAnimViewHolder.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutAnimViewHolder.5
 * JD-Core Version:    0.7.0.1
 */
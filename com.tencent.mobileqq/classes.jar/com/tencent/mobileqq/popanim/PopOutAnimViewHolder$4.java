package com.tencent.mobileqq.popanim;

import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PopOutAnimViewHolder$4
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  PopOutAnimViewHolder$4(PopOutAnimViewHolder paramPopOutAnimViewHolder) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopOutAnimViewHolder", 2, "onViewDetached");
    }
    PopOutAnimViewHolder localPopOutAnimViewHolder = this.a;
    PopOutAnimViewHolder.a(localPopOutAnimViewHolder, PopOutAnimViewHolder.a(localPopOutAnimViewHolder));
  }
  
  public void a(int paramInt)
  {
    PopOutAnimViewHelper.a("0X800BBA4", 2, String.valueOf(paramInt));
    PopOutAnimViewHolder localPopOutAnimViewHolder = this.a;
    PopOutAnimViewHolder.a(localPopOutAnimViewHolder, PopOutAnimViewHolder.a(localPopOutAnimViewHolder), paramInt);
    ThreadManager.getUIHandler().post(new PopOutAnimViewHolder.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutAnimViewHolder.4
 * JD-Core Version:    0.7.0.1
 */
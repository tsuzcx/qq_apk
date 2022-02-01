package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

class FeedItemCellTypeSmallSocial$3
  implements View.OnTouchListener
{
  FeedItemCellTypeSmallSocial$3(FeedItemCellTypeSmallSocial paramFeedItemCellTypeSmallSocial, RelativeLayout paramRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.setDuplicateParentStateEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeSmallSocial.3
 * JD-Core Version:    0.7.0.1
 */
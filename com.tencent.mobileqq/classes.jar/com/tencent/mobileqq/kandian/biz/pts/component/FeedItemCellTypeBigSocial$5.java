package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

class FeedItemCellTypeBigSocial$5
  implements View.OnTouchListener
{
  FeedItemCellTypeBigSocial$5(FeedItemCellTypeBigSocial paramFeedItemCellTypeBigSocial, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.setDuplicateParentStateEnabled(true);
      this.b.setDuplicateParentStateEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeBigSocial.5
 * JD-Core Version:    0.7.0.1
 */
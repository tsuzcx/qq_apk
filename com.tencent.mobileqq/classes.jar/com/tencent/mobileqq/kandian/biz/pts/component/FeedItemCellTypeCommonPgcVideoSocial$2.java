package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

class FeedItemCellTypeCommonPgcVideoSocial$2
  implements View.OnTouchListener
{
  FeedItemCellTypeCommonPgcVideoSocial$2(FeedItemCellTypeCommonPgcVideoSocial paramFeedItemCellTypeCommonPgcVideoSocial, LinearLayout paramLinearLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.setDuplicateParentStateEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeCommonPgcVideoSocial.2
 * JD-Core Version:    0.7.0.1
 */
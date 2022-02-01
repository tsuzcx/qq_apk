package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

class FeedItemCellTypeGalleryBiu$5
  implements View.OnTouchListener
{
  FeedItemCellTypeGalleryBiu$5(FeedItemCellTypeGalleryBiu paramFeedItemCellTypeGalleryBiu, LinearLayout paramLinearLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setDuplicateParentStateEnabled(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeGalleryBiu.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.comment.adapt;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class BaseBottomSheetDialogFragment$WindowTouchListener
  implements View.OnTouchListener
{
  private BaseBottomSheetDialogFragment$WindowTouchListener(BaseBottomSheetDialogFragment paramBaseBottomSheetDialogFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.this$0.dismiss();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment.WindowTouchListener
 * JD-Core Version:    0.7.0.1
 */
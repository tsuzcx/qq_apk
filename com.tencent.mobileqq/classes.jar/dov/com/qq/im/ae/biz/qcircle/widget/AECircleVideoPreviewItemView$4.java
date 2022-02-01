package dov.com.qq.im.ae.biz.qcircle.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class AECircleVideoPreviewItemView$4
  implements View.OnTouchListener
{
  AECircleVideoPreviewItemView$4(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView.4
 * JD-Core Version:    0.7.0.1
 */
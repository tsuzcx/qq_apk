package com.tencent.mobileqq.wink.pick.circle.part;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class WinkCirclePreviewPart$1
  implements RecyclerView.OnItemTouchListener
{
  WinkCirclePreviewPart$1(WinkCirclePreviewPart paramWinkCirclePreviewPart) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      WinkCirclePreviewPart.a(this.a, paramMotionEvent.getY());
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      float f = paramMotionEvent.getY();
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append(WinkCirclePreviewPart.a(this.a));
      paramRecyclerView.append(" ");
      paramRecyclerView.append(f);
      QLog.d("WinkCirclePreviewPart", 4, paramRecyclerView.toString());
      if (Math.abs(f - WinkCirclePreviewPart.a(this.a)) > 600.0F)
      {
        WinkCirclePreviewPart.b(this.a);
        return true;
      }
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePreviewPart.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class GroupVideoFilterList$1
  implements GLGestureListener
{
  GroupVideoFilterList$1(GroupVideoFilterList paramGroupVideoFilterList) {}
  
  public int onGetPriority()
  {
    return 1031;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if (i > 2) {}
    do
    {
      do
      {
        return false;
        float f;
        if ((i == 2) && (paramBoolean))
        {
          f = GLGestureProxy.getInstance().getScreenCoordinateX(paramMotionEvent.getX(1));
          GLGestureProxy.getInstance().getScreenCoordinateY(paramMotionEvent.getY(1));
        }
        while (f > 100.0F) {
          switch (j & 0xFF)
          {
          case 2: 
          case 3: 
          case 4: 
          default: 
            return false;
          case 0: 
            GroupVideoFilterList.access$002(this.this$0, false);
            return false;
            f = paramMotionEvent.getX();
            paramMotionEvent.getY();
          }
        }
        GroupVideoFilterList.access$002(this.this$0, true);
        return false;
      } while ((i != 2) || (!paramBoolean));
      GroupVideoFilterList.access$102(this.this$0, true);
      GroupVideoFilterList.access$002(this.this$0, false);
      return false;
    } while (!GroupVideoFilterList.access$100(this.this$0));
    if ((i == 2) && (paramBoolean)) {
      GroupVideoFilterList.access$002(this.this$0, true);
    }
    GroupVideoFilterList.access$102(this.this$0, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList.1
 * JD-Core Version:    0.7.0.1
 */
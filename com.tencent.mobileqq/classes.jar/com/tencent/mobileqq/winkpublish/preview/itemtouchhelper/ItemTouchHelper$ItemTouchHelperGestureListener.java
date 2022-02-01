package com.tencent.mobileqq.winkpublish.preview.itemtouchhelper;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

class ItemTouchHelper$ItemTouchHelperGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a.a(paramMotionEvent);
    if (localObject != null)
    {
      localObject = this.a.p.getChildViewHolder((View)localObject);
      if (localObject != null)
      {
        if (!this.a.l.d(this.a.p, (RecyclerView.ViewHolder)localObject)) {
          return;
        }
        if (paramMotionEvent.getPointerId(0) == this.a.k)
        {
          int i = paramMotionEvent.findPointerIndex(this.a.k);
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          paramMotionEvent = this.a;
          paramMotionEvent.c = f1;
          paramMotionEvent.d = f2;
          paramMotionEvent.h = 0.0F;
          paramMotionEvent.g = 0.0F;
          if (paramMotionEvent.l.a()) {
            this.a.a((RecyclerView.ViewHolder)localObject, 2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.preview.itemtouchhelper.ItemTouchHelper.ItemTouchHelperGestureListener
 * JD-Core Version:    0.7.0.1
 */
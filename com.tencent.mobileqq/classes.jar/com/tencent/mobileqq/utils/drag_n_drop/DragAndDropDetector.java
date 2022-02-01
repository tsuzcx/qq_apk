package com.tencent.mobileqq.utils.drag_n_drop;

import android.view.MotionEvent;

public class DragAndDropDetector
{
  protected DragAndDropDetector.DragSource a;
  protected DragAndDropDetector.DropTarget b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected boolean f = true;
  protected float g;
  protected float h;
  private DragAndDropDetector.Draggable i;
  
  public DragAndDropDetector(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.DropTarget paramDropTarget, boolean paramBoolean)
  {
    if ((paramDragSource != null) && (paramDropTarget != null))
    {
      this.a = paramDragSource;
      this.b = paramDropTarget;
      return;
    }
    throw new IllegalArgumentException("DragSource and DropTarget shouldn't be null!");
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.g = paramFloat1;
    this.h = paramFloat2;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f2;
    float f1;
    if (this.c)
    {
      f2 = paramMotionEvent.getRawX();
      f1 = paramMotionEvent.getRawY();
    }
    else
    {
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
    }
    f2 += this.g;
    f1 += this.h;
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
        }
        else
        {
          if (!this.d) {
            break label419;
          }
          this.a.onMove(this.i, f2, f1);
          this.i.b(this.a, f2, f1);
          if (this.f)
          {
            if (this.b.a(f2, f1))
            {
              if (!this.e)
              {
                this.e = true;
                this.f = this.b.b(this.a, this.i, f2, f1);
              }
              this.b.d(this.a, this.i, f2, f1);
              return true;
            }
            if (this.e)
            {
              this.e = false;
              this.b.c(this.a, this.i, f2, f1);
            }
          }
          return true;
        }
      }
      if (this.d)
      {
        if ((this.b.a(f2, f1)) && (this.b.a(this.a, this.i, f2, f1)))
        {
          this.a.onDrop(this.b, this.i, f2, f1);
          this.i.a(this.a, this.b, f2, f1);
        }
        else
        {
          this.a.onDrop(null, this.i, f2, f1);
          this.i.a(this.a, null, f2, f1);
        }
        this.d = false;
        this.e = false;
        this.f = true;
        return true;
      }
    }
    else
    {
      this.i = this.a.findDraggableByPos(f2, f1);
      paramMotionEvent = this.i;
      if (paramMotionEvent != null)
      {
        if ((this.a.onDrag(paramMotionEvent, f2, f1)) && (this.i.a(this.a, f2, f1))) {
          this.d = true;
        }
        return true;
      }
    }
    label419:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.utils.drag_n_drop;

import android.view.MotionEvent;

public class DragAndDropDetector
{
  protected float a;
  protected DragAndDropDetector.DragSource a;
  private DragAndDropDetector.Draggable a;
  protected DragAndDropDetector.DropTarget a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public DragAndDropDetector(DragAndDropDetector.DragSource paramDragSource, DragAndDropDetector.DropTarget paramDropTarget, boolean paramBoolean)
  {
    if ((paramDragSource != null) && (paramDropTarget != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource = paramDragSource;
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget = paramDropTarget;
      return;
    }
    throw new IllegalArgumentException("DragSource and DropTarget shouldn't be null!");
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f2;
    float f1;
    if (this.jdField_a_of_type_Boolean)
    {
      f2 = paramMotionEvent.getRawX();
      f1 = paramMotionEvent.getRawY();
    }
    else
    {
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
    }
    f2 += this.jdField_a_of_type_Float;
    f1 += this.jdField_b_of_type_Float;
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label419;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onMove(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, f2, f1);
          if (this.d)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(f2, f1))
            {
              if (!this.c)
              {
                this.c = true;
                this.d = this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.b(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
              }
              this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.b(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
              return true;
            }
            if (this.c)
            {
              this.c = false;
              this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
            }
          }
          return true;
        }
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(f2, f1)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1)))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onDrop(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget, f2, f1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onDrop(null, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, null, f2, f1);
        }
        this.jdField_b_of_type_Boolean = false;
        this.c = false;
        this.d = true;
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable = this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.findDraggableByPos(f2, f1);
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable;
      if (paramMotionEvent != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onDrag(paramMotionEvent, f2, f1)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      }
    }
    label419:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector
 * JD-Core Version:    0.7.0.1
 */
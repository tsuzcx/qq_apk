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
      f2 += this.jdField_a_of_type_Float;
      f1 += this.jdField_b_of_type_Float;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    label258:
    do
    {
      do
      {
        do
        {
          return false;
          f2 = paramMotionEvent.getX();
          f1 = paramMotionEvent.getY();
          break;
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable = this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.findDraggableByPos(f2, f1);
        } while (this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable == null);
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onDrag(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onMove(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.b(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.b(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(f2, f1)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onDrop(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DropTarget, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource.onDrop(null, this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable, f2, f1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$Draggable.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector$DragSource, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector
 * JD-Core Version:    0.7.0.1
 */
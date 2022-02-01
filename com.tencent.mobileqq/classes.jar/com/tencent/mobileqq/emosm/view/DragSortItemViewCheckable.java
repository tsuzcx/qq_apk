package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;

public class DragSortItemViewCheckable
  extends DragSortItemView
  implements Checkable
{
  public DragSortItemViewCheckable(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean isChecked()
  {
    boolean bool = false;
    View localView = super.getChildAt(0);
    if ((localView instanceof Checkable)) {
      bool = ((Checkable)localView).isChecked();
    }
    return bool;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    View localView = super.getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).setChecked(paramBoolean);
    }
  }
  
  public void toggle()
  {
    View localView = super.getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).toggle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortItemViewCheckable
 * JD-Core Version:    0.7.0.1
 */
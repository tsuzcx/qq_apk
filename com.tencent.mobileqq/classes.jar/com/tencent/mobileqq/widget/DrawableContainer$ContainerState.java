package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class DrawableContainer$ContainerState
  extends Drawable.ConstantState
{
  public int a;
  public Drawable a;
  private boolean a;
  private boolean b;
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() == null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      this.jdField_a_of_type_Boolean = true;
      return this.b;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawableContainer.ContainerState
 * JD-Core Version:    0.7.0.1
 */
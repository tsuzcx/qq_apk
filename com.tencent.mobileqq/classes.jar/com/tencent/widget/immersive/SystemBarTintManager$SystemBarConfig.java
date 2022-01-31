package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Window;

public class SystemBarTintManager$SystemBarConfig
{
  private final int jdField_a_of_type_Int;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  
  private SystemBarTintManager$SystemBarConfig(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
    for (;;)
    {
      this.b = bool;
      this.jdField_a_of_type_Int = ImmersiveUtils.a(paramWindow.getContext());
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.immersive.SystemBarTintManager.SystemBarConfig
 * JD-Core Version:    0.7.0.1
 */